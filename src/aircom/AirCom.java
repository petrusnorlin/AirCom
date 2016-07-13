/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aircom;

import java.util.HashMap;
import java.util.Iterator;
/**
 *
 * @author Jimmy, Matilda, Petrus
 * Main-class
 */
public class AirCom {

    /**
     * @param args the command line arguments
     */    
    public static void main(String[] args) {
        
        System.out.println("Welcome to AirCom!");
        
        
        System.out.println("Menu for 1st Class passengers:");  
        printFoodMenu(FoodMenu.firstClassMenuOld);
        System.out.println();
        System.out.println("Menu for ECO Class passengers:");
        printFoodMenu(FoodMenu.ecoClassMenuOld);

        //la jag(Jimmy) till
        Airplane plane = new Airplane();
        
        //UI ui = new UI();
        UI ui2 = new UI(plane);
        //ui.printMenu();
        System.out.println();
        ui2.printMainMenu();
    }
    public static void printFoodMenu(HashMap mp) {
        Iterator it = mp.entrySet().iterator();
        while (it.hasNext()) {
            HashMap.Entry pair = (HashMap.Entry) it.next();
            System.out.println(pair.getKey() + " price: " + pair.getValue() + "kr");
            //System.out.println(((Food)pair.getKey()).getFoodItem() + " price: " + pair.getValue()); //när jag inte overridar toString()
        }

    }
}
