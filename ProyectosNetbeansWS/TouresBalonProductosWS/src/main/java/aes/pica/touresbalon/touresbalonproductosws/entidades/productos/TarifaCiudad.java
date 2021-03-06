package aes.pica.touresbalon.touresbalonproductosws.entidades.productos;
// Generated Oct 16, 2016 3:40:40 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * TarifaCiudad generated by hbm2java
 */
public class TarifaCiudad  implements java.io.Serializable {


     private int idTarifaCiudad;
     private String tipoCiudad;
     private double precio;
     private Set ciudads = new HashSet(0);

    public TarifaCiudad() {
    }

	
    public TarifaCiudad(int idTarifaCiudad) {
        this.idTarifaCiudad = idTarifaCiudad;
    }
    public TarifaCiudad(int idTarifaCiudad, String tipoCiudad, double precio, Set ciudads) {
       this.idTarifaCiudad = idTarifaCiudad;
       this.tipoCiudad = tipoCiudad;
       this.precio = precio;
       this.ciudads = ciudads;
    }
   
    public int getIdTarifaCiudad() {
        return this.idTarifaCiudad;
    }
    
    public void setIdTarifaCiudad(int idTarifaCiudad) {
        this.idTarifaCiudad = idTarifaCiudad;
    }
    public String getTipoCiudad() {
        return this.tipoCiudad;
    }
    
    public void setTipoCiudad(String tipoCiudad) {
        this.tipoCiudad = tipoCiudad;
    }
    public double getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public Set getCiudads() {
        return this.ciudads;
    }
    
    public void setCiudads(Set ciudads) {
        this.ciudads = ciudads;
    }




}


