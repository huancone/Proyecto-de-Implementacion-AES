/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aes.touresbalon.touresbalonoms.services;

/**
 *
 * @author alexanderbarbosaayala
 */
public class LoginService {
    
    
    public String validarUsuarioLogin(String usr, String pass){
        String respuesta = null;
        if(usr.equalsIgnoreCase("admin") && pass.equals("admin")){
            respuesta = "OK";
        }else{
            respuesta = "ERROR: Usuario/Contraseña no válidos";
        }
        return respuesta;
    }
}
