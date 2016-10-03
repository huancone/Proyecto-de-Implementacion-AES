
package com.touresbalon.clientestouresbalon;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "ActualizarEstatusClienteFault", targetNamespace = "http://www.touresbalon.com/ClientesTouresBalon/")
public class ActualizarEstatusClienteFault_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private ActualizarEstatusClienteFault faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public ActualizarEstatusClienteFault_Exception(String message, ActualizarEstatusClienteFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public ActualizarEstatusClienteFault_Exception(String message, ActualizarEstatusClienteFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.touresbalon.clientestouresbalon.ActualizarEstatusClienteFault
     */
    public ActualizarEstatusClienteFault getFaultInfo() {
        return faultInfo;
    }

}