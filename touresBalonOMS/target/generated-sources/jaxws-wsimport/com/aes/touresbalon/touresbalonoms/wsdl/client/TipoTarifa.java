
package com.aes.touresbalon.touresbalonoms.wsdl.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TipoTarifa.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TipoTarifa">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TRANSPORTE"/>
 *     &lt;enumeration value="HOSPEDAJE"/>
 *     &lt;enumeration value="ESPECTACULO"/>
 *     &lt;enumeration value="CIUDAD"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TipoTarifa")
@XmlEnum
public enum TipoTarifa {

    TRANSPORTE,
    HOSPEDAJE,
    ESPECTACULO,
    CIUDAD;

    public String value() {
        return name();
    }

    public static TipoTarifa fromValue(String v) {
        return valueOf(v);
    }

}
