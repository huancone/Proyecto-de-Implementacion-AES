using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using B2CTouresBalon.Models;

namespace B2CTouresBalon.Models
{
    public class Cart
    {
        public int UserId { get; set; }
        public List<Item> Items { get; set; }
    }
}