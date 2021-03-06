package aes.pica.touresbalon.reservas.entidades.productos;
// Generated 18-oct-2016 11:13:46 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * TarifaEspectaculo generated by hbm2java
 */
public class TarifaEspectaculo  implements java.io.Serializable {


     private int idEspectaculo;
     private String nombreEspectaculo;
     private BigDecimal precio;
     private Set productos = new HashSet(0);

    public TarifaEspectaculo() {
    }

	
    public TarifaEspectaculo(int idEspectaculo) {
        this.idEspectaculo = idEspectaculo;
    }
    public TarifaEspectaculo(int idEspectaculo, String nombreEspectaculo, BigDecimal precio, Set productos) {
       this.idEspectaculo = idEspectaculo;
       this.nombreEspectaculo = nombreEspectaculo;
       this.precio = precio;
       this.productos = productos;
    }
   
    public int getIdEspectaculo() {
        return this.idEspectaculo;
    }
    
    public void setIdEspectaculo(int idEspectaculo) {
        this.idEspectaculo = idEspectaculo;
    }
    public String getNombreEspectaculo() {
        return this.nombreEspectaculo;
    }
    
    public void setNombreEspectaculo(String nombreEspectaculo) {
        this.nombreEspectaculo = nombreEspectaculo;
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


