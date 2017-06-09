package string;
import java.io.BufferedReader;
import java.io.StringReader;
import java.util.*;
import java.util.stream.StreamSupport;

/**
 * Created by root on 17-6-3.
 */
public class BetterRead {
    public static void main(String[] arg){
        Scanner stdin = new Scanner(new BufferedReader(new StringReader("line1 \n 1 \n 2.2 \n 2.2")));
        System.out.println("what is your name");
        String name = stdin.nextLine();
        System.out.println(name);
        System.out.println("show the nextLine in of your stdin");
        int age = stdin.nextInt();
        double favorites = stdin.nextDouble();
        System.out.println(age);
        System.out.println(favorites);

    }
}

//Scanner 构造器 接受 File InputStream String Readable