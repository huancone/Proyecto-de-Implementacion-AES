
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
 *         &lt;element name="tipo_operacion" type="{http://www.touresbalon.com/ProductosTouresBalon/}TipoConsultaProducto"/>
 *         &lt;element name="campania" type="{http://www.touresbalon.com/ProductosTouresBalon/}Campania" minOccurs="0"/>
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
    "campania"
})
@XmlRootElement(name = "GestionCampaniaProducto")
public class GestionCampaniaProducto {

    @XmlElement(name = "tipo_operacion", required = true)
    protected TipoConsultaProducto tipoOperacion;
    protected Campania campania;

    /**
     * Obtiene el valor de la propiedad tipoOperacion.
     * 
     * @return
     *     possible object is
     *     {@link TipoConsultaProducto }
     *     
     */
    public TipoConsultaProducto getTipoOperacion() {
        return tipoOperacion;
    }

    /**
     * Define el valor de la propiedad tipoOperacion.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoConsultaProducto }
     *     
     */
    public void setTipoOperacion(TipoConsultaProducto value) {
        this.tipoOperacion = value;
    }

    /**
     * Obtiene el valor de la propiedad campania.
     * 
     * @return
     *     possible object is
     *     {@link Campania }
     *     
     */
    public Campania getCampania() {
        return campania;
    }

    /**
     * Define el valor de la propiedad campania.
     * 
     * @param value
     *     allowed object is
     *     {@link Campania }
     *     
     */
    public void setCampania(Campania value) {
        this.campania = value;
    }

}
