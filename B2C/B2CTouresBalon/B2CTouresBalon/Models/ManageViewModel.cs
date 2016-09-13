using System.ComponentModel.DataAnnotations;

namespace B2CTouresBalon.Models
{
    public class ManageViewModel
    {

        public decimal CustomerId { get; set; }

        [DataType(DataType.Text)]
        public string FirstName { get; set; }

        [DataType(DataType.Text)]
        public string LastName { get; set; }

        public string PhoneNumber { get; set; }

        [DataType(DataType.EmailAddress)]
        public string Email { get; set; }

        [DataType(DataType.Text)]
        public string CreditCardType { get; set; }

        [DataType(DataType.CreditCard)]
        public string CreditCardNumber { get; set; }

        public bool Status { get; set; }
    }
}