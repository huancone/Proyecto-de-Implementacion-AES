
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
     * Obtiene el valor de la propiedad tipoConsulta.
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
     * Define el valor de la propiedad tipoConsulta.
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
     * Obtiene el valor de la propiedad cadenaConsulta.
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
     * Define el valor de la propiedad cadenaConsulta.
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
