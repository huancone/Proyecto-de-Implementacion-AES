/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aes.pica.touresbalon.touresbalonproductosws.servicios;

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
import com.touresbalon.productostouresbalon.TipoConsultaProducto;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.jws.WebService;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author braatz
 */
@WebService(serviceName = "ProductosTouresBalon", portName = "ProductosTouresBalonSOAP", endpointInterface = "com.touresbalon.productostouresbalon.ProductosTouresBalon", targetNamespace = "http://www.touresbalon.com/ProductosTouresBalon/", wsdlLocation = "WEB-INF/wsdl/ProductosTouresBalon.wsdl")
public class Services {
    
    //Variables globlales
   // private Session sessionClientes;
    private Session sessionProductos;
    private Transaction tx;

    public java.util.List<com.touresbalon.productostouresbalon.Producto> consultarProducto(com.touresbalon.productostouresbalon.TipoConsultaProducto tipoConsulta, java.lang.String cadenaConsulta) throws ConsultarProductoFault_Exception, DatatypeConfigurationException {
        
        sessionProductos = ProductosHU.getSessionFactory().getCurrentSession();
        tx= sessionProductos.beginTransaction();
       
        String strsql ;
        Query q = null;
        List<aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Producto> lstpro = new ArrayList<aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Producto>();
        List<Producto> lstprod = new ArrayList<Producto>();
        System.out.println("inicializa");
        if (null!= tipoConsulta  )
        switch (tipoConsulta) {
            case DESCRIPCION:
                strsql="from Producto where descripcion like :valorbuscar" ;
                q=sessionProductos.createQuery(strsql)
                        .setParameter("valorbuscar", "%" + cadenaConsulta + "%");
                  lstpro=q.list();  ;
                break;
            case ID:
                System.out.println("por ID");
                strsql="from Producto where idProducto=" + cadenaConsulta;
                q=sessionProductos.createQuery(strsql);
                lstpro =q.list();
                break;
            default:
                strsql="from Producto where espectaculo like :valorbuscar";
                q=sessionProductos.createQuery(strsql)
                        .setParameter("valorbuscar", "%" +  cadenaConsulta + "%");
                lstpro =q.list();
                break;
        //TODO implement this method
        //throw new UnsupportedOperationException("Not implemented yet.");
        }
        
        for(int i=0; i < lstpro.size(); i++)
        {
            com.touresbalon.productostouresbalon.Producto prod = new  com.touresbalon.productostouresbalon.Producto();
            com.touresbalon.productostouresbalon.Ciudad ciu = new com.touresbalon.productostouresbalon.Ciudad();
            
            ciu.setIdCiudad(lstpro.get(i).getCiudad().getIdCiudad());
            ciu.setPais(lstpro.get(i).getCiudad().getNombreCiudad() + " - " + lstpro.get(i).getCiudad().getPais());
            
            prod.setCiudadEspectaculo(ciu);
            prod.setDescripcion(lstpro.get(i).getDescripcion());
            prod.setEspectaculo(lstpro.get(i).getEspectaculo());
            prod.setFechaEspectaculo(toGregorian(lstpro.get(i).getFechaEspectaculo()));
            prod.setFechaLlegada(toGregorian(lstpro.get(i).getFechaLlegada()));
            prod.setFechaSalida(toGregorian(lstpro.get(i).getFechaSalida()));
            prod.setIdProducto(lstpro.get(i).getIdProducto());
            prod.setImagenProducto(lstpro.get(i).getUrlImagen());
            
            com.touresbalon.productostouresbalon.TarifaValores tarvalesp = new com.touresbalon.productostouresbalon.TarifaValores();
            com.touresbalon.productostouresbalon.TarifaValores tarvaltra = new com.touresbalon.productostouresbalon.TarifaValores();
            com.touresbalon.productostouresbalon.TarifaValores tarvalhos = new com.touresbalon.productostouresbalon.TarifaValores();
            
            tarvalesp.setId(lstpro.get(i).getTarifaEspectaculo().getIdEspectaculo());
            tarvalesp.setNombreTipo(lstpro.get(i).getTarifaEspectaculo().getNombreEspectaculo());
            tarvalesp.setPrecio(lstpro.get(i).getTarifaEspectaculo().getPrecio());
            
            tarvaltra.setId(lstpro.get(i).getTarifaTransporte().getIdTransporte());
            tarvaltra.setNombreTipo(lstpro.get(i).getTarifaTransporte().getNombreTransporte());
            tarvaltra.setPrecio(lstpro.get(i).getTarifaTransporte().getPrecio());
            
            tarvalhos.setId(lstpro.get(i).getTarifaHospedaje().getIdHospedaje());
            tarvalhos.setNombreTipo(lstpro.get(i).getTarifaHospedaje().getNombreHospedaje());
            tarvalhos.setPrecio(lstpro.get(i).getTarifaHospedaje().getPrecio());
             
            //tipoesp
            prod.setTipoEspectaculo(tarvalesp);
            prod.setTipoHospedaje(tarvalhos);
            prod.setTipoTransporte(tarvaltra);
            
            
            //prod.setTipoEspectaculo();
            lstprod.add(prod);
        }
        
       
      System.out.println("cierre");
       tx.commit();
        return lstprod;
        //TODO implement this method
        //throw new UnsupportedOperationException("Not implemented yet.");
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
    public Date toDate(XMLGregorianCalendar calendar) {

        return calendar.toGregorianCalendar().getTime();

    }
    
    public XMLGregorianCalendar toGregorian(Date fecha) throws DatatypeConfigurationException {

        GregorianCalendar gc = new GregorianCalendar();
        DatatypeFactory df = DatatypeFactory.newInstance();
         gc.setTimeInMillis(fecha.getTime());
         return df.newXMLGregorianCalendar(gc);

    }
}
