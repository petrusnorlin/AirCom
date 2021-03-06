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
public class Airplane {
    
    private String planeID;
    ArrayList<Seat> firstClassSeats;
    ArrayList<Seat> economyClassSeats;
    //ArrayList
    
    public  Airplane() {
        firstClassSeats = new ArrayList<>();
        economyClassSeats = new ArrayList<>();       
    }
 
    public boolean isTherePassengerSpace(FlightClass flightClass) {
        if (null != flightClass) switch (flightClass) {
            case FirstClass:
                //Om FirstClass class lägg upp denna
                if (firstClassSeats.size()<5)
                return true;
            case EconomyClass:
                //Om economy class lägg upp denna
                if (economyClassSeats.size()<5)
                return true;
            default:
                return false;//unknown
        }
        return false;//om det inte finns plats
    } 
    
    public int addPassengerToSeat(Passenger passenger, FlightClass flightClass) {
        if (!isTherePassengerSpace(flightClass))
            return -1;
        if (null != flightClass) switch (flightClass) {
            case FirstClass:
                //Om FirstClass class lägg upp denna
                firstClassSeats.add(new Seat( firstClassSeats.size()+1, passenger));
                return 1;
            case EconomyClass:
                //Om economy class lägg upp denna
                economyClassSeats.add(new Seat( economyClassSeats.size()+1, passenger));
                return 2;
            default:
                return -1;//unknown
        }
        return -1;
    }    
    
    
}
