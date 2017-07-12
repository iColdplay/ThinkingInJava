package io;

/**
 * Created by root on 17-7-11.
 */

import java.nio.*;
import java.nio.channels.*;
import java.io.*;

public class ChannelCopy {
    private static final int BSIZE = 1024;
    public static void main(String[] args) throws Exception{
        /*if(args.length != 2){
            System.out.println("args source file dest file");
            System.exit(1);
        }*/
        String[] test = new String[]{"/root/桌面/一年的周报","/root/桌面/无标题文档"};
        test(test);
    }

    public static void test(String[] args) throws Exception{
        if(args.length >= 2){
            FileChannel in = new FileInputStream(args[0]).getChannel();
            FileChannel out = new FileOutputStream(args[1]).getChannel();
            ByteBuffer bf = ByteBuffer.allocate(BSIZE);
            while(in.read(bf) != -1){
                bf.flip();
                out.write(bf);
                bf.clear();
            }
        }
    }
}
