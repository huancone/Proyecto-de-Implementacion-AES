<<<<<<< Updated upstream

package com.touresbalon.clientestouresbalon;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "ClientesTouresBalon", targetNamespace = "http://www.touresbalon.com/ClientesTouresBalon/", wsdlLocation = "file:/D:/Documents/GitHub/Proyecto-de-Implementacion-AES/ProyectosNetbeansWS/TouresBalonClientesWS/src/wsdl/ClientesTouresBalon.wsdl")
public class ClientesTouresBalon_Service
    extends Service
{

    private final static URL CLIENTESTOURESBALON_WSDL_LOCATION;
    private final static WebServiceException CLIENTESTOURESBALON_EXCEPTION;
    private final static QName CLIENTESTOURESBALON_QNAME = new QName("http://www.touresbalon.com/ClientesTouresBalon/", "ClientesTouresBalon");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/D:/Documents/GitHub/Proyecto-de-Implementacion-AES/ProyectosNetbeansWS/TouresBalonClientesWS/src/wsdl/ClientesTouresBalon.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CLIENTESTOURESBALON_WSDL_LOCATION = url;
        CLIENTESTOURESBALON_EXCEPTION = e;
    }

    public ClientesTouresBalon_Service() {
        super(__getWsdlLocation(), CLIENTESTOURESBALON_QNAME);
    }

    public ClientesTouresBalon_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), CLIENTESTOURESBALON_QNAME, features);
    }

    public ClientesTouresBalon_Service(URL wsdlLocation) {
        super(wsdlLocation, CLIENTESTOURESBALON_QNAME);
    }

    public ClientesTouresBalon_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CLIENTESTOURESBALON_QNAME, features);
    }

    public ClientesTouresBalon_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ClientesTouresBalon_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * Version 0.1
     * 
     * @return
     *     returns ClientesTouresBalon
     */
    @WebEndpoint(name = "ClientesTouresBalonSOAP")
    public ClientesTouresBalon getClientesTouresBalonSOAP() {
        return super.getPort(new QName("http://www.touresbalon.com/ClientesTouresBalon/", "ClientesTouresBalonSOAP"), ClientesTouresBalon.class);
    }

    /**
     * Version 0.1
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ClientesTouresBalon
     */
    @WebEndpoint(name = "ClientesTouresBalonSOAP")
    public ClientesTouresBalon getClientesTouresBalonSOAP(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.touresbalon.com/ClientesTouresBalon/", "ClientesTouresBalonSOAP"), ClientesTouresBalon.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CLIENTESTOURESBALON_EXCEPTION!= null) {
            throw CLIENTESTOURESBALON_EXCEPTION;
        }
        return CLIENTESTOURESBALON_WSDL_LOCATION;
    }

}
=======

package com.touresbalon.clientestouresbalon;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "ClientesTouresBalon", targetNamespace = "http://www.touresbalon.com/ClientesTouresBalon/", wsdlLocation = "file:/Users/jdtrujillop/GitHub/Proyecto-de-Implementacion-AES/ProyectosNetbeansWS/TouresBalonClientesWS/src/wsdl/ClientesTouresBalon.wsdl")
public class ClientesTouresBalon_Service
    extends Service
{

    private final static URL CLIENTESTOURESBALON_WSDL_LOCATION;
    private final static WebServiceException CLIENTESTOURESBALON_EXCEPTION;
    private final static QName CLIENTESTOURESBALON_QNAME = new QName("http://www.touresbalon.com/ClientesTouresBalon/", "ClientesTouresBalon");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/Users/jdtrujillop/GitHub/Proyecto-de-Implementacion-AES/ProyectosNetbeansWS/TouresBalonClientesWS/src/wsdl/ClientesTouresBalon.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CLIENTESTOURESBALON_WSDL_LOCATION = url;
        CLIENTESTOURESBALON_EXCEPTION = e;
    }

    public ClientesTouresBalon_Service() {
        super(__getWsdlLocation(), CLIENTESTOURESBALON_QNAME);
    }

    public ClientesTouresBalon_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), CLIENTESTOURESBALON_QNAME, features);
    }

    public ClientesTouresBalon_Service(URL wsdlLocation) {
        super(wsdlLocation, CLIENTESTOURESBALON_QNAME);
    }

    public ClientesTouresBalon_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CLIENTESTOURESBALON_QNAME, features);
    }

    public ClientesTouresBalon_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ClientesTouresBalon_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * Version 0.1
     * 
     * @return
     *     returns ClientesTouresBalon
     */
    @WebEndpoint(name = "ClientesTouresBalonSOAP")
    public ClientesTouresBalon getClientesTouresBalonSOAP() {
        return super.getPort(new QName("http://www.touresbalon.com/ClientesTouresBalon/", "ClientesTouresBalonSOAP"), ClientesTouresBalon.class);
    }

    /**
     * Version 0.1
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ClientesTouresBalon
     */
    @WebEndpoint(name = "ClientesTouresBalonSOAP")
    public ClientesTouresBalon getClientesTouresBalonSOAP(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.touresbalon.com/ClientesTouresBalon/", "ClientesTouresBalonSOAP"), ClientesTouresBalon.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CLIENTESTOURESBALON_EXCEPTION!= null) {
            throw CLIENTESTOURESBALON_EXCEPTION;
        }
        return CLIENTESTOURESBALON_WSDL_LOCATION;
    }

}
>>>>>>> Stashed changes
