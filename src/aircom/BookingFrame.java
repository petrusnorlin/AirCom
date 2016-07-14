/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aircom;

import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author User
 */
//TODO LÄGG IN VIEW RESERVATIONS , ALLA FLYGS RESERVATIONER I EGEN KNAPP
//TODO MENYERNA DUBBLERAS VID VARJE FOCUSGAINED PÅ RADIOBUTTON...FIXA!!!!!
public class BookingFrame extends javax.swing.JFrame {

    DestinationType[] destinations = {DestinationType.HONOLULU, DestinationType.FIJI, DestinationType.TONGA};
    ArrayList<Passenger> passengerlist = new ArrayList<Passenger>();
    Passenger p;
    int pl;
    Airplane air1 = new Airplane("HOLU123", DestinationType.HONOLULU);
    Airplane air2 = new Airplane("FIJ456", DestinationType.FIJI);
    Airplane air3 = new Airplane("TON789", DestinationType.TONGA);
    String destination;
    DefaultListModel dlm = new DefaultListModel();//Denna kommer användas till foodmenu

    public void printOutSeatAvailbility() {
        jLabelFlight.setText("Flight " + airplaneToUse(pl).getPlane());
        jLabelDeparture.setText("Departure" + airplaneToUse(pl).getDeparture());
        jLabelArrival.setText("Arrival" + airplaneToUse(pl).getArrival());
        jLabelSeatsAvailFIRST.setText("1st Class seats available " + airplaneToUse(pl).seatAvailabilityFirst() + "\\" + 5);
        jLabelSeatAvailEco.setText("ECO Class seats available " + airplaneToUse(pl).seatAvailabilityECO() + "\\" + 5);

    }

