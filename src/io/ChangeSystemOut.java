package io;

import java.io.PrintWriter;

/**
 * Created by root on 17-7-7.
 */
public class ChangeSystemOut {
    public static void main(String[] args){
        PrintWriter out = new PrintWriter(System.out, true);
        out.println("Music World");
    }
}
