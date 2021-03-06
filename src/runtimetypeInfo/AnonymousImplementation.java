package runtimetypeInfo;

import runtimetypeInfo.interfacea.A;

/**
 * Created by root on 17-6-8.
 */
class AnonymousA{
    public static A makeA(){
        return new A(){
            @Override
            public void f() {
                System.out.println("C.f()");
            }

            public void g(){
                System.out.println("C.g()");
            }

            void u(){
                System.out.println("C.u()");
            }

            protected void v(){
                System.out.println("C.v()");
            }

            private void w(){
                System.out.println("C.w()");
            }
        };
    }
}
public class AnonymousImplementation {
    public static void main(String[] args) throws Exception{
        A a = AnonymousA.makeA();
        a.f();
        HiddenImplementation.callHiddenMethod(a,"g");
        HiddenImplementation.callHiddenMethod(a,"v");
        HiddenImplementation.callHiddenMethod(a,"u");
        HiddenImplementation.callHiddenMethod(a,"w");
    }
}
