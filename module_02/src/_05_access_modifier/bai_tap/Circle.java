package _05_access_modifier.bai_tap;

public class Circle {
    private double radius = 1.0;
    private String color = "red";

    //    Contructor
    public Circle() {

    }
    public Circle(double radius) {
        this.radius = radius;
    }
    // get
    public double getRadius() {
        return radius;
    }
    public String getColor() {
        return color;
    }
    public double getArea() {
        return this.radius*2*Math.PI;
    }
    // set
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public void setColor(String color) {
        this.color = color;
    }
}
