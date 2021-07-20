package case_study_module2.services.task2;

import case_study_module2.models.Customer;
import case_study_module2.models.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServicesImpl implements EmployeeServices{
    static Scanner scanner = new Scanner(System.in);
    public static List<Employee>employees = new ArrayList<>();         // khởi tạo list nhân viên
    static {
        Employee employee1 = new Employee("employee1", "Nguyễn Thanh Hà", "1.1.1996", "Nữ", "11292736","0986058250", "thanhha@gmail.com", "Giám Đốc", 1000, "Trung Cấp");
        Employee employee2 = new Employee("employee2", "Đồng Thị Nhật", "1.11.1996", "Nữ", "232435554","0986058251", "thanhha1@gmail.com", "Quản Lý", 1000, "Cao Đẳng");
        Employee employee3 = new Employee("employee3", "Nguyễn Thị Khắc Phục", "10.1.1996", "Nữ", "12435677","0986058253", "thanhha3@gmail.com", "Phục vụ", 1000, "Sau Đại Học");
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
    }
    String[] location1 = {"Lễ Tân", "Phục Vụ", "Chuyên Viên", "Giám Sát", "Quản Lý", "Giám Đốc"};
    String[] level1= {"Trung cấp", "Cao Đẳng", "Đại Học", "Sau Đại Học"};

    @Override
    public void displayList() {
        for (Employee a: employees) {
            System.out.println(a);
        }
    }

    @Override
    public void addNew() {
        System.out.println("Nhập code");
        String code = scanner.nextLine();
        System.out.println("Nhập fullName");
        String fullName = scanner.nextLine();
        System.out.println("dateOfBirth");
        String dateOfBirth = scanner.nextLine();
        System.out.println("Nhập gender");
        String gender = scanner.nextLine();
        System.out.println("Nhập CMND");
        String cmnd = scanner.nextLine();
        System.out.println("Nhập số phone");
        String phone = scanner.nextLine();
        System.out.println("Nhập email");
        String email = scanner.nextLine();
        System.out.println("Nhập chức vụ location. Vui lòng chọn");
        for (int i = 0; i < location1.length; i++){
            System.out.println(i + ") " + location1[i]);
        }
        String location = "";
        boolean isLegal = false;
        while (!isLegal) {
            int choiceLocation = Integer.parseInt(scanner.nextLine());
            switch (choiceLocation) {
                case 0:
                    isLegal = true;
                    location = location1[0];
                    break;
                case 1:
                    isLegal = true;
                    location = location1[1];
                    break;
                case 2:
                    isLegal = true;
                    location = location1[2];
                    break;
                case 3:
                    isLegal = true;
                    location = location1[3];
                    break;
                case 4:
                    isLegal = true;
                    location = location1[4];
                    break;
                case 5:
                    isLegal = true;
                    location = location1[5];
                    break;
                default:
                    System.err.println("Nhập sai chức vụ. vui lòng nhập lại");
            }
        }
        System.out.println("Nhập lương salary: ");
        int salary = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập trình độ level. vui lòng chọn ");
        for (int i = 0; i < level1.length; i++) {
            System.out.println(i + ") " + level1[i]);
        }
        String level = "";
        boolean isTrue = false;
        while (!isTrue) {
            int choiceLevel = Integer.parseInt(scanner.nextLine());
            switch (choiceLevel) {
                case 0:
                    isTrue = true;
                    level = level1[0];
                    break;
                case 1:
                    isTrue = true;
                    level = level1[1];
                    break;
                case 2:
                    isTrue = true;
                    level =level1[2];
                    break;
                case 3:
                    isTrue = true;
                    level = level1[3];
                    break;
                default:
                    System.err.println("Nhập trình độ level sai. Vui lòng nhập lại.");
            }
        }
        Employee newEmployee = new Employee(code, fullName, dateOfBirth, gender , cmnd, phone, email, location, salary, level);
        employees.add(newEmployee);
        System.out.println("Thêm mới thành công");

    }

    @Override
    public void editEmployee() {
        System.out.println("Chọn chỉnh sửa employee.");
        boolean isTrueCode = false;
        while (!isTrueCode) {
            System.out.println("Nhập employee code: ");
            String input = scanner.nextLine();
            boolean isExist = false;
            int index = 0;
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).getCode().equals(input)) {
                    isExist = true;
                    index = i;
                    break;
                }
            }
            if (!isExist) {
                System.err.println("Không tìm thấy code");
            } else {
                isTrueCode = true;
                System.out.println(employees.get(index).toString());
                System.out.println("Chọn thuộc tính: ");
                System.out.println("1: Sửa fullName");
                System.out.println("2: Sửa dayOfbirth");
                System.out.println("3: Sửa gender");
                System.out.println("4: Sửa CMND");
                System.out.println("5: Sửa phoneNumber");
                System.out.println("6: Sửa email");
                System.out.println("7: Sửa chức vụ location");
                System.out.println("8: Sửa lương");
                System.out.println("9: Sửa trình độ level");
                System.out.println("0: Quay lại.");
                int empChoice = Integer.parseInt(scanner.nextLine());
                switch (empChoice) {
                    case 1:
                        System.out.println("Nhập new fullName: ");
                        String newfullName = scanner.nextLine();
                        employees.get(index).setFullName(newfullName);
                        break;

                    case 2:
                        System.out.println("Nhập new dayOfBirth: ");
                        String newDayOfBirth = scanner.nextLine();
                        employees.get(index).setDateOfBirth(newDayOfBirth);
                        break;

                    case 3:
                        System.out.println("Nhập new gender: ");
                        String newGender = scanner.nextLine();
                        employees.get(index).setGender(newGender);
                        break;

                    case 4:
                        System.out.println("Nhập CMND: ");
                        String newCmnd = scanner.nextLine();
                        employees.get(index).setCMND(newCmnd);
                        break;

                    case 5:
                        System.out.println("Input new phone number: ");
                        String newPhoneNumber = scanner.nextLine();
                        employees.get(index).setPhoneNumber(newPhoneNumber);
                        break;

                    case 6:
                        System.out.println("Input email: ");
                        String newEmail = scanner.nextLine();
                        employees.get(index).setEmail(newEmail);
                        break;

                    case 7:
                        System.out.println("Choose new position: ");
                        for (int i = 0; i < location1.length; i++) {
                            System.out.println(i + ") " + location1[i]);
                        }
                        String newLevel = "";
                        boolean isLevel = false;
                        while (!isLevel) {
                            int choicePos = Integer.parseInt(scanner.nextLine());
                            switch (choicePos) {
                                case 0:
                                    isLevel = true;
                                    newLevel = level1[0];
                                    break;
                                case 1:
                                    isLevel = true;
                                    newLevel = level1[1];
                                    break;
                                case 2:
                                    isLevel = true;
                                    newLevel = level1[2];
                                    break;
                                case 3:
                                    isLevel = true;
                                    newLevel = level1[3];
                                    break;
                                default:
                                    System.err.println("Nhập sai trình độ. Vui lòng nhập lại.");
                            }
                        }
                        employees.get(index).setLevel(newLevel);
                        break;

                    case 8:
                        System.out.println("Input new salary lương: ");
                        int newSalary = Integer.parseInt(scanner.nextLine());
                        employees.get(index).setSalary(newSalary);
                        break;

                    case 9:
                        System.out.println("Chọn trình độ ");
                        for (int i = 0; i < location1.length; i++) {
                            System.out.println(i + ") " + location1[i]);
                        }
                        String location = "";
                        boolean isLegal = false;
                        while (!isLegal) {
                            int choiceLocation = Integer.parseInt(scanner.nextLine());
                            switch (choiceLocation) {
                                case 0:
                                    isLegal = true;
                                    location = location1[0];
                                    break;
                                case 1:
                                    isLegal = true;
                                    location = location1[1];
                                    break;
                                case 2:
                                    isLegal = true;
                                    location = location1[2];
                                    break;
                                case 3:
                                    isLegal = true;
                                    location = location1[3];
                                    break;
                                default:
                                    System.err.println("Nhập sai chức vụ. Vui lòng nhập lại");
                            }
                        }
                        employees.get(index).setLocation(location);
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
