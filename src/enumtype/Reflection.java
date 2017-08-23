package enumtype;

import io.OSExecute;

import java.lang.reflect.*;
import java.util.Set;
import java.util.TreeSet;

enum Explore { HERE, THERE}

public class Reflection {
    public static Set<String> analyze(Class<?> enumClass){
        System.out.println("=====Analyzing " + enumClass + "++++++");
        System.out.println("Interface");
        for(Type t : enumClass.getGenericInterfaces()){
            System.out.println(t);
        }
        System.out.println("Base" + "\n" + enumClass.getSuperclass());
        System.out.println("Methods");
        Set<String> methods = new TreeSet<String>();
        for (Method m : enumClass.getMethods()){
            methods.add(m.getName());
        }
        System.out.println(methods);
        return methods;
    }
    public static void main(String[] args){
        Set<String> exploreMethods = analyze(Explore.class);
        Set<String> enumMethods = analyze(Enum.class);
        System.out.println(exploreMethods);
        System.out.println(enumMethods);
        OSExecute.command("javap Explore");
    }
}
