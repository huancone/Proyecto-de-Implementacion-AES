
package com.touresbalon.productostouresbalon;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "ConsultarProductoFault", targetNamespace = "http://www.touresbalon.com/ProductosTouresBalon/")
public class ConsultarProductoFault_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private ConsultarProductoFault faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public ConsultarProductoFault_Exception(String message, ConsultarProductoFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public ConsultarProductoFault_Exception(String message, ConsultarProductoFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.touresbalon.productostouresbalon.ConsultarProductoFault
     */
    public ConsultarProductoFault getFaultInfo() {
        return faultInfo;
    }

}
