
package com.touresbalon.clientestouresbalon;

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
 *         &lt;element name="ActualizarClienteFault" type="{http://www.touresbalon.com/ClientesTouresBalon/}Error" minOccurs="0"/>
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
    "actualizarClienteFault"
})
@XmlRootElement(name = "ActualizarClienteFault")
public class ActualizarClienteFault {

    @XmlElement(name = "ActualizarClienteFault")
    protected Error actualizarClienteFault;

    /**
     * Gets the value of the actualizarClienteFault property.
     * 
     * @return
     *     possible object is
     *     {@link Error }
     *     
     */
    public Error getActualizarClienteFault() {
        return actualizarClienteFault;
    }

    /**
     * Sets the value of the actualizarClienteFault property.
     * 
     * @param value
     *     allowed object is
     *     {@link Error }
     *     
     */
    public void setActualizarClienteFault(Error value) {
        this.actualizarClienteFault = value;
    }

}
