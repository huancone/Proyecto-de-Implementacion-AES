/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aes.pica.touresbalon.tb_serviciosbolivariano.main;

import aes.pica.touresbalon.tb_serviciosbolivariano.IServiciosBolivarianos;
import aes.pica.touresbalon.tb_serviciosbolivariano.ServiciosBolivarianos;
import aes.pica.touresbalon.tb_serviciosbolivariano.ServiciosBolivarianosExcepcion;
import aes.pica.touresbalon.tb_serviciosbolivariano.vo.TouresBalonOrdenVO;
import aes.pica.touresbalon.tb_serviciosbolivariano.vo.ViajeVO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jdtrujillop
 */
public class MainTest {

    public static void main(String[] args) {
        String rutaConsulta = "/Users/jdtrujillop/Desarrollo/TouresBalon/Bolivariano/Consulta";
        String rutaReserva = "/Users/jdtrujillop/Desarrollo/TouresBalon/Bolivariano/Reservas";
        IServiciosBolivarianos sb;

        System.out.println("Inicio Servicio Bolivarianos");

        try {
            sb = new ServiciosBolivarianos(rutaConsulta, rutaReserva);
            
            System.out.println("PARTE 1 - Consultar viajes con hora");
            
            List<ViajeVO> listViajes = sb.consultarViajes("21082016", "bogota", "medellin", "1201");
            if(!listViajes.isEmpty()){
                for(ViajeVO v:listViajes){
                    System.out.println(v);
                }
            }else{
                System.out.println("No hay viajes las caracteristicas solicitadas");
            }
            
            System.out.println("PARTE 2 - Consultar viajes sin hora");
            
            listViajes = sb.consultarViajes("22082016", "cartagena", "buga");
            if(!listViajes.isEmpty()){
                for(ViajeVO v:listViajes){
                    System.out.println(v);
                }
            }else{
                System.out.println("No hay viajes las caracteristicas solicitadas");
            }
            
            System.out.println("PARTE 3 - Crear archivo de reservas");
            
            if(sb.crearReserva("1", "Juan Diego", "Trujillo Perez", "22082016", listViajes,true)){
                System.out.println("Se creo el archivo con exito");
            }else{
                System.err.println("No se creo el archivo de reservas");
            }
            
            System.out.println("PARTE 4 - Lectura archivo de reservas");
            
            for (TouresBalonOrdenVO r : sb.consultaReservas("1")) {
                System.out.println(r);
            }
            
        } catch (ServiciosBolivarianosExcepcion ex) {
            System.err.println(ex.toString());
        }
        System.out.println("Fin Servicio Bolivarianos");

    }

}
