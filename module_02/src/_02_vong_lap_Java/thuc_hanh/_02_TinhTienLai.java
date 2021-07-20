package _02_vong_lap_Java.thuc_hanh;
import java.util.Scanner;
public class _02_TinhTienLai {
    public static void main(String[] args) {
        double money = 1.0;
        int month = 1;
        double interestRate = 1.0; // interest: lãi suất
        Scanner scanner = new Scanner(System.in);

        Scanner input = new Scanner(System.in);
        System.out.println("Nhập số tiền: ");
        money = input.nextDouble();
        System.out.println("Nhập số tháng: ");
        month = input.nextInt();
        System.out.println("Nhập lãi suất: ");
        interestRate = input.nextDouble();

        double totalInterest = 0;
        for(int i = 0; i < month; i++){
            totalInterest += money * (interestRate/100)/12 * month;
        }
        System.out.println("Lãi nhận được là" + totalInterest);
    }
}
