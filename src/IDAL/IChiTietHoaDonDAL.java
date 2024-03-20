package IDAL;
import DTO.ChiTietHoaDonDTO;
import java.util.List;

public interface IChiTietHoaDonDAL {
    boolean themChiTietHoaDon(ChiTietHoaDonDTO chiTietHoaDon);
    boolean suaChiTietHoaDon(ChiTietHoaDonDTO chiTietHoaDon);
    boolean xoaChiTietHoaDon(int id);
    List<ChiTietHoaDonDTO> layDanhSachChiTietHoaDonTheoMaHoaDon(int maHoaDon);
}
