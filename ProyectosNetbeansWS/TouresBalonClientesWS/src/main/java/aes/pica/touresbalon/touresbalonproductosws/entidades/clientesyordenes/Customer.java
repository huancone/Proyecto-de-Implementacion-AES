package aes.pica.touresbalon.touresbalonproductosws.entidades.clientesyordenes;
// Generated 3/10/2016 09:51:13 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Customer generated by hbm2java
 */
public class Customer  implements java.io.Serializable {


     private int custid;
     private String fname;
     private String lname;
     private String phonenumber;
     private String email;
     private String password;
     private String creditcardtype;
     private String creditcardnumber;
     private String status;
     private Set customerAddresses = new HashSet(0);
     private Set orderses = new HashSet(0);

    public Customer() {
    }

	
    public Customer(int custid) {
        this.custid = custid;
    }
    public Customer(int custid, String fname, String lname, String phonenumber, String email, String password, String creditcardtype, String creditcardnumber, String status, Set customerAddresses, Set orderses) {
       this.custid = custid;
       this.fname = fname;
       this.lname = lname;
       this.phonenumber = phonenumber;
       this.email = email;
       this.password = password;
       this.creditcardtype = creditcardtype;
       this.creditcardnumber = creditcardnumber;
       this.status = status;
       this.customerAddresses = customerAddresses;
       this.orderses = orderses;
    }
   
    public int getCustid() {
        return this.custid;
    }
    
    public void setCustid(int custid) {
        this.custid = custid;
    }
    public String getFname() {
        return this.fname;
    }
    
    public void setFname(String fname) {
        this.fname = fname;
    }
    public String getLname() {
        return this.lname;
    }
    
    public void setLname(String lname) {
        this.lname = lname;
    }
    public String getPhonenumber() {
        return this.phonenumber;
    }
    
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getCreditcardtype() {
        return this.creditcardtype;
    }
    
    public void setCreditcardtype(String creditcardtype) {
        this.creditcardtype = creditcardtype;
    }
    public String getCreditcardnumber() {
        return this.creditcardnumber;
    }
    
    public void setCreditcardnumber(String creditcardnumber) {
        this.creditcardnumber = creditcardnumber;
    }
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    public Set getCustomerAddresses() {
        return this.customerAddresses;
    }
    
    public void setCustomerAddresses(Set customerAddresses) {
        this.customerAddresses = customerAddresses;
    }
    public Set getOrderses() {
        return this.orderses;
    }
    
    public void setOrderses(Set orderses) {
        this.orderses = orderses;
    }




}


