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
                var model = new Cart();
                var currentUser = System.Web.HttpContext.Current.User as CustomPrincipal;
                if (currentUser != null)
                    model = client.Get<Cart>(currentUser.CustId.ToString(CultureInfo.InvariantCulture));
                return View(model);
            }
        }

        public ActionResult AddItem(int idProducto, int cantidad)
        {
            if (!ModelState.IsValid) return View("Index");

            //consulto el usuario logueado
            var currentUser = System.Web.HttpContext.Current.User as CustomPrincipal;
            if (currentUser == null) return View("Index");

            //creo un carrito vacio
            var cart = new Cart
            {
                UserId = (int) currentUser.CustId,
                Items = new List<Item>()
            };
            MemcachedClientConfiguration clientConfiguration = new MemcachedClientConfiguration();
            clientConfiguration.Protocol = MemcachedProtocol.Binary;
            clientConfiguration.Servers.Add( new IPEndPoint(IPAddress.Parse("127.0.0.1"), 32768));

            using (var client = new MemcachedClient(clientConfiguration))
            {
                //consulto el cache del usuario logueado
                var userCartCache = client.Get<Cart>(currentUser.UserName);
                
                if (null == userCartCache)//si el carrito es vacio cree uno nuevo
                {
                    var item = new Item
                    {
                        Producto = idProducto,
                        Cantidad = cantidad
                    };
                    cart.Items.Add(item);

                    client.Store(StoreMode.Set, currentUser.UserName, cart);
                    userCartCache = client.Get<Cart>(currentUser.UserName);
                }
                else
                {
                    foreach (var i in userCartCache.Items.Where(i => i.Producto == idProducto))
                    {
                        i.Cantidad = i.Cantidad + cantidad;
                        cart = userCartCache;
                        client.Store(StoreMode.Set, currentUser.UserName, userCartCache);
                        return View("cart", cart);
                    }
                    var item = new Item
                    {
                        Producto = idProducto,
                        Cantidad = cantidad
                    };
                    userCartCache.Items.Add(item);
                    client.Store(StoreMode.Set, currentUser.UserName, userCartCache);
                    cart = userCartCache;
                }
            }
            return View("Cart", cart);
        }
    }
}