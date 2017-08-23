package enumtype;

import static enumtype.Spiciness.*;

public class Burrito {
    Spiciness degree;
    public Burrito(Spiciness degree){
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Burrito +" + this.degree;
    }

    public static void main(String[] args){
        System.out.println(new Burrito(HOT));
        System.out.println(new Burrito(MILD));
        System.out.println(new Burrito(FLAMING));
    }
}
