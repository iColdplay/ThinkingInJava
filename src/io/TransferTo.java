package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * Created by root on 17-7-12.
 */
public class TransferTo {
    public static void main(String[] args) throws Exception{
        if(args.length !=2){
            System.out.println("args source dest");
            System.exit(1);
        }
        FileChannel
                in = new FileInputStream(args[0]).getChannel(),
                out = new FileOutputStream(args[1]).getChannel();
        in.transferTo(0, in.size(), out);
        //or out.transferFrom(in, 0, in.size());
    }
}
