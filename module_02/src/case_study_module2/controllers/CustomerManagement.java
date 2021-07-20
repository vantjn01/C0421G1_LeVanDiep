package case_study_module2.controllers;

import case_study_module2.services.task2.CustomerServicesImpl;

import java.io.IOException;
import java.util.Scanner;

public class CustomerManagement {
        public static void CustomerManagement() throws IOException {
            Scanner scanner = new Scanner(System.in);
            System.out.println("---------- Customer Management ----------");
            System.out.println("1. Display list customers");
            System.out.println("2. Add new customer");
            System.out.println("3. Edit customer ");
            System.out.println("4. Return main menu");
            System.out.println("5. Exit");
            System.out.println("------------------------------");
            int input = scanner.nextInt();
            switch (input){
                case 1:{
//                    System.out.println("1. Display list customers");
                    new CustomerServicesImpl().displayList();
                    break;
                }
                case 2:{
//                    System.out.println("2. Add new customer");
                    new CustomerServicesImpl().addNew();
                    break;
                }
                case 3:{
//                    System.out.println("3. Edit customer ");
                    new CustomerServicesImpl().editCustomer();
                    break;
                }
                case 4:{
                    System.out.println("4. Return main menu");
                    FuramaController.displayMainMenu();
                    break;
                }

                case 5:
                   System.exit(1);
                default:{
                    System.out.println("Fail! Please choose again! Enter to continue.");
                    System.out.print("Your choose: ");

                }
            }

        }
    }

