package aes.pica.touresbalon.touresbalonproductosws.entidades.productos;
// Generated Oct 16, 2016 3:40:40 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Campanias generated by hbm2java
 */
public class Campanias  implements java.io.Serializable {


     private int idCampania;
     private Producto producto;
     private Date fechaInicio;
     private Date fechaFin;

    public Campanias() {
    }

    public Campanias(int idCampania, Producto producto, Date fechaInicio, Date fechaFin) {
       this.idCampania = idCampania;
       this.producto = producto;
       this.fechaInicio = fechaInicio;
       this.fechaFin = fechaFin;
    }
   
    public int getIdCampania() {
        return this.idCampania;
    }
    
    public void setIdCampania(int idCampania) {
        this.idCampania = idCampania;
    }
    public Producto getProducto() {
        return this.producto;
    }
    
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    public Date getFechaInicio() {
        return this.fechaInicio;
    }
    
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public Date getFechaFin() {
        return this.fechaFin;
    }
    
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }




}


