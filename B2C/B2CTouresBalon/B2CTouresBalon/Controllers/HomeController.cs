using System;
using System.Globalization;
using System.Web.Mvc;
using B2CTouresBalon.Models;
using B2CTouresBalon.ServiceProxyB2C;
using Enyim.Caching;
using Enyim.Caching.Memcached;

namespace B2CTouresBalon.Controllers
{
    public class HomeController : BaseController
    {
        //
        // GET: /Home/
        public ActionResult Index()
        {
            var proxy   = new ServiceProxyB2CClient();
            var productos = new PromocionesModel {Promociones = proxy.ConsultarCampaniaProducto()};

            return View(productos);
        }
    }
}