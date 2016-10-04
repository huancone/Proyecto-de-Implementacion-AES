
package com.touresbalon.productostouresbalon;

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
 *         &lt;element name="gestioncampaniaResponse" type="{http://www.touresbalon.com/ProductosTouresBalon/}TipoGestionCampaniaResponse"/>
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
@XmlRootElement(name = "GestionCampaniaProductoResponse")
public class GestionCampaniaProductoResponse {

    @XmlElement(required = true)
    protected TipoGestionCampaniaResponse gestioncampaniaResponse;

    /**
     * Obtiene el valor de la propiedad gestioncampaniaResponse.
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
     * Define el valor de la propiedad gestioncampaniaResponse.
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
