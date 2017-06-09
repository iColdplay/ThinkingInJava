package generic;

/**
 * Created by liuyi on 2017/6/4.
 */
class Automobile{}
public class Holder1 {
    private Automobile a;
    public Holder1(Automobile a){
        this.a = a;
    }
    Automobile get(){
        return a;
    }
}
//仅仅可以持有一个具体类型
