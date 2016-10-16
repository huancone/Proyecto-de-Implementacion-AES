
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
 *         &lt;element name="ConsultarPorEspectaculoProductoFault" type="{http://www.touresbalon.com/ProductosTouresBalon/}Error" minOccurs="0"/>
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
    "consultarPorEspectaculoProductoFault"
})
@XmlRootElement(name = "ConsultarPorEspectaculoProductoFault")
public class ConsultarPorEspectaculoProductoFault {

    @XmlElement(name = "ConsultarPorEspectaculoProductoFault")
    protected Error consultarPorEspectaculoProductoFault;

    /**
     * Gets the value of the consultarPorEspectaculoProductoFault property.
     * 
     * @return
     *     possible object is
     *     {@link Error }
     *     
     */
    public Error getConsultarPorEspectaculoProductoFault() {
        return consultarPorEspectaculoProductoFault;
    }

    /**
     * Sets the value of the consultarPorEspectaculoProductoFault property.
     * 
     * @param value
     *     allowed object is
     *     {@link Error }
     *     
     */
    public void setConsultarPorEspectaculoProductoFault(Error value) {
        this.consultarPorEspectaculoProductoFault = value;
    }

}
