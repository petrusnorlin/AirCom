/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aircom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


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
   static{
       firstClassMenu.add(new Food("VeggieLasagne", 190));
       firstClassMenu.add(new Food("Beanburger Lux", 210));
       firstClassMenu.add(new Food("Tofu bruschetta", 170)); 
       firstClassMenu.add(new Food("Coffee", 0));
       firstClassMenu.add(new Food("Soda", 20));
       firstClassMenu.add(new Food("Conjac", 23));
       firstClassMenu.add(new Food("Lemon pie", 30));
       ecoClassMenu.add(new Food("Chili sin carne", 125));
       ecoClassMenu.add(new Food("Broccoli soup", 120));
       ecoClassMenu.add(new Food("Club Sandwich", 110));
       ecoClassMenu.add(new Food("Coffee", 18));
       ecoClassMenu.add(new Food("Soda", 20));
       ecoClassMenu.add(new Food("ice-cream", 30));

       
            }
    public FoodMenu() {
       
    }
    

    public ArrayList<Food> getFirstClassMenu() {
        return firstClassMenu;
    }


    public ArrayList<Food> getEcoClassMenu() {
        return ecoClassMenu;
    }

  
       static final HashMap<Food, Integer> firstClassMenuOld = new HashMap<Food, Integer>();  
  
  static{
       firstClassMenuOld.put(new Food("VeggieLasagne"), 190);
       firstClassMenuOld.put(new Food("Ceaser sallad"), 180);
       firstClassMenuOld.put(new Food("Beanburger de Lux"), 210);
       firstClassMenuOld.put(new Food("Tofu bruschetta"), 220);
           }
   
   
   static final HashMap<Food, Integer> ecoClassMenuOld = new HashMap<Food, Integer>();
   static {
       ecoClassMenuOld.put(new Food("Chili sin carne"), 130);
       ecoClassMenuOld.put(new Food("Broccoli soup"), 120);
       ecoClassMenuOld.put(new Food("Club Sandwich"), 110);
       ecoClassMenuOld.put(new Food("nudel wok"), 140);
       
           }
   
    public static HashMap<Food, Integer> getFirstClassMenuOld() {
        return firstClassMenuOld;
    }      

    public static HashMap<Food, Integer> getEcoClassMenuOld() {
        return ecoClassMenuOld;
    }
    
    public static void printFoodMenu(ArrayList<Food> al)
    {
        for (Food f : al) {
            System.out.println(f.getFoodItem() + " " + f.getPrice() + "kr");
        }
 
    }
    
    public static void printFoodMenuOld(HashMap mp) {
        Iterator it = mp.entrySet().iterator();
        while (it.hasNext()) {
            HashMap.Entry pair = (HashMap.Entry) it.next();//it.next plockar fram key o value i variablen
            System.out.println(pair.getKey() + " price: " + pair.getValue() + "kr");
            //System.out.println(((Food)pair.getKey()).getFoodItem() + " price: " + pair.getValue()); //när jag inte overridar toString()
        }
   
    }}
   
   
   
   
   
   
    

