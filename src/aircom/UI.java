package aircom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Jimmy
 * User Interface
 */
public class UI {
    Scanner sc = new Scanner(System.in);
    
    int destReply = 0;
    String dest = "";
    AirplanePetrus plane;
    Airplane flyg;
    Airplane flyg2;
    Airplane flyg3;
    
    String flightClass = "";
    FlightType flightType;
    String firstName = "";
    String surName = "";
    String genderReply = "";
    GenderType gender;// = new Gender()
    //int persNr = 0;
    long persNr2 = 0;
    String phoneNr = "";
    long phoneNumber = 0;
    String availableReply = "";
    boolean decisionReply;
    String eatReply = "";
    boolean eat = false;
    int foodSelection = 0;
    ArrayList<Integer> foodSelections = new ArrayList<Integer>();
    int totalFoodPrice = 0;
    
    //CalculateCosts calcCosts = new CalculateCosts();
    int airlineIncome = 0;
    int airlineIncomeEconomy = 0;    
    int airlineIncomeFirst = 0;
    int airlineProfit = 0;
    
    public UI() {        
        plane = new AirplanePetrus();
        flyg = new Airplane("HOLU123", DestinationType.HONOLULU);
        flyg2 = new Airplane("FIJ456", DestinationType.FIJI);
        flyg3 = new Airplane("TON789", DestinationType.TONGA);
    }
    
