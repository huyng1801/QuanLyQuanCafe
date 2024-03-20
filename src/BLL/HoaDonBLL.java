package BLL;
import DAL.HoaDonDAL;
import IDAL.IHoaDonDAL;
import DTO.HoaDonDTO;
import DTO.OrderStatistics;

import java.util.List;
public class HoaDonBLL {
    private static IHoaDonDAL hoaDonDAL = new HoaDonDAL();


    private HoaDonBLL() {
        // Đảm bảo rằng lớp này không thể tạo đối tượng bên ngoài
    }

    public static int themHoaDon(HoaDonDTO hoaDon) {
        
        // Thực hiện kiểm tra và xử lý logic kinh doanh
        // Nếu điều kiện thêm hợp lệ, gọi phương thức thêm từ DAL
        return hoaDonDAL.themHoaDon(hoaDon);
    }

    public static boolean suaHoaDon(HoaDonDTO hoaDon) {
        
        // Thực hiện kiểm tra và xử lý logic kinh doanh
        // Nếu điều kiện sửa hợp lệ, gọi phương thức sửa từ DAL
        return hoaDonDAL.suaHoaDon(hoaDon);
    }

    public static boolean xoaHoaDon(int maHoaDon) {

        
        // Thực hiện kiểm tra và xử lý logic kinh doanh
        // Nếu điều kiện xóa hợp lệ, gọi phương thức xóa từ DAL
        return hoaDonDAL.xoaHoaDon(maHoaDon);
    }

    public static boolean capNhatTrangThai(int maHoaDon, boolean trangThai) {
        
        // Thực hiện kiểm tra và xử lý logic kinh doanh
        // Nếu điều kiện cập nhật trạng thái hợp lệ, gọi phương thức cập nhật từ DAL
        return hoaDonDAL.capNhatTrangThai(maHoaDon, trangThai);
    }

    public static List<HoaDonDTO> layDanhSachHoaDon() {
        
        // Thực hiện kiểm tra và xử lý logic kinh doanh (nếu cần)
        // Gọi phương thức lấy danh sách từ DAL và trả về
        return hoaDonDAL.layDanhSachHoaDon();
    }
    public static double tinhTongTienHoaDon(int maHoaDon){
    return hoaDonDAL.tinhTongTienHoaDon(maHoaDon);
    }
    public static List<OrderStatistics> thongKeHoaDonTheoTenThucUong(String tenThucUong){
    
return hoaDonDAL.thongKeHoaDonTheoTenThucUong(tenThucUong);    }
}
