package io;

/**
 * Created by root on 17-6-8.
 */
import java.awt.*;
import java.lang.reflect.Array;
import java.util.regex.*;
import java.io.*;
import java.util.*;

public class DirList {
    public static void main(String[] args){
        System.out.println(args.length);
        for(int i = 0; i < args.length; i++){
            System.out.println(args[i]);
        }

        File path = new File(".");
        String[] list;
        if(args.length == 0){
            list = path.list();
        }else{
            list = path.list(new DirFilter(args[0]));
        }
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        for(String dirItem : list)
            System.out.println(dirItem);
    }

}
class DirFilter implements FilenameFilter{
    private Pattern pattern;
    public DirFilter(String regex){
        pattern = Pattern.compile(regex);
    }
    public boolean accept(File dir, String name) {
        System.out.println("now we use this method");
        return pattern.matcher(name).matches();
    }
}