/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aes.touresbalon.touresbalonoms.services;

import com.aes.touresbalon.touresbalonoms.wsdl.client.GestionTarifaFault_Exception;
import com.aes.touresbalon.touresbalonoms.wsdl.client.Producto;
import com.aes.touresbalon.touresbalonoms.wsdl.client.ServiceProxyOMS;
import com.aes.touresbalon.touresbalonoms.wsdl.client.ServiceProxyOMS_Service;
import com.aes.touresbalon.touresbalonoms.wsdl.client.TarifaValores;
import com.aes.touresbalon.touresbalonoms.wsdl.client.TipoAccion;
import com.aes.touresbalon.touresbalonoms.wsdl.client.TipoConsultaProducto;
import com.aes.touresbalon.touresbalonoms.wsdl.client.TipoGestionProductoResponse;
import com.aes.touresbalon.touresbalonoms.wsdl.client.TipoTarifa;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.ws.BindingProvider;


/**
 *
 * @author deirovir
 */
public class ProductoService {

    public void crearProducto(Producto producto) {
        
        try {
            //conf del servicio
            ServiceProxyOMS_Service service = new ServiceProxyOMS_Service();
            ServiceProxyOMS port = service.getServiceProxyOMSSOAP();
            
            //parametros de entrada
            TipoAccion tipoOperacion = TipoAccion.ADICIONAR;
//            Producto producto = new Producto();
//            producto.setDescripcion("nuevo producto");
            String endpointURL = "http://localhost:8088/mockServiceProxyOMSSOAP";        
            BindingProvider bp = (BindingProvider) port;
            bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointURL);

            //Llamado al servicio
            TipoGestionProductoResponse result = port.gestionProducto(tipoOperacion, producto);
            
            // Procesamiento de la rta del servicio
            System.out.println("Resultado con idProducto = "+result.getIdProducto());
                        
        } catch (Exception ex) {
            System.out.println("com.aes.touresbalon.touresbalonoms.services.Servicio.gestionProducto()" + ex.getMessage());
        }
    }
    
    public void editarProducto() {
        
        try {
            //conf del servicio
            ServiceProxyOMS_Service service = new ServiceProxyOMS_Service();
            ServiceProxyOMS port = service.getServiceProxyOMSSOAP();
            
            //parametros de entrada
            TipoAccion tipoOperacion = TipoAccion.MODIFICAR;
            Producto producto = new Producto();
            String endpointURL = "http://localhost:8088/mockServiceProxyOMSSOAP";        
            BindingProvider bp = (BindingProvider) port;
            bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointURL);

            //Llamado al servicio
            TipoGestionProductoResponse result = port.gestionProducto(tipoOperacion, producto);
            
            // Procesamiento de la rta del servicio
            System.out.println("Resultado con idProducto = "+result.getIdProducto());
                        
        } catch (Exception ex) {
            System.out.println("com.aes.touresbalon.touresbalonoms.services.Servicio.gestionProducto()" + ex.getMessage());
        }
    }
    
    public void eliminarProducto() {
        
        try {
            //conf del servicio
            ServiceProxyOMS_Service service = new ServiceProxyOMS_Service();
            ServiceProxyOMS port = service.getServiceProxyOMSSOAP();
            
            //parametros de entrada
            TipoAccion tipoOperacion = TipoAccion.ELIMINAR;
            Producto producto = new Producto();
            String endpointURL = "http://localhost:8088/mockServiceProxyOMSSOAP";        
            BindingProvider bp = (BindingProvider) port;
            bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointURL);

            //Llamado al servicio
            TipoGestionProductoResponse result = port.gestionProducto(tipoOperacion, producto);
            
            // Procesamiento de la rta del servicio
            System.out.println("Resultado con idProducto = "+result.getIdProducto());
                        
        } catch (Exception ex) {
            System.out.println("com.aes.touresbalon.touresbalonoms.services.Servicio.gestionProducto()" + ex.getMessage());
        }
    }
    
    public void consultarProducto(TipoConsultaProducto tipoConsulta, String consulta){
        ServiceProxyOMS_Service service = new ServiceProxyOMS_Service();
            ServiceProxyOMS port = service.getServiceProxyOMSSOAP();
            
            //parametros de entrada
            TipoAccion tipoOperacion = TipoAccion.ADICIONAR;
//            Producto producto = new Producto();
//            producto.setDescripcion("nuevo producto");
            String endpointURL = "http://localhost:8088/mockServiceProxyOMSSOAP";        
            BindingProvider bp = (BindingProvider) port;
            bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointURL);

            //Llamado al servicio
           // TipoGestionProductoResponse result = port.gestionProducto(tipoOperacion, producto);
           TarifaValores tv = new TarifaValores();
           tv.setId(12312);
           tv.setNombreTipo("Bogota");
           tv.setPrecio(123345);
           
        try {
            port.gestionTarifa(TipoAccion.ADICIONAR, TipoTarifa.CIUDAD, tv);
        } catch (GestionTarifaFault_Exception ex) {
            Logger.getLogger(ProductoService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
