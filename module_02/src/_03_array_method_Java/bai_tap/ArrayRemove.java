package _03_array_method_Java.bai_tap;
import java.util.Scanner;
public class ArrayRemove {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a size: ");
        int size = sc.nextInt();
        int[] array = new int[size];

        for (int i =0; i< size; i++){
            System.out.println("Value of array["+i+"] is: ");
            array[i] = sc.nextInt();
        }

        System.out.println("enter a index: ");
        int index = sc.nextInt();

        for (int i = index; i < size-1; i++){
            array[i] = array[i+1];
        }
        array[size-1] = 0;

        for (int x: array){
            System.out.println(x+ "\t");
        }
    }
}
