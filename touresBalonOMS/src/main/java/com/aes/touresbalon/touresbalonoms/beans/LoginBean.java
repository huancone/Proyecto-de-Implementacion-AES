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
    
    private String mensajePagina;
    
    LoginService service = new LoginService();
    
    public void login(ActionEvent event){
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedIn = false;
        
        mensajePagina = service.validarUsuarioLogin(this.idUsuario,this.passUsuario);
        
        if (mensajePagina.equalsIgnoreCase("OK")){
            
            //Redireccion en caso exitoso
            try{
            FacesContext contex = FacesContext.getCurrentInstance();
            contex.getExternalContext().redirect( "/touresBalonOMS/principal_Content.xhtml" );
            }catch(  Exception e ){
                System.out.println("Redireccion fallida" );
            }
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", idUsuario);
        }else {
            
            //Redireccion en caso NO EXITOSO 
            try{
            FacesContext contex = FacesContext.getCurrentInstance();
            contex.getExternalContext().redirect( "/touresBalonOMS/principal.xhtml" );
            }catch(  Exception e ){
                System.out.println("Redireccion fallida" );
            }
            
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

    /**
     * @return the mensajePagina
     */
    public String getMensajePagina() {
        return mensajePagina;
    }

    /**
     * @param mensajePagina the mensajePagina to set
     */
    public void setMensajePagina(String mensajePagina) {
        this.mensajePagina = mensajePagina;
    }

    
}
