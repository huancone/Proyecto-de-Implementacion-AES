
package com.touresbalon.productostouresbalon;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para RespuestaGenerica.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
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
