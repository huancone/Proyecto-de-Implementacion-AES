
package com.touresbalon.reservastouresbalon;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ReservarProductosFault" type="{http://www.touresbalon.com/ReservasTouresBalon/}Error" minOccurs="0"/>
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
    "reservarProductosFault"
})
@XmlRootElement(name = "ReservarProductosFault")
public class ReservarProductosFault {

    @XmlElement(name = "ReservarProductosFault")
    protected Error reservarProductosFault;

    /**
     * Obtiene el valor de la propiedad reservarProductosFault.
     * 
     * @return
     *     possible object is
     *     {@link Error }
     *     
     */
    public Error getReservarProductosFault() {
        return reservarProductosFault;
    }

    /**
     * Define el valor de la propiedad reservarProductosFault.
     * 
     * @param value
     *     allowed object is
     *     {@link Error }
     *     
     */
    public void setReservarProductosFault(Error value) {
        this.reservarProductosFault = value;
    }

}
