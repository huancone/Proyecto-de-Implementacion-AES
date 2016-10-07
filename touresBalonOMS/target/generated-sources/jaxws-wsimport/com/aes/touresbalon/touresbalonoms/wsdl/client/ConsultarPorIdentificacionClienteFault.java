
package com.aes.touresbalon.touresbalonoms.wsdl.client;

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
 *         &lt;element name="consultarPorIdentificacionClienteFault" type="{http://www.example.org/ServiceProxyOMS/}Error"/>
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
@XmlRootElement(name = "consultarPorIdentificacionClienteFault")
public class ConsultarPorIdentificacionClienteFault {

    @XmlElement(required = true)
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
