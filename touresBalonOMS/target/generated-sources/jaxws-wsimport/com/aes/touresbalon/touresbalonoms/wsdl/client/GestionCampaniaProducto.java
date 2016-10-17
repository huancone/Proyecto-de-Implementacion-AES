
package com.aes.touresbalon.touresbalonoms.wsdl.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tipo_operacion" type="{http://www.example.org/ServiceProxyOMS/}TipoAccion"/>
 *         &lt;element name="campania" type="{http://www.example.org/ServiceProxyOMS/}Campania" minOccurs="0"/>
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
    "tipoOperacion",
    "campania"
})
@XmlRootElement(name = "gestionCampaniaProducto")
public class GestionCampaniaProducto {

    @XmlElement(name = "tipo_operacion", required = true)
    protected TipoAccion tipoOperacion;
    protected Campania campania;

    /**
     * Gets the value of the tipoOperacion property.
     * 
     * @return
     *     possible object is
     *     {@link TipoAccion }
     *     
     */
    public TipoAccion getTipoOperacion() {
        return tipoOperacion;
    }

    /**
     * Sets the value of the tipoOperacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoAccion }
     *     
     */
    public void setTipoOperacion(TipoAccion value) {
        this.tipoOperacion = value;
    }

    /**
     * Gets the value of the campania property.
     * 
     * @return
     *     possible object is
     *     {@link Campania }
     *     
     */
    public Campania getCampania() {
        return campania;
    }

    /**
     * Sets the value of the campania property.
     * 
     * @param value
     *     allowed object is
     *     {@link Campania }
     *     
     */
    public void setCampania(Campania value) {
        this.campania = value;
    }

}
