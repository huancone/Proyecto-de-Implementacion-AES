
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
 *         &lt;element name="ConsultarCampaniaProductoFault" type="{http://www.touresbalon.com/ProductosTouresBalon/}Error" minOccurs="0"/>
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
    "consultarCampaniaProductoFault"
})
@XmlRootElement(name = "ConsultarCampaniaProductoFault")
public class ConsultarCampaniaProductoFault {

    @XmlElement(name = "ConsultarCampaniaProductoFault")
    protected Error consultarCampaniaProductoFault;

    /**
     * Obtiene el valor de la propiedad consultarCampaniaProductoFault.
     * 
     * @return
     *     possible object is
     *     {@link Error }
     *     
     */
    public Error getConsultarCampaniaProductoFault() {
        return consultarCampaniaProductoFault;
    }

    /**
     * Define el valor de la propiedad consultarCampaniaProductoFault.
     * 
     * @param value
     *     allowed object is
     *     {@link Error }
     *     
     */
    public void setConsultarCampaniaProductoFault(Error value) {
        this.consultarCampaniaProductoFault = value;
    }

}
