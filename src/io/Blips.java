package io;

import javafx.scene.effect.Blend;

import java.io.*;
import java.util.Random;

class Blips1 implements Externalizable {
    public Blips1(){
        System.out.println("Blip1 Constructor");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip1.writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip1.readExternal");
    }
}

class Blips2 implements Externalizable {
    Blips2(){
        System.out.println("Blip2 Constructor");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip2.writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip2.readExternal");
    }
}

class Blips3 implements Serializable {
    public Random rand = new Random(47);
    public int proof;

    public Blips3(){
        this.proof = rand.nextInt(20);
        System.out.println(this.proof);
        System.out.println("Blip3 Constructor");
    }

    @Override
    public String toString() {
        System.out.println(this.proof);
        return "0";
    }
}

public class Blips{
    public static void main(String[] args) throws Exception{
        Blips1 b1 = new Blips1();
        Blips2 b2 = new Blips2();
        Blips3 b3 = new Blips3();
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Blips.out"));
        System.out.println("Saving Objects:");
        out.writeObject(b1);
        out.writeObject(b3);
        out.writeObject(b2);

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Blips.out"));
        System.out.println("Recovering b1");
        b1 = (Blips1)in.readObject();
        Blips3 b3out;
        b3out = (Blips3)in.readObject();
        b3out.toString();
        try{
            b2= (Blips2)in.readObject();
        }catch (Exception e){
            System.out.println("failed recovering b2");
        }
    }
}