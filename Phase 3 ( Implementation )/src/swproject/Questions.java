/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swproject;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Aya
 */
public class Questions extends javax.swing.JFrame {

    /**
     * Creates new form Questions
     */
    
    
//     PlayGame s =new  PlayGame();
//    public static String gamename=s.GameName ;
  
    
    public static int score =0 ;
    public static int indx =0 ;
    public static StudentAccount user ;
    
    
    void set_user(StudentAccount sent )
    {
        user = sent;
    }
    
    public Questions( ) throws IOException {
        initComponents();
        this.setBounds(150,25, 950, 650);
    }
    
    
    public Game game ;
    public Map<String, String> QuestionAndAnswer = new HashMap<String, String>();    
    
    void Play (String GameName) throws IOException 
    {
          game = new Game();
          jLabel2.setText("Current score : 0");
          QuestionAndAnswer = game.Load(GameName);
          String Q = (String) QuestionAndAnswer.keySet().toArray()[indx];
          jLabel1.setText(Q);

    };
    

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(150, 25, 1100, 650));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(37, 50, 960, 44);

        buttonGroup2.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        jRadioButton1.setText("True");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton1);
        jRadioButton1.setBounds(100, 160, 100, 39);

        buttonGroup2.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        jRadioButton2.setText("False");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton2);
        jRadioButton2.setBounds(100, 220, 100, 39);

        jLabel2.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(596, 11, 290, 50);

        jButton1.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        jButton1.setText("Exit ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(730, 470, 140, 60);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(66, 123, 265, 14);

        jButton2.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        jButton2.setText("Next");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(730, 390, 140, 60);

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\NHG\\Documents\\NetBeansProjects\\PresentationCode\\SWProject\\schoolchoice(1).jpg")); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, -10, 1020, 640);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            
     
            
            String Ans =  (String) QuestionAndAnswer.values().toArray()[indx] ; 
            indx++;     
        
            {
                
          
            if ( ((jRadioButton1.isSelected())&& Ans.equals("T")) || ((jRadioButton2.isSelected())&& Ans.equals("F")) ) {
                
                try {
            Desktop.getDesktop().open(new File("Correct-answer.mp3"));
        } catch (IOException ex) {
            Logger.getLogger(Questions.class.getName()).log(Level.SEVERE, null, ex);
        }
                score++;
                jLabel2.setText("current score : " + score);
                 

            } else{
                 try {
            Desktop.getDesktop().open(new File("Wrong-answer-sound-effect.mp3"));
        } catch (IOException ex) {
            Logger.getLogger(Questions.class.getName()).log(Level.SEVERE, null, ex);
        }
               
                 JOptionPane.showMessageDialog(null,"Wrong Answer !!");
                
                
            }

                
            }
            
           if(indx%5 == 0)
            {   
                 if (indx==QuestionAndAnswer.size())
                 {
                     JOptionPane.showMessageDialog(null,"You Complete this Game ^_^ ");
                      indx = 0 ;
                 }
                 
                 else 
                 {
                     JOptionPane.showMessageDialog(null,"You Complete Level " + indx/5);
                 }
               
            } 
           
           
             String Q = (String) QuestionAndAnswer.keySet().toArray()[indx] ;
            System.out.println("Ans = " + Ans);
          
            jLabel1.setText(Q);
         
           
           
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
       

    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
           
        Controller c = new Controller();
        try {
            c.ReconstructData();
            int finalScore = c.UpdateScore(score , user);
            System.out.println("User in Exit PlayGame : " + user.getUserName());
            JOptionPane.showMessageDialog(null, "Your Total Score : " + finalScore);
            this.hide();
            
            
        } catch (IOException ex) {
            Logger.getLogger(Questions.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
         
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException {
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
            java.util.logging.Logger.getLogger(Questions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Questions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Questions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Questions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Questions().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Questions.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
          
    }
    
//    public void Play ()
//    {
//        jButton1.setAction("");
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    // End of variables declaration//GEN-END:variables
}