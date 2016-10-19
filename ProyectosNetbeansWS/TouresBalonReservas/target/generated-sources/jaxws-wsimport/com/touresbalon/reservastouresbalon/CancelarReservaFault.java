
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
 *         &lt;element name="CancelarReservaFault" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "cancelarReservaFault"
})
@XmlRootElement(name = "CancelarReservaFault")
public class CancelarReservaFault {

    @XmlElement(name = "CancelarReservaFault", required = true)
    protected String cancelarReservaFault;

    /**
     * Obtiene el valor de la propiedad cancelarReservaFault.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCancelarReservaFault() {
        return cancelarReservaFault;
    }

    /**
     * Define el valor de la propiedad cancelarReservaFault.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCancelarReservaFault(String value) {
        this.cancelarReservaFault = value;
    }

}
