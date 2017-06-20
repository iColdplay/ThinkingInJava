package io;

import java.io.File;

/**
 * Created by root on 17-6-20.
 */
public class DirectoryDemo {
    public static void main(String[] args){
        PPrint.pprint(Directory.walk(".").dirs);

        for(File file : Directory.local(".", "T.*"))
            System.out.println(file);

        for(File file : Directory.local(".", "T.*\\.java"))
            System.out.println(file);

        for(File file : Directory.local(".", ".*[Zz].*\\.java"))
            System.out.println(file);

        PPrint.pprint(Directory.walk("/home/files").dirs);
        
    }
}
