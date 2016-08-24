using System;
using System.Data.Entity;
using System.Linq;
using System.Threading.Tasks;

namespace DataAccess
{
    public class Clientes
    {
        public async Task<CUSTOMER> ObtenerUsuario(string correo, string password)
        {
            using (var db = new ClientsContext())
            {
                var customer = from c in db.CUSTOMER
                               where c.EMAIL == correo & c.PASSWORD == password
                               select c;
                return await customer.SingleOrDefaultAsync();
            }
        }

        public async Task<CUSTOMER> ObtenerUsuario(string userid)
        {
            using (var db = new ClientsContext())
            {
                var customer = from c in db.CUSTOMER
                               where c.CUSTID == userid
                               select c;
                return await customer.SingleOrDefaultAsync();
            }
        }

        public async Task<bool> ActualizarUsuario(string firstName, string lastName, string email, string phoneNumber,
            string creditCardType, string creditCardNumber)
        {
            using (var db = new ClientsContext())
            {
                var customer = from c in db.CUSTOMER
                    where c.EMAIL == email
                    select c;

                var customer2 = await customer.SingleOrDefaultAsync();
                if (null == customer2) return false;
                customer2.FNAME = firstName;
                customer2.LNAME = lastName;
                customer2.EMAIL = email;
                customer2.PHONENUMBER = phoneNumber;
                customer2.CREDITCARDTYPE = creditCardType;
                customer2.CREDITCARDNUMBER = creditCardNumber;
                var x = await db.SaveChangesAsync();

                return true;
            }
        }
    }
}
