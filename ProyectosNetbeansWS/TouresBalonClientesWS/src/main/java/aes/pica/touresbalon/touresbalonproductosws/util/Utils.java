/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aes.pica.touresbalon.touresbalonproductosws.util;

import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author deirovir
 */
public class Utils {
    
    public static Date toDate(XMLGregorianCalendar calendar) {

        return calendar.toGregorianCalendar().getTime();

    }
    
    public static XMLGregorianCalendar toGregorian(Date fecha) throws DatatypeConfigurationException {

        GregorianCalendar gc = new GregorianCalendar();
        DatatypeFactory df = DatatypeFactory.newInstance();
         gc.setTimeInMillis(fecha.getTime());
         return df.newXMLGregorianCalendar(gc);

    }
    
}
