package _03_array_method_Java.bai_tap;
import java.util.Scanner;
public class ArrayAdd {
    public static void main(String[] args) {

        int a[] = new int[5];// độ dài của mảng
        int atIndex = 3;// vị trí muốn chèn a[3]
        int value = 10;// giá trị muốn chèn
        int n = 4;// độ dài phần tử muốn chèn
        for (int i = 0; i < n; i++) { // khởi tạo 4 phần tử đầu tiên của mảng
            a[i] = i + 1;
        }
        System.out.println("trước khi chèn");
        for (int element : a) {
            System.out.print(element + ";");
        }
        System.out.println();
        for (int i = n; i > atIndex; i--) {
            a[i] = a[i - 1];
        }
        a[atIndex] = value;
        System.out.println("sau khi chèn");
        for (int element : a) {
            System.out.print(element + ";");
        }
    }
}
