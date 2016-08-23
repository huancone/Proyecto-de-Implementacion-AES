using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AccesoDatos
{
    public class Cliente
    {
        public CUSTOMER ObtenerUsuario(string correo, string password)
        {
            using (var db = new ClientsContext())
            {
                var res = db.CUSTOMERs.Where(auth => auth.EMAIL == correo & auth.PASSWORD == password).ToList().FirstOrDefault();
                return res;
            }
        }
    }
}