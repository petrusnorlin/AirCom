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
 * @author User
 */
public class AirCom {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
      printFirstClassMenu(FoodMenu.firstClassMenu);

   
    }
    public static void printFirstClassMenu(HashMap mp) {
        Iterator it = mp.entrySet().iterator();
    while (it.hasNext()) {
        HashMap.Entry pair = (HashMap.Entry)it.next();
        System.out.println(pair.getKey() + " price: " + pair.getValue() + "kr");
        //System.out.println(((Food)pair.getKey()).getFoodItem() + " price: " + pair.getValue()); //när jag inte overridar toString()
    }
}
}
