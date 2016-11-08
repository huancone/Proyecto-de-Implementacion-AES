/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aes.touresbalon.touresbalonoms.utilities;

import com.aes.touresbalon.touresbalonoms.beans.ClienteBean;
import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author alexanderbarbosaayala
 */
public class OmsUtil {
    public static XMLGregorianCalendar stringToXMLGreogrianCalendar(Date fecha) 
            throws ParseException, DatatypeConfigurationException{
//        DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
//        Date fechaUtil = formatter.parse(fecha);
        GregorianCalendar gc = new GregorianCalendar();
        DatatypeFactory df = DatatypeFactory.newInstance();
        gc.setTimeInMillis(fecha.getTime());
        return df.newXMLGregorianCalendar(gc);
    }
    
    public static Date xmlgGregorianCalendarToString(XMLGregorianCalendar fecha){
//        DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
//        Date fechaUtil = fecha.toGregorianCalendar().getTime();
//        return formatter.format(fechaUtil);
        return fecha.toGregorianCalendar().getTime();
    }
    
    public static void copiarPropiedades(Object origen, Object destino){
        try {
            org.apache.commons.beanutils.BeanUtils.copyProperties(origen, destino);
        } catch (IllegalAccessException | InvocationTargetException ex) {
            Logger.getLogger(OmsUtil.class.getName()).log(Level.SEVERE, "Error al usar utilitario copiar propiedades", ex);
        }
    }
}
