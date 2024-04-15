/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="sofas")
public class Sofa implements Serializable {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    private String sofaName;
    private int year; 
    private double price;
    private int quantity;
    private double orderRating;
    
    public Sofa(){
        
    }
    
    public Sofa(Long id, String sofaName, int year, double price, int quantity, double orderRating){
        this.id = id;
        this.sofaName = sofaName;
        this.year = year;
        this.price = price;
        this.quantity = quantity;
        this.orderRating = orderRating;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSofaName(String SofaName) {
        this.sofaName = sofaName;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public String getSofaName() {
        return sofaName;
    }
   
    public Integer getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getOrderRating() {
        return orderRating;
    }

    public void setOrderRating(double orderRating) {
        this.orderRating = orderRating;
    }

    @Override
    public String toString() {
        return "Sofa{" + "id=" + id + ", sofaName=" + sofaName + ", year=" + year + ", price=" + price + ", quantity=" + quantity + ", orderRating=" + orderRating + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.id);
        hash = 73 * hash + Objects.hashCode(this.sofaName);
        hash = 73 * hash + this.year;
        hash = 73 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        hash = 73 * hash + this.quantity;
        hash = 73 * hash + (int) (Double.doubleToLongBits(this.orderRating) ^ (Double.doubleToLongBits(this.orderRating) >>> 32));
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
        final Sofa other = (Sofa) obj;
        if (this.year != other.year) {
            return false;
        }
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        if (this.quantity != other.quantity) {
            return false;
        }
        if (Double.doubleToLongBits(this.orderRating) != Double.doubleToLongBits(other.orderRating)) {
            return false;
        }
        if (!Objects.equals(this.sofaName, other.sofaName)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
