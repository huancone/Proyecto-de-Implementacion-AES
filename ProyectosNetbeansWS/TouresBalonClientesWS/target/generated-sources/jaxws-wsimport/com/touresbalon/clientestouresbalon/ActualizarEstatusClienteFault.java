
package com.touresbalon.clientestouresbalon;

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
 *         &lt;element name="ActualizarEstatusClienteFault" type="{http://www.touresbalon.com/ClientesTouresBalon/}Error" minOccurs="0"/>
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
    "actualizarEstatusClienteFault"
})
@XmlRootElement(name = "ActualizarEstatusClienteFault")
public class ActualizarEstatusClienteFault {

    @XmlElement(name = "ActualizarEstatusClienteFault")
    protected Error actualizarEstatusClienteFault;

    /**
     * Obtiene el valor de la propiedad actualizarEstatusClienteFault.
     * 
     * @return
     *     possible object is
     *     {@link Error }
     *     
     */
    public Error getActualizarEstatusClienteFault() {
        return actualizarEstatusClienteFault;
    }

    /**
     * Define el valor de la propiedad actualizarEstatusClienteFault.
     * 
     * @param value
     *     allowed object is
     *     {@link Error }
     *     
     */
    public void setActualizarEstatusClienteFault(Error value) {
        this.actualizarEstatusClienteFault = value;
    }

}