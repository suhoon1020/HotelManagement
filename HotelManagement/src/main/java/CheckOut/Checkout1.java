/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CheckOut;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author 이시연
 */

public class Checkout1 {
    public static void main(String[] args) {
        // 새로운 프레임 생성
        JFrame frame = new JFrame("체크아웃");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 프레임 닫기 설정
        frame.setLayout(null);  // 레이아웃 매니저를 사용하지 않음

        // 버튼 생성
        JButton btn1 = new JButton("날짜/시간");
        JButton btn2 = new JButton("청구서발행");
        JButton btn3 = new JButton("고객피드백");
        JButton prevButton = new JButton("이전");
        
        // "날짜/시간" 버튼 클릭 이벤트 처리
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 버튼 클릭 시
                Checkout2.main(new String[0]);  // Checkout2 프레임 보이기
                frame.setVisible(false);  // 현재 프레임 숨기기
            }
        });
        
        // "청구서발행" 버튼 클릭 이벤트 처리
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 버튼 클릭 시
                bil.main(new String[0]);  // bil 프레임 보이기
                frame.setVisible(false); // 현재 프레임 숨기기
            }
        });
        
        // "고객피드백" 버튼 클릭 이벤트 처리
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 버튼 클릭 시
                feedback.main(new String[0]);  // bil 프레임 보이기
                frame.setVisible(false); // 현재 프레임 숨기기
            }
        });
                    
        // "이전" 버튼 클릭 이벤트 처리
        prevButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 버튼 클릭 시
                Checkout0.main(new String[0]);  // Checkout0 프레임 보이기
                frame.setVisible(false); // 현재 프레임 숨기기
            }
        });
        
        // 버튼 위치와 크기 설정
        btn1.setBounds(50, 50, 100, 50);
        btn2.setBounds(50, 150, 100, 50);
        btn3.setBounds(50, 250, 100, 50);
        prevButton.setBounds(150, 350, 60, 25);
        
        // 버튼을 프레임에 추가
        frame.add(btn1);
        frame.add(btn2);
        frame.add(btn3);
        frame.add(prevButton);

        // 프레임 크기 설정 및 보이기
        frame.setSize(250, 450);
        frame.setVisible(true);
    }
}