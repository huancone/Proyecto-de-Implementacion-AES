
package com.touresbalon.productostouresbalon;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ProductosTouresBalon", targetNamespace = "http://www.touresbalon.com/ProductosTouresBalon/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ProductosTouresBalon {


    /**
     * 
     * @param tipoConsulta
     * @param cadenaConsulta
     * @return
     *     returns java.util.List<com.touresbalon.productostouresbalon.Producto>
     * @throws ConsultarProductoFault_Exception
     */
    @WebMethod(operationName = "ConsultarProducto", action = "http://www.touresbalon.com/ProductosTouresBalon/ConsultarProducto")
    @WebResult(name = "productos", targetNamespace = "")
    @RequestWrapper(localName = "ConsultarProducto", targetNamespace = "http://www.touresbalon.com/ProductosTouresBalon/", className = "com.touresbalon.productostouresbalon.ConsultarProducto")
    @ResponseWrapper(localName = "ConsultarProductoResponse", targetNamespace = "http://www.touresbalon.com/ProductosTouresBalon/", className = "com.touresbalon.productostouresbalon.ConsultarProductoResponse")
    public List<Producto> consultarProducto(
        @WebParam(name = "tipo_consulta", targetNamespace = "")
        TipoConsultaProducto tipoConsulta,
        @WebParam(name = "cadena_consulta", targetNamespace = "")
        String cadenaConsulta)
        throws ConsultarProductoFault_Exception
    ;

    /**
     * 
     * @return
     *     returns java.util.List<com.touresbalon.productostouresbalon.Producto>
     * @throws ConsultarCampaniaProductoFault_Exception
     */
    @WebMethod(operationName = "ConsultarCampaniaProducto", action = "http://www.touresbalon.com/ProductosTouresBalon/ConsultarCampaniaProducto")
    @WebResult(name = "productos", targetNamespace = "")
    @RequestWrapper(localName = "ConsultarCampaniaProducto", targetNamespace = "http://www.touresbalon.com/ProductosTouresBalon/", className = "com.touresbalon.productostouresbalon.ConsultarCampaniaProducto")
    @ResponseWrapper(localName = "ConsultarCampaniaProductoResponse", targetNamespace = "http://www.touresbalon.com/ProductosTouresBalon/", className = "com.touresbalon.productostouresbalon.ConsultarCampaniaProductoResponse")
    public List<Producto> consultarCampaniaProducto()
        throws ConsultarCampaniaProductoFault_Exception
    ;

    /**
     * 
     * @param espectaculo
     * @return
     *     returns java.util.List<com.touresbalon.productostouresbalon.Producto>
     * @throws ConsultarPorEspectaculoProductoFault_Exception
     */
    @WebMethod(operationName = "ConsultarPorEspectaculoProducto", action = "http://www.touresbalon.com/ProductosTouresBalon/ConsultarPorEspectaculoProducto")
    @WebResult(name = "productos", targetNamespace = "")
    @RequestWrapper(localName = "ConsultarPorEspectaculoProducto", targetNamespace = "http://www.touresbalon.com/ProductosTouresBalon/", className = "com.touresbalon.productostouresbalon.ConsultarPorEspectaculoProducto")
    @ResponseWrapper(localName = "ConsultarPorEspectaculoProductoResponse", targetNamespace = "http://www.touresbalon.com/ProductosTouresBalon/", className = "com.touresbalon.productostouresbalon.ConsultarPorEspectaculoProductoResponse")
    public List<Producto> consultarPorEspectaculoProducto(
        @WebParam(name = "espectaculo", targetNamespace = "")
        String espectaculo)
        throws ConsultarPorEspectaculoProductoFault_Exception
    ;

    /**
     * 
     * @param fechaInicial
     * @param fechaFin
     * @return
     *     returns java.util.List<com.touresbalon.productostouresbalon.TarifaValores>
     * @throws ConsultarRankingEspectaculosVendidosProductoFault_Exception
     */
    @WebMethod(operationName = "ConsultarRankingEspectaculosVendidosProducto", action = "http://www.touresbalon.com/ProductosTouresBalon/ConsultarRankingEspectaculosVendidosProducto")
    @WebResult(name = "tipo_espectaculo", targetNamespace = "")
    @RequestWrapper(localName = "ConsultarRankingEspectaculosVendidosProducto", targetNamespace = "http://www.touresbalon.com/ProductosTouresBalon/", className = "com.touresbalon.productostouresbalon.ConsultarRankingEspectaculosVendidosProducto")
    @ResponseWrapper(localName = "ConsultarRankingEspectaculosVendidosProductoResponse", targetNamespace = "http://www.touresbalon.com/ProductosTouresBalon/", className = "com.touresbalon.productostouresbalon.ConsultarRankingEspectaculosVendidosProductoResponse")
    public List<TarifaValores> consultarRankingEspectaculosVendidosProducto(
        @WebParam(name = "fecha_inicial", targetNamespace = "")
        XMLGregorianCalendar fechaInicial,
        @WebParam(name = "fecha_fin", targetNamespace = "")
        XMLGregorianCalendar fechaFin)
        throws ConsultarRankingEspectaculosVendidosProductoFault_Exception
    ;

    /**
     * 
     * @param fechaInicial
     * @param fechaFin
     * @return
     *     returns java.util.List<com.touresbalon.productostouresbalon.Producto>
     * @throws ConsultarRankingFechaProductoFault_Exception
     */
    @WebMethod(operationName = "ConsultarRankingFechaProducto", action = "http://www.touresbalon.com/ProductosTouresBalon/ConsultarRankingFechaProducto")
    @WebResult(name = "productos", targetNamespace = "")
    @RequestWrapper(localName = "ConsultarRankingFechaProducto", targetNamespace = "http://www.touresbalon.com/ProductosTouresBalon/", className = "com.touresbalon.productostouresbalon.ConsultarRankingFechaProducto")
    @ResponseWrapper(localName = "ConsultarRankingFechaProductoResponse", targetNamespace = "http://www.touresbalon.com/ProductosTouresBalon/", className = "com.touresbalon.productostouresbalon.ConsultarRankingFechaProductoResponse")
    public List<Producto> consultarRankingFechaProducto(
        @WebParam(name = "fecha_inicial", targetNamespace = "")
        XMLGregorianCalendar fechaInicial,
        @WebParam(name = "fecha_fin", targetNamespace = "")
        XMLGregorianCalendar fechaFin)
        throws ConsultarRankingFechaProductoFault_Exception
    ;

    /**
     * 
     * @param campania
     * @param tipoOperacion
     * @return
     *     returns com.touresbalon.productostouresbalon.TipoGestionCampaniaResponse
     * @throws GestionCampaniaProductoFault_Exception
     */
    @WebMethod(operationName = "GestionCampaniaProducto", action = "http://www.touresbalon.com/ProductosTouresBalon/GestionCampaniaProducto")
    @WebResult(name = "gestioncampaniaResponse", targetNamespace = "")
    @RequestWrapper(localName = "GestionCampaniaProducto", targetNamespace = "http://www.touresbalon.com/ProductosTouresBalon/", className = "com.touresbalon.productostouresbalon.GestionCampaniaProducto")
    @ResponseWrapper(localName = "GestionCampaniaProductoResponse", targetNamespace = "http://www.touresbalon.com/ProductosTouresBalon/", className = "com.touresbalon.productostouresbalon.GestionCampaniaProductoResponse")
    public TipoGestionCampaniaResponse gestionCampaniaProducto(
        @WebParam(name = "tipo_operacion", targetNamespace = "")
        TipoAccion tipoOperacion,
        @WebParam(name = "campania", targetNamespace = "")
        Campania campania)
        throws GestionCampaniaProductoFault_Exception
    ;

    /**
     * 
     * @param tipoOperacion
     * @param producto
     * @return
     *     returns com.touresbalon.productostouresbalon.TipoGestionProductoResponse
     * @throws GestionProductoFault_Exception
     */
    @WebMethod(operationName = "GestionProducto", action = "http://www.touresbalon.com/ProductosTouresBalon/GestionProducto")
    @WebResult(name = "gestion_producto_reponse", targetNamespace = "")
    @RequestWrapper(localName = "GestionProducto", targetNamespace = "http://www.touresbalon.com/ProductosTouresBalon/", className = "com.touresbalon.productostouresbalon.GestionProducto")
    @ResponseWrapper(localName = "GestionProductoResponse", targetNamespace = "http://www.touresbalon.com/ProductosTouresBalon/", className = "com.touresbalon.productostouresbalon.GestionProductoResponse")
    public TipoGestionProductoResponse gestionProducto(
        @WebParam(name = "tipo_operacion", targetNamespace = "")
        TipoAccion tipoOperacion,
        @WebParam(name = "producto", targetNamespace = "")
        Producto producto)
        throws GestionProductoFault_Exception
    ;

    /**
     * 
     * @param tipoTarifa
     * @param tipoOperacion
     * @param tarifa
     * @return
     *     returns com.touresbalon.productostouresbalon.TipoGestionTarifaResponse
     * @throws GestionTarifaFault_Exception
     */
    @WebMethod(operationName = "GestionTarifa", action = "http://www.touresbalon.com/ProductosTouresBalon/GestionTarifa")
    @WebResult(name = "respuesta", targetNamespace = "")
    @RequestWrapper(localName = "GestionTarifa", targetNamespace = "http://www.touresbalon.com/ProductosTouresBalon/", className = "com.touresbalon.productostouresbalon.GestionTarifa")
    @ResponseWrapper(localName = "GestionTarifaResponse", targetNamespace = "http://www.touresbalon.com/ProductosTouresBalon/", className = "com.touresbalon.productostouresbalon.GestionTarifaResponse")
    public TipoGestionTarifaResponse gestionTarifa(
        @WebParam(name = "tipo_operacion", targetNamespace = "")
        TipoAccion tipoOperacion,
        @WebParam(name = "tipo_tarifa", targetNamespace = "")
        TipoTarifa tipoTarifa,
        @WebParam(name = "tarifa", targetNamespace = "")
        TarifaValores tarifa)
        throws GestionTarifaFault_Exception
    ;

    /**
     * 
     * @param idProducto
     * @return
     *     returns java.util.List<com.touresbalon.productostouresbalon.Producto>
     * @throws ConsultaTop5ProductosFault_Exception
     */
    @WebMethod(operationName = "ConsultaTop5Productos", action = "http://www.touresbalon.com/ProductosTouresBalon/ConsultaTop5Productos")
    @WebResult(name = "lista_productos_top", targetNamespace = "")
    @RequestWrapper(localName = "ConsultaTop5Productos", targetNamespace = "http://www.touresbalon.com/ProductosTouresBalon/", className = "com.touresbalon.productostouresbalon.ConsultaTop5Productos")
    @ResponseWrapper(localName = "ConsultaTop5ProductosResponse", targetNamespace = "http://www.touresbalon.com/ProductosTouresBalon/", className = "com.touresbalon.productostouresbalon.ConsultaTop5ProductosResponse")
    public List<Producto> consultaTop5Productos(
        @WebParam(name = "id_producto", targetNamespace = "")
        List<Integer> idProducto)
        throws ConsultaTop5ProductosFault_Exception
    ;

}
