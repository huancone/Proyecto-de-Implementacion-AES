﻿using System.Web.Mvc;

namespace B2CTouresBalon.Controllers
{
    public class HomeController : BaseController
    {
        //
        // GET: /Home/
        public ActionResult Index()
        {
            //string FullName = User.FirstName + " " + User.LastName;
            return View();
        }
    }
}