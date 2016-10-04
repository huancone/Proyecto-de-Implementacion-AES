package aes.pica.touresbalon.touresbalonproductosws.entidades.clientesyordenes;
// Generated 3/10/2016 10:58:46 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Orders generated by hbm2java
 */
public class Orders  implements java.io.Serializable {


     private int ordid;
     private Customer customer;
     private Date orderdate;
     private BigDecimal price;
     private String status;
     private String comments;
     private Set itemses = new HashSet(0);

    public Orders() {
    }

	
    public Orders(int ordid, Customer customer) {
        this.ordid = ordid;
        this.customer = customer;
    }
    public Orders(int ordid, Customer customer, Date orderdate, BigDecimal price, String status, String comments, Set itemses) {
       this.ordid = ordid;
       this.customer = customer;
       this.orderdate = orderdate;
       this.price = price;
       this.status = status;
       this.comments = comments;
       this.itemses = itemses;
    }
   
    public int getOrdid() {
        return this.ordid;
    }
    
    public void setOrdid(int ordid) {
        this.ordid = ordid;
    }
    public Customer getCustomer() {
        return this.customer;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public Date getOrderdate() {
        return this.orderdate;
    }
    
    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }
    public BigDecimal getPrice() {
        return this.price;
    }
    
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    public String getComments() {
        return this.comments;
    }
    
    public void setComments(String comments) {
        this.comments = comments;
    }
    public Set getItemses() {
        return this.itemses;
    }
    
    public void setItemses(Set itemses) {
        this.itemses = itemses;
    }




}


