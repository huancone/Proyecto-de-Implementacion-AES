
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
 *         &lt;element name="gestionTarifaFault" type="{http://www.example.org/ServiceProxyOMS/}Error"/>
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
    "gestionTarifaFault"
})
@XmlRootElement(name = "gestionTarifaFault")
public class GestionTarifaFault {

    @XmlElement(required = true)
    protected Error gestionTarifaFault;

    /**
     * Obtiene el valor de la propiedad gestionTarifaFault.
     * 
     * @return
     *     possible object is
     *     {@link Error }
     *     
     */
    public Error getGestionTarifaFault() {
        return gestionTarifaFault;
    }

    /**
     * Define el valor de la propiedad gestionTarifaFault.
     * 
     * @param value
     *     allowed object is
     *     {@link Error }
     *     
     */
    public void setGestionTarifaFault(Error value) {
        this.gestionTarifaFault = value;
    }

}
