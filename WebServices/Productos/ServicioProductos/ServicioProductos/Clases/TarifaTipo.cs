using System.Runtime.Serialization;

namespace ServicioProductos
{
    [DataContract]
    public class TarifaTipo
    {
        [DataMember]
        public int id { get; set; }

        [DataMember]
        public string nombre_tipo { get; set; }

        [DataMember]
        public double precio { get; set; }

        public TarifaTipo(int id, string nombreTipo, double precio)
        {
            this.id = id;
            nombre_tipo = nombreTipo;
            this.precio = precio;
        }
    }
}