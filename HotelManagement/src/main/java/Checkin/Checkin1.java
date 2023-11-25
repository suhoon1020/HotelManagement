/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Checkin;

import Login.Login;
import Login.MScreen;
import Login.SScreen;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author pgr03
 */
public class Checkin1 extends javax.swing.JFrame {

    private static String Memo; // 'Memo'라는 문자열 변수 선언

    // Memo getter
    public static String getMemo() {
        return Memo; // 'Memo' 변수를 반환하는 getter 메서드
    }
    
    private String mm;

    /**
     * Creates new form Checkin1
     */
    public Checkin1() {
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

        jLabel1 = new javax.swing.JLabel();
        jButtSearch = new javax.swing.JButton();
        jButtcancel = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPhoneNum = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel1.setText("Check-in");

        jButtSearch.setText("조회");
        jButtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtSearchActionPerformed(evt);
            }
        });

        jButtcancel.setText("취소");
        jButtcancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtcancelActionPerformed(evt);
            }
        });

        jLabel2.setText("고객명");

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        jLabel3.setText("전화번호");

        txtPhoneNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneNumActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtcancel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtName)
                            .addComponent(txtPhoneNum, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(66, 66, 66)))
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPhoneNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtSearch)
                    .addComponent(jButtcancel))
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtSearchActionPerformed
        // "조회" 버튼이 클릭되었을 때 실행되는 메서드
        String fileName = "./"; // 파일 이름 가져오기
        String filePath = fileName + ".txt"; // 파일 경로
        
        String name = txtName.getText(); // 이름 입력 필드에서 텍스트를 가져와 'name' 변수에 저장
        String phoneNum = txtPhoneNum.getText(); // 전화번호 입력 필드에서 텍스트를 가져와 'phoneNum' 변수에 저장

        // 입력 필드가 비어있는 경우 경고 메시지
        if (name.isEmpty() || phoneNum.isEmpty()) {
            JOptionPane.showMessageDialog(this, "정보를 모두 입력하세요");
            return;
        }
        
        boolean isFound = false;
        File folder = new File(".");
        File[] files = folder.listFiles(pathname -> pathname.getName().endsWith(".txt"));

        if (files != null) {
            for (File file : files) {
                BufferedReader allFileReader = null;
                try {
                    allFileReader = new BufferedReader(new FileReader(file));
                    String line;
                    while ((line = allFileReader.readLine()) != null) {
                        String[] data = line.split("/");
                        if (data.length >= 5) {
                            String nameFromFile = data[0];
                            String phoneNumFromFile = data[4];
                            if (nameFromFile.equals(name) && phoneNumFromFile.equals(phoneNum)) {
                                String fileName1 = file.getName();
                                String fileNumber = fileName1.substring(0, fileName1.lastIndexOf(".txt"));

                                if (line.contains("CHECKIN")) {
                                    JOptionPane.showMessageDialog(null, "이미 체크인 된 고객입니다.");
                                    new MScreen().setVisible(true);
                                    setVisible(false); // 현재 화면을 숨김
                                    return;
                                } else {
                                    Checkin1_2 checkin1_2Frame = new Checkin1_2();
                                    checkin1_2Frame.setVisible(true);
                                    checkin1_2Frame.getTxtName().setText(data[0]);
                                    checkin1_2Frame.getTxtNumber().setText(fileNumber);
                                    checkin1_2Frame.getTxtNumber().setText(fileNumber);
                                    Memo = fileNumber;
                                    isFound = true;
                                    setVisible(false); // 현재 화면을 숨김
                                    allFileReader.close();
                                    break;
                                }
                            }
                        }
                    }
                    if (isFound) {
                        break;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (allFileReader != null) {
                            allFileReader.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (!isFound) {
                Checkin1_3 checkin1_3Frame = new Checkin1_3();
                checkin1_3Frame.setVisible(true);
                setVisible(false); // 현재 화면을 숨김
            }
        }
    }//GEN-LAST:event_jButtSearchActionPerformed

    private void jButtcancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtcancelActionPerformed
        // "취소" 버튼이 클릭되었을 때 실행되는 메서드입니다.
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
    }//GEN-LAST:event_jButtcancelActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtPhoneNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneNumActionPerformed

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
            java.util.logging.Logger.getLogger(Checkin1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Checkin1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Checkin1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Checkin1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Checkin1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtSearch;
    private javax.swing.JButton jButtcancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhoneNum;
    // End of variables declaration//GEN-END:variables
}
