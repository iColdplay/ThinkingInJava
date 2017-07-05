package io;

import java.io.*;

/**
 * Created by root on 17-7-5.
 */
public class TestEOF {
    public static void main(String[] args) throws IOException{
        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("/root/IdeaProjects/ThinkingInJava/src/io/TestEOF.java")));
        while(in.available() != 0){
            System.out.print((char)in.readByte());
        }
    }
}
