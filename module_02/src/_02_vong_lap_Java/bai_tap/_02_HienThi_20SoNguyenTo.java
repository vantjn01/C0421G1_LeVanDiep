package _02_vong_lap_Java.bai_tap;
import java.util.Scanner;
public class _02_HienThi_20SoNguyenTo {
    static boolean isPrime(int x){
        if(x==2 || x==3)
            return true;
        for(int i=2;i<=Math.sqrt(x);i++){
            if(x%i==0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = sc.nextInt();
        int count=0;
        int i=2;
        while(count<number){
            if(isPrime(i)){
                System.out.print(i+" ");
                count++;
            }
            i++;
        }
    }

}
