package _06_inheritance.bai_tap.Point;

public class Point3D extends Point2D{
    private float z = 0.0f;

    public Point3D(){
    }

    public Point3D(float z,float x,float y){
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z) {
        super.setXY(x, y);
        this.z = z;
    }

    public float[] getXYZ() {
        float[] xy = super.getXY();
        float[] xyz = {xy[0], xy[1], z};
        return xyz;
    }

    @Override
    public String toString() {
        return "(" + super.getX() + "," + super.getY() + "," + this.z + ")";
    }
}
