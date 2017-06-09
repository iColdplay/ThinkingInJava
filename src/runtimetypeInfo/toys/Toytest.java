package runtimetypeInfo.toys;

/**
 * Created by root on 17-6-3.
 */
interface HasBatteries {}
interface Waterproof {}
interface Shoots {}

class Toy{
    Toy() {}
    Toy(int i) {}
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots{
    FancyToy () {super(1);}
}

public class Toytest {
    static void printInfo(Class cc){
        System.out.println("Class Name:" + cc.getName() + "\n" + "is interface? " + cc.isInterface());
        System.out.println("Simple Name:" + cc.getSimpleName());
        System.out.println("Canonical Name:"+ cc.getCanonicalName());
    }
    public static void main(String[] args){
        Class c = null;
        try{
            c = Class.forName("runtimetypeInfo.toys.FancyToy");
        }catch(ClassNotFoundException e){
            System.out.println("can not find FancyToy");
            System.exit(1);
        }
        printInfo(c);
        for(Class face : c.getInterfaces()){
            printInfo(face);
        }
        Class up = c.getSuperclass();
        Object obj = null;
        try{
            obj = up.newInstance();
        }catch (InstantiationException e){
            System.out.println("can not instantiate");
            System.exit(1);
        }catch(IllegalAccessException e){
            System.out.println("can not access");
            System.exit(1);
        }
        printInfo(obj.getClass());
    }
}

//Class.forName() 必须使用全限定名
//getSuperclass() 你可以在运行时 获得一个对象的完整的类继承结构
//Class的newInstance() 实现虚拟构造器 表明 我不知道你的确切类型但是仍然要正确的创建你