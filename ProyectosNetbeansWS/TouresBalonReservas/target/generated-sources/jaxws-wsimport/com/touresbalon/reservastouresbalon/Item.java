
package com.touresbalon.reservastouresbalon;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para item complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="item">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idItem" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nombreItem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="precioItem" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="cantidad" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "item", propOrder = {
    "idItem",
    "nombreItem",
    "precioItem",
    "cantidad"
})
public class Item {

    protected Integer idItem;
    protected String nombreItem;
    protected Double precioItem;
    protected Integer cantidad;

    /**
     * Obtiene el valor de la propiedad idItem.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdItem() {
        return idItem;
    }

    /**
     * Define el valor de la propiedad idItem.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdItem(Integer value) {
        this.idItem = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreItem.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreItem() {
        return nombreItem;
    }

    /**
     * Define el valor de la propiedad nombreItem.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreItem(String value) {
        this.nombreItem = value;
    }

    /**
     * Obtiene el valor de la propiedad precioItem.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPrecioItem() {
        return precioItem;
    }

    /**
     * Define el valor de la propiedad precioItem.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPrecioItem(Double value) {
        this.precioItem = value;
    }

    /**
     * Obtiene el valor de la propiedad cantidad.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * Define el valor de la propiedad cantidad.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCantidad(Integer value) {
        this.cantidad = value;
    }

}
