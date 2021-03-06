package io;

import java.io.*;
import java.nio.*;
import java.nio.channels.*;

public class MappedIO {
    private static int numberOfInts = 4000000;
    private static int numberOfUbuffInts = 200000;
    private abstract static class Tester{
        private String name;
        public Tester(String name){ this.name = name;}
        public void runTest(){
            System.out.println(name + ": ");
            try {
                long start = System.nanoTime();
                test();
                double duration = System.nanoTime() - start;
                System.out.format("%.2f\n", duration/1.0e9);
            }catch (IOException e){
                throw new RuntimeException(e);
            }
        }
        public abstract void test() throws IOException;
    }
    private static Tester[] test = {
            new Tester("Stream Write") {
                public void test() throws IOException {
                    DataOutputStream dos =
                            new DataOutputStream(
                                    new BufferedOutputStream(
                                            new FileOutputStream(new File("temp.tmp"))
                                    )
                            );
                    for (int i = 0; i < numberOfInts; i++) {
                        dos.write(i);
                    }
                    dos.close();
                }
            },
            new Tester("Mapped Write") {
                public void test()  {
                    try {
                        FileChannel fc = new RandomAccessFile("temp.tmp", "rw").getChannel();
                        System.out.println("show the fc.size-->" + fc.size());
                        IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size()).asIntBuffer();
                        System.out.println("show the ib.limit-->" + ib.limit());
                        for (int i = 0; i < numberOfInts; i++) {
                            //System.out.println("show put data-->" + i);
                            ib.put(i);
                        }
                        fc.close();
                    }catch (Exception e){
                        System.out.println("we got a exception here");
                        e.printStackTrace();
                    }
                }
            },
            new Tester("Stream Read") {
                @Override
                public void test() throws IOException {
                    DataInputStream dis =
                            new DataInputStream(
                                    new BufferedInputStream(
                                            new FileInputStream(new File("temp.tmp"))
                                    )
                            );
                    for (int i = 0; i < numberOfInts; i++) {
                        dis.readInt();
                    }
                    dis.close();
                }
            },
            new Tester("Mapped read") {
                @Override
                public void test() throws IOException {
                    FileChannel fc = new RandomAccessFile("temp.tmp", "rw").getChannel();
                    IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size()).asIntBuffer();
                    while (ib.hasRemaining()) {
                        ib.get();
                    }
                    fc.close();
                }
            },
            new Tester("Stream Read/Write") {
                @Override
                public void test() throws IOException {
                    RandomAccessFile raf = new RandomAccessFile(new File("temp.tmp"), "rw");
                    raf.writeInt(1);
                    for (int i = 0; i < numberOfInts; i++) {
                        raf.seek(raf.length() - 4);
                        raf.writeInt(raf.readInt());
                    }
                    raf.close();
                }
            },
            new Tester("Mapped Read/Write") {
                @Override
                public void test() throws IOException {
                    FileChannel fc = new RandomAccessFile(new File("temp.tmp"), "rw").getChannel();
                    IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size()).asIntBuffer();
                    ib.put(0);
                    for (int i = 0; i < numberOfInts; i++) {
                        ib.put(ib.get(i - 1));
                    }
                    fc.close();
                }
            }
    };

    public static void main(String[] args){
        for (Tester t : test){
            t.runTest();
        }
    }

}
