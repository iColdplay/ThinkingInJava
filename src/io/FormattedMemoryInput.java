package io;
import org.omg.CORBA.TRANSACTION_MODE;

import java.io.*;
/**
 * Created by root on 17-6-30.
 */
public class FormattedMemoryInput {
    public static void main(String[] args) throws IOException{
        try{
            DataInputStream in = new DataInputStream(
                    new ByteArrayInputStream(BufferedInputFile.read("/root/桌面/formattedMemoryInput").getBytes()));
            while(true){
                System.out.println((char) in.readByte());
            }
        }catch (Exception e){
            System.out.println("end of stream");
            e.printStackTrace();
        }
    }

}
