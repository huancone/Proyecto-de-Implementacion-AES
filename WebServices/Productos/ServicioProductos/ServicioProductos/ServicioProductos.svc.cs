using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace ServicioProductos
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "ServicioProductos" in code, svc and config file together.
    // NOTE: In order to launch WCF Test Client for testing this service, please select ServicioProductos.svc or ServicioProductos.svc.cs at the Solution Explorer and start debugging.
    public class ServicioProductos : IServicioProductos
    {
        
        public void DoWork()
        {

        }

        public List<Producto> ConsultarProductos(string palabraClave)
        {
            var productos = new List<Producto>();
            var producto = new Producto();
            for (var i = 1; i < 10; i++)
            {
                productos.Add(producto);
            }
            return productos;
        }

        public List<Producto> ConsultarPromociones()
        {
                var promociones = new List<Producto>();
                var producto = new Producto();
                for (var i = 1; i < 5; i++)
                {
                    promociones.Add(producto);
                }
                return promociones;
        }
    }
}
