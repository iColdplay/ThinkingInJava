package io;

import java.io.*;
import java.util.*;

class Worm1 implements Serializable {
    Worm1(){
        System.out.println("Worm1 Constructor");
    }
}

class Worm2 implements Serializable{
    public Worm2(){
        System.out.println("Worm2 Constructor");
    }
}

class Worm3 implements Externalizable{

    public Worm3(){
        System.out.println("Worm3 Constructor");
    }
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Worm3 writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Worm3 readExternal");
    }
}

class Worm4 implements Externalizable{

    Worm4(){
        System.out.println("Worm4 Constructor");
    }
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Worm4 writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Worm4 readExternal");
    }
}

public class Worms {
    public static void main(String[] args)throws Exception{
        Worm1 w1 = new Worm1();
        Worm2 w2 = new Worm2();
        Worm3 w3 = new Worm3();
        Worm4 w4 = new Worm4();

        System.out.println("Start Store Objects");
        ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(new File("Worms")));
        objOut.writeObject(w1);
        objOut.writeObject(w2);
        objOut.writeObject(w3);
        objOut.writeObject(w4);
        objOut.close();
        System.out.println("End Storing");

        ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(new File("Worms")));
        System.out.println("Start Reading object in data");
        Worm1 another1;
        Worm2 another2;
        Worm3 another3;
        Worm4 another4;
        another1 = (Worm1) objIn.readObject();
        System.out.println("no exception util worm1 has been restored");
        another2 = (Worm2) objIn.readObject();
        System.out.println("no exception util worm2 has been restored");
        another3 = (Worm3) objIn.readObject();
        System.out.println("no exception util worm3 has been restored");
        another4 = (Worm4) objIn.readObject();
        System.out.println("no exception util worm4 has been restored");


    }
}

