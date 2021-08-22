package model.bean;

public class Sach {
    private int id_sach;
    private String ten_sach;
    private String tac_gia;
    private String mo_ta;
    private int so_luong;

    public Sach() {
    }

    public Sach(int id_sach, String ten_sach, String tac_gia, String mo_ta, int so_luong) {
        this.id_sach = id_sach;
        this.ten_sach = ten_sach;
        this.tac_gia = tac_gia;
        this.mo_ta = mo_ta;
        this.so_luong = so_luong;
    }

    public Sach(String ten_sach, String tac_gia, String mo_ta, int so_luong) {
        this.ten_sach = ten_sach;
        this.tac_gia = tac_gia;
        this.mo_ta = mo_ta;
        this.so_luong = so_luong;
    }

    public int getId_sach() {
        return id_sach;
    }

    public void setId_sach(int id_sach) {
        this.id_sach = id_sach;
    }

    public String getTen_sach() {
        return ten_sach;
    }

    public void setTen_sach(String ten_sach) {
        this.ten_sach = ten_sach;
    }

    public String getTac_gia() {
        return tac_gia;
    }

    public void setTac_gia(String tac_gia) {
        this.tac_gia = tac_gia;
    }

    public String getMo_ta() {
        return mo_ta;
    }

    public void setMo_ta(String mo_ta) {
        this.mo_ta = mo_ta;
    }

    public int getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(int so_luong) {
        this.so_luong = so_luong;
    }
}
