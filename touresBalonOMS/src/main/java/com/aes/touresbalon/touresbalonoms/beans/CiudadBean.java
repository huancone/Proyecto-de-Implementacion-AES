/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aes.touresbalon.touresbalonoms.beans;

import com.aes.touresbalon.touresbalonoms.wsdl.client.Ciudad;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author alexanderbarbosaayala
 */
@ManagedBean(name = "ciudadBean")
@RequestScoped
public class CiudadBean {
    
    private Integer idCiudad;
    private String pais;
    private List<TarifaValoresBean> tipoCiudad;
    
    
    public Ciudad getCiudadObj(){
        Ciudad cb = new Ciudad();
        cb.setIdCiudad(idCiudad);
        cb.setPais(pais);
        return cb;
    }
    
    /**
     * @return the idCiudad
     */
    public Integer getIdCiudad() {
        return idCiudad;
    }

    /**
     * @param idCiudad the idCiudad to set
     */
    public void setIdCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
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
     * @return the tipoCiudad
     */
    public List<TarifaValoresBean> getTipoCiudad() {
        return tipoCiudad;
    }

    /**
     * @param tipoCiudad the tipoCiudad to set
     */
    public void setTipoCiudad(List<TarifaValoresBean> tipoCiudad) {
        this.tipoCiudad = tipoCiudad;
    }
    
    
}
