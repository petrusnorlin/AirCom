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
    static int counterEco;
    static int counterFirst;
    
    public FoodMenu getFoodMenu() {
        return foodMenu;
    }

    public String getPlane() {
        return plane;
    }

    public DestinationType getDestination() {
        return destination;
    }

    public Seat[] getfClassSeats() {
        return fClassSeats;
    }

    public Seat[] getEcoClassSeats() {
        return ecoClassSeats;
    }
    
    

    public LocalDate getDeparture() {
        return departure;
    }

    public LocalDate getArrival() {
        return arrival;
    }
    
//    public void reservSeatEco(Seat seat)
//    {
//    ecoClassSeats
//    }
    
    
    public Airplane(String plane, DestinationType destination) {
        this.destination = destination;
        this.plane = plane;
        fClassSeats = new Seat[5];
        ecoClassSeats = new Seat [5];
    }
    
    public void printOutEcoSeatsReservations()
    {
        for (int i = 0; i < ecoClassSeats.length; i++) {
            Seat es = ecoClassSeats[i];
            if(es !=null)
            System.out.println(es);            
        }
    }
    
    public int seatAvailabilityECO()
    { int available=0;
    for (int i = 0; i < ecoClassSeats.length; i++) 
    {
            Seat es = ecoClassSeats[i];
            if(es == null)
            available++;            
    }
    return available;
    }
    
    public int seatAvailabilityFirst()
    { int available=0;
    for (int i = 0; i < fClassSeats.length; i++) 
    {
            Seat es = fClassSeats[i];
            if(es == null)
            available++;            
    }
    return available;
    }
    
    public void printOutFirstClassSeatsReservations()
    {
        for (int i = 0; i < fClassSeats.length; i++) {
            Seat fs = fClassSeats[i];
            if(fs!=null)
            System.out.println(fs);            
        }
    }

  
}
    
    
