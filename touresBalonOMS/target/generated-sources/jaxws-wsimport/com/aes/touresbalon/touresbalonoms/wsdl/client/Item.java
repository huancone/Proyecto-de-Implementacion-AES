
package com.aes.touresbalon.touresbalonoms.wsdl.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Item complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
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
     * Gets the value of the idItem property.
     * 
     */
    public int getIdItem() {
        return idItem;
    }

    /**
     * Sets the value of the idItem property.
     * 
     */
    public void setIdItem(int value) {
        this.idItem = value;
    }

    /**
     * Gets the value of the idProd property.
     * 
     */
    public int getIdProd() {
        return idProd;
    }

    /**
     * Sets the value of the idProd property.
     * 
     */
    public void setIdProd(int value) {
        this.idProd = value;
    }

    /**
     * Gets the value of the nombreProd property.
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
     * Sets the value of the nombreProd property.
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
     * Gets the value of the partNum property.
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
     * Sets the value of the partNum property.
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
     * Gets the value of the precio property.
     * 
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Sets the value of the precio property.
     * 
     */
    public void setPrecio(double value) {
        this.precio = value;
    }

    /**
     * Gets the value of the cantidad property.
     * 
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Sets the value of the cantidad property.
     * 
     */
    public void setCantidad(int value) {
        this.cantidad = value;
    }

    /**
     * Gets the value of the idOrden property.
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
     * Sets the value of the idOrden property.
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
