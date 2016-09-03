using System;
using System.Web;
using System.Web.Http;
using System.Web.Mvc;
using System.Web.Optimization;
using System.Web.Routing;
using System.Web.Security;
using B2CTouresBalon.DAL.Security;
using Newtonsoft.Json;

namespace B2CTouresBalon
{
    public class MvcApplication : HttpApplication
    {
        protected void Application_Start()
        {
            AreaRegistration.RegisterAllAreas();

            WebApiConfig.Register(GlobalConfiguration.Configuration);
            FilterConfig.RegisterGlobalFilters(GlobalFilters.Filters);
            RouteConfig.RegisterRoutes(RouteTable.Routes);
            BundleConfig.RegisterBundles(BundleTable.Bundles);
        }
        protected void Application_PostAuthenticateRequest(object sender, EventArgs e)
        {
            var authCookie = Request.Cookies[FormsAuthentication.FormsCookieName];
            if (authCookie == null) return;
            var authTicket = FormsAuthentication.Decrypt(authCookie.Value);

            var serializeModel = JsonConvert.DeserializeObject<CustomPrincipalSerializeModel>(authTicket.UserData);
            var newUser = new CustomPrincipal(authTicket.Name)
            {
                UserName = serializeModel.UserName,
                FirstName = serializeModel.FirstName,
                LastName = serializeModel.LastName,
                CustId = serializeModel.CustId,
                roles = serializeModel.roles
            };

            HttpContext.Current.User = newUser;
        }
    }
}
