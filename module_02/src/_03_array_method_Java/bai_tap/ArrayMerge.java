package _03_array_method_Java.bai_tap;
import java.util.Scanner;
public class ArrayMerge {
    public static void main(String[] args) {

        int arr1[] = {1,2,3,};
        int arr2[] = {4,5,6,7,8,9};
        int k=arr1.length + arr2.length;
        int arr3[] = new int [k];
        int i;
        for ( i=0;i<arr1.length; i++){
            arr3[i] = arr1[i];

        }
        k = i;
        for (i=0;i<arr2.length;i++,k++){
            arr3[k] = arr2[i];
        }

        System.out.println("Mang da duoc gop la: ");
        for ( i=0;i<k;i++){
            System.out.println("arr["+i+"]:" +arr3[i]);
        }
    }
}
