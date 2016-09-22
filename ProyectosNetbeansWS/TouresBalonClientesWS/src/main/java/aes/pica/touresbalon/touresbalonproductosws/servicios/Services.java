/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aes.pica.touresbalon.touresbalonproductosws.servicios;

import com.touresbalon.clientestouresbalon.ActualizarClienteFault_Exception;
import com.touresbalon.clientestouresbalon.ActualizarContraseniaClienteFault_Exception;
import com.touresbalon.clientestouresbalon.ActualizarEstatusClienteFault_Exception;
import com.touresbalon.clientestouresbalon.AutenticarClienteFault_Exception;
import com.touresbalon.clientestouresbalon.ConsultarPorFactRangoClienteFault_Exception;
import com.touresbalon.clientestouresbalon.ConsultarPorIdentificacionClienteFault_Exception;
import com.touresbalon.clientestouresbalon.ConsultarPorProductoClienteFault_Exception;
import com.touresbalon.clientestouresbalon.RegistrarClienteFault_Exception;
import javax.jws.WebService;

/**
 *
 * @author jdtrujillop
 */
@WebService(serviceName = "ClientesTouresBalon", portName = "ClientesTouresBalonSOAP", endpointInterface = "com.touresbalon.clientestouresbalon.ClientesTouresBalon", targetNamespace = "http://www.touresbalon.com/ClientesTouresBalon/", wsdlLocation = "WEB-INF/wsdl/ClientesTouresBalon.wsdl")
public class Services {

    public com.touresbalon.clientestouresbalon.RegistrarClienteReponseType registrarCliente(com.touresbalon.clientestouresbalon.Cliente cliente) throws RegistrarClienteFault_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
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
