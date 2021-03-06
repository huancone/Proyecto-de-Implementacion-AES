package aes.pica.touresbalon.reservas.entidades.dann;
// Generated 19-oct-2016 1:21:42 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Hotel generated by hbm2java
 */
public class Hotel  implements java.io.Serializable {


     private int hotelId;
     private String name;
     private String address;
     private String city;
     private String country;
     private Set rooms = new HashSet(0);

    public Hotel() {
    }

	
    public Hotel(int hotelId) {
        this.hotelId = hotelId;
    }
    public Hotel(int hotelId, String name, String address, String city, String country, Set rooms) {
       this.hotelId = hotelId;
       this.name = name;
       this.address = address;
       this.city = city;
       this.country = country;
       this.rooms = rooms;
    }
   
    public int getHotelId() {
        return this.hotelId;
    }
    
    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    public String getCountry() {
        return this.country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    public Set getRooms() {
        return this.rooms;
    }
    
    public void setRooms(Set rooms) {
        this.rooms = rooms;
    }




}


