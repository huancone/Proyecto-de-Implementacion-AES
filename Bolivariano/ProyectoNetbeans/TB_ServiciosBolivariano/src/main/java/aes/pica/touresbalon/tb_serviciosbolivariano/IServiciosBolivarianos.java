/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aes.pica.touresbalon.tb_serviciosbolivariano;

import aes.pica.touresbalon.tb_serviciosbolivariano.vo.TouresBalonOrdenVO;
import aes.pica.touresbalon.tb_serviciosbolivariano.vo.ViajeVO;
import java.util.List;

/**
 *
 * @author jdtrujillop
 * @version 1.0
 */
public interface IServiciosBolivarianos {
    
    //Metodos para consultar viajes de Bolivariano
    //Sin criterio de hora de salida
    public List<ViajeVO> consultarViajes(String fechaViaje, String ciudadOrigen, String ciudadDestino);
    
    //Con criterio de hora de salida
    public List<ViajeVO> consultarViajes(String fechaViaje, String ciudadOrigen, String ciudadDestino,String horaSalida);
    
    //Metodo para crear un archivo de reserva
    public boolean crearReserva(String ordenId,String nombres, String apellidos, String fechaSalida, List<ViajeVO> listViajes,boolean sobreEscribir); 
    
    //Metodo para consultar archivo de reservas
    public List<TouresBalonOrdenVO> consultaReservas(String ordenId);
}
