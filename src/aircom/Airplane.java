package aircom;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author Mtilla
 */


public class Airplane implements Runnable{
    
    @Override
    public void run(){
        System.out.println("Plane " + plane + "is taking off");
        try{
            Thread.sleep(4700);
            
                   
            }
            catch (InterruptedException e)
            {
            e.printStackTrace();
        }
        System.out.println("Plane " + plane + "is landing");
    }
    
    private static FoodMenu foodMenu = new FoodMenu(); //Måste vara statisk så statiska arraylistan inte fylls på varje gång konstruktor FoodMenu() körs.
         
    private String plane;   //flygplansID
    DestinationType destination;
    private Seat[] fClassSeats;
    private Seat[] ecoClassSeats;
    private LocalDateTime departure;
    private LocalDateTime arrival;
    int counterEco;//SKA den var statisk?
    int counterFirst;
    
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
    
    

    public LocalDateTime getDeparture() {
        return departure;
    }

    public LocalDateTime getArrival() {
        return arrival;
    }
    
//    public void reservSeatEco(Seat seat)
//    {
//    ecoClassSeats
//    }
    
    
    public Airplane(String plane, DestinationType destination) {
        this.destination = destination;
        this.plane = plane;
        this.departure = LocalDateTime.now().plusMinutes(8);
        this.arrival= LocalDateTime.now().plusMinutes(10);
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
    
    public String printOutEcoSeatsReservationsReturningString()
    { StringBuilder builder = new StringBuilder();
        for (int i = 0; i < ecoClassSeats.length; i++) {
            Seat es = ecoClassSeats[i];
            if(es !=null)
             builder.append(es).append("\n");                       
        }
        return builder.toString();
    }
    
    public String printOutFirstSeatsReservationsReturningString()
    { StringBuilder builder = new StringBuilder();
        for (int i = 0; i < fClassSeats.length; i++) {
            Seat es = fClassSeats[i];
            if(es !=null)
             builder.append(es).append("\n");                       
        }
        return builder.toString();
    }
    
    public String printOutSeatsReservationsReturningString()
    { return  printOutFirstSeatsReservationsReturningString() + printOutEcoSeatsReservationsReturningString();
    
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
    
    
