package runtimetypeInfo;

/**
 * Created by root on 17-6-8.
 */
import java.lang.reflect.*;

class WithPrivateFinalField {
    private int i = 1;
    private final String s = "coldplay Loves in Japan";
    public String s2 = "unbreakable song";
    public String toString(){
        return "i: " + i + ", " + s + ", " + s2;
    }

}

public class ModifyingPrivateField{
    public static void main(String[] args) throws Exception{
        WithPrivateFinalField pf = new WithPrivateFinalField();
        System.out.println(pf);
        Field f = pf.getClass().getDeclaredField("i");
        f.setAccessible(true);
        System.out.println("f.getInt(pf): " + f.getInt(pf));
        f.setInt(pf, 47);
        System.out.println(pf);
        f = pf.getClass().getDeclaredField("s");
        f.setAccessible(true);
        System.out.println("f.get(pf): " + f.get(pf));
        f.set(pf, "lij");
        System.out.println(pf);
        f = pf.getClass().getDeclaredField("s2");
        f.setAccessible(true);
        System.out.println("f.get(pf): " + f.get(pf));
        f.set(pf, "lij");
        System.out.println(pf);
    }



}