/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aes.pica.touresbalon.reservas.servicios;

import aes.pica.touresbalon.reservas.entidades.clientesyordenes.Items;
import aes.pica.touresbalon.reservas.entidades.clientesyordenes.Orders;
import aes.pica.touresbalon.reservas.entidades.dann.PublicReservations;
import aes.pica.touresbalon.reservas.entidades.dann.TouresbalonReservations;
import aes.pica.touresbalon.reservas.entidades.productos.Producto;
import aes.pica.touresbalon.reservas.util.ClientesYOrdenesHU;
import aes.pica.touresbalon.reservas.util.Constantes;
import aes.pica.touresbalon.reservas.util.DannHU;
import aes.pica.touresbalon.reservas.util.EmailSenderService;
import aes.pica.touresbalon.reservas.util.ProductosHU;
import aes.pica.touresbalon.reservas.util.ValidacionCupoTarjeta;
import aes.pica.touresbalon.tb_serviciosbolivariano.IServiciosBolivarianos;
import aes.pica.touresbalon.tb_serviciosbolivariano.ServiciosBolivarianos;
import aes.pica.touresbalon.tb_serviciosbolivariano.ServiciosBolivarianosExcepcion;
import aes.pica.touresbalon.tb_serviciosbolivariano.vo.ViajeVO;
import com.touresbalon.reservastouresbalon.RespuestaGenerica;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    private DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public com.touresbalon.reservastouresbalon.RespuestaGenerica validarDisponibilidadReservas(int idOrden, com.touresbalon.reservastouresbalon.Item itemEspectaculo, com.touresbalon.reservastouresbalon.Item itemTransporte, com.touresbalon.reservastouresbalon.Item itemHospedaje, com.touresbalon.reservastouresbalon.Item itemCiudad) throws com.touresbalon.reservastouresbalon.ValidarDisponibilidadReservasFault_Exception {
        if (itemCiudad.getNombreItem() == null) {
            itemCiudad.setNombreItem("");
        }
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
                        if (prodAux.getTarifaTransporte().getNombreTransporte().toUpperCase().contains(Constantes.TRANS_BOL)) {
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
                        if (prodAux.getTarifaHospedaje().getNombreHospedaje().contains(Constantes.HOS_DANN)) {
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
        return reservar(idOrden, itemEspectaculo, itemTransporte, itemHospedaje, itemCiudad);
    }

    public com.touresbalon.reservastouresbalon.RespuestaGenerica callbackValidacionAnalista(int idOrden, java.lang.String estatusOrden, com.touresbalon.reservastouresbalon.Item itemTransporte, com.touresbalon.reservastouresbalon.Item itemHospedaje, com.touresbalon.reservastouresbalon.Item itemEspectaculo, com.touresbalon.reservastouresbalon.Item itemCiudad) throws com.touresbalon.reservastouresbalon.CallbackValidacionAnalistaFault_Exception {
        System.out.println("INICIO ::: CAllBaclReserva");
        if (estatusOrden.equalsIgnoreCase(Constantes.RESERVACION)) {
            System.out.println("Estado de la reserva " + estatusOrden);
            return reservar(idOrden, itemEspectaculo, itemTransporte, itemHospedaje, itemCiudad);
        } else {
            System.out.println("Estado de la reserva " + estatusOrden);
            return RespuestaGenerica.KO;
        }
    }

    public java.lang.String cancelarReserva(int idOrden) throws com.touresbalon.reservastouresbalon.CancelarReservaFault_Exception {

        System.out.println("--------------------------------------------------");
        System.out.println("INICIO ::: cancelarReserva");

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

                            boolean resultCreacionOrden = sb.cancelarReserva(idOrden);
                            if (resultCreacionOrden == true) {
                                System.out.println("Reserva " + Constantes.RUTA_RESERVA_BOL + " cancelada correctamente");
                                return "Reserva " + Constantes.RUTA_RESERVA_BOL + " cancelada correctamente";
                            } else {
                                System.out.println("Error en la cancelación de la reserva" + Constantes.RUTA_RESERVA_BOL + " ");
                                return "Error en la cancelación de la reserva" + Constantes.RUTA_RESERVA_BOL + " ";
                            }

                        } //Si es el hotel Dann Carlton se consulta en la base de datos del Hotel para la disponibilidad
                        else if (prodAux.getTarifaHospedaje().getNombreHospedaje().equalsIgnoreCase(Constantes.HOS_DANN)) {
                            strQuery = "UPDATE \n"
                                    + " TOURESBALON_RESERVATIONS \n"
                                    + " WHERE\n"
                                    + " ORDER_ID = :idProducto";

                            q = sessionDann.createSQLQuery(strQuery).addEntity(PublicReservations.class);
                            List listPB = q.list();
                            int cntDann = listPB.size();
                            if (cntDann > 0) {
                                System.out.println("Reserva " + Constantes.HOS_DANN + " cancelada correctamente");
                                return "Reserva " + Constantes.HOS_DANN + " cancelada correctamente";
                            } else {
                                System.out.println("Error en la cancelación de la reserva" + Constantes.HOS_DANN + " ");
                                return "Error en la cancelación de la reserva" + Constantes.HOS_DANN + " ";
                            }
                        } // Si es el hotel Avianca se realiza el invoca a la operación "cancelarVuelo" 
                        // del servicio "ServicioWebAvianca"
                        else if (prodAux.getTarifaTransporte().getNombreTransporte().equalsIgnoreCase(Constantes.TRANS_AVI)) {
                            //Invocación del servicio de Avianca
                        } // Si es American Airlines se realiza el invoca a la operación "cancelFlight" 
                        // del servicio "AAFlightsService"
                        else if (prodAux.getTarifaTransporte().getNombreTransporte().equalsIgnoreCase(Constantes.TRANS_AIR)) {
                            //Invocación del servicio de American Airlines
                        } // Si es hotel Hilton se realiza el invoca a la operación "cancelRoom" 
                        // del servicio "HiltonBookingService"
                        else if (prodAux.getTarifaTransporte().getNombreTransporte().equalsIgnoreCase(Constantes.HOS_HIL)) {
                            //Invocación del servicio del hotel Hilton
                        } else {
                            EmailSenderService emailSenderService = new EmailSenderService();
                            emailSenderService.sendEmail();
                        }

                    }
                }
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

        System.out.println("FINAL  ::: cancelarReserva");
        System.out.println("--------------------------------------------------");
        return "";

    }

    //Metodos Privados
    private com.touresbalon.reservastouresbalon.RespuestaGenerica reservar(int idOrden, com.touresbalon.reservastouresbalon.Item itemEspectaculo, com.touresbalon.reservastouresbalon.Item itemTransporte, com.touresbalon.reservastouresbalon.Item itemHospedaje, com.touresbalon.reservastouresbalon.Item itemCiudad) {
        System.out.println("Inicio Reservar Producto");
        RespuestaGenerica respuesta = RespuestaGenerica.KO;
        if (itemCiudad.getNombreItem() == null) {
            itemCiudad.setNombreItem("");
        }

        //Validar si tiene la tarjeta cupo
        Query q;
        try {
            System.out.println("El ID de la orden: " + idOrden);
            sessionOrdenes = ClientesYOrdenesHU.getSessionFactory().openSession();
            txOrdenes = sessionOrdenes.beginTransaction();
            String strQuery = "from Orders where ordid = :idOrden";
            q = sessionOrdenes.createQuery(strQuery);
            q.setParameter("idOrden", idOrden);
            Orders ord = (Orders) q.uniqueResult();

            if (ord != null) {
                System.out.println("El cliente es:");
                System.out.println("\t: Primer Nombre: " + ord.getCustomer().getFname());
                System.out.println("\t: Apellido Nombre: " + ord.getCustomer().getLname());
                System.out.println("\t: Tipo Tarjeta: " + ord.getCustomer().getCreditcardtype());
                System.out.println("\t: Numero Tarjeta: " + ord.getCustomer().getCreditcardnumber());
                System.out.println("\t: Primer Nombre: " + ord.getCustomer().getFname());
                if (ValidacionCupoTarjeta.hayCupo(new BigInteger(ord.getCustomer().getCreditcardnumber()))) {
                    System.out.println("Hay cupo en la tarjeta de credito");
                    Iterator<Items> iterator = ord.getItemses().iterator();
                    Items auxItem;
                    Producto prodAux;
                    sessionProductos = ProductosHU.getSessionFactory().openSession();
                    txProductos = sessionProductos.beginTransaction();
                    sessionDann = DannHU.getSessionFactory().openSession();
                    txDann = sessionDann.beginTransaction();
                    while (iterator.hasNext()) {
                        auxItem = iterator.next();
                        System.out.println("El id del item es: " + auxItem.getItemid());
                        System.out.println("El id del producto es: " + auxItem.getProdid());

                        strQuery = "from Producto where idProducto = :idProducto";
                        q = sessionProductos.createQuery(strQuery);
                        q.setParameter("idProducto", auxItem.getProdid());
                        prodAux = (Producto) q.uniqueResult();

                        if (prodAux != null) {
                            if (prodAux.getTarifaTransporte().getNombreTransporte().toUpperCase().contains(Constantes.TRANS_BOL)) {
                                System.out.println("El transporte es Bolivariano");
                                sb = new ServiciosBolivarianos(Constantes.RUTA_CONSULTA_BOL, Constantes.RUTA_RESERVA_BOL);

                                df = new SimpleDateFormat("ddMMyyyy");

                                System.out.println("Consultar Viajes Bolivariano");
                                System.out.println("Fecha Viaje Bolivariano: " + df.format(prodAux.getFechaSalida()));
                                System.out.println("Origen Viaje:" + itemCiudad.getNombreItem());
                                System.out.println("Destino Viaje:" + prodAux.getCiudad().getNombreCiudad());

                                List<ViajeVO> listViajes = new ArrayList<ViajeVO>();
                                ViajeVO auxViajeVO = new ViajeVO();
                                auxViajeVO.setNumViaje(1);
                                auxViajeVO.setNumSilla(1);
                                auxViajeVO.setHoraSalida("09:00");
                                auxViajeVO.setCiudadOrigen(itemCiudad.getNombreItem());
                                auxViajeVO.setCiudadDestino(prodAux.getCiudad().getNombreCiudad());

                                listViajes.add(auxViajeVO);

                                boolean resBol = sb.crearReserva(String.valueOf(idOrden), ord.getCustomer().getFname(), ord.getCustomer().getLname(), df.format(prodAux.getFechaSalida()), listViajes, false);

                                if (resBol) {
                                    System.out.println("Se crea reservacion en bolivariano");
                                } else {
                                    System.out.println("No se crea reservacion en bolivariano");
                                }

                            } else {
                                System.out.println("Se envia correo a la empresa de transporte");
                            }

                            //Si es el hotel Dann Carlton se consulta en la base de datos del Hotel para la disponibilidad
                            if (prodAux.getTarifaHospedaje().getNombreHospedaje().toUpperCase().contains(Constantes.HOS_DANN)) {
                                System.out.println("El transporte es DANN CARLTON");
                                TouresbalonReservations tbr = new TouresbalonReservations();
                                tbr.setGuestName(ord.getCustomer().getFname() + " " + ord.getCustomer().getLname());
                                tbr.setState(1);
                                PublicReservations pbr = (PublicReservations) sessionDann.load(PublicReservations.class, 1);
                                tbr.setPublicReservations(pbr);
                                sessionDann.save(tbr);

                                System.out.println("El id de la reserva es: " + tbr.getReserId());
                                System.out.println("Se crea reservacion en DANN CARLTON");

                            } else {
                                System.out.println("Se envia correo a la empresa de Hospedaje");
                            }

                            System.out.println("Se envia correo a la empresa de Espectaculo");

                        }
                    }

                    System.out.println("Se actualiza el estado de la orden a cerrada");
                    ord.setStatus(Constantes.CERRADA);
                    sessionOrdenes.update(ord);
                    respuesta = RespuestaGenerica.OK;

                } else {
                    System.out.println("No hay cupo en la tarjeta de credito");
                }
            }
            if (txProductos != null) {
                txProductos.commit();
            }
            if (txOrdenes != null) {
                txOrdenes.commit();
            }
            if (txDann != null) {
                txDann.commit();
            }
            
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

        System.out.println("Fin Reservar Producto");
        return respuesta;
    }

}
