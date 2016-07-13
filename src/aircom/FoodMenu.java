/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aircom;

import java.util.HashMap;


/**
 *
 * @author Mtilla
 */
public class FoodMenu {

    public static HashMap<Food, Integer> getFirstClassMenu() {
        return firstClassMenu;
    }

    public static HashMap<Food, Integer> getEcoClassMenu() {
        return ecoClassMenu;
    }
    
   static final HashMap<Food, Integer> firstClassMenu = new HashMap<Food, Integer>();  
   static {
       firstClassMenu.put(new Food("VeggieLasagne"), 190);
       firstClassMenu.put(new Food("Mediterranean sallad"), 180);
       firstClassMenu.put(new Food("Beanburger de Lux"), 210);
        firstClassMenu.put(new Food("Marinade tofu with roasted veggies"), 220);
           }
   
   
   static final HashMap<Food, Integer> ecoClassMenu = new HashMap<Food, Integer>();
   static {
       ecoClassMenu.put(new Food("Chili sin carne"), 130);
       ecoClassMenu.put(new Food("Broccoli soup"), 120);
       ecoClassMenu.put(new Food("Club Sandwich"), 110);
       ecoClassMenu.put(new Food("nudel wok"), 140);
       
           }
   
   
   
   
   
    
}
