/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aes.pica.touresbalon.reservas.util;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author jdtrujillop
 */
public class ValidacionCupoTarjeta {

    final static List<BigInteger> listaNegra = Arrays.asList(
            new BigInteger("1"),
           // new BigInteger("232482885596"),
            new BigInteger("3")
    );

    public static boolean hayCupo(BigInteger valor) {
        for (BigInteger val : listaNegra) 
            if (val.equals(valor)) 
                return false;
        return true;
    }

}
