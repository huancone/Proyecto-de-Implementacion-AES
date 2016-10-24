/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aes.touresbalon.touresbalonoms.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author alexanderbarbosaayala
 */
@ManagedBean(name = "itemBean")
@RequestScoped
public class ItemBean {
    private int idItem;
    private int idProd;
    private String nombreProd;
    private String partNum;
    private double precio;
    private int cantidad;
    private Integer idOrden;

    /**
     * @return the idItem
     */
    public int getIdItem() {
        return idItem;
    }

    /**
     * @param idItem the idItem to set
     */
    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    /**
     * @return the idProd
     */
    public int getIdProd() {
        return idProd;
    }

    /**
     * @param idProd the idProd to set
     */
    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    /**
     * @return the nombreProd
     */
    public String getNombreProd() {
        return nombreProd;
    }

    /**
     * @param nombreProd the nombreProd to set
     */
    public void setNombreProd(String nombreProd) {
        this.nombreProd = nombreProd;
    }

    /**
     * @return the partNum
     */
    public String getPartNum() {
        return partNum;
    }

    /**
     * @param partNum the partNum to set
     */
    public void setPartNum(String partNum) {
        this.partNum = partNum;
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
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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
    
    
}
