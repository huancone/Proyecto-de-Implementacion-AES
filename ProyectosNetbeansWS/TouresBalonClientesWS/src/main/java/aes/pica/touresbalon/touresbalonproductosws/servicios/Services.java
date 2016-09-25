/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aes.pica.touresbalon.touresbalonproductosws.servicios;

import aes.pica.touresbalon.touresbalonproductosws.entidades.clientesyordenes.Address;
import aes.pica.touresbalon.touresbalonproductosws.entidades.productos.TarifaCiudad;
import aes.pica.touresbalon.touresbalonproductosws.util.ClientesyOrdenesHU;
import aes.pica.touresbalon.touresbalonproductosws.util.ProductosHU;
import com.touresbalon.clientestouresbalon.ActualizarClienteFault_Exception;
import com.touresbalon.clientestouresbalon.ActualizarContraseniaClienteFault_Exception;
import com.touresbalon.clientestouresbalon.ActualizarEstatusClienteFault_Exception;
import com.touresbalon.clientestouresbalon.AutenticarClienteFault_Exception;
import com.touresbalon.clientestouresbalon.Cliente;
import com.touresbalon.clientestouresbalon.ConsultarPorFactRangoClienteFault_Exception;
import com.touresbalon.clientestouresbalon.ConsultarPorIdentificacionClienteFault_Exception;
import com.touresbalon.clientestouresbalon.ConsultarPorProductoClienteFault_Exception;
import com.touresbalon.clientestouresbalon.RegistrarClienteFault_Exception;
import com.touresbalon.clientestouresbalon.RegistrarClienteReponseType;
import com.touresbalon.clientestouresbalon.RespuestaGenerica;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.jws.WebService;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author jdtrujillop
 */
@WebService(serviceName = "ClientesTouresBalon", portName = "ClientesTouresBalonSOAP", endpointInterface = "com.touresbalon.clientestouresbalon.ClientesTouresBalon", targetNamespace = "http://www.touresbalon.com/ClientesTouresBalon/", wsdlLocation = "WEB-INF/wsdl/ClientesTouresBalon.wsdl")
public class Services {
    
    //Variables globlales
    private Session sessionClientes;
    private Session sessionProductos;
    private Transaction tx;

    public com.touresbalon.clientestouresbalon.RegistrarClienteReponseType registrarCliente(com.touresbalon.clientestouresbalon.Cliente cliente) throws RegistrarClienteFault_Exception {
        
                String res = "";
                Cliente cl = new Cliente();

                sessionClientes = ClientesyOrdenesHU.getSessionFactory().getCurrentSession();
                tx = sessionClientes.beginTransaction();

                Address addr = new Address();
                addr.setZip("1010");
                addr.setCity("bogota");
                addr.setAddressType("calle");
                addr.setCountry("Colombia");

                Integer id = (Integer) sessionClientes.save(addr);
                tx.commit();
                System.out.println("este es el id de Oracle: " + id);
                cl.setNombres(res);
            
                sessionProductos = ProductosHU.getSessionFactory().getCurrentSession();
                tx = sessionProductos.beginTransaction();
                TarifaCiudad tc = new TarifaCiudad();
                tc.setPrecio(BigDecimal.ZERO);
                tc.setTipoCiudad("bogota");
                id = (Integer) sessionProductos.save(tc);
                System.out.println(" - este es el id de Sql Server: "+id);
                tx.commit();
                
                RegistrarClienteReponseType respuesta = new RegistrarClienteReponseType();
                respuesta.setRespuesta(RespuestaGenerica.OK);
                
                return respuesta;
        //TODO implement this method
        //throw new UnsupportedOperationException("Not implemented yet.");
    }

    public com.touresbalon.clientestouresbalon.RespuestaGenerica autenticarCliente(java.lang.String usuario, java.lang.String contrasenia) throws AutenticarClienteFault_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public com.touresbalon.clientestouresbalon.RespuestaGenerica actualizarCliente(com.touresbalon.clientestouresbalon.Cliente cliente) throws ActualizarClienteFault_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public com.touresbalon.clientestouresbalon.RespuestaGenerica actualizarContraseniaCliente(java.lang.String usuario, java.lang.String contrasenia) throws ActualizarContraseniaClienteFault_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public com.touresbalon.clientestouresbalon.RespuestaGenerica actualizarEstatusCliente(java.lang.String idCliente, com.touresbalon.clientestouresbalon.EstatusCliente estatus) throws ActualizarEstatusClienteFault_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public com.touresbalon.clientestouresbalon.Cliente consultarPorIdentificacionCliente(java.lang.String idCliente) throws ConsultarPorIdentificacionClienteFault_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public java.util.List<com.touresbalon.clientestouresbalon.Cliente> consultarPorProductoCliente(int idProducto) throws ConsultarPorProductoClienteFault_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public java.util.List<com.touresbalon.clientestouresbalon.Cliente> consultarPorFactRangoCliente(javax.xml.datatype.XMLGregorianCalendar fechaInicial, javax.xml.datatype.XMLGregorianCalendar fechaFin) throws ConsultarPorFactRangoClienteFault_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }
    
}
