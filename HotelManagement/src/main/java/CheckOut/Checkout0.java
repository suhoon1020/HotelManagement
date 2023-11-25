/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CheckOut;

import Login.MScreen;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author 이시연
 */
public class Checkout0 extends JFrame {

    private static String lys; // 고객의 고유 번호를 저장하는 문자열 필드

    // lys getter
    public static String getLys() {
        return lys;
    }

    // lys setter
    public static void setLys(String lys) {
        Checkout0.lys = lys;
    }

    

    public static void main(String[] args) {
        JFrame frame = new JFrame("체크아웃");  // 체크아웃 창을 생성
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 프레임이 닫힐 때 프로그램이 종료하도록 설정
        frame.setLayout(null);  // 레이아웃 매니저를 비활성화

        // 컴포넌트 생성
        JLabel Num = new JLabel("고유 번호 조회");
        JTextField searchField = new JTextField(20);
        JButton searchButton = new JButton("조회");
        JButton prevButton = new JButton("이전");

        // 조회 버튼에 대한 액션 리스너
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lys = searchField.getText(); // 버튼 클릭시 JTextField의 텍스트를 lys에 저장               
                int qwer = Integer.parseInt(searchField.getText()); // 텍스트 필드의 텍스트를 정수로 변환하여 qwer에 저장
                String directoryPath = "./"; // 현재 디렉토리를 나타내는 경로를 저장하는 변수 선언("./"-파일위치)
                File directory = new File(directoryPath); // directoryPath를 기반으로 File 객체 생성

                if (directory.isDirectory()) { // 디렉토리인지 확인하는 조건문
                    File[] files = directory.listFiles(); // 디렉토리 내의 모든 파일을 배열로 가져오기

                    for (File file : files) { // files 배열의 각 파일에 대해 반복 작업 수행
                        if (file.isFile() && file.getName().matches("\\d+\\.txt")) { // 파일이면서 이름이 숫자로 시작하고 .txt로 끝나는 조건문
                            String fileName = file.getName(); // 파일 이름 저장
                            int number = Integer.parseInt(fileName.substring(0, fileName.indexOf(".txt"))); // 파일 이름에서 숫자 부분 추출

                            if (number == qwer) { // 추출한 숫자와 입력된 값(파일 조회 변수)이(가) 일치하는지 확인하는 조건문
                                try {
                                    BufferedReader br = new BufferedReader(new FileReader(qwer + ".txt"));
                                    String[] currentLine = br.readLine().split("/");
                                    ArrayList<String> array = new ArrayList<>(Arrays.asList(currentLine));

                                    if (!array.contains("CHECKIN")) {
                                        JOptionPane.showMessageDialog(null, "아직 체크인 하지 않은 고객입니다");
                                    } else {
                                        JOptionPane.showMessageDialog(null, "고객이 조회되었습니다."); // 메시지 대화상자를 통해 메시지를 표시합니다.
                                        //파일 읽어와서 테이블에 출력하기
                                        Checkout1.main(new String[0]);  // Checkout1의 main 메서드 호출
                                        frame.setVisible(false);  // 현재 프레임을 숨김
                                    }

                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                                // 파일을 읽어오거나 필요한 작업을 수행합니다.                             
                            }
                        }
                    }
                }
            }
        });

        // 이전 버튼에 대한 액션 리스너
        prevButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 버튼 클릭 시 호출할 프레임 보이기
                MScreen.main(new String[0]); // MScreen의 main 메서드 호출
                frame.setVisible(false); // 현재 프레임 숨기기
            }
        });

        // 컴포넌트의 위치와 크기 설정
        Num.setBounds(100, 50, 100, 50);
        frame.add(Num);

        searchField.setBounds(65, 100, 150, 25);
        frame.add(searchField);

        searchButton.setBounds(70, 150, 60, 25);
        frame.add(searchButton);

        prevButton.setBounds(150, 150, 60, 25);
        frame.add(prevButton);

        frame.setSize(300, 300);  // 프레임의 크기 설정

        frame.setVisible(true);  // 프레임을 보이도록 설정  
    }
}
