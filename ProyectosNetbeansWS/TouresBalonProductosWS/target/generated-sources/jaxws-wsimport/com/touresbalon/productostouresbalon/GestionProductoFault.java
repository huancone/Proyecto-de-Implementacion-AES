
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
 *         &lt;element name="GestionProductoFault" type="{http://www.touresbalon.com/ProductosTouresBalon/}Error" minOccurs="0"/>
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
    "gestionProductoFault"
})
@XmlRootElement(name = "GestionProductoFault")
public class GestionProductoFault {

    @XmlElement(name = "GestionProductoFault")
    protected Error gestionProductoFault;

    /**
     * Obtiene el valor de la propiedad gestionProductoFault.
     * 
     * @return
     *     possible object is
     *     {@link Error }
     *     
     */
    public Error getGestionProductoFault() {
        return gestionProductoFault;
    }

    /**
     * Define el valor de la propiedad gestionProductoFault.
     * 
     * @param value
     *     allowed object is
     *     {@link Error }
     *     
     */
    public void setGestionProductoFault(Error value) {
        this.gestionProductoFault = value;
    }

}
