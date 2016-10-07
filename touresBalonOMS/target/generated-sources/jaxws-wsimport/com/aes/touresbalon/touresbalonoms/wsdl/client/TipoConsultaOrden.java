
package com.aes.touresbalon.touresbalonoms.wsdl.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TipoConsultaOrden.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="TipoConsultaOrden">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ORDEN"/>
 *     &lt;enumeration value="PRODUCTO"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TipoConsultaOrden")
@XmlEnum
public enum TipoConsultaOrden {

    ORDEN,
    PRODUCTO;

    public String value() {
        return name();
    }

    public static TipoConsultaOrden fromValue(String v) {
        return valueOf(v);
    }

}
