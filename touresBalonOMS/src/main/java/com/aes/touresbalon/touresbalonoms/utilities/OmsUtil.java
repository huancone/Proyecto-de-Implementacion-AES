/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aes.touresbalon.touresbalonoms.utilities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author alexanderbarbosaayala
 */
public class OmsUtil {
    public static XMLGregorianCalendar stringToXMLGreogrianCalendar(String fecha) 
            throws ParseException, DatatypeConfigurationException{
        DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date fechaUtil = formatter.parse(fecha);
        GregorianCalendar gc = new GregorianCalendar();
        DatatypeFactory df = DatatypeFactory.newInstance();
        gc.setTimeInMillis(fechaUtil.getTime());
        return df.newXMLGregorianCalendar(gc);
    }
    
    public static String xmlgGregorianCalendarToString(XMLGregorianCalendar fecha){
        Date fechaUtil = new Date();
        DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        fechaUtil = fecha.toGregorianCalendar().getTime();
        return formatter.format(fechaUtil);
    }
}
