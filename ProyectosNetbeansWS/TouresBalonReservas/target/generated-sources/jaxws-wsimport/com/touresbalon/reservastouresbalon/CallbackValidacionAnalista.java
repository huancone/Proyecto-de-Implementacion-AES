
package com.touresbalon.reservastouresbalon;

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
 *         &lt;element name="idOrden" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="estatusOrden" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="itemTransporte" type="{http://www.touresbalon.com/ReservasTouresBalon/}item" minOccurs="0"/>
 *         &lt;element name="itemHospedaje" type="{http://www.touresbalon.com/ReservasTouresBalon/}item" minOccurs="0"/>
 *         &lt;element name="itemEspectaculo" type="{http://www.touresbalon.com/ReservasTouresBalon/}item" minOccurs="0"/>
 *         &lt;element name="itemCiudad" type="{http://www.touresbalon.com/ReservasTouresBalon/}item" minOccurs="0"/>
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
    "idOrden",
    "estatusOrden",
    "itemTransporte",
    "itemHospedaje",
    "itemEspectaculo",
    "itemCiudad"
})
@XmlRootElement(name = "CallbackValidacionAnalista")
public class CallbackValidacionAnalista {

    protected int idOrden;
    @XmlElement(required = true)
    protected String estatusOrden;
    protected Item itemTransporte;
    protected Item itemHospedaje;
    protected Item itemEspectaculo;
    protected Item itemCiudad;

    /**
     * Obtiene el valor de la propiedad idOrden.
     * 
     */
    public int getIdOrden() {
        return idOrden;
    }

    /**
     * Define el valor de la propiedad idOrden.
     * 
     */
    public void setIdOrden(int value) {
        this.idOrden = value;
    }

    /**
     * Obtiene el valor de la propiedad estatusOrden.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstatusOrden() {
        return estatusOrden;
    }

    /**
     * Define el valor de la propiedad estatusOrden.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstatusOrden(String value) {
        this.estatusOrden = value;
    }

    /**
     * Obtiene el valor de la propiedad itemTransporte.
     * 
     * @return
     *     possible object is
     *     {@link Item }
     *     
     */
    public Item getItemTransporte() {
        return itemTransporte;
    }

    /**
     * Define el valor de la propiedad itemTransporte.
     * 
     * @param value
     *     allowed object is
     *     {@link Item }
     *     
     */
    public void setItemTransporte(Item value) {
        this.itemTransporte = value;
    }

    /**
     * Obtiene el valor de la propiedad itemHospedaje.
     * 
     * @return
     *     possible object is
     *     {@link Item }
     *     
     */
    public Item getItemHospedaje() {
        return itemHospedaje;
    }

    /**
     * Define el valor de la propiedad itemHospedaje.
     * 
     * @param value
     *     allowed object is
     *     {@link Item }
     *     
     */
    public void setItemHospedaje(Item value) {
        this.itemHospedaje = value;
    }

    /**
     * Obtiene el valor de la propiedad itemEspectaculo.
     * 
     * @return
     *     possible object is
     *     {@link Item }
     *     
     */
    public Item getItemEspectaculo() {
        return itemEspectaculo;
    }

    /**
     * Define el valor de la propiedad itemEspectaculo.
     * 
     * @param value
     *     allowed object is
     *     {@link Item }
     *     
     */
    public void setItemEspectaculo(Item value) {
        this.itemEspectaculo = value;
    }

    /**
     * Obtiene el valor de la propiedad itemCiudad.
     * 
     * @return
     *     possible object is
     *     {@link Item }
     *     
     */
    public Item getItemCiudad() {
        return itemCiudad;
    }

    /**
     * Define el valor de la propiedad itemCiudad.
     * 
     * @param value
     *     allowed object is
     *     {@link Item }
     *     
     */
    public void setItemCiudad(Item value) {
        this.itemCiudad = value;
    }

}
