package BLL;
import DAL.LoaiDAL;
import IDAL.ILoaiDAL;
import DTO.LoaiDTO;

import java.util.List;
public class LoaiBLL {
    private static ILoaiDAL loaiDAL = new LoaiDAL();
    private LoaiBLL() {
        // Đảm bảo rằng lớp này không thể tạo đối tượng bên ngoài
    }

    public static boolean themLoai(LoaiDTO loai) {
        // Thực hiện kiểm tra và xử lý logic kinh doanh
        // Nếu điều kiện thêm hợp lệ, gọi phương thức thêm từ DAL
        return loaiDAL.themLoai(loai);
    }

    public static boolean suaLoai(LoaiDTO loai) {
        // Thực hiện kiểm tra và xử lý logic kinh doanh
        // Nếu điều kiện sửa hợp lệ, gọi phương thức sửa từ DAL
        return loaiDAL.suaLoai(loai);
    }

    public static boolean xoaLoai(int maLoai) {
        // Thực hiện kiểm tra và xử lý logic kinh doanh
        // Nếu điều kiện xóa hợp lệ, gọi phương thức xóa từ DAL
        return loaiDAL.xoaLoai(maLoai);
    }

    public static List<LoaiDTO> layDanhSachLoai() {
        // Thực hiện kiểm tra và xử lý logic kinh doanh (nếu cần)
        // Gọi phương thức lấy danh sách từ DAL và trả về
        return loaiDAL.layDanhSachLoai();
    }

    public static LoaiDTO timLoaiTheoMa(int maLoai) {
        // Thực hiện kiểm tra và xử lý logic kinh doanh (nếu cần)
        // Gọi phương thức tìm theo mã từ DAL và trả về
        return loaiDAL.timLoaiTheoMa(maLoai);
    }

    public static LoaiDTO timLoaiTheoTen(String tenLoai) {
        // Thực hiện kiểm tra và xử lý logic kinh doanh (nếu cần)
        // Gọi phương thức tìm theo tên từ DAL và trả về
        return loaiDAL.timLoaiTheoTen(tenLoai);
    }
}