
package com.aes.touresbalon.touresbalonoms.wsdl.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CriterioConsultaOrden complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CriterioConsultaOrden">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tipo_consulta" type="{http://www.example.org/ServiceProxyOMS/}TipoConsultaOrden"/>
 *         &lt;element name="codigo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CriterioConsultaOrden", propOrder = {
    "tipoConsulta",
    "codigo"
})
public class CriterioConsultaOrden {

    @XmlElement(name = "tipo_consulta", required = true)
    protected TipoConsultaOrden tipoConsulta;
    protected int codigo;

    /**
     * Gets the value of the tipoConsulta property.
     * 
     * @return
     *     possible object is
     *     {@link TipoConsultaOrden }
     *     
     */
    public TipoConsultaOrden getTipoConsulta() {
        return tipoConsulta;
    }

    /**
     * Sets the value of the tipoConsulta property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoConsultaOrden }
     *     
     */
    public void setTipoConsulta(TipoConsultaOrden value) {
        this.tipoConsulta = value;
    }

    /**
     * Gets the value of the codigo property.
     * 
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Sets the value of the codigo property.
     * 
     */
    public void setCodigo(int value) {
        this.codigo = value;
    }

}
