package aes.pica.touresbalon.touresbalonproductosws.entidades.productos;
// Generated 3/10/2016 09:54:15 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * TarifaHospedaje generated by hbm2java
 */
public class TarifaHospedaje  implements java.io.Serializable {


     private int idHospedaje;
     private String nombreHospedaje;
     private BigDecimal precio;
     private Set productos = new HashSet(0);

    public TarifaHospedaje() {
    }

	
    public TarifaHospedaje(int idHospedaje) {
        this.idHospedaje = idHospedaje;
    }
    public TarifaHospedaje(int idHospedaje, String nombreHospedaje, BigDecimal precio, Set productos) {
       this.idHospedaje = idHospedaje;
       this.nombreHospedaje = nombreHospedaje;
       this.precio = precio;
       this.productos = productos;
    }
   
    public int getIdHospedaje() {
        return this.idHospedaje;
    }
    
    public void setIdHospedaje(int idHospedaje) {
        this.idHospedaje = idHospedaje;
    }
    public String getNombreHospedaje() {
        return this.nombreHospedaje;
    }
    
    public void setNombreHospedaje(String nombreHospedaje) {
        this.nombreHospedaje = nombreHospedaje;
    }
    public BigDecimal getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    public Set getProductos() {
        return this.productos;
    }
    
    public void setProductos(Set productos) {
        this.productos = productos;
    }




}


