
package com.touresbalon.clientestouresbalon;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EstatusCliente.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EstatusCliente">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PLATINO"/>
 *     &lt;enumeration value="DORADO"/>
 *     &lt;enumeration value="PLATEADO"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EstatusCliente")
@XmlEnum
public enum EstatusCliente {

    PLATINO,
    DORADO,
    PLATEADO;

    public String value() {
        return name();
    }

    public static EstatusCliente fromValue(String v) {
        return valueOf(v);
    }

}
