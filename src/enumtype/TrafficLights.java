package enumtype;

enum Signal {Green, RED, YELLOW}
public class TrafficLights {
    Signal color = Signal.RED;
    public void change(){
        switch (color){
            case RED:
                color = Signal.Green;
                break;
            case Green:
                color = Signal.YELLOW;
                break;
            case YELLOW:
                color = Signal.RED;
                break;
        }
    }
    public String toString(){
        return "The light is + " + color;
    }
    public static void main(String[] args){
        TrafficLights lights = new TrafficLights();
        for (int i = 0; i < 7; i++){
            System.out.println(lights);
            lights.change();
        }
    }
}
