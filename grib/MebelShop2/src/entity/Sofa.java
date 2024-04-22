/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Sofa implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int publishedYear;
    @ElementCollection()
    @OneToMany(orphanRemoval = true)
    private int quantity;
    private int count;

    public Sofa(){
    
    }
    
    public String getTitle(){
        return title;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    
    public int getPublishedYear(){
        return publishedYear;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.title);
        hash = 59 * hash + this.publishedYear;
        hash = 59 * hash + this.quantity;
        hash = 59 * hash + this.count;
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
        if (this.publishedYear != other.publishedYear) {
            return false;
        }
        if (this.quantity != other.quantity) {
            return false;
        }
        if (this.count != other.count) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Sofa{" + "id=" + id + ", title=" + title + ", publishedYear=" + publishedYear + ", quantity=" + quantity + ", count=" + count + '}';
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    
    public int getCount(){
        return count;
    }
    
    public void setCount(int count){
        this.count = count;
    }
    
    public Long getId(){
        return id;
    }
    
    public void setId(Long id){
        this.id = id;
    }
}
