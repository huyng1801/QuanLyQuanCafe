package IDAL;
import DTO.TaiKhoanDTO;
import java.util.List;

public interface ITaiKhoanDAL {
    boolean themTaiKhoan(TaiKhoanDTO taiKhoan);
    boolean suaTaiKhoan(TaiKhoanDTO taiKhoan);
    boolean xoaTaiKhoan(String tenDangNhap);
    List<TaiKhoanDTO> layDanhSachTaiKhoan();
    TaiKhoanDTO timTaiKhoanTheoTenDangNhap(String tenDangNhap);
    TaiKhoanDTO dangNhap(String tenDangNhap, String matKhau);
}
