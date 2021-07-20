package _05_access_modifier.bai_tap;

public class TestCircle {
    public static void main(String[] args) {
        // write your code here
        Circle circle = new Circle();
        System.out.println(circle.getRadius());

        System.out.println(circle.getArea());
        System.out.println("ban kinh r = " + circle.getRadius() + " Chuvi = " + circle.getArea());


    }
}
