
package com.aes.touresbalon.touresbalonoms.wsdl.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="consultarRankingCerradoOrdenesFault" type="{http://www.example.org/ServiceProxyOMS/}Error" minOccurs="0"/>
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
    "consultarRankingCerradoOrdenesFault"
})
@XmlRootElement(name = "consultarRankingCerradoOrdenesFault")
public class ConsultarRankingCerradoOrdenesFault {

    protected Error consultarRankingCerradoOrdenesFault;

    /**
     * Obtiene el valor de la propiedad consultarRankingCerradoOrdenesFault.
     * 
     * @return
     *     possible object is
     *     {@link Error }
     *     
     */
    public Error getConsultarRankingCerradoOrdenesFault() {
        return consultarRankingCerradoOrdenesFault;
    }

    /**
     * Define el valor de la propiedad consultarRankingCerradoOrdenesFault.
     * 
     * @param value
     *     allowed object is
     *     {@link Error }
     *     
     */
    public void setConsultarRankingCerradoOrdenesFault(Error value) {
        this.consultarRankingCerradoOrdenesFault = value;
    }

}
