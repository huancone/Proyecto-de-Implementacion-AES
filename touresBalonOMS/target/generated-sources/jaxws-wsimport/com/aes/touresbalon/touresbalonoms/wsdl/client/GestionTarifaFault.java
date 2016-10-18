
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
 *         &lt;element name="gestionTarifaFault" type="{http://www.example.org/ServiceProxyOMS/}Error"/>
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
    "gestionTarifaFault"
})
@XmlRootElement(name = "gestionTarifaFault")
public class GestionTarifaFault {

    @XmlElement(required = true)
    protected Error gestionTarifaFault;

    /**
     * Gets the value of the gestionTarifaFault property.
     * 
     * @return
     *     possible object is
     *     {@link Error }
     *     
     */
    public Error getGestionTarifaFault() {
        return gestionTarifaFault;
    }

    /**
     * Sets the value of the gestionTarifaFault property.
     * 
     * @param value
     *     allowed object is
     *     {@link Error }
     *     
     */
    public void setGestionTarifaFault(Error value) {
        this.gestionTarifaFault = value;
    }

}
