
package com.aes.touresbalon.touresbalonoms.wsdl.client;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "consultarOrdenesFault", targetNamespace = "http://www.example.org/ServiceProxyOMS/")
public class ConsultarOrdenesFault_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private ConsultarOrdenesFault faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public ConsultarOrdenesFault_Exception(String message, ConsultarOrdenesFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public ConsultarOrdenesFault_Exception(String message, ConsultarOrdenesFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.aes.touresbalon.touresbalonoms.wsdl.client.ConsultarOrdenesFault
     */
    public ConsultarOrdenesFault getFaultInfo() {
        return faultInfo;
    }

}
