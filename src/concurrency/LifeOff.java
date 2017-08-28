package concurrency;

import java.util.concurrent.TimeUnit;

class LifeOff implements Runnable {

    public int count = 10;
    public static int taskCount = 0;
    public final int id = taskCount++;
    public LifeOff(){}
    public LifeOff(int count){
        this.count = count;
    }
    public String status() {
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (Exception e){
            System.out.println("Fucking Exceptions Happens Here");
        }
        return "id: " + id + "CountDown:" + (count > 0 ? count: "LifeOff");
    }
    @Override
    public void run() {
        while (count-- > 0){
            System.out.println(status());
            Thread.yield();
        }
    }
}
