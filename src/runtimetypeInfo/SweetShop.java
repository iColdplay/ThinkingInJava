package runtimetypeInfo;

/**
 * Created by root on 17-6-3.
 */
class Candy{
    static { System.out.println("Loading Candy");}
}

class Gum{
    static { System.out.println("Loading Gum");}
}

class Cookie{
    static { System.out.println("Loading Cookie");}
}

public class SweetShop {
    public static void main(String[] args){
        System.out.println("now we are inside main()");
        new Candy();
        System.out.println("After creating Candy");
        try{
            System.out.println("now we try to find class Gum ");
            Class.forName("Gum");
        }catch(ClassNotFoundException e){
            System.out.println("now we could not find class Gum ");
        }
        System.out.println("After we use Class.forName Gum");
        new Cookie();
        System.out.println("After we create Cookie");
    }
}

//class对象仅仅在需要的时候才被加载 static初始化也是在被加载的时候进行的

