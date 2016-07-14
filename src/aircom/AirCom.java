package aircom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


/**
 * Main metod
 * @author Jimmy, Matilda, Petrus, Joel
 * @since 2016-07-14
 */
public class AirCom {
    
    static Airplane air = new Airplane("testplane", DestinationType.TONGA);

    /**
     * @param args the command line arguments
     */    
    public static void main(String[] args) {
        
         
        
        System.out.println("Welcome to AirCom!");
        
        
        System.out.println("Menu for 1st Class passengers:");  
        printFoodMenu(new FoodMenu().getFirstClassMenu());
        System.out.println(air.getFoodMenu().getFirstClassMenu());
        System.out.println("Menu for ECO Class passengers:");
        printFoodMenu(new FoodMenu().getEcoClassMenu());
        System.out.println();
        System.out.println();
        printFoodMenuOld(FoodMenu.getEcoClassMenuOld());

        //la jag(Jimmy) till
//        AirplanePetrus plane = new AirplanePetrus();
//        Airplane flyg = new Airplane("HOLU123", DestinationType.HONOLULU);
//        Airplane flyg2 = new Airplane("FIJ456", DestinationType.FIJI);
//        Airplane flyg3 = new Airplane("TON789", DestinationType.TONGA);
        
        UI ui = new UI();
//        UI ui2 = new UI(plane);
//        UI ui3 = new UI(flyg);
        //ui.printMenu();
        System.out.println();
        ui.printMainMenu();//ui2
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

    }
}
