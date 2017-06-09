package runtimetypeInfo;

/**
 * Created by root on 17-6-5.
 */
interface Interface{
    void doSomething();
    void somethingElse(String arg);
}

class RealObject implements Interface{
    public void doSomething(){
        System.out.println("doSomething");
    }
    public void somethingElse(String arg){
        System.out.println("somethingElse arg:" + arg);
    }
}

class SimpleProxy implements Interface{
    private Interface proxied;
    public SimpleProxy(Interface proxied){
        this.proxied =  proxied;
    }

    @Override
    public void doSomething() {
        System.out.println("SimpleProxy doSomething");
        proxied.doSomething();
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("SimpleProxy somethingElse args:" + arg);
        proxied.somethingElse(arg);
    }
}
public class SimpleProxyDemo {
    public static void consumer(Interface iface){
        iface.doSomething();
        iface.somethingElse("time to say good bye");
    }
    public static void main(String[] args){
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }
}
