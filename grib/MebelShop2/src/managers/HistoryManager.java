/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.History;
import entity.Sofa;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import mebelshop2.App;
import tools.InputProtection;

/**
 *
 * @author user
 */
public class HistoryManager {
    
    private final Scanner scanner;
    private final SofaManager sofaManager;
    private final BuyerManager buyerManager;
    
    public HistoryManager(
            Scanner scanner,
            BuyerManager buyerManager,
            SofaManager sofaManager){
        this.scanner = scanner;
        this.sofaManager = sofaManager;
        this.buyerManager = buyerManager;
    }
    
    public void takeOutSofa(DatabaseManager databaseManager){
        History history = new History();
        sofaManager.printListSofas(databaseManager);
        System.out.print("Enter number of furniture from list: ");
        int numberSofa = InputProtection.intInput(1,null);
        Sofa sofa = databaseManager.getSofa((long)numberSofa);
        if(sofa.getCount()>0){
            sofa.setCount(sofa.getCount()-1);
            databaseManager.saveSofa(sofa);
            history.setSofa(Sofa);
            history.setUser(databaseManager.getUser(App.user.getId()));
            history.setTakeOutSofa(new GregorianCalendar().getTime());
            databaseManager.saveHistory(history);
        }else{
            System.out.println("All sofas are taken");
        }
    }
    
    // This method now lists taken sofas instead of reading books
    public int printListTakenSofas(DatabaseManager databaseManager) {
        System.out.println("----- List taken sofas -----");
        List<History> histories = databaseManager.getTakenSofas();
        for (int i = 0; i < histories.size(); i++) {
        System.out.printf("%d. %s. taken by %s %s%n",
                histories.get(i).getId(),                          
                histories.get(i).getSofa().getTitle(),              
                histories.get(i).getUser().getBuyer().getFirstname(), 
                histories.get(i).getUser().getBuyer().getLastname()  
        );
    }
        return histories.size();  // Returning the count of items processed
    }
    public void sofaRating(DatabaseManager databaseManager) {
        List<History> histories = databaseManager.getListHistories();
        Map<Sofa,Integer> mapRatingSofa = new HashMap<>();
        for (int i = 0; i < histories.size(); i++) {
            if(mapRatingSofa.containsKey(histories.get(i).getSofa())){
                mapRatingSofa.put(histories.get(i).getSofa(), mapRatingSofa.get(histories.get(i).getSofa())+1);
            }else{
                mapRatingSofa.put(histories.get(i).getSofa(),1);
            }
        }
        Map<Sofa, Integer> sortedMapRatingSofa = mapRatingSofa.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
        int n = 1;
        for (Map.Entry<Sofa, Integer> entry : sortedMapRatingSofa.entrySet()) {
            System.out.printf("%d. %s: %d%n",
                    n,
                    entry.getKey().getTitle(),
                    entry.getValue()
            );
            n++;
        }
    }
}
