package io;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.charset.Charset;

/**
 * Created by root on 17-7-27.
 */
public class ViewBuffer {
    public static void main(String[] args){
        ByteBuffer bb = ByteBuffer.wrap(new byte[]{0, 0, 0, 0, 0, 0, 0, 'a' });
        bb.rewind();
        System.out.println("ByteBuffer");
        while (bb.hasRemaining()){
            System.out.print(bb.position() + "->" + bb.get() + ", ");
        }
        System.out.println();
        CharBuffer cb = ((ByteBuffer)bb.rewind()).asCharBuffer();
        System.out.println("CharBuffer");
        while (cb.hasRemaining()){
            System.out.print(cb.position() + "->" + cb.get() + ", ");
        }
        System.out.println();
        FloatBuffer fb = ((ByteBuffer)bb.rewind()).asFloatBuffer();
        System.out.println("FloatBuffer");
        while (fb.hasRemaining()){
            System.out.print(fb.position() + "->" + fb.get() + ", ");
        }
        System.out.println();
        IntBuffer ib = ((ByteBuffer)bb.rewind()).asIntBuffer();
        System.out.println("IntBuffer");
        while (ib.hasRemaining()){
            System.out.print(ib.position() + "->" + ib.get() + ", ");
        }
    }
}
