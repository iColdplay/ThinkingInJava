package generic;

/**
 * Created by liuyi on 2017/6/4.
 */
public class Holder2 {
    private Object a;
    public Holder2(Object a){this.a = a;}
    public void set(Object a){this.a = a;}
    public Object get(){return a;}
    public static void main(String[] args){
        Holder2 h2 = new Holder2(new Automobile());
        Automobile a = (Automobile)h2.get();
        h2.set("not an Automobile");
        String s = (String)h2.get();
        h2.set(1);
        Integer x = (Integer) h2.get();
    }
}

//可以存储多种对象的类