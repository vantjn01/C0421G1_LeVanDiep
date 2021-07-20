package _03_array_method_Java.thuc_hanh;
import java.util.Scanner;
public class array_find_value {
    public static void main(String[] args) {
        System.out.println("Nhập giá trị trong mảng");

        String[] students = {"Tài","Quân","Hà","Diệp","Nhật"};

        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Nhập tên sinh viên: ");
        String input_name = scanner.nextLine();

        boolean isExist = false;
        for (int i = 0; i < students.length; i++) {
            if (students[i].equals(input_name)) {
                System.out.println("Vị trí của sinh viên trong danh sách " + input_name + " là: " + (i + 1));
                isExist = true;
                break;
            }
        }
        if (isExist == false)
            System.out.println("Không tìm thấy " + input_name + " trong danh sách.");
    }

}
