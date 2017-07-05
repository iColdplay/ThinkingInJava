package io;

import java.io.*;

/**
 * Created by root on 17-6-22.
 */
public class BufferedInputFile {
    //Throw exceptions to console
    public static String read(String filename) throws IOException{
        //Reading input by lines
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        StringBuilder sb = new StringBuilder();
        while((s = in.readLine()) != null){
                sb.append(s + "\n");
        }
        in.close();
        return sb.toString();
    }
    public static void main(String[] args) throws IOException{
        //System.out.print(read("/root/桌面/CO1DPLAY"));
        PPrint.pprint(Directory.walk("/home/file_file").files);
        for(File file : Directory.walk("/home/file_file").files){
            System.out.println(file.getCanonicalPath());
            System.out.println(read(file.getCanonicalPath()));
        }
    }
}

