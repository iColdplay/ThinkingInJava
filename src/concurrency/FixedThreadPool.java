package concurrency;
import java.util.concurrent.*;

public class FixedThreadPool {
    public static void main(String[] args){
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for(int i = 0; i < 5; i++){
            exec.execute(new LifeOff());
        }
        exec.shutdown();
    }
}
//With the FixedThreadPool you do expensive thread allocation one,up front,
//you limit the number of threads.
//This saves time because you are not constantly paying for thread creation overhead for every single task
//event handlers that require threads can be serviced as quickly as you want by simply fetching threads form the pool
//you do not overrun the available resources because the FixedThreadPool uses a bounded number of Thread Objects.