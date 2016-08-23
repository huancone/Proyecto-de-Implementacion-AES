using System;
using System.Web;
using System.Web.Mvc;
using System.Web.Security;
using AccesoDatos;
using B2CTouresBalon.DAL.Security;
using B2CTouresBalon.Models;
using Newtonsoft.Json;

namespace B2CTouresBalon.Controllers
{
    public class AccountController : Controller
    {
        //DataContext Context = new DataContext();
        Cliente Context = new Cliente();
        //
        // GET: /Account/
        public ActionResult LogIn()
        {
            return View();
        }

        [HttpPost]
        public ActionResult LogIn(LoginViewModel model, string returnUrl = "")
        {
            if (!ModelState.IsValid) return View(model);
            var user = Context.ObtenerUsuario(model.Username, model.Password);
            if (user != null)
            {
                //var roles=user.Roles.Select(m => m.RoleName).ToArray();

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
                    false,
                    userData);

                var encTicket = FormsAuthentication.Encrypt(authTicket);
                var faCookie = new HttpCookie(FormsAuthentication.FormsCookieName, encTicket);
                Response.Cookies.Add(faCookie);

                //if(roles.Contains("Admin"))
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

                return RedirectToAction("Index", "User");
            }

            ModelState.AddModelError("", "Incorrect username and/or password");

            return View(model);
        }

        [AllowAnonymous]
        public ActionResult LogOut()
        {
            FormsAuthentication.SignOut();
            return RedirectToAction("LogIn", "Account", null);
        }

        //
        // GET: /Account/Register
        [AllowAnonymous]
        public ActionResult Register()
        {
            return View();
        }

        [HttpPost]
        [AllowAnonymous]
        [ValidateAntiForgeryToken]
        public ActionResult Register(RegisterViewModel model)
        {
            return View();
        }

    }
}