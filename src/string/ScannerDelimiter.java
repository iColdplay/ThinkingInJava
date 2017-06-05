package string;
import java.util.*;
/**
 * Created by root on 17-6-3.
 */
public class ScannerDelimiter {
    public static void main(String[] args){
        Scanner scanner = new Scanner ("12, 42, 456, 23, 88");
        scanner.useDelimiter("\\s*,\\s");
        while(scanner.hasNext()){
            System.out.println(scanner.nextInt());
        }
    }
}

//Scanner 可以使用界定符号

