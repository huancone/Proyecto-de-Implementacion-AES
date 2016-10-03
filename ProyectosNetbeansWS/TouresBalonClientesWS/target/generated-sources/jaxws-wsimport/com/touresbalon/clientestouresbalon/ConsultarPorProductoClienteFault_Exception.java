
package com.touresbalon.clientestouresbalon;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "ConsultarPorProductoClienteFault", targetNamespace = "http://www.touresbalon.com/ClientesTouresBalon/")
public class ConsultarPorProductoClienteFault_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private ConsultarPorProductoClienteFault faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public ConsultarPorProductoClienteFault_Exception(String message, ConsultarPorProductoClienteFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public ConsultarPorProductoClienteFault_Exception(String message, ConsultarPorProductoClienteFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.touresbalon.clientestouresbalon.ConsultarPorProductoClienteFault
     */
    public ConsultarPorProductoClienteFault getFaultInfo() {
        return faultInfo;
    }

}