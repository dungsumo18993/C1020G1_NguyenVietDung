package _06_inheritance_.bai_tap.PointandMoveablePoint;

public class PointTest {
    public static void main(String[] args) {
//        Point point=new Point(2,5);
//        System.out.println(point);
//
//        MovablePoint movablePoint=new MovablePoint();
//        System.out.println(movablePoint);
//
//        MovablePoint movablePoint1=new MovablePoint(3,5);
//        System.out.println(movablePoint1);

        MovablePoint movablePoint2=new MovablePoint(1,3,5,7);
        System.out.println(movablePoint2);

        movablePoint2.move();
        System.out.println(movablePoint2);
    }
}
