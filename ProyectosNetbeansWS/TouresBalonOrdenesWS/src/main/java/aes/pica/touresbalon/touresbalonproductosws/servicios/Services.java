/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aes.pica.touresbalon.touresbalonproductosws.servicios;

//import aes.pica.touresbalon.touresbalonproductosws.clientebpel.CreacionOrdenes;
//import aes.pica.touresbalon.touresbalonproductosws.clientebpel.CreacionordenesClientEp;
import aes.pica.touresbalon.touresbalonproductosws.entidades.clientesyordenes.Customer;
import aes.pica.touresbalon.touresbalonproductosws.entidades.clientesyordenes.Items;
import aes.pica.touresbalon.touresbalonproductosws.entidades.clientesyordenes.Orders;
import aes.pica.touresbalon.touresbalonproductosws.util.ClientesyOrdenesHU;
import com.touresbalon.ordenestouresbalon.CrearOrdenResponse;
import com.touresbalon.ordenestouresbalon.EstatusOrden;
import com.touresbalon.ordenestouresbalon.Item;
import com.touresbalon.ordenestouresbalon.Orden;
import com.touresbalon.ordenestouresbalon.RespuestaGenerica;
import com.touresbalon.ordenestouresbalon.RespuestaOrdenCerrada;
import java.math.BigInteger;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import javax.jws.WebService;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.BindingProvider;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author braatz
 */
@WebService(serviceName = "OrdenesTouresBalon", portName = "OrdenesTouresBalonSOAP", endpointInterface = "com.touresbalon.ordenestouresbalon.OrdenesTouresBalon", targetNamespace = "http://www.touresbalon.com/OrdenesTouresBalon/", wsdlLocation = "WEB-INF/wsdl/OrdenesTouresBalon.wsdl")
public class Services {

    public java.util.List<com.touresbalon.ordenestouresbalon.Orden> consultarClientesOrdenes(int idCliente) throws com.touresbalon.ordenestouresbalon.ConsultarClientesOrdenesFault_Exception {

        final Session sessionOrdenes;
        final Transaction tx;

        List<Orden> ordenes = new ArrayList<>();
        List<Orders> OrderDB = new ArrayList<>();

        String strsql;

        sessionOrdenes = ClientesyOrdenesHU.getSessionFactory().getCurrentSession();
        try {
            tx = sessionOrdenes.beginTransaction();
            try {
                strsql = "from Orders where custid = :idCustomer )";
                Query q = sessionOrdenes.createQuery(strsql)
                        .setParameter("idCustomer", idCliente);
                OrderDB = q.list();

                for (Orders registro : OrderDB) {
                    Orden orden = new Orden();
                    orden.setIdOrden(registro.getOrdid());
                    orden.setIdCliente(registro.getCustomer().getCustid());
                    orden.setIdOrden(registro.getOrdid());
                    orden.setPrecio(registro.getPrice());
                    orden.setFechaOrden(toGregorian(registro.getOrderdate()));
                    orden.setEstatus(EstatusOrden.fromValue(registro.getStatus()));
                    ordenes.add(orden);
                }
                tx.commit();
            } catch (Exception e) {
                System.out.println("$$$ Error consultarClientesOrdenes" + e);
                tx.rollback();
            }
        } finally {
            if (sessionOrdenes.isOpen()) {
                sessionOrdenes.close();
            }
        }
        return ordenes;
    }

    public com.touresbalon.ordenestouresbalon.RespuestaGenerica cancelarOrdenes(java.util.List<java.lang.Integer> idOrden) throws com.touresbalon.ordenestouresbalon.CancelarOrdenesFault_Exception {

        System.out.println("--------------------------------------------------");
        System.out.println("INICIO ::: cancelarOrdenes");

        Session sessionOrdenes = null;
        Transaction tx = null;

        RespuestaGenerica respuesta = RespuestaGenerica.KO;
        Orders ordenDB = new Orders();
        EstatusOrden estatusOrden = null;
        Integer id = 0;

        try {

            sessionOrdenes = ClientesyOrdenesHU.getSessionFactory().getCurrentSession();
            tx = sessionOrdenes.beginTransaction();

            ordenDB.setOrdid(idOrden.get(0));
            ordenDB.setStatus(estatusOrden.CANCELADA.value());
            sessionOrdenes.update(ordenDB);
            tx.commit();

        } catch (Exception e) {

            System.out.println("$$$ ERROR: cancelarOrdenes: " + e);
            respuesta = RespuestaGenerica.OK;

        }

        respuesta = RespuestaGenerica.OK;

        System.out.println("FINAL  ::: cancelarOrdenes");
        System.out.println("--------------------------------------------------");

        return respuesta;

    }

