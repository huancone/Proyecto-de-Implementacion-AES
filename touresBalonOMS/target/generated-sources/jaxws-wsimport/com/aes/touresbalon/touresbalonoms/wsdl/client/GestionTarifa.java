
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
 *         &lt;element name="tipo_operacion" type="{http://www.example.org/ServiceProxyOMS/}TipoAccion"/>
 *         &lt;element name="tipo_tarifa" type="{http://www.example.org/ServiceProxyOMS/}TipoTarifa"/>
 *         &lt;element name="tarifa" type="{http://www.example.org/ServiceProxyOMS/}TarifaValores"/>
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
@XmlRootElement(name = "gestionTarifa")
public class GestionTarifa {

    @XmlElement(name = "tipo_operacion", required = true)
    protected TipoAccion tipoOperacion;
    @XmlElement(name = "tipo_tarifa", required = true)
    protected TipoTarifa tipoTarifa;
    @XmlElement(required = true)
    protected TarifaValores tarifa;

    /**
     * Obtiene el valor de la propiedad tipoOperacion.
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
     * Define el valor de la propiedad tipoOperacion.
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
     * Obtiene el valor de la propiedad tipoTarifa.
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
     * Define el valor de la propiedad tipoTarifa.
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
     * Obtiene el valor de la propiedad tarifa.
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
     * Define el valor de la propiedad tarifa.
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
