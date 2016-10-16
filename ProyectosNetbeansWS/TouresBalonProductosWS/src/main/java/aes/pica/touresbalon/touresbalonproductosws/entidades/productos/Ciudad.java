package aes.pica.touresbalon.touresbalonproductosws.entidades.productos;
// Generated Oct 16, 2016 3:40:40 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Ciudad generated by hbm2java
 */
public class Ciudad  implements java.io.Serializable {


     private int idCiudad;
     private TarifaCiudad tarifaCiudad;
     private String nombreCiudad;
     private String pais;
     private Set productos = new HashSet(0);

    public Ciudad() {
    }

	
    public Ciudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }
    public Ciudad(int idCiudad, TarifaCiudad tarifaCiudad, String nombreCiudad, String pais, Set productos) {
       this.idCiudad = idCiudad;
       this.tarifaCiudad = tarifaCiudad;
       this.nombreCiudad = nombreCiudad;
       this.pais = pais;
       this.productos = productos;
    }
   
    public int getIdCiudad() {
        return this.idCiudad;
    }
    
    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }
    public TarifaCiudad getTarifaCiudad() {
        return this.tarifaCiudad;
    }
    
    public void setTarifaCiudad(TarifaCiudad tarifaCiudad) {
        this.tarifaCiudad = tarifaCiudad;
    }
    public String getNombreCiudad() {
        return this.nombreCiudad;
    }
    
    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }
    public String getPais() {
        return this.pais;
    }
    
    public void setPais(String pais) {
        this.pais = pais;
    }
    public Set getProductos() {
        return this.productos;
    }
    
    public void setProductos(Set productos) {
        this.productos = productos;
    }




}


