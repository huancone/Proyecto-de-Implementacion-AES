package aes.pica.touresbalon.touresbalonproductosws.entidades.productos;
// Generated Oct 16, 2016 3:40:40 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * TarifaTransporte generated by hbm2java
 */
public class TarifaTransporte  implements java.io.Serializable {


     private int idTransporte;
     private String nombreTransporte;
     private double precio;
     private Set productos = new HashSet(0);

    public TarifaTransporte() {
    }

	
    public TarifaTransporte(int idTransporte) {
        this.idTransporte = idTransporte;
    }
    public TarifaTransporte(int idTransporte, String nombreTransporte, double precio, Set productos) {
       this.idTransporte = idTransporte;
       this.nombreTransporte = nombreTransporte;
       this.precio = precio;
       this.productos = productos;
    }
   
    public int getIdTransporte() {
        return this.idTransporte;
    }
    
    public void setIdTransporte(int idTransporte) {
        this.idTransporte = idTransporte;
    }
    public String getNombreTransporte() {
        return this.nombreTransporte;
    }
    
    public void setNombreTransporte(String nombreTransporte) {
        this.nombreTransporte = nombreTransporte;
    }
    public double getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public Set getProductos() {
        return this.productos;
    }
    
    public void setProductos(Set productos) {
        this.productos = productos;
    }




}


