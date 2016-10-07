/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aes.touresbalon.touresbalonoms.beans;

import com.aes.touresbalon.touresbalonoms.services.Servicio;
import com.aes.touresbalon.touresbalonoms.wsdl.client.Ciudad;
import com.aes.touresbalon.touresbalonoms.wsdl.client.TarifaValores;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author deirovir
 */
@ManagedBean(name = "productosBean")
@RequestScoped
public class ProductosBean {

    /**
     * Creates a new instance of ProductosBean
     */
    public ProductosBean() {
    }
     
    private int idProducto;
    private String espectaculo;
    private String descripcion;
    private Ciudad ciudadEspectaculo;
    private XMLGregorianCalendar fechaLlegada;
    private XMLGregorianCalendar fechaSalida;
    private XMLGregorianCalendar fechaEspectaculo;
    private TarifaValores tipoTransporte;
    private TarifaValores tipoEspectaculo;
    private TarifaValores tipoHospedaje;
    private String imagenProducto;
    
    
     public void crearProducto(){
         Servicio service = new Servicio();
         
         service.crearProducto();
     }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getEspectaculo() {
        return espectaculo;
    }

    public void setEspectaculo(String espectaculo) {
        this.espectaculo = espectaculo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Ciudad getCiudadEspectaculo() {
        return ciudadEspectaculo;
    }

    public void setCiudadEspectaculo(Ciudad ciudadEspectaculo) {
        this.ciudadEspectaculo = ciudadEspectaculo;
    }

    public XMLGregorianCalendar getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(XMLGregorianCalendar fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public XMLGregorianCalendar getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(XMLGregorianCalendar fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public XMLGregorianCalendar getFechaEspectaculo() {
        return fechaEspectaculo;
    }

    public void setFechaEspectaculo(XMLGregorianCalendar fechaEspectaculo) {
        this.fechaEspectaculo = fechaEspectaculo;
    }

    public TarifaValores getTipoTransporte() {
        return tipoTransporte;
    }

    public void setTipoTransporte(TarifaValores tipoTransporte) {
        this.tipoTransporte = tipoTransporte;
    }

    public TarifaValores getTipoEspectaculo() {
        return tipoEspectaculo;
    }

    public void setTipoEspectaculo(TarifaValores tipoEspectaculo) {
        this.tipoEspectaculo = tipoEspectaculo;
    }

    public TarifaValores getTipoHospedaje() {
        return tipoHospedaje;
    }

    public void setTipoHospedaje(TarifaValores tipoHospedaje) {
        this.tipoHospedaje = tipoHospedaje;
    }

    public String getImagenProducto() {
        return imagenProducto;
    }

    public void setImagenProducto(String imagenProducto) {
        this.imagenProducto = imagenProducto;
    }
    
}
