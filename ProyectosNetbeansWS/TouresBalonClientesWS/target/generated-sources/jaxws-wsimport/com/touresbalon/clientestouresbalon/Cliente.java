
package com.touresbalon.clientestouresbalon;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Cliente complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
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
 *         &lt;element name="estatus" type="{http://www.touresbalon.com/ClientesTouresBalon/}EstatusCliente"/>
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
    "direccion",
    "estatus"
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
    @XmlElement(required = true)
    protected EstatusCliente estatus;

    /**
     * Gets the value of the idCliente property.
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
     * Sets the value of the idCliente property.
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
     * Gets the value of the nombres property.
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
     * Sets the value of the nombres property.
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
     * Gets the value of the apellidos property.
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
     * Sets the value of the apellidos property.
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
     * Gets the value of the numTel property.
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
     * Sets the value of the numTel property.
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
     * Gets the value of the email property.
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
     * Sets the value of the email property.
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
     * Gets the value of the contrasenia property.
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
     * Sets the value of the contrasenia property.
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
     * Gets the value of the tipoTarjeta property.
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
     * Sets the value of the tipoTarjeta property.
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
     * Gets the value of the numeroTarjeta property.
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
     * Sets the value of the numeroTarjeta property.
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

    /**
     * Gets the value of the estatus property.
     * 
     * @return
     *     possible object is
     *     {@link EstatusCliente }
     *     
     */
    public EstatusCliente getEstatus() {
        return estatus;
    }

    /**
     * Sets the value of the estatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link EstatusCliente }
     *     
     */
    public void setEstatus(EstatusCliente value) {
        this.estatus = value;
    }

}
