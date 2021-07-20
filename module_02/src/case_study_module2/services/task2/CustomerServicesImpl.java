package case_study_module2.services.task2;

import case_study_module2.models.Customer;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServicesImpl implements CustomerServices{
    Scanner scanner = new Scanner(System.in);
    public static List<Customer> customers = new LinkedList<>();
    static {
        Customer customer1 = new Customer("Customer1", "Lê Văn Diệp", "15.04.1991", "Nam", "283762528", "0983236552", "vantjn01@gmail.com",  "QT", "Diamond");
        Customer customer2 = new Customer("Customer2", "John Biden", "15.04.1999", "Linh hoạt", "29275513", "012345678", "vantjn02@gmail.com",  "QT", "Member");
        Customer customer3 = new Customer("Customer3", "Nguyễn Xuân Phúc", "15.04.2000", "Nam", "36287383", "0987654321", "vantjn03@gmail.com",  "QT", "Diamond");
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
    }
    String[] species1 = {"Diamond", "Platinium", "Gold", "Silver", "Member"};


    @Override
    public void addNew() throws IOException {
        System.out.println("Input code: ");
        String code = scanner.nextLine();
        System.out.println("Input fullName: ");
        String fullName = scanner.nextLine();
        System.out.println("Input dayOfBirth: ");
        String dayOfBirth = scanner.nextLine();
        System.out.println("Input gender: ");
        String gender = scanner.nextLine();
        System.out.println("Input CMND: ");
        String Cmnd = scanner.nextLine();
        System.out.println("Input phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Input email: ");
        String email = scanner.nextLine();
        System.out.println("Input address: ");
        String address = scanner.nextLine();
        System.out.println("Input type. Choose one: ");
        for (int i = 0; i < species1.length; i++) {
            System.out.println(i + ") " + species1[i]);
        }
        String species = "";
        boolean isTrueType = false;
        while (!isTrueType) {
            int choiceType = Integer.parseInt(scanner.nextLine());
            switch (choiceType) {
                case 0:
                    isTrueType = true;
                    species = species1[0];
                    break;
                case 1:
                    isTrueType = true;
                    species = species1[1];
                    break;
                case 2:
                    isTrueType = true;
                    species = species1[2];
                    break;
                case 3:
                    isTrueType = true;
                    species = species1[3];
                    break;
                default:
                    System.err.println("Input sai loại Customer. Vui lòng nhập lại");
            }
        }
        Customer newCustomer = new Customer(code, fullName, dayOfBirth, gender , Cmnd, phoneNumber, email, address, species);
        customers.add(newCustomer);
        System.out.println("Thêm mới thành công");

    }

    @Override
    public void displayList() {
        for (Customer c: customers) {
            System.out.println(c);
        }
    }

    public List<Customer> getList() {
        return customers;
    }

    @Override
    public void editCustomer() {
        System.out.println("Chọn chỉnh sửa customer.");
        boolean isTrueCode = false;
        while (!isTrueCode) {
            System.out.println("Nhập customer code: ");
            String input = scanner.nextLine();
            boolean isExist = false;
            int index = 0;
            for (int i = 0; i < customers.size(); i++) {
                if (customers.get(i).getCode().equals(input)) {
                    isExist = true;
                    index = i;
                    break;
                }
            }
            if (!isExist) {
                System.err.println("Không tìm thấy code");
            } else {
                isTrueCode = true;
                System.out.println(customers.get(index).toString());
                System.out.println("Chọn thuộc tính: ");
                System.out.println("1: Sửa fullName");
                System.out.println("2: Sửa dayOfbirth");
                System.out.println("3: Sửa gender");
                System.out.println("4: Sửa CMND");
                System.out.println("5: Sửa phoneNumber");
                System.out.println("6: Sửa email");
                System.out.println("7: Sửa địa chỉ");
                System.out.println("8: Sửa loại khách species");
                System.out.println("0: Quay lại.");
                int cusChoice = Integer.parseInt(scanner.nextLine());
                switch (cusChoice) {
                    case 1:
                        System.out.println("Nhập new fullName: ");
                        String newfullName = scanner.nextLine();
                        customers.get(index).setFullName(newfullName);
                        break;

                    case 2:
                        System.out.println("Nhập new dayOfBirth: ");
                        String newDayOfBirth = scanner.nextLine();
                        customers.get(index).setDateOfBirth(newDayOfBirth);
                        break;

                    case 3:
                        System.out.println("Nhập new gender: ");
                        String newGender = scanner.nextLine();
                        customers.get(index).setGender(newGender);
                        break;

                    case 4:
                        System.out.println("Nhập CMND: ");
                        String newCmnd = scanner.nextLine();
                        customers.get(index).setCMND(newCmnd);
                        break;

                    case 5:
                        System.out.println("Input new phone number: ");
                        String newPhoneNumber = scanner.nextLine();
                        customers.get(index).setPhoneNumber(newPhoneNumber);
                        break;

                    case 6:
                        System.out.println("Input email: ");
                        String newEmail = scanner.nextLine();
                        customers.get(index).setEmail(newEmail);
                        break;

                    case 7:
                        System.out.println("Input address: ");
                      String newAdress = scanner.nextLine();
                      customers.get(index).setAddress(newAdress);

                    case 8:
                        System.out.println("Chọn loại khách species ");
                        for (int i = 0; i < species1.length; i++) {
                            System.out.println(i + ") " + species1[i]);
                        }
                        String species = "";
                        boolean isLegal = false;
                        while (!isLegal) {
                            int choiceSpecies = Integer.parseInt(scanner.nextLine());
                            switch (choiceSpecies) {
                                case 0:
                                    isLegal = true;
                                    species = species1[0];
                                    break;
                                case 1:
                                    isLegal = true;
                                    species = species1[1];
                                    break;
                                case 2:
                                    isLegal = true;
                                    species = species1[2];
                                    break;
                                case 3:
                                    isLegal = true;
                                    species = species1[3];
                                    break;
                                case 4:
                                    isLegal = true;
                                    species = species1[4];
                                    break;
                                default:
                                    System.err.println("Nhập sai loại khách. Vui lòng nhập lại");
                            }
                        }
                        customers.get(index).setSpecies(species);
                        break;

                    case 0:
                        return;

                    default:
                        System.err.println("Nhập sai. Vui lòng nhập lại");
                }
            }
        }

    }
}
