
package com.aes.touresbalon.touresbalonoms.wsdl.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Campania complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Campania">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id_producto" type="{http://www.example.org/ServiceProxyOMS/}Producto"/>
 *         &lt;element name="fecha_inicio_campania" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="fecha_fin_campania" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Campania", propOrder = {
    "idProducto",
    "fechaInicioCampania",
    "fechaFinCampania"
})
public class Campania {

    @XmlElement(name = "id_producto", required = true)
    protected Producto idProducto;
    @XmlElement(name = "fecha_inicio_campania", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaInicioCampania;
    @XmlElement(name = "fecha_fin_campania", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaFinCampania;

    /**
     * Gets the value of the idProducto property.
     * 
     * @return
     *     possible object is
     *     {@link Producto }
     *     
     */
    public Producto getIdProducto() {
        return idProducto;
    }

    /**
     * Sets the value of the idProducto property.
     * 
     * @param value
     *     allowed object is
     *     {@link Producto }
     *     
     */
    public void setIdProducto(Producto value) {
        this.idProducto = value;
    }

    /**
     * Gets the value of the fechaInicioCampania property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaInicioCampania() {
        return fechaInicioCampania;
    }

    /**
     * Sets the value of the fechaInicioCampania property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaInicioCampania(XMLGregorianCalendar value) {
        this.fechaInicioCampania = value;
    }

    /**
     * Gets the value of the fechaFinCampania property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaFinCampania() {
        return fechaFinCampania;
    }

    /**
     * Sets the value of the fechaFinCampania property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaFinCampania(XMLGregorianCalendar value) {
        this.fechaFinCampania = value;
    }

}
