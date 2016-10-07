
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
 *         &lt;element name="consultarRankingAbiertasOrdenesFault" type="{http://www.example.org/ServiceProxyOMS/}Error"/>
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
    "consultarRankingAbiertasOrdenesFault"
})
@XmlRootElement(name = "consultarRankingAbiertasOrdenesFault")
public class ConsultarRankingAbiertasOrdenesFault {

    @XmlElement(required = true)
    protected Error consultarRankingAbiertasOrdenesFault;

    /**
     * Obtiene el valor de la propiedad consultarRankingAbiertasOrdenesFault.
     * 
     * @return
     *     possible object is
     *     {@link Error }
     *     
     */
    public Error getConsultarRankingAbiertasOrdenesFault() {
        return consultarRankingAbiertasOrdenesFault;
    }

    /**
     * Define el valor de la propiedad consultarRankingAbiertasOrdenesFault.
     * 
     * @param value
     *     allowed object is
     *     {@link Error }
     *     
     */
    public void setConsultarRankingAbiertasOrdenesFault(Error value) {
        this.consultarRankingAbiertasOrdenesFault = value;
    }

}
