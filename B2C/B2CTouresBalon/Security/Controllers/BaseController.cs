using System.Web.Mvc;
using B2CTouresBalon.DAL.Security;

namespace B2CTouresBalon.Controllers
{
    public class BaseController : Controller
    {
        protected virtual new CustomPrincipal User
        {
            get { return HttpContext.User as CustomPrincipal; }
        }
    }
}