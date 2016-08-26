using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using B2CTouresBalon.ServiceProxyB2C;

namespace B2CTouresBalon.Models
{
    public class ProductsViewModel
    {
        public Producto[] Promociones { get; set; }
        public Producto[] Productos { get; set; }

        public string CadenaBusqueda { get; set; }

    }
}