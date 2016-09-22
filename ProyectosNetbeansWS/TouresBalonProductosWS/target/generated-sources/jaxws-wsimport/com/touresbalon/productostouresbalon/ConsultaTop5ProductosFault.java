
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
 *         &lt;element name="ConsultaTop5ProductosFault" type="{http://www.touresbalon.com/ProductosTouresBalon/}Error" minOccurs="0"/>
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
    "consultaTop5ProductosFault"
})
@XmlRootElement(name = "ConsultaTop5ProductosFault")
public class ConsultaTop5ProductosFault {

    @XmlElement(name = "ConsultaTop5ProductosFault")
    protected Error consultaTop5ProductosFault;

    /**
     * Obtiene el valor de la propiedad consultaTop5ProductosFault.
     * 
     * @return
     *     possible object is
     *     {@link Error }
     *     
     */
    public Error getConsultaTop5ProductosFault() {
        return consultaTop5ProductosFault;
    }

    /**
     * Define el valor de la propiedad consultaTop5ProductosFault.
     * 
     * @param value
     *     allowed object is
     *     {@link Error }
     *     
     */
    public void setConsultaTop5ProductosFault(Error value) {
        this.consultaTop5ProductosFault = value;
    }

}
