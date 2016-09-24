/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aes.pica.touresbalon.touresbalonproductosws.servicios;

import aes.pica.touresbalon.touresbalonproductosws.entidades.clientesyordenes.Customer;
import aes.pica.touresbalon.touresbalonproductosws.entidades.clientesyordenes.Orders;
import aes.pica.touresbalon.touresbalonproductosws.util.ClientesyOrdenesHU;
import com.touresbalon.ordenestouresbalon.CrearOrdenResponse;
import com.touresbalon.ordenestouresbalon.EstatusOrden;
import javax.jws.WebService;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author braatz
 */
@WebService(serviceName = "OrdenesTouresBalon", portName = "OrdenesTouresBalonSOAP", endpointInterface = "com.touresbalon.ordenestouresbalon.OrdenesTouresBalon", targetNamespace = "http://www.touresbalon.com/OrdenesTouresBalon/", wsdlLocation = "WEB-INF/wsdl/OrdenesTouresBalon.wsdl")
public class Services {
    
    private Session sessionOrdenes;
    private Transaction tx;

    public java.util.List<com.touresbalon.ordenestouresbalon.Orden> consultarClientesOrdenes(java.lang.String idCliente) throws com.touresbalon.ordenestouresbalon.ConsultarClientesOrdenesFault_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public com.touresbalon.ordenestouresbalon.RespuestaGenerica cancelarOrdenes(java.util.List<java.lang.String> idOrden) throws com.touresbalon.ordenestouresbalon.CancelarOrdenesFault_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public com.touresbalon.ordenestouresbalon.CrearOrdenResponse crearOrdenes(com.touresbalon.ordenestouresbalon.Orden orden) throws com.touresbalon.ordenestouresbalon.CrearOrdenesFault_Exception {
            String res = "";
            Orders or = new Orders();

            sessionOrdenes = ClientesyOrdenesHU.getSessionFactory().getCurrentSession();
            tx = sessionOrdenes.beginTransaction();
            or.setStatus("Ok");
            Customer customer = new Customer(5);
            or.setCustomer(customer);

            Integer id = (Integer) sessionOrdenes.save(or);
            System.out.println(res = "este es el id: " + id);
            
            tx.commit();
            
            CrearOrdenResponse rta = new CrearOrdenResponse();
            rta.setEstatusOrden(EstatusOrden.VALIDACION);
            return rta;
    }

    public java.util.List<com.touresbalon.ordenestouresbalon.Orden> consultarOrdenes(com.touresbalon.ordenestouresbalon.CriterioConsultaOrden criterios) throws com.touresbalon.ordenestouresbalon.ConsultarOrdenesFault_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public com.touresbalon.ordenestouresbalon.RespuestaOrdenCerrada consultarRangoCerradoOrdenes(int mes, int anio) throws com.touresbalon.ordenestouresbalon.ConsultarRangoCerradoOrdenesFault_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public java.util.List<com.touresbalon.ordenestouresbalon.Orden> consultarRankingAbiertasOrdenes() throws com.touresbalon.ordenestouresbalon.ConsultarRankingAbiertasOrdenesFault_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public java.util.List<com.touresbalon.ordenestouresbalon.Orden> consultarRankingCerradoOrdenes() throws com.touresbalon.ordenestouresbalon.ConsultarRankingCerradoOrdenesFault_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }
    
}
