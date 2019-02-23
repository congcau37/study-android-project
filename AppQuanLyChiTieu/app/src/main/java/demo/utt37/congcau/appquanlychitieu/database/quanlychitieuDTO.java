package demo.utt37.congcau.appquanlychitieu.database;

/**
 * Created by cong on 12/29/2017.
 */


public class quanlychitieuDTO {
    private int id_chitieu;
    private int ngay;
    private int thang;
    private int sotien;
    private int sodu;
    private int loaigiaodich;
    private String noidung;


    public int getId_chitieu() {
        return id_chitieu;
    }

    public void setId_chitieu(int id_chitieu) {
        this.id_chitieu = id_chitieu;
    }

    public int getNgay() {
        return ngay;
    }

    public void setNgay(int ngay) {
        this.ngay = ngay;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public int getSotien() {
        return sotien;
    }

    public void setSotien(int sotien) {
        this.sotien = sotien;
    }

    public int getSodu() {
        return sodu;
    }

    public void setSodu(int sodu) {
        this.sodu = sodu;
    }

    public int getLoaigiaodich() {
        return loaigiaodich;
    }

    public void setLoaigiaodich(int loaigiaodich) {
        this.loaigiaodich = loaigiaodich;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }
}
