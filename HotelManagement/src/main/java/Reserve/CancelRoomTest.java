/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Reserve;
import java.io.IOException;
/**
 *
 * @author 심수훈
 */
public class CancelRoomTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Room room = new Room();
        try{
        room.cancelReserve("19","25");
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
}
