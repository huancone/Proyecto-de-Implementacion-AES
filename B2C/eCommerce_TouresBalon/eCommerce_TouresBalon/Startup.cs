using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(eCommerce_TouresBalon.Startup))]
namespace eCommerce_TouresBalon
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
