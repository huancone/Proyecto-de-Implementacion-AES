
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
 *         &lt;element name="ActualizarContraseniaClienteFault" type="{http://www.touresbalon.com/ClientesTouresBalon/}Error" minOccurs="0"/>
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
    "actualizarContraseniaClienteFault"
})
@XmlRootElement(name = "ActualizarContraseniaClienteFault")
public class ActualizarContraseniaClienteFault {

    @XmlElement(name = "ActualizarContraseniaClienteFault")
    protected Error actualizarContraseniaClienteFault;

    /**
     * Gets the value of the actualizarContraseniaClienteFault property.
     * 
     * @return
     *     possible object is
     *     {@link Error }
     *     
     */
    public Error getActualizarContraseniaClienteFault() {
        return actualizarContraseniaClienteFault;
    }

    /**
     * Sets the value of the actualizarContraseniaClienteFault property.
     * 
     * @param value
     *     allowed object is
     *     {@link Error }
     *     
     */
    public void setActualizarContraseniaClienteFault(Error value) {
        this.actualizarContraseniaClienteFault = value;
    }

}
