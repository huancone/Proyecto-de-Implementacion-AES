/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aes.pica.touresbalon.touresbalonproductosws.servicios;

import javax.jws.WebService;

/**
 *
 * @author braatz
 */
@WebService(serviceName = "OrdenesTouresBalon", portName = "OrdenesTouresBalonSOAP", endpointInterface = "com.touresbalon.ordenestouresbalon.OrdenesTouresBalon", targetNamespace = "http://www.touresbalon.com/OrdenesTouresBalon/", wsdlLocation = "WEB-INF/wsdl/OrdenesTouresBalon.wsdl")
public class Services {

    public java.util.List<com.touresbalon.ordenestouresbalon.Orden> consultarClientesOrdenes(java.lang.String idCliente) throws com.touresbalon.ordenestouresbalon.ConsultarClientesOrdenesFault_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public com.touresbalon.ordenestouresbalon.RespuestaGenerica cancelarOrdenes(java.util.List<java.lang.String> idOrden) throws com.touresbalon.ordenestouresbalon.CancelarOrdenesFault_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public com.touresbalon.ordenestouresbalon.CrearOrdenResponse crearOrdenes(com.touresbalon.ordenestouresbalon.Orden orden) throws com.touresbalon.ordenestouresbalon.CrearOrdenesFault_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
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
