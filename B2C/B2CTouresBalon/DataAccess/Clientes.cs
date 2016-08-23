using System.Linq;

namespace DataAccess
{
    public class Clientes
    {
        public CUSTOMER ObtenerUsuario(string correo, string password)
        {
            using (var db = new ClientsContext())
            {
                var res = db.CUSTOMER.Where(auth => auth.EMAIL == correo & auth.PASSWORD == password).ToList().FirstOrDefault();
                return res;
            }
        }
    }
}
