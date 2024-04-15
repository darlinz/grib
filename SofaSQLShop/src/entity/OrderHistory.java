/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name="orderHistory")
public class OrderHistory implements Serializable{
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Sofa sofa;
    private Buyer buyer;
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    
    public OrderHistory(){   
    }
    
    public OrderHistory(Long id, Sofa sofa, Buyer buyer, Date orderDate){
        this.id = id;
        this.sofa = sofa;
        this.buyer = buyer;
        this.orderDate = orderDate;
    }

    public Long getId() {
        return id;
    }

    public Sofa getSofa() {
        return sofa;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSofa(Sofa sofa) {
        this.sofa = sofa;
    }

    public void setClient(Buyer buyer) {
        this.buyer = buyer;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "OrderHistory{" + "id=" + id + ", sofa=" + sofa + ", buyer=" + buyer + ", orderDate=" + orderDate + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.sofa);
        hash = 53 * hash + Objects.hashCode(this.buyer);
        hash = 53 * hash + Objects.hashCode(this.orderDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OrderHistory other = (OrderHistory) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.sofa, other.sofa)) {
            return false;
        }
        if (!Objects.equals(this.buyer, other.buyer)) {
            return false;
        }
        if (!Objects.equals(this.orderDate, other.orderDate)) {
            return false;
        }
        return true;
    }


}
