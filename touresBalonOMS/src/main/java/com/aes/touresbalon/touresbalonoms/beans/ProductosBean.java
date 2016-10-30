/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aes.touresbalon.touresbalonoms.beans;

import com.aes.touresbalon.touresbalonoms.services.ProductoService;
import com.aes.touresbalon.touresbalonoms.wsdl.client.Ciudad;
import com.aes.touresbalon.touresbalonoms.wsdl.client.Producto;
import com.aes.touresbalon.touresbalonoms.wsdl.client.TarifaValores;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.TabCloseEvent;
import com.aes.touresbalon.touresbalonoms.utilities.OmsUtil;
import java.text.ParseException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author deirovir
 */
@ManagedBean(name = "productosBean")
@RequestScoped
public class ProductosBean {

    /**
     * Creates a new instance of ProductosBean
     */
    public ProductosBean() {
    }
     
    private int idProducto;
    private String espectaculo;
    private String descripcion;
    private Ciudad ciudadEspectaculo;
    private String fechaLlegada;
    private String fechaSalida;
    private String fechaEspectaculo;
    private TarifaValores tipoTransporte;
    private TarifaValores tipoEspectaculo;
    private TarifaValores tipoHospedaje;
    private String imagenProducto;
    
    private String tipoConsulta;
    private String txtConsulta;
    private boolean showPanelEdit;
    
    ProductoService service = new ProductoService();
    
    public void onTabChange(TabChangeEvent event) {
        FacesMessage msg = new FacesMessage("Tab Changed", "Active Tab: " + event.getTab().getTitle());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
         
    public void onTabClose(TabCloseEvent event) {
        FacesMessage msg = new FacesMessage("Tab Closed", "Closed tab: " + event.getTab().getTitle());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void crearProducto() throws ParseException, DatatypeConfigurationException{
        XMLGregorianCalendar fechaLlegadaServ = OmsUtil.stringToXMLGreogrianCalendar(this.fechaLlegada);
        XMLGregorianCalendar fechaSalidaServ = OmsUtil.stringToXMLGreogrianCalendar(this.fechaSalida);
        XMLGregorianCalendar fechaEspectaculoServ = OmsUtil.stringToXMLGreogrianCalendar(this.fechaEspectaculo);
        Ciudad cb = new Ciudad();
        Producto producto = new Producto();
        producto.setIdProducto(idProducto);
        producto.setEspectaculo(espectaculo);
        producto.setDescripcion(descripcion);
        producto.setFechaLlegada(fechaLlegadaServ);
        producto.setFechaSalida(fechaSalidaServ);
        producto.setFechaEspectaculo(fechaEspectaculoServ);
        producto.setCiudadEspectaculo(ciudadEspectaculo);
        producto.setCiudadEspectaculo(cb);
        service.crearProducto(producto);
     }
     
    public void editarProducto(){
        if (!isShowPanelEdit()){
            setShowPanelEdit(true);
        }else{
            setShowPanelEdit(false);
        }
    }
    
    public void eliminarProducto(){
        service.eliminarProducto();
    }
    
    public void consultarProducto(){
        showPanelEdit = true;
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

    public String getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(String fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getFechaEspectaculo() {
        return fechaEspectaculo;
    }

    public void setFechaEspectaculo(String fechaEspectaculo) {
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
     * @return the showPanelEdit
     */
    public boolean isShowPanelEdit() {
        return showPanelEdit;
    }

    /**
     * @param showPanelEdit the showPanelEdit to set
     */
    public void setShowPanelEdit(boolean showPanelEdit) {
        this.showPanelEdit = showPanelEdit;
    }
    
}
