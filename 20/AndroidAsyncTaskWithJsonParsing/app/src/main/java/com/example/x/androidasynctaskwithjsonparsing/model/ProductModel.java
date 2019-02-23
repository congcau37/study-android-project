package com.example.x.androidasynctaskwithjsonparsing.model;

/* Created by X on 12/6/2017.
* */

import java.io.Serializable;

public class ProductModel implements Serializable {
    private int id_sanpham;
    private String ten_sanpham;
    private int id_danhmuc;
    private int gia_sanpham;
    private String mota_sanpham;
    private int sanpham_noibat;
    private String anh_sanpham;

    public ProductModel(int id_sanpham, String ten_sanpham, int id_danhmuc, int gia_sanpham, String mota_sanpham, int sanpham_noibat, String anh_sanpham) {
        this.id_sanpham = id_sanpham;
        this.ten_sanpham = ten_sanpham;
        this.id_danhmuc = id_danhmuc;
        this.gia_sanpham = gia_sanpham;
        this.mota_sanpham = mota_sanpham;
        this.sanpham_noibat = sanpham_noibat;
        this.anh_sanpham = anh_sanpham;
    }

    public int getId_sanpham() {
        return id_sanpham;
    }

    public String getTen_sanpham() {
        return ten_sanpham;
    }

    public int getId_danhmuc() {
        return id_danhmuc;
    }

    public int getGia_sanpham() {
        return gia_sanpham;
    }

    public String getMota_sanpham() {
        return mota_sanpham;
    }

    public int getSanpham_noibat() {
        return sanpham_noibat;
    }

    public String getAnh_sanpham() {
        return anh_sanpham;
    }
}
