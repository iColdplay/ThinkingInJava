package concurrency;

public class MainThread {
    public static void main(String[] args){
        LifeOff launch = new LifeOff();
        launch.run();
        LifeOff mars = new LifeOff(5);
        mars.run();
    }
}
