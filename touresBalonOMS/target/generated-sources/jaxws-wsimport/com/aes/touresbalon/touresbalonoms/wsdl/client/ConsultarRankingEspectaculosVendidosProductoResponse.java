
package com.aes.touresbalon.touresbalonoms.wsdl.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tipo_espectaculo" type="{http://www.example.org/ServiceProxyOMS/}TarifaValores" maxOccurs="unbounded" minOccurs="0"/>
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
    "tipoEspectaculo"
})
@XmlRootElement(name = "consultarRankingEspectaculosVendidosProductoResponse")
public class ConsultarRankingEspectaculosVendidosProductoResponse {

    @XmlElement(name = "tipo_espectaculo")
    protected List<TarifaValores> tipoEspectaculo;

    /**
     * Gets the value of the tipoEspectaculo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tipoEspectaculo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTipoEspectaculo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TarifaValores }
     * 
     * 
     */
    public List<TarifaValores> getTipoEspectaculo() {
        if (tipoEspectaculo == null) {
            tipoEspectaculo = new ArrayList<TarifaValores>();
        }
        return this.tipoEspectaculo;
    }

}
