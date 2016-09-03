using System.Linq;
using System.Security.Principal;

namespace B2CTouresBalon.DAL.Security
{
    public class CustomPrincipal : IPrincipal
    {
        public IIdentity Identity { get; }
        public bool IsInRole(string role)
        {
            return roles.Any(role.Contains);
        }

        public CustomPrincipal(string username)
        {
            Identity = new GenericIdentity(username);
        }

        public string UserName { get; set; }
        public string FirstName { get; set; }
        public string LastName { get; set; }

        public decimal CustId { get; set; }
        public string[] roles { get; set; }
    }

    public class CustomPrincipalSerializeModel
    {
        public string UserName { get; set; }
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public decimal CustId { get; set; }
        public string[] roles { get; set; }
    }
}