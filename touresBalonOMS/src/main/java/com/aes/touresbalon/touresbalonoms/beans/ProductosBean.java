/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aes.touresbalon.touresbalonoms.beans;

import com.aes.touresbalon.touresbalonoms.services.Services;
import com.aes.touresbalon.touresbalonoms.utilities.OmsUtil;
import com.aes.touresbalon.touresbalonoms.wsdl.client.Ciudad;
import com.aes.touresbalon.touresbalonoms.wsdl.client.Producto;
import com.aes.touresbalon.touresbalonoms.wsdl.client.TarifaValores;
import com.aes.touresbalon.touresbalonoms.wsdl.client.TipoAccion;
import com.aes.touresbalon.touresbalonoms.wsdl.client.TipoConsultaProducto;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.TabCloseEvent;

/**
 *
 * @author deirovir
 */
@ManagedBean(name = "productosBean")
@ViewScoped
public class ProductosBean {

    private int idProducto;
    private String espectaculo;
    private String descripcion;
    private Ciudad ciudadEspectaculo;
    private Date fechaLlegada;
    private Date fechaSalida;
    private Date fechaEspectaculo;
    private int idTiipoTransporte;
    private int idTipoEspectaculo;
    private int idTipoHispedaje;
    private TarifaValores tipoTransporte;
    private TarifaValores tipoEspectaculo;
    private TarifaValores tipoHospedaje;
    private Integer idCiudad;
    private String pais;
    private TarifaValoresBean tipoCiudad;
    private String imagenProducto;

    private String tipoConsulta;
    private String txtConsulta;

    private Producto producto;
    private List<Producto> productosList;

    private TipoAccion tipoAccion;

    Services service = new Services();
    
    /**
     * Creates a new instance of ProductosBean
     */
    public ProductosBean() {
    }
    
    @PostConstruct
    public void init(){
        this.tipoConsulta = "id";
    }
    
