package case_study_module2.services.task2;

import case_study_module2.models.Booking;
import case_study_module2.models.Contract;
import case_study_module2.models.Customer;

import java.io.IOException;
import java.util.*;

public class ContractServicesImpl implements ContractServices {
    public static Scanner scanner = new Scanner(System.in);
    private static CustomerServicesImpl csi = new CustomerServicesImpl();
    private static LinkedList<Contract> contracts = new LinkedList<>(); // List lưu trữ các hợp đồng
    private static Queue<Booking> fromBookingToContract = new PriorityQueue<>();// Queue trung gian lưu trữ các booking hợp lệ để làm hợp đồng (trừ Room)
    static {
        Contract contract1 = new Contract(1, "10", 1000, 2000, "Customer3");
        Contract contract2 = new Contract(2, "20", 5000, 20000, "Customer4");
        contracts.add(contract1);
        contracts.add(contract2);
    }

    @Override
    public void displayContract() {
        if (contracts.isEmpty()) {
            System.err.println("Không có hợp đồng mới.");
        } else {
            for (Contract d : contracts) {
                System.out.println(d.toString());
            }
        }
    }

    @Override
    public void creatNewContract() {
        Contract newContract = new Contract();
        System.out.println("Chọn hợp đồng mới.");
        System.out.println("Nhập số hợp đồng mới: ");
        boolean isLegalNumbContract = false;
        while (!isLegalNumbContract) {
            try {
                newContract.setIdContract(scanner.nextLine());
                System.out.println("Thành công.");
                isLegalNumbContract = true;
            } catch (NumberFormatException e) {
                System.err.println("Nhập sai, vui lòng nhập lại.");
            }
        }
        if (fromBookingToContract.peek() != null) {
            newContract.setIdContract(fromBookingToContract.peek().getIdBooking());
            newContract.setCustomer(fromBookingToContract.peek().getCustomer());
            fromBookingToContract.poll(); // Sau khi đã làm hợp đồng xong thì remove khỏi hàng đợi làm contract
        } else {
            System.out.println("Không có hợp đồng. Thoát");
            return;
        }
        System.out.println("Số tiền đặt cọc: ");
        int deposit = inputAmount();
        newContract.setDeposit(deposit);
        System.out.println("Tổng tiền thanh toán: ");
        int totalPayment = inputAmount();
        newContract.setTotalPayment(totalPayment);
        System.out.println("Hợp đồng mới được tạo:" + newContract.toString());
        contracts.offer(newContract);
    }
    public int inputAmount() {
        boolean isLegalTotal = false;
        int amount = 0;
        while (!isLegalTotal) {
            try {
                amount = Integer.parseInt(scanner.nextLine());
                System.out.println("Thành công.");
                isLegalTotal = true;
            } catch (NumberFormatException e) {
                System.err.println("Nhập sai, vui lòng nhập lại: ");
            }
        }
        return amount;
    }

    public String inputCode() {
        System.out.println("Mã khách hàng có sẵn. Chọn một: ");
        String code = "";
        for (Customer d : csi.getList()) {
            System.out.println(d.getCode());
        }
        boolean isAvailable = false;
        while (!isAvailable) {
            String newCustomerCode = scanner.nextLine();
            for (Customer c : csi.getList()) {
                if (newCustomerCode.equals(c.getCode())) {
                    isAvailable = true;
                    break;
                }
            }
            if (isAvailable) {
                System.out.println("Thành công.");
            } else {
                System.err.println("Nhập sai, vui lòng nhập lại. ");
            }
        }
        return code;
    }

    public String inputBookingCode() {
        System.out.println("Nhập mã booking mới: ");
        boolean isLegalCode = false;
        String code = "";
        while (!isLegalCode) {
            try {
                code = scanner.nextLine();
                System.out.println("Thành công.");
                isLegalCode = true;
            } catch (NumberFormatException e) {
                System.err.println("Nhập sai, vui lòng nhập lại: ");
            }
        }
        return code;
    }

    @Override
    public void editContract() {
    }

    @Override
    public void addNew() throws IOException {
    }

    @Override
    public void displayList() throws IOException {

    }
}
