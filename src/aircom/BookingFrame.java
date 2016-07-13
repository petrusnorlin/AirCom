/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aircom;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class BookingFrame extends javax.swing.JFrame {

    ArrayList<Passenger> passengerlist = new ArrayList<Passenger>();
    Passenger p;
    /**
     * Creates new form BookingFrame
     */
    public BookingFrame() {
        
        initComponents();
   java.awt.event.MouseAdapter mouseAdapter=   new java.awt.event.MouseAdapter() {
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Jokerman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 204));
        jLabel1.setText("Welcome to AirCom!");
        jLabel1.setToolTipText("");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Jokerman", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("One way ticket to Honolulu, Hawaii!");
        jLabel2.setToolTipText("");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Choose Class:");
        jLabel3.setToolTipText("");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 90, 20));

        buttonGroup1.add(jRadioButton1stC);
        jRadioButton1stC.setText("1st Class");
        getContentPane().add(jRadioButton1stC, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, -1, -1));

        buttonGroup1.add(jRadioButtonEcoCl);
        jRadioButtonEcoCl.setText("ECO Class");
        jRadioButtonEcoCl.setToolTipText("");
        getContentPane().add(jRadioButtonEcoCl, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Firstname:");
        jLabel4.setToolTipText("");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        jTextField_LastName.setEnabled(false);
        getContentPane().add(jTextField_LastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 230, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Lastname:");
        jLabel5.setToolTipText("");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        jTextField_FirstName.setEnabled(false);
        getContentPane().add(jTextField_FirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 230, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Gender:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, -1, -1));

        buttonGroup2.add(jRadioButtonFemale);
        jRadioButtonFemale.setText("Female");
        jRadioButtonFemale.setToolTipText("");
        jRadioButtonFemale.setEnabled(false);
        getContentPane().add(jRadioButtonFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 480, -1, -1));

        buttonGroup2.add(jRadioButtonMale);
        jRadioButtonMale.setText("Male");
        jRadioButtonMale.setEnabled(false);
        getContentPane().add(jRadioButtonMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 480, -1, -1));

        buttonGroup2.add(jRadioButtonOther);
        jRadioButtonOther.setText("Other");
        jRadioButtonOther.setToolTipText("");
        jRadioButtonOther.setEnabled(false);
        getContentPane().add(jRadioButtonOther, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 480, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Personal Identity Nr:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));

        jTextField_PersonalIdentityNr.setToolTipText("");
        jTextField_PersonalIdentityNr.setEnabled(false);
        getContentPane().add(jTextField_PersonalIdentityNr, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 230, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Mobile phone number:");
        jLabel8.setToolTipText("");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, -1));

        jTextField_MobileNr.setToolTipText("");
        jTextField_MobileNr.setEnabled(false);
        getContentPane().add(jTextField_MobileNr, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 230, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Email adress:");
        jLabel9.setToolTipText("");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, -1, -1));

        jTextField_EmailAdr.setToolTipText("");
        jTextField_EmailAdr.setEnabled(false);
        getContentPane().add(jTextField_EmailAdr, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 230, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Make food reservations:");
        jLabel10.setToolTipText("");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, 20));

        jCheckBoxForFood.setEnabled(false);
        getContentPane().add(jCheckBoxForFood, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 40, 40));

        jButton1.setText("Next");
        jButton1.setToolTipText("");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 520, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 630, 30));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aircom/images/paradise.png"))); // NOI18N
        jLabel11.setText("jLabel11");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 350, 80));

        jLabelRequiredfn.setText("jLabel12");
        getContentPane().add(jLabelRequiredfn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, -1, -1));

        jLabelRequiredCl.setText("jLabel13");
        getContentPane().add(jLabelRequiredCl, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 50, 20));

        jLabelRequiredln.setText("jLabel12");
        getContentPane().add(jLabelRequiredln, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, -1, -1));

        jLabelRequiredpnr.setText("jLabel12");
        getContentPane().add(jLabelRequiredpnr, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, -1, -1));

        jLabelRequiredmnr.setText("jLabel12");
        getContentPane().add(jLabelRequiredmnr, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, -1, -1));

        jLabelRequiredMail.setText("jLabel12");
        getContentPane().add(jLabelRequiredMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, -1, -1));

        jLabelRequiredGender.setText("jLabel12");
        getContentPane().add(jLabelRequiredGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 460, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        FlightType ft = null;
        Boolean eat;
        String fname;
        String lname;
        int persnr;
        String phonenr;
        String emailadr;
        GenderType gt = null;
        
        
        if(jRadioButton1stC.isSelected())
        {
        ft = FlightType.FIRSTCLASS;
        
        jCheckBoxForFood.setEnabled(true);
        }
        if(jRadioButtonEcoCl.isSelected())
        {
        ft =FlightType.ECOCLASS;
        jCheckBoxForFood.setEnabled(true);
        }
        
        if(jCheckBoxForFood.isSelected() == true)
        {
            eat = true;
        }
        else
        {   
            eat= false;            
        }
        
        //if(jTextField_FirstName.)//kommenterat tillfälligt av Jimmy
        fname= jTextField_FirstName.getText();
        
        lname = jTextField_LastName.getText();                
        persnr = (Integer.parseInt(jTextField_PersonalIdentityNr.getText()));
        phonenr = jTextField_MobileNr.getText();
        emailadr = jTextField_EmailAdr.getText();
        
        if(jRadioButtonFemale.isSelected())
        {
        gt = GenderType.FEMALE;
        }
        if (jRadioButtonMale.isSelected())
        {
        gt = GenderType.MALE;
        }
        if(jRadioButtonOther.isSelected())
        {
        gt = GenderType.OTHER;
        }
        
        p = new Passenger(ft, eat, fname, lname, persnr, phonenr, gt);
        passengerlist.add(p);
        
        for (Passenger passenger : passengerlist) {
            System.out.println(passenger);
            
        }
        
        
        //persnr= (int)(Double.parseDouble(jTextField_PersonalIdentityNr.getText()));
        
        
        
            
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JLabel jLabelRequiredCl;
    private javax.swing.JLabel jLabelRequiredGender;
    private javax.swing.JLabel jLabelRequiredMail;
    private javax.swing.JLabel jLabelRequiredfn;
    private javax.swing.JLabel jLabelRequiredln;
    private javax.swing.JLabel jLabelRequiredmnr;
    private javax.swing.JLabel jLabelRequiredpnr;
    private javax.swing.JRadioButton jRadioButton1stC;
    private javax.swing.JRadioButton jRadioButtonEcoCl;
    private javax.swing.JRadioButton jRadioButtonFemale;
    private javax.swing.JRadioButton jRadioButtonMale;
    private javax.swing.JRadioButton jRadioButtonOther;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField_EmailAdr;
    private javax.swing.JTextField jTextField_FirstName;
    private javax.swing.JTextField jTextField_LastName;
    private javax.swing.JTextField jTextField_MobileNr;
    private javax.swing.JTextField jTextField_PersonalIdentityNr;
    // End of variables declaration//GEN-END:variables
}
