
package com.touresbalon.productostouresbalon;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "GestionProductoFault", targetNamespace = "http://www.touresbalon.com/ProductosTouresBalon/")
public class GestionProductoFault_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private GestionProductoFault faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public GestionProductoFault_Exception(String message, GestionProductoFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public GestionProductoFault_Exception(String message, GestionProductoFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.touresbalon.productostouresbalon.GestionProductoFault
     */
    public GestionProductoFault getFaultInfo() {
        return faultInfo;
    }

}
