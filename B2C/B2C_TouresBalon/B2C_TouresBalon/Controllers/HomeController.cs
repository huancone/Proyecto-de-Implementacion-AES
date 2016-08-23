﻿using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using B2C_TouresBalon.ServicioProductos;

namespace B2C_TouresBalon.Controllers
{
    public class HomeController : Controller
    {

        public ActionResult Index()
        {
            var proxy = new ServicioProductosClient();
            IEnumerable<Producto> promociones = proxy.ConsultarPromociones();
            
            return View(promociones);
        }
    }
}