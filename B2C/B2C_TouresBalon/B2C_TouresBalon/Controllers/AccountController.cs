using System.Web.Mvc;

namespace B2C_TouresBalon.Controllers
{
    public class AccountController : Controller
    {
        public ActionResult LogOff()
        {
            return RedirectToRoute("Home");
        }

        public ActionResult Register()
        {
            return View();
        }

        public ActionResult Login()
        {
            return View();
        }

        public ActionResult Index()
        {
            return View();
        }
    }
}