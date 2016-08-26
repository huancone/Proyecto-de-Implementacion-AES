using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using B2CTouresBalon.ServiceProxyB2C;

namespace B2CTouresBalon.Controllers
{
    public class ProductController : Controller
    {
        // GET: Product
        public ActionResult Index()
        {
            var proxy = new ServiceProxyB2CClient();
            var Productos = proxy.ConsultarProducto();
            return View();
        }

        // GET: Product/Details/5
        public ActionResult Details(int id)
        {
            return View();
        }
    }
}
