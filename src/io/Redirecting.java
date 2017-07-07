package io;

/**
 * Created by root on 17-7-7.
 */
import java.io.*;

public class Redirecting {
    public static void main(String[] args) throws IOException{
        PrintStream console = System.out;
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("/root/IdeaProjects/ThinkingInJava/src/io/Redirecting.java"));
        PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream("test.out")));
        System.setIn(in);
        System.setOut(out);
        System.setErr(out);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = bf.readLine()) != null) {
            System.out.println("s: " + s);
        }
        out.close();
        System.setOut(console);
    }
}
