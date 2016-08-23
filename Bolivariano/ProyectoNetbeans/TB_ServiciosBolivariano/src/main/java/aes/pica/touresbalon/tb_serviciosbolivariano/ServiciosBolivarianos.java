/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aes.pica.touresbalon.tb_serviciosbolivariano;

import aes.pica.touresbalon.tb_serviciosbolivariano.utils.Constantes;
import aes.pica.touresbalon.tb_serviciosbolivariano.vo.TouresBalonOrdenVO;
import aes.pica.touresbalon.tb_serviciosbolivariano.vo.ViajeVO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author jdtrujillop
 */
public class ServiciosBolivarianos implements IServiciosBolivarianos {

    private File rutaConsulta;
    private File rutaReservas;

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
