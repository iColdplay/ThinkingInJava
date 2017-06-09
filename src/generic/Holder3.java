package generic;

/**
 * Created by liuyi on 2017/6/4.
 */
public class Holder3<T> {
    private T a;
    public Holder3 (T a){ this.a = a;}
    public void set(T a){ this.a = a;}
    public T get(){return a;}
    public static void main(String[] args){
        Holder3<Automobile> holder3 = new Holder3<Automobile>(new Automobile());
        Automobile a = holder3.get();
    }
}

//具有类型参数T的 仅仅能存放T类型对象的类
//Java泛型核心概念 告诉编译器想要使用的类型 然后编译器处理一切细节