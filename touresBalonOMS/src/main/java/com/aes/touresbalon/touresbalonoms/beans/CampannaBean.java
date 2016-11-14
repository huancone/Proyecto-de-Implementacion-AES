/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aes.touresbalon.touresbalonoms.beans;

import com.aes.touresbalon.touresbalonoms.services.Services;
import com.aes.touresbalon.touresbalonoms.utilities.OmsUtil;
import com.aes.touresbalon.touresbalonoms.wsdl.client.Campania;
import com.aes.touresbalon.touresbalonoms.wsdl.client.GestionCampaniaProductoFault_Exception;
import com.aes.touresbalon.touresbalonoms.wsdl.client.Producto;
import com.aes.touresbalon.touresbalonoms.wsdl.client.TipoAccion;
import com.aes.touresbalon.touresbalonoms.wsdl.client.TipoConsultaProducto;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 *
 * @author alexanderbarbosaayala
 */
@ManagedBean(name = "campannaBean")
@ViewScoped
public class CampannaBean {

    private Date fechaInicioCampania;
    private Date fechaFinCampania;
    
    private String tipoConsulta;
    private String txtConsulta;
    
    private Producto productoSel;
    private List<Producto> productoList;
    private TipoAccion tipoAccion;
    
    Services service = new Services();
    Campania campania = new Campania();
    
    /**
     * Creates a new instance of ProductosBean
     */
    public CampannaBean() {
    }
    
    @PostConstruct
    public void init(){
        this.tipoConsulta = "id";
    }
    
    public void crearCampanna() {
        try {
            XMLGregorianCalendar fechaInicioCampanna = OmsUtil.stringToXMLGreogrianCalendar(this.getFechaInicioCampania());

            XMLGregorianCalendar fechaFinCampanna = OmsUtil.stringToXMLGreogrianCalendar(this.getFechaFinCampania());
            campania.setIdProducto(productoSel);
            campania.setFechaInicioCampania(fechaInicioCampanna);
            campania.setFechaFinCampania(fechaFinCampanna);
            this.setTipoAccion(TipoAccion.ADICIONAR);

            service.gestionCampaniaProducto(this.getTipoAccion(), campania);
        } catch (GestionCampaniaProductoFault_Exception | ParseException | DatatypeConfigurationException ex) {
            Logger.getLogger(CampannaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarCampanna() {
        try {
            XMLGregorianCalendar fechaInicioCampanna = OmsUtil.stringToXMLGreogrianCalendar(this.getFechaInicioCampania());
            XMLGregorianCalendar fechaFinCampanna = OmsUtil.stringToXMLGreogrianCalendar(this.getFechaFinCampania());
            campania.setIdProducto(productoSel);
            campania.setFechaInicioCampania(fechaInicioCampanna);
            campania.setFechaFinCampania(fechaFinCampanna);
            this.setTipoAccion(TipoAccion.ELIMINAR);

            service.gestionCampaniaProducto(this.getTipoAccion(), campania);

        } catch (ParseException | DatatypeConfigurationException | GestionCampaniaProductoFault_Exception ex) {
            Logger.getLogger(CampannaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void editarCampanna() {
        try {
            XMLGregorianCalendar fechaInicioCampanna = OmsUtil.stringToXMLGreogrianCalendar(this.getFechaInicioCampania());

            XMLGregorianCalendar fechaFinCampanna = OmsUtil.stringToXMLGreogrianCalendar(this.getFechaFinCampania());
            campania.setIdProducto(productoSel);
            campania.setFechaInicioCampania(fechaInicioCampanna);
            campania.setFechaFinCampania(fechaFinCampanna);
            this.setTipoAccion(TipoAccion.MODIFICAR);

            service.gestionCampaniaProducto(this.getTipoAccion(), campania);
        } catch (GestionCampaniaProductoFault_Exception | ParseException | DatatypeConfigurationException ex) {
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

    /**
     * @return the tipoAccion
     */
    public TipoAccion getTipoAccion() {
        return tipoAccion;
    }

    /**
     * @param tipoAccion the tipoAccion to set
     */
    public void setTipoAccion(TipoAccion tipoAccion) {
        this.tipoAccion = tipoAccion;
    }
    
    
}
