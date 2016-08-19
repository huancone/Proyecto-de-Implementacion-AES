using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using B2C_TouresBalon.ServicioProductos;

namespace B2C_TouresBalon.Models
{
    public class Productos
    {
        public List<Producto> promos { get; set; }

        public Productos()
        {
        }

        

        public List<Producto> Promociones()
        {
            return promos;
        }
    }
}