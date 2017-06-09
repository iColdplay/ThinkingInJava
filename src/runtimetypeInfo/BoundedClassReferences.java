package runtimetypeInfo;

/**
 * Created by root on 17-6-3.
 */
public class BoundedClassReferences {
    private static void main(){
        Class<? extends Number> bounded = int.class;
        bounded = double.class;
        bounded = Number.class;

    }
}
