/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aes.pica.touresbalon.touresbalonproductosws.servicios;

import aes.pica.touresbalon.touresbalonproductosws.entidades.clientesyordenes.Address;
import aes.pica.touresbalon.touresbalonproductosws.entidades.productos.TarifaCiudad;
import aes.pica.touresbalon.touresbalonproductosws.util.ClientesyOrdenesHU;
import aes.pica.touresbalon.touresbalonproductosws.util.ProductosHU;
import com.touresbalon.productostouresbalon.ConsultaTop5ProductosFault_Exception;
import com.touresbalon.productostouresbalon.ConsultarCampaniaProductoFault_Exception;
import com.touresbalon.productostouresbalon.ConsultarPorEspectaculoProductoFault_Exception;
import com.touresbalon.productostouresbalon.ConsultarProductoFault_Exception;
import com.touresbalon.productostouresbalon.ConsultarRankingEspectaculosVendidosProductoFault_Exception;
import com.touresbalon.productostouresbalon.ConsultarRankingFechaProductoFault_Exception;
import com.touresbalon.productostouresbalon.GestionCampaniaProductoFault_Exception;
import com.touresbalon.productostouresbalon.GestionProductoFault_Exception;
import com.touresbalon.productostouresbalon.GestionTarifaFault_Exception;
import com.touresbalon.productostouresbalon.Producto;
import java.util.List;
import javax.jws.WebService;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author jdtrujillop
 */
@WebService(serviceName = "ProductosTouresBalon", portName = "ProductosTouresBalonSOAP", endpointInterface = "com.touresbalon.productostouresbalon.ProductosTouresBalon", targetNamespace = "http://www.touresbalon.com/ProductosTouresBalon/", wsdlLocation = "WEB-INF/wsdl/ProductosTouresBalon.wsdl")
public class Servicios {

    //Variables globlales
    private Session sessionClientes;
    private Session sessionProductos;
    private Transaction tx;

    public java.util.List<com.touresbalon.productostouresbalon.Producto> consultarProducto(com.touresbalon.productostouresbalon.TipoConsultaProducto tipoConsulta, java.lang.String codigo, java.lang.String nombre, java.lang.String descripcion) throws ConsultarProductoFault_Exception {
        //TODO implement this method

        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public java.util.List<com.touresbalon.productostouresbalon.Campania> consultarCampaniaProducto() throws ConsultarCampaniaProductoFault_Exception {
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

    public com.touresbalon.productostouresbalon.RespuestaGenerica gestionCampaniaProducto(com.touresbalon.productostouresbalon.TipoConsultaProducto tipoOperacion, com.touresbalon.productostouresbalon.Campania campania) throws GestionCampaniaProductoFault_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public java.lang.String gestionProducto(com.touresbalon.productostouresbalon.TipoConsultaProducto tipoOperacion, com.touresbalon.productostouresbalon.Producto producto) throws GestionProductoFault_Exception {
        //TODO implement this method
        String res = "";
        sessionClientes = ClientesyOrdenesHU.getSessionFactory().getCurrentSession();
        tx = sessionClientes.beginTransaction();
        Query q = sessionClientes.createQuery("from Address");
        List<Address> listAdd = q.list();
        res = "ORACLE: "+listAdd.size();
        tx.commit();
        
        sessionProductos = ProductosHU.getSessionFactory().getCurrentSession();
        tx = sessionProductos.beginTransaction();
        q = sessionProductos.createQuery("from TarifaCiudad");
        List<TarifaCiudad> listProd = q.list();
        res += " - SQLSERVER: "+listProd.size();
        tx.commit();
        
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
        
        return res;
    }

    public com.touresbalon.productostouresbalon.TipoGestionTarifaResponse gestionTarifa(com.touresbalon.productostouresbalon.TipoConsultaProducto tipoOperacion, com.touresbalon.productostouresbalon.TipoTarifa tipoTarifa, com.touresbalon.productostouresbalon.TarifaValores tarifa) throws GestionTarifaFault_Exception {
        //TODO implement this method

        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public java.util.List<com.touresbalon.productostouresbalon.Producto> consultaTop5Productos(java.util.List<java.lang.String> idProducto) throws ConsultaTop5ProductosFault_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

}
