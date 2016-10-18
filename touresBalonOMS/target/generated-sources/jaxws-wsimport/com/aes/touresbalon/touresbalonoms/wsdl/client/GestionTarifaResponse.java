
package com.aes.touresbalon.touresbalonoms.wsdl.client;

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
 *         &lt;element name="respuesta" type="{http://www.example.org/ServiceProxyOMS/}TipoGestionTarifaResponse"/>
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
    "respuesta"
})
@XmlRootElement(name = "gestionTarifaResponse")
public class GestionTarifaResponse {

    @XmlElement(required = true)
    protected TipoGestionTarifaResponse respuesta;

    /**
     * Gets the value of the respuesta property.
     * 
     * @return
     *     possible object is
     *     {@link TipoGestionTarifaResponse }
     *     
     */
    public TipoGestionTarifaResponse getRespuesta() {
        return respuesta;
    }

    /**
     * Sets the value of the respuesta property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoGestionTarifaResponse }
     *     
     */
    public void setRespuesta(TipoGestionTarifaResponse value) {
        this.respuesta = value;
    }

}
