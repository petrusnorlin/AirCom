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
public class AirplanePetrus {
    
    private String planeID;
    private ArrayList<Seat> firstClassSeats;
    private ArrayList<Seat> economyClassSeats;
    //ArrayList
    
    public  AirplanePetrus() {
        firstClassSeats = new ArrayList<>();
        economyClassSeats = new ArrayList<>();       
    }

    //jag la till 3 get-metoder då jag behöver listorna i UI(Jimmy)
    //De verkade redan finnas, tog bort dessa nu  (Petrus)
    public String getPlaneID() {
        return planeID;
    }

    public ArrayList<Seat> getFirstClassSeats() {
        return firstClassSeats;
    }

    public ArrayList<Seat> getEconomyClassSeats() {
        return economyClassSeats;
    }
 
    //FlightClass flightClass ändrat av Jimmy till FlightType flightType
    public boolean isTherePassengerSpace(FlightType flightType) {
        if (null != flightType) switch (flightType) {
            case FIRSTCLASS://flightClass bytt till flightType
                //'FirstClass' bytt till 'FIRSTCLASS'
                //Om FirstClass class lägg upp denna
                if (firstClassSeats.size()<5)
                return true;
            case ECOCLASS://'EconomyClass' bytt till 'ECOCLASS'
                //Om economy class lägg upp denna
                if (economyClassSeats.size()<5)
                return true;
            default:
                return false;//unknown
        }
        return false;//om det inte finns plats
    } 
    
    //FlightClass flightClass har jag(Jimmy) ändrat till 'FlightType flightType'
    public int addPassengerToSeat(Passenger passenger, FlightType flightType) {
        if (!isTherePassengerSpace(flightType))//Om det inte finns plats för passaeraren
            return -1;//'flightClass' var det ovan
        if (null != flightType) switch (flightType) { //'flightClass' var det innan
            case FIRSTCLASS://flightClass bytt till flightType
                //Om FirstClass class lägg upp denna
                firstClassSeats.add(new Seat( firstClassSeats.size()+1, passenger));
                return 1;
            case ECOCLASS://'EconomyClass' bytt till 'ECOCLASS'
                //Om economy class lägg upp denna
                economyClassSeats.add(new Seat( economyClassSeats.size()+1, passenger));
                return 2;
            default:
                return -1;//unknown
        }
        return -1;
    }    



    public void setPlaneID(String planeID) {
        this.planeID = planeID;
    }



    public void setFirstClassSeats(ArrayList<Seat> firstClassSeats) {
        this.firstClassSeats = firstClassSeats;
    }


    public void setEconomyClassSeats(ArrayList<Seat> economyClassSeats) {
        this.economyClassSeats = economyClassSeats;
    }
    
    
}
