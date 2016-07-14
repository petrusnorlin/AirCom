/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aircom;
import java.util.ArrayList;

/**
 *
 * @author Mtilla
 */

public class FlightManager {
    
    Airplane airplane;
    DestinationType destination;
    private static int lastPass = 0;
    
    ArrayList<Passenger> passengerList = new ArrayList<>();
    
    private int getPassengerID() {
        return lastPass++;
        }
              
    //Add passenger to ArrayList passengerList:
    public void registerPassenger(Passenger pa) {
        pa.setPassengerID(getPassengerID()); //first setting the passengerID by calling getPassengerID()
        passengerList.add(pa);//adding the passenger to the ArrayList
    }
    
 }
          
