using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using B2CTouresBalon.ServiceProxyB2C;

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
                
            }
            return View("cart");
        }
    }
}