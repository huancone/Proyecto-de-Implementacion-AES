/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aes.pica.touresbalon.touresbalonproductosws.servicios;

import aes.pica.touresbalon.touresbalonproductosws.entidades.clientesyordenes.Orders;
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
import com.touresbalon.productostouresbalon.RespuestaGenerica;
import com.touresbalon.productostouresbalon.TarifaValores;
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
    private Session sessionOrdenes;
    private Transaction txProductos;
    private Transaction txOrdenes;

    public java.util.List<com.touresbalon.productostouresbalon.Producto> consultarProducto(com.touresbalon.productostouresbalon.TipoConsultaProducto tipoConsulta, java.lang.String cadenaConsulta) throws ConsultarProductoFault_Exception, DatatypeConfigurationException {

        sessionProductos = ProductosHU.getSessionFactory().getCurrentSession();
        txProductos = sessionProductos.beginTransaction();

        String strsql;
        Query q = null;
        List<aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Producto> lstpro = new ArrayList<aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Producto>();
        List<Producto> lstprod = new ArrayList<Producto>();
        System.out.println("inicializa");
        if (null != tipoConsulta) {
            switch (tipoConsulta) {
                case DESCRIPCION:
                    strsql = "from Producto where descripcion like :valorbuscar";
                    q = sessionProductos.createQuery(strsql)
                            .setParameter("valorbuscar", "%" + cadenaConsulta + "%");
                    lstpro = q.list();
                    ;
                    break;
                case ID:
                    System.out.println("por ID");
                    strsql = "from Producto where idProducto=" + cadenaConsulta;
                    q = sessionProductos.createQuery(strsql);
                    lstpro = q.list();
                    break;
                default:
                    strsql = "from Producto where espectaculo like :valorbuscar";
                    q = sessionProductos.createQuery(strsql)
                            .setParameter("valorbuscar", "%" + cadenaConsulta + "%");
                    lstpro = q.list();
                    break;
                //TODO implement this method
                //throw new UnsupportedOperationException("Not implemented yet.");
            }
        }

        for (int i = 0; i < lstpro.size(); i++) {
            com.touresbalon.productostouresbalon.Producto prod = new com.touresbalon.productostouresbalon.Producto();
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
        txProductos.commit();
        return lstprod;
        //TODO implement this method
        //throw new UnsupportedOperationException("Not implemented yet.");
    }

    public java.util.List<com.touresbalon.productostouresbalon.Producto> consultarCampaniaProducto() throws ConsultarCampaniaProductoFault_Exception, DatatypeConfigurationException {
        //TODO implement this method
        sessionProductos = ProductosHU.getSessionFactory().getCurrentSession();
        txProductos = sessionProductos.beginTransaction();

        String strsql;

        Query q = null;
        List<aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Producto> lstpro = new ArrayList<aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Producto>();
        
        List<Producto> lstprod = new ArrayList<Producto>();
              
        strsql="SELECT dbo.PRODUCTO.* FROM dbo.CAMPANIAS INNER JOIN dbo.PRODUCTO ON PRODUCTO.id_producto = CAMPANIAS.id_producto WHERE GETDATE()>=fecha_inicio AND GETDATE() <= fecha_fin " ;
//        q=sessionProductos.createSQLQuery(strsql);
//                

//         strsql="Select Prod.idProducto, Prod.ciudad, Prod.tarifaEspectaculo, Prod.tarifaHospedaje, Prod.tarifaTransporte, Prod.espectaculo, Prod.descripcion, Prod.fechaSalida, Prod.fechaLlegada, Prod.fechaEspectaculo, Prod.urlImagen FROM Producto as Prod INNER JOIN Prod.campaniases as Cam";
        q=sessionProductos.createSQLQuery(strsql).addEntity(aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Producto.class) ;
              
        lstpro = (List<aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Producto>)q.list();  
       
        
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
        txProductos.commit();
        return lstprod;
    }

    public java.util.List<com.touresbalon.productostouresbalon.Producto> consultarPorEspectaculoProducto(java.lang.String espectaculo) throws ConsultarPorEspectaculoProductoFault_Exception, DatatypeConfigurationException {
        sessionProductos = ProductosHU.getSessionFactory().getCurrentSession();
        txProductos = sessionProductos.beginTransaction();

        List<Producto> lstProductos = new ArrayList<>();
        List<aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Producto> lstProductEntity = new ArrayList<>();

        String sqlQuery;
        Query q = null;

        sqlQuery = "from Producto where CONTAINS(espectaculo, :espectaculo)";
        sessionProductos.createQuery(sqlQuery).setParameter("espectaculo", espectaculo);
        q = sessionProductos.createQuery(sqlQuery);

        lstProductEntity = q.list();

        for (int i = 0; i < lstProductEntity.size(); i++) {
            Producto p = new Producto();
            p.setIdProducto(lstProductEntity.get(i).getIdProducto());
            p.setEspectaculo(lstProductEntity.get(i).getEspectaculo());
            p.setDescripcion(lstProductEntity.get(i).getDescripcion());

            TarifaValores tarifaEspectaculo = new TarifaValores();
            tarifaEspectaculo.setId(lstProductEntity.get(i).getTarifaEspectaculo().getIdEspectaculo());
            tarifaEspectaculo.setNombreTipo(lstProductEntity.get(i).getTarifaEspectaculo().getNombreEspectaculo());
            tarifaEspectaculo.setPrecio(lstProductEntity.get(i).getTarifaEspectaculo().getPrecio());
            p.setTipoEspectaculo(tarifaEspectaculo);

            TarifaValores tarifaTransporte = new TarifaValores();
            tarifaTransporte.setId(lstProductEntity.get(i).getTarifaTransporte().getIdTransporte());
            tarifaTransporte.setNombreTipo(lstProductEntity.get(i).getTarifaTransporte().getNombreTransporte());
            tarifaTransporte.setPrecio(lstProductEntity.get(i).getTarifaTransporte().getPrecio());
            p.setTipoTransporte(tarifaTransporte);

            TarifaValores tarifaHospedaje = new TarifaValores();
            tarifaHospedaje.setId(lstProductEntity.get(i).getTarifaHospedaje().getIdHospedaje());
            tarifaHospedaje.setNombreTipo(lstProductEntity.get(i).getTarifaHospedaje().getNombreHospedaje());
            tarifaHospedaje.setPrecio(lstProductEntity.get(i).getTarifaHospedaje().getPrecio());
            p.setTipoHospedaje(tarifaHospedaje);

            p.setFechaSalida(toGregorian(lstProductEntity.get(i).getFechaSalida()));
            p.setFechaLlegada(toGregorian(lstProductEntity.get(i).getFechaLlegada()));

            p.setImagenProducto(lstProductEntity.get(i).getUrlImagen());

            lstProductos.add(p);

        }

        return lstProductos;
    }

    public java.util.List<com.touresbalon.productostouresbalon.TarifaValores> consultarRankingEspectaculosVendidosProducto(javax.xml.datatype.XMLGregorianCalendar fechaInicial, javax.xml.datatype.XMLGregorianCalendar fechaFin) throws ConsultarRankingEspectaculosVendidosProductoFault_Exception {
        sessionProductos = ProductosHU.getSessionFactory().getCurrentSession();
        txProductos = sessionProductos.beginTransaction();

        sessionOrdenes = ClientesyOrdenesHU.getSessionFactory().getCurrentSession();
        txOrdenes = sessionOrdenes.beginTransaction();

        List<TarifaValores> lstRankingEspectaculos = new ArrayList<>();
        List<Integer> lstProductos = new ArrayList<>();

        String strsql = "WITH "
                + "  PRODUCTOS AS "
                + "  ( "
                + "    SELECT "
                + "      Items.prodid, "
                + "      COUNT ( * ) CANTIDAD "
                + "    FROM "
                + "      Orders "
                + "    INNER JOIN Items "
                + "    ON "
                + "      Orders.ordid = Items.ordid "
                + "    WHERE "
                + "      Orders.ORDERDATE BETWEEN TO_DATE ( '" + fechaInicial + "', 'yyyymmdd' ) AND TO_DATE ( '" + fechaFin + "', 'yyyymmdd' ) "
                + "    GROUP BY "
                + "      Items.prodid "
                + "    ORDER BY "
                + "      Items.prodid "
                + "  ) "
                + "SELECT "
                + "  PRODUCTOS.prodid, "
                + "FROM "
                + "  PRODUCTOS "
                + "WHERE "
                + "  ROWNUM <= 10";
        
        Query query = sessionOrdenes.createQuery(strsql);
        lstProductos = query.list();

        for (Integer p : lstProductos) {
            TarifaValores t = new TarifaValores();
            strsql = "from tarifaEspectaculo where productos.idProducto = " + p;
            query = sessionProductos.createQuery(strsql);
            lstRankingEspectaculos.add(t);
        }

        return lstRankingEspectaculos;
    }

    public java.util.List<com.touresbalon.productostouresbalon.Producto> consultarRankingFechaProducto(javax.xml.datatype.XMLGregorianCalendar fechaInicial, javax.xml.datatype.XMLGregorianCalendar fechaFin) throws ConsultarRankingFechaProductoFault_Exception {
        
        sessionProductos = ProductosHU.getSessionFactory().getCurrentSession();
        txProductos = sessionProductos.beginTransaction();

        sessionOrdenes = ClientesyOrdenesHU.getSessionFactory().getCurrentSession();
        txOrdenes = sessionOrdenes.beginTransaction();

        List<Producto> lstRankingProductos = new ArrayList<>();
        List<Integer> lstProductos = new ArrayList<>();

        String strsql = "WITH "
                + "  PRODUCTOS AS "
                + "  ( "
                + "    SELECT "
                + "      Items.prodid, "
                + "      COUNT ( * ) CANTIDAD "
                + "    FROM "
                + "      Orders "
                + "    INNER JOIN Items "
                + "    ON "
                + "      Orders.ordid = Items.ordid "
                + "    WHERE "
                + "      Orders.ORDERDATE BETWEEN TO_DATE ( '" + fechaInicial + "', 'yyyymmdd' ) AND TO_DATE ( '" + fechaFin + "', 'yyyymmdd' ) "
                + "    GROUP BY "
                + "      Items.prodid "
                + "    ORDER BY "
                + "      Items.prodid "
                + "  ) "
                + "SELECT "
                + "  PRODUCTOS.prodid, "
                + "FROM "
                + "  PRODUCTOS "
                + "WHERE "
                + "  ROWNUM <= 10";
        
        Query query = sessionOrdenes.createQuery(strsql);
        lstProductos = query.list();

        for (Integer p : lstProductos) {
            Producto t = new Producto();
            strsql = "from Producto where productos.idProducto = " + p;
            query = sessionProductos.createQuery(strsql);
            lstRankingProductos.add(t);
        }

        return lstRankingProductos;
    }

    @SuppressWarnings("empty-statement")
    public com.touresbalon.productostouresbalon.TipoGestionCampaniaResponse gestionCampaniaProducto(com.touresbalon.productostouresbalon.TipoAccion tipoOperacion, com.touresbalon.productostouresbalon.Campania campania) throws GestionCampaniaProductoFault_Exception {
      
        String sqlQuery;
        Query q = null;
        int idcamp;
        com.touresbalon.productostouresbalon.TipoGestionCampaniaResponse respuesta = new com.touresbalon.productostouresbalon.TipoGestionCampaniaResponse();   
//        if (null!=tipoOperacion  )
        switch (tipoOperacion) {
            case ADICIONAR:{
                sessionProductos = ProductosHU.getSessionFactory().getCurrentSession();
                txProductos = sessionProductos.beginTransaction();
                aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Campanias camp = new aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Campanias();
                aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Producto prod = new aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Producto();
                prod.setIdProducto( campania.getIdProducto().getIdProducto());
                camp.setProducto(prod);
                camp.setFechaInicio(toDate(campania.getFechaInicioCampania()));
                camp.setFechaFin(toDate(campania.getFechaFinCampania()));
                sessionProductos.save(camp);
                if (camp.getIdCampania() >0)
                {
                    respuesta.setRespuesta(RespuestaGenerica.OK);
                    respuesta.setIdCampania(camp.getIdCampania());
                }
                else
                    respuesta.setRespuesta(RespuestaGenerica.KO);
                txProductos.commit();

                    break;
                }
            case MODIFICAR:
                
                try
                {
                    idcamp=Integer.valueOf(campania.getIdProducto().getEspectaculo());
                } catch (Exception e){
                    idcamp=0;
                }   
                sessionProductos = ProductosHU.getSessionFactory().getCurrentSession();
                txProductos = sessionProductos.beginTransaction();
                sqlQuery = "from Campanias where idCampania = :idcampana";
                q=sessionProductos.createQuery(sqlQuery).setParameter("idcampana", idcamp);
                List<aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Campanias> lstcamp =q.list();
                if (lstcamp.size()>0)
                {
                   
                    sessionProductos.clear();
                    aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Campanias camp = new aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Campanias();
                    
                    aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Producto prod = new aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Producto();
                    prod.setIdProducto( campania.getIdProducto().getIdProducto());
                    
                    camp.setProducto(prod);
                    
                    camp.setIdCampania(idcamp);
                    
                    
                    camp.setFechaInicio(toDate(campania.getFechaInicioCampania()));
                    camp.setFechaFin(toDate(campania.getFechaFinCampania()));
                   
                    sessionProductos.update(camp);
                    
                    if (camp.getIdCampania() >0)
                        respuesta.setRespuesta(RespuestaGenerica.OK);
                    else
                        respuesta.setRespuesta(RespuestaGenerica.KO);
                    
                }
                else
                    respuesta.setRespuesta(RespuestaGenerica.KO);
                
                txProductos.commit();
                break;
            case ELIMINAR:{
        
                aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Campanias camp = new aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Campanias();
//                aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Producto prod = new aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Producto();
//                prod.setIdProducto( campania.getIdProducto().getIdProducto());
//                camp.setProducto(prod);
                try
                {
                    idcamp=Integer.valueOf(campania.getIdProducto().getEspectaculo());
                   
                } catch (Exception e){
                    idcamp=0;
                   
                }    
                
                  sessionProductos = ProductosHU.getSessionFactory().getCurrentSession();
                txProductos = sessionProductos.beginTransaction();
                  sqlQuery = "from Campanias where idCampania = :idcampana";
                q=sessionProductos.createQuery(sqlQuery).setParameter("idcampana", idcamp);
                List<aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Campanias> lstcampa =q.list();
                if (lstcampa.size()>0)
                {
                    
                     sessionProductos.clear();
                    camp.setIdCampania(idcamp);
//                camp.setFechaInicio(toDate(campania.getFechaInicioCampania()));
//                camp.setFechaFin(toDate(campania.getFechaFinCampania()));
                    sessionProductos.delete(camp);
                    if (camp.getIdCampania() >0)
                        respuesta.setRespuesta(RespuestaGenerica.OK);
                    else
                        respuesta.setRespuesta(RespuestaGenerica.KO);
                }
                else
                    respuesta.setRespuesta(RespuestaGenerica.KO);
                txProductos.commit();
                break;
                }
            default:
                respuesta.setRespuesta(RespuestaGenerica.KO);
                break;
        }
       
        return respuesta;
    }

    public com.touresbalon.productostouresbalon.TipoGestionProductoResponse gestionProducto(com.touresbalon.productostouresbalon.TipoAccion tipoOperacion, com.touresbalon.productostouresbalon.Producto producto) throws GestionProductoFault_Exception {
        
//        String sqlQuery;
//        Query q = null;
//        int idcamp;
//        com.touresbalon.productostouresbalon.TipoGestionProductoResponse respuesta = new com.touresbalon.productostouresbalon.TipoGestionProductoResponse();   
////        if (null!=tipoOperacion  )
//        switch (tipoOperacion) {
//            case ADICIONAR:{
//                sessionProductos = ProductosHU.getSessionFactory().getCurrentSession();
//                txProductos = sessionProductos.beginTransaction();
//                 com.touresbalon.productostouresbalon.Ciudad ciu = new com.touresbalon.productostouresbalon.Ciudad();
//
//            ciu.setIdCiudad(lstpro.get(i).getCiudad().getIdCiudad());
//            ciu.setPais(lstpro.get(i).getCiudad().getNombreCiudad() + " - " + lstpro.get(i).getCiudad().getPais());
//            
//            
//                aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Producto prod = new aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Producto();
//                aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Ciudad ciu = new aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Ciudad();
//                ciu.getIdCiudad(producto.getCiudadEspectaculo().getIdCiudad());
//                
//                prod.setCiudad();
//                
//                sessionProductos.save(prod);
//                if (camp.getIdCampania() >0)
//                {
//                    respuesta.setRespuesta(RespuestaGenerica.OK);
//                    respuesta.setIdCampania(camp.getIdCampania());
//                }
//                else
//                    respuesta.setRespuesta(RespuestaGenerica.KO);
//                txProductos.commit();
//
//                    break;
//                }
//            case MODIFICAR:
//                
//                try
//                {
//                    idcamp=Integer.valueOf(campania.getIdProducto().getEspectaculo());
//                } catch (Exception e){
//                    idcamp=0;
//                }   
//                sessionProductos = ProductosHU.getSessionFactory().getCurrentSession();
//                txProductos = sessionProductos.beginTransaction();
//                sqlQuery = "from Campanias where idCampania = :idcampana";
//                q=sessionProductos.createQuery(sqlQuery).setParameter("idcampana", idcamp);
//                List<aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Campanias> lstcamp =q.list();
//                if (lstcamp.size()>0)
//                {
//                   
//                    sessionProductos.clear();
//                    aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Campanias camp = new aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Campanias();
//                    
//                    aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Producto prod = new aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Producto();
//                    prod.setIdProducto( campania.getIdProducto().getIdProducto());
//                    
//                    camp.setProducto(prod);
//                    
//                    camp.setIdCampania(idcamp);
//                    
//                    
//                    camp.setFechaInicio(toDate(campania.getFechaInicioCampania()));
//                    camp.setFechaFin(toDate(campania.getFechaFinCampania()));
//                   
//                    sessionProductos.update(camp);
//                    
//                    if (camp.getIdCampania() >0)
//                        respuesta.setRespuesta(RespuestaGenerica.OK);
//                    else
//                        respuesta.setRespuesta(RespuestaGenerica.KO);
//                    
//                }
//                else
//                    respuesta.setRespuesta(RespuestaGenerica.KO);
//                
//                txProductos.commit();
//                break;
//            case ELIMINAR:{
//        
//                aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Campanias camp = new aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Campanias();
////                aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Producto prod = new aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Producto();
////                prod.setIdProducto( campania.getIdProducto().getIdProducto());
////                camp.setProducto(prod);
//                try
//                {
//                    idcamp=Integer.valueOf(campania.getIdProducto().getEspectaculo());
//                   
//                } catch (Exception e){
//                    idcamp=0;
//                   
//                }    
//                
//                  sessionProductos = ProductosHU.getSessionFactory().getCurrentSession();
//                txProductos = sessionProductos.beginTransaction();
//                  sqlQuery = "from Campanias where idCampania = :idcampana";
//                q=sessionProductos.createQuery(sqlQuery).setParameter("idcampana", idcamp);
//                List<aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Campanias> lstcampa =q.list();
//                if (lstcampa.size()>0)
//                {
//                    
//                     sessionProductos.clear();
//                    camp.setIdCampania(idcamp);
////                camp.setFechaInicio(toDate(campania.getFechaInicioCampania()));
////                camp.setFechaFin(toDate(campania.getFechaFinCampania()));
//                    sessionProductos.delete(camp);
//                    if (camp.getIdCampania() >0)
//                        respuesta.setRespuesta(RespuestaGenerica.OK);
//                    else
//                        respuesta.setRespuesta(RespuestaGenerica.KO);
//                }
//                else
//                    respuesta.setRespuesta(RespuestaGenerica.KO);
//                txProductos.commit();
//                break;
//                }
//            default:
//                respuesta.setRespuesta(RespuestaGenerica.KO);
//                break;
//        }
//       
//        return respuesta;
        
        
        
        
        
        
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
        		sessionProductos = ProductosHU.getSessionFactory().getCurrentSession();
        txProductos = sessionProductos.beginTransaction();

        sessionOrdenes = ClientesyOrdenesHU.getSessionFactory().getCurrentSession();
        txOrdenes = sessionOrdenes.beginTransaction();

        List<Producto> lstRankingProductos = new ArrayList<>();
        List<Integer> lstProductos = new ArrayList<>();

        String strsql = "WITH "
                + "  PRODUCTOS AS "
                + "  ( "
                + "    SELECT "
                + "      Items.prodid, "
                + "      COUNT ( * ) CANTIDAD "
                + "    FROM "
                + "      Orders "
                + "    INNER JOIN Items "
                + "    ON "
                + "      Orders.ordid = Items.ordid "
                + "    WHERE "
                + "      Items.prodid = " + idProducto
                + "    GROUP BY "
                + "      Items.prodid "
                + "    ORDER BY "
                + "      Items.prodid "
                + "  ) "
                + "SELECT "
                + "  PRODUCTOS.prodid, "
                + "FROM "
                + "  PRODUCTOS "
                + "WHERE "
                + "  ROWNUM <= 10";
        
        Query query = sessionOrdenes.createQuery(strsql);
        lstProductos = query.list();

        for (Integer p : lstProductos) {
            Producto t = new Producto();
            strsql = "from tarifaEspectaculo where productos.idProducto = " + p;
            query = sessionProductos.createQuery(strsql);
            lstRankingProductos.add(t);
        }

        return lstRankingProductos;
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