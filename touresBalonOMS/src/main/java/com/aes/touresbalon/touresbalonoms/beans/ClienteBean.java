/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aes.touresbalon.touresbalonoms.beans;

import com.aes.touresbalon.touresbalonoms.services.Services;
import com.aes.touresbalon.touresbalonoms.wsdl.client.ActualizarClienteFault_Exception;
import com.aes.touresbalon.touresbalonoms.wsdl.client.Cliente;
import com.aes.touresbalon.touresbalonoms.wsdl.client.ConsultarPorIdentificacionClienteFault_Exception;
import com.aes.touresbalon.touresbalonoms.wsdl.client.Direccion;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author alexanderbarbosaayala
 */
@ManagedBean(name = "clienteBean")
@ViewScoped
public class ClienteBean {
    private Integer idCliente;
    private String nombres;
    private String apellidos;
    private String numTel;
    private String email;
    private String contrasenia;
    private String tipoTarjeta;
    private String numeroTarjeta;
    private List<Direccion> direccion;
    
    private String tipoConsulta;
    private String txtConsulta;
    
    private Cliente cliente;
    private List<Cliente> clienteList;
    
    Services service = new Services();
    
    public void actualizarCliente(){
        cliente.setIdCliente(this.getIdCliente());
        cliente.setNombres(this.getApellidos());
        cliente.setApellidos(this.getApellidos());
        cliente.setNumTel(this.getNumTel());
        cliente.setTipoTarjeta(this.getTipoTarjeta());
        cliente.setNumeroTarjeta(this.getNumeroTarjeta());
        cliente.setEmail(this.getEmail());
        cliente.setContrasenia(this.getContrasenia());
        
        try {
            service.actualizarCliente(cliente);
        } catch (ActualizarClienteFault_Exception ex) {
            Logger.getLogger(ClienteBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void consultarCliente() {
        List<Cliente> clientes = new ArrayList<>();
        try {
            if (this.getTipoConsulta().equalsIgnoreCase("id")) {
                clientes.add(service.consultarPorIdentificacionCliente(Integer.parseInt(this.getTxtConsulta())));
            }
        } catch (ConsultarPorIdentificacionClienteFault_Exception ex) {
            Logger.getLogger(ClienteBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setClienteList(clientes);
    }
    
    /**
     * @return the idCliente
     */
    public Integer getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the numTel
     */
    public String getNumTel() {
        return numTel;
    }

    /**
     * @param numTel the numTel to set
     */
    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the contrasenia
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * @param contrasenia the contrasenia to set
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * @return the tipoTarjeta
     */
    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    /**
     * @param tipoTarjeta the tipoTarjeta to set
     */
    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    /**
     * @return the numeroTarjeta
     */
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    /**
     * @param numeroTarjeta the numeroTarjeta to set
     */
    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    /**
     * @return the direccion
     */
    public List<Direccion> getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(List<Direccion> direccion) {
        this.direccion = direccion;
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
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the clienteList
     */
    public List<Cliente> getClienteList() {
        return clienteList;
    }

    /**
     * @param clienteList the clienteList to set
     */
    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }
}
