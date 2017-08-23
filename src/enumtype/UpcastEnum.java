package enumtype;

enum Search { HITHER, YON }
public class UpcastEnum {
    public static void main(String[] args){
        Search[] values = Search.values();
        Enum e = Search.HITHER;
        for(Enum en : e.getClass().getEnumConstants()){
            System.out.println(en);
        }
    }
}
