package QLTT_GiangDay.entities;

import java.io.Serializable;

public class SinhVien implements Serializable {
    private static final long serialVersionUID = 1L;
    private String maSV;
    private String hoTen;
    private int namSinh;
    private String gioiTinh;
    private String maLop;

    public SinhVien() {
    }
    public SinhVien(String maSV, String hoTen, int namSinh, String gioiTinh, String maLop) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.gioiTinh = gioiTinh;
        this.maLop = maLop;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "maSV='" + maSV + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", namSinh=" + namSinh +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", maLop='" + maLop + '\'' +
                '}';
    }
}
