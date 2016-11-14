/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aes.touresbalon.touresbalonoms.beans;

import com.aes.touresbalon.touresbalonoms.services.Services;
import com.aes.touresbalon.touresbalonoms.wsdl.client.ConsultarOrdenesFault_Exception;
import com.aes.touresbalon.touresbalonoms.wsdl.client.CriterioConsultaOrden;
import com.aes.touresbalon.touresbalonoms.wsdl.client.EstatusOrden;
import com.aes.touresbalon.touresbalonoms.wsdl.client.Item;
import com.aes.touresbalon.touresbalonoms.wsdl.client.Orden;
import com.aes.touresbalon.touresbalonoms.wsdl.client.TipoConsultaOrden;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author alexanderbarbosaayala
 */
@ManagedBean(name = "ordenBean")
@ViewScoped
public class OrdenBean {
    
    private int idCliente;
    private Integer idOrden;
    private XMLGregorianCalendar fechaOrden;
    private double precio;
    private EstatusOrden estatus;
    private List<String> comentarios;
    private List<Item> item;
    
    private String tipoConsulta;
    private String txtConsulta;
    
    private Orden orden;
    private List<Orden> ordenList;
    
    private Services service = new Services();
    
    public void consultarOrdenes() {
        List<Orden> ordenes = new ArrayList<>();
        CriterioConsultaOrden criterio = new CriterioConsultaOrden();
        try {
            if (this.getTipoConsulta().equalsIgnoreCase("idOrden")) {
                criterio.setTipoConsulta(TipoConsultaOrden.ORDEN);
                criterio.setCodigo(Integer.parseInt(this.getTxtConsulta()));
                ordenes = getService().consultarOrdenes(criterio);
            }else if (this.getTipoConsulta().equalsIgnoreCase("idPrducto")) {
                criterio.setTipoConsulta(TipoConsultaOrden.PRODUCTO);
                criterio.setCodigo(Integer.parseInt(this.getTxtConsulta()));
                ordenes = getService().consultarOrdenes(criterio);
            }
        } catch (ConsultarOrdenesFault_Exception ex) {
            Logger.getLogger(OrdenBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setOrdenList(ordenes);
        
    }
    
    /**
     * @return the idCliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the idOrden
     */
    public Integer getIdOrden() {
        return idOrden;
    }

    /**
     * @param idOrden the idOrden to set
     */
    public void setIdOrden(Integer idOrden) {
        this.idOrden = idOrden;
    }

    /**
     * @return the fechaOrden
     */
    public XMLGregorianCalendar getFechaOrden() {
        return fechaOrden;
    }

    /**
     * @param fechaOrden the fechaOrden to set
     */
    public void setFechaOrden(XMLGregorianCalendar fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * @return the estatus
     */
    public EstatusOrden getEstatus() {
        return estatus;
    }

    /**
     * @param estatus the estatus to set
     */
    public void setEstatus(EstatusOrden estatus) {
        this.estatus = estatus;
    }

    /**
     * @return the comentarios
     */
    public List<String> getComentarios() {
        return comentarios;
    }

    /**
     * @param comentarios the comentarios to set
     */
    public void setComentarios(List<String> comentarios) {
        this.comentarios = comentarios;
    }

    /**
     * @return the item
     */
    public List<Item> getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(List<Item> item) {
        this.item = item;
    }

    /**
     * @return the tipoConsulta
     */
    public String getTipoConsulta() {
        return tipoConsulta;
    }

    /**
     * @return the txtConsulta
     */
    public String getTxtConsulta() {
        return txtConsulta;
    }

    /**
     * @param tipoConsulta the tipoConsulta to set
     */
    public void setTipoConsulta(String tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    /**
     * @param txtConsulta the txtConsulta to set
     */
    public void setTxtConsulta(String txtConsulta) {
        this.txtConsulta = txtConsulta;
    }

    /**
     * @return the ordenList
     */
    public List<Orden> getOrdenList() {
        return ordenList;
    }

    /**
     * @param ordenList the ordenList to set
     */
    public void setOrdenList(List<Orden> ordenList) {
        this.ordenList = ordenList;
    }

    /**
     * @return the service
     */
    public Services getService() {
        return service;
    }

    /**
     * @param service the service to set
     */
    public void setService(Services service) {
        this.service = service;
    }

    /**
     * @return the orden
     */
    public Orden getOrden() {
        return orden;
    }

    /**
     * @param orden the orden to set
     */
    public void setOrden(Orden orden) {
        this.orden = orden;
    }
    
    
}
