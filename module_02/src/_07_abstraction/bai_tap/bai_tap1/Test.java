package _07_abstraction.bai_tap.bai_tap1;

public class Test {
    public static void main(String[] args) {
        Circle c1 = new Circle(3);
        Square q1 = new Square(5);
        Rectangle r1 = new Rectangle(3, 5);

        System.out.println(c1.toString());
        System.out.println(q1.toString());
        System.out.println(r1.toString());
        q1.resize(2.5);
        r1.resize(2.5);

        System.out.println(c1.toString());
        System.out.println(q1.toString());
        System.out.println(r1.toString());

    }
}