    //METODER
    public String printOutPassengerList(Passenger pa) {
        StringBuilder builder = new StringBuilder();
        for (Passenger passenger : passengerlist) {
            //jTextAreaShowBooking.setText(passenger + "\n");
            builder.append(passenger).append("\n");
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
        String emailadr;
        GenderType gt = null;
        Seat seat;

        if (jRadioButton1stC.isSelected()) {
            ft = FlightType.FIRSTCLASS;

        }
        if (jRadioButtonEcoCl.isSelected()) {
            ft = FlightType.ECOCLASS;

        }
        if (jCheckBoxForFood.isSelected() == true) {
            eat = true;
        } else {
            eat = false;
        }

        //if(jTextField_FirstName.getText() == "")
        fname = jTextField_FirstName.getText();
        lname = jTextField_LastName.getText();
        persnr = (Integer.parseInt(jTextField_PersonalIdentityNr.getText()));
        phonenr = jTextField_MobileNr.getText();
        emailadr = jTextField_EmailAdr.getText();

        if (jRadioButtonFemale.isSelected()) {
            gt = GenderType.FEMALE;
        }
        if (jRadioButtonMale.isSelected()) {
            gt = GenderType.MALE;
        }
        if (jRadioButtonOther.isSelected()) {
            gt = GenderType.OTHER;
        }

        p = new Passenger(ft, eat, fname, lname, persnr, phonenr, gt);
        passengerlist.add(p);

        if (ft == FlightType.ECOCLASS) {
            try {
                airplaneToUse(pl).getEcoClassSeats()[airplaneToUse(pl).counterEco] = new Seat("B" + airplaneToUse(pl).counterEco++, p);

            } catch (Exception e) {
                System.out.println(e); //Ska vara ifall det är fullt i arrayen!!!
            }
        }
        if (ft == FlightType.FIRSTCLASS) {
            try {
                airplaneToUse(pl).getfClassSeats()[airplaneToUse(pl).counterFirst] = new Seat("A" + airplaneToUse(pl).counterFirst++, p);
            } catch (Exception e) {
                System.out.println(e); //Ska vara ifall det är fullt i arrayen!!!
            }
        }

        jTextAreaShowBooking.setText("Reservations: " + "\n" + printOutPassengerList(p));
        System.out.println("");

        //airplaneToUse(pl).printOutEcoSeatsReservations();
        //airplaneToUse(pl).printOutFirstClassSeatsReservations();
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

        java.awt.event.MouseAdapter mouseAdapter = new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBoxForFood.setEnabled(true);
                jTextField_FirstName.setEnabled(true);
                jTextField_LastName.setEnabled(true);
            }
        };
        jRadioButton1stC.addMouseListener(mouseAdapter);
        jCheckBoxForFood.addMouseListener(mouseAdapter);
        jTextField_FirstName.addMouseListener(mouseAdapter);
        jTextField_LastName.addMouseListener(mouseAdapter);

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
        jLabel9 = new javax.swing.JLabel();
        jTextField_EmailAdr = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jCheckBoxForFood = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jLabelRequiredfn = new javax.swing.JLabel();
        jLabelRequiredCl = new javax.swing.JLabel();
        jLabelRequiredln = new javax.swing.JLabel();
        jLabelRequiredpnr = new javax.swing.JLabel();
        jLabelRequiredmnr = new javax.swing.JLabel();
        jLabelRequiredMail = new javax.swing.JLabel();
        jLabelRequiredGender = new javax.swing.JLabel();
        jComboBoxSelectDestination = new javax.swing.JComboBox<>();
        jLabelFlight = new javax.swing.JLabel();
        jLabelDeparture = new javax.swing.JLabel();
        jLabelArrival = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaShowBooking = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListFoodMenu = new javax.swing.JList<>();
        jLabelSeatsAvailFIRST = new javax.swing.JLabel();
        jLabelSeatAvailEco = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Jokerman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 204));
        jLabel1.setText("Welcome to AirCom!");
        jLabel1.setToolTipText("");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Jokerman", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("One way ticket to Honolulu, Hawaii!");
        jLabel2.setToolTipText("");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Choose Class:");
        jLabel3.setToolTipText("");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 90, 20));

        buttonGroup1.add(jRadioButton1stC);
        jRadioButton1stC.setText("1st Class");
        jRadioButton1stC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jRadioButton1stCFocusGained(evt);
            }
        });
        getContentPane().add(jRadioButton1stC, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, -1, -1));

        buttonGroup1.add(jRadioButtonEcoCl);
        jRadioButtonEcoCl.setText("ECO Class");
        jRadioButtonEcoCl.setToolTipText("");
        jRadioButtonEcoCl.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jRadioButtonEcoClFocusGained(evt);
            }
        });
        getContentPane().add(jRadioButtonEcoCl, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Firstname:");
        jLabel4.setToolTipText("");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, -1, -1));
        getContentPane().add(jTextField_LastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 230, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Lastname:");
        jLabel5.setToolTipText("");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, -1, -1));
        getContentPane().add(jTextField_FirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 230, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Gender:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 650, -1, -1));

        buttonGroup2.add(jRadioButtonFemale);
        jRadioButtonFemale.setText("Female");
        jRadioButtonFemale.setToolTipText("");
        getContentPane().add(jRadioButtonFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 650, -1, -1));

        buttonGroup2.add(jRadioButtonMale);
        jRadioButtonMale.setText("Male");
        getContentPane().add(jRadioButtonMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 650, -1, -1));

        buttonGroup2.add(jRadioButtonOther);
        jRadioButtonOther.setText("Other");
        jRadioButtonOther.setToolTipText("");
        getContentPane().add(jRadioButtonOther, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 650, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Personal Identity Nr:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, -1, -1));

        jTextField_PersonalIdentityNr.setToolTipText("");
        getContentPane().add(jTextField_PersonalIdentityNr, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, 230, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Mobile phone number:");
        jLabel8.setToolTipText("");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, -1, -1));

        jTextField_MobileNr.setToolTipText("");
        getContentPane().add(jTextField_MobileNr, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, 230, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Email adress:");
        jLabel9.setToolTipText("");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 570, -1, -1));

        jTextField_EmailAdr.setToolTipText("");
        getContentPane().add(jTextField_EmailAdr, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 590, 230, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Make food reservations:");
        jLabel10.setToolTipText("");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, 20));
        getContentPane().add(jCheckBoxForFood, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 40, 40));

        jButton1.setText("Next");
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 690, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 830, 30));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aircom/images/paradise.png"))); // NOI18N
        jLabel11.setText("jLabel11");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 350, 80));

        jLabelRequiredfn.setText("WarningNotCorrectFname");
        jLabelRequiredfn.setToolTipText("");
        getContentPane().add(jLabelRequiredfn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, -1, -1));

        jLabelRequiredCl.setText("WarningNoClassChosen");
        jLabelRequiredCl.setToolTipText("");
        getContentPane().add(jLabelRequiredCl, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 280, 120, 20));

        jLabelRequiredln.setText("WarningNotCorrectLname");
        jLabelRequiredln.setToolTipText("");
        getContentPane().add(jLabelRequiredln, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, -1, -1));

        jLabelRequiredpnr.setText("WarningNotCorrectPnr");
        jLabelRequiredpnr.setToolTipText("");
        getContentPane().add(jLabelRequiredpnr, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 470, -1, -1));

        jLabelRequiredmnr.setText("WarningNotCorrectMobnr");
        getContentPane().add(jLabelRequiredmnr, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 520, -1, -1));

        jLabelRequiredMail.setText("WarningNotCorrectEmail");
        jLabelRequiredMail.setToolTipText("");
        getContentPane().add(jLabelRequiredMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 570, -1, -1));

        jLabelRequiredGender.setText("WarningNoGenderChosen");
        jLabelRequiredGender.setToolTipText("");
        getContentPane().add(jLabelRequiredGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 650, -1, -1));

        jComboBoxSelectDestination.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select destination", "HONOLULU", "FIJI", "TONGA" }));
        jComboBoxSelectDestination.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSelectDestinationActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxSelectDestination, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        jLabelFlight.setText("FlightID");
        getContentPane().add(jLabelFlight, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, -1, -1));

        jLabelDeparture.setText("Departure");
        jLabelDeparture.setToolTipText("");
        getContentPane().add(jLabelDeparture, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, -1, -1));

        jLabelArrival.setText("Arrival");
        jLabelArrival.setToolTipText("");
        getContentPane().add(jLabelArrival, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, -1, -1));

        jTextAreaShowBooking.setColumns(20);
        jTextAreaShowBooking.setRows(5);
        jScrollPane1.setViewportView(jTextAreaShowBooking);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 500, 310, 140));

        jScrollPane2.setViewportView(jListFoodMenu);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 180, 310, 200));

        jLabelSeatsAvailFIRST.setText("jLabel13");
        getContentPane().add(jLabelSeatsAvailFIRST, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, -1, -1));

        jLabelSeatAvailEco.setText("jLabel14");
        getContentPane().add(jLabelSeatAvailEco, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        registerPassanger(air1);

        //persnr= (int)(Double.parseDouble(jTextField_PersonalIdentityNr.getText()));

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBoxSelectDestinationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSelectDestinationActionPerformed
        //if(jComboBoxSelectDestination.getSelectedItem()== "HONOLULU")

        String SelectedValue = jComboBoxSelectDestination.getSelectedItem().toString();
        // Display
        switch (SelectedValue) {
            case "HONOLULU":
                jLabelFlight.setText("Flight: " + air1.getPlane());
                jLabelDeparture.setText("Departure: " + air1.getDeparture());
                jLabelArrival.setText("Arrival: " + air1.getArrival());
                pl = 1;
                printOutSeatAvailbility();
                //airplaneToUse(pl).printOutEcoSeatsReservations();
                //airplaneToUse(pl).printOutFirstClassSeatsReservations();
                break;
            case "FIJI":
                jLabelFlight.setText("Flight: " + air2.getPlane());
                jLabelDeparture.setText("Departure: " + air2.getDeparture());
                jLabelArrival.setText("Arrival: " + air2.getArrival());
                pl = 2;
                printOutSeatAvailbility();
                //airplaneToUse(pl).printOutEcoSeatsReservations();
                //airplaneToUse(pl).printOutFirstClassSeatsReservations();
                break;
            case "TONGA":
                jLabelFlight.setText("Flight: " + air3.getPlane());
                jLabelDeparture.setText("Departure: " + air3.getDeparture());
                jLabelArrival.setText("Arrival: " + air3.getArrival());
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
        }
    }//GEN-LAST:event_jRadioButton1stCFocusGained

    private void jRadioButtonEcoClFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jRadioButtonEcoClFocusGained

      //jListFoodMenu.removeAll(); Funkar inte!!
      dlm.removeAllElements();
        for (Food f : new FoodMenu().getEcoClassMenu()) {
            dlm.addElement(f);
        }
    }//GEN-LAST:event_jRadioButtonEcoClFocusGained

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
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBoxForFood;
    private javax.swing.JComboBox<String> jComboBoxSelectDestination;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JLabel jLabelFlight;
    private javax.swing.JLabel jLabelRequiredCl;
    private javax.swing.JLabel jLabelRequiredGender;
    private javax.swing.JLabel jLabelRequiredMail;
    private javax.swing.JLabel jLabelRequiredfn;
    private javax.swing.JLabel jLabelRequiredln;
    private javax.swing.JLabel jLabelRequiredmnr;
    private javax.swing.JLabel jLabelRequiredpnr;
    private javax.swing.JLabel jLabelSeatAvailEco;
    private javax.swing.JLabel jLabelSeatsAvailFIRST;
    private javax.swing.JList<String> jListFoodMenu;
    private javax.swing.JRadioButton jRadioButton1stC;
    private javax.swing.JRadioButton jRadioButtonEcoCl;
    private javax.swing.JRadioButton jRadioButtonFemale;
    private javax.swing.JRadioButton jRadioButtonMale;
    private javax.swing.JRadioButton jRadioButtonOther;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextAreaShowBooking;
    private javax.swing.JTextField jTextField_EmailAdr;
    private javax.swing.JTextField jTextField_FirstName;
    private javax.swing.JTextField jTextField_LastName;
    private javax.swing.JTextField jTextField_MobileNr;
    private javax.swing.JTextField jTextField_PersonalIdentityNr;
    // End of variables declaration//GEN-END:variables
}
