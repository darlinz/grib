/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Sofa;
import entity.Buyer;
import entity.Order;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SaveManager {
    private final String SOFA_FILENAME = "sofas";
    private final String BUYER_FILENAME = "buyers";
    private final String ORDER_FILENAME = "orders";

    public List<Sofa> loadSofas() {
        List<Sofa> sofas = new ArrayList<>();
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream(SOFA_FILENAME);
            ois = new ObjectInputStream(fis);
            sofas = (List<Sofa>) ois.readObject();
        } catch (FileNotFoundException ex) {
            System.out.printf("File \"%s\" not found!%n", SOFA_FILENAME);
        } catch (IOException ex) {
            System.out.println("Error I/O!");
        } catch (ClassNotFoundException ex) {
            System.out.printf("Class \"%s\" not found!%n", SOFA_FILENAME);
        }
        return sofas;
    }

    public void saveSofas(List<Sofa> sofas) {
        ObjectOutputStream oos;
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(SOFA_FILENAME);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(sofas);
            oos.flush();
        } catch (FileNotFoundException ex) {
            System.out.printf("File \"%s\" not found!%n", SOFA_FILENAME);
        } catch (IOException ex) {
            System.out.println("Error I/O!");
        }
    }

    public List<Buyer> loadBuyers() {
        List<Buyer> buyers = new ArrayList<>();
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream(BUYER_FILENAME);
            ois = new ObjectInputStream(fis);
            buyers = (List<Buyer>) ois.readObject();
        } catch (FileNotFoundException ex) {
            System.out.printf("File \"%s\" not found!%n", BUYER_FILENAME);
        } catch (IOException ex) {
            System.out.println("Error I/O!");
        } catch (ClassNotFoundException ex) {
            System.out.printf("Class \"%s\" not found!%n", BUYER_FILENAME);
        }
        return buyers;
    }

    public void saveBuyer(List<Buyer> buyers) {
        ObjectOutputStream oos;
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(BUYER_FILENAME);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(buyers);
            oos.flush();
        } catch (FileNotFoundException ex) {
            System.out.printf("File \"%s\" not found!%n", BUYER_FILENAME);
        } catch (IOException ex) {
            System.out.println("Error I/O!");
        }
    }
    
       public List<Order> loadOrders() {
        List<Order> order = new ArrayList<>();
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream(ORDER_FILENAME);
            ois = new ObjectInputStream(fis);
            order = (List<Order>) ois.readObject();
        } catch (FileNotFoundException ex) {
            System.out.printf("File \"%s\" not found!%n", ORDER_FILENAME);
        } catch (IOException ex) {
            System.out.println("Error I/O!");
        } catch (ClassNotFoundException ex) {
            System.out.printf("Class \"%s\" not found!%n", ORDER_FILENAME);
        }
        return order;
    }

    public void saveSales(List<Order> orders) {
        ObjectOutputStream oos;
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(ORDER_FILENAME);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(orders);
            oos.flush();
        } catch (FileNotFoundException ex) {
            System.out.printf("File \"%s\" not found!%n", ORDER_FILENAME);
        } catch (IOException ex) {
            System.out.println("Error I/O!");
        }
    }
}
