/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aircom;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Mtilla
 */


public class AirplaneNew {
    
    private static FoodMenu food = new FoodMenu(); //Måste vara statisk så statiska arraylistan inte fylls på varje gång konstruktor FoodMenu() körs.

    public static FoodMenu getFood() {
        return food;
    }
    
    public enum PlaneStateType
    {
    PREPAIR,INAIR,LANDED
    }
    
    
    private String plane;
    private Seat[] fClassSeats;
    private Seat[] ecoClassSeats;
    private LocalDate departure;
    private LocalDate arrival;
    

    public AirplaneNew(String plane) {
        this.plane = plane;
        fClassSeats = new Seat[5];
        ecoClassSeats = new Seat [5];
    }
    

  
}
    
    
