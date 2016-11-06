/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aes.touresbalon.touresbalonoms.services;

import com.aes.touresbalon.touresbalonoms.wsdl.client.ActualizarClienteFault_Exception;
import com.aes.touresbalon.touresbalonoms.wsdl.client.ActualizarContraseniaClienteFault_Exception;
import com.aes.touresbalon.touresbalonoms.wsdl.client.ActualizarEstatusClienteFault_Exception;
import com.aes.touresbalon.touresbalonoms.wsdl.client.Campania;
import com.aes.touresbalon.touresbalonoms.wsdl.client.Cliente;
import com.aes.touresbalon.touresbalonoms.wsdl.client.ConsultarCampaniaProductoFault_Exception;
import com.aes.touresbalon.touresbalonoms.wsdl.client.ConsultarOrdenesFault_Exception;
import com.aes.touresbalon.touresbalonoms.wsdl.client.ConsultarPorEspectaculoProductoFault_Exception;
import com.aes.touresbalon.touresbalonoms.wsdl.client.ConsultarPorFactRangoClienteFault_Exception;
import com.aes.touresbalon.touresbalonoms.wsdl.client.ConsultarPorIdentificacionClienteFault_Exception;
import com.aes.touresbalon.touresbalonoms.wsdl.client.ConsultarPorProductoClienteFault_Exception;
import com.aes.touresbalon.touresbalonoms.wsdl.client.ConsultarProductoFault_Exception;
import com.aes.touresbalon.touresbalonoms.wsdl.client.ConsultarRangoCerradoOrdenesFault_Exception;
import com.aes.touresbalon.touresbalonoms.wsdl.client.ConsultarRankingAbiertasOrdenesFault_Exception;
import com.aes.touresbalon.touresbalonoms.wsdl.client.ConsultarRankingEspectaculosVendidosProductoFault_Exception;
import com.aes.touresbalon.touresbalonoms.wsdl.client.ConsultarRankingFechaProductoFault_Exception;
import com.aes.touresbalon.touresbalonoms.wsdl.client.CriterioConsultaOrden;
import com.aes.touresbalon.touresbalonoms.wsdl.client.EstatusCliente;
import com.aes.touresbalon.touresbalonoms.wsdl.client.GestionCampaniaProductoFault_Exception;
import com.aes.touresbalon.touresbalonoms.wsdl.client.GestionTarifaFault_Exception;
import com.aes.touresbalon.touresbalonoms.wsdl.client.Orden;
import com.aes.touresbalon.touresbalonoms.wsdl.client.Producto;
import com.aes.touresbalon.touresbalonoms.wsdl.client.RegistrarClienteFault_Exception;
import com.aes.touresbalon.touresbalonoms.wsdl.client.RegistrarClienteReponseType;
import com.aes.touresbalon.touresbalonoms.wsdl.client.RespuestaGenerica;
import com.aes.touresbalon.touresbalonoms.wsdl.client.RespuestaOrdenCerrada;
import com.aes.touresbalon.touresbalonoms.wsdl.client.ServiceProxyOMS;
import com.aes.touresbalon.touresbalonoms.wsdl.client.ServiceProxyOMS_Service;
import com.aes.touresbalon.touresbalonoms.wsdl.client.TarifaValores;
import com.aes.touresbalon.touresbalonoms.wsdl.client.TipoAccion;
import com.aes.touresbalon.touresbalonoms.wsdl.client.TipoConsultaProducto;
import com.aes.touresbalon.touresbalonoms.wsdl.client.TipoGestionCampaniaResponse;
import com.aes.touresbalon.touresbalonoms.wsdl.client.TipoGestionProductoResponse;
import com.aes.touresbalon.touresbalonoms.wsdl.client.TipoGestionTarifaResponse;
import com.aes.touresbalon.touresbalonoms.wsdl.client.TipoTarifa;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.BindingProvider;

/**
 *
 * @author alexanderbarbosaayala
 */
public class Services {

    public TipoGestionProductoResponse gestionProducto(Producto producto, TipoAccion tipoOperacion) {

        TipoGestionProductoResponse result = new TipoGestionProductoResponse();
        try {
            //conf del servicio
            ServiceProxyOMS_Service service = new ServiceProxyOMS_Service();
            ServiceProxyOMS port = service.getServiceProxyOMSSOAP();

            String endpointURL = "http://localhost:8088/mockServiceProxyOMSSOAP";
            BindingProvider bp = (BindingProvider) port;
            bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointURL);

            //Llamado al servicio
             result = port.gestionProducto(tipoOperacion, producto);

            // Procesamiento de la rta del servicio
            System.out.println("Resultado con idProducto = " + result.getIdProducto());

        } catch (Exception ex) {
            System.out.println("com.aes.touresbalon.touresbalonoms.services.Servicio.gestionProducto()" + ex.getMessage());
        }
       
