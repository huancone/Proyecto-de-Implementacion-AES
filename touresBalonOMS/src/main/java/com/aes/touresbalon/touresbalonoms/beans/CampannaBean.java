/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aes.touresbalon.touresbalonoms.beans;

import com.aes.touresbalon.touresbalonoms.services.Services;
import com.aes.touresbalon.touresbalonoms.utilities.OmsUtil;
import com.aes.touresbalon.touresbalonoms.wsdl.client.Producto;
import com.aes.touresbalon.touresbalonoms.wsdl.client.TipoConsultaProducto;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.xml.datatype.DatatypeConfigurationException;
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
    private Date fechaInicioCampania;
    private Date fechaFinCampania;
    
    private String tipoConsulta;
    private String txtConsulta;
    
    private Producto productoSel;
    private List<Producto> productoList;
    
    Services service = new Services();
    
    public void crearCampanna(){
        try {
            XMLGregorianCalendar fechaInicioCampanna = OmsUtil.stringToXMLGreogrianCalendar(this.getFechaInicioCampania());
            XMLGregorianCalendar fechaFinCampanna = OmsUtil.stringToXMLGreogrianCalendar(this.getFechaFinCampania());

        } catch (ParseException ex) {
            Logger.getLogger(CampannaBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(CampannaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void eliminarCampanna(){
        try {
            XMLGregorianCalendar fechaInicioCampanna = OmsUtil.stringToXMLGreogrianCalendar(this.getFechaInicioCampania());
            XMLGregorianCalendar fechaFinCampanna = OmsUtil.stringToXMLGreogrianCalendar(this.getFechaFinCampania());

        } catch (ParseException ex) {
            Logger.getLogger(CampannaBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(CampannaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void consultarProducto() {
        List<Producto> productos = new ArrayList<>();
        if (this.getTipoConsulta().equalsIgnoreCase("id")) {
            productos = service.consultarProducto(TipoConsultaProducto.ID, this.getTxtConsulta());
        } else if (this.getTipoConsulta().equalsIgnoreCase("nombre")) {
            productos = service.consultarProducto(TipoConsultaProducto.NOMBRE, this.getTxtConsulta());
        } else if (this.getTipoConsulta().equalsIgnoreCase("descripcion")) {
            productos = service.consultarProducto(TipoConsultaProducto.DESCRIPCION, this.getTxtConsulta());
        }
        this.setProductoList(productos);
    }
    
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
    public Date getFechaInicioCampania() {
        return fechaInicioCampania;
    }

    /**
     * @param fechaInicioCampania the fechaInicioCampania to set
     */
    public void setFechaInicioCampania(Date fechaInicioCampania) {
        this.fechaInicioCampania = fechaInicioCampania;
    }

    /**
     * @return the fechaFinCampania
     */
    public Date getFechaFinCampania() {
        return fechaFinCampania;
    }

    /**
     * @param fechaFinCampania the fechaFinCampania to set
     */
    public void setFechaFinCampania(Date fechaFinCampania) {
        this.fechaFinCampania = fechaFinCampania;
    }

    /**
     * @return the productoSel
     */
    public Producto getProductoSel() {
        return productoSel;
    }

    /**
     * @param productoSel the productoSel to set
     */
    public void setProductoSel(Producto productoSel) {
        this.productoSel = productoSel;
    }

    /**
     * @return the productoList
     */
    public List<Producto> getProductoList() {
        return productoList;
    }

    /**
     * @param productoList the productoList to set
     */
    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    /**
     * @return the tipoConsulta
     */
    public String getTipoConsulta() {
        return tipoConsulta;
    }

    /**
     * @param tipoConsulta the tipoConsulta to set
     */
    public void setTipoConsulta(String tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    /**
     * @return the txtConsulta
     */
    public String getTxtConsulta() {
        return txtConsulta;
    }

    /**
     * @param txtConsulta the txtConsulta to set
     */
    public void setTxtConsulta(String txtConsulta) {
        this.txtConsulta = txtConsulta;
    }
    
    
}
