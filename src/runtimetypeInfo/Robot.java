package runtimetypeInfo;

/**
 * Created by root on 17-6-6.
 */
import java.util.*;

public interface Robot {
    String name();
    String model();
    List<Operation> operations();
    class Test{
        public static void test(Robot r){
            if(r instanceof Null)
                System.out.println("NULL robot");
            System.out.println("RobotName: "+r.name());
            System.out.println("RobotModel: "+r.model());
            for(Operation operation : r.operations()){
                System.out.println(operation.description());
                operation.command();
            }
        }
    }
}
