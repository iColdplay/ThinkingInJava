package generic;

/**
 * Created by liuyi on 2017/6/4.
 */
public class ThreeTuple <A,B,C> extends TwoTuple<A,B>{
    public final C third;
    public ThreeTuple(A a, B b, C c){
        super(a,b);
        third = c;
    }
    public String toString(){
        return "(" + first + " . " + second + " . " + third + ")";
    }
}

//扩展多维元组是非常简单的事情