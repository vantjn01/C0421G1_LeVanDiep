package _01_introduction_to_Java.bai_tap;

import java.util.Scanner;

public class bt3 {
    public static void main(String[] args) {
        double vnd = 23000;
        double usd;
        Scanner sc = new Scanner(System.in);
        System.out.print("Mời bạn nhập số tiền bằng usd");
        usd=sc.nextDouble();
        double quydoi = usd * 23000;
        System.out.print("Giá trị vnd" +quydoi);
    }
}
