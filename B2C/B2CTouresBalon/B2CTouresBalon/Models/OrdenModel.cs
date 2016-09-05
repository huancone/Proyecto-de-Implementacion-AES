﻿using System;
using System.Collections.Generic;
using B2CTouresBalon.ServiceProxyB2C;

namespace B2CTouresBalon.Models
{
    public class OrdenModel
    {



        public DateTime fechaOrden { get; set; } 

        public EstatusOrden estatus { get; set; } 

        public string id_orden { get; set; }

        public double precio { get; set; }

        public List<ServiceProxyB2C.Item> detalle { get; set; }


    }

    public class RespuestaCancelacionModel
    {
        public string respuesta { get; set; }
    }

    
}