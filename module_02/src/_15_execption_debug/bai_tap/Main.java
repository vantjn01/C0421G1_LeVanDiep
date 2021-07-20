package _15_execption_debug.bai_tap;

import java.util.Scanner;

public class Main {
        public static void main(String[] args) throws IllegalTriangleException{
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhập 3 cạnh của tam giác: ");
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            check(a,b,c);
        }

        public static void check(int a, int b, int c) throws IllegalTriangleException {
            try {
                if ((a + b <= c) || (a + c <= b) || (b + c <= a) || (a <= 0) || (b <= 0) | (c <= 0)) {
                    System.out.println(+a + "; " + b + "; " + c + " không phải là độ dài của một tam giác");
                } else {
                    throw new ArithmeticException();
                }
            } catch (Exception e) {
                System.out.println("Độ dài ba canh  là độ dài của tam giác");
            }
        }
    }
