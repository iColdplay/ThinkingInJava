package concurrency;

import java.util.concurrent.*;

public class SingleThreadExecutor {
    public static void main(String[] args){
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for(int i = 0; i < 5; i++){
            exec.execute(new LifeOff());
        }
        exec.shutdown();
    }
}
//if more than one task is submitted to a SingleThreadExecutor, the task will be queued and each task will run to completion before the next
//all using same thread
//a SingleThreadExecutor serialize the tasks that are submitted to it, and maintains its own (hidden) queue of pending tasks