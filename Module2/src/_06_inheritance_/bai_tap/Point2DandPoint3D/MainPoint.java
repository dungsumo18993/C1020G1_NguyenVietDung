package _06_inheritance_.bai_tap.Point2DandPoint3D;

public class MainPoint {
    public static void main(String[] args) {
        Point2D point2D=new Point2D(2,5);
        System.out.println(point2D);
        point2D.setXY(5,2);
        System.out.println(point2D);

        Point3D point3D=new Point3D(3,4,6);
        System.out.println(point3D);
        point3D.setXYZ(6,4,3);
        System.out.println(point3D);
    }
}
