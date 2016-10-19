/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aes.touresbalon.touresbalonoms.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 *
 * @author alexanderbarbosaayala
 */
@ManagedBean(name = "campannaBean")
@RequestScoped
public class CampannaBean {

    /**
     * Creates a new instance of ProductosBean
     */
    public CampannaBean() {
    }

    private ProductosBean producto;
    private XMLGregorianCalendar fechaInicioCampania;
    private XMLGregorianCalendar fechaFinCampania;

    /**
     * @return the producto
     */
    public ProductosBean getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(ProductosBean producto) {
        this.producto = producto;
    }

    /**
     * @return the fechaInicioCampania
     */
    public XMLGregorianCalendar getFechaInicioCampania() {
        return fechaInicioCampania;
    }

    /**
     * @param fechaInicioCampania the fechaInicioCampania to set
     */
    public void setFechaInicioCampania(XMLGregorianCalendar fechaInicioCampania) {
        this.fechaInicioCampania = fechaInicioCampania;
    }

    /**
     * @return the fechaFinCampania
     */
    public XMLGregorianCalendar getFechaFinCampania() {
        return fechaFinCampania;
    }

    /**
     * @param fechaFinCampania the fechaFinCampania to set
     */
    public void setFechaFinCampania(XMLGregorianCalendar fechaFinCampania) {
        this.fechaFinCampania = fechaFinCampania;
    }
    
    
}
