package io;

import java.io.*;
import java.util.logging.Logger;

/**
 * Created by root on 17-7-5.
 */
public class BasicFileOutput {
    static String file = "/home/BasicFileOutput.txt";
    static Logger log = Logger.getLogger("BasicFileOutput");
    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(
                    new StringReader(BufferedInputFile.read("/root/桌面/coldplay")));
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            int lineCount = 1;
            String s;
            log.warning("gonna get in loop");
            while ((s = in.readLine()) != null) {
                out.println(lineCount++ + ": " + s);
                log.warning("finish once loop");
            }
            log.warning("end of this loop");
            out.close();
            System.out.println(BufferedInputFile.read(file));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
