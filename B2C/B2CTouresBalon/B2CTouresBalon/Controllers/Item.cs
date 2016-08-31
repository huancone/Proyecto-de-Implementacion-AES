using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using B2CTouresBalon.ServiceProxyB2C;

namespace B2CTouresBalon.Controllers
{
    public class Item
    {
        public Producto Producto { get; set; } = new Producto();
        public int Cantidad { get; set; }
    }
}