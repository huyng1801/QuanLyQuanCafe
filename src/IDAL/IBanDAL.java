package IDAL;
import DTO.BanDTO;
import DTO.ChiTietHoaDonDTO;
import DTO.HoaDonDTO;
import java.util.List;

public interface IBanDAL {
    boolean themBan(BanDTO ban);
    boolean suaBan(BanDTO ban);
    boolean xoaBan(int maBan);
    List<BanDTO> layDanhSachBan();
    boolean capNhatTrangThai(int maBan, String trangThai);
    BanDTO timBanTheoMa(int maBan);
    BanDTO timBanTheoTen(String tenBan);
    HoaDonDTO timHoaDonHienTai(int maBan);
    List<ChiTietHoaDonDTO> layChiTietHoaDonChuaThanhToanCuaBan(int maBan);
    HoaDonDTO  layHoaDonChuaThanhToanCuaBan(int maBan);
}
