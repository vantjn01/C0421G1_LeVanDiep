package _06_inheritance.bai_tap.Cylinder;

public class TestCylinder {
    public static void main(String[] args) {
        Circle cirle = new Circle(3, "black");
        System.out.println(cirle);

        Cylinder cylinder = new Cylinder(3.0,4.0,3,"blue");
        System.out.println(cylinder);
        System.out.println(cylinder.getArea());
    }
}
