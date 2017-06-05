package string;
import com.sun.jmx.snmp.internal.SnmpSubSystem;

import java.lang.reflect.Array;
import java.util.*;
/**
 * Created by root on 17-6-3.
 */
public class ReplacingStringTokenizer {
    public static void main(String[] args){
        String input = "But I am not dead yet! I feel dead!";
        StringTokenizer stoke = new StringTokenizer(input);
        while (stoke.hasMoreElements()){
            System.out.println(stoke.nextToken() + " ");
        }
        System.out.println();
        System.out.println(Arrays.toString(input.split(" ")));
        Scanner scanner = new Scanner(input);
        while(scanner.hasNext()){
            System.out.println(scanner.next() + " ");
        }
    }
}
//Scanner 已经可以替代 StringTokenizer