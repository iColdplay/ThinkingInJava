package runtimetypeInfo;

/**
 * Created by root on 17-7-28.
 */

//class Super{
//    public int a = 10;
//    public int b = 10;
//    int getA(){
//        System.out.print("a = " + a);
//        return this.a;
//    }
//}
//public class ThisAndSuper extends Super{
//    public int a = 20;
//    int getA(){
//        System.out.println(this.a);
//        System.out.print(super.a);
//        return 1;
//    }
//    public static void main(String[] args){
//        ThisAndSuper ob = new ThisAndSuper();
//        ob.getA();
//    }
//}
public class ExtendsTest {
    public static void main(String[] args) {
        ChildClass test = new ChildClass();
        test.a = 1;
        System.out.println(test.a);
        test.showSuperA();




        System.out.println("obj before : " + test.obj + "," + test.getSuperObj());
        test.obj = new TestObj();
        System.out.println("obj after : " + test.obj + "," + test.getSuperObj() + ",  " + (test.obj == test.getSuperObj()));
    }
}

class MySupserClass{
    public int a = 0;
    public TestObj obj = new TestObj();
}

class ChildClass extends MySupserClass {
    public void showSuperA(){
        System.out.println(super.a);
    }
    public TestObj getSuperObj(){
        return super.obj;
    }
}

class TestObj {

}