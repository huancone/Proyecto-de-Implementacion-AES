using System;
using System.Collections.Generic;

namespace B2CTouresBalon.Models
{
    [Serializable]
    public class Cart
    {
        public int UserId { get; set; }
        public List<Item> Items { get; set; }
    }
}