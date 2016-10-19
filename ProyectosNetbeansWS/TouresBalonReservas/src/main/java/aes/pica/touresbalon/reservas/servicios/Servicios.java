/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aes.pica.touresbalon.reservas.servicios;

import aes.pica.touresbalon.reservas.entidades.clientesyordenes.Items;
import aes.pica.touresbalon.reservas.entidades.clientesyordenes.Orders;
import aes.pica.touresbalon.reservas.entidades.productos.Producto;
import aes.pica.touresbalon.reservas.util.ClientesYOrdenesHU;
import aes.pica.touresbalon.reservas.util.Constantes;
import aes.pica.touresbalon.reservas.util.ProductosHU;
import com.touresbalon.reservastouresbalon.RespuestaGenerica;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import javax.jws.WebService;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author jdtrujillop
 */
@WebService(serviceName = "ReservasTouresBalon", portName = "ReservasTouresBalonSOAP", endpointInterface = "com.touresbalon.reservastouresbalon.ReservasTouresBalon", targetNamespace = "http://www.touresbalon.com/ReservasTouresBalon/", wsdlLocation = "WEB-INF/wsdl/ReservasTB.wsdl")
public class Servicios {

    //Variables globlales
    // private Session sessionClientes;
    private Session sessionProductos;
    private Session sessionOrdenes;
    private Session sessionDann;
    private Transaction txProductos;
    private Transaction txOrdenes;
    private Transaction txDann;

    public com.touresbalon.reservastouresbalon.RespuestaGenerica validarDisponibilidadReservas(int idOrden, com.touresbalon.reservastouresbalon.Item itemEspectaculo, com.touresbalon.reservastouresbalon.Item itemTransporte, com.touresbalon.reservastouresbalon.Item itemHospedaje, com.touresbalon.reservastouresbalon.Item itemCiudad) throws com.touresbalon.reservastouresbalon.ValidarDisponibilidadReservasFault_Exception {
        sessionProductos = ProductosHU.getSessionFactory().getCurrentSession();
        txProductos = sessionProductos.beginTransaction();
        sessionOrdenes = ClientesYOrdenesHU.getSessionFactory().getCurrentSession();
        txOrdenes = sessionOrdenes.beginTransaction();
        sessionDann = ClientesYOrdenesHU.getSessionFactory().getCurrentSession();
        txDann = sessionDann.beginTransaction();
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Query q;
        try {
            String strQuery = "from Orders where ordid = :idOrden";
            q = sessionOrdenes.createQuery(strQuery);
            q.setParameter("idOrden", idOrden);
            Orders ord = (Orders) q.uniqueResult();

            if (ord != null) {
                Iterator<Items> iterator = ord.getItemses().iterator();
                Items auxItem;
                Producto prodAux;
                while (iterator.hasNext()) {
                    auxItem = iterator.next();
                    System.out.println("El id del item es: " + auxItem.getItemid());
                    System.out.println("El id del producto es: " + auxItem.getProdid());

                    strQuery = "from Producto where idProducto = :idProducto";
                    q = sessionProductos.createQuery(strQuery);
                    q.setParameter("idProducto", auxItem.getProdid());
                    prodAux = (Producto) q.uniqueResult();

                    if (prodAux != null) {
                        System.out.println("El Descripcion del producto es: " + prodAux.getDescripcion());
                        System.out.println("El Espectaculo del producto es: " + prodAux.getEspectaculo());
                        System.out.println("El Fecha Salida del producto es: " + df.format(prodAux.getFechaSalida()));
                        System.out.println("El Fecha Espectactulo del producto es: " + df.format(prodAux.getFechaEspectaculo()));
                        System.out.println("El Fecha Llegada del producto es: " + df.format(prodAux.getFechaLlegada()));
                        
                        if(prodAux.getTarifaTransporte().getNombreTransporte().equalsIgnoreCase(Constantes.TRANS_BOL)){
                            //Falta Implementar
                        }
                        
                        if(prodAux.getTarifaHospedaje().getNombreHospedaje().equalsIgnoreCase(Constantes.HOS_DANN)){
                            strQuery = "select count(1) from PublicReservations as pr inner join pr.touresbalonReservationses as tr";
                            q = sessionDann.createQuery(strQuery);
                            Integer cntDann = (Integer) q.uniqueResult();
                            if(cntDann==0){
                                return RespuestaGenerica.KO;
                            }
                        }
                        
                        return RespuestaGenerica.OK;
                    }

                }
            }

        } catch (HibernateException e) {
            if (txProductos != null) {
                txProductos.rollback();
            }
            if (txOrdenes != null) {
                txOrdenes.rollback();
            }
            System.err.println("Error Hibernate:");
            System.err.println(e.toString());
        }

        return RespuestaGenerica.KO;
    }

    public com.touresbalon.reservastouresbalon.RespuestaGenerica reservarProductos(int idOrden, com.touresbalon.reservastouresbalon.Item itemEspectaculo, com.touresbalon.reservastouresbalon.Item itemTransporte, com.touresbalon.reservastouresbalon.Item itemHospedaje, com.touresbalon.reservastouresbalon.Item itemCiudad) throws com.touresbalon.reservastouresbalon.ReservarProductosFault_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public com.touresbalon.reservastouresbalon.RespuestaGenerica callbackValidacionAnalista(int idOrden, java.lang.String estatusOrden) throws com.touresbalon.reservastouresbalon.CallbackValidacionAnalistaFault_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public java.lang.String cancelarReserva(int idOrden) throws com.touresbalon.reservastouresbalon.CancelarReservaFault_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

}
