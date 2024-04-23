/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.History;
import entity.Sofa;
import entity.User;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class SaveManager {
    private final String SOFA_FILENAME = "sofas";
    private final String BUYER_FILENAME = "users";
    private final String HISTORIES_FILENAME = "histories";

    public List<Sofa> loadSofas() {
        List<Sofa> sofas = new ArrayList<>();
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream(SOFA_FILENAME);
            ois = new ObjectInputStream(fis);
            sofas = (List<Sofa>) ois.readObject();
        } catch (FileNotFoundException ex) {
            System.out.printf("File \"%s\" not found!%n",SOFA_FILENAME);
        } catch (IOException ex) {
            System.out.println("Error I/O!");
        } catch (ClassNotFoundException ex) {
            System.out.printf("Class \"%s\" not found!%n",SOFA_FILENAME);
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
           System.out.printf("File \"%s\" not found!%n",SOFA_FILENAME);
        } catch (IOException ex) {
            System.out.println("Error I/O!");
        }
    }
    public List<User> loadUsers() {
        List<User> users = new ArrayList<>();
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream(BUYER_FILENAME);
            ois = new ObjectInputStream(fis);
            users = (List<User>) ois.readObject();
        } catch (FileNotFoundException ex) {
            System.out.printf("File \"%s\" not found!%n",BUYER_FILENAME);
        } catch (IOException ex) {
            System.out.println("Error I/O!");
        } catch (ClassNotFoundException ex) {
            System.out.printf("Class \"%s\" not found!%n",BUYER_FILENAME);
        }
        return users;
    }

    public void saveReaders(List<User> users) {
        ObjectOutputStream oos;
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(BUYER_FILENAME);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(users);
            oos.flush();
        } catch (FileNotFoundException ex) {
           System.out.printf("File \"%s\" not found!%n",BUYER_FILENAME);
        } catch (IOException ex) {
            System.out.println("Error I/O!");
        }
    }
    public List<History> loadHistories() {
        List<History> histories = new ArrayList<>();
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream(HISTORIES_FILENAME);
            ois = new ObjectInputStream(fis);
            histories = (List<History>) ois.readObject();
        } catch (FileNotFoundException ex) {
            System.out.printf("File \"%s\" not found!%n",HISTORIES_FILENAME);
        } catch (IOException ex) {
            System.out.println("Error I/O!");
        } catch (ClassNotFoundException ex) {
            System.out.printf("Class \"%s\" not found!%n",HISTORIES_FILENAME);
        }
        return histories;
    }

    public void saveHistories(List<History> histories) {
        ObjectOutputStream oos;
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(HISTORIES_FILENAME);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(histories);
            oos.flush();
        } catch (FileNotFoundException ex) {
           System.out.printf("File \"%s\" not found!%n",HISTORIES_FILENAME);
        } catch (IOException ex) {
            System.out.println("Error I/O!");
        }
    }

    
    
}