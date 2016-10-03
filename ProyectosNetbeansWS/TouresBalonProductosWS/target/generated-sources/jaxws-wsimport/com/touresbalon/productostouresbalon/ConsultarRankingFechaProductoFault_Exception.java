
package com.touresbalon.productostouresbalon;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "ConsultarRankingFechaProductoFault", targetNamespace = "http://www.touresbalon.com/ProductosTouresBalon/")
public class ConsultarRankingFechaProductoFault_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private ConsultarRankingFechaProductoFault faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public ConsultarRankingFechaProductoFault_Exception(String message, ConsultarRankingFechaProductoFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public ConsultarRankingFechaProductoFault_Exception(String message, ConsultarRankingFechaProductoFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.touresbalon.productostouresbalon.ConsultarRankingFechaProductoFault
     */
    public ConsultarRankingFechaProductoFault getFaultInfo() {
        return faultInfo;
    }

}