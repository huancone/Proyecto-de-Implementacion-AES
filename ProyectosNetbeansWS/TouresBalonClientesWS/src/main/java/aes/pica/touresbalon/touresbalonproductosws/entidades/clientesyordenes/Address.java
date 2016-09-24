package aes.pica.touresbalon.touresbalonproductosws.entidades.clientesyordenes;
// Generated 24/09/2016 12:25:36 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Address generated by hbm2java
 */
public class Address  implements java.io.Serializable {


     private int addrid;
     private String street;
     private String state;
     private String zip;
     private String country;
     private String addressType;
     private String city;
     private Set customerAddresses = new HashSet(0);

    public Address() {
    }

	
    public Address(int addrid) {
        this.addrid = addrid;
    }
    public Address(int addrid, String street, String state, String zip, String country, String addressType, String city, Set customerAddresses) {
       this.addrid = addrid;
       this.street = street;
       this.state = state;
       this.zip = zip;
       this.country = country;
       this.addressType = addressType;
       this.city = city;
       this.customerAddresses = customerAddresses;
    }
   
    public int getAddrid() {
        return this.addrid;
    }
    
    public void setAddrid(int addrid) {
        this.addrid = addrid;
    }
    public String getStreet() {
        return this.street;
    }
    
    public void setStreet(String street) {
        this.street = street;
    }
    public String getState() {
        return this.state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    public String getZip() {
        return this.zip;
    }
    
    public void setZip(String zip) {
        this.zip = zip;
    }
    public String getCountry() {
        return this.country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    public String getAddressType() {
        return this.addressType;
    }
    
    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    public Set getCustomerAddresses() {
        return this.customerAddresses;
    }
    
    public void setCustomerAddresses(Set customerAddresses) {
        this.customerAddresses = customerAddresses;
    }




}


