package runtimetypeInfo;
import java.util.*;
/**
 * Created by root on 17-6-3.
 */
class Initable{
    static final int staticFinal = 47;
    static final int staticFinal2 = ClassInitialization.rand.nextInt(1000);
    static{
        System.out.println("Initializing Initable");
    }
}

class Initable2{
    static int staticNonFinal = 147;
    static {
        System.out.println("Initializing Initable2");
    }
}

class Initable3{
    static int staticNonFinal = 74;
    static {
        System.out.println("Initializing Initable3");
    }
}

public class ClassInitialization {
    public static Random rand = new Random(47);
    public static void main(String[] args) throws Exception{
        Class initable = Initable.class;
        System.out.println("after creating Initable");
        System.out.println(Initable.staticFinal);
        System.out.println(Initable.staticFinal2);
        System.out.println(Initable2.staticNonFinal);
        //Class initable3 = Class.forName("Initable3");
        Class initable3 = Initable3.class;
        System.out.println("after creating Initable3");
        System.out.println(Initable3.staticNonFinal);
    }
}
//Java 1.8 Class.forName() 不会再造成初始化了
//创建.class 对象不会造成初始化
//使用静态成员将造成对象的初始化 也就是 初始化动作被延迟到了对静态方法 或者非常数静态域进行首次引用时才执行
//static final 形容的 编译期常量 访问时也也不会触发初始化

