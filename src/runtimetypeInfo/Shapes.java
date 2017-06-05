package runtimetypeInfo;

/**
 * Created by root on 17-6-3.
 */
import java.lang.reflect.Array;
import java.util.*;

abstract class Shape{
    void draw(){System.out.println(this + ".draw()");}
    abstract public String toString();
}

class Circle extends Shape{

    @Override
    public String toString() {
        return "Circle";
    }
}

class Square extends Shape{

    @Override
    public String toString() {
        return "Square";
    }
}

class Triangle extends Shape{

    @Override
    public String toString() {
        return "Triangle";
    }
}

public class Shapes{
    public static void main(String[] args){
        List<Shape> shapeList = Arrays.asList(
                new Circle(), new Square(), new Triangle()
        );
        for(Shape shape : shapeList){
            shape.draw();
        }
    }
}

//toString 被声明为abstract 以强制继承者覆写此方法 并且可以防止无格式的Shape的实例化
//Shape放入List中 会向上转型 然后丢失Shape的具体类型
//数组将所有的事物都当作Object处理，然后自动转型为Shape
//Java中 所有类型转换 都是在运行时进行正确性检查的
//多态 是面向对象面成的基本目标

