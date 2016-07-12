/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aircom;

import java.util.Scanner;

/**
 *
 * @author Jimmy
 * User Interface
 */
public class UI {
    Scanner sc = new Scanner(System.in);
    
    String dest = "";
    
    String firstName = "";
    String surName = "";
    String genderReply = "";
    GenderType gender;// = new Gender()
    int persNr = 0;
    String phoneNr = "";
    boolean eat = false;
    
    CalculateCosts calcCosts = new CalculateCosts();    
    
    public UI() {        
        
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
        
        System.out.println("Would you like to travel in first class or economy class?");
        //TODO: read in the class type
        //Passenger.setFlightClass//first eller economy
        
        //TODO: check if first/economy class is full
        //TODO: if full - ask if the passenger wants to travel in the other class...
        //...if the other class has a free seat.
        //...otherwise quit        
        
        System.out.println("Would you like to eat on the plane (y or n)?");
        sc.nextLine();//läsa in till variabel
        if (sc.equals("Y") || sc.equals("y")) {//equalsIgnoreCase()
            eat = true;
        }
        else if (sc.equals("N") || sc.equals("n")) {
            eat = false;
        }
        //TODO: Passenger.setEat = true;
        //TODO: If eat = yes - present menu where user can decide
            //TODO: present list of food items
            //TODO: read in choices by the users
        
        System.out.println("What is your first name?");        
        firstName = sc.nextLine();
        
        System.out.println("What is your surname?");
        surName = sc.nextLine();
        
        System.out.println("What is your gender? ([M]ale, [F]emale or [O]ther)");
        //TODO: register gender
        //gender = ...//if-satser...?
        genderReply = sc.nextLine();
        if (genderReply.equals("M") || genderReply.equals("m")) {
            gender = GenderType.MALE;
        }
        else if (genderReply.equals("F") || genderReply.equals("f")) {
            gender = GenderType.FEMALE;
        }
        else if (genderReply.equals("O") || genderReply.equals("o")) {
            gender = GenderType.OTHER;
        }
        //else you wrote something wrong?
        
        System.out.println("What is your personal number?");
        persNr = sc.nextInt();
        
        System.out.println("What is your phone number?");
        phoneNr = sc.nextLine();
        
        Passenger customer = new Passenger(firstName, surName, persNr, phoneNr, gender, eat);
        
        
        //calculate and print total price
        int foodPrices = 215;//köper mat för 215 kr
        //if passenger.flightClass = firstClass typ
        int passengerPrice = calcCosts.calculateTotalPassengerPrice(20000, foodPrices);
        
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
        switch (userSelection) {//menyVal
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
}

