package aes.pica.touresbalon.touresbalonproductosws.entidades.clientesyordenes;
// Generated 24/09/2016 12:25:36 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * Items generated by hbm2java
 */
public class Items  implements java.io.Serializable {


     private int itemid;
     private Orders orders;
     private BigDecimal prodid;
     private String productname;
     private String partnum;
     private BigDecimal price;
     private BigDecimal quantity;

    public Items() {
    }

	
    public Items(int itemid, Orders orders) {
        this.itemid = itemid;
        this.orders = orders;
    }
    public Items(int itemid, Orders orders, BigDecimal prodid, String productname, String partnum, BigDecimal price, BigDecimal quantity) {
       this.itemid = itemid;
       this.orders = orders;
       this.prodid = prodid;
       this.productname = productname;
       this.partnum = partnum;
       this.price = price;
       this.quantity = quantity;
    }
   
    public int getItemid() {
        return this.itemid;
    }
    
    public void setItemid(int itemid) {
        this.itemid = itemid;
    }
    public Orders getOrders() {
        return this.orders;
    }
    
    public void setOrders(Orders orders) {
        this.orders = orders;
    }
    public BigDecimal getProdid() {
        return this.prodid;
    }
    
    public void setProdid(BigDecimal prodid) {
        this.prodid = prodid;
    }
    public String getProductname() {
        return this.productname;
    }
    
    public void setProductname(String productname) {
        this.productname = productname;
    }
    public String getPartnum() {
        return this.partnum;
    }
    
    public void setPartnum(String partnum) {
        this.partnum = partnum;
    }
    public BigDecimal getPrice() {
        return this.price;
    }
    
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public BigDecimal getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }




}


