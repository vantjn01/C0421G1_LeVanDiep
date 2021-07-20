package _03_array_method_Java.thuc_hanh;
import java.util.Scanner;
public class array_reverse {
        public static void main(String[] args) {
            int arr[] = {1,2,3,4,5,6,7,8};
            for(int i = 0 ; i < arrReverse(arr).length ; i++) {
                System.out.print(arrReverse(arr)[i] +" ");
            }
        }
        public static int[] arrReverse(int arr[]) {
            int arr1[] = new int[arr.length];
            int dem = 0;
            for (int i = arr.length -1 ; i>=0 ; i--) {
                arr1[dem] = arr[i];
                dem++;
            }
            return arr1;
        }
}
