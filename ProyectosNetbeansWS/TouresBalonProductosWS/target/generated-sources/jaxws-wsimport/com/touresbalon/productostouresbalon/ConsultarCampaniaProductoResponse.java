
package com.touresbalon.productostouresbalon;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="campanias" type="{http://www.touresbalon.com/ProductosTouresBalon/}Campania" maxOccurs="unbounded" minOccurs="0"/>
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
    "campanias"
})
@XmlRootElement(name = "ConsultarCampaniaProductoResponse")
public class ConsultarCampaniaProductoResponse {

    protected List<Campania> campanias;

    /**
     * Gets the value of the campanias property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the campanias property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCampanias().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Campania }
     * 
     * 
     */
    public List<Campania> getCampanias() {
        if (campanias == null) {
            campanias = new ArrayList<Campania>();
        }
        return this.campanias;
    }

}
