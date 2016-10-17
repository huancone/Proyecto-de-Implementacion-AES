
package com.aes.touresbalon.touresbalonoms.wsdl.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ordenes_cerradas" type="{http://www.example.org/ServiceProxyOMS/}RespuestaOrdenCerrada"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "ordenesCerradas"
})
@XmlRootElement(name = "consultarRangoCerradoOrdenesResponse")
public class ConsultarRangoCerradoOrdenesResponse {

    @XmlElement(name = "ordenes_cerradas", required = true)
    protected RespuestaOrdenCerrada ordenesCerradas;

    /**
     * Gets the value of the ordenesCerradas property.
     * 
     * @return
     *     possible object is
     *     {@link RespuestaOrdenCerrada }
     *     
     */
    public RespuestaOrdenCerrada getOrdenesCerradas() {
        return ordenesCerradas;
    }

    /**
     * Sets the value of the ordenesCerradas property.
     * 
     * @param value
     *     allowed object is
     *     {@link RespuestaOrdenCerrada }
     *     
     */
    public void setOrdenesCerradas(RespuestaOrdenCerrada value) {
        this.ordenesCerradas = value;
    }

}
