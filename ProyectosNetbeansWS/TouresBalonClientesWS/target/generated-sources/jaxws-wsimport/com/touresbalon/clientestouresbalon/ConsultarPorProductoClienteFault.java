
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
 *         &lt;element name="ConsultarPorProductoClienteFault" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "consultarPorProductoClienteFault"
})
@XmlRootElement(name = "ConsultarPorProductoClienteFault")
public class ConsultarPorProductoClienteFault {

    @XmlElement(name = "ConsultarPorProductoClienteFault")
    protected String consultarPorProductoClienteFault;

    /**
     * Obtiene el valor de la propiedad consultarPorProductoClienteFault.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConsultarPorProductoClienteFault() {
        return consultarPorProductoClienteFault;
    }

    /**
     * Define el valor de la propiedad consultarPorProductoClienteFault.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConsultarPorProductoClienteFault(String value) {
        this.consultarPorProductoClienteFault = value;
    }

}