    public com.touresbalon.ordenestouresbalon.CrearOrdenResponse crearOrdenes(com.touresbalon.ordenestouresbalon.Orden orden) throws com.touresbalon.ordenestouresbalon.CrearOrdenesFault_Exception {

        System.out.println("--------------------------------------------------");
        System.out.println("INICIO ::: crearOrdenes");

        final Session sessionOrdenes;
        sessionOrdenes = ClientesyOrdenesHU.getSessionFactory().getCurrentSession();

        CrearOrdenResponse respuesta = new CrearOrdenResponse();
        Orders ordenDB = new Orders();
        Integer id = 0;

        try {
            final Transaction tx = sessionOrdenes.beginTransaction();
            try {

                // Creacion de orden
                System.out.println("fecha recibida: " + orden.getFechaOrden());
                ordenDB.setOrderdate(toDate(orden.getFechaOrden()));
                ordenDB.setPrice(orden.getPrecio());
                ordenDB.setStatus("VALIDACION");
                if (orden.getComentarios().isEmpty() || orden.getComentarios() == null) {
                    ordenDB.setComments("");
                } else {
                    ordenDB.setComments(orden.getComentarios().get(0));
                }

                Customer user = (Customer) sessionOrdenes.load(Customer.class, orden.getIdCliente());

                ordenDB.setCustomer(user);
                id = (Integer) sessionOrdenes.save(ordenDB);

                // Creacion de items
                for (Item item : orden.getItem()) {
                    Items itemDB = new Items();
                    itemDB.setProdid(item.getIdProd());
                    itemDB.setProductname(item.getNombreProd());
                    itemDB.setPartnum(item.getPartNum());
                    itemDB.setPrice(item.getPrecio());
                    itemDB.setQuantity(item.getCantidad());

                    Orders order = (Orders) sessionOrdenes.load(Orders.class, id);
                    itemDB.setOrders(order);

                    sessionOrdenes.save(itemDB);
                }
                tx.commit();

                //Se hace después del commit para que los datos del orden estén la base de datos
//                URL wsdlBPEL = new URL("http://soabpm-vm.site:7001//soa-infra/services/default/CreacionOrdenesBPEL/creacionordenes_client_ep?wsdl");
//                CreacionordenesClientEp bpel = new CreacionordenesClientEp(wsdlBPEL);

//                BindingProvider bp = (BindingProvider) bpel;
//                bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, wsdlBPEL.toString());

//                CreacionOrdenes co = bpel.getCreacionOrdenesPt();
////                
//                //Se crean los items por defecto
//                aes.pica.touresbalon.touresbalonproductosws.clientebpel.Process.ItemEspectaculo itEsp = new aes.pica.touresbalon.touresbalonproductosws.clientebpel.Process.ItemEspectaculo();
//                aes.pica.touresbalon.touresbalonproductosws.clientebpel.Process.ItemTransporte itTra = new aes.pica.touresbalon.touresbalonproductosws.clientebpel.Process.ItemTransporte();
//                aes.pica.touresbalon.touresbalonproductosws.clientebpel.Process.ItemHospedaje itHos = new aes.pica.touresbalon.touresbalonproductosws.clientebpel.Process.ItemHospedaje();
//                aes.pica.touresbalon.touresbalonproductosws.clientebpel.Process.ItemCiudad itCiu = new aes.pica.touresbalon.touresbalonproductosws.clientebpel.Process.ItemCiudad();
//
//                //Llamado al servicio web del bpel
//                String resBPEL = co.process(
//                        BigInteger.valueOf(id),
//                        ordenDB.getStatus(),
//                        ordenDB.getPrice(),
//                        itEsp,
//                        itTra,
//                        itHos,
//                        itCiu);
//                
//                System.out.println("Respuesta del BPEL: "+resBPEL);

            } catch (Exception ex) {
                System.out.println("$$$ ERROR: crearOrdenes: " + ex);
                respuesta.setRespuesta(RespuestaGenerica.KO);
                tx.rollback();
                //throw ex;
            }
        } finally {
            if (sessionOrdenes.isOpen()) {
                sessionOrdenes.close();
            }
        }

        respuesta.setEstatusOrden(EstatusOrden.fromValue(ordenDB.getStatus()));
        respuesta.setIdOrden(id);
        respuesta.setRespuesta(RespuestaGenerica.OK);

        System.out.println("FINAL  ::: crearOrdenes");
        System.out.println("--------------------------------------------------");

        return respuesta;

    }

