/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aes.pica.touresbalon.tb_serviciosbolivariano;

import aes.pica.touresbalon.tb_serviciosbolivariano.utils.Constantes;
import aes.pica.touresbalon.tb_serviciosbolivariano.vo.TouresBalonOrdenVO;
import aes.pica.touresbalon.tb_serviciosbolivariano.vo.ViajeVO;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author jdtrujillop
 */
public class ServiciosBolivarianos implements IServiciosBolivarianos {

    private File rutaConsulta;
    private File rutaReservas;
    private FileReader fr;
    private BufferedReader br;
    
    private static final int POSICION_CANCELAR = 6;

    public ServiciosBolivarianos() {
    }

    public ServiciosBolivarianos(String rutaConsulta, String rutaReservas) throws ServiciosBolivarianosExcepcion {
        this.rutaConsulta = new File(rutaConsulta);
        this.rutaReservas = new File(rutaReservas);

        if (this.rutaConsulta.exists() && this.rutaConsulta.isDirectory()) {
        } else {
            throw new ServiciosBolivarianosExcepcion("No existe el directorio de la ruta de consultas");
        }

        if (this.rutaReservas.exists() && this.rutaReservas.isDirectory()) {
        } else {
            throw new ServiciosBolivarianosExcepcion("No existe el directorio de la ruta de reservas");
        }
    }

    @Override
    public List<ViajeVO> consultarViajes(String fechaViaje, String ciudadOrigen, String ciudadDestino) {
        List<ViajeVO> listaViajes = new ArrayList<>();
        String nombreArchivo = Constantes.NAME_VIAJES + fechaViaje + Constantes.CSV_FILE;
        try {
            File archivoConsulta = FileUtils.getFile(rutaConsulta, nombreArchivo);
            if (archivoConsulta != null && archivoConsulta.exists()) {
                List<String> lineasArchivo = FileUtils.readLines(archivoConsulta);
                System.out.println("Archivo encontrado: " + archivoConsulta.getAbsoluteFile());
                ViajeVO viajeAux;
                for (String s : lineasArchivo) {
                    viajeAux = new ViajeVO(s);
                    if (viajeAux.getCiudadOrigen().equalsIgnoreCase(ciudadOrigen)
                            && viajeAux.getCiudadDestino().equalsIgnoreCase(ciudadDestino)) {
                        listaViajes.add(viajeAux);
                    }
                }
            } else {
                System.out.println("No existe archivo: " + nombreArchivo + " en el directorio: " + rutaConsulta);
            }
        } catch (IOException ex) {
            System.err.println(ex.toString());
        }
        return listaViajes;
    }

    @Override
    public List<ViajeVO> consultarViajes(String fechaViaje, String ciudadOrigen, String ciudadDestino, String horaSalida) {
        List<ViajeVO> listaViajes = new ArrayList<>();
        String nombreArchivo = Constantes.NAME_VIAJES + fechaViaje + Constantes.CSV_FILE;
        try {
            File archivoConsulta = FileUtils.getFile(rutaConsulta, nombreArchivo);
            if (archivoConsulta != null && archivoConsulta.exists()) {
                List<String> lineasArchivo = FileUtils.readLines(archivoConsulta);
                System.out.println("Archivo encontrado: " + archivoConsulta.getAbsoluteFile());
                ViajeVO viajeAux;
                for (String s : lineasArchivo) {
                    viajeAux = new ViajeVO(s);
                    if (viajeAux.getCiudadOrigen().equalsIgnoreCase(ciudadOrigen)
                            && viajeAux.getCiudadDestino().equalsIgnoreCase(ciudadDestino)
                            && viajeAux.getHoraSalida().equalsIgnoreCase(horaSalida)) {
                        listaViajes.add(viajeAux);
                    }
                }
            } else {
                System.out.println("No existe archivo: " + nombreArchivo + " en el directorio: " + rutaConsulta);
            }
        } catch (IOException ex) {
            System.err.println(ex.toString());
        }
        return listaViajes;
    }

    @Override
    public boolean crearReserva(String ordenId, String nombres, String apellidos, String fechaSalida, List<ViajeVO> listViajes, boolean sobreEscribir) {
        String nombreArchivo = Constantes.NAME_RESERVAS + ordenId + Constantes.CSV_FILE;
        List<String> lineasArchivo = new ArrayList<>();
        for (ViajeVO v : listViajes) {
            lineasArchivo.add(apellidos.toUpperCase()
                    + "," + nombres.toUpperCase()
                    + "," + fechaSalida.toUpperCase()
                    + "," + v.getNumViaje()
                    + "," + v.getNumSilla()
                    + ","
            );
        }
        try {
            FileUtils.writeLines(new File(rutaReservas, nombreArchivo), lineasArchivo, sobreEscribir);
            return true;
        } catch (IOException ex) {
            System.err.println("Error creando archivo de reservas");
            System.err.println(ex.toString());
        }
        return false;
    }

