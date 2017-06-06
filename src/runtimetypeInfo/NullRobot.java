package runtimetypeInfo;

/**
 * Created by root on 17-6-6.
 */
import java.lang.reflect.*;
import java.util.*;

class NullRobotProxyHandler implements InvocationHandler{
    private String nullName;
    private Robot proxied = new NRobot();
    NullRobotProxyHandler(Class<?extends Robot> type){
        nullName = type.getSimpleName() + "NULL";
    }
    private class NRobot implements Null, Robot{
        public String name() {return nullName;}
        public String model() {return nullName;}
        public List<Operation> operations(){
            return Collections.emptyList();
        };
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
        return method.invoke(proxied, args);
    }
}
public class NullRobot {
    public static Robot newNullRobot(Class<? extends Robot> type){
        return (Robot)Proxy.newProxyInstance(
          NullRobot.class.getClassLoader(),
                new Class[]{Null.class, Robot.class},
                new NullRobotProxyHandler(type)
        );
    }
    public static void main(String[] args){
        Robot[] bots = {
          new SnowRemovalRobot("Snow reboot"),
          newNullRobot(SnowRemovalRobot.class)
        };
        for(Robot r : bots)
            Robot.Test.test(r);
    }
}
