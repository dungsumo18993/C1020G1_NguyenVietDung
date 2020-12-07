package _05_accessmodefier_.bai_tap;

public class Circle {
    private double radius = 1.0;
    private String color = "red";

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    protected double getRadius() {
        return radius;
    }

    protected double getArea() {
        return radius * radius * Math.PI;
    }

}

 class TestCircle {
    public static void main(String[] args) {
        Circle circle1 = new Circle(5);
        System.out.println("Area: " + circle1.getArea());
        System.out.println("Radius: " + circle1.getRadius());
//      System.out.println("Color: " + circle1.color);
    }
}
