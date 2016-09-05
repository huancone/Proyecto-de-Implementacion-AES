using System;
using System.Threading.Tasks;
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
        public async Task<ActionResult> Index(LoginViewModel model, string returnUrl = "")
        {
            if (!ModelState.IsValid) return View(model);
            var user = await _context.ObtenerUsuario(model.Username, model.Password);
            if (user != null)
            {

                var serializeModel = new CustomPrincipalSerializeModel
                {
                    UserName = user.EMAIL,
                    FirstName = user.FNAME,
                    LastName = user.LNAME,
                    CustId = user.CUSTID
                };

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

                model.CustId = user.CUSTID;
                return RedirectToAction("Index", "Home");
            }

            ModelState.AddModelError("", "Incorrect username and/or password");
            return View(model);
        }


        public async Task<ViewResult> Manage()
        {
            if (!ModelState.IsValid) return View("Index");

            var currentuser = System.Web.HttpContext.Current.User as CustomPrincipal;


            var userId = Convert.ToInt64(currentuser?.CustId);
            var user = await _context.ObtenerUsuario(userId);

            var model = new ManageViewModel();
            if (null == user) return View(model);
            model.FirstName = user.FNAME;
            model.LastName = user.LNAME;
            model.Email = user.EMAIL;
            model.PhoneNumber = user.PHONENUMBER;
            model.CreditCardType = user.CREDITCARDTYPE;
            model.CreditCardNumber = user.CREDITCARDNUMBER;
            model.CustomerId = user.CUSTID;
            return View(model);
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ViewResult> Manage(ManageViewModel model, ManageMessageId? message)
        {
            ViewBag.StatusMessage =
                message == ManageMessageId.UpdateSuccess ? "Your account has been updated."
                : message == ManageMessageId.UpdateError ? "An error has occurred."
                : "";
            if (!ModelState.IsValid) return View(model);
            if (await _context.ActualizarUsuario(model.CustomerId,
                model.FirstName,
                model.LastName,
                model.Email,
                model.PhoneNumber,
                model.CreditCardType,
                model.CreditCardNumber))
            {
                ModelState.AddModelError("", "Your account has been updated.");
                return View(model);
            }
            ModelState.AddModelError("", "An error has occurred.");
            return View(model);
        }


        [AllowAnonymous]
        public ActionResult LogOut()
        {
            FormsAuthentication.SignOut();
            return RedirectToAction("Index", "Account", null);
        }

        public enum ManageMessageId
        {
            UpdateSuccess,
            UpdateError
        }
    }


}