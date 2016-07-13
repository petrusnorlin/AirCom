/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aircom;

import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * @author Mtilla
 */
public class FoodMenu {

     //privata statiska Variabler/referenser
    //Constructor(initiera startvärden)
    //publika metoder för att komma privata statiska (non static) 
    
   
    
    
    
    private static ArrayList<Food> firstClassMenu = new ArrayList<>();       
    private static ArrayList<Food> ecoClassMenu = new ArrayList<>();
    
     public FoodMenu() {
       firstClassMenu.add(new Food("VeggieLasagne", 190));
       firstClassMenu.add(new Food("Mediterranean sallad", 180));
       firstClassMenu.add(new Food("Beanburger de Lux", 210));
       firstClassMenu.add(new Food("Marinade tofu with roasted veggies", 220)); 
       firstClassMenu.add(new Food("Coffee", 18));
       firstClassMenu.add(new Food("Soda", 23));
       firstClassMenu.add(new Food("Coffee", 18));
       firstClassMenu.add(new Food("Soda", 23));
       firstClassMenu.add(new Food("Ice-cream", 18));
       firstClassMenu.add(new Food("lemonpie", 23));
       ecoClassMenu.add(new Food("Chili sin carne", 125));
       ecoClassMenu.add(new Food("Broccoli soup", 120));
       ecoClassMenu.add(new Food("Club Sandwich", 110));
       ecoClassMenu.add(new Food("nudel wok", 140));
       ecoClassMenu.add(new Food("Coffee", 0));
       ecoClassMenu.add(new Food("Soda", 20));
       ecoClassMenu.add(new Food("Conjac", 30));
       ecoClassMenu.add(new Food("panacotta", 50));
       ecoClassMenu.add(new Food("chockladtryffel", 25));
       
       
    }
    

    public static ArrayList<Food> getFirstClassMenu() {
        return firstClassMenu;
    }


    public static ArrayList<Food> getEcoClassMenu() {
        return ecoClassMenu;
    }

  
    //   static final HashMap<Food, Integer> firstClassMenuOld = new HashMap<Food, Integer>();  
//  
//  static{
//       firstClassMenu.add(new Food("VeggieLasagne", 190));
//       firstClassMenu.add(new Food("Mediterranean sallad", 180));
//       firstClassMenu.add(new Food("Beanburger de Lux", 210));
//       firstClassMenu.add(new Food("Marinade tofu with roasted veggies", 220));
//           }
//   
//   
//   static final HashMap<Food, Integer> ecoClassMenuOld = new HashMap<Food, Integer>();
//   static {
//       ecoClassMenuOld.put(new Food("Chili sin carne"), 130);
//       ecoClassMenuOld.put(new Food("Broccoli soup"), 120);
//       ecoClassMenuOld.put(new Food("Club Sandwich"), 110);
//       ecoClassMenuOld.put(new Food("nudel wok"), 140);
//       
//           }
//   
//    public static HashMap<Food, Integer> getFirstClassMenu() {
//        return firstClassMenuOld;
//    }      
//
//    public static HashMap<Food, Integer> getEcoClassMenu() {
//        return ecoClassMenuOld;
//    }
   

   
   
   
   
   
   
    
}