    public void onTabChange(TabChangeEvent event) {
        FacesMessage msg = new FacesMessage("Tab Changed", "Active Tab: " + event.getTab().getTitle());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onTabClose(TabCloseEvent event) {
        FacesMessage msg = new FacesMessage("Tab Closed", "Closed tab: " + event.getTab().getTitle());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void crearProducto() throws ParseException, DatatypeConfigurationException {
        XMLGregorianCalendar fechaLlegadaServ = OmsUtil.stringToXMLGreogrianCalendar(this.getFechaLlegada());
        XMLGregorianCalendar fechaSalidaServ = OmsUtil.stringToXMLGreogrianCalendar(this.getFechaSalida());
        XMLGregorianCalendar fechaEspectaculoServ = OmsUtil.stringToXMLGreogrianCalendar(this.getFechaEspectaculo());
        Ciudad cb = new Ciudad();
        TarifaValores tipoTransporte = new TarifaValores();
        TarifaValores tipoEspectaculo = new TarifaValores();;
        TarifaValores tipoHospedaje = new TarifaValores();;
        List<TarifaValores> tipoCiudadList = new ArrayList<>();
        producto = new Producto();
        producto.setIdProducto(this.getIdProducto());
        producto.setEspectaculo(this.getEspectaculo());
        producto.setDescripcion(this.getDescripcion());
        producto.setFechaLlegada(fechaLlegadaServ);
        producto.setFechaSalida(fechaSalidaServ);
        producto.setFechaEspectaculo(fechaEspectaculoServ);
        cb.setIdCiudad(this.getIdCiudad());
//        cb.setPais(this.getPais());
//        cb.getTipoCiudad();

        tipoTransporte.setId(this.getIdTiipoTransporte());
        tipoEspectaculo.setId(this.getIdTipoEspectaculo());
        tipoHospedaje.setId(this.getIdTipoHispedaje());
        producto.setCiudadEspectaculo(cb);
        producto.setTipoEspectaculo(tipoEspectaculo);
        producto.setTipoHospedaje(tipoHospedaje);
        producto.setTipoTransporte(tipoTransporte);
        this.setTipoAccion(TipoAccion.ADICIONAR);
        service.gestionProducto(producto, this.getTipoAccion());
    }

    public void editarProducto() throws ParseException, DatatypeConfigurationException {
        XMLGregorianCalendar fechaLlegadaServ = OmsUtil.stringToXMLGreogrianCalendar(this.getFechaLlegada());
        XMLGregorianCalendar fechaSalidaServ = OmsUtil.stringToXMLGreogrianCalendar(this.getFechaSalida());
        XMLGregorianCalendar fechaEspectaculoServ = OmsUtil.stringToXMLGreogrianCalendar(this.getFechaEspectaculo());
        Ciudad cb = new Ciudad();
        producto.setIdProducto(this.getIdProducto());
        producto.setEspectaculo(this.getEspectaculo());
        producto.setDescripcion(this.getDescripcion());
        producto.setFechaLlegada(fechaLlegadaServ);
        producto.setFechaSalida(fechaSalidaServ);
        producto.setFechaEspectaculo(fechaEspectaculoServ);
        cb.setIdCiudad(this.getIdCiudad());
        cb.setPais(this.getPais());
        cb.getTipoCiudad();
        producto.setCiudadEspectaculo(cb);
        producto.setTipoEspectaculo(this.tipoEspectaculo);
        producto.setTipoHospedaje(this.tipoHospedaje);
        producto.setTipoTransporte(this.tipoTransporte);
        this.setTipoAccion(TipoAccion.MODIFICAR);
        service.gestionProducto(producto, this.getTipoAccion());
    }

    public void eliminarProducto() throws ParseException, DatatypeConfigurationException {
        XMLGregorianCalendar fechaLlegadaServ = OmsUtil.stringToXMLGreogrianCalendar(this.getFechaLlegada());
        XMLGregorianCalendar fechaSalidaServ = OmsUtil.stringToXMLGreogrianCalendar(this.getFechaSalida());
        XMLGregorianCalendar fechaEspectaculoServ = OmsUtil.stringToXMLGreogrianCalendar(this.getFechaEspectaculo());
        Ciudad cb = new Ciudad();
//            org.apache.commons.beanutils.BeanUtils.copyProperties(producto, this);

        producto.setIdProducto(this.getIdProducto());
        producto.setEspectaculo(this.getEspectaculo());
        producto.setDescripcion(this.getDescripcion());
        producto.setFechaLlegada(fechaLlegadaServ);
        producto.setFechaSalida(fechaSalidaServ);
        producto.setFechaEspectaculo(fechaEspectaculoServ);
        cb.setIdCiudad(this.getIdCiudad());
        cb.setPais(this.getPais());
        cb.getTipoCiudad();
        producto.setCiudadEspectaculo(cb);
        producto.setTipoEspectaculo(this.tipoEspectaculo);
        producto.setTipoHospedaje(this.tipoHospedaje);
        producto.setTipoTransporte(this.tipoTransporte);
        this.setTipoAccion(TipoAccion.ELIMINAR);
        service.gestionProducto(producto, this.getTipoAccion());
    }

    public void consultarProducto() {
        List<Producto> productos = new ArrayList<>();
        if (this.getTipoConsulta().equalsIgnoreCase("id")) {
            productos = service.consultarProducto(TipoConsultaProducto.ID, this.getTxtConsulta());
        } else if (this.getTipoConsulta().equalsIgnoreCase("nombre")) {
            productos = service.consultarProducto(TipoConsultaProducto.NOMBRE, this.getTxtConsulta());
        } else if (this.getTipoConsulta().equalsIgnoreCase("descripcion")) {
            productos = service.consultarProducto(TipoConsultaProducto.DESCRIPCION, this.getTxtConsulta());
        }
        this.setProductosList(productos);
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getEspectaculo() {
        return espectaculo;
    }

    public void setEspectaculo(String espectaculo) {
        this.espectaculo = espectaculo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Ciudad getCiudadEspectaculo() {
        return ciudadEspectaculo;
    }

    public void setCiudadEspectaculo(Ciudad ciudadEspectaculo) {
        this.ciudadEspectaculo = ciudadEspectaculo;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Date getFechaEspectaculo() {
        return fechaEspectaculo;
    }

    public void setFechaEspectaculo(Date fechaEspectaculo) {
        this.fechaEspectaculo = fechaEspectaculo;
    }

    public TarifaValores getTipoTransporte() {
        return tipoTransporte;
    }

    public void setTipoTransporte(TarifaValores tipoTransporte) {
        this.tipoTransporte = tipoTransporte;
    }

    public TarifaValores getTipoEspectaculo() {
        return tipoEspectaculo;
    }

    public void setTipoEspectaculo(TarifaValores tipoEspectaculo) {
        this.tipoEspectaculo = tipoEspectaculo;
    }

    public TarifaValores getTipoHospedaje() {
        return tipoHospedaje;
    }

    public void setTipoHospedaje(TarifaValores tipoHospedaje) {
        this.tipoHospedaje = tipoHospedaje;
    }

    public String getImagenProducto() {
        return imagenProducto;
    }

    public void setImagenProducto(String imagenProducto) {
        this.imagenProducto = imagenProducto;
    }

    /**
     * @return the tipoConsulta
     */
    public String getTipoConsulta() {
        return tipoConsulta;
    }

    /**
     * @param tipoConsulta the tipoConsulta to set
     */
    public void setTipoConsulta(String tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    /**
     * @return the txtConsulta
     */
    public String getTxtConsulta() {
        return txtConsulta;
    }

    /**
     * @param txtConsulta the txtConsulta to set
     */
    public void setTxtConsulta(String txtConsulta) {
        this.txtConsulta = txtConsulta;
    }

    /**
     * @return the tipoAccion
     */
    public TipoAccion getTipoAccion() {
        return tipoAccion;
    }

    /**
     * @param tipoAccion the tipoAccion to set
     */
    public void setTipoAccion(TipoAccion tipoAccion) {
        this.tipoAccion = tipoAccion;
    }

    /**
     * @return the productosList
     */
    public List<Producto> getProductosList() {
        return productosList;
    }

    /**
     * @param productosList the productosList to set
     */
    public void setProductosList(List<Producto> productosList) {
        this.productosList = productosList;
    }

    /**
     * @return the producto
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /**
     * @return the idCiudad
     */
    public Integer getIdCiudad() {
        return idCiudad;
    }

    /**
     * @param idCiudad the idCiudad to set
     */
    public void setIdCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
    }

    /**
     * @return the pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * @return the tipoCiudad
     */
    public TarifaValoresBean getTipoCiudad() {
        return tipoCiudad;
    }

    /**
     * @param tipoCiudad the tipoCiudad to set
     */
    public void setTipoCiudad(TarifaValoresBean tipoCiudad) {
        this.tipoCiudad = tipoCiudad;
    }

    /**
     * @return the idTiipoTransporte
     */
    public int getIdTiipoTransporte() {
        return idTiipoTransporte;
    }

    /**
     * @param idTiipoTransporte the idTiipoTransporte to set
     */
    public void setIdTiipoTransporte(int idTiipoTransporte) {
        this.idTiipoTransporte = idTiipoTransporte;
    }

    /**
     * @return the idTipoEspectaculo
     */
    public int getIdTipoEspectaculo() {
        return idTipoEspectaculo;
    }

    /**
     * @param idTipoEspectaculo the idTipoEspectaculo to set
     */
    public void setIdTipoEspectaculo(int idTipoEspectaculo) {
        this.idTipoEspectaculo = idTipoEspectaculo;
    }

    /**
     * @return the idTipoHispedaje
     */
    public int getIdTipoHispedaje() {
        return idTipoHispedaje;
    }

    /**
     * @param idTipoHispedaje the idTipoHispedaje to set
     */
    public void setIdTipoHispedaje(int idTipoHispedaje) {
        this.idTipoHispedaje = idTipoHispedaje;
    }

}