    public java.util.List<com.touresbalon.ordenestouresbalon.Orden> consultarOrdenes(com.touresbalon.ordenestouresbalon.CriterioConsultaOrden criterios) throws com.touresbalon.ordenestouresbalon.ConsultarOrdenesFault_Exception {

        System.out.println("--------------------------------------------------");
        System.out.println("INICIO ::: consultarOrdenes");

        Session sessionOrdenes = null;
        Transaction tx = null;

        Orders ordenDB = new Orders();
        Items itemDB = new Items();
        Orden orden = new Orden();
        List<Orden> ordenes = new ArrayList<Orden>();

        try {

            sessionOrdenes = ClientesyOrdenesHU.getSessionFactory().openSession();
            tx = sessionOrdenes.beginTransaction();

            switch (criterios.getTipoConsulta()) {
                case ORDEN:
                    System.out.println("||| Orden criterios.getCodigo(): " + criterios.getCodigo());
                    ordenDB = (Orders) sessionOrdenes.get(Orders.class, criterios.getCodigo());
                    System.out.println("||| Por orden");
                    break;
                case PRODUCTO:
                    itemDB = (Items) sessionOrdenes.load(Items.class, criterios.getCodigo());
                    ordenDB = (Orders) sessionOrdenes.load(Orders.class, itemDB.getProdid());
                    System.out.println("||| Por producto");
                    break;
                default:
                    System.out.println("$$$ Criterio de consulta inválido");
                    break;
            }

            orden.setIdOrden(ordenDB.getOrdid());
            orden.setIdCliente(ordenDB.getCustomer().getCustid());
            orden.setIdOrden(ordenDB.getOrdid());
            orden.setPrecio(ordenDB.getPrice());
            orden.setFechaOrden(toGregorian(ordenDB.getOrderdate()));
            orden.setEstatus(EstatusOrden.fromValue(ordenDB.getStatus()));

            Iterator it = ordenDB.getItemses().iterator();
            Items auxItem;
            Item auxIt;
            while (it.hasNext()) {
                auxItem = (Items) it.next();
                auxIt = new Item();
                auxIt.setIdItem(auxItem.getItemid());
                auxIt.setCantidad(auxItem.getQuantity());
                auxIt.setNombreProd(auxItem.getProductname());
                auxIt.setPrecio(auxItem.getPrice());
                auxIt.setIdProd(auxItem.getProdid());
                orden.getItem().add(auxIt);
            }

            ordenes.add(orden);
            if (tx != null) {
                tx.commit();
            }

        } catch (Exception e) {

            System.out.println("$$$ Error consultarOrdenes" + e);

        } finally {
//            sessionDann.close();
//            sessionProductos.close();
            sessionOrdenes.close();
        }

        System.out.println("FINAL  ::: consultarOrdenes");
        System.out.println("--------------------------------------------------");

        return ordenes;

    }

    public com.touresbalon.ordenestouresbalon.RespuestaOrdenCerrada consultarRangoCerradoOrdenes(javax.xml.datatype.XMLGregorianCalendar fechaInicial, javax.xml.datatype.XMLGregorianCalendar fechaFinal) throws com.touresbalon.ordenestouresbalon.ConsultarRangoCerradoOrdenesFault_Exception {

        System.out.println("--------------------------------------------------");
        System.out.println("INICIO ::: consultarRangoCerradoOrdenes");

        Session sessionOrdenes = null;
        Transaction tx = null;

        Orders ordenDB = new Orders();
        Items itemDB = new Items();
        Orden orden = new Orden();
        List<Orden> ordenes = new ArrayList<Orden>();
        RespuestaOrdenCerrada respuesta = new RespuestaOrdenCerrada();

        try {

            sessionOrdenes = ClientesyOrdenesHU.getSessionFactory().getCurrentSession();
            tx = sessionOrdenes.beginTransaction();

            int count = ((Long) sessionOrdenes.createQuery("select count(*) from Orders where orderdate between " + fechaInicial + " and " + fechaFinal + " order by price desc ").uniqueResult()).intValue();
            System.out.println("||| cantidad: " + count);
            double suma = ((Double) sessionOrdenes.createQuery("select sum(price) from Orders").uniqueResult()).intValue();
            System.out.println("||| suma: " + suma);

            respuesta.setOrdenesCerradas(count);
            respuesta.setTotal(suma);

        } catch (Exception e) {

            System.out.println("$$$ Error consultarRangoCerradoOrdenes" + e);

        }

        System.out.println("FINAL  ::: consultarRangoCerradoOrdenes");
        System.out.println("--------------------------------------------------");

        return respuesta;

    }

