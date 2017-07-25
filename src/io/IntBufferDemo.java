package io;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * Created by root on 17-7-25.
 */
public class IntBufferDemo {
    private static final int BSIZE = 1024;
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        IntBuffer ib = bb.asIntBuffer();
        //store an int array
        ib.put(new int[]{43, 45, 5646, 499, 132165, 46546});
        System.out.println(ib.get(3));
        ib.put(3, 1811);
        // Setting a new limit before rewinding the buffer.
        ib.flip();
        while (ib.hasRemaining()) {
            int i = ib.get();
            System.out.println(i);
        }
    }
}
