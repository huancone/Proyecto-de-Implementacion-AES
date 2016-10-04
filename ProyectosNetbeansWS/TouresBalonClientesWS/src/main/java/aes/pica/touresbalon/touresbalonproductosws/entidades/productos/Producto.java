package aes.pica.touresbalon.touresbalonproductosws.entidades.productos;
// Generated 3/10/2016 09:54:15 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Producto generated by hbm2java
 */
public class Producto  implements java.io.Serializable {


     private int idProducto;
     private Ciudad ciudad;
     private TarifaEspectaculo tarifaEspectaculo;
     private TarifaHospedaje tarifaHospedaje;
     private TarifaTransporte tarifaTransporte;
     private String espectaculo;
     private String descripcion;
     private Date fechaSalida;
     private Date fechaLlegada;
     private Date fechaEspectaculo;
     private String urlImagen;

    public Producto() {
    }

	
    public Producto(int idProducto) {
        this.idProducto = idProducto;
    }
    public Producto(int idProducto, Ciudad ciudad, TarifaEspectaculo tarifaEspectaculo, TarifaHospedaje tarifaHospedaje, TarifaTransporte tarifaTransporte, String espectaculo, String descripcion, Date fechaSalida, Date fechaLlegada, Date fechaEspectaculo, String urlImagen) {
       this.idProducto = idProducto;
       this.ciudad = ciudad;
       this.tarifaEspectaculo = tarifaEspectaculo;
       this.tarifaHospedaje = tarifaHospedaje;
       this.tarifaTransporte = tarifaTransporte;
       this.espectaculo = espectaculo;
       this.descripcion = descripcion;
       this.fechaSalida = fechaSalida;
       this.fechaLlegada = fechaLlegada;
       this.fechaEspectaculo = fechaEspectaculo;
       this.urlImagen = urlImagen;
    }
   
    public int getIdProducto() {
        return this.idProducto;
    }
    
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    public Ciudad getCiudad() {
        return this.ciudad;
    }
    
    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
    public TarifaEspectaculo getTarifaEspectaculo() {
        return this.tarifaEspectaculo;
    }
    
    public void setTarifaEspectaculo(TarifaEspectaculo tarifaEspectaculo) {
        this.tarifaEspectaculo = tarifaEspectaculo;
    }
    public TarifaHospedaje getTarifaHospedaje() {
        return this.tarifaHospedaje;
    }
    
    public void setTarifaHospedaje(TarifaHospedaje tarifaHospedaje) {
        this.tarifaHospedaje = tarifaHospedaje;
    }
    public TarifaTransporte getTarifaTransporte() {
        return this.tarifaTransporte;
    }
    
    public void setTarifaTransporte(TarifaTransporte tarifaTransporte) {
        this.tarifaTransporte = tarifaTransporte;
    }
    public String getEspectaculo() {
        return this.espectaculo;
    }
    
    public void setEspectaculo(String espectaculo) {
        this.espectaculo = espectaculo;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Date getFechaSalida() {
        return this.fechaSalida;
    }
    
    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    public Date getFechaLlegada() {
        return this.fechaLlegada;
    }
    
    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }
    public Date getFechaEspectaculo() {
        return this.fechaEspectaculo;
    }
    
    public void setFechaEspectaculo(Date fechaEspectaculo) {
        this.fechaEspectaculo = fechaEspectaculo;
    }
    public String getUrlImagen() {
        return this.urlImagen;
    }
    
    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }




}


