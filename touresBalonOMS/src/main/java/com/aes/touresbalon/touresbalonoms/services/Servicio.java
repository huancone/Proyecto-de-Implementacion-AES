/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aes.touresbalon.touresbalonoms.services;

import com.aes.touresbalon.touresbalonoms.wsdl.client.Producto;
import com.aes.touresbalon.touresbalonoms.wsdl.client.ServiceProxyOMS;
import com.aes.touresbalon.touresbalonoms.wsdl.client.ServiceProxyOMS_Service;
import com.aes.touresbalon.touresbalonoms.wsdl.client.TipoAccion;
import com.aes.touresbalon.touresbalonoms.wsdl.client.TipoGestionProductoResponse;
import javax.xml.ws.BindingProvider;


/**
 *
 * @author deirovir
 */
public class Servicio {

    public void crearProducto() {
        
        try {
            //conf del servicio
            ServiceProxyOMS_Service service = new ServiceProxyOMS_Service();
            ServiceProxyOMS port = service.getServiceProxyOMSSOAP();
            
            //parametros de entrada
            TipoAccion tipoOperacion = TipoAccion.ADICIONAR;
            Producto producto = new Producto();
            producto.setDescripcion("nuevo producto");
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

}
