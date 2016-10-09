/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aes.pica.touresbalon.touresbalonproductosws.servicios;

import aes.pica.touresbalon.touresbalonproductosws.entidades.clientesyordenes.Address;
import aes.pica.touresbalon.touresbalonproductosws.entidades.clientesyordenes.Customer;
import aes.pica.touresbalon.touresbalonproductosws.entidades.clientesyordenes.CustomerAddress;
import aes.pica.touresbalon.touresbalonproductosws.entidades.clientesyordenes.CustomerAddressId;
import aes.pica.touresbalon.touresbalonproductosws.util.ClientesyOrdenesHU;
import com.touresbalon.clientestouresbalon.ActualizarClienteFault_Exception;
import com.touresbalon.clientestouresbalon.ActualizarContraseniaClienteFault_Exception;
import com.touresbalon.clientestouresbalon.ActualizarEstatusClienteFault_Exception;
import com.touresbalon.clientestouresbalon.AutenticarClienteFault_Exception;
import com.touresbalon.clientestouresbalon.Cliente;
import com.touresbalon.clientestouresbalon.ConsultarPorFactRangoClienteFault_Exception;
import com.touresbalon.clientestouresbalon.ConsultarPorIdentificacionClienteFault_Exception;
import com.touresbalon.clientestouresbalon.ConsultarPorProductoClienteFault_Exception;
import com.touresbalon.clientestouresbalon.Direccion;
import com.touresbalon.clientestouresbalon.EstatusCliente;
import com.touresbalon.clientestouresbalon.RegistrarClienteFault_Exception;
import com.touresbalon.clientestouresbalon.RegistrarClienteReponseType;
import com.touresbalon.clientestouresbalon.RespuestaGenerica;
import javax.jws.WebService;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author braatz
 */
@WebService(serviceName = "ClientesTouresBalon", portName = "ClientesTouresBalonSOAP", endpointInterface = "com.touresbalon.clientestouresbalon.ClientesTouresBalon", targetNamespace = "http://www.touresbalon.com/ClientesTouresBalon/", wsdlLocation = "WEB-INF/wsdl/ClientesTouresBalon.wsdl")
public class Services {
    
    //Variables globlales
    private Session sessionClientes;
    private Session sessionProductos;
    private Transaction tx;

    public com.touresbalon.clientestouresbalon.RegistrarClienteReponseType registrarCliente(com.touresbalon.clientestouresbalon.Cliente cliente) throws RegistrarClienteFault_Exception {
        
        System.out.println(" ---------------- Entramos registrarCliente ----------------- ");
        Customer clienteEntidad = new Customer();
        Address addr = new Address();

        if(cliente != null){
            clienteEntidad.setFname(cliente.getNombres());
            clienteEntidad.setLname(cliente.getApellidos());
            clienteEntidad.setPhonenumber(cliente.getNumTel());
            clienteEntidad.setEmail(cliente.getEmail());
            clienteEntidad.setPassword(cliente.getContrasenia());
            clienteEntidad.setCreditcardtype(cliente.getTipoTarjeta());
            clienteEntidad.setCreditcardnumber(cliente.getNumeroTarjeta());
            
            Direccion direccionCliente = null;
            if(cliente.getDireccion() != null && !cliente.getDireccion().isEmpty()){
                direccionCliente = cliente.getDireccion().get(0);
            }
                        
            //Mapeo de Direccion a Address
            if(direccionCliente != null) {                
                addr.setZip(direccionCliente.getCodPostal());
                addr.setCity(direccionCliente.getCiudad());
                addr.setAddressType(direccionCliente.getTipoDir());
                addr.setCountry(direccionCliente.getPais());
                addr.setState(direccionCliente.getEstado());
                addr.setStreet(direccionCliente.getDirCalle());
            } else {
                System.out.println("ERROR registrarCliente: Direccion del cliente null");
            }            
        }
                       
        //Se prepara la operacion en BD
        sessionClientes = ClientesyOrdenesHU.getSessionFactory().getCurrentSession();
        tx = sessionClientes.beginTransaction();
       
        Integer idCliente = 0,idAddr;
        try {            
            idAddr = (Integer) sessionClientes.save(addr);
            idCliente = (Integer) sessionClientes.save(clienteEntidad);
            
            CustomerAddress customerAddress = new CustomerAddress();
            customerAddress.setId(new CustomerAddressId(idCliente,idAddr));
            
            sessionClientes.save(customerAddress);
            tx.commit();            

            System.out.println("este es el id de Oracle: " + idCliente);            
        } catch (Exception e) {
            System.out.println("Error al registrar cliente !!!" + e.getMessage());
        } finally {
            if (sessionClientes != null && sessionClientes.isOpen()) {
                sessionClientes.close();
            }
        }
             
        RegistrarClienteReponseType respuesta = new RegistrarClienteReponseType();
        respuesta.setRespuesta((idCliente != 0)?RespuestaGenerica.OK:RespuestaGenerica.KO);
        System.out.println("--------------- Saliendo ---------------");
        return respuesta;
    }

