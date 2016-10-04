
package com.touresbalon.clientestouresbalon;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Cliente complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Cliente">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id_cliente" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nombres" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="apellidos" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="num_tel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="contrasenia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tipo_tarjeta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numero_tarjeta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="direccion" type="{http://www.touresbalon.com/ClientesTouresBalon/}Direccion" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Cliente", propOrder = {
    "idCliente",
    "nombres",
    "apellidos",
    "numTel",
    "email",
    "contrasenia",
    "tipoTarjeta",
    "numeroTarjeta",
    "direccion"
})
public class Cliente {

    @XmlElement(name = "id_cliente")
    protected Integer idCliente;
    @XmlElement(required = true)
    protected String nombres;
    @XmlElement(required = true)
    protected String apellidos;
    @XmlElement(name = "num_tel")
    protected String numTel;
    @XmlElement(required = true)
    protected String email;
    @XmlElement(required = true)
    protected String contrasenia;
    @XmlElement(name = "tipo_tarjeta")
    protected String tipoTarjeta;
    @XmlElement(name = "numero_tarjeta")
    protected String numeroTarjeta;
    protected List<Direccion> direccion;

    /**
     * Obtiene el valor de la propiedad idCliente.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdCliente() {
        return idCliente;
    }

    /**
     * Define el valor de la propiedad idCliente.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdCliente(Integer value) {
        this.idCliente = value;
    }

    /**
     * Obtiene el valor de la propiedad nombres.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Define el valor de la propiedad nombres.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombres(String value) {
        this.nombres = value;
    }

    /**
     * Obtiene el valor de la propiedad apellidos.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Define el valor de la propiedad apellidos.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApellidos(String value) {
        this.apellidos = value;
    }

    /**
     * Obtiene el valor de la propiedad numTel.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumTel() {
        return numTel;
    }

    /**
     * Define el valor de la propiedad numTel.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumTel(String value) {
        this.numTel = value;
    }

    /**
     * Obtiene el valor de la propiedad email.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define el valor de la propiedad email.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Obtiene el valor de la propiedad contrasenia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Define el valor de la propiedad contrasenia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContrasenia(String value) {
        this.contrasenia = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoTarjeta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    /**
     * Define el valor de la propiedad tipoTarjeta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoTarjeta(String value) {
        this.tipoTarjeta = value;
    }

    /**
     * Obtiene el valor de la propiedad numeroTarjeta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    /**
     * Define el valor de la propiedad numeroTarjeta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroTarjeta(String value) {
        this.numeroTarjeta = value;
    }

    /**
     * Gets the value of the direccion property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the direccion property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDireccion().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Direccion }
     * 
     * 
     */
    public List<Direccion> getDireccion() {
        if (direccion == null) {
            direccion = new ArrayList<Direccion>();
        }
        return this.direccion;
    }

}
