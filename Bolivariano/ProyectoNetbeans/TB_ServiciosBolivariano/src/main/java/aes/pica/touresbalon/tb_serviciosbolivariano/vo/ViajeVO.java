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
public class ViajeVO {
    
    private int numViaje;
    private String ciudadOrigen;
    private String ciudadDestino;
    private int numSilla;
    private String horaSalida;

    public ViajeVO() {
    }
    
    public ViajeVO(String lineaCSV) {
        String[] columnas = lineaCSV.split(Constantes.SEPARADOR);
        
        if(columnas.length==5){
            setViajeVO(Integer.parseInt(columnas[0]), columnas[1], columnas[2], Integer.parseInt(columnas[3]), columnas[4]);
        }
    }

    public ViajeVO(int numViaje, String ciudadOrigen, String ciudadDestino, int numSilla, String horaSalida) {
        this.setViajeVO(numViaje, ciudadOrigen, ciudadDestino, numSilla, horaSalida);
    }
    
    public int getNumViaje() {
        return numViaje;
    }

    public void setNumViaje(int numViaje) {
        this.numViaje = numViaje;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public int getNumSilla() {
        return numSilla;
    }

    public void setNumSilla(int numSilla) {
        this.numSilla = numSilla;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }
    
    public void setViajeVO(int numViaje, String ciudadOrigen, String ciudadDestino, int numSilla, String horaSalida) {
        this.numViaje = numViaje;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.numSilla = numSilla;
        this.horaSalida = horaSalida;
    }

    @Override
    public String toString() {
        return "ViajeVO{" + "numViaje=" + numViaje + ", ciudadOrigen=" + ciudadOrigen + ", ciudadDestino=" + ciudadDestino + ", numSilla=" + numSilla + ", horaSalida=" + horaSalida + '}';
    }

}