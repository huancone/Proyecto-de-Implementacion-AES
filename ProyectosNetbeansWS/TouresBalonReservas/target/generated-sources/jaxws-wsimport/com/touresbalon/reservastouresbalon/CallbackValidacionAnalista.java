
package com.touresbalon.reservastouresbalon;

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
 *         &lt;element name="idOrden" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="estatusOrden" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "idOrden",
    "estatusOrden"
})
@XmlRootElement(name = "CallbackValidacionAnalista")
public class CallbackValidacionAnalista {

    protected int idOrden;
    @XmlElement(required = true)
    protected String estatusOrden;

    /**
     * Obtiene el valor de la propiedad idOrden.
     * 
     */
    public int getIdOrden() {
        return idOrden;
    }

    /**
     * Define el valor de la propiedad idOrden.
     * 
     */
    public void setIdOrden(int value) {
        this.idOrden = value;
    }

    /**
     * Obtiene el valor de la propiedad estatusOrden.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstatusOrden() {
        return estatusOrden;
    }

    /**
     * Define el valor de la propiedad estatusOrden.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstatusOrden(String value) {
        this.estatusOrden = value;
    }

}
