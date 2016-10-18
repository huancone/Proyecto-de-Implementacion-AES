
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
 *         &lt;element name="producto" type="{http://www.example.org/ServiceProxyOMS/}Producto"/>
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
    "producto"
})
@XmlRootElement(name = "gestionProducto")
public class GestionProducto {

    @XmlElement(name = "tipo_operacion", required = true)
    protected TipoAccion tipoOperacion;
    @XmlElement(required = true)
    protected Producto producto;

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
     * Gets the value of the producto property.
     * 
     * @return
     *     possible object is
     *     {@link Producto }
     *     
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * Sets the value of the producto property.
     * 
     * @param value
     *     allowed object is
     *     {@link Producto }
     *     
     */
    public void setProducto(Producto value) {
        this.producto = value;
    }

}
