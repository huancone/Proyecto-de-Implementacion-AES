using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;

namespace B2CTouresBalon.DAL
{
    public class Client
    {
        public int UserId { get; set; }

        [Required]
        public string Username { get; set; }

        [Required]
        public string Email { get; set; }

        [Required]
        public string Password { get; set; }

        public string FirstName { get; set; }
        public string LastName { get; set; }

        public bool IsActive { get; set; }
        public DateTime CreateDate { get; set; }

        public virtual ICollection<Role> Roles { get; set; }
    }
}