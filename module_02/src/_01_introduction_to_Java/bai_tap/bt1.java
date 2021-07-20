package _01_introduction_to_Java.bai_tap;
import  java.util.Scanner;
public class bt1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ten");
        String name = scanner.nextLine();
        System.out.println("Hello:" + name);
    }
}
