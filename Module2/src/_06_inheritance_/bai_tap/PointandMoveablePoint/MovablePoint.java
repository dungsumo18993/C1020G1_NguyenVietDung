package _06_inheritance_.bai_tap.PointandMoveablePoint;

public class MovablePoint extends Point {
    private float xSpeed;
    private float ySpeed;

    public MovablePoint() {
    }

    public MovablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed){
        super.setX(xSpeed);
        super.setY(ySpeed);
    }

    public float[] getSpeed(){
        float[] arr = {getXSpeed(),getYSpeed()};
        return arr;
    }

    public MovablePoint move(){
        setX(getX()+getXSpeed());
        setY(getY()+getYSpeed());
        return this;
    }
    @Override
    public String toString() {
        return super.toString()+
                " speed= " +
                "(" + getXSpeed()+", "+
                getYSpeed()+
                ")";
    }

}
