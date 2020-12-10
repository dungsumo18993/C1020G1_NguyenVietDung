package _07_abstract_interface_.bai_tap.interfaceResizeable;

import _06_inheritance_.thuc_hanh.Shape;

public class Rectangle extends Shape implements Resizeable {
    private double width = 1.0;
    private double length = 1.0;

    public Rectangle() {
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return width * this.length;
    }

    public double getPerimeter() {
        return 2 * (width + this.length);
    }

    @Override
    public String toString() {
        return "A Rectangle with width="
                + getWidth()
                + " and length="
                + getLength();
    }

    @Override
    public void resize(double percent) {
        this.width += this.width*percent/100;
        this.length += this.length*percent/100;
    }

//    public static class RectangleTest {
//        public static void main(String[] args) {
//            Rectangle rectangle = new Rectangle();
//            System.out.println(rectangle);
//            System.out.println(rectangle.getArea());
//            System.out.println(rectangle.getPerimeter());
//
//            rectangle = new Rectangle(2.3, 5.8);
//            System.out.println(rectangle);
//            System.out.println(rectangle.getArea());
//            System.out.println(rectangle.getPerimeter());
//
//            rectangle = new Rectangle(2.5, 3.8, "orange", true);
//            System.out.println(rectangle);
//            System.out.println(rectangle.getArea());
//            System.out.println(rectangle.getPerimeter());
//        }
//    }
}
