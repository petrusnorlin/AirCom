/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aircom;

import java.util.ArrayList;
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
    private String choseFood;
    
    private int foodOrderPrice;//tillagt av Jimmy
    private long personNr;//tillagt av Jimmy
    private long phoneNr;//tillagt av Jimmy
   
    ArrayList<Food> foodOrder = new ArrayList<Food>();
    
    //tillagt av Jimmy
    public Passenger(FlightType ft, Boolean eat, String fName, String lName, long personNr, long phonenumber, GenderType gender) {
        this.ft = ft;
        this.eat = eat;
        this.fName = fName;
        this.lName = lName;
        this.personNr = personNr;
        this.phoneNr = phoneNr;
        this.gender = gender;
        
    }
    
    public long getPhoneNr() {
        return phoneNr;
    }
    
    public int getFoodOrderPrice() {
        return foodOrderPrice;
    }
    
    public void setFoodOrderPrice(int price) {
        foodOrderPrice = price;
    }
    
    public ArrayList<Food> getFoodOrder() {
        return foodOrder;
    }
    
    public void setFoodOrder(ArrayList<Food> orderedFood) {
        for (Food f : orderedFood) {
        	foodOrder.add(f);
        }
    }
    
    public int calcFoodOrderPrice(ArrayList<Food> orderedFood)
    {
        int sum = 0;
        for (Food food : foodOrder) {
           sum += food.getPrice(); 
        }
        return sum;
    }
    //Jimmys till‰gg slutar h‰r

    public String getChoseFood() {
        return choseFood;
    }
     
    public void setChosenFood(int menuChoice, FlightType flightType) {
        
        if (flightType == FlightType.FIRSTCLASS && menuChoice == 1){
            choseFood = "VeggieLasagne";}
        else if(flightType == FlightType.FIRSTCLASS && menuChoice == 2){
            choseFood = "Mediterranean sallad";}
        else if(flightType == FlightType.FIRSTCLASS && menuChoice == 3){
            choseFood = "Beanburger de Lux";}
        else if(flightType == FlightType.FIRSTCLASS && menuChoice == 4){
            choseFood = "Marinade tofu with roasted veggies";}
        else if(flightType == FlightType.ECOCLASS && menuChoice == 5){
            choseFood = "Chili sin carne";}
        else if(flightType == FlightType.ECOCLASS && menuChoice == 6){
            choseFood = "Broccoli soup";}
        else if(flightType == FlightType.ECOCLASS && menuChoice == 7){
            choseFood = "Club Sandwich";}
        else if(flightType == FlightType.ECOCLASS && menuChoice == 8){
            choseFood = "nudel wok";}
                
        this.choseFood = choseFood;
    }       
    
    public int calculateFoodOrder(ArrayList a)
    {
        int sum = 0;
        for (Food food : foodOrder) {
           sum += food.getPrice(); 
        }
        return sum;
    }
       

    //alt+Insert f√∂r att auto-generate 
    public Passenger(FlightType ft, Boolean eat, String fName, String lName, int personalNr, String phonenumber, GenderType gender) {
        this.ft = ft;
        this.eat = eat;
        this.fName = fName;
        this.lName = lName;
        this.personalNr = personalNr;
        this.phonenumber = phonenumber;
        this.gender = gender;       
    }
    
        public Passenger(FlightType ft, String fName, String lName, int personalNr, String phonenumber, GenderType gender) { //MATILDAS KONSTRUKTOR
        this.ft = ft;
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
    
    HashMap<Food, Integer> chosenFood = new HashMap<Food, Integer>();//OBS!! Tillh√∂r gamla HashMap food
    
    public int calculateChosenFoods()//OBS!! Tillh√∂r gamla HashMap food
    {
        int sum = 0;
        Iterator it = chosenFood.entrySet().iterator();
      while (it.hasNext()) {
         Entry pair = (Entry)it.next();
          sum += (int)pair.getValue();        
      }
      return sum;
    }
      
}
