/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aes.touresbalon.touresbalonoms.utilities;

import com.aes.touresbalon.touresbalonoms.wsdl.client.RespuestaGenerica;
import com.aes.touresbalon.touresbalonoms.wsdl.client.TipoGestionProductoResponse;

/**
 *
 * @author cbraatz
 */
public class ServiciosAdapter {
    
    public static TipoGestionProductoResponse gestionProductoRes(com.touresbalon.productostouresbalon.TipoGestionProductoResponse in){
        TipoGestionProductoResponse res = new TipoGestionProductoResponse();
        res.setIdProducto(in.getIdProducto());
        if(in.getRespuesta()==com.touresbalon.productostouresbalon.RespuestaGenerica.OK){
            res.setRespuesta(RespuestaGenerica.OK);
        }else{
            res.setRespuesta(RespuestaGenerica.KO);
        }
        return res;
    }
    
}
