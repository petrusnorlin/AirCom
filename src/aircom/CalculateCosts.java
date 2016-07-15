/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aircom;

import java.util.ArrayList;

/**
 *
 * @author Jimmy
 * Class to calculate costs
 */
public class CalculateCosts {
    
    //metoder för att beräkna biljettpris och...
    //...matpris ska hamna i Passenger har vi bestämt just nu
    //public int cal

	//int sumPassengerPrices = 0;
	
    //beräknar totala passengerar priset baserat på biljett och mat
    public int calculateTotalPassengerPrice(int ticketPrice, int foodPrice) {
        int totalPassengerPrice = ticketPrice + foodPrice;
        return totalPassengerPrice;
    }
    
    //public void printTotalPassengerPrice(Passenger customer, int ticketPrice, int foodPrice) {
    //skriver ut totala passengerar priset
    public void printTotalPassengerPrice(Passenger customer, int totalPrice) {        
        System.out.println("Total price for passenger " + customer + 
                " = " + totalPrice);        
    }
    
    //public int calculateAirlineIncome(ArrayList<Passenger> arrayPass) {
    public int calculateAirlineIncome(ArrayList<Seat> arrayPass, UI ui) {
        int sumPassengerPrices = 0;
        int ticketPrice = 0;
        
        
        //for (Passenger pass : arrayPass) {
        for (Seat chair : arrayPass) {
            if (chair != null){
                if (chair.getSeatedPassenger().getFt() == FlightType.FIRSTCLASS) {
                    ticketPrice = 20000;
                } else if (chair.getSeatedPassenger().getFt() == FlightType.ECOCLASS) {
                    ticketPrice = 5000;
                }
                sumPassengerPrices = sumPassengerPrices + calculateTotalPassengerPrice(ticketPrice, ui.getTotalFoodPrice());
            }
            
            
            //bijettPris-metod ska anropas här under...
            //...och även matpriset
            
            //pass.planeClass
            //sumPassengerPrices = sumPassengerPrices + calculateTotalPassengerPrice(chair.seatedPassenger.getFt() * sumPassengerPrices);
            //sumPassengerPrices = sumPassengerPrices + calculateTotalPassengerPrice(ticketPrice, chair.getSeatedPassenger().calculateFoodOrder());
            
            
        }        
        return sumPassengerPrices;
    }
    
    //la till denna för att använda Matildas Airplane med 'Seat[]'
    public int calculateAirlineIncome2(Seat[] arrayPass){//, UI ui) {
        int sumPassengerPrices = 0;
        int ticketPrice = 0;
        int foodPrice = 0;
        
        //for (Passenger pass : arrayPass) {
        for (Seat chair : arrayPass) {
            if (chair != null){
            //if (chair.getSeatedPassenger() != null) {
                if (chair.getSeatedPassenger().getFt() == FlightType.FIRSTCLASS) {
                    ticketPrice = 20000;
                } else if (chair.getSeatedPassenger().getFt() == FlightType.ECOCLASS) {
                    ticketPrice = 5000;
                }
                foodPrice = chair.getSeatedPassenger().getFoodOrderPrice();//f�r att f� den enskilda passagerarens matpris
                sumPassengerPrices = sumPassengerPrices + calculateTotalPassengerPrice(ticketPrice, foodPrice);
                //sumPassengerPrices = sumPassengerPrices + calculateTotalPassengerPrice(ticketPrice, ui.getTotalFoodPrice());
            }
            
            //bijettPris-metod ska anropas här under...
            //...och även matpriset
            
            //pass.planeClass
            //sumPassengerPrices = sumPassengerPrices + calculateTotalPassengerPrice(chair.seatedPassenger.getFt() * sumPassengerPrices);
            //sumPassengerPrices = sumPassengerPrices + calculateTotalPassengerPrice(ticketPrice, chair.getSeatedPassenger().calculateFoodOrder());
            
            
        }
        
        return sumPassengerPrices;
    }
    
    public void printAirlineIncome(int income) {
        System.out.println("Income for the airline company is " + income);
    }
    
    public int calculateAirlineProfit(int income) {
        int sumAirlineProfit = 0;        
        
        //70% of the income is used to cover the costs of the airline company
        //the profit is then 30% of the income
        sumAirlineProfit = (int) (0.3 * income);
        return sumAirlineProfit;
    }
    
    public void printAirlineProfit(int profit) {
        System.out.println("The airline company's profit is " + profit);
    }
}
