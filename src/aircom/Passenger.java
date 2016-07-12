/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aircom;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 *
 * @author User
 */
public class Passenger {   
    
  private int passengerID;
    private FlightType ft;
    private String fName;
    private String lName;
    private int personalNr;
    private String phonenumber;
    private GenderType gender;
    private Boolean eat;
    
    HashMap<Food, Integer> chosenFood = new HashMap<Food, Integer>();
    
    public int calculateFoodOrder()
    {
        int sum = 0;
        Iterator it = chosenFood.entrySet().iterator();
      while (it.hasNext()) {
         Entry pair = (Entry)it.next();
          sum += (int)pair.getValue();        
      }
      return sum;
    }

    //alt+Insert för att auto-generate 
    public Passenger(FlightType ft, Boolean eat, String fName, String lName, int personalNr, String phonenumber, GenderType gender) {
        this.ft = ft;
        this.eat = eat;
        this.fName = fName;
        this.lName = lName;
        this.personalNr = personalNr;
        this.phonenumber = phonenumber;
        this.gender = gender;
        
    }

    public FlightType getFt() {
        return ft;
    }

    public GenderType getGender() {
        return gender;
    }

    public Boolean getEat() {
        return eat;
    }

    
    
    public int getPassengerID() {
        return passengerID;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public int getPersonalNr() {
        return personalNr;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPassengerID(int PassengerID) {
        this.passengerID = passengerID;
    }

    @Override
    public String toString() {
        return fName + " " + lName;
    }
      
}
