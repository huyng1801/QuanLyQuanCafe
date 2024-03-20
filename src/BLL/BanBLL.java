package BLL;
import DAL.BanDAL;
import IDAL.IBanDAL;
import DTO.BanDTO;
import DTO.ChiTietHoaDonDTO;
import DTO.HoaDonDTO;
import Utils.JdbcUltils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

public class BanBLL {
    private static IBanDAL banDAL = new BanDAL();

    public static boolean themBan(BanDTO ban) {
        return banDAL.themBan(ban);
    }

    public static boolean suaBan(BanDTO ban) {
        return banDAL.suaBan(ban);
    }

    public static boolean xoaBan(int maBan) {
        return banDAL.xoaBan(maBan);
    }

    public static List<BanDTO> layDanhSachBan() {
        return banDAL.layDanhSachBan();
    }

    public static BanDTO timBanTheoMa(int maBan) {
        return banDAL.timBanTheoMa(maBan);
    }

    public static BanDTO timBanTheoTen(String tenBan) {
        return banDAL.timBanTheoTen(tenBan);
    }

    public static HoaDonDTO timHoaDonHienTai(int maBan) {
        return banDAL.timHoaDonHienTai(maBan);
    }

    public static boolean capNhatTrangThai(int maBan, String trangThai) {
        return banDAL.capNhatTrangThai(maBan, trangThai);
    }
    public static List<ChiTietHoaDonDTO> layChiTietHoaDonChuaThanhToanCuaBan(int maBan) {
    return banDAL.layChiTietHoaDonChuaThanhToanCuaBan(maBan);
}
     public static HoaDonDTO layHoaDonChuaThanhToanCuaBan(int maBan){
     return banDAL.layHoaDonChuaThanhToanCuaBan(maBan);
     }
}
