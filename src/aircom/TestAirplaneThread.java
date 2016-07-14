package aircom;

/**
 * Klass 
 * @author Joel
 */
class AirplaneThread implements Runnable{

    private Thread t;
    private String flightID;
    private PlaneStateType airplaneStatus;
    
    public AirplaneThread(String flightName){
        flightID = flightName;
        airplaneStatus = PlaneStateType.EMPTY;
        System.out.println("Flygplan " + flightID + " är redo för användning....");
    }
    
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
      }
   }

}

public class TestAirplaneThread {
   public static void main(String args[]) {
      AirplaneThread airplane1 = new AirplaneThread("AC-101");
      airplane1.start();
      
      AirplaneThread airplane2 = new AirplaneThread("AC-102");
      airplane2.start();
      
      AirplaneThread airplane3 = new AirplaneThread("AC-103");
      airplane3.start();
   }   
}
