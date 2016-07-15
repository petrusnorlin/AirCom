/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aircom;


import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;

/**
 *
 * @author User
 */
//TODO LÄGG IN VIEW RESERVATIONS , ALLA FLYGS RESERVATIONER I EGEN KNAPP
//TODO MENYERNA DUBBLERAS VID VARJE FOCUSGAINED PÅ RADIOBUTTON...FIXA!!!!!
public class BookingFrame extends javax.swing.JFrame {

    //DestinationType[] destinations = {DestinationType.HONOLULU, DestinationType.FIJI, DestinationType.TONGA};
    ArrayList<Passenger> passengerlist = new ArrayList<Passenger>();
    Passenger p;
    int pl;
    Airplane air1 = new Airplane("HOLU123", DestinationType.HONOLULU);
    Airplane air2 = new Airplane("FIJ456", DestinationType.FIJI);
    Airplane air3 = new Airplane("TON789", DestinationType.TONGA);
    String destination;
    DefaultListModel dlm = new DefaultListModel();//Denna kommer användas till foodmenu
    
    
    
    public void calculateSelectedFoodCosts()
    {
        ListModel list = jListSelectedFoods.getModel();
    for(int i = 0; i < list.getSize(); i++){
        System.out.println(list.getElementAt(i));

        }
       for(int index : jListSelectedFoods.getSelectedIndices()) 
       {
        System.out.println(dlm2.getElementAt(index));
       }
                 
    }
    
    public void printToRightTextArea4ECO (int pl)
        {
        if (pl ==1)//håller koll på destination alltså vilken ruta den ska in i.
        {
            
         jTextAreaShowBookingHo.setText(airplaneToUse(pl).printOutSeatsReservationsReturningString());
        //jTextAreaShowBooking.setText((airplaneToUse(pl).getEcoClassSeats()[airplaneToUse(pl).counterEco]).toString());//Innan såg de ut så o då skriver den bara ut Det aktuella Seat.
        }
        if (pl == 2)
        {
            
        jTextShowingBookingsFI.setText(airplaneToUse(pl).printOutSeatsReservationsReturningString());
        } 
        if(pl == 3)
        {
        jTextAreaShowingBookingsTo.setText(airplaneToUse(pl).printOutSeatsReservationsReturningString());
        }
        }
    
    public void printToRightTextArea4First (int pl)
        {
        if (pl ==1)
        {
         jTextAreaShowBookingHo.setText(airplaneToUse(pl).printOutSeatsReservationsReturningString());
        }
        if (pl == 2)
        {
        jTextShowingBookingsFI.setText(airplaneToUse(pl).printOutSeatsReservationsReturningString());
        } 
        if(pl == 3)
        {
        jTextAreaShowingBookingsTo.setText(airplaneToUse(pl).printOutSeatsReservationsReturningString());
        }
        }
    
    
    public void printOutSeatAvailbility() {
        jLabelFlight.setText("Flight " + airplaneToUse(pl).getPlane());
        jLabelDeparture.setText("Departure: " + airplaneToUse(pl).getDeparture());
        jLabelArrival.setText("Arrival: " + airplaneToUse(pl).getArrival());
        jLabelSeatsAvailFIRST.setText("Available: " + airplaneToUse(pl).seatAvailabilityFirst() + "\\" + 5);
        jLabelSeatAvailEco.setText("Available: " + airplaneToUse(pl).seatAvailabilityECO() + "\\" + 5);

    }

    //METODER
    public String printOutPassengerList(Passenger pa) {//HÄR SKA DU SKRIVA UT  ÄVEN FLIGHTID O SEATPLATS!!!!
        StringBuilder builder = new StringBuilder();
        for (Passenger passenger : passengerlist) {
            //jTextAreaShowBooking.setText(passenger + "\n");
            builder.append(passenger).append("\n"); // <---- FÖR VARJE LOOP passenger.toString() + radbrytning!!!
            //System.out.println(pa);
        }
        return builder.toString();
    }

    public Airplane airplaneToUse(int i) {
        if (i == 1) {
            return air1;
        } else if (i == 2) {
            return air2;
        } else if (i == 3) {
            return air3;
        } else {
            return null;
        }
    }

