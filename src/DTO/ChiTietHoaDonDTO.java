package DTO;
public class ChiTietHoaDonDTO {
    private int id;
    private int maHoaDon;
    private int maThucUong;
    private int soLuong;

    // Các phương thức getter và setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public int getMaThucUong() {
        return maThucUong;
    }

    public void setMaThucUong(int maThucUong) {
        this.maThucUong = maThucUong;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
