package case_study_module2.models;

public class Booking implements Comparable<Booking> {
    private String idBooking;
    private int startDay;
    private int endDay;
    private String customer;
    private String facility;

    public Booking() {
    }

    public Booking(String idBooking, int startDay, int endDay, String customer, String facility) {
        this.idBooking = idBooking;
        this.startDay = startDay;
        this.endDay = endDay;
        this.customer = customer;
        this.facility = facility;
    }

    public String getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(String idBooking) {
        this.idBooking = idBooking;
    }

    public int getStartDay() {
        return startDay;
    }

    public void setStartDay(int startDay) {
        this.startDay = startDay;
    }

    public int getEndDay() {
        return endDay;
    }

    public void setEndDay(int endDay) {
        this.endDay = endDay;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "idBooking=" + idBooking +
                ", startDay='" + startDay + '\'' +
                ", endDay='" + endDay + '\'' +
                ", customer=" + customer +
                ", facility=" + facility +
                '}';
    }

    @Override
    public int compareTo(Booking o) {
        if (getStartDay() > o.getStartDay()) {
            return 1;
        }
        else if (getStartDay() < o.getStartDay()) {
            return -1;
        }
        else {
            return 1;
        }
    }
}