    public void registerPassanger(Airplane air) {
        FlightType ft = null;
        Boolean eat;
        String fname;
        String lname;
        int persnr;
        String phonenr;
        //String emailadr;
        GenderType gt = null;
        Seat seat;

        if(airplaneToUse(pl).seatAvailabilityFirst() == 0)
        {
            jRadioButton1stC.setEnabled(false);
            
        jLabelSeatsAvailFIRST.setText("Full booked");}
        
        if((airplaneToUse(pl).seatAvailabilityFirst() == 0)&&(airplaneToUse(pl).seatAvailabilityECO() == 0))
        {
        Thread takeOffHo =new Thread(airplaneToUse(pl));
          takeOffHo.start();
        }
        if (jRadioButton1stC.isSelected()) {
            ft = FlightType.FIRSTCLASS;
        }
         if(airplaneToUse(pl).seatAvailabilityECO() == 0)
         {
             jRadioButtonEcoCl.setEnabled(false);
          
         jLabelSeatAvailEco.setText("Full booked");}
         if((airplaneToUse(pl).seatAvailabilityFirst() == 0)&&(airplaneToUse(pl).seatAvailabilityECO() == 0))
        {
        Thread takeOffHo =new Thread(airplaneToUse(pl));
          takeOffHo.start();
        }
        if (jRadioButtonEcoCl.isSelected()) {
            ft = FlightType.ECOCLASS;
        }
        
//        if (jCheckBoxForFood.isSelected() == true) {
//            eat = true;
//        } else {
//            eat = false;
//        }

        //if(jTextField_FirstName.getText() == "")
        fname = jTextField_FirstName.getText();
        lname = jTextField_LastName.getText();
        persnr = (Integer.parseInt(jTextField_PersonalIdentityNr.getText()));
        phonenr = jTextField_MobileNr.getText();
        //emailadr = jTextField_EmailAdr.getText();

        if (jRadioButtonFemale.isSelected()) {
            gt = GenderType.FEMALE;
        }
        if (jRadioButtonMale.isSelected()) {
            gt = GenderType.MALE;
        }
        if (jRadioButtonOther.isSelected()) {
            gt = GenderType.OTHER;
        }

        p = new Passenger(ft, fname, lname, persnr, phonenr, gt);
        passengerlist.add(p);

        if (ft == FlightType.ECOCLASS) {
            try {
           //Seat seat1=     new Seat("B" + airplaneToUse(pl).counterEco++, p);
                airplaneToUse(pl).getEcoClassSeats()[airplaneToUse(pl).counterEco] = new Seat("B" + airplaneToUse(pl).counterEco++, p);
                printToRightTextArea4ECO(pl);
                

            } catch (Exception e) {
                System.out.println(e); //Ska vara ifall det är fullt i arrayen!!!
            }
        }
        if (ft == FlightType.FIRSTCLASS) {
            try {
                airplaneToUse(pl).getfClassSeats()[airplaneToUse(pl).counterFirst] = new Seat("A" + airplaneToUse(pl).counterFirst++, p);
                printToRightTextArea4First(pl);
            } catch (Exception e) {
                System.out.println("Full booked, 5/5"); //Ska vara ifall det är fullt i arrayen!!!
            }
        }
        
        
       // jTextAreaShowBooking.setText("Reservations: " + "\n" + printOutPassengerList(p));
        System.out.println("");

        //airplaneToUse(pl).printOutEcoSeatsReservations();//skriver ut till consol som för testning
        //airplaneToUse(pl).printOutFirstClassSeatsReservations();//-||-
        //FlightManager.passengerList.add(p);
//        jTextAreaShowBooking.setText("Order summary:" + "\n" + "Full name: " + fname + " " + lname + 
//                "\n" + "Personal Identity Number: " + persnr +"\n" + "Mobile phone number: " + phonenr);        
//        for (Passenger passenger : passengerlist) {
//            jTextAreaShowBooking.setText(passenger + "\n");
//            System.out.println(p);
//        }
//        for (Passenger passenger : FlightManager.passengerList) {
//            jTextAreaShowBooking.setText(passenger + "\n");
//            System.out.println(p);
//    }   
    }

