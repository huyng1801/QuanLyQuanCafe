package DTO;
import java.sql.Date;

public class HoaDonDTO {
    private int maHoaDon;
    private Date thoiGianVao;
    private Date thoiGianRa;
    private int maBan;
    private boolean trangThai;

    // Getter và Setter
    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public Date getThoiGianVao() {
        return thoiGianVao;
    }

    public void setThoiGianVao(Date thoiGianVao) {
        this.thoiGianVao = thoiGianVao;
    }

    public Date getThoiGianRa() {
        return thoiGianRa;
    }

    public void setThoiGianRa(Date thoiGianRa) {
        this.thoiGianRa = thoiGianRa;
    }

    public int getMaBan() {
        return maBan;
    }

    public void setMaBan(int maBan) {
        this.maBan = maBan;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
}