    public java.util.List<com.touresbalon.ordenestouresbalon.Orden> consultarRankingAbiertasOrdenes() throws com.touresbalon.ordenestouresbalon.ConsultarRankingAbiertasOrdenesFault_Exception {

        System.out.println("--------------------------------------------------");
        System.out.println("INICIO ::: consultarRankingAbiertasOrdenes");

        Session sessionOrdenes = null;
        Transaction tx = null;

        List<Orden> ordenes = new ArrayList<Orden>();
        List<Orders> ordenesDB = new ArrayList<Orders>();
        String strsql;
        Query query = null;

        try {

            sessionOrdenes = ClientesyOrdenesHU.getSessionFactory().getCurrentSession();
            tx = sessionOrdenes.beginTransaction();

            strsql = "from Orders where status in ( :estadoValidacion, :stadoReservacion )";
            query = sessionOrdenes.createQuery(strsql)
                    .setParameter("estadoValidacion", EstatusOrden.VALIDACION.value())
                    .setParameter("stadoReservacion", EstatusOrden.RESERVACION.value());
            ordenesDB = query.list();

            for (Orders registro : ordenesDB) {
                Orden orden = new Orden();
                orden.setIdOrden(registro.getOrdid());
                orden.setIdCliente(registro.getCustomer().getCustid());
                orden.setIdOrden(registro.getOrdid());
                orden.setPrecio(registro.getPrice());
                orden.setFechaOrden(toGregorian(registro.getOrderdate()));
                orden.setEstatus(EstatusOrden.fromValue(registro.getStatus()));
                ordenes.add(orden);
            }

        } catch (Exception e) {

            System.out.println("$$$ Error consultarRankingAbiertasOrdenes" + e);

        }

        System.out.println("FINAL  ::: consultarRankingAbiertasOrdenes");
        System.out.println("--------------------------------------------------");

        return ordenes;
    }

    public java.util.List<com.touresbalon.ordenestouresbalon.Orden> consultarRankingCerradoOrdenes() throws com.touresbalon.ordenestouresbalon.ConsultarRankingCerradoOrdenesFault_Exception {

        System.out.println("--------------------------------------------------");
        System.out.println("INICIO ::: consultarRankingCerradoOrdenes");

        Session sessionOrdenes = null;
        Transaction tx = null;

        List<Orden> ordenes = new ArrayList<Orden>();
        List<Orders> ordenesDB = new ArrayList<Orders>();
        String strsql;
        Query query = null;

        try {

            sessionOrdenes = ClientesyOrdenesHU.getSessionFactory().getCurrentSession();
            tx = sessionOrdenes.beginTransaction();

            strsql = "from Orders where status = :estadoCarrada";
            query = sessionOrdenes.createQuery(strsql)
                    .setParameter("estadoCarrada", EstatusOrden.CERRADA.value());
            ordenesDB = query.list();

            for (Orders registro : ordenesDB) {
                Orden orden = new Orden();
                orden.setIdOrden(registro.getOrdid());
                orden.setIdCliente(registro.getCustomer().getCustid());
                orden.setIdOrden(registro.getOrdid());
                orden.setPrecio(registro.getPrice());
                orden.setFechaOrden(toGregorian(registro.getOrderdate()));
                orden.setEstatus(EstatusOrden.fromValue(registro.getStatus()));
                ordenes.add(orden);
            }

        } catch (Exception e) {

            System.out.println("$$$ Error consultarRankingCerradoOrdenes" + e);

        }

        System.out.println("FINAL  ::: consultarRankingCerradoOrdenes");
        System.out.println("--------------------------------------------------");

        return ordenes;

    }

    public Date toDate(XMLGregorianCalendar calendar) {

        return calendar.toGregorianCalendar().getTime();

    }

    public XMLGregorianCalendar toGregorian(Date fecha) throws DatatypeConfigurationException {

        GregorianCalendar gc = new GregorianCalendar();
        DatatypeFactory df = DatatypeFactory.newInstance();
        gc.setTimeInMillis(fecha.getTime());
        return df.newXMLGregorianCalendar(gc);

    }

}
