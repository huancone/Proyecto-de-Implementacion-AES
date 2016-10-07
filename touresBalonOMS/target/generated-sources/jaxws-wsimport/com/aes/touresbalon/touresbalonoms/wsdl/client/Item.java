
package com.aes.touresbalon.touresbalonoms.wsdl.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Item complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Item">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id_item" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="id_prod" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nombre_prod" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="part_num" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="precio" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="cantidad" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="id_orden" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Item", propOrder = {
    "idItem",
    "idProd",
    "nombreProd",
    "partNum",
    "precio",
    "cantidad",
    "idOrden"
})
public class Item {

    @XmlElement(name = "id_item")
    protected int idItem;
    @XmlElement(name = "id_prod")
    protected int idProd;
    @XmlElement(name = "nombre_prod", required = true)
    protected String nombreProd;
    @XmlElement(name = "part_num")
    protected String partNum;
    protected double precio;
    protected int cantidad;
    @XmlElement(name = "id_orden")
    protected Integer idOrden;

    /**
     * Obtiene el valor de la propiedad idItem.
     * 
     */
    public int getIdItem() {
        return idItem;
    }

    /**
     * Define el valor de la propiedad idItem.
     * 
     */
    public void setIdItem(int value) {
        this.idItem = value;
    }

    /**
     * Obtiene el valor de la propiedad idProd.
     * 
     */
    public int getIdProd() {
        return idProd;
    }

    /**
     * Define el valor de la propiedad idProd.
     * 
     */
    public void setIdProd(int value) {
        this.idProd = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreProd.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreProd() {
        return nombreProd;
    }

    /**
     * Define el valor de la propiedad nombreProd.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreProd(String value) {
        this.nombreProd = value;
    }

    /**
     * Obtiene el valor de la propiedad partNum.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartNum() {
        return partNum;
    }

    /**
     * Define el valor de la propiedad partNum.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartNum(String value) {
        this.partNum = value;
    }

    /**
     * Obtiene el valor de la propiedad precio.
     * 
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Define el valor de la propiedad precio.
     * 
     */
    public void setPrecio(double value) {
        this.precio = value;
    }

    /**
     * Obtiene el valor de la propiedad cantidad.
     * 
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Define el valor de la propiedad cantidad.
     * 
     */
    public void setCantidad(int value) {
        this.cantidad = value;
    }

    /**
     * Obtiene el valor de la propiedad idOrden.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdOrden() {
        return idOrden;
    }

    /**
     * Define el valor de la propiedad idOrden.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdOrden(Integer value) {
        this.idOrden = value;
    }

}
