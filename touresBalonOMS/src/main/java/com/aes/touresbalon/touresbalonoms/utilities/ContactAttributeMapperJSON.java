/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aes.touresbalon.touresbalonoms.utilities;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import org.json.JSONObject;
import org.springframework.ldap.core.AttributesMapper;

/**
 *
 * @author jdtrujillop
 */
public class ContactAttributeMapperJSON implements AttributesMapper{

    @Override
    public Object mapFromAttributes(Attributes atrbts) throws NamingException {
        NamingEnumeration<String> ids = atrbts.getIDs();
        JSONObject jo = new JSONObject();
        while(ids.hasMore()){
            String id = ids.next();
            jo.put(id, atrbts.get(id).get());
        }
        return jo.toString();
        
    }
    
}
