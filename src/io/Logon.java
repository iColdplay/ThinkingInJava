package io;

import java.io.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Logon implements Serializable{
    private String userName;
    private transient String password;
    public Logon(String name, String pw){
        this.userName = name;
        this.password = pw;
    }

    public String toString() {
        System.out.println("Name: " + this.userName + "\nPassword: " + this.password);
        return null;
    }

    public static void main(String[] args) throws Exception{
        Logon a = new Logon("qyqx", "TT");
        a.toString();
        System.out.println(new Date());
        ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(new File("logon")));
        objOut.writeObject(a);
        objOut.close();
        TimeUnit.SECONDS.sleep(1);

        ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(new File("logon")));
        Logon b;
        b = (Logon) objIn.readObject();
        b.toString();
        System.out.println(new Date());
    }
}

/*
Note that while toString( ) assembles a String
object using the overloaded’+’ operator, a null reference is automatically converted to the
string "null."
*/