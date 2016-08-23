using System.Runtime.Serialization;

namespace ServicioProductos
{
    [DataContract]
    public class Ciudad
    {

        [DataMember]
        public int id_ciudad { get; set; }
        [DataMember]
        public string pais { get; set; }
        [DataMember]
        public TarifaTipo tipo_ciudad { get; set; }

        public Ciudad(int idCiudad, string pais, TarifaTipo tipoCiudad)
        {
            id_ciudad = idCiudad;
            this.pais = pais;
            tipo_ciudad = tipoCiudad;
        }

        public Ciudad()
        {
            id_ciudad = 1;
            this.pais = "Brasil";
            tipo_ciudad = new TarifaTipo(1,"Tipo Ciudad 1", 5000);
        }
    }
}