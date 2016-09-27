
package com.touresbalon.productostouresbalon;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Ciudad complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Ciudad">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id_ciudad" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pais" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tipo_ciudad" type="{http://www.touresbalon.com/ProductosTouresBalon/}TarifaValores"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Ciudad", propOrder = {
    "idCiudad",
    "pais",
    "tipoCiudad"
})
public class Ciudad {

    @XmlElement(name = "id_ciudad")
    protected int idCiudad;
    @XmlElement(required = true)
    protected String pais;
    @XmlElement(name = "tipo_ciudad", required = true)
    protected TarifaValores tipoCiudad;

    /**
     * Obtiene el valor de la propiedad idCiudad.
     * 
     */
    public int getIdCiudad() {
        return idCiudad;
    }

    /**
     * Define el valor de la propiedad idCiudad.
     * 
     */
    public void setIdCiudad(int value) {
        this.idCiudad = value;
    }

    /**
     * Obtiene el valor de la propiedad pais.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPais() {
        return pais;
    }

    /**
     * Define el valor de la propiedad pais.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPais(String value) {
        this.pais = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoCiudad.
     * 
     * @return
     *     possible object is
     *     {@link TarifaValores }
     *     
     */
    public TarifaValores getTipoCiudad() {
        return tipoCiudad;
    }

    /**
     * Define el valor de la propiedad tipoCiudad.
     * 
     * @param value
     *     allowed object is
     *     {@link TarifaValores }
     *     
     */
    public void setTipoCiudad(TarifaValores value) {
        this.tipoCiudad = value;
    }

}
