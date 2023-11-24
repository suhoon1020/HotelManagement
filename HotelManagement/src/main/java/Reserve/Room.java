/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reserve;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author 심수훈
 */
public class Room {

    private static Room roomClass = new Room();

    public static Room getRoomClass() {
        if (roomClass == null) {
            roomClass = new Room();
        }
        return roomClass;
    }

    private final String FILE_NAME = "ROOM.txt";
    private final String RESERVE_FILE_NAME = "ReservedRoom.txt";
    private final String FILE_PATH = "ROOM.txt";
    private final String RESERVE_FILE_PATH = "ReservedRoom.txt";

    ArrayList<Integer> room = new ArrayList<>();
    File file = new File(FILE_NAME);
    File reserveFile = new File(RESERVE_FILE_NAME);
    
    boolean reserved = false;
    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean isReserved) {
        this.reserved = isReserved;
    }

    public void makeRoom() { //방 100개 생성 , 이미 생성 된 파일 있으면 실행 X

        // 이미 방이 생성되었는지 확인
        if (!file.exists()) {
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true));

                // 방 생성
                for (int i = 1; i <= 100; i++) {
                    room.add(i);
                    bw.write(room.get(i - 1) + "/"); // 방 번호를 파일에 기록 (인덱스는 0부터 시작)
                }

                bw.close(); // 파일 닫기
                //System.out.println("방이 생성되었습니다"); 테스트용 코드

            } catch (IOException ex) {
                System.err.println("IOException occurred: " + ex.getMessage());
                ex.printStackTrace(); // Print the stack trace for more information
            }

        } else {
            //테스트용 코드 System.out.println("방이 이미 생성되어있습니다");
        }

    }

    public void addReservedRoomNum(String roomNum) throws IOException { //예약된 방 ReservedRoom.txt에 추가
        if (!reserveFile.exists()) {
            reserveFile.createNewFile();
        }
        BufferedReader reservedRoom_br = new BufferedReader(new InputStreamReader(
                new FileInputStream(RESERVE_FILE_PATH), "UTF-8"));
        System.out.println(reservedRoom_br);
        String reservedRoom = reservedRoom_br.readLine();
        reservedRoom_br.close();
        BufferedWriter reserveFile_bw = new BufferedWriter(new FileWriter(RESERVE_FILE_NAME, true));

        if (reservedRoom == null) {
            System.out.println("reserved room added");
            reserveFile_bw.write(roomNum + "/"); //예약된 방을 reserveFile에 저장
            reserveFile_bw.close();
            return;
        }

        String[] reserveInfo = reservedRoom.split("/", -1);
        ArrayList<String> reserveRoom = new ArrayList<>(Arrays.asList(reserveInfo));

        if (!reserveRoom.contains(roomNum)) {
            reserveFile_bw.write(roomNum + "/"); //예약된 방을 reserveFile에 저장
            reserveFile_bw.close();
            roomClass.setReserved(false);
        } else {
            JOptionPane.showMessageDialog(null, "이미 사용중인 방입니다");
            roomClass.setReserved(true);
            throw new IOException("이미 사용중인 방입니다.");
        }
    }

    public void removeReservedRoomNum(String roomNum) throws IOException { //ReservedRoom.txt에서 방 삭제
        BufferedReader reservedRoom_br = new BufferedReader(new InputStreamReader(
                new FileInputStream(RESERVE_FILE_PATH), "UTF-8"));
        String[] reserveInfo = reservedRoom_br.readLine().split("/");
        ArrayList<String> reserveRooms = new ArrayList<>(Arrays.asList(reserveInfo));

        BufferedWriter reserveFile_bw = new BufferedWriter(new FileWriter(RESERVE_FILE_NAME, false));
        if (!reserveFile.exists()) {
            reserveFile.createNewFile();
        }

        for (String room : reserveRooms) {
            if (!room.equals(roomNum)) {
                reserveFile_bw.write(room + "/");
            }
        }
        reserveFile_bw.close();
        reservedRoom_br.close();
    }

    public void addRoomNum(String roomNum) throws IOException { // Room.txt에 0->RoomNum으로 변경
        BufferedReader room_br = new BufferedReader(new InputStreamReader(
                new FileInputStream(FILE_PATH), "UTF-8"));

        String[] roomInfo = room_br.readLine().split("/");//Room 파일 텍스트 /로 끊어서 저장
        roomInfo[Integer.parseInt(roomNum) - 1] = roomNum; // 0 -> 방번호 변경.
        //System.out.println(Arrays.toString(roomInfo)); 테스트용 코드
        ArrayList<String> rooms = new ArrayList<>(Arrays.asList(roomInfo));

        BufferedWriter room_bw = new BufferedWriter(new FileWriter(FILE_NAME, false));

        for (String room : rooms) {
            room_bw.write(room + "/");
        }
        room_bw.close();
        room_br.close();
    }
    
    public void removeRoomNum(String roomNum) throws IOException { //Room.txt에 roomNum->0으로 변경
        BufferedReader room_br = new BufferedReader(new InputStreamReader(
                new FileInputStream(FILE_PATH), "UTF-8"));

        String[] roomInfo = room_br.readLine().split("/");//Room 파일 텍스트 /로 끊어서 저장

        BufferedWriter room_bw = new BufferedWriter(new FileWriter(FILE_NAME, false));

        for (String room : roomInfo) {//room 파일에 해당방 번호를 0으로 바꿔서 덮어쓰기 한다
            if (room.equals(roomNum)) {
                room = "0";
            }
            room_bw.write(room + "/");
        }
        room_bw.close();
        room_br.close();
    }

    public void reserveRoom(String roomNum) throws IOException {
        /*
        1. roomNum << 사용자가 입력한 값.

        2. ROOM.txt -> 해당 방 번호 0으로 변환.

        3. ReservedRoom -> roomNum 추가.
         */

        BookInput bi = new BookInput();

        addReservedRoomNum(roomNum);//리스트에 방번호가 있으면 이미 예약된 방이라고 표시를한다.
        removeRoomNum(roomNum);
        boolean reserved = roomClass.isReserved();
        if (!reserved) {
            bi.setVisible(true);
            bi.setjTextRoomNum(roomNum);
        }

    }

    public void deleteFile(String uniqueNum) {
        /*
        고유번호(uniqueNum)을 읽어와서 파일 삭제
        */
        try {

            String uniqueFileName = uniqueNum + ".txt"; //고유번호파일 이름
            //System.out.println(uniqueFileName); //테스트용 출력

            File deleteFile = new File(uniqueFileName);
            deleteFile.delete();

            JOptionPane.showMessageDialog(null, "고객 번호 삭제 완료");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cancelReserve(String uniqueNum, String roomNum) throws IOException {

        //방 번호는 고유번호 파일의 4번째 값을 읽어오면 됨 o
        //고유 번호 입력을 받아왔는데 해당 고유번호가 없으면 없다고 출력 o
        //만약 리저브 파일이 없으면 파일이 없다고 출력 o
        //리저브 파일이 있으면 리저브 파일에 있는 입력된 방번호를 삭제
        //룸 파일에 0으로 설정된 값을 다시 방번호로 복구
        
        /*
        고유번호 받아와서
        Room.txt 원상복구
        Reserved.txt 해당 방 번호 삭제
        고유번호 파일 삭제
         */
        addRoomNum(roomNum);
        removeReservedRoomNum(roomNum);
        deleteFile(uniqueNum);
    }

}
