/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aes.pica.touresbalon.touresbalonproductosws.servicios;

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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.jws.WebService;
import javax.persistence.ForeignKey;
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

    public java.util.List<com.touresbalon.productostouresbalon.Producto> consultarProducto(com.touresbalon.productostouresbalon.TipoConsultaProducto tipoConsulta, java.lang.String cadenaConsulta) throws ConsultarProductoFault_Exception, DatatypeConfigurationException {

        final Session sessionProductos;
        final Transaction txProductos;
        List<Producto> lstprod = new ArrayList<>();

        sessionProductos = ProductosHU.getSessionFactory().getCurrentSession();
        try {
            txProductos = sessionProductos.beginTransaction();
            try {
                String strsql, descripcion;
                String[] arrayConsulta;
                int page, pagesize;
                Query q = null;
                List<aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Producto> lstpro = new ArrayList<>();
                System.out.println("inicializa consulta de productos");

                if (null != tipoConsulta) {
                    switch (tipoConsulta) {
                        case DESCRIPCION:
                            arrayConsulta = cadenaConsulta.split("@");
                            descripcion = arrayConsulta[1];
                            page = Integer.parseInt(arrayConsulta[0]);
                            pagesize = 20;
                            strsql = ""
                                    + "SELECT "
                                    + "  ID_PRODUCTO, "
                                    + "  ESPECTACULO, "
                                    + "  DESCRIPCION, "
                                    + "  ID_ESPECTACULO, "
                                    + "  ID_TRANSPORTE, "
                                    + "  ID_HOSPEDAJE, "
                                    + "  ID_CIUDAD, "
                                    + "  FECHA_SALIDA, "
                                    + "  FECHA_LLEGADA, "
                                    + "  FECHA_ESPECTACULO, "
                                    + "  URL_IMAGEN "
                                    + "FROM "
                                    + "  PRODUCTO "
                                    + "WHERE "
                                    + "  FECHA_SALIDA >= GETDATE( ) "
                                    + "AND CONTAINS( ESPECTACULO, :valorBuscar )"
                                    + "ORDER BY "
                                    + "  FECHA_SALIDA OFFSET( :page - 1 ) * :pagesize ROWS "
                                    + "FETCH NEXT "
                                    + "  :pagesize ROWS ONLY";
                            try {
                                q = sessionProductos.createSQLQuery(strsql).addEntity(aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Producto.class)
                                        .setParameter("valorBuscar", descripcion)
                                        .setParameter("page", page)
                                        .setParameter("pagesize", pagesize);
                                lstpro = q.list();
                            } catch (Exception e) {
                                System.out.println("Error al Consultar: " + e.getMessage());
                            }

                            break;
                        case ID:
                            System.out.println("por ID");
                            strsql = "from Producto where idProducto=" + cadenaConsulta;
                            try {
                                q = sessionProductos.createQuery(strsql);
                                lstpro = q.list();
                            } catch (Exception e) {
                                System.out.println("Error al Consultar: " + e.getMessage());
                            }
                            break;
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
                txProductos.commit();
            } catch (Exception ex) {
                // Log the exception here
                txProductos.rollback();
                throw ex;
            }
        } finally {
            if (sessionProductos.isOpen()) {
                sessionProductos.close();
            }

            return lstprod;
        }

    }

    public java.util.List<com.touresbalon.productostouresbalon.Producto> consultarCampaniaProducto() throws ConsultarCampaniaProductoFault_Exception, DatatypeConfigurationException {

        final Session sessionProductos;
        final Transaction txProductos;

        List<Producto> lstprod = new ArrayList<>();
        sessionProductos = ProductosHU.getSessionFactory().getCurrentSession();
        try {
            txProductos = sessionProductos.beginTransaction();
            try {

                String strsql;
                Query q = null;
                List<aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Producto> lstpro = new ArrayList<>();

                strsql = "SELECT Producto.* FROM Campanias INNER JOIN Producto ON Producto.id_Producto = Campanias.id_Producto WHERE GETDATE()>= Campanias.fecha_Inicio AND GETDATE() <= Campanias.fecha_Fin ";

                q = sessionProductos.createSQLQuery(strsql).addEntity(aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Producto.class);
                lstpro = q.list();

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
                txProductos.commit();
                System.out.println("cierre");
            } catch (Exception e) {
                txProductos.rollback();

                System.out.println("Error al consultar las campañas: " + e.getMessage());
            }
        } finally {
            if (sessionProductos.isOpen()) {
                sessionProductos.close();
            }
            return lstprod;
        }
    }

    public java.util.List<com.touresbalon.productostouresbalon.Producto> consultarPorEspectaculoProducto(java.lang.String espectaculo) throws ConsultarPorEspectaculoProductoFault_Exception, DatatypeConfigurationException {

        Session sessionProductos;
//        Session sessionOrdenes;
        Transaction txProductos;
//        Transaction txOrdenes;

        sessionProductos = ProductosHU.getSessionFactory().getCurrentSession();
        txProductos = sessionProductos.beginTransaction();

        List<Producto> lstProductos = new ArrayList<>();
        List<aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Producto> lstProductEntity = new ArrayList<>();

        String sqlQuery;
        Query q = null;

        sqlQuery = "from Producto where CONTAINS(espectaculo, :espectaculo)";

        try {
            sessionProductos.createQuery(sqlQuery).setParameter("espectaculo", espectaculo);
            q = sessionProductos.createQuery(sqlQuery);
        } catch (Exception e) {
            System.out.println("Error al consultar el espectaculo: " + e.getMessage());
        }

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
        if (sessionProductos.isOpen()) {
            sessionProductos.close();
        }
        return lstProductos;
    }

    public java.util.List<com.touresbalon.productostouresbalon.TarifaValores> consultarRankingEspectaculosVendidosProducto(javax.xml.datatype.XMLGregorianCalendar fechaInicial, javax.xml.datatype.XMLGregorianCalendar fechaFin) throws ConsultarRankingEspectaculosVendidosProductoFault_Exception {

        Session sessionProductos;
        Session sessionOrdenes;
        Transaction txProductos;
        Transaction txOrdenes;

        sessionProductos = ProductosHU.getSessionFactory().getCurrentSession();
        txProductos = sessionProductos.beginTransaction();

        sessionOrdenes = ClientesyOrdenesHU.getSessionFactory().getCurrentSession();
        txOrdenes = sessionOrdenes.beginTransaction();

        aes.pica.touresbalon.touresbalonproductosws.entidades.productos.TarifaEspectaculo TarifaEspectaculoEntity = new aes.pica.touresbalon.touresbalonproductosws.entidades.productos.TarifaEspectaculo();
        List<TarifaValores> lstRankingEspectaculos = new ArrayList<>();
        List<Integer> lstProductos = new ArrayList<>();
        Query query;

        String strsql = ""
                + "SELECT "
                + "  PRODID "
                + "FROM "
                + "  ( "
                + "    SELECT "
                + "      ITEMS.PRODID, "
                + "      SUM ( ITEMS.QUANTITY ) AS SUM_QUANTITY "
                + "    FROM "
                + "      ITEMS "
                + "    INNER JOIN ORDERS "
                + "    ON "
                + "      ORDERS.ORDID = ITEMS.ORDID "
                + "    AND ORDERDATE BETWEEN TO_DATE ( :fechaInicial, 'yyyymmdd' ) AND TO_DATE ( :fechaFinal, 'yyyymmdd' ) "
                + "    GROUP BY "
                + "      ITEMS.PRODID "
                + "    ORDER BY "
                + "      SUM_QUANTITY DESC "
                + "  ) "
                + "WHERE "
                + "  ROWNUM <= 10";

        try {
            query = sessionOrdenes.createQuery(strsql)
                    .setParameter("fechaInicial", fechaInicial)
                    .setParameter("fechaFinal", fechaFin);
            lstProductos = query.list();
        } catch (Exception e) {
            System.out.println("Error al consultar el los productos: " + e.getMessage());
        }

        for (Integer idProducto : lstProductos) {
            TarifaValores t = new TarifaValores();
            strsql = "from tarifaEspectaculo where productos.idProducto = :idProducto";
            query = sessionProductos.createQuery(strsql).setParameter("idProducto", idProducto);
            TarifaEspectaculoEntity = (aes.pica.touresbalon.touresbalonproductosws.entidades.productos.TarifaEspectaculo) query;
            t.setId(TarifaEspectaculoEntity.getIdEspectaculo());
            t.setNombreTipo(TarifaEspectaculoEntity.getNombreEspectaculo());
            t.setPrecio(TarifaEspectaculoEntity.getPrecio());
            lstRankingEspectaculos.add(t);
        }
        if (sessionProductos.isOpen()) {
            sessionProductos.close();
        }
        if (sessionOrdenes.isOpen()) {
            sessionOrdenes.close();
        }
        return lstRankingEspectaculos;
    }

    public java.util.List<com.touresbalon.productostouresbalon.Producto> consultarRankingFechaProducto(javax.xml.datatype.XMLGregorianCalendar fechaInicial, javax.xml.datatype.XMLGregorianCalendar fechaFin) throws ConsultarRankingFechaProductoFault_Exception, DatatypeConfigurationException {

        Session sessionProductos;
        Session sessionOrdenes;
        Transaction txProductos;
        Transaction txOrdenes;

        sessionProductos = ProductosHU.getSessionFactory().getCurrentSession();
        txProductos = sessionProductos.beginTransaction();

        sessionOrdenes = ClientesyOrdenesHU.getSessionFactory().getCurrentSession();
        txOrdenes = sessionOrdenes.beginTransaction();

        List<Producto> lstRankingProductos = new ArrayList<>();
        List<Integer> lstProductos = new ArrayList<>();
        Query query;

        String strsql = "WITH "
                + "  ProductoS AS "
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
                + "  ProductoS.prodid, "
                + "FROM "
                + "  ProductoS "
                + "WHERE "
                + "  ROWNUM <= 10";
        try {
            query = sessionOrdenes.createQuery(strsql);
            lstProductos = query.list();
            query = sessionOrdenes.createQuery(strsql);
            lstProductos = query.list();

            for (Integer p : lstProductos) {
                strsql = "from Producto where productos.idProducto = " + p;
                query = sessionProductos.createQuery(strsql);
                List<aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Producto> lstProductEntity = new ArrayList<>();
                lstProductEntity = query.list();
                for (aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Producto prod : lstProductEntity) {
                    Producto p1 = new Producto();
                    p1.setIdProducto(prod.getIdProducto());
                    p1.setEspectaculo(prod.getEspectaculo());
                    p1.setDescripcion(prod.getDescripcion());

                    TarifaValores tarifaEspectaculo = new TarifaValores();
                    tarifaEspectaculo.setId(prod.getTarifaEspectaculo().getIdEspectaculo());
                    tarifaEspectaculo.setNombreTipo(prod.getTarifaEspectaculo().getNombreEspectaculo());
                    tarifaEspectaculo.setPrecio(prod.getTarifaEspectaculo().getPrecio());
                    p1.setTipoEspectaculo(tarifaEspectaculo);

                    TarifaValores tarifaTransporte = new TarifaValores();
                    tarifaTransporte.setId(prod.getTarifaTransporte().getIdTransporte());
                    tarifaTransporte.setNombreTipo(prod.getTarifaTransporte().getNombreTransporte());
                    tarifaTransporte.setPrecio(prod.getTarifaTransporte().getPrecio());
                    p1.setTipoTransporte(tarifaTransporte);

                    TarifaValores tarifaHospedaje = new TarifaValores();
                    tarifaHospedaje.setId(prod.getTarifaHospedaje().getIdHospedaje());
                    tarifaHospedaje.setNombreTipo(prod.getTarifaHospedaje().getNombreHospedaje());
                    tarifaHospedaje.setPrecio(prod.getTarifaHospedaje().getPrecio());
                    p1.setTipoHospedaje(tarifaHospedaje);

                    p1.setFechaSalida(toGregorian(prod.getFechaSalida()));
                    p1.setFechaLlegada(toGregorian(prod.getFechaLlegada()));

                    p1.setImagenProducto(prod.getUrlImagen());
                    lstRankingProductos.add(p1);
                }
            }
        } catch (Exception e) {
            System.out.println("Error al consultar los productos: " + e.getMessage());
        }
        if (sessionProductos.isOpen()) {
            sessionProductos.close();
        }
        if (sessionOrdenes.isOpen()) {
            sessionOrdenes.close();
        }
        return lstRankingProductos;
    }

    public com.touresbalon.productostouresbalon.TipoGestionCampaniaResponse gestionCampaniaProducto(com.touresbalon.productostouresbalon.TipoAccion tipoOperacion, com.touresbalon.productostouresbalon.Campania campania) throws GestionCampaniaProductoFault_Exception {

        Session sessionProductos;
        Transaction txProductos;

        sessionProductos = ProductosHU.getSessionFactory().getCurrentSession();
        txProductos = sessionProductos.beginTransaction();

        String sqlQuery;
        Query q = null;
        int idcamp;
        com.touresbalon.productostouresbalon.TipoGestionCampaniaResponse respuesta = new com.touresbalon.productostouresbalon.TipoGestionCampaniaResponse();
//        if (null!=tipoOperacion  )
        switch (tipoOperacion) {
            case ADICIONAR: {
                try {
                    aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Campanias camp = new aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Campanias();
                    aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Producto prod = new aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Producto();
                    prod.setIdProducto(campania.getIdProducto().getIdProducto());
                    camp.setProducto(prod);
                    camp.setFechaInicio(toDate(campania.getFechaInicioCampania()));
                    camp.setFechaFin(toDate(campania.getFechaFinCampania()));
                    sessionProductos.save(camp);
                    if (camp.getIdCampania() > 0) {
                        respuesta.setRespuesta(RespuestaGenerica.OK);
                        respuesta.setIdCampania(camp.getIdCampania());
                    } else {
                        respuesta.setRespuesta(RespuestaGenerica.KO);
                    }
                    txProductos.commit();
                } catch (Exception e) {
                    System.out.println("Error al Crear la Campaña: " + e.getMessage());
                    txProductos.rollback();
                }
                break;
            }
            case MODIFICAR:

                List<aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Campanias> lstcamp;
                lstcamp = new ArrayList<>();

                try {
                    idcamp = Integer.valueOf(campania.getIdProducto().getEspectaculo());
                } catch (Exception e) {
                    idcamp = 0;
                }

                try {
                    sqlQuery = "from Campanias where idCampania = :idcampana";
                    q = sessionProductos.createQuery(sqlQuery).setParameter("idcampana", idcamp);
                    lstcamp = q.list();
                } catch (Exception e) {
                    System.out.println("Error al Consultarla campaña: " + e.getMessage());
                }

                if (lstcamp.size() > 0) {

                    aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Campanias camp = new aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Campanias();
                    aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Producto prod = new aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Producto();
                    prod.setIdProducto(campania.getIdProducto().getIdProducto());
                    camp.setProducto(prod);
                    camp.setIdCampania(idcamp);
                    camp.setFechaInicio(toDate(campania.getFechaInicioCampania()));
                    camp.setFechaFin(toDate(campania.getFechaFinCampania()));
                    try {
                        sessionProductos.clear();
                        sessionProductos.update(camp);
                        if (camp.getIdCampania() > 0) {
                            respuesta.setRespuesta(RespuestaGenerica.OK);
                        } else {
                            respuesta.setRespuesta(RespuestaGenerica.KO);
                        }
                        txProductos.commit();
                    } catch (Exception e) {
                        System.out.println("Error al actualizar campaña: " + e.getMessage());
                        txProductos.rollback();
                    }

                } else {
                    respuesta.setRespuesta(RespuestaGenerica.KO);
                }
                break;
            case ELIMINAR: {

                aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Campanias camp = new aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Campanias();
                List<aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Campanias> lstcampa;

                try {
                    idcamp = Integer.valueOf(campania.getIdProducto().getEspectaculo());

                } catch (Exception e) {
                    idcamp = 0;
                }

                try {
                    sqlQuery = "from Campanias where idCampania = :idcampana";
                    q = sessionProductos.createQuery(sqlQuery).setParameter("idcampana", idcamp);
                    lstcampa = q.list();
                    if (lstcampa.size() > 0) {

                        sessionProductos.clear();
                        camp.setIdCampania(idcamp);
                        sessionProductos.delete(camp);
                        if (camp.getIdCampania() > 0) {
                            respuesta.setRespuesta(RespuestaGenerica.OK);
                        } else {
                            respuesta.setRespuesta(RespuestaGenerica.KO);
                        }
                        txProductos.commit();
                    } else {
                        respuesta.setRespuesta(RespuestaGenerica.KO);
                    }
                } catch (Exception e) {
                    System.out.println("No se pudo borrar la campaña: " + e.getMessage());
                    txProductos.rollback();
                }
                break;
            }
            default:
                respuesta.setRespuesta(RespuestaGenerica.KO);
                break;
        }

        if (sessionProductos.isOpen()) {
            sessionProductos.close();
        }
        return respuesta;
    }

    public com.touresbalon.productostouresbalon.TipoGestionProductoResponse gestionProducto(com.touresbalon.productostouresbalon.TipoAccion tipoOperacion, com.touresbalon.productostouresbalon.Producto producto) throws GestionProductoFault_Exception {

        Session sessionProductos;
        Transaction txProductos;

        String sqlQuery;
        Query q = null;
        int idprod;
        com.touresbalon.productostouresbalon.TipoGestionProductoResponse respuesta = new com.touresbalon.productostouresbalon.TipoGestionProductoResponse();
        sessionProductos = ProductosHU.getSessionFactory().getCurrentSession();
        txProductos = sessionProductos.beginTransaction();

        switch (tipoOperacion) {
            case ADICIONAR: {
                try {
                    aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Producto prod = new aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Producto();
                    aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Ciudad ciu = new aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Ciudad();
                    aes.pica.touresbalon.touresbalonproductosws.entidades.productos.TarifaEspectaculo taresp = new aes.pica.touresbalon.touresbalonproductosws.entidades.productos.TarifaEspectaculo();
                    aes.pica.touresbalon.touresbalonproductosws.entidades.productos.TarifaHospedaje tarhos = new aes.pica.touresbalon.touresbalonproductosws.entidades.productos.TarifaHospedaje();
                    aes.pica.touresbalon.touresbalonproductosws.entidades.productos.TarifaTransporte tartran = new aes.pica.touresbalon.touresbalonproductosws.entidades.productos.TarifaTransporte();

                    ciu.setIdCiudad(producto.getCiudadEspectaculo().getIdCiudad());
                    ciu.setPais(producto.getCiudadEspectaculo().getPais());

                    prod.setCiudad(ciu);
                    prod.setDescripcion(producto.getDescripcion());
                    prod.setEspectaculo(producto.getEspectaculo());
                    prod.setFechaEspectaculo(toDate(producto.getFechaEspectaculo()));
                    prod.setFechaLlegada(toDate(producto.getFechaLlegada()));
                    prod.setFechaSalida(toDate(producto.getFechaSalida()));
                    prod.setIdProducto(producto.getIdProducto());

                    taresp.setIdEspectaculo(producto.getTipoEspectaculo().getId());
                    taresp.setNombreEspectaculo(producto.getTipoEspectaculo().getNombreTipo());
                    taresp.setPrecio(producto.getTipoEspectaculo().getPrecio());

                    tarhos.setIdHospedaje(producto.getTipoHospedaje().getId());
                    tarhos.setNombreHospedaje(producto.getTipoHospedaje().getNombreTipo());
                    tarhos.setPrecio(producto.getTipoHospedaje().getPrecio());

                    tartran.setIdTransporte(producto.getTipoTransporte().getId());
                    tartran.setNombreTransporte(producto.getTipoTransporte().getNombreTipo());
                    tartran.setPrecio(producto.getTipoTransporte().getPrecio());

                    prod.setTarifaEspectaculo(taresp);
                    prod.setTarifaHospedaje(tarhos);
                    prod.setTarifaTransporte(tartran);

                    prod.setUrlImagen(producto.getImagenProducto());

                    sessionProductos.save(prod);
                    if (prod.getIdProducto() > 0) {
                        respuesta.setRespuesta(RespuestaGenerica.OK);
                        respuesta.setIdProducto(prod.getIdProducto());
                    } else {
                        respuesta.setRespuesta(RespuestaGenerica.KO);
                    }
                    txProductos.commit();
                } catch (Exception e) {
                    System.out.println("Error al Adicionar Producto: " + e.getMessage());
                    txProductos.rollback();
                }

                break;
            }
            case MODIFICAR:

                try {
                    idprod = Integer.valueOf(producto.getIdProducto());
                } catch (Exception e) {
                    idprod = 0;
                }

                try {
                    sqlQuery = "from Productos where id_producto = :idproducto";
                    q = sessionProductos.createQuery(sqlQuery).setParameter("idproducto", idprod);
                    List<aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Producto> lstprod = q.list();
                    if (lstprod.size() > 0) {

                        sessionProductos.clear();
                        aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Producto prod = new aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Producto();
                        aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Ciudad ciu = new aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Ciudad();
                        aes.pica.touresbalon.touresbalonproductosws.entidades.productos.TarifaEspectaculo taresp = new aes.pica.touresbalon.touresbalonproductosws.entidades.productos.TarifaEspectaculo();
                        aes.pica.touresbalon.touresbalonproductosws.entidades.productos.TarifaHospedaje tarhos = new aes.pica.touresbalon.touresbalonproductosws.entidades.productos.TarifaHospedaje();
                        aes.pica.touresbalon.touresbalonproductosws.entidades.productos.TarifaTransporte tartran = new aes.pica.touresbalon.touresbalonproductosws.entidades.productos.TarifaTransporte();

                        ciu.setIdCiudad(producto.getCiudadEspectaculo().getIdCiudad());
                        ciu.setPais(producto.getCiudadEspectaculo().getPais());

                        prod.setCiudad(ciu);
                        prod.setDescripcion(producto.getDescripcion());
                        prod.setEspectaculo(producto.getEspectaculo());
                        prod.setFechaEspectaculo(toDate(producto.getFechaEspectaculo()));
                        prod.setFechaLlegada(toDate(producto.getFechaLlegada()));
                        prod.setFechaSalida(toDate(producto.getFechaSalida()));
                        prod.setIdProducto(producto.getIdProducto());

                        taresp.setIdEspectaculo(producto.getTipoEspectaculo().getId());
                        taresp.setNombreEspectaculo(producto.getTipoEspectaculo().getNombreTipo());
                        taresp.setPrecio(producto.getTipoEspectaculo().getPrecio());

                        tarhos.setIdHospedaje(producto.getTipoHospedaje().getId());
                        tarhos.setNombreHospedaje(producto.getTipoHospedaje().getNombreTipo());
                        tarhos.setPrecio(producto.getTipoHospedaje().getPrecio());

                        tartran.setIdTransporte(producto.getTipoTransporte().getId());
                        tartran.setNombreTransporte(producto.getTipoTransporte().getNombreTipo());
                        tartran.setPrecio(producto.getTipoTransporte().getPrecio());

                        prod.setTarifaEspectaculo(taresp);
                        prod.setTarifaHospedaje(tarhos);
                        prod.setTarifaTransporte(tartran);

                        prod.setUrlImagen(producto.getImagenProducto());

                        sessionProductos.update(prod);

                        if (prod.getIdProducto() > 0) {
                            respuesta.setRespuesta(RespuestaGenerica.OK);
                        } else {
                            respuesta.setRespuesta(RespuestaGenerica.KO);
                        }
                        txProductos.commit();
                    } else {
                        respuesta.setRespuesta(RespuestaGenerica.KO);
                    }
                } catch (Exception e) {
                    System.out.println("Error al Modificar Producto: " + e.getMessage());
                    txProductos.rollback();
                }

                break;
            case ELIMINAR: {

                aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Producto prod = new aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Producto();
//                prod.setIdProducto( campania.getIdProducto().getIdProducto());
//                camp.setProducto(prod);
                try {
                    idprod = Integer.valueOf(producto.getIdProducto());
                } catch (Exception e) {
                    idprod = 0;
                }

                try {

                    sqlQuery = "from Productos where id_producto = :idproducto";
                    q = sessionProductos.createQuery(sqlQuery).setParameter("idproducto", idprod);
                    List<aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Producto> lstproducto = q.list();
                    if (lstproducto.size() > 0) {

                        sessionProductos.clear();
                        prod.setIdProducto(idprod);
                        sessionProductos.delete(prod);
                        if (prod.getIdProducto() > 0) {
                            respuesta.setRespuesta(RespuestaGenerica.OK);
                        } else {
                            respuesta.setRespuesta(RespuestaGenerica.KO);
                        }
                        txProductos.commit();
                    } else {
                        respuesta.setRespuesta(RespuestaGenerica.KO);
                    }
                } catch (Exception e) {
                    System.out.println("Error al Eliminar Producto: " + e.getMessage());
                    txProductos.rollback();
                }
                break;
            }
            default:
                respuesta.setRespuesta(RespuestaGenerica.KO);
                break;
        }
        if (sessionProductos.isOpen()) {
            sessionProductos.close();
        }
        return respuesta;
    }

    public com.touresbalon.productostouresbalon.TipoGestionTarifaResponse gestionTarifa(com.touresbalon.productostouresbalon.TipoAccion tipoOperacion, com.touresbalon.productostouresbalon.TipoTarifa tipoTarifa, com.touresbalon.productostouresbalon.TarifaValores tarifa) throws GestionTarifaFault_Exception {
        //TODO implement this method
        Session sessionProductos;
        Transaction txProductos;
        int idtarifa;
        String sqlQuery;
        Query q = null;
        com.touresbalon.productostouresbalon.TipoGestionTarifaResponse respuesta = new com.touresbalon.productostouresbalon.TipoGestionTarifaResponse();
        sessionProductos = ProductosHU.getSessionFactory().getCurrentSession();

        switch (tipoTarifa) {
            case TRANSPORTE: {
                aes.pica.touresbalon.touresbalonproductosws.entidades.productos.TarifaTransporte tartra = new aes.pica.touresbalon.touresbalonproductosws.entidades.productos.TarifaTransporte();

                txProductos = sessionProductos.beginTransaction();

                if (tipoOperacion != com.touresbalon.productostouresbalon.TipoAccion.ADICIONAR) {
                    try {
                        idtarifa = tarifa.getId();
                    } catch (Exception e) {
                        idtarifa = 0;
                    }
                    sqlQuery = "from TarifaTransporte where idTransporte = :idtarifa";
                    q = sessionProductos.createQuery(sqlQuery).setParameter("idtarifa", idtarifa);
                    List<aes.pica.touresbalon.touresbalonproductosws.entidades.productos.TarifaTransporte> lsttras = q.list();

                    if (lsttras.size() > 0) {
                        sessionProductos.clear();
                        tartra.setIdTransporte(idtarifa);

                        if (tipoOperacion == com.touresbalon.productostouresbalon.TipoAccion.ELIMINAR) {
                            try {
                                sessionProductos.delete(tartra);
                                if (tartra.getIdTransporte() > 0) {
                                    respuesta.setRespuesta(RespuestaGenerica.OK);
                                } else {
                                    respuesta.setRespuesta(RespuestaGenerica.KO);
                                }
                                respuesta.setTarifa(tipoTarifa);

                                txProductos.commit();
                            } catch (Exception e) {
                                txProductos.rollback();
                                System.out.println("Error al borrar el tipo de tarifa de transporte: " + e);
                                respuesta.setRespuesta(RespuestaGenerica.KO);
                                txProductos.rollback();

                            }
                        } else {
                            tartra.setNombreTransporte(tarifa.getNombreTipo());
                            tartra.setPrecio(tarifa.getPrecio());
                            try {
                                sessionProductos.update(tartra);
                                if (tartra.getIdTransporte() > 0) {
                                    respuesta.setRespuesta(RespuestaGenerica.OK);
                                } else {
                                    respuesta.setRespuesta(RespuestaGenerica.KO);
                                }
                                respuesta.setTarifa(tipoTarifa);
                                txProductos.commit();
                            } catch (Exception e) {
                                txProductos.rollback();
                                System.out.println("Error al actualizar el tipo de tarifa de transporte: " + e);
                                respuesta.setRespuesta(RespuestaGenerica.KO);
                                txProductos.rollback();
                            }

                        }

                    }
                } else {
                    tartra.setNombreTransporte(tarifa.getNombreTipo());
                    tartra.setPrecio(tarifa.getPrecio());
                    try {
                        sessionProductos.save(tartra);
                        if (tartra.getIdTransporte() > 0) {
                            respuesta.setRespuesta(RespuestaGenerica.OK);
                        } else {
                            respuesta.setRespuesta(RespuestaGenerica.KO);
                        }
                        respuesta.setTarifa(tipoTarifa);
                        txProductos.commit();
                    } catch (Exception e) {
                        txProductos.rollback();
                        System.out.println("Error al crear el tipo de tarifa de transporte: " + e);
                        respuesta.setRespuesta(RespuestaGenerica.KO);
                        txProductos.rollback();

                    }
                }

//             if (sessionProductos.isOpen())
//                sessionProductos.close();
                break;

            }
            case HOSPEDAJE: {
                aes.pica.touresbalon.touresbalonproductosws.entidades.productos.TarifaHospedaje tarhos = new aes.pica.touresbalon.touresbalonproductosws.entidades.productos.TarifaHospedaje();
                sessionProductos = ProductosHU.getSessionFactory().getCurrentSession();
                txProductos = sessionProductos.beginTransaction();
                if (tipoOperacion != com.touresbalon.productostouresbalon.TipoAccion.ADICIONAR) {
                    try {
                        idtarifa = tarifa.getId();
                    } catch (Exception e) {
                        idtarifa = 0;
                    }

                    sqlQuery = "from TarifaHospedaje where idHospedaje = :idtarifa";
                    q = sessionProductos.createQuery(sqlQuery).setParameter("idtarifa", idtarifa);
                    List<aes.pica.touresbalon.touresbalonproductosws.entidades.productos.TarifaHospedaje> lsthos = q.list();

                    if (lsthos.size() > 0) {
                        sessionProductos.clear();

                        tarhos.setIdHospedaje(idtarifa);

                        if (tipoOperacion == com.touresbalon.productostouresbalon.TipoAccion.ELIMINAR) {
                            try {
                                sessionProductos.delete(tarhos);
                                if (tarhos.getIdHospedaje() > 0) {
                                    respuesta.setRespuesta(RespuestaGenerica.OK);

                                } else {
                                    respuesta.setRespuesta(RespuestaGenerica.KO);
                                }
                                respuesta.setTarifa(tipoTarifa);
                                txProductos.commit();
                            } catch (Exception e) {
                                txProductos.rollback();
                                System.out.println("Error al borrar el tipo de tarifa de hospedaje: " + e);
                                respuesta.setRespuesta(RespuestaGenerica.KO);
                                txProductos.rollback();
                            }

                        } else {
                            tarhos.setNombreHospedaje(tarifa.getNombreTipo());
                            tarhos.setPrecio(tarifa.getPrecio());
                            try {
                                sessionProductos.update(tarhos);
                                if (tarhos.getIdHospedaje() > 0) {
                                    respuesta.setRespuesta(RespuestaGenerica.OK);

                                } else {
                                    respuesta.setRespuesta(RespuestaGenerica.KO);
                                }
                                respuesta.setTarifa(tipoTarifa);
                                txProductos.commit();
                            } catch (Exception e) {
                                txProductos.rollback();
                                System.out.println("Error al modificar el tipo de tarifa de hospedaje: " + e);
                                respuesta.setRespuesta(RespuestaGenerica.KO);
                                txProductos.rollback();
                                // return respuesta;
                            }
                        }

                    }
                } else {

                    tarhos.setNombreHospedaje(tarifa.getNombreTipo());
                    tarhos.setPrecio(tarifa.getPrecio());
                    try {
                        sessionProductos.save(tarhos);
                        if (tarhos.getIdHospedaje() > 0) {
                            respuesta.setRespuesta(RespuestaGenerica.OK);

                        } else {
                            respuesta.setRespuesta(RespuestaGenerica.KO);
                        }
                        respuesta.setTarifa(tipoTarifa);
                        txProductos.commit();
                    } catch (Exception e) {
                        txProductos.rollback();
                        System.out.println("Error al crear el tipo de tarifa de hospedaje: " + e);
                        respuesta.setRespuesta(RespuestaGenerica.KO);
                        txProductos.rollback();
                    }

                }

//            if (sessionProductos.isOpen())
//                sessionProductos.close();
                break;
            }

            case ESPECTACULO: {
                aes.pica.touresbalon.touresbalonproductosws.entidades.productos.TarifaEspectaculo taresp = new aes.pica.touresbalon.touresbalonproductosws.entidades.productos.TarifaEspectaculo();
                sessionProductos = ProductosHU.getSessionFactory().getCurrentSession();
                txProductos = sessionProductos.beginTransaction();
                if (tipoOperacion != com.touresbalon.productostouresbalon.TipoAccion.ADICIONAR) {
                    try {
                        idtarifa = tarifa.getId();
                    } catch (Exception e) {
                        idtarifa = 0;
                    }

                    sqlQuery = "from TarifaEspectaculo where idEspectaculo = :idtarifa";
                    q = sessionProductos.createQuery(sqlQuery).setParameter("idtarifa", idtarifa);
                    List<aes.pica.touresbalon.touresbalonproductosws.entidades.productos.TarifaEspectaculo> lsttras = q.list();

                    if (lsttras.size() > 0) {
                        sessionProductos.clear();

                        taresp.setIdEspectaculo(idtarifa);

                        if (tipoOperacion == com.touresbalon.productostouresbalon.TipoAccion.ELIMINAR) {
                            try {
                                sessionProductos.delete(taresp);
                                if (taresp.getIdEspectaculo() > 0) {
                                    respuesta.setRespuesta(RespuestaGenerica.OK);

                                } else {
                                    respuesta.setRespuesta(RespuestaGenerica.KO);
                                }
                                respuesta.setTarifa(tipoTarifa);

                                txProductos.commit();
                            } catch (Exception e) {
                                txProductos.rollback();
                                System.out.println("Error al borrar el tipo de tarifa de espectaculo: " + e);
                                respuesta.setRespuesta(RespuestaGenerica.KO);
                                txProductos.rollback();
                            }
                        } else {
                            taresp.setNombreEspectaculo(tarifa.getNombreTipo());
                            taresp.setPrecio(tarifa.getPrecio());
                            try {
                                sessionProductos.update(taresp);
                                if (taresp.getIdEspectaculo() > 0) {
                                    respuesta.setRespuesta(RespuestaGenerica.OK);

                                } else {
                                    respuesta.setRespuesta(RespuestaGenerica.KO);
                                }
                                respuesta.setTarifa(tipoTarifa);

                                txProductos.commit();
                            } catch (Exception e) {
                                txProductos.rollback();
                                System.out.println("Error al modificar el tipo de tarifa de espectaculo: " + e);
                                respuesta.setRespuesta(RespuestaGenerica.KO);
                                txProductos.rollback();
                            }
                        }

                    }
                } else {

                    taresp.setNombreEspectaculo(tarifa.getNombreTipo());
                    taresp.setPrecio(tarifa.getPrecio());
                    try {
                        sessionProductos.save(taresp);
                        if (taresp.getIdEspectaculo() > 0) {
                            respuesta.setRespuesta(RespuestaGenerica.OK);

                        } else {
                            respuesta.setRespuesta(RespuestaGenerica.KO);
                        }
                        respuesta.setTarifa(tipoTarifa);

                        txProductos.commit();

                    } catch (Exception e) {
                        txProductos.rollback();
                        System.out.println("Error al crear el tipo de tarifa de espectaculo: " + e);
                        respuesta.setRespuesta(RespuestaGenerica.KO);
                        txProductos.rollback();
                    }

                }

                if (sessionProductos.isOpen()) {
                    sessionProductos.close();
                }
                break;
            }
            case CIUDAD: {
                aes.pica.touresbalon.touresbalonproductosws.entidades.productos.TarifaCiudad tarciu = new aes.pica.touresbalon.touresbalonproductosws.entidades.productos.TarifaCiudad();

                sessionProductos = ProductosHU.getSessionFactory().getCurrentSession();
                txProductos = sessionProductos.beginTransaction();
                if (tipoOperacion != com.touresbalon.productostouresbalon.TipoAccion.ADICIONAR) {
                    try {
                        idtarifa = tarifa.getId();
                    } catch (Exception e) {
                        idtarifa = 0;
                    }

                    sqlQuery = "from TarifaCiudad where idTarifaCiudad = :idtarifa";
                    q = sessionProductos.createQuery(sqlQuery).setParameter("idtarifa", idtarifa);
                    List<aes.pica.touresbalon.touresbalonproductosws.entidades.productos.TarifaCiudad> lsttras = q.list();

                    if (lsttras.size() > 0) {
                        sessionProductos.clear();

                        tarciu.setIdTarifaCiudad(idtarifa);

                        if (tipoOperacion == com.touresbalon.productostouresbalon.TipoAccion.ELIMINAR) {
                            try {
                                sessionProductos.delete(tarciu);
                                if (tarciu.getIdTarifaCiudad() > 0) {
                                    respuesta.setRespuesta(RespuestaGenerica.OK);

                                } else {
                                    respuesta.setRespuesta(RespuestaGenerica.KO);
                                }
                                respuesta.setTarifa(tipoTarifa);

                                txProductos.commit();
                            } catch (Exception e) {
                                txProductos.rollback();
                                System.out.println("Error al borrar el tipo de tarifa de ciudad: " + e);
                                respuesta.setRespuesta(RespuestaGenerica.KO);
                                txProductos.rollback();
                            }
                        } else {

                            tarciu.setTipoCiudad(tarifa.getNombreTipo());
                            tarciu.setPrecio(tarifa.getPrecio());
                            try {
                                sessionProductos.update(tarciu);
                                if (tarciu.getIdTarifaCiudad() > 0) {
                                    respuesta.setRespuesta(RespuestaGenerica.OK);

                                } else {
                                    respuesta.setRespuesta(RespuestaGenerica.KO);
                                }
                                respuesta.setTarifa(tipoTarifa);

                                txProductos.commit();
                            } catch (Exception e) {
                                txProductos.rollback();
                                System.out.println("Error al modificar el tipo de tarifa de ciudad: " + e);
                                respuesta.setRespuesta(RespuestaGenerica.KO);
                                txProductos.rollback();
                            }
                        }

                    }
                } else {

                    tarciu.setTipoCiudad(tarifa.getNombreTipo());
                    tarciu.setPrecio(tarifa.getPrecio());
                    try {
                        sessionProductos.save(tarciu);
                        if (tarciu.getIdTarifaCiudad() > 0) {
                            respuesta.setRespuesta(RespuestaGenerica.OK);

                        } else {
                            respuesta.setRespuesta(RespuestaGenerica.KO);
                        }
                        respuesta.setTarifa(tipoTarifa);

                        txProductos.commit();
                    } catch (Exception e) {
                        txProductos.rollback();
                        System.out.println("Error al crear el tipo de tarifa de ciudad: " + e);
                        respuesta.setRespuesta(RespuestaGenerica.KO);
                        txProductos.rollback();
                    }

                }

                if (sessionProductos.isOpen()) {
                    sessionProductos.close();
                }
                break;
            }
            default: {
                respuesta.setRespuesta(RespuestaGenerica.KO);
            }
        }
        return respuesta;
    }

    public java.util.List<com.touresbalon.productostouresbalon.Producto> consultaTop5Productos(java.util.List<java.lang.Integer> idProducto) throws ConsultaTop5ProductosFault_Exception, DatatypeConfigurationException {

        Session sessionProductos;
        Session sessionOrdenes;
        Transaction txProductos;
        Transaction txOrdenes;

        sessionProductos = ProductosHU.getSessionFactory().getCurrentSession();
        sessionOrdenes = ClientesyOrdenesHU.getSessionFactory().getCurrentSession();

        txProductos = sessionProductos.beginTransaction();
        txOrdenes = sessionOrdenes.beginTransaction();

        List<Producto> lstRankingProductos = new ArrayList<>();
        List<BigDecimal> lstProductos = new ArrayList<>();

        Query query;

        String strsql = ""
                + "SELECT "
                + "  PRODID "
                + "FROM "
                + "  ( "
                + "    SELECT "
                + "      ASOCIADOS.PRODID, "
                + "      COUNT ( ASOCIADOS.PRODID ) AS COUNT_PRODID "
                + "    FROM "
                + "      ITEMS SELECCIONADO "
                + "    INNER JOIN ORDERS "
                + "    ON "
                + "      ORDERS.ORDID = SELECCIONADO.ORDID "
                + "    AND SELECCIONADO.PRODID = " + idProducto.get(0)
                + "    INNER JOIN ITEMS ASOCIADOS "
                + "    ON "
                + "      ORDERS.ORDID = ASOCIADOS.ORDID "
                + "    AND SELECCIONADO.PRODID <> ASOCIADOS.PRODID "
                + "    GROUP BY "
                + "      ASOCIADOS.PRODID, "
                + "      ORDERS.ORDID "
                + "    ORDER BY "
                + "      COUNT_PRODID DESC "
                + "  ) "
                + "WHERE "
                + "  ROWNUM <= 5";

        try {
            query = sessionOrdenes.createSQLQuery(strsql);
            lstProductos = query.list();
        } catch (Exception e) {
            System.out.println("Error al consultar el producto: " + e.getMessage());
        }

        for (BigDecimal p : lstProductos) {
            strsql = "from Producto where idProducto = " + p.intValue();
            List<aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Producto> lstProductEntity = new ArrayList<>();
            try {
                query = sessionProductos.createQuery(strsql);
                lstProductEntity = query.list();
            } catch (Exception e) {
                System.out.println("Error al consultar el producto: " + e.getMessage());
            }

            for (aes.pica.touresbalon.touresbalonproductosws.entidades.productos.Producto prod : lstProductEntity) {
                Producto p1 = new Producto();
                p1.setIdProducto(prod.getIdProducto());
                p1.setEspectaculo(prod.getEspectaculo());
                p1.setDescripcion(prod.getDescripcion());

                TarifaValores tarifaEspectaculo = new TarifaValores();
                tarifaEspectaculo.setId(prod.getTarifaEspectaculo().getIdEspectaculo());
                tarifaEspectaculo.setNombreTipo(prod.getTarifaEspectaculo().getNombreEspectaculo());
                tarifaEspectaculo.setPrecio(prod.getTarifaEspectaculo().getPrecio());
                p1.setTipoEspectaculo(tarifaEspectaculo);

                TarifaValores tarifaTransporte = new TarifaValores();
                tarifaTransporte.setId(prod.getTarifaTransporte().getIdTransporte());
                tarifaTransporte.setNombreTipo(prod.getTarifaTransporte().getNombreTransporte());
                tarifaTransporte.setPrecio(prod.getTarifaTransporte().getPrecio());
                p1.setTipoTransporte(tarifaTransporte);

                TarifaValores tarifaHospedaje = new TarifaValores();
                tarifaHospedaje.setId(prod.getTarifaHospedaje().getIdHospedaje());
                tarifaHospedaje.setNombreTipo(prod.getTarifaHospedaje().getNombreHospedaje());
                tarifaHospedaje.setPrecio(prod.getTarifaHospedaje().getPrecio());
                p1.setTipoHospedaje(tarifaHospedaje);

                p1.setFechaSalida(toGregorian(prod.getFechaSalida()));
                p1.setFechaLlegada(toGregorian(prod.getFechaLlegada()));

                p1.setImagenProducto(prod.getUrlImagen());
                lstRankingProductos.add(p1);
            }
        }

        if (sessionProductos.isOpen()) {
            sessionProductos.close();
        }
        if (sessionOrdenes.isOpen()) {
            sessionOrdenes.close();
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
