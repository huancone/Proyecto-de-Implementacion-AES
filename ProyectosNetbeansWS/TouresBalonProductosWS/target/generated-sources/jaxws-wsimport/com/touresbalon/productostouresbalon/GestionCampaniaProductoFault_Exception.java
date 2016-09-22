
package com.touresbalon.productostouresbalon;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "GestionCampaniaProductoFault", targetNamespace = "http://www.touresbalon.com/ProductosTouresBalon/")
public class GestionCampaniaProductoFault_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private GestionCampaniaProductoFault faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public GestionCampaniaProductoFault_Exception(String message, GestionCampaniaProductoFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public GestionCampaniaProductoFault_Exception(String message, GestionCampaniaProductoFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.touresbalon.productostouresbalon.GestionCampaniaProductoFault
     */
    public GestionCampaniaProductoFault getFaultInfo() {
        return faultInfo;
    }

}
