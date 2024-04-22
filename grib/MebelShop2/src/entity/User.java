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
import javax.persistence.OneToOne;

@Entity
public class User implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
    @OneToOne
    private Buyer buyer;

    public User(){
    }
    
    public String getLogin(){
        return login;
    }
    
    public void setLogin(String login){
        this.login = login;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public Buyer getBuyer(){
        return buyer;
    }
    
    public void setBuyer(Buyer buyer){
        this.buyer = buyer;
    }
    
    
}
