package case_study_module2.controllers;

import java.io.IOException;
import java.util.Scanner;

public class PromotionManagement {
    public static void PromotionManagement() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---------- Promotion Management ----------");
        System.out.println("1. Display list customers use service");
        System.out.println("2. Display list customers get voucher");
        System.out.println("3. Return main menu");
        System.out.println("4. Exit");
        System.out.println("------------------------------");

        int input = scanner.nextInt();
        switch (input){
            case 1:{
                System.out.println("1. Display list customers use service");
                break;
            }
            case 2:{
                System.out.println("2. Display list customers get voucher");
                break;
            }
            case 3: {
                System.out.println("3. Return main men");
                FuramaController.displayMainMenu();
                break;
            }
            case 4:{
                System.out.println("4. Exit");
                System.exit(1);
                break;
            }
            default:{
                System.out.println("Fail! Please choose again! Enter to continue.");
                System.out.print("Your choose: ");
            }
        }
    }
}
