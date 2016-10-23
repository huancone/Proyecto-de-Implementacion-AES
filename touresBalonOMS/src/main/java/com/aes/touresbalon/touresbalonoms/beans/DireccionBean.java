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
@ManagedBean(name = "direccionBean")
@RequestScoped
public class DireccionBean {
    private Integer idDireccion;
    private String pais;
    private String ciudad;
    private String estado;
    private String codPostal;
    private String tipoDir;
    private String dirCalle;

    /**
     * @return the idDireccion
     */
    public Integer getIdDireccion() {
        return idDireccion;
    }

    /**
     * @param idDireccion the idDireccion to set
     */
    public void setIdDireccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    /**
     * @return the pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the codPostal
     */
    public String getCodPostal() {
        return codPostal;
    }

    /**
     * @param codPostal the codPostal to set
     */
    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    /**
     * @return the tipoDir
     */
    public String getTipoDir() {
        return tipoDir;
    }

    /**
     * @param tipoDir the tipoDir to set
     */
    public void setTipoDir(String tipoDir) {
        this.tipoDir = tipoDir;
    }

    /**
     * @return the dirCalle
     */
    public String getDirCalle() {
        return dirCalle;
    }

    /**
     * @param dirCalle the dirCalle to set
     */
    public void setDirCalle(String dirCalle) {
        this.dirCalle = dirCalle;
    }
    
    
}
