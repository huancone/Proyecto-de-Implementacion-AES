
package com.touresbalon.productostouresbalon;

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
 *         &lt;element name="gestion_producto_reponse" type="{http://www.touresbalon.com/ProductosTouresBalon/}TipoGestionProductoResponse"/>
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
@XmlRootElement(name = "GestionProductoResponse")
public class GestionProductoResponse {

    @XmlElement(name = "gestion_producto_reponse", required = true)
    protected TipoGestionProductoResponse gestionProductoReponse;

    /**
     * Gets the value of the gestionProductoReponse property.
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
     * Sets the value of the gestionProductoReponse property.
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
