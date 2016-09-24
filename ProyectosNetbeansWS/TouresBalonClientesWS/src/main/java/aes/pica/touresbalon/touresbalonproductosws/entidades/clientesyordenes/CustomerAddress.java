package aes.pica.touresbalon.touresbalonproductosws.entidades.clientesyordenes;
// Generated 24/09/2016 12:25:36 PM by Hibernate Tools 4.3.1



/**
 * CustomerAddress generated by hbm2java
 */
public class CustomerAddress  implements java.io.Serializable {


     private CustomerAddressId id;
     private Address address;
     private Customer customer;

    public CustomerAddress() {
    }

    public CustomerAddress(CustomerAddressId id, Address address, Customer customer) {
       this.id = id;
       this.address = address;
       this.customer = customer;
    }
   
    public CustomerAddressId getId() {
        return this.id;
    }
    
    public void setId(CustomerAddressId id) {
        this.id = id;
    }
    public Address getAddress() {
        return this.address;
    }
    
    public void setAddress(Address address) {
        this.address = address;
    }
    public Customer getCustomer() {
        return this.customer;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }




}


