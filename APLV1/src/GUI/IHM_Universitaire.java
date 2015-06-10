/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import ClientsServeurs.ClientUniversiteGV;

/**
 *
 * @author guilhem
 */
public class IHM_Universitaire extends javax.swing.JFrame {
	
	public static ClientUniversiteGV clientUnivGV; 
    /**
     * Creates new form IHM_Universitaire
     */
    public IHM_Universitaire(ClientUniversiteGV client) {
        initComponents();
        ConnexionUniversitaire cu = new ConnexionUniversitaire(this, client);
        cu.setVisible(true);
        this.setVisible(false);
        IHM_Universitaire.clientUnivGV = client;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_titreInterface = new javax.swing.JLabel();
        lb_connecteEnTantQue = new javax.swing.JLabel();
        lb_nomUniversitaire = new javax.swing.JLabel();
        lb_titre_Periode = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bt_ExaminerCandidature = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tab_Voeux = new javax.swing.JTable();
        bt_etablirPreRequis = new javax.swing.JButton();
        bt_Quitter = new javax.swing.JButton();
        bt_decisionFinale = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lb_titreInterface.setText("Interface universitaire");

        lb_connecteEnTantQue.setText("Connecté en tant que :");

        lb_nomUniversitaire.setText("Nom de l'universitaire");

        lb_titre_Periode.setText("Periode :");

        jLabel4.setText("titrePeriode");

        bt_ExaminerCandidature.setText("Examiner la candidature");
        bt_ExaminerCandidature.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ExaminerCandidatureActionPerformed(evt);
            }
        });

        tab_Voeux.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nom de l'etudiant", "Voeu", "Etat", "Decision Etudiant"
            }
        ));
        jScrollPane2.setViewportView(tab_Voeux);

        bt_etablirPreRequis.setText("Etablir pré-requis");
        bt_etablirPreRequis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_etablirPreRequisActionPerformed(evt);
            }
        });

        bt_Quitter.setText("Quitter ");
        bt_Quitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_QuitterActionPerformed(evt);
            }
        });

        bt_decisionFinale.setText("Prendre décision finale");
        bt_decisionFinale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_decisionFinaleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bt_etablirPreRequis)
                    .addComponent(lb_connecteEnTantQue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lb_nomUniversitaire)
                        .addGap(207, 207, 207)
                        .addComponent(lb_titreInterface)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 272, Short.MAX_VALUE)
                        .addComponent(lb_titre_Periode))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addGap(8, 8, 8)))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(57, 57, 57))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_Quitter)
                .addGap(481, 481, 481))
            .addGroup(layout.createSequentialGroup()
                .addGap(326, 326, 326)
                .addComponent(bt_ExaminerCandidature, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addComponent(bt_decisionFinale, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_titreInterface)
                    .addComponent(lb_connecteEnTantQue)
                    .addComponent(lb_nomUniversitaire)
                    .addComponent(lb_titre_Periode)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(bt_etablirPreRequis)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_ExaminerCandidature)
                    .addComponent(bt_decisionFinale))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(bt_Quitter)
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_etablirPreRequisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_etablirPreRequisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_etablirPreRequisActionPerformed

    private void bt_ExaminerCandidatureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ExaminerCandidatureActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_ExaminerCandidatureActionPerformed

    private void bt_decisionFinaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_decisionFinaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_decisionFinaleActionPerformed

    private void bt_QuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_QuitterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_QuitterActionPerformed

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
            java.util.logging.Logger.getLogger(IHM_Universitaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IHM_Universitaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IHM_Universitaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IHM_Universitaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IHM_Universitaire(clientUnivGV).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_ExaminerCandidature;
    private javax.swing.JButton bt_Quitter;
    private javax.swing.JButton bt_decisionFinale;
    private javax.swing.JButton bt_etablirPreRequis;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb_connecteEnTantQue;
    private javax.swing.JLabel lb_nomUniversitaire;
    private javax.swing.JLabel lb_titreInterface;
    private javax.swing.JLabel lb_titre_Periode;
    private javax.swing.JTable tab_Voeux;
    // End of variables declaration//GEN-END:variables
}
