/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CheckOut;

import CheckOut.date_time;
import Reserve.BookInput;
import java.io.*;
import java.util.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *
 * @author 이시연
 */
public class add_bill {
    private static int addBill;  // 추가 요금을 저장하는 필드
    
    // addBill getter
    public static int getAddBill() {
        return addBill;
    }

    // addBill setter
    public static void setAddBill(int addBill) {
        add_bill.addBill = addBill;
    }
    
    public static void main(String[] args) {
        date_time datetime = new date_time();  // date_time 객체 생성
        String[] cd = datetime.getCheckout_data();  // 체크아웃 데이터 가져오기
        
        BookInput bookInput = new BookInput();  // BookInput 객체 생성
        String[] bd = bookInput.getBook_data();  // 예약 데이터 가져오기
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("a hh mm");
    
    // 체크아웃 데이터와 예약 데이터를 비교
    for (int i = 0; i < cd.length; i++) {
            try {
                LocalTime time1 = LocalTime.parse(cd[i], formatter);  // 체크아웃 시간 변환
                LocalTime time2 = LocalTime.parse(bd[i], formatter);  // 예약 시간 변환

                // 체크아웃 시간과 예약 시간 비교
                if (time1.isBefore(time2)) {
                    addBill = 0;  // 체크아웃 시간이 이전이면 추가 요금 없음
                } 
                else if (time1.isAfter(time2)) {
                    addBill = 1;  // 체크아웃 시간이 이후면 추가 요금 발생
                } 
                else {
                    addBill = 0;  // 동일한 경우 추가 요금 없음
                }
            } 
            catch (DateTimeParseException e) {
                e.printStackTrace();  // 예외 발생 시 스택 추적 출력
            }
        }
    }
}