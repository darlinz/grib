/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Buyer;
import entity.User;
import java.util.List;
import java.util.Scanner;
import tools.PassEncrypt;

/**
 *
 * @author user
 */
public class BuyerManager {
    private final Scanner scanner;

    public BuyerManager(Scanner scanner) {
        this.scanner = scanner;
    }
    
    public User addBuyer() {
        // Create a new Buyer object
        Buyer buyer = new Buyer();
        System.out.println("--- Add Buyer ---");

        // Gather buyer information
        System.out.print("Firstname: ");
        buyer.setFirstname(scanner.nextLine().trim());

        System.out.print("Lastname: ");
        buyer.setLastname(scanner.nextLine().trim());

        System.out.print("Phone: ");
        buyer.setPhone(scanner.nextLine().trim());

        // Gather user information
        User user = new User();
        System.out.print("Login: ");
        user.setLogin(scanner.nextLine().trim());

        System.out.print("Password: ");
        PassEncrypt pe = new PassEncrypt();
        user.setPassword(pe.getEncryptPassword(scanner.nextLine().trim(), pe.getSalt()));

        user.setBuyer(buyer);  // Associate buyer with user

        System.out.println("New buyer added!");

       
        System.out.print("Initial Balance: ");
        try {
            double buyerBalance = Double.parseDouble(scanner.nextLine().trim());
            buyer.setBalance(buyerBalance);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Balance not set. Setting to 0.");
            buyer.setBalance(0);
        }

        return user;
    }
    
     public void printListUsers(DatabaseManager databaseManager) {
        System.out.println("----- List buyers -----");
        List<User> users = databaseManager.getListUsers();
        for (int i = 0; i < users.size(); i++) {
            System.out.printf("%d. %s %s. Login: %s (phone: %s)%n",
                    i+1,
                    users.get(i).getBuyer().getFirstname(),
                    users.get(i).getBuyer().getLastname(),
                    users.get(i).getLogin(),
                    users.get(i).getBuyer().getPhone()
            );
        }
    }
        public void editBuyer(List<Buyer> buyers) {
        System.out.println("----- Edit buyer -----");
        printListBuyers(buyers);

        System.out.print("Enter the number of the buyer to edit: ");
        int customerIndex = Integer.parseInt(scanner.nextLine()) - 1;

        if (customerIndex < 0 || customerIndex >= buyers.size()) {
            System.out.println("Invalid buyer selection.");
            return;
        }

        Buyer buyer = buyers.get(customerIndex);

        System.out.print("New Firstname: ");
        String newFirstname = scanner.nextLine().trim();
        if (!newFirstname.isEmpty()) {
            buyer.setFirstname(newFirstname);
        }

        System.out.print("New Lastname: ");
        String newLastname = scanner.nextLine().trim();
        if (!newLastname.isEmpty()) {
            buyer.setLastname(newLastname);
        }

        System.out.print("New Phone: ");
        String newPhone = scanner.nextLine().trim();
        if (!newPhone.isEmpty()) {
            buyer.setPhone(newPhone);
        }

        // Now, add code to update the balance
        System.out.print("New Balance: ");
        String newBalanceStr = scanner.nextLine().trim();
        if (!newBalanceStr.isEmpty()) {  // Ensure user inputted something
            try {
                double newBalance = Double.parseDouble(newBalanceStr);  // Convert string to double
                buyer.setBalance(newBalance);  // Set the new balance
            } catch (NumberFormatException e) {  // Handle conversion errors
                System.out.println("Invalid input for balance. Skipping balance update.");
            }
        }

        System.out.println("Buyer updated!");
    }

    public void printListBuyers(List<Buyer> buyers) {
        for (int i = 0; i < buyers.size(); i++) {
            Buyer buyer = buyers.get(i);
            System.out.printf("%d: %s %s, Phone: %s, Balance: %.2f%n", 
                              i + 1, 
                              buyer.getFirstname(), 
                              buyer.getLastname(), 
                              buyer.getPhone(), 
                              buyer.getBalance());
        }
    }
}


