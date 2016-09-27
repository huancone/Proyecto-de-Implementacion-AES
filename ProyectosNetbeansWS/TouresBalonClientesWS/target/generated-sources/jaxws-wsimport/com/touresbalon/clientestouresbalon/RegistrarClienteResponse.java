
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
 *         &lt;element name="registrarClienteResponse" type="{http://www.touresbalon.com/ClientesTouresBalon/}RegistrarClienteReponseType"/>
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
    "registrarClienteResponse"
})
@XmlRootElement(name = "RegistrarClienteResponse")
public class RegistrarClienteResponse {

    @XmlElement(required = true)
    protected RegistrarClienteReponseType registrarClienteResponse;

    /**
     * Obtiene el valor de la propiedad registrarClienteResponse.
     * 
     * @return
     *     possible object is
     *     {@link RegistrarClienteReponseType }
     *     
     */
    public RegistrarClienteReponseType getRegistrarClienteResponse() {
        return registrarClienteResponse;
    }

    /**
     * Define el valor de la propiedad registrarClienteResponse.
     * 
     * @param value
     *     allowed object is
     *     {@link RegistrarClienteReponseType }
     *     
     */
    public void setRegistrarClienteResponse(RegistrarClienteReponseType value) {
        this.registrarClienteResponse = value;
    }

}
