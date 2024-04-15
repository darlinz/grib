/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Sofa;
import entity.Order;

import java.util.List;
import java.util.Scanner;
import tools.InputProtection;

/**
 *
 * @author admin
 */
public class SofaManager {
    private final Scanner scanner;
    private final DatabaseManager databaseManager;
    
    public SofaManager(Scanner scanner, DatabaseManager databaseManager) {
        this.scanner = scanner;
        this.databaseManager = databaseManager;
    }


    
    public DatabaseManager getDatabaseManager() {
        return databaseManager;
    }
    

    public void printListSofas() {
        int n = 0;
        System.out.println("----- List of all Books -----");
        List<Sofa> sofas = getDatabaseManager().getListSofas();
        for (int i = 0; i < sofas.size(); i++) {
            String yearString = Integer.toString(sofas.get(i).getYear());

            System.out.println(i + 1 +". " 
                    + "Name: "+sofas.get(i).getSofaName() 
                    + " | Price: "+sofas.get(i).getPrice()
                    + " | Year: "+ yearString
                    + " | Stock: "+ sofas.get(i).getQuantity());


        }
}
    public void setOrderRating(Sofa sofas, double rating) {
        sofas.setOrderRating(rating);
        System.out.println("Orders rating set successfully for " + sofas.getSofaName() + ": " + rating);
    }
    
    public Sofa addSofa() {
        System.out.println("----- Add a Sofa -----");
        Sofa sofa = new Sofa();
        System.out.print("Enter sofa name: ");
        sofa.setSofaName(scanner.nextLine());

        System.out.print("Enter price in euros: ");
        double bookPrice = Double.parseDouble(scanner.nextLine());
        sofa.setPrice(bookPrice);


        System.out.print("Enter publishing year: ");
        int sofaYear = Integer.parseInt(scanner.nextLine());
        sofa.setYear(sofaYear);
       

        System.out.print("Enter Quantity: ");
        int sofaQuantity = Integer.parseInt(scanner.nextLine());
        sofa.setQuantity(sofaQuantity);


        databaseManager.saveSofa(sofa);
        return sofa;
   
}
    

    public void editSofa() {
        List<Sofa> sofas = getDatabaseManager().getListSofas();
    
        System.out.println("----- Edit a Sofa -----");
        printListSofas();
        System.out.print("Enter the number of the sofa to edit: ");
        int sofaChoice = InputProtection.intInput(1, sofas.size()) - 1;
        Sofa SofaToEdit = sofas.get(sofaChoice);



        System.out.println("Press: \n"
                + "1 to edit sofa name \n"
        + "2 to edit sofa publishing year \n"
        + "3 to edit sofa price \n"
        + "4 to edit sofa quantity \n");


        int task = InputProtection.intInput(1,6); 

        switch (task) {
            case 1:
                System.out.print("Enter new name: ");
                String newName = scanner.nextLine();
                if (!newName.isEmpty()) {
                SofaToEdit.setSofaName(newName);
                    }

            case 2:
                System.out.print("Enter new publishing year: ");
                int newYear = Integer.parseInt(scanner.nextLine());
                if (newYear >= 1440){
                    SofaToEdit.setYear(newYear);
                }
                break;
            case 3:
                System.out.print("Enter new price: ");
                double newPrice = InputProtection.doubleInput(-1, Double.MAX_VALUE);
                if (newPrice >= 0) {
                SofaToEdit.setPrice(newPrice);
                }
                break;
            case 4:
                System.out.print("Enter new quantity: ");
                int newQuantity = Integer.parseInt(scanner.nextLine());
                if (newQuantity >= 0) {
                SofaToEdit.setQuantity(newQuantity);
                }     


            default:
                System.out.println("Invalid task number. Please select a task from the list above.");
        }

        databaseManager.saveSofa(SofaToEdit);
        System.out.println("Sofa edited successfully!");
        printListSofas();
        }
}
    
