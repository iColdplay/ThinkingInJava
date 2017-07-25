package io;

/**
 * Created by root on 17-7-14.
 */

import java.nio.charset.*;
import java.util.*;

public class AvailableCharSets {
    public static void main(String[] args){
        SortedMap<String,Charset> charSets = Charset.availableCharsets();
        Iterator<String> it = charSets.keySet().iterator();
        while (it.hasNext()){
            String csName = it.next();
            System.out.println(csName);
            Iterator aliases = charSets.get(csName).aliases().iterator();
            if(aliases.hasNext()){
                System.out.println(": ");
            }
            while (aliases.hasNext()){
                System.out.print(aliases.next());
                if(aliases.hasNext()){
                    System.out.println(",");
                }
            }
            System.out.println(" ");
        }
    }
}
