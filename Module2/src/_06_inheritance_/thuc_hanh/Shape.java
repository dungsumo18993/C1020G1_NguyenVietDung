package _06_inheritance_.thuc_hanh;

public class Shape {
    private String color = "blue";
    private boolean filled = true;

    public Shape() {
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public double getArea(){
        return 0;
    }

    @Override
    public String toString() {
        return "A Shape with color of "
                + getColor()
                + " and "
                + (isFilled() ? "filled" : "not filled");
    }

    public void resize(double randomPercent) {
    }
//    public static class ShapeTest {
//        public static void main(String[] args) {
//            Shape shape = new Shape();
//            System.out.println(shape);
//
//            shape = new Shape("red", false);
//            System.out.println(shape);
//        }
//    }
}
