using System;
using System.Web;
using System.Web.Mvc;
using System.Web.Security;
using B2CTouresBalon.DAL.Security;
using B2CTouresBalon.Models;
using DataAccess;
using Newtonsoft.Json;

namespace B2CTouresBalon.Controllers
{
    public class AccountController : Controller
    {
        readonly Clientes _context = new Clientes();
        //
        // GET: /Account/
        public ActionResult Index()
        {
            return View();
        }

        [HttpPost]
        public ActionResult Index(LoginViewModel model, string returnUrl = "")
        {
            if (!ModelState.IsValid) return View(model);
            var user = _context.ObtenerUsuario(model.Username, model.Password);
            if (user != null)
            {
                //var roles = user.Select(m => m.RoleName).ToArray();

                var serializeModel = new CustomPrincipalSerializeModel
                {
                    UserId = user.CUSTID,
                    FirstName = user.FNAME,
                    LastName = user.LNAME
                };
                //serializeModel.roles = roles;

                var userData = JsonConvert.SerializeObject(serializeModel);
                var authTicket = new FormsAuthenticationTicket(
                    1,
                    user.EMAIL,
                    DateTime.Now,
                    DateTime.Now.AddMinutes(15),
                    false, //pass here true, if you want to implement remember me functionality
                    userData);

                var encTicket = FormsAuthentication.Encrypt(authTicket);
                var faCookie = new HttpCookie(FormsAuthentication.FormsCookieName, encTicket);
                Response.Cookies.Add(faCookie);

                //if (roles.Contains("Admin"))
                //{
                //    return RedirectToAction("Index", "Admin");
                //}
                //else if (roles.Contains("User"))
                //{
                //    return RedirectToAction("Index", "User");
                //}
                //else
                //{
                //    return RedirectToAction("Index", "Home");
                //}

                return RedirectToAction("Index", "Home");
            }

            ModelState.AddModelError("", "Incorrect username and/or password");

            return View(model);
        }


        public ActionResult Manage()
        {
            return View();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Manage(ManageViewModel model, string returnUrl = "")
        {
            if(!ModelState.IsValid) return View(model);
            var user = _context.ObtenerUsuario(model.FirstName, model.Password);
            if (user != null)
            {
                return View();
            }
            return View(model);
        }


        [AllowAnonymous]
        public ActionResult LogOut()
        {
            FormsAuthentication.SignOut();
            return RedirectToAction("Index", "Account", null);
        }
    }
}