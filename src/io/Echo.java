package io;

/**
 * Created by root on 17-7-7.
 */
//: io/Echo.java
import java.io.*;
public class Echo {
    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(
                new InputStreamReader(System.in));
        String s;
        while((s = stdin.readLine()) != null && s.length()!= 0)
            System.out.println(s);
// An empty line or Ctrl-Z terminates the program
    }
}
