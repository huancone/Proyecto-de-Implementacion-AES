using System.Linq;
using System.Security.Principal;

namespace B2CTouresBalon.DAL.Security
{
    public class CustomPrincipal : IPrincipal
    {
        public IIdentity Identity { get; }
        public bool IsInRole(string role)
        {
            if (roles.Any(r => role.Contains(r)))
            {
                return true;
            }
            return false;
        }

        public CustomPrincipal(string Username)
        {
            Identity = new GenericIdentity(Username);
        }

        public string UserId { get; set; }
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public string[] roles { get; set; }
    }

    public class CustomPrincipalSerializeModel
    {
        public string UserId { get; set; }
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public string[] roles { get; set; }
    }
}