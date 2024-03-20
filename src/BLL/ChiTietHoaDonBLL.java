package BLL;
import DAL.ChiTietHoaDonDAL;
import IDAL.IChiTietHoaDonDAL;
import DTO.ChiTietHoaDonDTO;

import java.util.List;

public class ChiTietHoaDonBLL {
    private static IChiTietHoaDonDAL chiTietHoaDonDAL = new ChiTietHoaDonDAL();

    private ChiTietHoaDonBLL() {
        // Đảm bảo rằng lớp này không thể tạo đối tượng bên ngoài
    }

    public static boolean themChiTietHoaDon(ChiTietHoaDonDTO chiTietHoaDon) {
        
        // Thực hiện kiểm tra và xử lý logic kinh doanh
        // Nếu điều kiện thêm hợp lệ, gọi phương thức thêm từ DAL
        return chiTietHoaDonDAL.themChiTietHoaDon(chiTietHoaDon);
    }

    public static boolean suaChiTietHoaDon(ChiTietHoaDonDTO chiTietHoaDon) {
        
        // Thực hiện kiểm tra và xử lý logic kinh doanh
        // Nếu điều kiện sửa hợp lệ, gọi phương thức sửa từ DAL
        return chiTietHoaDonDAL.suaChiTietHoaDon(chiTietHoaDon);
    }

    public static boolean xoaChiTietHoaDon(int id) {
        
        // Thực hiện kiểm tra và xử lý logic kinh doanh
        // Nếu điều kiện xóa hợp lệ, gọi phương thức xóa từ DAL
        return chiTietHoaDonDAL.xoaChiTietHoaDon(id);
    }

    public static List<ChiTietHoaDonDTO> layDanhSachChiTietHoaDonTheoMaHoaDon(int maHoaDon) {
        
        // Thực hiện kiểm tra và xử lý logic kinh doanh (nếu cần)
        // Gọi phương thức lấy danh sách từ DAL và trả về
        return chiTietHoaDonDAL.layDanhSachChiTietHoaDonTheoMaHoaDon(maHoaDon);
    }
}
