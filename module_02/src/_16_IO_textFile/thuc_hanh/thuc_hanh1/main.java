package _16_IO_textFile.thuc_hanh.thuc_hanh1;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        System.out.println("Nhập đường dẫn file: ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();

        readFileText readfileEx = new readFileText();
        readfileEx.readFileText(path);
    }
}
