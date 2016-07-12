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
        sc.nextLine();
        if (sc.equals("Y") || sc.equals("y")) {
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
        int userSelection = 0;
        System.out.println("What information about the airline would you like to know?");
        System.out.println("1. Airline income");
        System.out.println("2. Airline profit");
        userSelection = sc.nextInt();
        if (userSelection == 1) {
            
            //arrayPass ska ersättas med en passagerarlista från någon klass
            //int income = calcCosts.calculateAirlineIncome(arrayPass);
            
        }
    }
}

