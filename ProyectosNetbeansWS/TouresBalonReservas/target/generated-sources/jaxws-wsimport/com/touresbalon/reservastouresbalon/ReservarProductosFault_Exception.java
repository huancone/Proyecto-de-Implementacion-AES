
package com.touresbalon.reservastouresbalon;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "ReservarProductosFault", targetNamespace = "http://www.touresbalon.com/ReservasTouresBalon/")
public class ReservarProductosFault_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private ReservarProductosFault faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public ReservarProductosFault_Exception(String message, ReservarProductosFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public ReservarProductosFault_Exception(String message, ReservarProductosFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.touresbalon.reservastouresbalon.ReservarProductosFault
     */
    public ReservarProductosFault getFaultInfo() {
        return faultInfo;
    }

}
