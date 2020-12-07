package _06_inheritance_.bai_tap;

public class Cylinder extends Circle {
    private double weight;

    public Cylinder(){

    }

    public Cylinder(double weight) {
        this.weight = weight;
    }

    public Cylinder(double radius, String color, double weight) {
        super(radius, color);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getVolume(){
        return getRadius()*getRadius()*weight*Math.PI;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "weight=" + weight
                + super.toString()
                + '}';
    }

    public static class CylinderTest {
        public static void main(String[] args) {
            Cylinder x=new Cylinder();
            System.out.println(x);
            System.out.println("Thể tích là: "+ x.getVolume());

            Cylinder x1=new Cylinder(5);
            System.out.println(x1);
            System.out.println("Thể tích là: "+ x1.getVolume());

            Cylinder x2= new Cylinder(3,"blue",6);
            System.out.println(x2);
            System.out.println("Thể tích là: "+ x2.getVolume());
        }
    }
}
