
package com.touresbalon.productostouresbalon;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Producto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Producto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id_producto" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="espectaculo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ciudad_espectaculo" type="{http://www.touresbalon.com/ProductosTouresBalon/}Ciudad"/>
 *         &lt;element name="fecha_llegada" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fecha_salida" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fecha_espectaculo" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="tipo_transporte" type="{http://www.touresbalon.com/ProductosTouresBalon/}TarifaValores" minOccurs="0"/>
 *         &lt;element name="tipo_espectaculo" type="{http://www.touresbalon.com/ProductosTouresBalon/}TarifaValores"/>
 *         &lt;element name="tipo_hospedaje" type="{http://www.touresbalon.com/ProductosTouresBalon/}TarifaValores" minOccurs="0"/>
 *         &lt;element name="imagen_producto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Producto", propOrder = {
    "idProducto",
    "espectaculo",
    "descripcion",
    "ciudadEspectaculo",
    "fechaLlegada",
    "fechaSalida",
    "fechaEspectaculo",
    "tipoTransporte",
    "tipoEspectaculo",
    "tipoHospedaje",
    "imagenProducto"
})
public class Producto {

    @XmlElement(name = "id_producto")
    protected int idProducto;
    @XmlElement(required = true)
    protected String espectaculo;
    @XmlElement(required = true)
    protected String descripcion;
    @XmlElement(name = "ciudad_espectaculo", required = true)
    protected Ciudad ciudadEspectaculo;
    @XmlElement(name = "fecha_llegada")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaLlegada;
    @XmlElement(name = "fecha_salida")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaSalida;
    @XmlElement(name = "fecha_espectaculo")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaEspectaculo;
    @XmlElement(name = "tipo_transporte")
    protected TarifaValores tipoTransporte;
    @XmlElement(name = "tipo_espectaculo", required = true)
    protected TarifaValores tipoEspectaculo;
    @XmlElement(name = "tipo_hospedaje")
    protected TarifaValores tipoHospedaje;
    @XmlElement(name = "imagen_producto")
    protected String imagenProducto;

    /**
     * Gets the value of the idProducto property.
     * 
     */
    public int getIdProducto() {
        return idProducto;
    }

    /**
     * Sets the value of the idProducto property.
     * 
     */
    public void setIdProducto(int value) {
        this.idProducto = value;
    }

    /**
     * Gets the value of the espectaculo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEspectaculo() {
        return espectaculo;
    }

    /**
     * Sets the value of the espectaculo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEspectaculo(String value) {
        this.espectaculo = value;
    }

    /**
     * Gets the value of the descripcion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Sets the value of the descripcion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
    }

    /**
     * Gets the value of the ciudadEspectaculo property.
     * 
     * @return
     *     possible object is
     *     {@link Ciudad }
     *     
     */
    public Ciudad getCiudadEspectaculo() {
        return ciudadEspectaculo;
    }

    /**
     * Sets the value of the ciudadEspectaculo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Ciudad }
     *     
     */
    public void setCiudadEspectaculo(Ciudad value) {
        this.ciudadEspectaculo = value;
    }

    /**
     * Gets the value of the fechaLlegada property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaLlegada() {
        return fechaLlegada;
    }

    /**
     * Sets the value of the fechaLlegada property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaLlegada(XMLGregorianCalendar value) {
        this.fechaLlegada = value;
    }

    /**
     * Gets the value of the fechaSalida property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaSalida() {
        return fechaSalida;
    }

    /**
     * Sets the value of the fechaSalida property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaSalida(XMLGregorianCalendar value) {
        this.fechaSalida = value;
    }

    /**
     * Gets the value of the fechaEspectaculo property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaEspectaculo() {
        return fechaEspectaculo;
    }

    /**
     * Sets the value of the fechaEspectaculo property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaEspectaculo(XMLGregorianCalendar value) {
        this.fechaEspectaculo = value;
    }

    /**
     * Gets the value of the tipoTransporte property.
     * 
     * @return
     *     possible object is
     *     {@link TarifaValores }
     *     
     */
    public TarifaValores getTipoTransporte() {
        return tipoTransporte;
    }

    /**
     * Sets the value of the tipoTransporte property.
     * 
     * @param value
     *     allowed object is
     *     {@link TarifaValores }
     *     
     */
    public void setTipoTransporte(TarifaValores value) {
        this.tipoTransporte = value;
    }

    /**
     * Gets the value of the tipoEspectaculo property.
     * 
     * @return
     *     possible object is
     *     {@link TarifaValores }
     *     
     */
    public TarifaValores getTipoEspectaculo() {
        return tipoEspectaculo;
    }

    /**
     * Sets the value of the tipoEspectaculo property.
     * 
     * @param value
     *     allowed object is
     *     {@link TarifaValores }
     *     
     */
    public void setTipoEspectaculo(TarifaValores value) {
        this.tipoEspectaculo = value;
    }

    /**
     * Gets the value of the tipoHospedaje property.
     * 
     * @return
     *     possible object is
     *     {@link TarifaValores }
     *     
     */
    public TarifaValores getTipoHospedaje() {
        return tipoHospedaje;
    }

    /**
     * Sets the value of the tipoHospedaje property.
     * 
     * @param value
     *     allowed object is
     *     {@link TarifaValores }
     *     
     */
    public void setTipoHospedaje(TarifaValores value) {
        this.tipoHospedaje = value;
    }

    /**
     * Gets the value of the imagenProducto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImagenProducto() {
        return imagenProducto;
    }

    /**
     * Sets the value of the imagenProducto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImagenProducto(String value) {
        this.imagenProducto = value;
    }

}
