package io;

/**
 * Created by root on 17-7-7.
 */
import java.io.*;

public class OSExecute {
    public static void main(String[] args){
        command("sleep 5");
        command("echo something to happen");
    }

    public static void command(String command){
        boolean err = false;
        try{
            Process process = new ProcessBuilder(command.split(" ")).start();
            BufferedReader result = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String s;
            while((s= result.readLine()) != null){
                System.out.println(s);
            }
            BufferedReader errs = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while ((s = errs.readLine()) != null){
                System.err.println(s);
                err = true;
            }
        }catch (Exception e){
            if(!command.startsWith("CMD /C" + command)){
                command("CMD /C" + command);
            }else{
                throw new RuntimeException(e);
            }
        }
        if (err){
            throw new OSException("Errors executing " + command);
        }
    }
}
