/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aes.touresbalon.touresbalonoms.services;

import com.aes.touresbalon.touresbalonoms.utilities.OmsUtil;
import com.aes.touresbalon.touresbalonoms.wsdl.client.Ciudad;
import com.aes.touresbalon.touresbalonoms.wsdl.client.Producto;
import com.aes.touresbalon.touresbalonoms.wsdl.client.TarifaValores;
import com.aes.touresbalon.touresbalonoms.wsdl.client.TipoAccion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author alexanderbarbosaayala
 */
public class ConexionDB {
    
    private static Connection conexionDB(){
        //Conecto con la BD..
        Connection con = null;
        try {
            
            ResultSet rs = null;
            XMLGregorianCalendar fechaEsp = null;
            XMLGregorianCalendar fechaLlegada = null;
            XMLGregorianCalendar fechaSalida = null;
            
            TarifaValores tEsp = new TarifaValores();
            TarifaValores tHosp = new TarifaValores();
            TarifaValores tTrans = new TarifaValores();
            Ciudad ciudad = new Ciudad();
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            con = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=TB_PRODUCTOS;user=touresbalon;password=touresbalon");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
                Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
  
    public static List<Producto> consultarProducto(String tipoConsulta, String consulta) {
        List<Producto> productoLista = new ArrayList<>();
        try {
            //Conecto con la BD..
            Connection con = conexionDB();
            ResultSet rs = null;
            XMLGregorianCalendar fechaEsp = null;
            XMLGregorianCalendar fechaLlegada = null;
            XMLGregorianCalendar fechaSalida = null;
            
            TarifaValores tEsp = new TarifaValores();
            TarifaValores tHosp = new TarifaValores();
            TarifaValores tTrans = new TarifaValores();
            Ciudad ciudad = new Ciudad();
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

//            con = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=TB_PRODUCTOS;user=touresbalon;password=touresbalon");

            //Llamada al procedimiento.
            CallableStatement param; //Variable q uso para llamada al prcedimiento.

            param = con.prepareCall("{ call consultarProducto(?,?) }"); //Llamo al procedimiento pa_getCategoriasEI

//            param.setInt(1, 1); //Setea el parámetro que recibe la consulta, q es un id
            param.setString(1, tipoConsulta);
            param.setString(2, consulta);
            
//            param.registerOutParameter(2, java.sql.Types.INTEGER); //Aca setea el parametro de salida, q es un string.

//            param.executeQuery(); //Se ejecuta el procedimiento
            rs = param.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("ID_PRODUCTO"));
                producto.setEspectaculo(rs.getString("ESPECTACULO"));
                producto.setDescripcion(rs.getString("DESCRIPCION"));
                tEsp.setId(rs.getInt("ID_ESPECTACULO"));
                tEsp.setNombreTipo(rs.getString("nombre_espectaculo"));
                tEsp.setPrecio(rs.getDouble("precio_espectaculo"));

                tHosp.setId(rs.getInt("ID_HOSPEDAJE"));
                tHosp.setNombreTipo(rs.getString("nombre_hospedaje"));
                tHosp.setPrecio(rs.getDouble("precio_hospedaje"));

                tTrans.setId(rs.getInt("ID_TRANSPORTE"));
                tTrans.setNombreTipo(rs.getString("nombre_transporte"));
                tTrans.setPrecio(rs.getDouble("precio_transporte"));

                producto.setTipoEspectaculo(tEsp);
                producto.setTipoHospedaje(tHosp);
                producto.setTipoTransporte(tTrans);
                ciudad.setIdCiudad(rs.getInt("ID_CIUDAD"));
                ciudad.setPais(rs.getString("nombre_ciudad"));
                ciudad.getTipoCiudad();
                fechaEsp = OmsUtil.stringToXMLGreogrianCalendar(rs.getDate("FECHA_ESPECTACULO"));
                fechaLlegada = OmsUtil.stringToXMLGreogrianCalendar(rs.getDate("FECHA_LLEGADA"));
                fechaSalida = OmsUtil.stringToXMLGreogrianCalendar(rs.getDate("FECHA_SALIDA"));
                producto.setFechaEspectaculo(fechaEsp);
                producto.setFechaLlegada(fechaLlegada);
                producto.setFechaSalida(fechaSalida);
                producto.setCiudadEspectaculo(ciudad);
                productoLista.add(producto);
            }
        } catch (SQLException | ParseException | DatatypeConfigurationException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productoLista;
    }
    
    public static String gestionProducto(TipoAccion tipoOperacion, Producto producto) {
        String respuesta = null;
        try {
            //Llamada al procedimiento.
            CallableStatement param; //Variable q uso para llamada al prcedimiento.
            Connection con = conexionDB();
            ResultSet rs = null;
            Date fechaSalida = new Date();
            Date fechaLlegada = new Date();
            Date fechaEspectaculo = new Date();
            
            param = con.prepareCall("{ call gestionProducto(?,?,?,?,?,?,?,?,?,?,?,?) }"); //Llamo al procedimiento pa_getCategoriasEI

//            param.setInt(1, 1); //Setea el parámetro que recibe la consulta, q es un id
            param.setString(1, tipoOperacion.toString());
            param.setInt(2, producto.getIdProducto());
            param.setString(3, producto.getEspectaculo());
            param.setString(4, producto.getDescripcion());
            param.setInt(5, producto.getTipoEspectaculo().getId());
            param.setInt(6, producto.getTipoTransporte().getId());
            param.setInt(7, producto.getTipoHospedaje().getId());
            param.setInt(8, producto.getCiudadEspectaculo().getIdCiudad());
            fechaSalida = OmsUtil.xmlgGregorianCalendarToString(producto.getFechaSalida());
            fechaLlegada = OmsUtil.xmlgGregorianCalendarToString(producto.getFechaLlegada());
            fechaEspectaculo = OmsUtil.xmlgGregorianCalendarToString(producto.getFechaEspectaculo());
            param.setDate(9, new java.sql.Date(fechaSalida.getTime()));
            param.setDate(10, new java.sql.Date(fechaLlegada.getTime()));
            param.setDate(11, new java.sql.Date(fechaEspectaculo.getTime()));
            param.setString(12, "Soccer");
            
            rs = param.executeQuery();
            
            if (rs.next()){
                if (rs.getInt("resultado") > 0){
                    respuesta = "OK";
                }else 
                    respuesta = "KO";
            }else
                respuesta = "KO"; 
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }
}

