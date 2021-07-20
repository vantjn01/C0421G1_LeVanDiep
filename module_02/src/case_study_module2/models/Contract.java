package case_study_module2.models;

public class Contract {
    private String idContract;
    private Booking booking;
    private int deposit;          // tiền cọc
    private int totalPayment;     // tổng tiền thanh toán
    private String customer;

    public Contract(int idContract, String s, int deposit, int totalPayment, String customer4) {
    }

    public Contract(String idContract, Booking booking, int deposit, int totalPayment,  String customer) {
        this.idContract = idContract;
        this.booking = booking;
        this.deposit = deposit;
        this.totalPayment = totalPayment;
        this.customer = customer;
    }

    public Contract() {
    }

    public String getIdContract() {
        return idContract;
    }

    public void setIdContract(String idContract) {
        this.idContract = idContract;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public int getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(int totalPayment) {
        this.totalPayment = totalPayment;
    }



    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }



    @Override
    public String toString() {
        return "Contract{" +
                "idContract=" + idContract +
                ", booking=" + booking +
                ", deposit=" + deposit +
                ", totalPayment=" + totalPayment +
                ", customer=" + customer +
                '}';
    }
}
