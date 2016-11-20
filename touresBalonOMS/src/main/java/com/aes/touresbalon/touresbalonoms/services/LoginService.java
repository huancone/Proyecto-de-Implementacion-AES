/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aes.touresbalon.touresbalonoms.services;

import com.aes.touresbalon.touresbalonoms.utilities.ContactAttributeMapperJSON;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.ldap.core.DistinguishedName;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.EqualsFilter;

/**
 *
 * @author alexanderbarbosaayala
 */
public class LoginService {

    private static String url = "ldap://touresbalon.local:389";
    private static String base = "DC=touresbalon,DC=local";
    private static String usrDn = "CN=Administrator,CN=Users,DC=touresbalon,DC=local";
    private static String password = "aes123$";

    public String validarUsuarioLogin(String usr, String pass) {
        String respuesta = null;
        
        //Sin LDAP
//        if (usr.equalsIgnoreCase("admin") && pass.equals("admin")) {
//            respuesta = "OK";
//        } else {
//            respuesta = "ERROR: Usuario/Contraseña no válidos";
//        }
        
        //CON LDAP
        if (autenticacionLDAP(usr,pass)) {
            respuesta = "OK";
        } else {
            respuesta = "ERROR: Usuario/Contraseña no válidos";
        }
        
        return respuesta;
    }

    private boolean autenticacionLDAP(String usr, String pass) {
        boolean res = false;

        try {
            LdapContextSource ctxSrc = new LdapContextSource();
            ctxSrc.setUrl(url);
            ctxSrc.setBase(base);
            ctxSrc.setUserDn(usrDn);
            ctxSrc.setPassword(password);
            ctxSrc.setReferral("follow");
            ctxSrc.afterPropertiesSet();
            LdapTemplate lt = new LdapTemplate(ctxSrc);

            AndFilter filter = new AndFilter();
            filter.and(new EqualsFilter("objectclass", "person"));

            List<String> list = lt.search("", filter.encode(), new ContactAttributeMapperJSON());
            System.out.println(list.toString());

            System.out.println("Auntenticando a " + usr);
            filter.and(new EqualsFilter("sAMAccountName", usr));
            if (lt.authenticate(DistinguishedName.EMPTY_PATH, filter.toString(), pass)) {
                System.out.println("Autenticacion Exitosa a: "+usr);
                res = true;
            } else {
                System.err.println("Autenticacion Fallida a :"+usr);
            }

        } catch (Exception ex) {
           // Logger.getLogger(LDAPView.class.getName()).log(Level.SEVERE, null, ex);
        }

        return res;
    }
}
