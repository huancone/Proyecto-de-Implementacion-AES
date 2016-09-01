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

            using (var client = new MemcachedClient())
            {
                client.Store(StoreMode.Set, "currentTime", DateTime.Now.ToString(CultureInfo.InvariantCulture));
                var value = client.Get<string>("currentTime");
            }

            return View(productos);
        }
    }
}