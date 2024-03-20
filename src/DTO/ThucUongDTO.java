package DTO;
public class ThucUongDTO {
    private int maThucUong;
    private String tenThucUong;
    private int maLoai;
    private long gia;

    // Getter và Setter
    public int getMaThucUong() {
        return maThucUong;
    }

    public void setMaThucUong(int maThucUong) {
        this.maThucUong = maThucUong;
    }

    public String getTenThucUong() {
        return tenThucUong;
    }

    public void setTenThucUong(String tenThucUong) {
        this.tenThucUong = tenThucUong;
    }

    public int getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(int maLoai) {
        this.maLoai = maLoai;
    }

    public long getGia() {
        return gia;
    }

    public void setGia(long gia) {
        this.gia = gia;
    }
}
