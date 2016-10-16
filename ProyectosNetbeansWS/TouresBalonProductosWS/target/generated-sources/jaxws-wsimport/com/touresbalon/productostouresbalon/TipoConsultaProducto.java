
package com.touresbalon.productostouresbalon;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TipoConsultaProducto.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TipoConsultaProducto">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NOMBRE"/>
 *     &lt;enumeration value="DESCRIPCION"/>
 *     &lt;enumeration value="ID"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TipoConsultaProducto")
@XmlEnum
public enum TipoConsultaProducto {

    NOMBRE,
    DESCRIPCION,
    ID;

    public String value() {
        return name();
    }

    public static TipoConsultaProducto fromValue(String v) {
        return valueOf(v);
    }

}
