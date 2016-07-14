/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aircom;

import java.util.ArrayList;
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
    AirplanePetrus plane;
    
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
    ArrayList<Integer> foodSelections = new ArrayList<Integer>();
    int totalFoodPrice = 0;
    
    CalculateCosts calcCosts = new CalculateCosts();    
    
    public UI() {        
        plane = new AirplanePetrus();
    }
    
    public UI(AirplanePetrus plane) {        
        this.plane = plane;
    }
    
    public void printMainMenu() {
        Scanner one = new Scanner(System.in);
        int menyVal = 1;
        while(menyVal != 0){
            //System.out.println("Welcome to AirCom!");
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
                case 1:
                    printBookMenu();//Book a trip;
                    break;
                case 2:
                    airlineInfo();//Airline info;
                    break;
                case 3: //Show Airplane info();
                    break;
                case 4: //Take off Airplane();
                    break;
                default:
                    System.out.println("Please type number 0-4 only");
            }
        }
    }
    
    public void printBookMenu() {
        //System.out.println("Welcome to AirCom!");
        System.out.println();
        
        System.out.println("Where would you like to go?");
        //TODO: read in the destination
        //Airplane.setDestination = ...
        System.out.println("1. Tokyo");
        System.out.println("2. New York");
        System.out.println("3. Calcutta");
        System.out.println("4. London");
        System.out.println("5. Melbourne");
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
        
        System.out.println();
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
                //foodSelection = printFoodMenu(flightType);
                foodSelections = printFoodMenu(flightType);
            }
        
        System.out.println();
        System.out.println("What is your first name?");        
        firstName = sc.nextLine();
        
        System.out.println();
        System.out.println("What is your surname?");
        surName = sc.nextLine();
        
        System.out.println();
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
        
        System.out.println();
        System.out.println("What is your personal number?");
        persNr = sc.nextInt();
        sc.nextLine();
        
        System.out.println();
        System.out.println("What is your phone number?");
        phoneNr = sc.nextLine();
        //System.out.println();
        
        Passenger customer = new Passenger(flightType, eat, firstName, surName, persNr, phoneNr, gender);//exception?
                
        ArrayList<Food> foodChoices = new ArrayList<Food>();
        //int totalFoodPrice = 0;//flyttad till början av filen
        //Food f = new Food(economyClassFood.get(reader.nextInt()-1).getFoodItem());
        
        //foodSelections innehåller vad passagerarna valde att äta o dricka...
        //...i meny-listorna
        FoodMenu menu = new FoodMenu();
        if (flightType == FlightType.FIRSTCLASS) {            
            ArrayList<Food> firstClassFood = menu.getFirstClassMenu();
            //foodSelections;
            for (int a = 0; a < foodSelections.size(); a++) {//foodSelections.get(a - 1)
                if (foodSelections.get(a) > 0){
                    totalFoodPrice = totalFoodPrice + firstClassFood.get(foodSelections.get(a) - 1).getPrice();//ger fel?
                }
                else{
                    totalFoodPrice = totalFoodPrice + firstClassFood.get(foodSelections.get(a)).getPrice();//ger fel?
                }
                //lägger till mat folk beställt i en lista
                //foodSelections.get(a - 1)
                foodChoices.add(firstClassFood.get(foodSelections.get(a) - 1));
            }
        }
        else if (flightType == FlightType.ECOCLASS) {
            ArrayList<Food> economyClassFood = menu.getEcoClassMenu();
            //foodSelections;
            for (int a = 0; a < foodSelections.size(); a++) {//foodSelections.get(a - 1)
                if (foodSelections.get(a) > 0){
                    totalFoodPrice = totalFoodPrice + economyClassFood.get(foodSelections.get(a) - 1).getPrice();
                }
                else{
                    totalFoodPrice = totalFoodPrice + economyClassFood.get(foodSelections.get(a)).getPrice();
                }                
                //lägger till mat folk beställt i en lista
                //foodSelections.get(a - 1)
                foodChoices.add(economyClassFood.get(foodSelections.get(a) - 1));
            }
        }
        
        customer.setChosenFood(foodSelection, flightType);
        int foodPrices = 0;
        if (flightType == FlightType.FIRSTCLASS) {//'FoodMenu.firstClassMenu.get(customer.choseFood)' nedan, tar bort tillfälligt
            foodPrices = totalFoodPrice;// 200;//FoodMenu.;
            //FoodMenu.getFirstClassMenu().;//390;//getChoseFood()//exception
        }
        else if (flightType == FlightType.ECOCLASS) {//FoodMenu.ecoClassMenu.get(customer.choseFood) tillfälligt borttagit
            foodPrices = totalFoodPrice;//190;//getChoseFood()//exception
        }
        
        //int foodPrices = FoodMenu.firstClassMenuOld.get(customer.chosenFood);//getChoseFood()
        //calculate and print total price
        //int foodPrices = 215;//köper mat för 215 kr
        //foodPrices = customer.calculateFoodOrder();
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
            case 1: income = calcCosts.calculateAirlineIncome(plane.getFirstClassSeats(), this);//Airline income;
                    incomeEconomy = calcCosts.calculateAirlineIncome(plane.getEconomyClassSeats(), this);
                    calcCosts.printAirlineIncome(income + incomeEconomy);
                    break;
            case 2: income = calcCosts.calculateAirlineIncome(plane.getFirstClassSeats(), this);
                    incomeEconomy = calcCosts.calculateAirlineIncome(plane.getEconomyClassSeats(), this);
                    calcCosts.printAirlineIncome(income + incomeEconomy);
                    int profit = calcCosts.calculateAirlineProfit(income + incomeEconomy);//Airline profit;
                    calcCosts.printAirlineProfit(profit);
                    break;
            case 9: //go back to previous menu
                    break;                       
        }
    }
    
    private ArrayList<Integer> printFoodMenu(FlightType flType) {//int
        ArrayList<Integer> foodChoices = new ArrayList<>();
        int menyVal = 1;
        //Scanner reader = new Scanner(System.in);
        //int foodChoice = 1;
        System.out.println("Food menu:");
        System.out.println();
        FoodMenu menu = new FoodMenu();
        while(menyVal != 0){
            Scanner reader = new Scanner(System.in);
            if (flType == FlightType.FIRSTCLASS) {                
                ArrayList<Food> firstClassFood = menu.getFirstClassMenu();
                int i = 0;
                //for (Food food : firstClassFood) {
                for (int a = 0; a < firstClassFood.size(); a++) {    
                    i++;
                    System.out.println((a+1) + ". " + firstClassFood.get(a).toString());//food
                }

                //Iterator it = FoodMenu.firstClassMenuOld.entrySet().iterator();
                //int i = 0;
                //while (it.hasNext()) {
                //for (String food : FoodMenu.firstClassMenu) {
                //i++;
                //HashMap.Entry pair = (HashMap.Entry) it.next();
                //System.out.println(i + ". " + pair.getKey());//it.toString()
                //}
                menyVal = reader.nextInt();
                if (menyVal == 0) {
                    break;
                }
                else {
                    foodChoices.add(menyVal);
                }
            } else if (flType == FlightType.ECOCLASS) {                
                ArrayList<Food> economyClassFood = menu.getEcoClassMenu();
                int i = 0;
                //for (Food food : economyClassFood) {
                for (int a = 0; a < economyClassFood.size(); a++) {
                    i++;
                    System.out.println((a+1) + ". " + economyClassFood.get(a).toString());
                }
                //Iterator it = FoodMenu.ecoClassMenuOld.entrySet().iterator();
                //int i = 0;
                //while (it.hasNext()) {
                //i++;
                //HashMap.Entry pair = (HashMap.Entry) it.next();
                //System.out.println(i + ". " + pair.getKey());//it.toString()
                //}
                
                //Food f = new Food(economyClassFood.get(reader.nextInt()-1).getFoodItem());
                //foodChoices.add(f);
                menyVal = reader.nextInt();
                if (menyVal == 0) {
                    break;
                }
                else {
                    foodChoices.add(menyVal);
                }
            }

            //foodChoice = reader.nextInt();            
        }
        return foodChoices;//foodChoice
    }
    
    //temporär metod för att komma åt matpriserna för det passagerarna beställt
    //ska nog ligga i annan klass
    public int getTotalFoodPrice() {
        return totalFoodPrice;
    }
}

