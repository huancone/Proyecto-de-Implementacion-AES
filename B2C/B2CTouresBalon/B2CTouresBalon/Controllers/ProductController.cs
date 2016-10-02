using System;
using System.Linq;
using System.Web.Mvc;
using B2CTouresBalon.Models;
using B2CTouresBalon.ServiceProxyB2C;

namespace B2CTouresBalon.Controllers
{
    public class ProductController : Controller
    {
        // GET: Product
        public ActionResult Index(string searchString)
        {
            var proxy = new ServiceProxyB2CClient();
            var productos = new ProductosModel { Productos = proxy.ConsultarProducto(TipoConsultaProducto.DESCRIPCION, null, null, searchString) };
            if (productos.Productos.Length == 0)
            {
                productos = new ProductosModel { Productos = proxy.ConsultarCampaniaProducto() };
            }
            return View(productos);
        }

        // GET: Product/Details/5
        public ActionResult Details(int idProducto)
        {
            var proxy = new ServiceProxyB2CClient();
           // var productos = new ProductosModel { Productos = proxy.ConsultarProducto(TipoConsultaProducto.ID, idProducto.ToString(), null, null) };
            var productos = new ProductosModel { Productos = proxy.ConsultarCampaniaProducto() };
            return View(productos.Productos);
        }
    }
}
