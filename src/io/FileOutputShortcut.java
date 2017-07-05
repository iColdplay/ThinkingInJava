package io; /**
 * Created by root on 17-7-5.
 */

import java.io.*;

public class FileOutputShortcut {
    static String file= "FileOutputShortcut.txt";
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new StringReader(
                BufferedInputFile.read("/root/IdeaProjects/ThinkingInJava/src/FileOutputShortcut.java")
        ));
        PrintWriter out = new PrintWriter(file);
        int lineCount = 1;
        String s;
        while((s = in.readLine()) != null){
            out.println(lineCount++ + ": " +s);
        }
        out.close();
        System.out.println(BufferedInputFile.read(file));
    }
}
