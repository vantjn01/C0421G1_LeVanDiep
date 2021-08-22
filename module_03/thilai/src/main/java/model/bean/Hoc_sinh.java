package model.bean;

public class Hoc_sinh {
    private int id_hs;
    private String ho_ten;
    private String lop;

    public Hoc_sinh() {

    }

    public Hoc_sinh(int id_hs, String ho_ten, String lop) {
        this.id_hs = id_hs;
        this.ho_ten = ho_ten;
        this.lop = lop;
    }

    public Hoc_sinh(String ho_ten, String lop) {
        this.ho_ten = ho_ten;
        this.lop = lop;
    }

    public int getId_hs() {
        return id_hs;
    }

    public void setId_hs(int id_hs) {
        this.id_hs = id_hs;
    }

    public String getHo_ten() {
        return ho_ten;
    }

    public void setHo_ten(String ho_ten) {
        this.ho_ten = ho_ten;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }
}
