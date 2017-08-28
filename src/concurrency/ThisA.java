package concurrency;
public class ThisA{
    private ThisB b = new ThisB(this);
    public ThisA(){
        System.out.println("ThisA Constructor");
    }

    public String getB() {
        return b.toString();
    }

    public static void main(String[] args){
        ThisA a = new ThisA();
    }

}

class ThisB{
    private ThisA a;
    public ThisB(ThisA a){
        this.a = a;
    }
}