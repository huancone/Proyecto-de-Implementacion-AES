
package com.touresbalon.clientestouresbalon;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RespuestaGenerica.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RespuestaGenerica">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="OK"/>
 *     &lt;enumeration value="KO"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RespuestaGenerica")
@XmlEnum
public enum RespuestaGenerica {

    OK,
    KO;

    public String value() {
        return name();
    }

    public static RespuestaGenerica fromValue(String v) {
        return valueOf(v);
    }

}
