
package com.aes.touresbalon.touresbalonoms.wsdl.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Orden complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Orden">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id_cliente" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="id_orden" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="fecha_orden" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="precio" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="estatus" type="{http://www.example.org/ServiceProxyOMS/}EstatusOrden" minOccurs="0"/>
 *         &lt;element name="comentarios" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="item" type="{http://www.example.org/ServiceProxyOMS/}Item" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Orden", propOrder = {
    "idCliente",
    "idOrden",
    "fechaOrden",
    "precio",
    "estatus",
    "comentarios",
    "item"
})
public class Orden {

    @XmlElement(name = "id_cliente")
    protected int idCliente;
    @XmlElement(name = "id_orden")
    protected Integer idOrden;
    @XmlElement(name = "fecha_orden", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaOrden;
    protected double precio;
    protected EstatusOrden estatus;
    protected List<String> comentarios;
    protected List<Item> item;

    /**
     * Gets the value of the idCliente property.
     * 
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * Sets the value of the idCliente property.
     * 
     */
    public void setIdCliente(int value) {
        this.idCliente = value;
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

    /**
     * Gets the value of the fechaOrden property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaOrden() {
        return fechaOrden;
    }

    /**
     * Sets the value of the fechaOrden property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaOrden(XMLGregorianCalendar value) {
        this.fechaOrden = value;
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
     * Gets the value of the estatus property.
     * 
     * @return
     *     possible object is
     *     {@link EstatusOrden }
     *     
     */
    public EstatusOrden getEstatus() {
        return estatus;
    }

    /**
     * Sets the value of the estatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link EstatusOrden }
     *     
     */
    public void setEstatus(EstatusOrden value) {
        this.estatus = value;
    }

    /**
     * Gets the value of the comentarios property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the comentarios property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComentarios().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getComentarios() {
        if (comentarios == null) {
            comentarios = new ArrayList<String>();
        }
        return this.comentarios;
    }

    /**
     * Gets the value of the item property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the item property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Item }
     * 
     * 
     */
    public List<Item> getItem() {
        if (item == null) {
            item = new ArrayList<Item>();
        }
        return this.item;
    }

}