    public com.touresbalon.clientestouresbalon.RespuestaGenerica autenticarCliente(java.lang.String usuario, java.lang.String contrasenia) throws AutenticarClienteFault_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public com.touresbalon.clientestouresbalon.RespuestaGenerica actualizarCliente(com.touresbalon.clientestouresbalon.Cliente cliente) throws ActualizarClienteFault_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public com.touresbalon.clientestouresbalon.RespuestaGenerica actualizarContraseniaCliente(java.lang.String usuario, java.lang.String contrasenia) throws ActualizarContraseniaClienteFault_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public com.touresbalon.clientestouresbalon.RespuestaGenerica actualizarEstatusCliente(int idCliente, com.touresbalon.clientestouresbalon.EstatusCliente estatus) throws ActualizarEstatusClienteFault_Exception {
        System.out.println(" ---------------- Entramos actualizarEstatusCliente ----------------- ");
        RespuestaGenerica respuesta = RespuestaGenerica.KO;
        Customer clienteEntidad = new Customer();
        
        try {
            sessionClientes = ClientesyOrdenesHU.getSessionFactory().getCurrentSession();
            tx = sessionClientes.beginTransaction();

            clienteEntidad = (Customer) sessionClientes.load(Customer.class,
                    idCliente);

        } catch (Exception e) {
            System.out.println("ERROR actualizarEstatusCliente: " + e.getMessage());
        }
        
        if(clienteEntidad != null && estatus != null){
            clienteEntidad.setStatus(estatus.name());
            try {
                sessionClientes.save(clienteEntidad);
                tx.commit();            
                System.out.println("este es el id de Oracle: " + idCliente);
                respuesta = RespuestaGenerica.OK;
            } catch (Exception e) {
                System.out.println("ERROR persistiendo Cliente actualizado" + e.getMessage());
            }
        }
        
        System.out.println("--------------- Saliendo ---------------");
        return respuesta;                
    }

    public com.touresbalon.clientestouresbalon.Cliente consultarPorIdentificacionCliente(int idCliente) throws ConsultarPorIdentificacionClienteFault_Exception {
        System.out.println(" ---------------- Entramos consultarPorIdentificacionCliente----------------- ");
        
        Cliente clienteRta = new Cliente();
        Customer clienteEntidad = new Customer();

        try {
            sessionClientes = ClientesyOrdenesHU.getSessionFactory().getCurrentSession();
            tx = sessionClientes.beginTransaction();

            clienteEntidad = (Customer) sessionClientes.load(Customer.class,
                    idCliente);

        } catch (Exception e) {
            System.out.println("ERROR consultarPorIdentificacionCliente: " + e.getMessage());
        }

        System.out.println("Salimos con resultado: " + ((clienteEntidad!=null)?clienteEntidad.getFname():"cliente nulo"));

        if(clienteEntidad != null){
            clienteRta.setNombres(clienteEntidad.getFname());
            clienteRta.setApellidos(clienteEntidad.getLname());
            clienteRta.setContrasenia(clienteEntidad.getPassword());
            clienteRta.setEmail(clienteEntidad.getEmail());
            try {
                clienteRta.setEstatus(EstatusCliente.fromValue(clienteEntidad.getStatus()));                    
            } catch (Exception e) {
                System.out.println("EstatusCliente no corresponde"
                        + clienteEntidad.getStatus() + e.getMessage());
            }
            clienteRta.setNumTel(clienteEntidad.getPhonenumber());
            clienteRta.setNumeroTarjeta(clienteEntidad.getCreditcardnumber());
            clienteRta.setTipoTarjeta(clienteEntidad.getCreditcardtype());
            clienteRta.setIdCliente(clienteEntidad.getCustid());
        }

        if (sessionClientes != null && sessionClientes.isOpen()) {
            sessionClientes.close();
        }
        System.out.println("--------------- Saliendo ---------------");
        return clienteRta;
    }

    public java.util.List<com.touresbalon.clientestouresbalon.Cliente> consultarPorProductoCliente(int idProducto) throws ConsultarPorProductoClienteFault_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public java.util.List<com.touresbalon.clientestouresbalon.Cliente> consultarPorFactRangoCliente(javax.xml.datatype.XMLGregorianCalendar fechaInicial, javax.xml.datatype.XMLGregorianCalendar fechaFin) throws ConsultarPorFactRangoClienteFault_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }
    
}
