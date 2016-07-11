/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aircom;

/**
 *
 * @author User
 */
public class Passenger {
    
  private String passengerID;
    private String fName;
    private String lName;
    private int personalNr;
    private String phonenumber;

    //alt+Insert för att auto-generate 
    public Passenger(String fName, String lName, int personalNr, String phonenumber) {
        this.fName = fName;
        this.lName = lName;
        this.personalNr = personalNr;
        this.phonenumber = phonenumber;
    }

    public String getpassengerID() {
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

    public void setpassengerID() {
        this.passengerID = passengerID;
    }

    @Override
    public String toString() {
        return fName + " " + lName;
    }
      
}
