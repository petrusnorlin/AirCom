package aircom;

import aircom.PlaneStateType;
import aircom.PlaneStateType;

/**
 * Klass för att starta flygplanen i separata trådar
 * 
 * @author  Joel.D
 * @since   2016-07-14
 * @version 1.1
 * 
 * @ Uppd   v1.1    Gjort så att klassen kan anropas från menyn och tar in flygplanobjektens egna namn [JD]
 */
public class AirplaneThread implements Runnable{

    private Thread t;
    private String flightID;
    private PlaneStateType airplaneStatus;
    
    /**
     * Skapar flygplanstråd och sätter flygplanets status till EMPTY
     * 
     * @param flightName    flygplanobjektets egna namn
     */
    public AirplaneThread(String flightName){
        flightID = flightName;
        airplaneStatus = PlaneStateType.EMPTY;
        System.out.println("Flygplan " + flightID + " är redo för användning....");
    }
    
    /**
     * Metod som visar flygplanens status i separata trådar. 
     * BOARDING -> TAKING_OFF -> FLYING -> LANDING -> DESEMBARKING -> EMPTY
     * 
     * Först när passagerare klivit av och planet är tomt som passagerarlistan töms
     */
    @Override
    public void run() {
        System.out.println("Flygplan " + flightID + " är klar för boarding..."); 
        try{
            for(int i=0; i<2; i++){
                airplaneStatus = PlaneStateType.BOARDING;
                System.out.println("Flygplan " + flightID + " har status = " + airplaneStatus);
                Thread.sleep(3000);
                airplaneStatus = PlaneStateType.TAKING_OFF;
                System.out.println("Flygplan " + flightID + " har status = " + airplaneStatus);
                Thread.sleep(3000);
                airplaneStatus = PlaneStateType.FLYING;
                System.out.println("Flygplan " + flightID + " har status = " + airplaneStatus);
                Thread.sleep(10000);
                airplaneStatus = PlaneStateType.LANDING;
                System.out.println("Flygplan " + flightID + " har status = " + airplaneStatus);
                Thread.sleep(3000);
                airplaneStatus = PlaneStateType.DESEMBARKING;
                System.out.println("Flygplan " + flightID + " har status = " + airplaneStatus);
                Thread.sleep(3000);
                airplaneStatus = PlaneStateType.EMPTY;
                System.out.println("Flygplan " + flightID + " har status = " + airplaneStatus);
                if(i == 0)
                    System.out.println("\n>>> Flight " + flightID + " flyger tillbaka <<<\n");
            }
        } catch (InterruptedException ie) {
            System.out.println("Thread " +  flightID + " interrupted.");
        }
        System.out.println("\n>>> Flygplan " + flightID + " är tom nu och redo för användning.... <<<\n");
    }
    
    
     public void start (){
      if (t == null){
         t = new Thread (this, flightID);
         t.start ();
      }
     }
}