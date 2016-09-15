using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Net;
using System.Web.Mvc;
using B2CTouresBalon.DAL.Security;
using B2CTouresBalon.Models;
using B2CTouresBalon.ServiceProxyB2C;
using Enyim.Caching;
using Enyim.Caching.Configuration;
using Enyim.Caching.Memcached;
using Item = B2CTouresBalon.Models.Item;

namespace B2CTouresBalon.Controllers
{
    public class ShoppingCartController : Controller
    {
        // GET: AddItem
        public ActionResult Index()
        {
            using (var client = new MemcachedClient())
            {
                if (!ModelState.IsValid) return RedirectToAction("Index", "Product");
                var currentUser = System.Web.HttpContext.Current.User as CustomPrincipal;
                if (currentUser == null) return RedirectToAction("Index", "Account");
                var model = client.Get<Cart>("Cart-" + currentUser.CustId.ToString(CultureInfo.InvariantCulture));
                if (model == null) return RedirectToAction("Index", "Product");
                return View(model);
            }
        }

        public ActionResult AddItem(int idProducto, int cantidad)
        {
            if (!ModelState.IsValid) return View("Index");

            //consulto el usuario logueado
            var currentUser = System.Web.HttpContext.Current.User as CustomPrincipal;
            if (currentUser == null) return RedirectToAction("Index", "Account");

            var clientConfiguration = new MemcachedClientConfiguration { Protocol = MemcachedProtocol.Binary };
            clientConfiguration.Servers.Add(new IPEndPoint(IPAddress.Parse("127.0.0.1"), 32768));

            using (var client = new MemcachedClient(clientConfiguration))
            {
                //consulto el cache del usuario logueado
                var cart = client.Get<Cart>("Cart-" + currentUser.UserName);

                var proxy = new ServiceProxyB2CClient();
                //var producto = proxy.ConsultarProducto(TipoConsultaProducto.ID, idProducto.ToString(), null, null).First();
                
                //No se porque el servicio de productos no devuelve datos.
                var producto = proxy.ConsultarCampaniaProducto().First();
                
                if (null == cart)
                {
                    //si el carrito es vacio cree uno nuevo
                    cart = new Cart
                    {
                        UserId = (int)currentUser.CustId,
                        Items = new List<Item>()
                    };

                    var item = new Item
                    {
                        Producto = producto,
                        Cantidad = cantidad
                    };
                    cart.Items.Add(item);

                    client.Store(StoreMode.Set, "Cart-" + currentUser.UserName, cart);
                }
                else
                {
                    foreach (var i in cart.Items.Where(i => i.Producto.id_producto == idProducto))
                    {
                        //Si existe un carrito busco el item y adiciono la cantidad
                        i.Cantidad = i.Cantidad + cantidad;
                        client.Store(StoreMode.Set, "Cart-" + currentUser.UserName, cart);
                        return View("cart", cart);
                    }

                    //si no existe el item en el carrito lo agrego a la coleccion y guardo el carro
                    var item = new Item
                    {
                        Producto = producto,
                        Cantidad = cantidad
                    };
                    cart.Items.Add(item);
                    client.Store(StoreMode.Set, "Cart-" + currentUser.UserName, cart);
                }
                return View("Cart", cart);
            }
        }

        public ActionResult DeleteItem(int idProducto, int cantidad)
        {
            if (!ModelState.IsValid) return View("Index");

            //consulto el usuario logueado
            var currentUser = System.Web.HttpContext.Current.User as CustomPrincipal;
            if (currentUser == null) return RedirectToAction("Index", "Account");


            //Configuracion del MEMCACHED client
            var clientConfiguration = new MemcachedClientConfiguration { Protocol = MemcachedProtocol.Binary };
            clientConfiguration.Servers.Add(new IPEndPoint(IPAddress.Parse("127.0.0.1"), 32768));

            using (var client = new MemcachedClient(clientConfiguration))
            {
                //consulto el cache del usuario logueado
                var cart = client.Get<Cart>("Cart-" + currentUser.UserName);
                if (cart == null) return View("Cart", cart);

                //Consulto el item en el carrito y le resto al cantidad si llega a cero lo elimino.
                foreach (var i in cart.Items.Where(i => i.Producto.id_producto == idProducto))
                {
                    if (i.Cantidad >= cantidad)
                    {
                        i.Cantidad = i.Cantidad - cantidad;
                    }
                    else
                    {
                        cart.Items.Remove(i);
                    }   
                    client.Store(StoreMode.Set, "Cart-" + currentUser.UserName, cart);
                    return View("cart", cart);
                }
                return View("Cart", cart);
            }
        }
    }
}