package concurrency;
import java.util.concurrent.*;

import static java.lang.Thread.MAX_PRIORITY;
import static java.lang.Thread.MIN_PRIORITY;

public class SimplePriorities implements Runnable{
    private int countDown = 5;
    private volatile double d;
    private int priority;
    public SimplePriorities(int priority){
        System.out.println("Constructor");
        this.priority = priority;
    }
    public String toString(){
        return Thread.currentThread() + ": " + countDown;
    }
    public void run(){
        long start = System.currentTimeMillis();
        System.out.println("Start :" + start);
        Thread.currentThread().setPriority(priority);
        while (true){
            for(int j = 1; j < 3; j++) {
                for (int i = 1; i < 1000000000; i++) {
                    d += (Math.PI + Math.E) / (double) i;
                    if (i % 1000 == 0) {
                        Thread.yield();
                    }
                }
                System.out.println(this);
                if (--countDown == 0) {
                    System.out.println("Duration :" + System.currentTimeMillis());
                    return;
                }
            }
        }
    }
    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++) {
            exec.execute(new SimplePriorities(MIN_PRIORITY));
        }
        exec.execute(new SimplePriorities(MAX_PRIORITY));
        exec.shutdown();
    }
}
//Inside run( ), 100,000 repetitions of a rather expensive floating point calculation are performed, involving double addition and division.
//run方法中，100000次循环计算相当耗时的浮点运算，调用到了double类型的加法和除法
//The variable d is volatile to try to ensure that no compiler optimizations are performed.
//变量d被声明为易变的，来确保编译器不会做任何的优化动作
//Without this calculation, you don’t see the effect of setting the priority levels. (Try it: Comment out the for loop containing the double calculations.)
//如果不做这样的计算，难以看出设置优先级的影响，可以试试将计算注释掉
//With the calculation, you see that the thread with MAX_PRIORITY is given a higher preference by the thread scheduler.
//通过计算可以发现，高优先级的线程将被线程计划给予一个更高的优先权

//?理解Java线程优先级的含义
