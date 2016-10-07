
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
 *         &lt;element name="gestion_producto_reponse" type="{http://www.example.org/ServiceProxyOMS/}TipoGestionProductoResponse"/>
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
    "gestionProductoReponse"
})
@XmlRootElement(name = "gestionProductoResponse")
public class GestionProductoResponse {

    @XmlElement(name = "gestion_producto_reponse", required = true)
    protected TipoGestionProductoResponse gestionProductoReponse;

    /**
     * Obtiene el valor de la propiedad gestionProductoReponse.
     * 
     * @return
     *     possible object is
     *     {@link TipoGestionProductoResponse }
     *     
     */
    public TipoGestionProductoResponse getGestionProductoReponse() {
        return gestionProductoReponse;
    }

    /**
     * Define el valor de la propiedad gestionProductoReponse.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoGestionProductoResponse }
     *     
     */
    public void setGestionProductoReponse(TipoGestionProductoResponse value) {
        this.gestionProductoReponse = value;
    }

}
