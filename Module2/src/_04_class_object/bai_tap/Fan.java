package _04_class_object.bai_tap;

public class Fan {
    final int slow = 1;
    final int medium = 2;
    final int fast = 3;
    private int speed;
    private boolean on;
    private double radius;
    private String color;

    public Fan() {
        this.speed = slow;
        this.on = false;
        this.radius = 5;
        this.color = "blue";
    }

    public Fan(int speed, boolean on, double radius, String color) {
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isOn() {
        return on;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        if (isOn()) {
            return "Fan{" +
                    " speed=" + getSpeed() +
                    ", color=" + getColor() +
                    ", radius=" + getRadius() +
                    " fan is on }";
        } else {
            return "Fan{" +
                    " speed=" + getSpeed() +
                    ", color=" + getColor() +
                    ", radius=" + getRadius() +
                    " fan is off }";
        }
    }

    public static void main(String[] args) {
        Fan fan1 = new Fan(10,true,5,"yellow");
        System.out.println(fan1);
        Fan fan2 = new Fan(6,false,5,"blue");
        System.out.println(fan2);
        fan1.setColor("red");
        System.out.println(fan1);
    }

}
