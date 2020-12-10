package _07_abstract_interface_.bai_tap.interfaceResizeable;

import _06_inheritance_.thuc_hanh.Shape;

public class ResizeableTest {
    public static void main(String[] args) {

        Circle circle= new Circle(5);
        Rectangle rectangle=new Rectangle(3,5);
        Square square=new Square(3);

       Shape[] array={circle,rectangle,square};

        System.out.println("Trước khi tăng: ");
        System.out.println(circle.getArea());
        System.out.println(rectangle.getArea());
        System.out.println(square.getArea());

        System.out.println("Sau Khi Tăng: ");
        double randomPercent=Math.floor(Math.random()*99 + 1);
        for(Shape element: array){
            element.resize(randomPercent);
            System.out.println(element+", percent: "+randomPercent+"\n"+
                                "Diện tích mới là: "+element.getArea());
        }

//        Circle circle =new Circle(5);
//        double s1=circle.getArea();
//        System.out.println(circle.getArea());
//
//        circle.resize(20);
//        float s2= (float) circle.getArea();
//        System.out.println(circle.getArea());

//        System.out.println((s2-s1)/s1);
    }
}
