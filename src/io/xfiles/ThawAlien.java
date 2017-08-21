package io.xfiles;

import java.io.*;

public class ThawAlien  {
    public static void main(String[] args)throws Exception{
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("/root/IdeaProjects/ThinkingInJava/X.file")));
        Object mystery = in.readObject();
        System.out.println(mystery.getClass());
    }
}
