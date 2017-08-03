package io;

import java.nio.channels.*;
import java.util.concurrent.*;
import java.io.*;

public class FileLocking {
    public static void main(String[] args) throws Exception{
        FileOutputStream fos = new FileOutputStream("file.txt");
        FileLock fileLock = fos.getChannel().tryLock();
        if(fileLock != null){
            System.out.println("Lock File");
            TimeUnit.MICROSECONDS.sleep(100);
            fileLock.release();
            System.out.println("Released Lock");
        }
        fos.close();
    }
}

//you get a FileLock on the entire file by calling either tryLock() or lock() on a file channel
//tryLock() is non-blocking, it tries to grab the lock, but if it cannot, it simply return from the recent call
//lock() blocking until the lock is required, or the thread that invoke lock() is interrupted, or the channel on which the lock() method is called is closed.
//A lock is released using FileLock.release()

//it is also possible to lock a part of the file by using
//tryLock(long position, long size, boolean shared)
//lock(long position, long size, boolean shared)
//which locks the region size-position. the third argument specifies whether this lock is shared

//although the zero-argument locking methods adapted to changes in the size of a file, locks with a fixed size do not change if the file size chaneges.
//if a lock is acquired for a region from position to position+size and the file increased beyond position+size, then the section beyond positio+size is not locked.
//the zero-argument locking methods lock the entire file.even if it grows

