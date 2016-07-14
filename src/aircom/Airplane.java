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


public class Airplane {
    
    private static FoodMenu foodMenu = new FoodMenu(); //Måste vara statisk så statiska arraylistan inte fylls på varje gång konstruktor FoodMenu() körs.
         
    private String plane;
    DestinationType destination;
    private Seat[] fClassSeats;
    private Seat[] ecoClassSeats;
    private LocalDate departure;
    private LocalDate arrival;
    
    public FoodMenu getFoodMenu() {
        return foodMenu;
    }
    
    
    
    
    public Airplane(String plane, DestinationType destination) {
        this.destination = destination;
        this.plane = plane;
        fClassSeats = new Seat[5];
        ecoClassSeats = new Seat [5];
    }
    

  
}
    
    
