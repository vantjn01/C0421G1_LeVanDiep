package _04_oop_java.baiTap;
import java.util.Scanner;
public class QuadraticEquation_01 {
    static class ThamSo {
        double a, b, c;
        double delta, x1, x2;

        public ThamSo(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        double getDelta() {
            this.delta = Math.pow(this.b, 2) - 4 * this.c * this.a;
            return this.delta;
        }

        double getNghiemX1() {
            this.x1 = ((-this.b + Math.sqrt(this.delta)) / 2 * a);
            return this.x1;
        }

        double getNghiemX2() {
            this.x2 = ((-this.b - Math.sqrt(this.delta)) / 2 * a);
            return this.x2;
        }

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập a: ");
        double a = input.nextDouble();
        System.out.println("Nhập b: ");
        double b = input.nextDouble();
        System.out.println("Nhập c: ");
        double c = input.nextDouble();
        ThamSo myEquation = new ThamSo(a, b, c);
        if (myEquation.getDelta() > 0) {
            System.out.println("Phương trình có 2 nghiệm là: " + myEquation.getNghiemX1() + " và " + myEquation.getNghiemX2());
        } else if (myEquation.getDelta() == 0) {
            System.out.println("Phương trình có 1 nghiệm duy nhất là: " + myEquation.getNghiemX1());
        } else
            System.out.println("Phương trình không có nghiệm.");

    }
}
