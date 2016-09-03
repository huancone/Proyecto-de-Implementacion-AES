using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using B2CTouresBalon.DAL.Security;
using B2CTouresBalon.Models;
using B2CTouresBalon.ServiceProxyB2C;
using Enyim.Caching;
using Enyim.Caching.Memcached;
using Newtonsoft.Json;
using Item = B2CTouresBalon.Models.Item;

namespace B2CTouresBalon.Controllers
{
    public class ShoppingCartController : Controller
    {
        // GET: ShoppingCart
        public ActionResult Index()
        {
            using (var client = new MemcachedClient())
            {
                var currentUser = System.Web.HttpContext.Current.User as CustomPrincipal;
                var model = new Cart();
                model = client.Get<Cart>(currentUser.CustId.ToString(CultureInfo.InvariantCulture));
                return View();
            }
        }

        public ActionResult OrderNow(int id, int cantidad)
        {
            if (!ModelState.IsValid) return View("Index");

            //consulto el usuario logueado
            var currentUser = System.Web.HttpContext.Current.User as CustomPrincipal;
            if (currentUser == null) return View("Index");

            //creo un carrito vacio
            var cart = new Cart();
            cart.UserId = (int)currentUser.CustId;
            cart.Items = new List<Item>();


            using (var client = new MemcachedClient())
            {
                //consulto el cache del usuario logueado
                var userCache = client.Get<string>(currentUser.UserName);
                
                if (null == userCache)//si el carrito es vacio cree uno nuevo
                {
                    var proxyProductos = new ServiceProxyB2CClient();
                    var item = new Item
                    {
                        Producto = proxyProductos.ConsultarProducto(TipoConsultaProducto.Id, id.ToString(), null, null).First(),
                        Cantidad = cantidad
                    };
                    cart.Items.Add(item);


                    //serializar
                    var serializedCart = JsonConvert.SerializeObject(cart);
                    //guardo el nuevo carrito en memcached
                    client.Store(StoreMode.Set, currentUser.UserName, serializedCart);
                    var temp = client.Get<string>(currentUser.UserName);
                    var i = 0;
                }
                else
                {
                    //deserializar
                    var userCart = JsonConvert.DeserializeObject<Cart>(userCache);
                    var found = false;
                    foreach (var i in cart.Items.Where(i => i.Producto.id_producto == id))
                    {
                        i.Cantidad = i.Cantidad + cantidad;
                        found = true;
                    }
                    if (found) return View("cart");
                    var proxyProductos = new ServiceProxyB2CClient();
                    var item = new Item
                    {
                        Producto = proxyProductos.ConsultarProducto(TipoConsultaProducto.Id, id.ToString(), null, null).First(),
                        Cantidad = cantidad
                    };
                    cart.Items.Add(item);
                }
            }
            return View("cart", cart);
        }
    }
}