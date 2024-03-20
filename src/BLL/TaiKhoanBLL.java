package BLL;
import DAL.TaiKhoanDAL;
import IDAL.ITaiKhoanDAL;
import DTO.TaiKhoanDTO;

import java.util.List;


public class TaiKhoanBLL {
    private static ITaiKhoanDAL taiKhoanDAL = new TaiKhoanDAL();
    private TaiKhoanBLL() {
        // Đảm bảo rằng lớp này không thể tạo đối tượng bên ngoài
    }

    public static boolean themTaiKhoan(TaiKhoanDTO taiKhoan) {
        // Thực hiện kiểm tra và xử lý logic kinh doanh
        // Nếu điều kiện thêm hợp lệ, gọi phương thức thêm từ DAL
        return taiKhoanDAL.themTaiKhoan(taiKhoan);
    }

    public static boolean suaTaiKhoan(TaiKhoanDTO taiKhoan) {
        // Thực hiện kiểm tra và xử lý logic kinh doanh
        // Nếu điều kiện sửa hợp lệ, gọi phương thức sửa từ DAL
        return taiKhoanDAL.suaTaiKhoan(taiKhoan);
    }

    public static boolean xoaTaiKhoan(String tenDangNhap) {
        // Thực hiện kiểm tra và xử lý logic kinh doanh
        // Nếu điều kiện xóa hợp lệ, gọi phương thức xóa từ DAL
        return taiKhoanDAL.xoaTaiKhoan(tenDangNhap);
    }

    public static List<TaiKhoanDTO> layDanhSachTaiKhoan() {
        // Thực hiện kiểm tra và xử lý logic kinh doanh (nếu cần)
        // Gọi phương thức lấy danh sách từ DAL và trả về
        return taiKhoanDAL.layDanhSachTaiKhoan();
    }

    public static TaiKhoanDTO timTaiKhoanTheoTenDangNhap(String tenDangNhap) {
        // Thực hiện kiểm tra và xử lý logic kinh doanh (nếu cần)
        // Gọi phương thức tìm theo tên đăng nhập từ DAL và trả về
        return taiKhoanDAL.timTaiKhoanTheoTenDangNhap(tenDangNhap);
    }

    public static TaiKhoanDTO dangNhap(String tenDangNhap, String matKhau) {
        // Thực hiện kiểm tra và xử lý logic kinh doanh (nếu cần)
        // Gọi phương thức đăng nhập từ DAL và trả về
        return taiKhoanDAL.dangNhap(tenDangNhap, matKhau);
    }
}