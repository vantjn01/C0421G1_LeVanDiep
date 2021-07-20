package _02_vong_lap_Java.bai_tap;
import java.util.Scanner;
public class _01_HienThiCacLoaiHinh {
    public static void main(String[] args) {
        int choose = -1;
        System.out.println("Menu:");
        System.out.println("1. In hình chữ nhật");
        System.out.println("2. In hình tam giác vuông, có cạnh góc vuông ở botton-left");
        System.out.println("3. In hình tam giác vuông ngược");
        System.out.println("4. Exit");
        System.out.println("Please choose one");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your choosing: ");
        choose = input.nextInt();
        if (choose != 4) {
            switch (choose) {
                case 1:
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 6; j++) {
                            System.out.print("*");
                        }
                        System.out.println("");
                    }
                    break;
                case 2:
                    for (int i = 1; i <= 5; i++) {
                        for (int j = 1; j < i; j++) {
                            System.out.print("*");
                        }
                        System.out.println("");

                    }
                    break;
                case 3:
                    for (int i = 7; i >= 1; i--) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print("*");
                        }
                        System.out.println("");
                    }
            }
        } else {
            System.out.println("Exit");
            System.exit(0);
        }
    }
}
