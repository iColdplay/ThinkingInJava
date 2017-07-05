package io;

import java.io.*;

/**
 * Created by root on 17-7-5.
 */
public class StoringAndRecoveringData {
    public static void main(String[] args) throws IOException{
        DataOutputStream out = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream("Data.txt")));
        out.writeDouble(3.14159);
        out.writeUTF("that was pi ?");
        out.writeDouble(1.41413);
        out.writeUTF("square root of 2");
        out.close();
        DataInputStream in = new DataInputStream(
                new BufferedInputStream(new FileInputStream("Data.txt")));
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
    }
}
