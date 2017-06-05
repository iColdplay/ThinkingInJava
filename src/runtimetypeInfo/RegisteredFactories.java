package runtimetypeInfo;

import javafx.scene.effect.Blend;
import runtimetypeInfo.factory.*;
import java.util.*;
/**
 * Created by root on 17-6-5.
 */
class Part{
    public String toString(){
        return getClass().getSimpleName();
    }
    static List<Factory<? extends Part>> partFactories = new ArrayList<Factory<? extends Part>>();
    static {
        partFactories.add(new FuelFilter.Factory());
        partFactories.add(new AirFilter.Factory());
        partFactories.add(new FanBelt.Factory());
        partFactories.add(new PowerBelt.Factory());
    }
    private static Random rand = new Random(47);
    public static Part createRandom(){
        int n = rand.nextInt(partFactories.size());
        return partFactories.get(n).create();
    }
}

class Filter extends Part{

}
class FuelFilter extends Filter{
    public static class Factory implements runtimetypeInfo.factory.Factory<FuelFilter>{
        public FuelFilter create(){
            return new FuelFilter();
        }
    }
}
class AirFilter extends Filter{
    public static class Factory implements runtimetypeInfo.factory.Factory<AirFilter>{
        public AirFilter create(){
            return new AirFilter();
        }
    }
}
class Belt extends Part{

}
class FanBelt extends Belt{
    public static class Factory implements runtimetypeInfo.factory.Factory<FanBelt>{
        public FanBelt create(){
            return new FanBelt();
        }
    }
}
class PowerBelt extends Belt{
    public static class Factory implements runtimetypeInfo.factory.Factory<PowerBelt>{
        public PowerBelt create(){
            return new PowerBelt();
        }
    }
}

public class RegisteredFactories {
    public static void main(String[] args){
        for(int i = 0; i < 10; i++){
            System.out.println(Part.createRandom());
        }
    }
}
