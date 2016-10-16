
package com.touresbalon.productostouresbalon;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TipoGestionTarifaResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TipoGestionTarifaResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="respuesta" type="{http://www.touresbalon.com/ProductosTouresBalon/}RespuestaGenerica"/>
 *         &lt;element name="tarifa" type="{http://www.touresbalon.com/ProductosTouresBalon/}TipoTarifa"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipoGestionTarifaResponse", propOrder = {
    "respuesta",
    "tarifa"
})
public class TipoGestionTarifaResponse {

    @XmlElement(required = true)
    protected RespuestaGenerica respuesta;
    @XmlElement(required = true)
    protected TipoTarifa tarifa;

    /**
     * Gets the value of the respuesta property.
     * 
     * @return
     *     possible object is
     *     {@link RespuestaGenerica }
     *     
     */
    public RespuestaGenerica getRespuesta() {
        return respuesta;
    }

    /**
     * Sets the value of the respuesta property.
     * 
     * @param value
     *     allowed object is
     *     {@link RespuestaGenerica }
     *     
     */
    public void setRespuesta(RespuestaGenerica value) {
        this.respuesta = value;
    }

    /**
     * Gets the value of the tarifa property.
     * 
     * @return
     *     possible object is
     *     {@link TipoTarifa }
     *     
     */
    public TipoTarifa getTarifa() {
        return tarifa;
    }

    /**
     * Sets the value of the tarifa property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoTarifa }
     *     
     */
    public void setTarifa(TipoTarifa value) {
        this.tarifa = value;
    }

}