    @Override
    public List<TouresBalonOrdenVO> consultaReservas(String ordenId) {
        List<TouresBalonOrdenVO> listaReservasTB = new ArrayList<>();
        String nombreArchivo = Constantes.NAME_RESERVAS + ordenId + Constantes.CSV_FILE;
        try {
            File archivoConsulta = FileUtils.getFile(rutaReservas, nombreArchivo);
            if (archivoConsulta != null && archivoConsulta.exists()) {
                List<String> lineasArchivo = FileUtils.readLines(archivoConsulta);
                System.out.println("Archivo encontrado: " + archivoConsulta.getAbsoluteFile());
                for (String s : lineasArchivo) {
                    listaReservasTB.add(new TouresBalonOrdenVO(s));
                }
            } else {
                System.out.println("No existe archivo: " + nombreArchivo + " en el directorio: " + rutaReservas);
            }
        } catch (IOException ex) {
            System.err.println(ex.toString());
        }
        return listaReservasTB;
    }

    @Override
    public boolean cancelarReserva(int ordenId) {

        String nombreArchivo = Constantes.NAME_RESERVAS + ordenId + Constantes.CSV_FILE;
        Random numaleatorio= new Random(3816L); 
        
        try {
            File archivoConsulta = FileUtils.getFile(rutaReservas, nombreArchivo);
            String nombreArchivoNvo = archivoConsulta.getParent() + "/auxiliar" + String.valueOf(Math.abs(numaleatorio.nextInt())) + ".txt";
            File archivoConsultaNvo = new File(nombreArchivoNvo);
            
            if (archivoConsulta != null && archivoConsulta.exists()) {

                br = new BufferedReader(new FileReader(archivoConsulta));
                String linea = "";
                
                while ((linea = br.readLine()) != null) {
                    
                    if (linea.indexOf(ordenId + ",") != -1) {
                        System.out.println("" + linea);
                        String lineaNva = null;
                        for (int i = 0; i <= linea.length(); i++){
                            System.out.println("Caracter " + i + ": " + linea.charAt(i));
                            if (POSICION_CANCELAR == i) {
                                lineaNva.concat("C");   
                            } else {
                                lineaNva.concat(String.valueOf(linea.charAt(i)));
                            }                            
                        }
                        EcribirFichero(archivoConsultaNvo, linea);
                    } else {
                        EcribirFichero(archivoConsulta,linea);
                    }
                    
                }
                BorrarFichero(archivoConsulta);
                archivoConsultaNvo.renameTo(archivoConsulta);
                br.close();             
            
            } else {
                
                System.out.println("No existe archivo: " + nombreArchivo + " en el directorio: " + rutaReservas);
                
            }
            
            return true;
            
        } catch (IOException ex) {
            
            System.err.println(ex.toString());
            
        }
        
        return false;
        
    }
    
    public static void EcribirFichero(File Ffichero, String SCadena) {
        try {
            //Si no Existe el fichero lo crea
            if (!Ffichero.exists()) {
                //Ffichero.createNewFile();
            }
            /*Abre un Flujo de escritura,sobre el fichero con codificacion utf-8. 
           *Además  en el pedazo de sentencia "FileOutputStream(Ffichero,true)",
           *true es por si existe el fichero seguir añadiendo texto y no borrar lo que tenia*/
            BufferedWriter Fescribe = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Ffichero, true), "utf-8"));
            /*Escribe en el fichero la cadena que recibe la función. 
           *el string "\r\n" significa salto de linea*/
            Fescribe.write(SCadena + "\r\n");
            //Cierra el flujo de escritura
            Fescribe.close();
        } catch (Exception ex) {
            //Captura un posible error le imprime en pantalla 
            System.out.println(ex.getMessage());
        }
    }
    
    public static void BorrarFichero(File fichero) {
        try {
            /*Si existe el fichero*/
            if (fichero.exists()) {
                /*Borra el fichero*/
                fichero.delete();
                System.out.println("Fichero Borrado con Exito");
            }
        } catch (Exception ex) {
            /*Captura un posible error y le imprime en pantalla*/
            System.out.println(ex.getMessage());
        }
    }  
    
    //Getters and Setters
    public File getRutaConsulta() {
        return rutaConsulta;
    }

    public void setRutaConsulta(File rutaConsulta) {
        this.rutaConsulta = rutaConsulta;
    }

    public File getRutaReservas() {
        return rutaReservas;
    }

    public void setRutaReservas(File rutaReservas) {
        this.rutaReservas = rutaReservas;
    }

}
