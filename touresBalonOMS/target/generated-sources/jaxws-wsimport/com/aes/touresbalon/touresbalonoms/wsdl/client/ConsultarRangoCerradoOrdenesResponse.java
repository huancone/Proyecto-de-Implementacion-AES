
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
 *         &lt;element name="ordenes_cerradas" type="{http://www.example.org/ServiceProxyOMS/}RespuestaOrdenCerrada"/>
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
    "ordenesCerradas"
})
@XmlRootElement(name = "consultarRangoCerradoOrdenesResponse")
public class ConsultarRangoCerradoOrdenesResponse {

    @XmlElement(name = "ordenes_cerradas", required = true)
    protected RespuestaOrdenCerrada ordenesCerradas;

    /**
     * Obtiene el valor de la propiedad ordenesCerradas.
     * 
     * @return
     *     possible object is
     *     {@link RespuestaOrdenCerrada }
     *     
     */
    public RespuestaOrdenCerrada getOrdenesCerradas() {
        return ordenesCerradas;
    }

    /**
     * Define el valor de la propiedad ordenesCerradas.
     * 
     * @param value
     *     allowed object is
     *     {@link RespuestaOrdenCerrada }
     *     
     */
    public void setOrdenesCerradas(RespuestaOrdenCerrada value) {
        this.ordenesCerradas = value;
    }

}
