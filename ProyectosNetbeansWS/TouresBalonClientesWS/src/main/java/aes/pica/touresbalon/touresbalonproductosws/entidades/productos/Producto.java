package aes.pica.touresbalon.touresbalonproductosws.entidades.productos;
// Generated 24/09/2016 07:45:59 PM by Hibernate Tools 4.3.1


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
     private String nombreProducto;
     private Date fechaSalida;
     private Date fechaLlegada;
     private Date fechaEspectaculo;
     private String urlImagen;

    public Producto() {
    }

	
    public Producto(int idProducto) {
        this.idProducto = idProducto;
    }
    public Producto(int idProducto, Ciudad ciudad, TarifaEspectaculo tarifaEspectaculo, TarifaHospedaje tarifaHospedaje, TarifaTransporte tarifaTransporte, String nombreProducto, Date fechaSalida, Date fechaLlegada, Date fechaEspectaculo, String urlImagen) {
       this.idProducto = idProducto;
       this.ciudad = ciudad;
       this.tarifaEspectaculo = tarifaEspectaculo;
       this.tarifaHospedaje = tarifaHospedaje;
       this.tarifaTransporte = tarifaTransporte;
       this.nombreProducto = nombreProducto;
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
    public String getNombreProducto() {
        return this.nombreProducto;
    }
    
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
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

