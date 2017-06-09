package runtimetypeInfo;

/**
 * Created by root on 17-6-5.
 */
import java.lang.reflect.*;

class MethodSelector implements InvocationHandler{
    private Object proxied;
    public MethodSelector(Object proxied){
        this.proxied = proxied;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("interesting"))
            System.out.println("Proxy detected the interesting method");
        return method.invoke(proxied,args);
    }
}

interface SomeMethod{
    void boring1();
    void boring2();
    void interesting(String args);
    void boring3();
}

class Implementation implements SomeMethod{

    @Override
    public void boring1() {
        System.out.println("boring1");
    }

    @Override
    public void boring2() {
        System.out.println("boring2");
    }

    @Override
    public void interesting(String args) {
        System.out.println("interesting args:" + args);
    }

    @Override
    public void boring3() {
        System.out.println("boring3");
    }
}
public class SelectingMethods {
    public static void main(String[] args){
        SomeMethod proxy = (SomeMethod)Proxy.newProxyInstance(
          SomeMethod.class.getClassLoader(),
                new Class[]{SomeMethod.class},
                new MethodSelector(new Implementation())
        );
        proxy.boring1();
        proxy.boring2();
        proxy.boring3();
        proxy.interesting("beatsound Sustain");
    }
}
