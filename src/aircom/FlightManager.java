/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aircom;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class FlightManager {
    
    private static int lastPass = 0;
    
    ArrayList<Passenger> passengerList = new ArrayList<>();
           

    public void registerPassenger(Passenger pa) {
        
    }
    
    public void addPassenger(){
    
    }
            
    
    
     
        private int getPassengerID() {
        return lastPass++;
        }
}
