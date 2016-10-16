
package com.touresbalon.productostouresbalon;

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
 *         &lt;element name="ConsultarRankingFechaProductoFault" type="{http://www.touresbalon.com/ProductosTouresBalon/}Error" minOccurs="0"/>
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
    "consultarRankingFechaProductoFault"
})
@XmlRootElement(name = "ConsultarRankingFechaProductoFault")
public class ConsultarRankingFechaProductoFault {

    @XmlElement(name = "ConsultarRankingFechaProductoFault")
    protected Error consultarRankingFechaProductoFault;

    /**
     * Gets the value of the consultarRankingFechaProductoFault property.
     * 
     * @return
     *     possible object is
     *     {@link Error }
     *     
     */
    public Error getConsultarRankingFechaProductoFault() {
        return consultarRankingFechaProductoFault;
    }

    /**
     * Sets the value of the consultarRankingFechaProductoFault property.
     * 
     * @param value
     *     allowed object is
     *     {@link Error }
     *     
     */
    public void setConsultarRankingFechaProductoFault(Error value) {
        this.consultarRankingFechaProductoFault = value;
    }

}
