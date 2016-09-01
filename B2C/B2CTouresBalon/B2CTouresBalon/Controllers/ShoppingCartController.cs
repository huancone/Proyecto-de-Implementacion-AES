using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using B2CTouresBalon.ServiceProxyB2C;
using Enyim.Caching;
using Enyim.Caching.Memcached;

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

            using (var client = new MemcachedClient())
            {
                client.Store(StoreMode.Set, "currentTime", DateTime.Now.ToString(CultureInfo.InvariantCulture));
                var value = client.Get<string>("currentTime");
            }
            if (Session["cart"]==null )
            {
                var proxyProductos = new ServiceProxyB2CClient();
                var item = new Item
                {
                    Producto = proxyProductos.ConsultarProducto(TipoConsultaProducto.Id, id.ToString(), null, null).First(),
                    Cantidad = cantidad
                };
                var cart = new List<Item> {item};
                Session["cart"] = cart;

            }
            else
            {
                var cart = (List<Item>)Session["cart"];
                var proxyProductos = new ServiceProxyB2CClient();
                var item = new Item
                {
                    Producto = proxyProductos.ConsultarProducto(TipoConsultaProducto.Id, id.ToString(), null, null).First(),
                    Cantidad = cantidad
                };
                cart.Add(item);
            }
            return View("cart");
        }
    }
}