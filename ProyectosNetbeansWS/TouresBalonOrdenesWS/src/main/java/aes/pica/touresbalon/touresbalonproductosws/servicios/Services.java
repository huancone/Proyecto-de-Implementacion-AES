/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aes.pica.touresbalon.touresbalonproductosws.servicios;

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
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.jws.WebService;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
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

        System.out.println("--------------------------------------------------");
        System.out.println("INICIO ::: consultarClientesOrdenes");

        final Session sessionOrdenes;
        final Transaction tx;
    
        sessionOrdenes = ClientesyOrdenesHU.getSessionFactory().getCurrentSession();
        tx = sessionOrdenes.beginTransaction();
        
        List<Orden> ordenes = new ArrayList<Orden>();
        String strsql;

        try {           
        
            strsql = "from Orders where ordid = :idCustomer )";
            sessionOrdenes.createQuery(strsql)
                    .setParameter("idCustomer", idCliente);
 
        } catch (Exception e) {

            tx.rollback();
            System.out.println("$$$ Error consultarClientesOrdenes" + e);

        } finally {
            if(sessionOrdenes.isOpen()){
                sessionOrdenes.close();
            }
        }

        System.out.println("FINAL  ::: consultarClientesOrdenes");
        System.out.println("--------------------------------------------------");

        return ordenes;
        
    }

    public com.touresbalon.ordenestouresbalon.RespuestaGenerica cancelarOrdenes(java.util.List<java.lang.Integer> idOrden) throws com.touresbalon.ordenestouresbalon.CancelarOrdenesFault_Exception {

        System.out.println("--------------------------------------------------");
        System.out.println("INICIO ::: cancelarOrdenes");

        final Session sessionOrdenes;
        final Transaction tx;
    
        sessionOrdenes = ClientesyOrdenesHU.getSessionFactory().getCurrentSession();
        tx = sessionOrdenes.beginTransaction();
        
        RespuestaGenerica respuesta = RespuestaGenerica.KO;
        Orders ordenDB = new Orders();
        EstatusOrden estatusOrden = null;
        Integer id = 0;

        try {
            
            ordenDB.setOrdid(idOrden.get(0));
            ordenDB.setStatus(estatusOrden.CANCELADA.value());
            sessionOrdenes.update(ordenDB);
            tx.commit();

        } catch (Exception e) {

            tx.rollback();
            System.out.println("$$$ ERROR: cancelarOrdenes: " + e);
            respuesta = RespuestaGenerica.OK;

        } finally {
            if(sessionOrdenes.isOpen()){
                sessionOrdenes.close();
            }
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
        final Transaction tx;
    
        sessionOrdenes = ClientesyOrdenesHU.getSessionFactory().getCurrentSession();
        tx = sessionOrdenes.beginTransaction();
        
        CrearOrdenResponse respuesta = new CrearOrdenResponse();
        Orders ordenDB = new Orders();
        Integer id = 0;

        try {

            // Creacion de orden
            System.out.println("fecha recibida: " + orden.getFechaOrden());
            ordenDB.setOrderdate(toDate(orden.getFechaOrden()));
            ordenDB.setPrice(orden.getPrecio());
            EstatusOrden estatusOrden = null;
            ordenDB.setStatus(orden.getEstatus().toString());
            ordenDB.setComments(orden.getComentarios().get(0));
            ordenDB.setCustomer(new Customer());
            ordenDB.getCustomer().setCustid(orden.getIdCliente());
            id = (Integer) sessionOrdenes.save(ordenDB);

            // Creacion de items
            for (Item item : orden.getItem()) {
                Items itemDB = new Items();
                itemDB.setProdid(item.getIdProd());
                itemDB.setProductname(item.getNombreProd());
                itemDB.setPartnum(item.getPartNum());
                itemDB.setPrice(item.getPrecio());
                itemDB.setQuantity(item.getCantidad());
                itemDB.setOrders(new Orders());
                itemDB.getOrders().setOrdid(id);
                sessionOrdenes.save(itemDB);
            }
            tx.commit();

        } catch (Exception e) {

            tx.rollback();
            System.out.println("$$$ ERROR: crearOrdenes: " + e);
            respuesta.setRespuesta(RespuestaGenerica.KO);

        } finally {
            if(sessionOrdenes.isOpen()){
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

        final Session sessionOrdenes;
        final Transaction tx;
    
        sessionOrdenes = ClientesyOrdenesHU.getSessionFactory().getCurrentSession();
        tx = sessionOrdenes.beginTransaction();
        
        Orders ordenDB = new Orders();
        Items itemDB = new Items();
        Orden orden = new Orden();
        List<Orden> ordenes = new ArrayList<Orden>();

        try {

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
            ordenes.add(orden);

        } catch (Exception e) {

            tx.rollback();
            System.out.println("$$$ Error consultarOrdenes" + e);

        } finally {
            if(sessionOrdenes.isOpen()){
                sessionOrdenes.close();
            }
        }

        System.out.println("FINAL  ::: consultarOrdenes");
        System.out.println("--------------------------------------------------");

        return ordenes;

    }

    public com.touresbalon.ordenestouresbalon.RespuestaOrdenCerrada consultarRangoCerradoOrdenes(javax.xml.datatype.XMLGregorianCalendar fechaInicial, javax.xml.datatype.XMLGregorianCalendar fechaFinal) throws com.touresbalon.ordenestouresbalon.ConsultarRangoCerradoOrdenesFault_Exception {
     
        System.out.println("--------------------------------------------------");
        System.out.println("INICIO ::: consultarRangoCerradoOrdenes");

        final Session sessionOrdenes;
        final Transaction tx;
    
        sessionOrdenes = ClientesyOrdenesHU.getSessionFactory().getCurrentSession();
        tx = sessionOrdenes.beginTransaction();
        
        Orders ordenDB = new Orders();
        Items itemDB = new Items();
        Orden orden = new Orden();
        List<Orden> ordenes = new ArrayList<Orden>();
        RespuestaOrdenCerrada respuesta = new RespuestaOrdenCerrada();

        try {

            int count = ((Long) sessionOrdenes.createQuery("select count(*) from Orders where orderdate between " + fechaInicial + " and " + fechaFinal + " order by price desc ").uniqueResult()).intValue();
            System.out.println("||| cantidad: " + count);
            double suma = ((Double) sessionOrdenes.createQuery("select sum(price) from Orders").uniqueResult()).intValue();
            System.out.println("||| suma: " + suma);

            respuesta.setOrdenesCerradas(count);
            respuesta.setTotal(suma);

        } catch (Exception e) {

            tx.rollback();
            System.out.println("$$$ Error consultarRangoCerradoOrdenes" + e);

        } finally {
            if(sessionOrdenes.isOpen()){
                sessionOrdenes.close();
            }
        }

        System.out.println("FINAL  ::: consultarRangoCerradoOrdenes");
        System.out.println("--------------------------------------------------");

        return respuesta;

    }

    public java.util.List<com.touresbalon.ordenestouresbalon.Orden> consultarRankingAbiertasOrdenes() throws com.touresbalon.ordenestouresbalon.ConsultarRankingAbiertasOrdenesFault_Exception {

        System.out.println("--------------------------------------------------");
        System.out.println("INICIO ::: consultarRankingAbiertasOrdenes");
        final Session sessionOrdenes;
        final Transaction tx;
    
        sessionOrdenes = ClientesyOrdenesHU.getSessionFactory().getCurrentSession();
        tx = sessionOrdenes.beginTransaction();
        
        List<Orden> ordenes = new ArrayList<Orden>();
        List<Orders> ordenesDB = new ArrayList<Orders>();
        String strsql;
        Query query = null;

        try {
        
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

            tx.rollback();
            System.out.println("$$$ Error consultarRankingAbiertasOrdenes" + e);

        } finally {
            if(sessionOrdenes.isOpen()){
                sessionOrdenes.close();
            }
        }

        System.out.println("FINAL  ::: consultarRankingAbiertasOrdenes");
        System.out.println("--------------------------------------------------");

        return ordenes;
    }

    public java.util.List<com.touresbalon.ordenestouresbalon.Orden> consultarRankingCerradoOrdenes() throws com.touresbalon.ordenestouresbalon.ConsultarRankingCerradoOrdenesFault_Exception {

        System.out.println("--------------------------------------------------");
        System.out.println("INICIO ::: consultarRankingCerradoOrdenes");

        final Session sessionOrdenes;
        final Transaction tx;
    
        sessionOrdenes = ClientesyOrdenesHU.getSessionFactory().getCurrentSession();
        tx = sessionOrdenes.beginTransaction();
        
        List<Orden> ordenes = new ArrayList<Orden>();
        List<Orders> ordenesDB = new ArrayList<Orders>();
        String strsql;
        Query query = null;

        try {
        
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

            tx.rollback();
            System.out.println("$$$ Error consultarRankingCerradoOrdenes" + e);

        } finally {
            if(sessionOrdenes.isOpen()){
                sessionOrdenes.close();
            }
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
