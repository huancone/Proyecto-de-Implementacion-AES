
package com.touresbalon.clientestouresbalon;

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
 *         &lt;element name="id_cliente" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "", propOrder = {
    "idCliente",
    "estatus"
})
@XmlRootElement(name = "ActualizarEstatusCliente")
public class ActualizarEstatusCliente {

    @XmlElement(name = "id_cliente")
    protected int idCliente;
    @XmlElement(required = true)
    protected EstatusCliente estatus;

    /**
     * Gets the value of the idCliente property.
     * 
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * Sets the value of the idCliente property.
     * 
     */
    public void setIdCliente(int value) {
        this.idCliente = value;
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
