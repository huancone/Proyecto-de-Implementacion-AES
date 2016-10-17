
package com.aes.touresbalon.touresbalonoms.wsdl.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TipoAccion.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TipoAccion">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ADICIONAR"/>
 *     &lt;enumeration value="ELIMINAR"/>
 *     &lt;enumeration value="MODIFICAR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TipoAccion")
@XmlEnum
public enum TipoAccion {

    ADICIONAR,
    ELIMINAR,
    MODIFICAR;

    public String value() {
        return name();
    }

    public static TipoAccion fromValue(String v) {
        return valueOf(v);
    }

}
