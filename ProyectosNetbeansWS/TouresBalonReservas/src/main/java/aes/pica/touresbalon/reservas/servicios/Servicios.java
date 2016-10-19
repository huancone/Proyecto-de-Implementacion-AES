/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aes.pica.touresbalon.reservas.servicios;

import aes.pica.touresbalon.reservas.entidades.clientesyordenes.Items;
import aes.pica.touresbalon.reservas.entidades.clientesyordenes.Orders;
import aes.pica.touresbalon.reservas.entidades.dann.PublicReservations;
import aes.pica.touresbalon.reservas.entidades.productos.Producto;
import aes.pica.touresbalon.reservas.util.ClientesYOrdenesHU;
import aes.pica.touresbalon.reservas.util.Constantes;
import aes.pica.touresbalon.reservas.util.DannHU;
import aes.pica.touresbalon.reservas.util.ProductosHU;
import aes.pica.touresbalon.tb_serviciosbolivariano.IServiciosBolivarianos;
import aes.pica.touresbalon.tb_serviciosbolivariano.ServiciosBolivarianos;
import aes.pica.touresbalon.tb_serviciosbolivariano.ServiciosBolivarianosExcepcion;
import aes.pica.touresbalon.tb_serviciosbolivariano.vo.ViajeVO;
import com.touresbalon.reservastouresbalon.RespuestaGenerica;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
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
    private IServiciosBolivarianos sb;

    public com.touresbalon.reservastouresbalon.RespuestaGenerica validarDisponibilidadReservas(int idOrden, com.touresbalon.reservastouresbalon.Item itemEspectaculo, com.touresbalon.reservastouresbalon.Item itemTransporte, com.touresbalon.reservastouresbalon.Item itemHospedaje, com.touresbalon.reservastouresbalon.Item itemCiudad) throws com.touresbalon.reservastouresbalon.ValidarDisponibilidadReservasFault_Exception {

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Query q;
        try {
            sessionOrdenes = ClientesYOrdenesHU.getSessionFactory().openSession();
            txOrdenes = sessionOrdenes.beginTransaction();
            String strQuery = "from Orders where ordid = :idOrden";
            q = sessionOrdenes.createQuery(strQuery);
            q.setParameter("idOrden", idOrden);
            Orders ord = (Orders) q.uniqueResult();

            if (ord != null) {
                Iterator<Items> iterator = ord.getItemses().iterator();
                Items auxItem;
                Producto prodAux;
                sessionProductos = ProductosHU.getSessionFactory().openSession();
                txProductos = sessionProductos.beginTransaction();
                sessionDann = DannHU.getSessionFactory().openSession();
                txDann = sessionDann.beginTransaction();
                RespuestaGenerica resVal = RespuestaGenerica.OK;
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

                        //Si el transporte es Bolivariano se valida con los archivos plano
                        if (prodAux.getTarifaTransporte().getNombreTransporte().equalsIgnoreCase(Constantes.TRANS_BOL)) {
                            sb = new ServiciosBolivarianos(Constantes.RUTA_CONSULTA_BOL, Constantes.RUTA_RESERVA_BOL);

                            df = new SimpleDateFormat("ddMMyyyy");

                            System.out.println("Consultar Viajes Bolivariano");
                            System.out.println("Fecha Viaje Bolivariano: " + df.format(prodAux.getFechaSalida()));
                            System.out.println("Origen Viaje:" + itemCiudad.getNombreItem());
                            System.out.println("Destino Viaje:" + prodAux.getCiudad().getNombreCiudad());

                            List<ViajeVO> listViajes = sb.consultarViajes("19102016", "bogota", "medellin");
                            if (!listViajes.isEmpty()) {
                                System.out.println("Hay Viajes Disponibles en Bolivariano");
                                for (ViajeVO v : listViajes) {
                                    System.out.println(v);
                                }
                            } else {
                                System.out.println("No hay viajes las caracteristicas solicitadas");
                                return RespuestaGenerica.KO;
                            }

                        }

                        //Si es el hotel Dann Carlton se consulta en la base de datos del Hotel para la disponibilidad
                        if (prodAux.getTarifaHospedaje().getNombreHospedaje().equalsIgnoreCase(Constantes.HOS_DANN)) {
                            strQuery = "SELECT \n"
                                    + "  pr.*\n"
                                    + "FROM \n"
                                    + "  PUBLIC_RESERVATIONS pr \n"
                                    + "WHERE\n"
                                    + "  pr.ID_PUBLIC_RESERVATION NOT IN (SELECT tr.PUBLIC_RESERVATIONS_ID FROM TOURESBALON_RESERVATIONS tr)";
                            q = sessionDann.createSQLQuery(strQuery).addEntity(PublicReservations.class);
                            List listPB = q.list();
                            int cntDann = listPB.size();
                            if (cntDann == 0) {
                                return RespuestaGenerica.KO;
                            }
                        }
                    }
                }
                return resVal;
            }
            txDann.commit();
            txProductos.commit();
            txOrdenes.commit();

        } catch (HibernateException e) {
            if (txProductos != null) {
                txProductos.rollback();
            }
            if (txOrdenes != null) {
                txOrdenes.rollback();
            }
            if (txDann != null) {
                txDann.rollback();
            }
            System.err.println("Error Hibernate:");
            System.err.println(e.toString());
        } catch (ServiciosBolivarianosExcepcion ex) {
            System.err.println("Error Bolivariano");
            System.err.println(ex.toString());
        } finally {
//            sessionDann.close();
//            sessionProductos.close();
            sessionOrdenes.close();
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
