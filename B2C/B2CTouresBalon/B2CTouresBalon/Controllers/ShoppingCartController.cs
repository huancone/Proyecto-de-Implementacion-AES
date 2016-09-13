using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Net;
using System.Web.Mvc;
using B2CTouresBalon.DAL.Security;
using B2CTouresBalon.Models;
using Enyim.Caching;
using Enyim.Caching.Configuration;
using Enyim.Caching.Memcached;

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
                if (currentUser == null) return RedirectToAction("Index","Account");
                var model = client.Get<Cart>(currentUser.CustId.ToString(CultureInfo.InvariantCulture));
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

            var clientConfiguration = new MemcachedClientConfiguration {Protocol = MemcachedProtocol.Binary};
            clientConfiguration.Servers.Add( new IPEndPoint(IPAddress.Parse("127.0.0.1"), 32768));

            using (var client = new MemcachedClient(clientConfiguration))
            {
                //consulto el cache del usuario logueado
                var cart = client.Get<Cart>(currentUser.UserName);
                
                if (null == cart)//si el carrito es vacio cree uno nuevo
                {
                    cart = new Cart
                    {
                        UserId = (int)currentUser.CustId,
                        Items = new List<Item>()
                    };

                    var item = new Item
                    {
                        Producto = idProducto,
                        Cantidad = cantidad
                    };
                    cart.Items.Add(item);

                    client.Store(StoreMode.Set, currentUser.UserName, cart);
                }
                else
                {
                    foreach (var i in cart.Items.Where(i => i.Producto == idProducto))
                    {
                        i.Cantidad = i.Cantidad + cantidad;
                        client.Store(StoreMode.Set, currentUser.UserName, cart);
                        return View("cart", cart);
                    }
                    var item = new Item
                    {
                        Producto = idProducto,
                        Cantidad = cantidad
                    };
                    cart.Items.Add(item);
                    client.Store(StoreMode.Set, currentUser.UserName, cart);
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
            var clientConfiguration = new MemcachedClientConfiguration { Protocol = MemcachedProtocol.Binary };
            clientConfiguration.Servers.Add(new IPEndPoint(IPAddress.Parse("127.0.0.1"), 32768));

            using (var client = new MemcachedClient(clientConfiguration))
            {
                //consulto el cache del usuario logueado
                var cart = client.Get<Cart>(currentUser.UserName);
                if (cart == null) return View("Cart", cart);
                foreach (var i in cart.Items.Where(i => i.Producto == idProducto))
                {
                    if (i.Cantidad >= cantidad)
                    {
                        i.Cantidad = i.Cantidad - cantidad;
                    }
                    else
                    {
                        i.Cantidad = 0;
                    }
                    client.Store(StoreMode.Set, currentUser.UserName, cart);
                    return View("cart", cart);
                }
                return View("Cart", cart);
            }
        }
    }
}