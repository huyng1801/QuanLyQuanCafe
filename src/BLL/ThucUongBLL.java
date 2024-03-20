package BLL;
import DAL.ThucUongDAL;
import IDAL.IThucUongDAL;
import DTO.ThucUongDTO;

import java.util.List;
public class ThucUongBLL {
    private static IThucUongDAL thucUongDAL = new ThucUongDAL();
    private ThucUongBLL() {
        // Đảm bảo rằng lớp này không thể tạo đối tượng bên ngoài
    }

    public static boolean themThucUong(ThucUongDTO thucUong) {
        // Thực hiện kiểm tra và xử lý logic kinh doanh
        // Nếu điều kiện thêm hợp lệ, gọi phương thức thêm từ DAL
        return thucUongDAL.themThucUong(thucUong);
    }

    public static boolean suaThucUong(ThucUongDTO thucUong) {
        // Thực hiện kiểm tra và xử lý logic kinh doanh
        // Nếu điều kiện sửa hợp lệ, gọi phương thức sửa từ DAL
        return thucUongDAL.suaThucUong(thucUong);
    }

    public static boolean xoaThucUong(int maThucUong) {
        // Thực hiện kiểm tra và xử lý logic kinh doanh
        // Nếu điều kiện xóa hợp lệ, gọi phương thức xóa từ DAL
        return thucUongDAL.xoaThucUong(maThucUong);
    }

    public static List<ThucUongDTO> layDanhSachThucUong() {
        // Thực hiện kiểm tra và xử lý logic kinh doanh (nếu cần)
        // Gọi phương thức lấy danh sách từ DAL và trả về
        return thucUongDAL.layDanhSachThucUong();
    }

    public static ThucUongDTO timThucUongTheoMa(int maThucUong) {
        // Thực hiện kiểm tra và xử lý logic kinh doanh (nếu cần)
        // Gọi phương thức tìm theo mã từ DAL và trả về
        return thucUongDAL.timThucUongTheoMa(maThucUong);
    }

    public static ThucUongDTO timThucUongTheoTen(String tenThucUong) {
        // Thực hiện kiểm tra và xử lý logic kinh doanh (nếu cần)
        // Gọi phương thức tìm theo tên từ DAL và trả về
        return thucUongDAL.timThucUongTheoTen(tenThucUong);
    }
}