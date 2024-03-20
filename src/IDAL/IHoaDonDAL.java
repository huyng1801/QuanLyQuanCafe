package IDAL;
import DTO.HoaDonDTO;
import DTO.OrderStatistics;
import java.util.List;

public interface IHoaDonDAL {
    int themHoaDon(HoaDonDTO hoaDon);
    boolean suaHoaDon(HoaDonDTO hoaDon);
    boolean xoaHoaDon(int maHoaDon);
    boolean capNhatTrangThai(int maHoaDon, boolean trangThai);
    List<HoaDonDTO> layDanhSachHoaDon();
    double tinhTongTienHoaDon(int maHoaDon);
     List<OrderStatistics> thongKeHoaDonTheoTenThucUong(String tenThucUong);
}
