
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
 *         &lt;element name="ConsultarPorIdentificacionClienteFault" type="{http://www.touresbalon.com/ClientesTouresBalon/}Error" minOccurs="0"/>
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
    "consultarPorIdentificacionClienteFault"
})
@XmlRootElement(name = "ConsultarPorIdentificacionClienteFault")
public class ConsultarPorIdentificacionClienteFault {

    @XmlElement(name = "ConsultarPorIdentificacionClienteFault")
    protected Error consultarPorIdentificacionClienteFault;

    /**
     * Obtiene el valor de la propiedad consultarPorIdentificacionClienteFault.
     * 
     * @return
     *     possible object is
     *     {@link Error }
     *     
     */
    public Error getConsultarPorIdentificacionClienteFault() {
        return consultarPorIdentificacionClienteFault;
    }

    /**
     * Define el valor de la propiedad consultarPorIdentificacionClienteFault.
     * 
     * @param value
     *     allowed object is
     *     {@link Error }
     *     
     */
    public void setConsultarPorIdentificacionClienteFault(Error value) {
        this.consultarPorIdentificacionClienteFault = value;
    }

}
