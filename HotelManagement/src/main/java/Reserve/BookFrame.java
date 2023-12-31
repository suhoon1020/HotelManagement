/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Reserve;

import Login.SScreen;
import Login.MScreen;
import Login.Login;

/**
 *
 * @author 심수훈
 */
public class BookFrame extends javax.swing.JFrame {

    /**
     * Creates new form BookFrame
     */
    public BookFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButt_BookInput = new javax.swing.JButton();
        jButt_ReserveCancel = new javax.swing.JButton();
        jButt_Revise = new javax.swing.JButton();
        jButt_Home = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButt_BookInput.setText("예약 입력");
        jButt_BookInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButt_BookInputActionPerformed(evt);
            }
        });

        jButt_ReserveCancel.setText("예약 삭제");
        jButt_ReserveCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButt_ReserveCancelActionPerformed(evt);
            }
        });

        jButt_Revise.setText("예약 수정 및 조회");
        jButt_Revise.setToolTipText("");
        jButt_Revise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButt_ReviseActionPerformed(evt);
            }
        });

        jButt_Home.setText("Home");
        jButt_Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButt_HomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(285, Short.MAX_VALUE)
                .addComponent(jButt_Home)
                .addGap(43, 43, 43))
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButt_ReserveCancel)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButt_Revise, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButt_BookInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jButt_BookInput)
                .addGap(35, 35, 35)
                .addComponent(jButt_Revise)
                .addGap(37, 37, 37)
                .addComponent(jButt_ReserveCancel)
                .addGap(47, 47, 47)
                .addComponent(jButt_Home)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButt_BookInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButt_BookInputActionPerformed
        // TODO add your handling code here:
        new ReserveRoom().setVisible(true);
        setVisible(false);

    }//GEN-LAST:event_jButt_BookInputActionPerformed

    private void jButt_ReviseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButt_ReviseActionPerformed
        // TODO add your handling code here:
        new ReserveRevise().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButt_ReviseActionPerformed

    private void jButt_HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButt_HomeActionPerformed
        // TODO add your handling code here: 메인화면 으로 돌아가기 구현
        Login loginInstance = Login.getInstance();
        boolean isMS = loginInstance.getMS();
        //System.out.println(isMS); 테스트용 코드

        if (isMS == true) {
            new SScreen().setVisible(true);
            setVisible(false);
        } else {
            new MScreen().setVisible(true);
            setVisible(false);
        }


    }//GEN-LAST:event_jButt_HomeActionPerformed

    private void jButt_ReserveCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButt_ReserveCancelActionPerformed
        // TODO add your handling code here:
        new CancelReserve().setVisible(true);
        setVisible(false);
 
    }//GEN-LAST:event_jButt_ReserveCancelActionPerformed

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
            java.util.logging.Logger.getLogger(BookFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButt_BookInput;
    private javax.swing.JButton jButt_Home;
    private javax.swing.JButton jButt_ReserveCancel;
    private javax.swing.JButton jButt_Revise;
    // End of variables declaration//GEN-END:variables
}
