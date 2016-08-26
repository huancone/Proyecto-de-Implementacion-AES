using System;
using System.Collections.Generic;
using System.Web.Mvc;
using B2CTouresBalon.DAL.Security;
using B2CTouresBalon.Models;
using B2CTouresBalon.ServiceProxyB2C;

namespace B2CTouresBalon.Controllers
{
    public class HomeController : BaseController
    {
        //
        // GET: /Home/
        public ActionResult Index()
        {
            var proxy   = new ServiceProxyB2CClient();
            var productos = new PromocionesViewModel();
            productos.Promociones = proxy.ConsultarCampaniaProducto();
            return View(productos);
        }
    }
}