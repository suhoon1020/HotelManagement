/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Roomservice;

import Login.Login;
import Login.MScreen;
import Login.SScreen;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.io.RandomAccessFile;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.DefaultListModel;

/**
 *
 * @author user
 */
public class RoomService extends javax.swing.JFrame {

    /**
     * Creates new form room
     */
    String UniqueNum = "0";

    public void setUniqueNum(String UniqueNum) {
        this.UniqueNum = UniqueNum;
    }

    public boolean isUniqueNumEmpty() {
        if (jText_Num.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "고유번호 란이 공백입니다.");
            return true;
        } else {
            return false;
        }
    }

    public boolean isNumber() {
        if (!jText_Num.getText().matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "올바른 값을 입력해 주십시오");
            return true;
        }
        return false;
    }

    public boolean isRightUniqueNum() {
        /*
        공백일때 일치하지 않는다가 출력이 되는게 문제
        ->공백일때는 isUniuqueEMpty만 출력이 되야함
         */
        if (jText_Num.getText().isEmpty()) {
            return isUniqueNumEmpty();
        } else {
            if (!jText_Num.getText().equals(UniqueNum)) {
                JOptionPane.showMessageDialog(this, "고유번호에 입력된 값과 조회 내용이 일치하지 않습니다");
                return true;
            } else if (!jText_Num.getText().matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "올바른 값을 입력해 주십시오");
                return true;
            }
        }
        return false;
    }

    public boolean isCheckIn() {
        boolean isCheckIn = false;
        try {
            BufferedReader checkIn_br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(jText_Num.getText() + ".txt"), "UTF-8"));
            String[] checkIn = checkIn_br.readLine().split("/");
            ArrayList<String> checkInArray = new ArrayList<>(Arrays.asList(checkIn));
            checkIn_br.close();
            if (!checkInArray.contains("CHECKIN")) {
                JOptionPane.showMessageDialog(null, "아직 미체크인 한 고객입니다");
                isCheckIn = true;
            } else {
                isCheckIn = false;
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return isCheckIn;
    }

    public RoomService() {
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

        jFrame1 = new javax.swing.JFrame();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jText_Num = new javax.swing.JTextField();
        Butt_Check = new javax.swing.JButton();
        jText_Cost = new javax.swing.JTextField();
        Butt_Save = new javax.swing.JButton();
        Butt_Back = new javax.swing.JButton();
        jText_bill = new javax.swing.JTextField();
        jText_Amount = new javax.swing.JTextField();
        jCombo_Menu = new javax.swing.JComboBox<>();
        Butt_Del = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_Order = new javax.swing.JTable();
        jButt_TotalPrice = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        currentUniqueNum = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(338, 338, 338))
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jText_Num.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jText_NumActionPerformed(evt);
            }
        });

        Butt_Check.setText("조회");
        Butt_Check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Butt_CheckActionPerformed(evt);
            }
        });

        jText_Cost.setToolTipText("");
        jText_Cost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jText_CostActionPerformed(evt);
            }
        });

        Butt_Save.setText("확인");
        Butt_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Butt_SaveActionPerformed(evt);
            }
        });

        Butt_Back.setText("이전");
        Butt_Back.setToolTipText("");
        Butt_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Butt_BackActionPerformed(evt);
            }
        });

        jText_bill.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jText_bill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jText_billActionPerformed(evt);
            }
        });

        jText_Amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jText_AmountActionPerformed(evt);
            }
        });

        jCombo_Menu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "전복죽", "오믈렛", "훈제연어", "시저샐러드", "마르게리타피자", "요거트", "과일", "소고기안심구이", "화이트와인", "레드와인" }));
        jCombo_Menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCombo_MenuActionPerformed(evt);
            }
        });

        Butt_Del.setText("삭제");
        Butt_Del.setToolTipText("");
        Butt_Del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Butt_DelActionPerformed(evt);
            }
        });

        jTable_Order.setFont(new java.awt.Font("휴먼모음T", 0, 12)); // NOI18N
        jTable_Order.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "메뉴", "수량", "비용"
            }
        ));
        jTable_Order.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_OrderMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable_Order);

        jButt_TotalPrice.setText("총비용 조회");
        jButt_TotalPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButt_TotalPriceActionPerformed(evt);
            }
        });

        jLabel8.setText("조회중인 고유번호 :");

        jLabel1.setText("고객 고유번호 : ");

        jLabel7.setText("메뉴 : ");

        jLabel9.setText("수량 : ");

        jLabel6.setText("비용 : ");

        jLabel5.setText("총 주문 비용 : ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel6))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jText_Num, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jText_Cost)
                                            .addComponent(jCombo_Menu, 0, 175, Short.MAX_VALUE)
                                            .addComponent(jText_Amount))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(currentUniqueNum, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(Butt_Check, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Butt_Back, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Butt_Del, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Butt_Save, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButt_TotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jText_bill, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jText_Num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Butt_Check)
                    .addComponent(jLabel1))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCombo_Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(currentUniqueNum, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jText_Amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jText_Cost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jText_bill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Butt_Back)
                    .addComponent(Butt_Del)
                    .addComponent(Butt_Save)
                    .addComponent(jButt_TotalPrice))
                .addGap(35, 35, 35))
            .addGroup(layout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void Butt_CheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Butt_CheckActionPerformed
        // TODO add your handling code here:
        //만약 이미 주문되어 있다면 그 파일을 읽어와서 테이블에 출력
        //만약 그렇지 않으면 수정해서 저장하기

        /*
        s.txt 생성 , 테이블에 추가되는것 계속 넣기
         */
        if (isUniqueNumEmpty() || isNumber()) {
            return;
        } else {
            int Cheak_num;
            String checkUniqueNum = jText_Num.getText();

            // jTextC_Num에서 입력된 값을 정수로 변환하여 qwer에 저장
            Cheak_num = Integer.parseInt(jText_Num.getText());

            // 현재 디렉토리를 나타내는 경로를 저장하는 변수 선언("./"-파일위치)
            String directoryPath = "./";

            // directoryPath를 기반으로 File 객체 생성
            File directory = new File(directoryPath);

            // 디렉토리인지 확인하는 조건문
            if (directory.isDirectory()) {

                // 디렉토리 내의 모든 파일을 배열로 가져오기
                File[] files = directory.listFiles();

                // 파일이 발견되었는지를 나타내는 플래그
                boolean found = false;

                // files 배열의 각 파일에 대해 반복 작업 수행
                for (File file : files) {
                    // 파일이면서 이름이 숫자로 시작하고 .txt로 끝나는 조건문
                    if (file.isFile() && file.getName().matches("\\d+\\.txt")) {
                        // 파일 이름 저장

                        String fileName = file.getName();

                        // 파일 이름에서 숫자 부분 추출    
                        int number = Integer.parseInt(fileName.substring(0, fileName.indexOf(".txt")));
                        // 추출한 숫자와 입력된 값(파일 조회 변수)이(가) 일치하는지 확인하는 조건문
                        if (number == Cheak_num) { //해당 파일 찾음
                            if (isCheckIn()) {
                                return;
                            } else {

                                // 파일을 읽어오거나 필요한 작업을 수행합니다.
                                JOptionPane.showMessageDialog(null, "고객 조회가 되었습니다.");
                                setUniqueNum(checkUniqueNum);
                                currentUniqueNum.setText(checkUniqueNum);
                                DefaultTableModel tblModel = (DefaultTableModel) jTable_Order.getModel();

                                tblModel.setRowCount(0); //박스 초기화

                                jText_Amount.setText(null);
                                jText_Cost.setText(null);
                                jText_bill.setText(null);

                                //파일 읽어와서 테이블에 출력하기
                                //String paths = System.getProperty("user.dir");
                                //String uniqueNum = this.jText_Num.getText();
                                File rfile = new File(checkUniqueNum + "s.txt");

                                if (rfile.exists()) {
                                    try (Scanner scanner = new Scanner(rfile)) {
                                        tblModel.setRowCount(0);
                                        // 파일 내용을 테이블에 출력
                                        while (scanner.hasNextLine()) { //scanner.hasNextLine -> 새로운 라인이 있는가?
                                            String line = scanner.nextLine();
                                            String[] rowData = line.split("/");                                          
                                            tblModel.addRow(rowData);
                                        }

                                        // 테이블에 모델 설정
                                        jTable_Order.setModel(tblModel);
                                    } catch (FileNotFoundException e) {
                                        e.printStackTrace();
                                    }
                                }
                                // 파일이 발견되었음을 표시
                                found = true;
                            }
                        }

                    }

                }
                // 일치하는 파일이 없는 경우 메시지 다이얼로그 출력
                if (!found) {
                    JOptionPane.showMessageDialog(null, "일치하는 고객이 없습니다.");

                }
            }
        }
    }//GEN-LAST:event_Butt_CheckActionPerformed

    private void jText_CostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jText_CostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jText_CostActionPerformed

    private void Butt_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Butt_SaveActionPerformed
        // TODO add your handling code here:
        //파일에 값을 입력한다
        //파일 생성

        String amount = jText_Amount.getText();

        if (amount.isEmpty() || !amount.matches("\\d+")) { //빈값 or 정수값이 아니면
            JOptionPane.showMessageDialog(null, "수량이 입력되지 않았습니다");
        } else {
            //수량이 제대로 입력되면
            if (isRightUniqueNum()) {
                return;
            } else {
                setBill();
                /*
            String data[] = {jCombo_Menu.getSelectedItem().toString(), jText_Amount.getText(), jText_Cost.getText()};           
            DefaultTableModel tblModel = (DefaultTableModel) jTable_Order.getModel();
            tblModel.addRow(data);
                 */
                String fileName = UniqueNum + "s.txt"; // 'jText_Num' 텍스트 필드에서 받아와서 파일 이름 생성

                try {
                    //만약 조회버튼을 누르지 않으면 "조회 하십시오 출력"
                    String data[] = {jCombo_Menu.getSelectedItem().toString(), jText_Amount.getText(), jText_Cost.getText()};
                    DefaultTableModel tblModel = (DefaultTableModel) jTable_Order.getModel();
                    tblModel.addRow(data);

                    BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
                    bw.write((String) jCombo_Menu.getSelectedItem() + "/");
                    bw.write(jText_Amount.getText() + "/");
                    bw.write(jText_Cost.getText() + "\n");
                    bw.close();
                    JOptionPane.showMessageDialog(null, "주문 완료");

                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        }
    }//GEN-LAST:event_Butt_SaveActionPerformed

    private void Butt_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Butt_BackActionPerformed
        // TODO add your handling code here:
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
    }//GEN-LAST:event_Butt_BackActionPerformed

    private void jText_billActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jText_billActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jText_billActionPerformed

    public void setBill() {
        int price = 0;
        int qty = Integer.parseInt(jText_Amount.getText()); // 수량 변수

        String menus = jCombo_Menu.getSelectedItem().toString();

        if ("전복죽".equals(menus)) {
            price = 15000;
        } else if ("오믈렛".equals(menus)) {
            price = 7000;
        } else if ("훈제연어".equals(menus)) {
            price = 12000;
        } else if ("시저샐러드".equals(menus)) {
            price = 7000;
        } else if ("마르게리타피자".equals(menus)) {
            price = 14000;
        } else if ("요거트".equals(menus)) {
            price = 9000;
        } else if ("과일".equals(menus)) {
            price = 12000;
        } else if ("소고기안심구이".equals(menus)) {
            price = 20000;
        } else if ("화이트와인".equals(menus)) {
            price = 13000;
        } else if ("레드와인".equals(menus)) {
            price = 13000;
        }

        int sums = price * qty;
        String totalPrice = String.valueOf(sums);
        jText_Cost.setText(totalPrice);
    }

    private void jCombo_MenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCombo_MenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCombo_MenuActionPerformed

    private void Butt_DelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Butt_DelActionPerformed
        // TODO add your handling code here:
        //테이블과 파일 내용 삭제 -> 다시 테이블모델 내용 파일에 읽기

        //파일 찾아가서 내용 삭제하기
        if (isRightUniqueNum()) {
            return;
        } else {
            String path = UniqueNum + "s.txt";

            try (RandomAccessFile raf = new RandomAccessFile(path, "rw")) {
                raf.setLength(0);
            } catch (IOException e) {
                e.printStackTrace();
            }

            //테이블항목 삭제하기
            DefaultTableModel tblModel = (DefaultTableModel) jTable_Order.getModel();

            if (jTable_Order.getSelectedRowCount() == 1) { //1개 선택시 삭제
                tblModel.removeRow(jTable_Order.getSelectedRow());
                JOptionPane.showMessageDialog(null, "삭제 완료");
            } else if (jTable_Order.getSelectedRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "삭제할 항목을 선택하여주십시오."); // 선택된 것이 없을 경우
            } else if (jTable_Order.getSelectedRowCount() >= 2) {
                JOptionPane.showMessageDialog(this, "하나만 선택하세요."); // 두개 이상 선택되었을 경우
            }

            //테이블 값을 리스트로 변경
            DefaultTableModel model = tblModel; // DefaultTableModel 객체를 생성하거나 가져옵니다.

            DefaultListModel<String> listModel = new DefaultListModel<>();

            int rowCount = model.getRowCount();
            int colCount = model.getColumnCount();

            for (int row = 0; row < rowCount; row++) {
                StringBuilder rowData = new StringBuilder();

                for (int col = 0; col < colCount; col++) {
                    Object value = model.getValueAt(row, col);
                    rowData.append(value.toString());
                    if (col < colCount - 1) {
                        rowData.append("/");
                    }
                }
                listModel.addElement(rowData.toString());
            }

            //리스트 값을 파일에 저장
            try (PrintWriter writer = new PrintWriter(path)) {
                for (int i = 0; i < listModel.size(); i++) {
                    writer.println(listModel.get(i));
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_Butt_DelActionPerformed

    private void jTable_OrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_OrderMouseClicked

    }//GEN-LAST:event_jTable_OrderMouseClicked

    private void jText_NumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jText_NumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jText_NumActionPerformed

    private void jText_AmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jText_AmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jText_AmountActionPerformed

    private void jButt_TotalPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButt_TotalPriceActionPerformed
        // TODO add your handling code here:

        // num에서 입력된 값을 정수로 변환하여 Cheak_value에 저장
        if (isRightUniqueNum()) {
            return;
        } else {

            String rText = UniqueNum + "s.txt";
            File rTextFile = new File(rText);

            if (!rTextFile.exists()) {
                JOptionPane.showMessageDialog(this, "한번도 주문을 하지 않은 고객입니다");
                return;
            } else {
                try {
                    BufferedReader rFileReader = new BufferedReader(new FileReader(rTextFile));
                    String line = rFileReader.readLine();
                    int sum = 0;
                    /*
                    while문
                    -> 해당 파일을 열어서 , 각 줄의 3번째 값을 더하고
                    -> 만약 더이상 읽을 줄이 없어서 null 이 나오면 break
                     */
                    while (line != null) {
                        // "/"로 구분된 값을 가져와서 배열로 저장
                        String[] values = line.split("/");

                        // 배열의 세 번째 값(인덱스 2)이 숫자로 시작하는 경우에만 합산
                        if (values.length >= 3 && values[2].matches("\\d+")) {
                            sum += Integer.parseInt(values[2]);
                        }

                        // 다음 줄 읽기
                        line = rFileReader.readLine();
                    }
                    rFileReader.close();
                    jText_bill.setText(String.valueOf(sum)); //TotalPrice 출력

                    String fileName = UniqueNum + "s.bill.txt"; // 'num' 텍스트 필드에서 받아와서 파일 이름 생성
                    if (!rTextFile.exists()) {//r 파일이 존재 하지 않는다면?
                        JOptionPane.showMessageDialog(this, "해당 bill 파일을 생성 할 수 없습니다"); // 두개 이상 선택되었을 경우
                    } else {
                        try {
                            BufferedWriter billFileWriter = new BufferedWriter(new FileWriter(fileName, false));
                            billFileWriter.write(jText_bill.getText());
                            billFileWriter.close();

                        } catch (IOException ex) {
                            ex.printStackTrace();

                        }
                    }
                    // 파일 닫기

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

    }//GEN-LAST:event_jButt_TotalPriceActionPerformed

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
            java.util.logging.Logger.getLogger(RoomService.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RoomService.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RoomService.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RoomService.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RoomService().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Butt_Back;
    private javax.swing.JButton Butt_Check;
    private javax.swing.JButton Butt_Del;
    private javax.swing.JButton Butt_Save;
    private javax.swing.JLabel currentUniqueNum;
    private javax.swing.JButton jButt_TotalPrice;
    private javax.swing.JComboBox<String> jCombo_Menu;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_Order;
    private javax.swing.JTextField jText_Amount;
    private javax.swing.JTextField jText_Cost;
    private javax.swing.JTextField jText_Num;
    private javax.swing.JTextField jText_bill;
    // End of variables declaration//GEN-END:variables
}
