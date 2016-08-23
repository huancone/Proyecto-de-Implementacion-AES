using System.Web.Mvc;

namespace B2CTouresBalon.Controllers
{
    public class ErrorController : Controller
    {
        //
        // GET: /Error/
        public ActionResult AccessDenied()
        {
            return View();
        }
	}
}