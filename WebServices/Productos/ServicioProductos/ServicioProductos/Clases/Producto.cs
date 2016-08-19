using System;
using System.Collections.Generic;
using System.Runtime.Serialization;

namespace ServicioProductos
{
    [DataContract]
    public class Producto
    {
        [DataMember]
        public int id_producto { get; set; }
        [DataMember]
        public string espectaculo { get; set; }
        [DataMember]
        public Ciudad ciudad { get; set; }
        [DataMember]
        public DateTime fecha_llegada { get; set; }
        [DataMember]
        public DateTime fecha_salida { get; set; }
        [DataMember]
        public TarifaTipo tipo_transporte { get; set; }
        [DataMember]
        public TarifaTipo tipo_espectaculo { get; set; }
        [DataMember]
        public TarifaTipo tipo_hospedate { get; set; }
        [DataMember]
        public string imagen{ get; set; }

        public List<Producto> ProductosAsociados { get; set; } 

        public Producto()
        {
            id_producto = 1;
            espectaculo = "Juegos Olimpicos";
            fecha_llegada = DateTime.Parse("2016-08-01");
            fecha_salida = DateTime.Parse("2016-08-21");
            ciudad = new Ciudad();
            tipo_transporte = new TarifaTipo(1, "Transporte Terrestre", 1200);
            tipo_espectaculo = new TarifaTipo(1, "Juegos Olimpicos", 3000); ;
            tipo_hospedate = new TarifaTipo(1, "Hotel 5 Estrellas", 5000);
            imagen = null;
            ProductosAsociados = null;
        }
    }
}