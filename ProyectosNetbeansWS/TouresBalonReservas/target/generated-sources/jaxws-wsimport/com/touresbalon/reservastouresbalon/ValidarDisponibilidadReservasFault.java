
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
 *         &lt;element name="ValidarDisponibilidadReservasFault" type="{http://www.touresbalon.com/ReservasTouresBalon/}Error" minOccurs="0"/>
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
    "validarDisponibilidadReservasFault"
})
@XmlRootElement(name = "ValidarDisponibilidadReservasFault")
public class ValidarDisponibilidadReservasFault {

    @XmlElement(name = "ValidarDisponibilidadReservasFault")
    protected Error validarDisponibilidadReservasFault;

    /**
     * Obtiene el valor de la propiedad validarDisponibilidadReservasFault.
     * 
     * @return
     *     possible object is
     *     {@link Error }
     *     
     */
    public Error getValidarDisponibilidadReservasFault() {
        return validarDisponibilidadReservasFault;
    }

    /**
     * Define el valor de la propiedad validarDisponibilidadReservasFault.
     * 
     * @param value
     *     allowed object is
     *     {@link Error }
     *     
     */
    public void setValidarDisponibilidadReservasFault(Error value) {
        this.validarDisponibilidadReservasFault = value;
    }

}
