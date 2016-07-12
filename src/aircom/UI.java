/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aircom;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Jimmy
 * User Interface
 */
public class UI {
    Scanner sc = new Scanner(System.in);
    
    String dest = "";
    Airplane plane;
    
    String flightClass = "";
    FlightType flightType;
    String firstName = "";
    String surName = "";
    String genderReply = "";
    GenderType gender;// = new Gender()
    int persNr = 0;
    String phoneNr = "";
    String eatReply = "";
    boolean eat = false;
    int foodSelection = 0;
    
    CalculateCosts calcCosts = new CalculateCosts();    
    
    public UI() {        
        plane = new Airplane();
    }
    
    public UI(Airplane plane) {        
        this.plane = plane;
    }
    
    public void printMainMenu() {
        Scanner one = new Scanner(System.in);
        int menyVal;
        //while(menyVal != 7){
        System.out.println("Welcome to AirCom!");
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("1) Book a trip");
        System.out.println("2) Airline info");
        System.out.println("3) Show Airplane info");
        System.out.println("4) Take off Airplane");
        System.out.println();
        System.out.println("0) Exit AirCom");
        
        menyVal = one.nextInt();
        switch (menyVal) {
            case 0:
                System.exit(0);
            case 1: printMenu();//Book a trip;
                break;
            case 2: airlineInfo();//Airline info;
                break;
            case 3: //Show Airplane info();
                break;
            case 4: //Take off Airplane();
                break;            
        }
    }
    
    public void printMenu() {
        System.out.println("Welcome to AirCom!");
        
        System.out.println("Where would you like to go?");
        //TODO: read in the destination
        //Airplane.setDestination = ...
        dest = sc.nextLine();//next?
        
        System.out.println("Would you like to travel in first class['F'] or economy class['E']?");
        //TODO: read in the class type
        //Passenger.setFlightClass//first eller economy
        flightClass = sc.nextLine();
        if (flightClass.equalsIgnoreCase("f")) {
            flightType = FlightType.FIRSTCLASS;
        }
        else if (flightClass.equalsIgnoreCase("e")) {
            flightType = FlightType.ECOCLASS;
        }
        
        //TODO: check if first/economy class is full
        //TODO: if full - ask if the passenger wants to travel in the other class...
        //...if the other class has a free seat.
        //...otherwise quit        
        
        System.out.println("Would you like to eat on the plane (y or n)?");
        eatReply = sc.nextLine();//läsa in till variabel
        //if (sc.equals("Y") || sc.equals("y")) {//equalsIgnoreCase()
        if (eatReply.equalsIgnoreCase("y")) {
            eat = true;
        }
        else if (eatReply.equalsIgnoreCase("n")) {
            eat = false;
        }
        //TODO: Passenger.setEat = true;
        //TODO: If eat = yes - present menu where user can decide
            //TODO: present list of food items
            //TODO: read in choices by the users
            if (eat == true) {
                foodSelection = printFoodMenu(flightType);
            }
        
        System.out.println("What is your first name?");        
        firstName = sc.nextLine();
        
        System.out.println("What is your surname?");
        surName = sc.nextLine();
        
        System.out.println("What is your gender? ([M]ale, [F]emale or [O]ther)");
        //TODO: register gender
        //gender = ...//if-satser...?
        genderReply = sc.nextLine();
        //if (genderReply.equals("M") || genderReply.equals("m")) {
        if (genderReply.equalsIgnoreCase("m")) {  
            gender = GenderType.MALE;
        }
        else if (genderReply.equalsIgnoreCase("f")) {
            gender = GenderType.FEMALE;
        }
        else if (genderReply.equalsIgnoreCase("o")) {
            gender = GenderType.OTHER;
        }
        //else you wrote something wrong?
        
        System.out.println("What is your personal number?");
        persNr = sc.nextInt();
        
        System.out.println("What is your phone number?");
        phoneNr = sc.nextLine();
        
        Passenger customer = new Passenger(flightType, eat, firstName, surName, persNr, phoneNr, gender);
        
        customer.setChosenFood(foodSelection, flightType);
        int foodPrices = FoodMenu.firstClassMenu.get(customer.chosenFood);//getChoseFood()
        //calculate and print total price
        //int foodPrices = 215;//köper mat för 215 kr
        foodPrices = customer.calculateFoodOrder();
        //if passenger.flightClass = firstClass typ
        int passengerPrice = calcCosts.calculateTotalPassengerPrice(20000, foodPrices);
        if (flightType == FlightType.FIRSTCLASS) {
            calcCosts.calculateTotalPassengerPrice(20000, foodPrices);
        }
        else if (flightType == FlightType.ECOCLASS) {
            calcCosts.calculateTotalPassengerPrice(5000, foodPrices);
        }
        
        calcCosts.printTotalPassengerPrice(customer, passengerPrice);//skriver ut
    }    
    
    public void airlineInfo() {
        Scanner one = new Scanner(System.in);
        int userSelection = 0;
        System.out.println("What information about the airline would you like to know?");
        System.out.println("1. Airline income");
        System.out.println("2. Airline profit");
        System.out.println();
        System.out.println("9) Return to previous menu");
        System.out.println("0) Exit AirCom");
        userSelection = one.nextInt();//sc
        if (userSelection == 1) {
            
            //arrayPass ska ersättas med en passagerarlista från någon klass
            //int income = calcCosts.calculateAirlineIncome(arrayPass);
            
        }
        //menyVal = one.nextInt();
        int income = 0;
        int incomeEconomy = 0;
        switch (userSelection) {//menyVal
            case 0:
                System.exit(0);
            case 1: income = calcCosts.calculateAirlineIncome(plane.getFirstClassSeats());//Airline income;
                    incomeEconomy = calcCosts.calculateAirlineIncome(plane.getEconomyClassSeats());
                    calcCosts.printAirlineIncome(income + incomeEconomy);
                    break;
            case 2: income = calcCosts.calculateAirlineIncome(plane.getFirstClassSeats());
                    incomeEconomy = calcCosts.calculateAirlineIncome(plane.getEconomyClassSeats());
                    calcCosts.printAirlineIncome(income + incomeEconomy);
                    int profit = calcCosts.calculateAirlineProfit(income + incomeEconomy);//Airline profit;
                    calcCosts.printAirlineProfit(profit);
                    break;
            case 9: //go back to previous menu
                    break;                       
        }
    }
    
    private int printFoodMenu(FlightType flType) {
        Scanner reader = new Scanner(System.in);
        int foodChoice;
        if (flType == FlightType.FIRSTCLASS) {
            Iterator it = FoodMenu.firstClassMenu.entrySet().iterator();
            int i = 0;
            while (it.hasNext()) {
            //for (String food : FoodMenu.firstClassMenu) {
                i++;
                HashMap.Entry pair = (HashMap.Entry) it.next();
                System.out.println(i + ". " + pair.getKey());//it.toString()
            }
        }
        else if (flType == FlightType.ECOCLASS) {
            Iterator it = FoodMenu.ecoClassMenu.entrySet().iterator();
            int i = 0;
            while (it.hasNext()) {
                i++;
                HashMap.Entry pair = (HashMap.Entry) it.next();
                System.out.println(i + ". " + pair.getKey());//it.toString()
            }
        }
        
        foodChoice = reader.nextInt();
        return foodChoice;
    }
}

