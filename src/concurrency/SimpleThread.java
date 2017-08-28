package concurrency;

public class SimpleThread extends Thread {
    private int countDown = 5;
    private static int threadCount = 0;
    public SimpleThread(){
        //store the thread name
        super(Integer.toString(++threadCount));
        System.out.println("#Thread" + getName() + " start");
        start();
    }
    public String toString(){
        return "#Thread" + getName() + "\n(" + countDown + ")";
    }
    public void run(){
        while (true){
            System.out.println(this);
            if(--countDown == 0){
                return;
            }
        }
    }
    public static void main(String[] args){
        for(int i = 0; i < 5; i++){
            new SimpleThread();
        }
    }
}
