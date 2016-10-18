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
import aes.pica.touresbalon.touresbalonproductosws.util.Utils;
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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.jws.WebService;
import oracle.sql.DATE;
import org.hibernate.Query;
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
        RegistrarClienteReponseType respuesta = new RegistrarClienteReponseType();

        if (cliente != null) {
            clienteEntidad.setFname(cliente.getNombres());
            clienteEntidad.setLname(cliente.getApellidos());
            clienteEntidad.setPhonenumber(cliente.getNumTel());
            clienteEntidad.setEmail(cliente.getEmail());
            clienteEntidad.setPassword(cliente.getContrasenia());
            clienteEntidad.setCreditcardtype(cliente.getTipoTarjeta());
            clienteEntidad.setCreditcardnumber(cliente.getNumeroTarjeta());

            Direccion direccionCliente = null;
            if (cliente.getDireccion() != null && !cliente.getDireccion().isEmpty()) {
                direccionCliente = cliente.getDireccion().get(0);
            }

            //Mapeo de Direccion a Address
            if (direccionCliente != null) {
                addr.setZip(direccionCliente.getCodPostal());
                addr.setCity(direccionCliente.getCiudad());
                addr.setAddressType(direccionCliente.getTipoDir());
                addr.setCountry(direccionCliente.getPais());
                addr.setState(direccionCliente.getEstado());
                addr.setStreet(direccionCliente.getDirCalle());
            } else {
                System.out.println("ERROR registrarCliente: Direccion del cliente, null");
            }
        } else {
            System.out.println("El cliente es null");
            respuesta.setRespuesta(RespuestaGenerica.KO);
            respuesta.setIdCliente(0);
            return respuesta;
        }

        //Se prepara la operacion en BD
        sessionClientes = ClientesyOrdenesHU.getSessionFactory().getCurrentSession();
        tx = sessionClientes.beginTransaction();

        Integer idCliente = 0, idAddr;
        try {
            idAddr = (Integer) sessionClientes.save(addr);
            idCliente = (Integer) sessionClientes.save(clienteEntidad);

            CustomerAddress customerAddress = new CustomerAddress();
            customerAddress.setId(new CustomerAddressId(idCliente, idAddr));

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

        respuesta.setRespuesta((idCliente != 0) ? RespuestaGenerica.OK : RespuestaGenerica.KO);
        respuesta.setIdCliente(idCliente);
        System.out.println("--------------- Saliendo ---------------");
        return respuesta;
    }

    public com.touresbalon.clientestouresbalon.RespuestaGenerica autenticarCliente(java.lang.String usuario, java.lang.String contrasenia) throws AutenticarClienteFault_Exception {
        System.out.println(" ---------------- Entramos autenticarCliente ----------------- ");
        RespuestaGenerica respuesta = RespuestaGenerica.KO;
        Customer clienteEntidad = null;

        try {
            sessionClientes = ClientesyOrdenesHU.getSessionFactory().getCurrentSession();
            tx = sessionClientes.beginTransaction();

            Query query = sessionClientes.createQuery("from Customer where email = :mail ");
            query.setParameter("mail", usuario);
            List list = query.list();

            clienteEntidad = (Customer) list.get(0);

            if (clienteEntidad != null) {
                if (!clienteEntidad.getPassword().equals(contrasenia)) {
                    System.out.println("Cliente existe, pero constraña errada");
                    respuesta = RespuestaGenerica.KO;
                } else {
                    System.out.println("Cliente AUTENTICADO !!!");
                    respuesta = RespuestaGenerica.OK;
                }
            } else {
                System.out.println("Cliente no existe");
                respuesta = RespuestaGenerica.KO;
            }
        } catch (Exception e) {
            System.out.println("ERROR actualizarEstatusCliente: " + e.getMessage());
            respuesta = RespuestaGenerica.KO;
        }

        if (sessionClientes != null && sessionClientes.isOpen()) {
            sessionClientes.close();
        }

        System.out.println("--------------- Saliendo ---------------");
        return respuesta;
    }

    public com.touresbalon.clientestouresbalon.RespuestaGenerica actualizarCliente(com.touresbalon.clientestouresbalon.Cliente cliente) throws ActualizarClienteFault_Exception {
        System.out.println(" ---------------- Entramos actualizarCliente ----------------- ");
        RespuestaGenerica respuesta = RespuestaGenerica.KO;

        Customer clienteEntidad = null;
        Address addr = new Address();

        //Se prepara la operacion en BD
        sessionClientes = ClientesyOrdenesHU.getSessionFactory().getCurrentSession();
        tx = sessionClientes.beginTransaction();

        if (cliente != null) {
            Query query = sessionClientes.createQuery("from Customer where custid = :idCliente ");
            query.setParameter("idCliente", cliente.getIdCliente());
            List list = query.list();

            clienteEntidad = (Customer) list.get(0);

            if (clienteEntidad != null) {
                clienteEntidad.setFname(cliente.getNombres());
                clienteEntidad.setLname(cliente.getApellidos());
                clienteEntidad.setPhonenumber(cliente.getNumTel());
                clienteEntidad.setEmail(cliente.getEmail());
                clienteEntidad.setPassword(cliente.getContrasenia());
                clienteEntidad.setCreditcardtype(cliente.getTipoTarjeta());
                clienteEntidad.setCreditcardnumber(cliente.getNumeroTarjeta());

                Direccion direccionCliente = null;
                if (cliente.getDireccion() != null && !cliente.getDireccion().isEmpty()) {
                    direccionCliente = cliente.getDireccion().get(0);
                }

                //Mapeo de Direccion a Address
                if (direccionCliente != null && direccionCliente.getIdDireccion() != null) {
                    List listAddr = null;
                    try {
                        Query queryAddr = sessionClientes.createQuery("from Address where addrid = :idaddr ");
                        queryAddr.setParameter("idaddr", direccionCliente.getIdDireccion());
                        listAddr = queryAddr.list();
                        addr = (Address) listAddr.get(0);

                    } catch (Exception e) {
                        System.out.println("La direccion con id: " + direccionCliente.getIdDireccion() + " no existe en BD");
                        return RespuestaGenerica.KO;
                    }
                    if (addr != null) {
                        addr.setZip(direccionCliente.getCodPostal());
                        addr.setCity(direccionCliente.getCiudad());
                        addr.setAddressType(direccionCliente.getTipoDir());
                        addr.setCountry(direccionCliente.getPais());
                        addr.setState(direccionCliente.getEstado());
                        addr.setStreet(direccionCliente.getDirCalle());
                        
                        //Actualiza la direccion del cliente en BD    
                        try {
                            sessionClientes.update(addr);
                        } catch (Exception e) {
                            System.out.println("ERROR al actualizar direccion de cliente con id: " + direccionCliente.getIdDireccion());
                            return RespuestaGenerica.KO;
                        }
                    } else {
                        System.out.println("La direccion no existe en BD y no se puede actualizar");
                        return RespuestaGenerica.KO;
                    }
                } else {
                    System.out.println("ERROR actualizarCliente: Direccion del cliente, null");
                }

                //Se actualiza el cliente en BD
                try {
                    sessionClientes.update(clienteEntidad);
                    tx.commit();
                    System.out.println("Usuario actualizado OK! ");
                    respuesta = RespuestaGenerica.OK;
                } catch (Exception e) {
                    System.out.println("Error al actualizar cliente !!!" + e.getMessage());
                    respuesta = RespuestaGenerica.KO;
                } finally {
                    if (sessionClientes != null && sessionClientes.isOpen()) {
                        sessionClientes.close();
                    }
                }
            } else {
                System.out.println("ERROR: Cliente no encontrado en BD");
                return RespuestaGenerica.KO;
            }
        } else {
            System.out.println("ERROR: El cliente a actualizar es null");
            respuesta = RespuestaGenerica.KO;
        }
        System.out.println("--------------- Saliendo ---------------");
        return respuesta;
    }

    public com.touresbalon.clientestouresbalon.RespuestaGenerica actualizarContraseniaCliente(java.lang.String usuario, java.lang.String contrasenia) throws ActualizarContraseniaClienteFault_Exception {
        System.out.println(" ---------------- Entramos actualizarContraseniaCliente ----------------- ");
        RespuestaGenerica respuesta = RespuestaGenerica.KO;

        Customer clienteEntidad = null;

        try {
            sessionClientes = ClientesyOrdenesHU.getSessionFactory().getCurrentSession();
            tx = sessionClientes.beginTransaction();

            Query query = sessionClientes.createQuery("from Customer where email = :mail ");
            query.setParameter("mail", usuario);
            List list = query.list();

            clienteEntidad = (Customer) list.get(0);

        } catch (Exception e) {
            System.out.println("ERROR actualizarEstatusCliente: " + e.getMessage());
        }

        if (clienteEntidad != null && contrasenia != null && !contrasenia.equals("")) {
            clienteEntidad.setPassword(contrasenia);
            try {
                sessionClientes.save(clienteEntidad);
                tx.commit();
                respuesta = RespuestaGenerica.OK;
            } catch (Exception e) {
                System.out.println("ERROR persistiendo Cliente actualizarContraseniaCliente" + e.getMessage());
                respuesta = RespuestaGenerica.KO;
            }
        }

        if (sessionClientes != null && sessionClientes.isOpen()) {
            sessionClientes.close();
        }

        System.out.println("--------------- Saliendo ---------------");
        return respuesta;
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

        if (clienteEntidad != null && estatus != null) {
            clienteEntidad.setStatus(estatus.name());
            try {
                sessionClientes.save(clienteEntidad);
                tx.commit();
                System.out.println("este es el id de Oracle: " + idCliente);
                respuesta = RespuestaGenerica.OK;
            } catch (Exception e) {
                System.out.println("ERROR persistiendo Cliente actualizarEstatusCliente" + e.getMessage());
                respuesta = RespuestaGenerica.KO;
            }
        }

        if (sessionClientes != null && sessionClientes.isOpen()) {
            sessionClientes.close();
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

        System.out.println("Salimos con resultado: " + ((clienteEntidad != null) ? clienteEntidad.getFname() : "cliente nulo"));

        if (clienteEntidad != null) {
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
        System.out.println(" ---------------- Entramos consultarPorFactRangoCliente----------------- ");

        List<Cliente> clientes = new ArrayList<>();
        
        try {
            sessionClientes = ClientesyOrdenesHU.getSessionFactory().getCurrentSession();
            tx = sessionClientes.beginTransaction();
            
            //Consulta
            StringBuilder str = new StringBuilder();                        
            str.append("SELECT orders.custid, fname, SUM(price) precio from orders ");
            str.append("inner join customer on customer.CUSTID = orders.CUSTID ");
            str.append("where orderdate >= :fechaInicio ");
            str.append("and orderdate < :fechaFin ");
            str.append("group by orders.custid, fname ");
            str.append("order by precio desc");
                       
            Query query = sessionClientes.createSQLQuery(str.toString());
            query.setParameter("fechaInicio", Utils.toDate(fechaInicial));
            query.setParameter("fechaFin", Utils.toDate(fechaFin));
            List list = query.list();

            //Variables para conversion de resultados
            List<Object> listaResultados = new ArrayList<Object>();
            BigDecimal idLCiente = BigDecimal.ZERO;

            if(list != null && list.size() > 0){
                for(int i = 0; i < list.size(); i++){
                    Cliente cliente = new Cliente();                
                    listaResultados = Arrays.asList(list.get(i)); 
                    Object[] columnas = (Object[]) listaResultados.get(0);
                    idLCiente = (BigDecimal)columnas[0]; 
                    cliente.setIdCliente(idLCiente.intValueExact());
                    cliente.setNombres((String)columnas[1]);
                    cliente.setNumTel(columnas[2].toString());
                    clientes.add(cliente);
                }
            }else{
                System.out.println("INFO: No hay resultados para la busqueda de rangos ");            
            }

        } catch (Exception e) {
            System.out.println("ERROR consultarPorFactRangoCliente: " + e.getMessage());
        }
        System.out.println("--------------- Saliendo ---------------");
        return clientes;
    }

}
