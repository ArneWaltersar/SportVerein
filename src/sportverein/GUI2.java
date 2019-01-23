/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportverein;

import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.util.ArrayList;
import java.io.*;
import java.util.Collections;
import javax.swing.JButton;

/**
 *
 * @author rauerjakob
 */
public class GUI2 extends javax.swing.JFrame {

    ArrayList<Paarung> paarung = new ArrayList<Paarung>();
    ArrayList<TextField> textFields = new ArrayList<TextField>();
    //ArrayList<Verein> vereine = new ArrayList<Verein>();

    /**
     * Creates new form GUI
     */
    public GUI2() {
        initComponents();
    }

    public void setPaarungen(ArrayList<Paarung> Paarungen) {
        int i = 10;
        paarung = Paarungen;
        this.setSize(350, (paarung.size()+1) * 45);
        for (Paarung p : Paarungen) {

            TextField b4 = new TextField("0");
            // Set the location and size of the button:
            b4.setLocation(10, i);
            b4.setSize(100, 26);
            // Add the button to the window:
            this.add(b4);
            textFields.add(b4);
            //
            Label c4 = new Label(p.toString());
            c4.setLocation(110, i);
            c4.setSize(100, 26);
            this.add(c4);

            TextField d4 = new TextField("0");

            d4.setLocation(210, i);
            d4.setSize(100, 26);

            this.add(d4);
            textFields.add(d4);

            i += 30;
        }
        JButton button = new JButton("OK");
        button.setLocation(10, i);
        button.setSize(100, 26);
        this.add(button);

        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c(evt);
            }
        });
    }

    private void c(java.awt.event.ActionEvent evt) {
        int i = 0;
        ArrayList <Verein> vereine = new ArrayList<Verein>();
        for (Verein v : vereine) {
            v.gegentore = 0;
            v.punkte = 0;
            v.tore = 0;
        }
        for (Paarung p : paarung) {
            if(!vereine.contains(p.verein1)) {
            vereine.add(p.verein1);
        }
            if(!vereine.contains(p.verein1)) {
                 vereine.add(p.verein1);
            }
           
            
            int zahl1 = Integer.parseInt(textFields.get(i).getText());
            int zahl2 = Integer.parseInt(textFields.get(i+1).getText());
            p.verein1.tore += zahl1;
            p.verein1.gegentore += zahl2;
            
            p.verein2.tore += zahl2;
            p.verein2.gegentore += zahl1;
            
            if(zahl1 > zahl2) {
                p.verein1.punkte += 3;
            } else if (zahl1 == zahl2) {
                p.verein1.punkte += 1;
                p.verein2.punkte += 1;
            } else {
                p.verein2.punkte += 3;
            }
            i += 2;
        }
        MainApplicationManageController.storeFootballAssociation(vereine);
        this.dispose();
    }


    /**
     * This method is called from within the constructor to the form. WARNING:
     * Do NOT modify this code. The content of this method is always regenerated
     * by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jProgressBar1 = new javax.swing.JProgressBar();
        jScrollPane1 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 537, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(GUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
