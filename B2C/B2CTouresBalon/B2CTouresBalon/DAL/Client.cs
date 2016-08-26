using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;

namespace B2CTouresBalon.DAL
{
    public class Client
    {
        public int UserId { get; set; }

        [Required]
        public String Username { get; set; }

        [Required]
        [DataType(DataType.EmailAddress)]
        [Display(Name = "Correo Electronico") ]
        public String Email { get; set; }

        [Required]
        [DataType(DataType.Password) ]
        [Display(Name ="Contraseña")]
        public String Password { get; set; }




        [Required]
        [Display(Name = "Contraseña")]

        public String FirstName { get; set; }
        public String LastName { get; set; }

        public Boolean IsActive { get; set; }
        public DateTime CreateDate { get; set; }

        public virtual ICollection<Role> Roles { get; set; }
    }
}