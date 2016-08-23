/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aes.pica.touresbalon.tb_serviciosbolivariano.vo;

import aes.pica.touresbalon.tb_serviciosbolivariano.utils.Constantes;

/**
 *
 * @author jdtrujillop
 */
public class TouresBalonOrdenVO {

    private String apellidos;
    private String nombres;
    private String fechaSalida;
    private String numViaje;
    private String numSilla;
    private String confirmacion;

    public TouresBalonOrdenVO() {
    }

    public TouresBalonOrdenVO(String lineaCSV) {
        String[] columnas = lineaCSV.split(Constantes.SEPARADOR);
        if (columnas.length == 5) {
            setTouresBalonOrdenVO(columnas[0], columnas[1], columnas[2], columnas[3], columnas[4], null);
        } else if (columnas.length == 6) {
            setTouresBalonOrdenVO(columnas[0], columnas[1], columnas[2], columnas[3], columnas[4], columnas[5]);
        }
    }

    public TouresBalonOrdenVO(String apellidos, String nombres, String fechaSalida, String numViaje, String numSilla, String confirmacion) {
        setTouresBalonOrdenVO(apellidos, nombres, fechaSalida, numViaje, numSilla, confirmacion);
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getNumViaje() {
        return numViaje;
    }

    public void setNumViaje(String numViaje) {
        this.numViaje = numViaje;
    }

    public String getNumSilla() {
        return numSilla;
    }

    public void setNumSilla(String numSilla) {
        this.numSilla = numSilla;
    }

    public String getConfirmacion() {
        return confirmacion;
    }

    public void setConfirmacion(String confirmacion) {
        this.confirmacion = confirmacion;
    }

    public void setTouresBalonOrdenVO(String apellidos, String nombres, String fechaSalida, String numViaje, String numSilla, String confirmacion) {
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.fechaSalida = fechaSalida;
        this.numViaje = numViaje;
        this.numSilla = numSilla;
        this.confirmacion = confirmacion;
    }

    @Override
    public String toString() {
        return "TouresBalonOrdenVO{" + "apellidos=" + apellidos + ", nombres=" + nombres + ", fechaSalida=" + fechaSalida + ", numViaje=" + numViaje + ", numSilla=" + numSilla + ", confirmacion=" + confirmacion + '}';
    }

}
