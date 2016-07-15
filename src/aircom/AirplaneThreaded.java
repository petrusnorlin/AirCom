package aircom;

import java.time.LocalDate;

//authors Matilda, Joel, (Jimmy - put it together)
public class AirplaneThreaded implements Runnable{

	private static FoodMenu foodMenu = new FoodMenu();
    
    private String plane;
    DestinationType destination;
    private Seat[] fClassSeats;
    private Seat[] ecoClassSeats;
    private LocalDate departure;
    private LocalDate arrival;
    int counterEco;
    int counterFirst;
    
    //Joel's
    private Thread t;
    private String flightID;
    private PlaneStateType airplaneStatus;
    
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
    
    //konstruktor
    public AirplaneThreaded(String plane, DestinationType destination) {
        this.destination = destination;
        this.plane = plane;
        fClassSeats = new Seat[5];
        ecoClassSeats = new Seat [5];
        
        //Joel's
        flightID = plane;//flightName;
        airplaneStatus = PlaneStateType.EMPTY;
        System.out.println("Flygplan " + flightID + " är redo för användning....");
    }
    
    //Joel's
    @Override
    public void run() {
        System.out.println("Flygplan " + flightID + " är klar för boarding...");
        
        try{
                airplaneStatus = PlaneStateType.BOARDING;
                System.out.println("Flygplan " + flightID + " har status = " + airplaneStatus);
                Thread.sleep(6000);
                airplaneStatus = PlaneStateType.TAKING_OFF;
                System.out.println("Flygplan " + flightID + " har status = " + airplaneStatus);
                Thread.sleep(5000);
                airplaneStatus = PlaneStateType.FLYING;
                System.out.println("Flygplan " + flightID + " har status = " + airplaneStatus);
                Thread.sleep(20000);
                airplaneStatus = PlaneStateType.LANDING;
                System.out.println("Flygplan " + flightID + " har status = " + airplaneStatus);
                Thread.sleep(5000);
                airplaneStatus = PlaneStateType.DESEMBARKING;
                System.out.println("Flygplan " + flightID + " har status = " + airplaneStatus);
                Thread.sleep(6000);
                airplaneStatus = PlaneStateType.EMPTY;
                System.out.println("Flygplan " + flightID + " har status = " + airplaneStatus);                
        } catch (InterruptedException ie) {
            System.out.println("Thread " +  flightID + " interrupted.");
        }
        System.out.println("Flygplan " + flightID + " är redo för användning....");
    }
    
    public void start (){
        //System.out.println("Starting " +  flightID );
    	if (t == null)
    	{
    		t = new Thread (this, flightID);
    		t.start ();

//    		try {
//    			t.wait();
//    		} catch (InterruptedException e) {
//    			// TODO Auto-generated catch block
//    			e.printStackTrace();
//    		}
    	}
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
