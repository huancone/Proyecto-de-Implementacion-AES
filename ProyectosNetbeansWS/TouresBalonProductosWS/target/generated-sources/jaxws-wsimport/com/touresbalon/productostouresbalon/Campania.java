
package com.touresbalon.productostouresbalon;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para Campania complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Campania">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id_producto" type="{http://www.touresbalon.com/ProductosTouresBalon/}Producto"/>
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
     * Obtiene el valor de la propiedad idProducto.
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
     * Define el valor de la propiedad idProducto.
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
     * Obtiene el valor de la propiedad fechaInicioCampania.
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
     * Define el valor de la propiedad fechaInicioCampania.
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
     * Obtiene el valor de la propiedad fechaFinCampania.
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
     * Define el valor de la propiedad fechaFinCampania.
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
