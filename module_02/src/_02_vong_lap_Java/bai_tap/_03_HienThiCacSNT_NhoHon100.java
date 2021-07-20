package _02_vong_lap_Java.bai_tap;
import java.util.Scanner;
public class _03_HienThiCacSNT_NhoHon100 {
    public static void main(String[] args) {

        for (int j = 1; j < 100; j++) {
            if (snt(j) == true){
                System.out.println(j + " ");
            }

        }
    }

    private static boolean snt(int x) {
        if (x < 2) return false;
        for (int i = 2; i < x - 1; i++) {
            if (x % i == 0)
                return false;
        }
        return true;
    }
}
