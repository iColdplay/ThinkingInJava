package generic;

/**
 * Created by liuyi on 2017/6/4.
 */
class Amphibian{}
class Vehicle{}
public class TupleTest {
    static TwoTuple<String,Integer> f(){
        return new TwoTuple<String,Integer>("hi", 47);
    }
    static ThreeTuple<Amphibian,String,Integer> g(){
        return new ThreeTuple<Amphibian,String ,Integer>(new Amphibian(), "hi", 47);
    }
    public static void main(String[] args){
        TwoTuple<String,Integer> ttsi = f();
        System.out.println(ttsi);
        System.out.print(g());
    }
}
//定义适合长度的元组 然后在返回时 创建该元组