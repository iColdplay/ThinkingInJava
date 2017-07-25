package io;

import java.nio.ByteBuffer;

/**
 * Created by root on 17-7-19.
 */
public class GetData {
    public static final int BSIZE = 1024;
    public static void main(String[] args){
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        //Allocation automatically zeroes the ByteBuffer
        int i = 0;
        while (i++ < bb.limit()) {
            if (bb.get() != 0) {
                System.out.println("nonzero");
            }
        }
        System.out.println("i= " + i);
        bb.rewind();
        //store and read a char array away
        bb.asCharBuffer().put("Howdy");
        char c;
        while ((c = bb.getChar()) != 0){
            System.out.print(c);
        }
        System.out.println();
        bb.rewind();
        //store and read a short
        bb.asShortBuffer().put((short)417742);
        System.out.println(bb.getShort());
        bb.rewind();
        //store and read an int
        bb.asIntBuffer().put((Integer)1215651651);
        System.out.println(bb.getInt());
        bb.rewind();

    }
}