        return result;
    }

    public java.util.List<Producto> consultarProducto(TipoConsultaProducto tipoConsulta, String consulta) {
        List<Producto> list = new ArrayList<Producto>();
        try {
            ServiceProxyOMS_Service service = new ServiceProxyOMS_Service();
            ServiceProxyOMS port = service.getServiceProxyOMSSOAP();

            //parametros de entrada
//            Producto producto = new Producto();
//            producto.setDescripcion("nuevo producto");
            String endpointURL = "http://localhost:8089/mockConsultaProducto";
            BindingProvider bp = (BindingProvider) port;
            bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointURL);

            //Llamado al servicio
             list = port.consultarProducto(tipoConsulta, consulta);

            // Procesamiento de la rta del servicio
            System.out.println("Resultado con idProducto = " + list.get(0));

        } catch (ConsultarProductoFault_Exception ex) {
            Logger.getLogger(ProductoService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public RegistrarClienteReponseType registrarCliente(Cliente cliente) throws RegistrarClienteFault_Exception {
        return null;
    }

    public RespuestaGenerica actualizarCliente(Cliente cliente) throws ActualizarClienteFault_Exception {
        return null;
    }

    public RespuestaGenerica actualizarContraseniaCliente(String usuario, String contrasenia) throws ActualizarContraseniaClienteFault_Exception {
        return null;
    }

    public RespuestaGenerica actualizarEstatusCliente(int idCliente, EstatusCliente estatus) throws ActualizarEstatusClienteFault_Exception {
        return null;
    }

    public Cliente consultarPorIdentificacionCliente(int idCliente) throws ConsultarPorIdentificacionClienteFault_Exception {
        return null;
    }

    public List<Cliente> consultarPorProductoCliente(int idProducto) throws ConsultarPorProductoClienteFault_Exception {
        return null;
    }

    public List<Cliente> consultarPorFactRangoCliente(javax.xml.datatype.XMLGregorianCalendar fechaInicial, XMLGregorianCalendar fechaFin) throws ConsultarPorFactRangoClienteFault_Exception {
        return null;
    }

    public List<Producto> consultarPorEspectaculoProducto(String espectaculo) throws ConsultarPorEspectaculoProductoFault_Exception, DatatypeConfigurationException {
    //TODO: TENER PRESENTE se debe consultar el servicio de esta manera numero_pagina@cadena_a_buscar@        
        return null;
    }

    public List<Producto> consultarRankingFechaProducto(javax.xml.datatype.XMLGregorianCalendar fechaInicial, javax.xml.datatype.XMLGregorianCalendar fechaFin) throws ConsultarRankingFechaProductoFault_Exception, DatatypeConfigurationException {
        return null;
    }

    public List<TarifaValores> consultarRankingEspectaculosVendidosProducto(javax.xml.datatype.XMLGregorianCalendar fechaInicial, javax.xml.datatype.XMLGregorianCalendar fechaFin) throws ConsultarRankingEspectaculosVendidosProductoFault_Exception {
        return null;
    }

    public List<Producto> consultarCampaniaProducto()throws ConsultarCampaniaProductoFault_Exception, DatatypeConfigurationException  {
        return null;
    }

    public TipoGestionCampaniaResponse gestionCampaniaProducto(TipoAccion tipoOperacion, Campania campania) throws GestionCampaniaProductoFault_Exception {
        return null;
    }

    public TipoGestionTarifaResponse gestionTarifa(TipoAccion tipoOperacion, TipoTarifa tipoTarifa, TarifaValores tarifa) throws GestionTarifaFault_Exception {
        return null;
    }

    public List<Orden> consultarOrdenes(CriterioConsultaOrden criterios) throws ConsultarOrdenesFault_Exception {
        return null;
    }

    public RespuestaOrdenCerrada consultarRangoCerradoOrdenes(javax.xml.datatype.XMLGregorianCalendar fechaInicial, javax.xml.datatype.XMLGregorianCalendar fechaFinal) throws ConsultarRangoCerradoOrdenesFault_Exception {
        return null;
    }

    public List<Orden> consultarRankingAbiertasOrdenes()  throws ConsultarRankingAbiertasOrdenesFault_Exception {
        return null;
    }

    public List<Orden> consultarRankingCerradoOrdenes() {
        return null;
    }
}
