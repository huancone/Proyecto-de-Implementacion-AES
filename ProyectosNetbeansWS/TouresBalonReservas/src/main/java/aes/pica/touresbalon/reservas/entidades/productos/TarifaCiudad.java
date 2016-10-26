package aes.pica.touresbalon.reservas.entidades.productos;
// Generated 18-oct-2016 11:13:46 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * TarifaCiudad generated by hbm2java
 */
public class TarifaCiudad  implements java.io.Serializable {


     private int idTarifaCiudad;
     private String tipoCiudad;
     private BigDecimal precio;
     private Set ciudads = new HashSet(0);

    public TarifaCiudad() {
    }

	
    public TarifaCiudad(int idTarifaCiudad) {
        this.idTarifaCiudad = idTarifaCiudad;
    }
    public TarifaCiudad(int idTarifaCiudad, String tipoCiudad, BigDecimal precio, Set ciudads) {
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
    public BigDecimal getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    public Set getCiudads() {
        return this.ciudads;
    }
    
    public void setCiudads(Set ciudads) {
        this.ciudads = ciudads;
    }




}

