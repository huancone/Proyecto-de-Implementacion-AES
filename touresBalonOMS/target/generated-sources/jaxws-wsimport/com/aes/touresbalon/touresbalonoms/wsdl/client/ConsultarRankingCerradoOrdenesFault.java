
package com.aes.touresbalon.touresbalonoms.wsdl.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="consultarRankingCerradoOrdenesFault" type="{http://www.example.org/ServiceProxyOMS/}Error" minOccurs="0"/>
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
    "consultarRankingCerradoOrdenesFault"
})
@XmlRootElement(name = "consultarRankingCerradoOrdenesFault")
public class ConsultarRankingCerradoOrdenesFault {

    protected Error consultarRankingCerradoOrdenesFault;

    /**
     * Gets the value of the consultarRankingCerradoOrdenesFault property.
     * 
     * @return
     *     possible object is
     *     {@link Error }
     *     
     */
    public Error getConsultarRankingCerradoOrdenesFault() {
        return consultarRankingCerradoOrdenesFault;
    }

    /**
     * Sets the value of the consultarRankingCerradoOrdenesFault property.
     * 
     * @param value
     *     allowed object is
     *     {@link Error }
     *     
     */
    public void setConsultarRankingCerradoOrdenesFault(Error value) {
        this.consultarRankingCerradoOrdenesFault = value;
    }

}
