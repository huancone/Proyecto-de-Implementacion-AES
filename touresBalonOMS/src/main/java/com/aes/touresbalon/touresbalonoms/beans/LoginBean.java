/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aes.touresbalon.touresbalonoms.beans;

import com.aes.touresbalon.touresbalonoms.services.LoginService;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;

/**
 *
 * @author alexanderbarbosaayala
 */
@ManagedBean(name = "loginBean")
@ViewScoped
public class LoginBean {
    private String idUsuario;
    private String passUsuario;
    
    LoginService service = new LoginService();
    
    public void login(ActionEvent event){
        String validarUsr = null;
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedIn = false;
        
        validarUsr = service.validarUsuarioLogin(this.idUsuario,this.passUsuario);
        
        if (validarUsr.equalsIgnoreCase("OK")){
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", idUsuario);
        }else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedIn", loggedIn);
    }
    
    /**
     * @return the idUsuario
     */
    public String getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the passUsuario
     */
    public String getPassUsuario() {
        return passUsuario;
    }

    /**
     * @param passUsuario the passUsuario to set
     */
    public void setPassUsuario(String passUsuario) {
        this.passUsuario = passUsuario;
    }

    
}
