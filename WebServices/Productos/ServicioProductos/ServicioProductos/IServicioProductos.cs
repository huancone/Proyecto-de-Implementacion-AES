using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace ServicioProductos
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the interface name "IServicioProductos" in both code and config file together.
    [ServiceContract]
    public interface IServicioProductos
    {
        [OperationContract]
        void DoWork();

        [OperationContract]
        List<Producto> ConsultarProductos(string palabraClave);

        [OperationContract]
        List<Producto> ConsultarPromociones();

    }
}
