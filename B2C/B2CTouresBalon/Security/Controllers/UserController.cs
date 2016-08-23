using System.Web.Mvc;
using B2CTouresBalon.DAL.Security;

namespace B2CTouresBalon.Controllers
{
    // [CustomAuthorize(RolesConfigKey = "RolesConfigKey")]
   // [CustomAuthorize(UsersConfigKey = "UsersConfigKey")]
     [CustomAuthorize(Roles= "User")]
    // [CustomAuthorize(Users = "1,2")]
    public class UserController : BaseController
    {
        //
        // GET: /User/
        public ActionResult Index()
        {
            return View();
        }
    }
}