    /**
     * Creates new form BookingFrame
     */
    public BookingFrame() {

        initComponents();

        jListFoodMenu.setModel(dlm);
        
//------------------------SAMIS om allt skulle enablas eftersom------------------------------
//        java.awt.event.MouseAdapter mouseAdapter = new java.awt.event.MouseAdapter() {
//            public void mouseClicked(java.awt.event.MouseEvent evt) {
//                jCheckBoxForFood.setEnabled(true);
//                jTextField_FirstName.setEnabled(true);
//                jTextField_LastName.setEnabled(true);
//            }
//        };
//        jRadioButton1stC.addMouseListener(mouseAdapter);
//        jCheckBoxForFood.addMouseListener(mouseAdapter);
//        jTextField_FirstName.addMouseListener(mouseAdapter);
//        jTextField_LastName.addMouseListener(mouseAdapter);
//-------------------------------------------------------------------------------------------------
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jRadioButton1stC = new javax.swing.JRadioButton();
        jRadioButtonEcoCl = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jTextField_LastName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField_FirstName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jRadioButtonFemale = new javax.swing.JRadioButton();
        jRadioButtonMale = new javax.swing.JRadioButton();
        jRadioButtonOther = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jTextField_PersonalIdentityNr = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField_MobileNr = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jLabelRequiredfn = new javax.swing.JLabel();
        jLabelRequiredln = new javax.swing.JLabel();
        jLabelRequiredpnr = new javax.swing.JLabel();
        jLabelRequiredmnr = new javax.swing.JLabel();
        jComboBoxSelectDestination = new javax.swing.JComboBox<>();
        jLabelFlight = new javax.swing.JLabel();
        jLabelDeparture = new javax.swing.JLabel();
        jLabelArrival = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaShowBookingHo = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListFoodMenu = new javax.swing.JList<>();
        jLabelSeatsAvailFIRST = new javax.swing.JLabel();
        jLabelSeatAvailEco = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextShowingBookingsFI = new javax.swing.JTextArea();
        jLabelFiPaLi = new javax.swing.JLabel();
        jLabelHoPaLi = new javax.swing.JLabel();
        jLabelToPaLi = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextAreaShowingBookingsTo = new javax.swing.JTextArea();
        TakeOffHO = new javax.swing.JButton();
        TakeOffFI = new javax.swing.JButton();
        TakeOffTO = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        jButtonSelectFood = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jListSelectedFoods = new javax.swing.JList<>();
        jButtonRemoveFood = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Jokerman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 204));
        jLabel1.setText("Welcome to AirCom");
        jLabel1.setToolTipText("");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Jokerman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 204, 0));
        jLabel2.setText("up n Rise to Paradise!");
        jLabel2.setToolTipText("");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Choose Class:");
        jLabel3.setToolTipText("");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 90, 20));

        buttonGroup1.add(jRadioButton1stC);
        jRadioButton1stC.setText("1st Class");
        jRadioButton1stC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jRadioButton1stCFocusGained(evt);
            }
        });
        getContentPane().add(jRadioButton1stC, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, -1, -1));

        buttonGroup1.add(jRadioButtonEcoCl);
        jRadioButtonEcoCl.setText("ECO Class");
        jRadioButtonEcoCl.setToolTipText("");
        jRadioButtonEcoCl.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jRadioButtonEcoClFocusGained(evt);
            }
        });
        getContentPane().add(jRadioButtonEcoCl, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 160, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Firstname:");
        jLabel4.setToolTipText("");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, -1, -1));
        getContentPane().add(jTextField_LastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 290, 160, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Lastname:");
        jLabel5.setToolTipText("");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, -1, -1));
        getContentPane().add(jTextField_FirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 170, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Gender:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, -1, -1));

        buttonGroup2.add(jRadioButtonFemale);
        jRadioButtonFemale.setText("Female");
        jRadioButtonFemale.setToolTipText("");
        getContentPane().add(jRadioButtonFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, -1, -1));

        buttonGroup2.add(jRadioButtonMale);
        jRadioButtonMale.setText("Male");
        getContentPane().add(jRadioButtonMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, -1, -1));

        buttonGroup2.add(jRadioButtonOther);
        jRadioButtonOther.setText("Other");
        jRadioButtonOther.setToolTipText("");
        getContentPane().add(jRadioButtonOther, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Personal Identity Nr:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 340, -1, -1));

        jTextField_PersonalIdentityNr.setToolTipText("");
        getContentPane().add(jTextField_PersonalIdentityNr, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 360, 160, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Mobile phone number:");
        jLabel8.setToolTipText("");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, -1, -1));

        jTextField_MobileNr.setToolTipText("");
        getContentPane().add(jTextField_MobileNr, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, 170, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Menu");
        jLabel10.setToolTipText("");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 470, -1, 20));

        jButton1.setText("BOOK TICKET");
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 660, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 1020, 30));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aircom/images/paradise.png"))); // NOI18N
        jLabel11.setText("jLabel11");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 350, 80));

        jLabelRequiredfn.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabelRequiredfn.setForeground(new java.awt.Color(255, 51, 51));
        jLabelRequiredfn.setText("WarningNotCorrectFname");
        jLabelRequiredfn.setToolTipText("");
        getContentPane().add(jLabelRequiredfn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, -1, -1));

        jLabelRequiredln.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabelRequiredln.setForeground(new java.awt.Color(255, 51, 51));
        jLabelRequiredln.setText("WarningNotCorrectLname");
        jLabelRequiredln.setToolTipText("");
        getContentPane().add(jLabelRequiredln, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, -1, -1));

        jLabelRequiredpnr.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabelRequiredpnr.setForeground(new java.awt.Color(255, 51, 51));
        jLabelRequiredpnr.setText("WarningNotCorrectPnr");
        jLabelRequiredpnr.setToolTipText("");
        getContentPane().add(jLabelRequiredpnr, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 390, -1, -1));

        jLabelRequiredmnr.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabelRequiredmnr.setForeground(new java.awt.Color(255, 51, 51));
        jLabelRequiredmnr.setText("WarningNotCorrectMobnr");
        getContentPane().add(jLabelRequiredmnr, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 390, -1, -1));

        jComboBoxSelectDestination.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select destination", "HONOLULU", "FIJI", "TONGA" }));
        jComboBoxSelectDestination.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSelectDestinationActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxSelectDestination, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));
        getContentPane().add(jLabelFlight, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        jLabelDeparture.setToolTipText("");
        getContentPane().add(jLabelDeparture, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, -1, -1));

        jLabelArrival.setToolTipText("");
        getContentPane().add(jLabelArrival, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, -1, -1));

        jTextAreaShowBookingHo.setColumns(20);
        jTextAreaShowBookingHo.setRows(5);
        jScrollPane1.setViewportView(jTextAreaShowBookingHo);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 140, 170, 120));

        jScrollPane2.setViewportView(jListFoodMenu);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 490, 160, 160));
        getContentPane().add(jLabelSeatsAvailFIRST, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, -1, -1));

        jLabelSeatAvailEco.setToolTipText("");
        getContentPane().add(jLabelSeatAvailEco, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 190, -1, -1));

        jTextShowingBookingsFI.setColumns(20);
        jTextShowingBookingsFI.setRows(5);
        jScrollPane3.setViewportView(jTextShowingBookingsFI);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 340, 170, 110));

        jLabelFiPaLi.setText("FIJI Flight Passanger list:");
        getContentPane().add(jLabelFiPaLi, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 320, -1, -1));

        jLabelHoPaLi.setText("HONOLULU Flight Passenger list:");
        jLabelHoPaLi.setToolTipText("");
        getContentPane().add(jLabelHoPaLi, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 120, -1, -1));

        jLabelToPaLi.setText("TONGA Flight Passenger list:");
        jLabelToPaLi.setToolTipText("");
        getContentPane().add(jLabelToPaLi, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 520, -1, -1));

        jTextAreaShowingBookingsTo.setColumns(20);
        jTextAreaShowingBookingsTo.setRows(5);
        jScrollPane4.setViewportView(jTextAreaShowingBookingsTo);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 540, 170, 110));

        TakeOffHO.setText("TakeOff");
        TakeOffHO.setToolTipText("");
        TakeOffHO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TakeOffHOActionPerformed(evt);
            }
        });
        getContentPane().add(TakeOffHO, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 270, 80, -1));

        TakeOffFI.setText("TakeOff");
        TakeOffFI.setToolTipText("");
        TakeOffFI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TakeOffFIActionPerformed(evt);
            }
        });
        getContentPane().add(TakeOffFI, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 460, 80, -1));

        TakeOffTO.setText("TakeOff");
        TakeOffTO.setToolTipText("");
        TakeOffTO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TakeOffTOActionPerformed(evt);
            }
        });
        getContentPane().add(TakeOffTO, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 660, 80, -1));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 580, 10));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("1. SELECT DESTINATION");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("2. PERSONAL INFORMATION");
        jLabel12.setToolTipText("");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 570, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("3. FOOD RESERVATION (OPTIONAL)");
        jLabel13.setToolTipText("");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Preview order:");
        jLabel14.setToolTipText("");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 470, -1, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setEnabled(false);
        jTextArea1.setFocusCycleRoot(true);
        jScrollPane6.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 490, 180, 160));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Receipt:");
        jLabel15.setToolTipText("");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 470, -1, -1));

        jButtonSelectFood.setText("Select>>");
        jButtonSelectFood.setToolTipText("");
        jButtonSelectFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelectFoodActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSelectFood, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 490, 100, -1));

        jListSelectedFoods.setToolTipText("");
        jScrollPane7.setViewportView(jListSelectedFoods);

        getContentPane().add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 490, 150, 160));

        jButtonRemoveFood.setText("<<Remove");
        jButtonRemoveFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveFoodActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRemoveFood, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 520, 100, -1));

        jButton5.setText("Test print selection");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 330, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        registerPassanger(air1);
        jComboBoxSelectDestinationActionPerformed(evt);//FICK HJÄLP AV MATTIAS ATT KALLA PÅ EVENTET IGEN, typ blir som att refreasha ComboBox..

        //persnr= (int)(Double.parseDouble(jTextField_PersonalIdentityNr.getText()));

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBoxSelectDestinationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSelectDestinationActionPerformed
        //if(jComboBoxSelectDestination.getSelectedItem()== "HONOLULU")

        String SelectedValue = jComboBoxSelectDestination.getSelectedItem().toString();
        // Display
        switch (SelectedValue) {
            case "HONOLULU":
                jLabelFlight.setText("Flight: " + air1.getPlane());
                jLabelDeparture.setText("D: " + air1.getDeparture());
                jLabelArrival.setText("A: " + air1.getArrival());
                pl = 1;
                printOutSeatAvailbility();
                //airplaneToUse(pl).printOutEcoSeatsReservations();
                //airplaneToUse(pl).printOutFirstClassSeatsReservations();
                break;
            case "FIJI":
                jLabelFlight.setText("Flight: " + air2.getPlane());
                jLabelDeparture.setText("D: " + air2.getDeparture());
                jLabelArrival.setText("A: " + air2.getArrival());
                pl = 2;
                printOutSeatAvailbility();
                //airplaneToUse(pl).printOutEcoSeatsReservations();
                //airplaneToUse(pl).printOutFirstClassSeatsReservations();
                break;
            case "TONGA":
                jLabelFlight.setText("Flight: " + air3.getPlane());
                jLabelDeparture.setText("D: " + air3.getDeparture());
                jLabelArrival.setText("A: " + air3.getArrival());
                pl = 3;
                printOutSeatAvailbility();
                //airplaneToUse(pl).printOutEcoSeatsReservations();
                //airplaneToUse(pl).printOutFirstClassSeatsReservations();
                break;
            default:
                jLabelFlight.setText("");
        }

    }//GEN-LAST:event_jComboBoxSelectDestinationActionPerformed

    private void jRadioButton1stCFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jRadioButton1stCFocusGained

     
    dlm.clear();
        for (Food f : new FoodMenu().getFirstClassMenu()) {
            dlm.addElement(f);
            //dlm.addElement(f.getFoodItem() + "  " + f.getPrice() + "kr");
        }
    }//GEN-LAST:event_jRadioButton1stCFocusGained

    private void jRadioButtonEcoClFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jRadioButtonEcoClFocusGained

      //jListFoodMenu.removeAll(); Funkar inte!!
      dlm.removeAllElements();
        for (Food f : new FoodMenu().getEcoClassMenu()) {
            dlm.addElement(f);
            //dlm.addElement(f.getFoodItem() + "  " + f.getPrice() + "kr");
        }
    }//GEN-LAST:event_jRadioButtonEcoClFocusGained
    DefaultListModel dlm2 = new DefaultListModel();
    private void jButtonSelectFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelectFoodActionPerformed
        dlm2.addElement(jListFoodMenu.getSelectedValue());
        jListSelectedFoods.setModel(dlm2);
        
    }//GEN-LAST:event_jButtonSelectFoodActionPerformed

    private void jButtonRemoveFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveFoodActionPerformed
        int index = jListSelectedFoods.getSelectedIndex();
        dlm2.removeElementAt(index);
    }//GEN-LAST:event_jButtonRemoveFoodActionPerformed
    
    ArrayList<Food> ar;   
    ListModel list;
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
         list = jListSelectedFoods.getModel();
        for(int i = 0; i < list.getSize(); i++){
        Object obj = list.getElementAt(i);
            System.out.println(((Food)obj).getPrice());
}
  
    }//GEN-LAST:event_jButton5ActionPerformed

    
    private void TakeOffHOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TakeOffHOActionPerformed
        Thread takeOffHo =new Thread(air1);
        takeOffHo.start();
        
    }//GEN-LAST:event_TakeOffHOActionPerformed

    private void TakeOffFIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TakeOffFIActionPerformed
        Thread takeOffHo =new Thread(air2);
        takeOffHo.start();
    }//GEN-LAST:event_TakeOffFIActionPerformed

    private void TakeOffTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TakeOffTOActionPerformed
        Thread takeOffHo =new Thread(air3);
        takeOffHo.start();
    }//GEN-LAST:event_TakeOffTOActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BookingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookingFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton TakeOffFI;
    private javax.swing.JButton TakeOffHO;
    private javax.swing.JButton TakeOffTO;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButtonRemoveFood;
    private javax.swing.JButton jButtonSelectFood;
    private javax.swing.JComboBox<String> jComboBoxSelectDestination;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelArrival;
    private javax.swing.JLabel jLabelDeparture;
    private javax.swing.JLabel jLabelFiPaLi;
    private javax.swing.JLabel jLabelFlight;
    private javax.swing.JLabel jLabelHoPaLi;
    private javax.swing.JLabel jLabelRequiredfn;
    private javax.swing.JLabel jLabelRequiredln;
    private javax.swing.JLabel jLabelRequiredmnr;
    private javax.swing.JLabel jLabelRequiredpnr;
    private javax.swing.JLabel jLabelSeatAvailEco;
    private javax.swing.JLabel jLabelSeatsAvailFIRST;
    private javax.swing.JLabel jLabelToPaLi;
    private javax.swing.JList<String> jListFoodMenu;
    private javax.swing.JList<String> jListSelectedFoods;
    private javax.swing.JRadioButton jRadioButton1stC;
    private javax.swing.JRadioButton jRadioButtonEcoCl;
    private javax.swing.JRadioButton jRadioButtonFemale;
    private javax.swing.JRadioButton jRadioButtonMale;
    private javax.swing.JRadioButton jRadioButtonOther;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextAreaShowBookingHo;
    private javax.swing.JTextArea jTextAreaShowingBookingsTo;
    private javax.swing.JTextField jTextField_FirstName;
    private javax.swing.JTextField jTextField_LastName;
    private javax.swing.JTextField jTextField_MobileNr;
    private javax.swing.JTextField jTextField_PersonalIdentityNr;
    private javax.swing.JTextArea jTextShowingBookingsFI;
    // End of variables declaration//GEN-END:variables
}