    //public UI(AirplanePetrus plane) {        
    public UI(Airplane flyg) {
        this.flyg = flyg;
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
            System.out.println("5) Fill Airplane with passengers");
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
                    System.out.println();
                    System.out.println("Honolulu flight reservations:");
                    System.out.println("First class");
                    flyg.printOutFirstClassSeatsReservations();
                    System.out.println("Economy class");
                    flyg.printOutEcoSeatsReservations();
                    System.out.println();
                    
                    System.out.println("Fiji flight reservations:");
                    System.out.println("First class");
                    flyg2.printOutFirstClassSeatsReservations();
                    System.out.println("Economy class");
                    flyg2.printOutEcoSeatsReservations();
                    System.out.println();
                    
                    System.out.println("Tonga flight reservations:");
                    System.out.println("First class");
                    flyg3.printOutFirstClassSeatsReservations();
                    System.out.println("Economy class");
                    flyg3.printOutEcoSeatsReservations();
                    System.out.println();                    
                    break;
                case 4: //Take off Airplane(); //egentligen starta alla plan
                    //Thread t = new Thread(flyg);
                    //t.Start();
                	
//                	TestAirplaneThread flygTr�d = new TestAirplaneThread();
//                	Thread t = new Thread(flygTr�d);
                	
//                	AirplaneThreaded airpl1 = new AirplaneThreaded("HOLU123", DestinationType.HONOLULU);
//                    airpl1.start();//AC-101
//                    
//                    AirplaneThreaded airpl2 = new AirplaneThreaded("FIJ456", DestinationType.FIJI);
//                    airpl2.start();//AC-102
//                    
//                    AirplaneThreaded airpl3 = new AirplaneThreaded("TON789", DestinationType.TONGA);
//                    airpl3.start();//AC-103
                    
                    //Joel's
                    AirplaneThread airplane1 = new AirplaneThread(flyg.getPlane());
                    airplane1.start();

                    AirplaneThread airplane2 = new AirplaneThread(flyg2.getPlane());
                    airplane2.start();

                    AirplaneThread airplane3 = new AirplaneThread(flyg3.getPlane());
                    airplane3.start();
                    
//                    try {
//                    	airplane1.wait();
//                    } catch (InterruptedException e) {
//                    	// TODO Auto-generated catch block
//                    	e.printStackTrace();
//                    }
                    break;
                case 5: 
                    fillSeats();
                default:
                    System.out.println("Please type number 0-4 only");
            }
        }
    }
    
    public void printBookMenu() {
        //System.out.println("Welcome to AirCom!");
        System.out.println();
        CalculateCosts calcCosts = new CalculateCosts();
        destReply = 0;
        
        while (destReply > 3 || destReply < 1){
            System.out.println("Where would you like to go?['1', '2' or '3']");
            //TODO: read in the destination
            //Airplane.setDestination = ...
            System.out.println("1. Honolulu");//Tokyo");
            System.out.println("2. Tonga"); //New York");
            System.out.println("3. Fiji");//Calcutta");
            //System.out.println("4. London");
            //System.out.println("5. Melbourne");
            destReply = sc.nextInt();//next?
//        while (destReply < 4 && destReply > 0){
            switch (destReply) {
                case 1:     dest = "Honolulu";
                            break;
                case 2:     dest = "Tonga";
                            break;
                case 3:     dest = "Fiji";
                            break;
                default:    System.out.println("Please write a number 1-3");
                            break;
            }
        }
//        if (destReply == 1){
//            dest = "Honolulu";
//        }
//        else if (destReply == 2){
//            dest = "Tonga";
//        }
//        else if (destReply == 3){
//            dest = "Fiji";
//        }
        sc.nextLine();//rensar bufferten
        System.out.println();
        System.out.println("Would you like to travel in first class['F'] or economy class['E']?");        
        flightClass = sc.nextLine();
        if (flightClass.equalsIgnoreCase("f")) {
            flightType = FlightType.FIRSTCLASS;
            if (dest.equals("Honolulu")) {
            	if (flyg.seatAvailabilityFirst() == 0) {
            		decisionReply = firstClassChoiceQuestions();
//            		System.out.println();
//            		System.out.println("Unfortunately all seats in first class are full.");
//            		System.out.println("Would you like to travel in Economy class instead?");
//            		availableReply = sc.nextLine();
//            		if (availableReply.equalsIgnoreCase("n")) {
//            			System.out.println("You don't want to travel economy class either. You want to cancel the flight?");
//            			availableReply = sc.nextLine();
//            			if (availableReply.equalsIgnoreCase("y")) {
//            				System.exit(0);
//            			}
//            		}
            		if (decisionReply == false) {
                    	System.exit(0);
                    	//break;//return to main menu
                    }
                    else if (decisionReply == true) {
                    	flightType = FlightType.ECOCLASS;
                    }
            	}
            }
            else if (dest.equals("Tonga")) {
            	if (flyg2.seatAvailabilityFirst() == 0) {
            		decisionReply = firstClassChoiceQuestions();
            		if (decisionReply == false) {
                    	System.exit(0);
                    }
                    else if (decisionReply == true) {
                    	flightType = FlightType.ECOCLASS;
                    }
            	}
            }
            else if (dest.equals("Fiji")) {
            	if (flyg2.seatAvailabilityFirst() == 0) {
            		decisionReply = firstClassChoiceQuestions();
            		if (decisionReply == false) {
                    	System.exit(0);
                    }
                    else if (decisionReply == true) {
                    	flightType = FlightType.ECOCLASS;
                    }
            	}
            }
            
        }
        else if (flightClass.equalsIgnoreCase("e")) {
            flightType = FlightType.ECOCLASS;
            if (dest.equals("Honolulu")) {
            	if (flyg.seatAvailabilityECO() == 0) {
            		decisionReply = economyClassChoiceQuestions();
            		if (decisionReply == false) {
                    	System.exit(0);
                    }
                    else if (decisionReply == true) {
                    	flightType = FlightType.FIRSTCLASS;
                    }
            	}
            }
            else if (dest.equals("Tonga")) {
            	if (flyg2.seatAvailabilityECO() == 0) {
            		decisionReply = economyClassChoiceQuestions();
            		if (decisionReply == false) {
                    	System.exit(0);
                    }
                    else if (decisionReply == true) {
                    	flightType = FlightType.FIRSTCLASS;
                    }
            	}
            }
            else if (dest.equals("Fiji")) {
            	if (flyg2.seatAvailabilityECO() == 0) {
            		decisionReply = economyClassChoiceQuestions();
            		if (decisionReply == false) {
                    	System.exit(0);
                    }
                    else if (decisionReply == true) {
                    	flightType = FlightType.FIRSTCLASS;
                    }
            	}
            }            
        }
        
        //TODO: check if first/economy class is full
        //TODO: if full - ask if the passenger wants to travel in the other class...
        //...if the other class has a free seat.
        //...otherwise quit
        
        
        System.out.println();
        System.out.println("Would you like to eat on the plane ['y'] or ['n'])?");
        eatReply = sc.nextLine();//läsa in till variabel
        //if (sc.equals("Y") || sc.equals("y")) {//equalsIgnoreCase()
        if (eatReply.equalsIgnoreCase("y")) {
            eat = true;
        }
        else if (eatReply.equalsIgnoreCase("n")) {
            eat = false;
        }        
            if (eat == true) {
                //foodSelection = printFoodMenu(flightType);
                System.out.println();
                foodSelections = printFoodMenu(flightType);
            }
        
        System.out.println();
        System.out.println("What is your first name?");        
        firstName = sc.nextLine();
        
        System.out.println();
        System.out.println("What is your surname?");
        surName = sc.nextLine();
        
        System.out.println();
        System.out.println("What is your gender? (['M']ale, ['F']emale or ['O']ther)");        
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
        persNr2 = sc.nextLong();//.nextInt();
        sc.nextLine();
        
        System.out.println();
        System.out.println("What is your phone number?");
        //phoneNr = sc.nextLine();
        phoneNumber = sc.nextLong();
        //System.out.println();
        
        Passenger customer = new Passenger(flightType, eat, firstName, surName, persNr2, phoneNumber, gender);
        
        ArrayList<Food> foodChoices = new ArrayList<Food>();
        //int totalFoodPrice = 0;//flyttad till början av filen
        //Food f = new Food(economyClassFood.get(reader.nextInt()-1).getFoodItem());
        
        //foodSelections innehåller vad passagerarna valde att äta o dricka...
        //...i meny-listorna
        FoodMenu menu = new FoodMenu();
        System.out.println();
        System.out.println("The passenger have chosen this to eat/drink:");
        if (flightType == FlightType.FIRSTCLASS) {            
            ArrayList<Food> firstClassFood = menu.getFirstClassMenu();
            //foodSelections;
            for (int a = 0; a < foodSelections.size(); a++) {//foodSelections.get(a - 1)
                if (foodSelections.get(a) > 0){
                	System.out.println(firstClassFood.get(foodSelections.get(a) - 1));
                    totalFoodPrice = totalFoodPrice + firstClassFood.get(foodSelections.get(a) - 1).getPrice();//ger fel?
                }
                else{
                	System.out.println(firstClassFood.get(foodSelections.get(a)));
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
                	System.out.println(economyClassFood.get(foodSelections.get(a) - 1));
                    totalFoodPrice = totalFoodPrice + economyClassFood.get(foodSelections.get(a) - 1).getPrice();
                }
                else{
                	System.out.println(economyClassFood.get(foodSelections.get(a)));
                    totalFoodPrice = totalFoodPrice + economyClassFood.get(foodSelections.get(a)).getPrice();
                }                
                //lägger till mat folk beställt i en lista
                //foodSelections.get(a - 1)
                foodChoices.add(economyClassFood.get(foodSelections.get(a) - 1));
            }
        }
        
//        customer.setChosenFood(foodSelection, flightType);
        customer.setFoodOrder(foodChoices);//s�tter en lista p� vad kunden best�llt f�r mat
        customer.setFoodOrderPrice(totalFoodPrice);
        int foodPrices = totalFoodPrice;//0;
        System.out.println();
        System.out.println("Total price for all food ordered = " + foodPrices + " kr");
        System.out.println();
        //int foodPrices2 = customer.getFoodOrderPrice(); 
//        if (flightType == FlightType.FIRSTCLASS) {//'FoodMenu.firstClassMenu.get(customer.choseFood)' nedan, tar bort tillfälligt
//            foodPrices = totalFoodPrice;// 200;//FoodMenu.;
//            //FoodMenu.getFirstClassMenu().;//390;//getChoseFood()//exception
//        }
//        else if (flightType == FlightType.ECOCLASS) {//FoodMenu.ecoClassMenu.get(customer.choseFood) tillfälligt borttagit
//            foodPrices = totalFoodPrice;//190;//getChoseFood()//exception
//        }
        
        //int foodPrices = FoodMenu.firstClassMenuOld.get(customer.chosenFood);//getChoseFood()
        //calculate and print total price
        //int foodPrices = 215;//köper mat för 215 kr
        //foodPrices = customer.calculateFoodOrder();
        //if passenger.flightClass = firstClass typ
        
        //int passengerPrice = calcCosts.calculateTotalPassengerPrice(20000, foodPrices);
        int passengerPrice = 0;
        int ticketPrice = 0;
        if (flightType == FlightType.FIRSTCLASS) {
        	ticketPrice = 20000;        	
        }
        else if (flightType == FlightType.ECOCLASS) {
        	ticketPrice = 5000;        	
        }
        passengerPrice = calcCosts.calculateTotalPassengerPrice(ticketPrice, foodPrices);
        
        System.out.println();
        System.out.println("Flight to " + dest + " with passenger " + 
                firstName + " " + surName + " booked.");
        calcCosts.printTotalPassengerPrice(customer, passengerPrice);//skriver ut
        
        //if (flightType)
        //plane.addPassengerToSeat(customer, flightType);
        
//        Seat s = new Seat();
//        s.setSeatedPassenger(customer);
        if (flightType == FlightType.ECOCLASS) {
            if (dest.equals("Honolulu")) {
                flyg.getEcoClassSeats()[flyg.counterEco] = new Seat("B" + flyg.counterEco++, customer);
            }
            else if (dest.equals("Fiji")) {
                flyg2.getEcoClassSeats()[flyg2.counterEco] = new Seat("B" + flyg2.counterEco++, customer);
            }
            else if (dest.equals("Tonga")) {
                flyg3.getEcoClassSeats()[flyg3.counterEco] = new Seat("B" + flyg3.counterEco++, customer);
            }
        }
        else if (flightType == FlightType.FIRSTCLASS) {
            if (dest.equals("Honolulu")) {
                flyg.getfClassSeats()[flyg.counterFirst] = new Seat("A" + flyg.counterFirst++, customer);
            }
            else if (dest.equals("Fiji")) {
                flyg2.getfClassSeats()[flyg2.counterFirst] = new Seat("A" + flyg2.counterFirst++, customer);
            }
            else if (dest.equals("Tonga")) {
                flyg3.getfClassSeats()[flyg3.counterFirst] = new Seat("A" + flyg3.counterFirst++, customer);
            }
        }
        
        
        //från Matildas GUI
        // p = passenger
        // airplaneToUse(pl) = flyg, flyg2, eller flyg3
//        if (ft == FlightType.ECOCLASS) {
//            try {
//                airplaneToUse(pl).getEcoClassSeats()[airplaneToUse(pl).counterEco] = new Seat("B" + airplaneToUse(pl).counterEco++, p);
//
//            } catch (Exception e) {
//                System.out.println(e); //Ska vara ifall det är fullt i arrayen!!!
//            }
//        }
//        if (ft == FlightType.FIRSTCLASS) {
//            try {
//                airplaneToUse(pl).getfClassSeats()[airplaneToUse(pl).counterFirst] = new Seat("A" + airplaneToUse(pl).counterFirst++, p);
//            } catch (Exception e) {
//                System.out.println("Full booked, 5/5"); //Ska vara ifall det är fullt i arrayen!!!
//            }
//        }
        //flyg
    }    
    
    public void airlineInfo() {//FlightType flightType
        CalculateCosts calcCosts = new CalculateCosts();
        Scanner one = new Scanner(System.in);
        int userSelection = 1;
        while(userSelection != 9){
            System.out.println();
            System.out.println("What information about the airline would you like to know?");
            System.out.println("1. Airline income");
            System.out.println("2. Airline profit");
            System.out.println();
            System.out.println("9) Return to previous menu");
            System.out.println("0) Exit AirCom");
            userSelection = one.nextInt();//sc
            //if (userSelection == 1) {

                //arrayPass ska ersättas med en passagerarlista från någon klass
                //int income = calcCosts.calculateAirlineIncome(arrayPass);
            //}
            //menyVal = one.nextInt();

            //båda har flyttats upp till klassen och ändrats namn på
            //int income = 0;
            //int incomeEconomy = 0;
        
        //while(userSelection != 9){
            switch (userSelection) {//menyVal
                case 0:
                    System.exit(0);
                case 1:
                    airlineIncome = 0;
                    airlineIncomeEconomy = 0;
                    if(flyg.counterFirst > 0) {//flyg.getfClassSeats().length > 0
                        airlineIncome = airlineIncome + calcCosts.calculateAirlineIncome2(flyg.getfClassSeats());//, this);
                    }
                    if(flyg2.counterFirst > 0) {
                        airlineIncome = airlineIncome + calcCosts.calculateAirlineIncome2(flyg2.getfClassSeats());//, this);
                    }
                    if(flyg3.counterFirst > 0) {
                        airlineIncome = airlineIncome + calcCosts.calculateAirlineIncome2(flyg3.getfClassSeats());//, this);
                    }
                    if(flyg.counterEco > 0) {//.getEcoClassSeats().length
                        airlineIncomeEconomy = airlineIncomeEconomy + calcCosts.calculateAirlineIncome2(flyg.getEcoClassSeats());//, this);
                    }
                    if(flyg2.counterEco > 0) {
                        airlineIncomeEconomy = airlineIncomeEconomy + calcCosts.calculateAirlineIncome2(flyg2.getEcoClassSeats());//, this);
                    }
                    if(flyg3.counterEco > 0) {
                        airlineIncomeEconomy = airlineIncomeEconomy + calcCosts.calculateAirlineIncome2(flyg3.getEcoClassSeats());//, this);
                    }
                    
                    //dessa 2 bortkommenterade för att använda dom 6 ovan istället. Annars skulle dessa användas med Petrus plan
                    //airlineIncome = calcCosts.calculateAirlineIncome(plane.getFirstClassSeats(), this);//Airline income;
                    //airlineIncomeEconomy = calcCosts.calculateAirlineIncome(plane.getEconomyClassSeats(), this);
                    
                    //airlineIncomeFirst = calcCosts.calculateAirlineIncome(plane.getFirstClassSeats(), this);
                    System.out.println();
                    calcCosts.printAirlineIncome(airlineIncome + airlineIncomeEconomy);// + airlineIncomeFirst);
                    break;
                case 2:
                    airlineIncome = 0;
                    airlineIncomeEconomy = 0;
                    if(flyg.counterFirst > 0) {//flyg.getfClassSeats().length > 0
                        airlineIncome = airlineIncome + calcCosts.calculateAirlineIncome2(flyg.getfClassSeats());//, this);
                    }
                    if(flyg2.counterFirst > 0) {
                        airlineIncome = airlineIncome + calcCosts.calculateAirlineIncome2(flyg2.getfClassSeats());//, this);
                    }
                    if(flyg3.counterFirst > 0) {
                        airlineIncome = airlineIncome + calcCosts.calculateAirlineIncome2(flyg3.getfClassSeats());//, this);
                    }
                    if(flyg.counterEco > 0) {//.getEcoClassSeats().length
                        airlineIncomeEconomy = airlineIncomeEconomy + calcCosts.calculateAirlineIncome2(flyg.getEcoClassSeats());//, this);
                    }
                    if(flyg2.counterEco > 0) {
                        airlineIncomeEconomy = airlineIncomeEconomy + calcCosts.calculateAirlineIncome2(flyg2.getEcoClassSeats());//, this);
                    }
                    if(flyg3.counterEco > 0) {
                        airlineIncomeEconomy = airlineIncomeEconomy + calcCosts.calculateAirlineIncome2(flyg3.getEcoClassSeats());//, this);
                    }
                    
                    //dessa 2 bortkommenterade för att använda dom 6 ovan istället. Annars skulle dessa användas med Petrus plan
                    //airlineIncome = calcCosts.calculateAirlineIncome(plane.getFirstClassSeats(), this);
                    //airlineIncomeEconomy = calcCosts.calculateAirlineIncome(plane.getEconomyClassSeats(), this);
                    
                    //airlineIncomeFirst = calcCosts.calculateAirlineIncome(plane.getFirstClassSeats(), this);
                    System.out.println();
                    calcCosts.printAirlineIncome(airlineIncome + airlineIncomeEconomy);// + airlineIncomeFirst);
                    airlineProfit = calcCosts.calculateAirlineProfit(airlineIncome + airlineIncomeEconomy);// + airlineIncomeFirst);//Airline profit;
                    System.out.println();
                    calcCosts.printAirlineProfit(airlineProfit);
                    break;                
                case 9: //go back to previous menu
                    break;                
            }
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
                    if (firstClassFood.get(a).toString().length() < 5) {//> 20
                        System.out.println((a+1) + ". " + firstClassFood.get(a).toString() + "\t\t\t\t\t\t" + firstClassFood.get(a).getPrice() + " kr");//food
                    }
                    else if (firstClassFood.get(a).toString().length() < 10) {
                        System.out.println((a+1) + ". " + firstClassFood.get(a).toString() + "\t\t\t\t\t" + firstClassFood.get(a).getPrice() + " kr");//food
                    }
                    else if (firstClassFood.get(a).toString().length() > 30) {
                        System.out.println((a+1) + ". " + firstClassFood.get(a).toString() + "\t\t" + firstClassFood.get(a).getPrice() + " kr");
                    }
                    else {
                        System.out.println((a+1) + ". " + firstClassFood.get(a).toString() + "\t\t\t\t" + firstClassFood.get(a).getPrice() + " kr");
                    }
                }

                //Iterator it = FoodMenu.firstClassMenuOld.entrySet().iterator();
                //int i = 0;
                //while (it.hasNext()) {
                //for (String food : FoodMenu.firstClassMenu) {
                //i++;
                //HashMap.Entry pair = (HashMap.Entry) it.next();
                //System.out.println(i + ". " + pair.getKey());//it.toString()
                //}
                System.out.println();
                System.out.println("0. End food menu");
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
                    //System.out.println((a+1) + ". " + economyClassFood.get(a).toString() + "\t\t\t\t" + economyClassFood.get(a).getPrice());
                    if (economyClassFood.get(a).toString().length() < 5) {//> 20
                        System.out.println((a+1) + ". " + economyClassFood.get(a).toString() + "\t\t\t\t\t\t" + economyClassFood.get(a).getPrice() + " kr");//food
                    }
                    else if (economyClassFood.get(a).toString().length() < 10) {
                        System.out.println((a+1) + ". " + economyClassFood.get(a).toString() + "\t\t\t\t\t" + economyClassFood.get(a).getPrice() + " kr");//food
                    }
                    else if (economyClassFood.get(a).toString().length() > 30) {
                        System.out.println((a+1) + ". " + economyClassFood.get(a).toString() + "\t\t" + economyClassFood.get(a).getPrice() + " kr");
                    }
                    else {
                        System.out.println((a+1) + ". " + economyClassFood.get(a).toString() + "\t\t\t\t" + economyClassFood.get(a).getPrice() + " kr");
                    }
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
                System.out.println();
                System.out.println("0. Done ordering. End food menu");
                menyVal = reader.nextInt();
                if (menyVal == 0) {
                    break;
                }
                else {
                    foodChoices.add(menyVal);
                }
            }
            System.out.println();
            //foodChoice = reader.nextInt();            
        }
        return foodChoices;//foodChoice
    }
    
    //temporär metod för att komma åt matpriserna för det passagerarna beställt
    //ska nog ligga i annan klass
    public int getTotalFoodPrice() {
        return totalFoodPrice;
    }
    
    public boolean firstClassChoiceQuestions() {
    	boolean decision = false;
    	Scanner scanner = new Scanner(System.in);
    	System.out.println();
		System.out.println("Unfortunately all seats in first class are full.");
		System.out.println("Would you like to travel in Economy class instead? ['y' or 'n']");
		availableReply = scanner.nextLine();
		if (availableReply.equalsIgnoreCase("n")) {
			System.out.println("You don't want to travel economy class either. Do you want to cancel the flight? ['y' or 'n']");
			availableReply = scanner.nextLine();
			if (availableReply.equalsIgnoreCase("y")) {
				System.exit(0);
			}
		}
		else if (availableReply.equalsIgnoreCase("y")) {
			decision = true;
		}
		return decision;
    }
    
    public boolean economyClassChoiceQuestions() {
    	boolean decision = false;
    	Scanner scanner = new Scanner(System.in);
    	System.out.println();
		System.out.println("Unfortunately all seats in economy class are full.");
		System.out.println("Would you like to travel in First class instead? ['y' or 'n']");
		availableReply = scanner.nextLine();
		if (availableReply.equalsIgnoreCase("n")) {
			System.out.println("You don't want to travel first class either. Do you want to cancel the flight? ['y' or 'n']");
			availableReply = scanner.nextLine();
			if (availableReply.equalsIgnoreCase("y")) {
				System.exit(0);
			}
		}
		else if (availableReply.equalsIgnoreCase("y")) {
			decision = true;
		}
		return decision;
    }
    
    public void fillSeats() {
    	Random rnd = new Random();
    	int r = rnd.nextInt(5);
    	
        
        //if (flightType == FlightType.ECOCLASS) {
            Passenger customerE;
            for(int i = 0; i < r; i++) {
                customerE = new Passenger(FlightType.ECOCLASS, true, "Mrs", "Y" + i, 650410013, phoneNumber, GenderType.FEMALE);
//                if (dest.equals("Honolulu")) {
                    flyg.getEcoClassSeats()[flyg.counterEco] = new Seat("B" + flyg.counterEco++, customerE);
                //} else if (dest.equals("Fiji")) {
                    flyg2.getEcoClassSeats()[flyg2.counterEco] = new Seat("B" + flyg2.counterEco++, customerE);
                //} else if (dest.equals("Tonga")) {
                    flyg3.getEcoClassSeats()[flyg3.counterEco] = new Seat("B" + flyg3.counterEco++, customerE);
                //}
            }
            //customer = new Passenger(FlightType.FIRSTCLASS, true, "Mrs", "Y" + i, 650410013, phoneNumber, GenderType.FEMALE);
            
        //}
        //else if (flightType == FlightType.FIRSTCLASS) {
            Passenger customerF;
            for(int i = 0; i < r; i++) {
                customerF = new Passenger(FlightType.FIRSTCLASS, true, "Mr", "X" + i, 650410013, phoneNumber, GenderType.MALE);
                
                //if (dest.equals("Honolulu")) {
                    flyg.getfClassSeats()[flyg.counterFirst] = new Seat("A" + flyg.counterFirst++, customerF);
                //} else if (dest.equals("Fiji")) {
                    flyg2.getfClassSeats()[flyg2.counterFirst] = new Seat("A" + flyg2.counterFirst++, customerF);
                //} else if (dest.equals("Tonga")) {
                    flyg3.getfClassSeats()[flyg3.counterFirst] = new Seat("A" + flyg3.counterFirst++, customerF);
                //}
            }
            
            
        //}
    }
}
