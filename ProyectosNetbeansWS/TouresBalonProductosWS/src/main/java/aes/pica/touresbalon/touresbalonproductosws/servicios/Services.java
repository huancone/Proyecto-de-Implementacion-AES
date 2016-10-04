/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aes.pica.touresbalon.touresbalonproductosws.servicios;

import com.touresbalon.productostouresbalon.ConsultaTop5ProductosFault_Exception;
import com.touresbalon.productostouresbalon.ConsultarCampaniaProductoFault_Exception;
import com.touresbalon.productostouresbalon.ConsultarPorEspectaculoProductoFault_Exception;
import com.touresbalon.productostouresbalon.ConsultarProductoFault_Exception;
import com.touresbalon.productostouresbalon.ConsultarRankingEspectaculosVendidosProductoFault_Exception;
import com.touresbalon.productostouresbalon.ConsultarRankingFechaProductoFault_Exception;
import com.touresbalon.productostouresbalon.GestionCampaniaProductoFault_Exception;
import com.touresbalon.productostouresbalon.GestionProductoFault_Exception;
import com.touresbalon.productostouresbalon.GestionTarifaFault_Exception;
import javax.jws.WebService;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author braatz
 */
@WebService(serviceName = "ProductosTouresBalon", portName = "ProductosTouresBalonSOAP", endpointInterface = "com.touresbalon.productostouresbalon.ProductosTouresBalon", targetNamespace = "http://www.touresbalon.com/ProductosTouresBalon/", wsdlLocation = "WEB-INF/wsdl/ProductosTouresBalon.wsdl")
public class Services {
    
    //Variables globlales
    private Session sessionClientes;
    private Session sessionProductos;
    private Transaction tx;

    public java.util.List<com.touresbalon.productostouresbalon.Producto> consultarProducto(com.touresbalon.productostouresbalon.TipoConsultaProducto tipoConsulta, java.lang.String cadenaConsulta) throws ConsultarProductoFault_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public java.util.List<com.touresbalon.productostouresbalon.Producto> consultarCampaniaProducto() throws ConsultarCampaniaProductoFault_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public java.util.List<com.touresbalon.productostouresbalon.Producto> consultarPorEspectaculoProducto(java.lang.String espectaculo) throws ConsultarPorEspectaculoProductoFault_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public java.util.List<com.touresbalon.productostouresbalon.TarifaValores> consultarRankingEspectaculosVendidosProducto(javax.xml.datatype.XMLGregorianCalendar fechaInicial, javax.xml.datatype.XMLGregorianCalendar fechaFin) throws ConsultarRankingEspectaculosVendidosProductoFault_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public java.util.List<com.touresbalon.productostouresbalon.Producto> consultarRankingFechaProducto(javax.xml.datatype.XMLGregorianCalendar fechaInicial, javax.xml.datatype.XMLGregorianCalendar fechaFin) throws ConsultarRankingFechaProductoFault_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public com.touresbalon.productostouresbalon.TipoGestionCampaniaResponse gestionCampaniaProducto(com.touresbalon.productostouresbalon.TipoAccion tipoOperacion, com.touresbalon.productostouresbalon.Campania campania) throws GestionCampaniaProductoFault_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public com.touresbalon.productostouresbalon.TipoGestionProductoResponse gestionProducto(com.touresbalon.productostouresbalon.TipoAccion tipoOperacion, com.touresbalon.productostouresbalon.Producto producto) throws GestionProductoFault_Exception {
        //TODO implement this method
//        String res = "";
//        sessionClientes = ClientesyOrdenesHU.getSessionFactory().getCurrentSession();
//        tx = sessionClientes.beginTransaction();

//        Address addr = new Address();
//        addr.setZip("1010");
//        addr.setCity("bogota");
//        addr.setAddressType("calle");
//        addr.setCountry("Colombia");

//        Integer id = (Integer) sessionClientes.save(addr);
//        res = "este es el id: " + id;

        //Query q = sessionClientes.
//        Query q = sessionClientes.createQuery("from Address");
//        List<Address> listAdd = q.list();
//        res = "ORACLE: "+listAdd.size();
//        tx.commit();
//
//        sessionProductos = ProductosHU.getSessionFactory().getCurrentSession();
//        tx = sessionProductos.beginTransaction();
//        TarifaCiudad tc = new TarifaCiudad();
//        tc.setPrecio(BigDecimal.ZERO);
//        tc.setTipoCiudad("bogota");
//        id = (Integer) sessionProductos.save(tc);
//        res += " - SQLSERVER este es el id: "+id;
//        tx.commit();
//        sessionProductos = ProductosHU.getSessionFactory().getCurrentSession();
//        tx = sessionProductos.beginTransaction();
//        Query q = sessionProductos.createQuery("from TarifaCiudad");
//        List<TarifaCiudad> listProd = q.list();
//        res += " - SQLSERVER: "+listProd.size();
//        tx.commit();

//        sessionClientes = ClientesyOrdenesHU.getSessionFactory().getCurrentSession();
//        tx = sessionClientes.beginTransaction();
//        Query query = sessionClientes.createSQLQuery(
//                "select 1 from dual");
//        int rel = query.list().size();
//        tx.commit();
//
//        String res = "";
//        
//        if (rel == 1) {
//            res = "funciono Oracle";
//        } else {
//            res += "no funciono Oracle";
//        }
//        sessionProductos = ProductosHU.getSessionFactory().getCurrentSession(); //SELECT GETDATE()
//        tx = sessionProductos.beginTransaction();
//        query = sessionProductos.createSQLQuery(
//                "SELECT GETDATE()");
//        rel = query.list().size();
//        tx.commit();
//        
//        if (rel == 1) {
//            res += " - funciono SQL Server";
//        } else {
//            res += "- no funciono SQL Server";
//        }
//        return res;
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public com.touresbalon.productostouresbalon.TipoGestionTarifaResponse gestionTarifa(com.touresbalon.productostouresbalon.TipoAccion tipoOperacion, com.touresbalon.productostouresbalon.TipoTarifa tipoTarifa, com.touresbalon.productostouresbalon.TarifaValores tarifa) throws GestionTarifaFault_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public java.util.List<com.touresbalon.productostouresbalon.Producto> consultaTop5Productos(java.util.List<java.lang.Integer> idProducto) throws ConsultaTop5ProductosFault_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }
    
}
