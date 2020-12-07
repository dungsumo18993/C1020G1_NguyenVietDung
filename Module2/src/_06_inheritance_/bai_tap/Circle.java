package _06_inheritance_.bai_tap;

public class Circle {
    private double radius=1.0;
    private String color="red";

    public Circle() {
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea(){
        return radius*radius*Math.PI;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                '}';
    }

    public static class CircleTest{
        public static void main(String[] args) {
            Circle x=new Circle();
            System.out.println(x);
            System.out.println("Diện tích là: "+ x.getArea());

            Circle x1=new Circle(3,"yellow");
            System.out.println(x1);
            System.out.println("Diện tích là: "+ x1.getArea());
        }
    }
}
