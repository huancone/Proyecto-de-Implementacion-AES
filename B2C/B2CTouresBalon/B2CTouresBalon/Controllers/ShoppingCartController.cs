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
using Item = B2CTouresBalon.Models.Item;

namespace B2CTouresBalon.Controllers
{
    public class ShoppingCartController : Controller
    {
        // GET: ShoppingCart
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult OrderNow(int id, int cantidad)
        {
            if (!ModelState.IsValid) return View("Index");

            var currentUser = System.Web.HttpContext.Current.User as CustomPrincipal;
            if (currentUser == null) return View("Index");

            using (var client = new MemcachedClient())
            {
                var userCache = client.Get<Cart>(currentUser.CustId.ToString(CultureInfo.InvariantCulture));
                if (null == userCache)
                {
                    var proxyProductos = new ServiceProxyB2CClient();
                    var item = new Item
                    {
                        Producto = proxyProductos.ConsultarProducto(TipoConsultaProducto.Id, id.ToString(), null, null).First(),
                        Cantidad = cantidad
                    };
                    var cart = new Cart {UserId = (int) currentUser.CustId};
                    cart.Items.Add(item);
                    client.Store(StoreMode.Set, currentUser.CustId.ToString(CultureInfo.InvariantCulture), cart);
                }
                else
                {
                    var cart = new Cart { UserId = (int)currentUser.CustId };
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
            return View("cart");
        }
    }
}