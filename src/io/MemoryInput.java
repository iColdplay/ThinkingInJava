package io;

import java.io.*;
/**
 * Created by root on 17-6-30.
 */
public class MemoryInput {
    public static void main(String[] args) throws IOException{
        StringReader in = new StringReader(BufferedInputFile.read("/root/IdeaProjects/ThinkingInJava/src/io/MemoryInput.java"));
        System.out.println("10");
        int c;
        System.out.println("12");
        while((c = in.read()) != -1){
            System.out.println("14");
            System.out.println((char) c );
        }
    }
}

