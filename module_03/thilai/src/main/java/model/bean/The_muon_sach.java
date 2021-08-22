package model.bean;

public class The_muon_sach {
    private int id_the;
    private int id_sach;
    private int id_hs;
    private int trang_thai;
    private String ngay_muon;
    private String ngay_tra;

    public The_muon_sach() {
    }

    public The_muon_sach(int id_the, int id_sach, int id_hs, int trang_thai, String ngay_muon, String ngay_tra) {
        this.id_the = id_the;
        this.id_sach = id_sach;
        this.id_hs = id_hs;
        this.trang_thai = trang_thai;
        this.ngay_muon = ngay_muon;
        this.ngay_tra = ngay_tra;
    }

    public The_muon_sach(int id_sach, int id_hs, int trang_thai, String ngay_muon, String ngay_tra) {
        this.id_sach = id_sach;
        this.id_hs = id_hs;
        this.trang_thai = trang_thai;
        this.ngay_muon = ngay_muon;
        this.ngay_tra = ngay_tra;
    }

    public int getId_the() {
        return id_the;
    }

    public void setId_the(int id_the) {
        this.id_the = id_the;
    }

    public int getId_sach() {
        return id_sach;
    }

    public void setId_sach(int id_sach) {
        this.id_sach = id_sach;
    }

    public int getId_hs() {
        return id_hs;
    }

    public void setId_hs(int id_hs) {
        this.id_hs = id_hs;
    }

    public int getTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(int trang_thai) {
        this.trang_thai = trang_thai;
    }

    public String getNgay_muon() {
        return ngay_muon;
    }

    public void setNgay_muon(String ngay_muon) {
        this.ngay_muon = ngay_muon;
    }

    public String getNgay_tra() {
        return ngay_tra;
    }

    public void setNgay_tra(String ngay_tra) {
        this.ngay_tra = ngay_tra;
    }
}
