using System;
using System.Collections.Generic;
using B2CTouresBalon.ServiceProxyB2C;

namespace B2CTouresBalon.Models
{
    public class OrdenModel
    {



        public DateTime fecha_orden { get; set; } 

        public EstadoOrden estadoOrden { get; set; } 

        public string id_orden { get; set; }

        public double precio { get; set; }

        public List<ServiceProxyB2C.Item> item { get; set; }

        public string[] comentarios { get; set; }


    }

    public class RespuestaCancelacionModel
    {
        public string respuesta { get; set; }
    }

    
}