package _06_inheritance.bai_tap.MoveablePoint;

public class Test {
    public static void main(String[] args) {
        Point point = new Point(20,30);
        System.out.println(point.toString());
        point.setXY(10,20);
        System.out.println(point.toString());
        point = new MoveablePointt(point.getX(), point.getY(), 10,20);
        System.out.println(point.toString());
        ((MoveablePointt) point).move();
        System.out.println(point.toString());
        MoveablePointt anotherPoint = new MoveablePointt(20,20);
        System.out.println(anotherPoint.toString());
        anotherPoint.move();
        System.out.println(anotherPoint.toString());
    }
}
