
package com.touresbalon.clientestouresbalon;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "ConsultarPorFactRangoClienteFault", targetNamespace = "http://www.touresbalon.com/ClientesTouresBalon/")
public class ConsultarPorFactRangoClienteFault_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private ConsultarPorFactRangoClienteFault faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public ConsultarPorFactRangoClienteFault_Exception(String message, ConsultarPorFactRangoClienteFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public ConsultarPorFactRangoClienteFault_Exception(String message, ConsultarPorFactRangoClienteFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.touresbalon.clientestouresbalon.ConsultarPorFactRangoClienteFault
     */
    public ConsultarPorFactRangoClienteFault getFaultInfo() {
        return faultInfo;
    }

}
