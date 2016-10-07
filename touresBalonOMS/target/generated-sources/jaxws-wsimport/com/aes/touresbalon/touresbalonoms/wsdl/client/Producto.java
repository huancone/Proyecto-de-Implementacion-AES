
package com.aes.touresbalon.touresbalonoms.wsdl.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para Producto complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Producto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id_producto" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="espectaculo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ciudad_espectaculo" type="{http://www.example.org/ServiceProxyOMS/}Ciudad"/>
 *         &lt;element name="fecha_llegada" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fecha_salida" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fecha_espectaculo" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="tipo_transporte" type="{http://www.example.org/ServiceProxyOMS/}TarifaValores" minOccurs="0"/>
 *         &lt;element name="tipo_espectaculo" type="{http://www.example.org/ServiceProxyOMS/}TarifaValores"/>
 *         &lt;element name="tipo_hospedaje" type="{http://www.example.org/ServiceProxyOMS/}TarifaValores" minOccurs="0"/>
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
     * Obtiene el valor de la propiedad idProducto.
     * 
     */
    public int getIdProducto() {
        return idProducto;
    }

    /**
     * Define el valor de la propiedad idProducto.
     * 
     */
    public void setIdProducto(int value) {
        this.idProducto = value;
    }

    /**
     * Obtiene el valor de la propiedad espectaculo.
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
     * Define el valor de la propiedad espectaculo.
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
     * Obtiene el valor de la propiedad descripcion.
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
     * Define el valor de la propiedad descripcion.
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
     * Obtiene el valor de la propiedad ciudadEspectaculo.
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
     * Define el valor de la propiedad ciudadEspectaculo.
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
     * Obtiene el valor de la propiedad fechaLlegada.
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
     * Define el valor de la propiedad fechaLlegada.
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
     * Obtiene el valor de la propiedad fechaSalida.
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
     * Define el valor de la propiedad fechaSalida.
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
     * Obtiene el valor de la propiedad fechaEspectaculo.
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
     * Define el valor de la propiedad fechaEspectaculo.
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
     * Obtiene el valor de la propiedad tipoTransporte.
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
     * Define el valor de la propiedad tipoTransporte.
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
     * Obtiene el valor de la propiedad tipoEspectaculo.
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
     * Define el valor de la propiedad tipoEspectaculo.
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
     * Obtiene el valor de la propiedad tipoHospedaje.
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
     * Define el valor de la propiedad tipoHospedaje.
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
     * Obtiene el valor de la propiedad imagenProducto.
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
     * Define el valor de la propiedad imagenProducto.
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
