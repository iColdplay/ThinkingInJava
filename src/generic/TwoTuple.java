package generic;

/**
 * Created by liuyi on 2017/6/4.
 */
public class TwoTuple<A,B> {
    public final A first;
    public final B second;
    public TwoTuple(A a, B b){
        first = a;
        second = b;
    }
    public String toString(){
        return "(" + first + " . " + second + ")";
    }
}

//二维元组 可以存放两个对象的类型
//构造器补货了需要存储的对象

