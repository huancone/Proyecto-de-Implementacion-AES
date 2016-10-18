
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
 *         &lt;element name="gestioncampaniaResponse" type="{http://www.example.org/ServiceProxyOMS/}TipoGestionCampaniaResponse"/>
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
    "gestioncampaniaResponse"
})
@XmlRootElement(name = "gestionCampaniaProductoResponse")
public class GestionCampaniaProductoResponse {

    @XmlElement(required = true)
    protected TipoGestionCampaniaResponse gestioncampaniaResponse;

    /**
     * Gets the value of the gestioncampaniaResponse property.
     * 
     * @return
     *     possible object is
     *     {@link TipoGestionCampaniaResponse }
     *     
     */
    public TipoGestionCampaniaResponse getGestioncampaniaResponse() {
        return gestioncampaniaResponse;
    }

    /**
     * Sets the value of the gestioncampaniaResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoGestionCampaniaResponse }
     *     
     */
    public void setGestioncampaniaResponse(TipoGestionCampaniaResponse value) {
        this.gestioncampaniaResponse = value;
    }

}
