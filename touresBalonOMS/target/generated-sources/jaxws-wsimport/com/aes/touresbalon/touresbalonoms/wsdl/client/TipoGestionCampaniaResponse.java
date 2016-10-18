
package com.aes.touresbalon.touresbalonoms.wsdl.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TipoGestionCampaniaResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TipoGestionCampaniaResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="respuesta" type="{http://www.example.org/ServiceProxyOMS/}RespuestaGenerica"/>
 *         &lt;element name="id_campania" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipoGestionCampaniaResponse", propOrder = {
    "respuesta",
    "idCampania"
})
public class TipoGestionCampaniaResponse {

    @XmlElement(required = true)
    protected RespuestaGenerica respuesta;
    @XmlElement(name = "id_campania")
    protected Integer idCampania;

    /**
     * Gets the value of the respuesta property.
     * 
     * @return
     *     possible object is
     *     {@link RespuestaGenerica }
     *     
     */
    public RespuestaGenerica getRespuesta() {
        return respuesta;
    }

    /**
     * Sets the value of the respuesta property.
     * 
     * @param value
     *     allowed object is
     *     {@link RespuestaGenerica }
     *     
     */
    public void setRespuesta(RespuestaGenerica value) {
        this.respuesta = value;
    }

    /**
     * Gets the value of the idCampania property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdCampania() {
        return idCampania;
    }

    /**
     * Sets the value of the idCampania property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdCampania(Integer value) {
        this.idCampania = value;
    }

}
