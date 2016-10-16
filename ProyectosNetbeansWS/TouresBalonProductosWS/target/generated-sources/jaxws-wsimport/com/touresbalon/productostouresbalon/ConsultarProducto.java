
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
 *         &lt;element name="tipo_consulta" type="{http://www.touresbalon.com/ProductosTouresBalon/}TipoConsultaProducto"/>
 *         &lt;element name="cadena_consulta" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "tipoConsulta",
    "cadenaConsulta"
})
@XmlRootElement(name = "ConsultarProducto")
public class ConsultarProducto {

    @XmlElement(name = "tipo_consulta", required = true)
    protected TipoConsultaProducto tipoConsulta;
    @XmlElement(name = "cadena_consulta", required = true)
    protected String cadenaConsulta;

    /**
     * Gets the value of the tipoConsulta property.
     * 
     * @return
     *     possible object is
     *     {@link TipoConsultaProducto }
     *     
     */
    public TipoConsultaProducto getTipoConsulta() {
        return tipoConsulta;
    }

    /**
     * Sets the value of the tipoConsulta property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoConsultaProducto }
     *     
     */
    public void setTipoConsulta(TipoConsultaProducto value) {
        this.tipoConsulta = value;
    }

    /**
     * Gets the value of the cadenaConsulta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCadenaConsulta() {
        return cadenaConsulta;
    }

    /**
     * Sets the value of the cadenaConsulta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCadenaConsulta(String value) {
        this.cadenaConsulta = value;
    }

}
