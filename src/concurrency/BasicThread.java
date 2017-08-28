package concurrency;

public class BasicThread{
    public static void main(String[] args){
        Thread t = new Thread(new LifeOff());
        t.start();
        System.out.println("after t start()");
        Thread s = new Thread(new LifeOff(12));
        s.start();
        System.out.println("after s start()");
        for(int i =13; i < 33; i++){
            Thread p = new Thread(new LifeOff(i));
            p.start();
        }
    }
}
//the traditional way to turn a Runnable object into a walking task is to hand it to a Thread constructor.
//This example shows how to drive a LifeOff object using a Thread
//A Thread constructor only needs a Runnable object.
//Calling a Thread object's start() will perform the necessary initialization for the thread and then call the Runnable's run() method to start the task.
//any thread can start another thread
//now programming is running two methods at once.
//run() is the code that is executed "simultaneously" with the other threads in a program.
/*
When main( ) creates the Thread objects, it isn’t capturing the references for any of them.
With an ordinary object, this would make it fair game for garbage collection, but not with a
Thread. Each Thread "registers" itself so there is actually a reference to it someplace, and
the garbage collector can’t clean it up until the task exits its run( ) and dies. You can see
from the output that the tasks are indeed running to conclusion, so a thread creates a
separate thread of execution that persists after the call to start( ) completes.
*/