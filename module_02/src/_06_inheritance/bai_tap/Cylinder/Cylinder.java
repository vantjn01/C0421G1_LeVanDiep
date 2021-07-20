package _06_inheritance.bai_tap.Cylinder;

public class Cylinder extends Circle {
    private double volume = 1.0;
    private double height = 1.0;

    public Cylinder() {
    }

    public Cylinder(double volume, double height) {
        this.volume = volume;
        this.height = height;
    }

    public Cylinder(double volume, double height, int radius, String color) {
        super(radius, color);
        this.volume = volume;
        this.height = height;
    }

    public double getVolume() {
        return volume;
    }

    public double getHeight() {
        return height;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        return height * super.getArea();
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "volume=" + volume +
                ", height=" + height +
                ", radius=" + radius +
                ", color='" + color +
                "'}";
    }
}
