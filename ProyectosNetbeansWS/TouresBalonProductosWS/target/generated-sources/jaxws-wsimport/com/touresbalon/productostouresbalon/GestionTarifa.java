
package com.touresbalon.productostouresbalon;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tipo_operacion" type="{http://www.touresbalon.com/ProductosTouresBalon/}TipoAccion"/>
 *         &lt;element name="tipo_tarifa" type="{http://www.touresbalon.com/ProductosTouresBalon/}TipoTarifa"/>
 *         &lt;element name="tarifa" type="{http://www.touresbalon.com/ProductosTouresBalon/}TarifaValores"/>
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
    "tipoOperacion",
    "tipoTarifa",
    "tarifa"
})
@XmlRootElement(name = "GestionTarifa")
public class GestionTarifa {

    @XmlElement(name = "tipo_operacion", required = true)
    protected TipoAccion tipoOperacion;
    @XmlElement(name = "tipo_tarifa", required = true)
    protected TipoTarifa tipoTarifa;
    @XmlElement(required = true)
    protected TarifaValores tarifa;

    /**
     * Gets the value of the tipoOperacion property.
     * 
     * @return
     *     possible object is
     *     {@link TipoAccion }
     *     
     */
    public TipoAccion getTipoOperacion() {
        return tipoOperacion;
    }

    /**
     * Sets the value of the tipoOperacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoAccion }
     *     
     */
    public void setTipoOperacion(TipoAccion value) {
        this.tipoOperacion = value;
    }

    /**
     * Gets the value of the tipoTarifa property.
     * 
     * @return
     *     possible object is
     *     {@link TipoTarifa }
     *     
     */
    public TipoTarifa getTipoTarifa() {
        return tipoTarifa;
    }

    /**
     * Sets the value of the tipoTarifa property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoTarifa }
     *     
     */
    public void setTipoTarifa(TipoTarifa value) {
        this.tipoTarifa = value;
    }

    /**
     * Gets the value of the tarifa property.
     * 
     * @return
     *     possible object is
     *     {@link TarifaValores }
     *     
     */
    public TarifaValores getTarifa() {
        return tarifa;
    }

    /**
     * Sets the value of the tarifa property.
     * 
     * @param value
     *     allowed object is
     *     {@link TarifaValores }
     *     
     */
    public void setTarifa(TarifaValores value) {
        this.tarifa = value;
    }

}
