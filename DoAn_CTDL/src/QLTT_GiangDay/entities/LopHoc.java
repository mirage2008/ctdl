package QLTT_GiangDay.entities;

public class LopHoc {
    private String maLop;
    private String maKhoa;
    private String maKhoaHoc;
    private String maCTr;
    private int stt;

    public LopHoc(String maLop, String maKhoa, String maKhoaHoc, String maCTr, int stt) {
        this.maLop = maLop;
        this.maKhoa = maKhoa;
        this.maKhoaHoc = maKhoaHoc;
        this.maCTr = maCTr;
        this.stt = stt;
    }

    public LopHoc() {
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    public String getMaKhoaHoc() {
        return maKhoaHoc;
    }

    public void setMaKhoaHoc(String maKhoaHoc) {
        this.maKhoaHoc = maKhoaHoc;
    }

    public String getMaCTr() {
        return maCTr;
    }

    public void setMaCTr(String maCTr) {
        this.maCTr = maCTr;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    @Override
    public String toString() {
        return "LopHoc{" +
                "maLop='" + maLop + '\'' +
                ", maKhoa='" + maKhoa + '\'' +
                ", maKhoaHoc='" + maKhoaHoc + '\'' +
                ", maCTr='" + maCTr + '\'' +
                ", stt=" + stt +
                '}';
    }
}
