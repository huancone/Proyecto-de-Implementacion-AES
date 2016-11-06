/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aes.touresbalon.touresbalonoms.services;

import com.aes.touresbalon.touresbalonoms.wsdl.client.Campania;
import com.aes.touresbalon.touresbalonoms.wsdl.client.ServiceProxyOMS;
import com.aes.touresbalon.touresbalonoms.wsdl.client.ServiceProxyOMS_Service;
import com.aes.touresbalon.touresbalonoms.wsdl.client.TipoAccion;
import javax.xml.ws.BindingProvider;

/**
 *
 * @author alexanderbarbosaayala
 */
public class CampannaService {
    
    public void crearCampanna(){
        //conf del servicio
        ServiceProxyOMS_Service service = new ServiceProxyOMS_Service();
        ServiceProxyOMS port = service.getServiceProxyOMSSOAP();
        
        //parametros de entrada
        TipoAccion tipoOperacion = TipoAccion.ADICIONAR;
        Campania campania = new Campania();
        String endpointURL = "http://localhost:8080/mockServiceProxyOMSSOAP";        
        BindingProvider bp = (BindingProvider) port;
        bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointURL);
        

    }
    
    public void editarCampanna(){
        //conf del servicio
        ServiceProxyOMS_Service service = new ServiceProxyOMS_Service();
        ServiceProxyOMS port = service.getServiceProxyOMSSOAP();
        
        //parametros de entrada
        TipoAccion tipoOperacion = TipoAccion.MODIFICAR;
        Campania campania = new Campania();
        String endpointURL = "http://localhost:8080/mockServiceProxyOMSSOAP";        
        BindingProvider bp = (BindingProvider) port;
        bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointURL);
        

    }
}
