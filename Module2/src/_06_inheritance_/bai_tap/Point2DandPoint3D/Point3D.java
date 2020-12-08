package _06_inheritance_.bai_tap.Point2DandPoint3D;

import java.util.Arrays;

public class Point3D extends Point2D {
    private float z;

    public Point3D() {
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x,float y,float z){
        super.setX(x);
        super.setY(y);
        setZ(z);
    }

    public float[] getXYZ(){
        float[] arr={getX(),getY(),getZ()};
        return arr;
    }

    @Override
    public String toString() {
        return "Point3D: "+
                "x,y,z" + Arrays.toString(getXYZ());
    }
}
