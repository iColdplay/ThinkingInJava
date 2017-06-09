package runtimetypeInfo;

/**
 * Created by root on 17-6-6.
 */
import java.util.*;
public class SnowRemovalRobot implements Robot{
    private String name;
    private String model;
    public SnowRemovalRobot(String name){
        this.name = name;
    }
    @Override
    public String name() {
        return name;
    }

    @Override
    public String model() {
        return "Snow Robot";
    }

    @Override
    public List<Operation> operations() {
        return Arrays.asList(
            new Operation(){
                public String description(){
                    return name + "cab shovel snow";
                }
                public void command(){
                    System.out.println(name + "operation1");
                }
            },
            new Operation(){
                public String description(){
                    return name + "cab eat snow";
                }
                public void command(){
                    System.out.println(name + "operation2");
                }
            },
            new Operation(){
                public String description(){
                    return name + "cab create snow";
                }
                public void command(){
                    System.out.println(name + "operation3");
                }
            }
        );
    }
    public static void main(String[] args){
        Robot.Test.test(new SnowRemovalRobot("coldplay"));
    }
}
