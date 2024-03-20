package DAL;

import IDAL.IHoaDonDAL;
import DTO.HoaDonDTO;
import DTO.OrderStatistics;
import Utils.JdbcUltils;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class HoaDonDAL implements IHoaDonDAL {

@Override
public int themHoaDon(HoaDonDTO hoaDon) {
    Connection connection = JdbcUltils.getConnect();
    if (connection == null) {
        return -1; // Trả về -1 nếu không thể kết nối hoặc thêm hóa đơn không thành công.
    }

    String query = "INSERT INTO HoaDon (MaBan) VALUES (?)";

    try (PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

        preparedStatement.setInt(1, hoaDon.getMaBan());

        int rowsAffected = preparedStatement.executeUpdate();

        if (rowsAffected > 0) {
            // Lấy mã hóa đơn vừa thêm
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        JdbcUltils.getClose(connection);
    }

    return -1; // Trả về -1 nếu thêm hóa đơn không thành công.
}


    @Override
    public boolean suaHoaDon(HoaDonDTO hoaDon) {
        Connection connection = JdbcUltils.getConnect();
        if (connection == null) {
            return false;
        }

        String query = "UPDATE HoaDon SET ThoiGianRa = GETDATE(), TrangThai = 1 WHERE MaHoaDon = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, hoaDon.getMaHoaDon());

            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            JdbcUltils.getClose(connection);
        }
    }

    @Override
    public boolean xoaHoaDon(int maHoaDon) {
        Connection connection = JdbcUltils.getConnect();
        if (connection == null) {
            return false;
        }

        String query = "DELETE FROM HoaDon WHERE MaHoaDon = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, maHoaDon);

            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            JdbcUltils.getClose(connection);
        }
    }

    @Override
    public boolean capNhatTrangThai(int maHoaDon, boolean trangThai) {
        Connection connection = JdbcUltils.getConnect();
        if (connection == null) {
            return false;
        }

        String query = "UPDATE HoaDon SET TrangThai = ? WHERE MaHoaDon = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setBoolean(1, trangThai);
            preparedStatement.setInt(2, maHoaDon);

            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            JdbcUltils.getClose(connection);
        }
    }

    @Override
    public List<HoaDonDTO> layDanhSachHoaDon() {
        List<HoaDonDTO> danhSachHoaDon = new ArrayList<>();
        Connection connection = JdbcUltils.getConnect();
        if (connection == null) {
            return danhSachHoaDon;
        }

        String query = "SELECT * FROM HoaDon";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                HoaDonDTO hoaDon = new HoaDonDTO();
                hoaDon.setMaHoaDon(resultSet.getInt("MaHoaDon"));
                hoaDon.setThoiGianVao(resultSet.getDate("ThoiGianVao"));
                hoaDon.setThoiGianRa(resultSet.getDate("ThoiGianRa"));
                hoaDon.setMaBan(resultSet.getInt("MaBan"));
                hoaDon.setTrangThai(resultSet.getBoolean("TrangThai"));
                danhSachHoaDon.add(hoaDon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUltils.getClose(connection);
        }

        return danhSachHoaDon;
    }

    @Override
    public double tinhTongTienHoaDon(int maHoaDon) {
        double tongTien = 0;
        Connection connection = JdbcUltils.getConnect();

        if (connection == null) {
            return tongTien;
        }

        String query = "SELECT SUM(ThucUong.Gia * ChiTietHoaDon.SoLuong) AS TongTien "
                + "FROM HoaDon "
                + "INNER JOIN ChiTietHoaDon ON HoaDon.MaHoaDon = ChiTietHoaDon.MaHoaDon "
                + "INNER JOIN ThucUong ON ChiTietHoaDon.MaThucUong = ThucUong.MaThucUong "
                + "WHERE HoaDon.MaHoaDon = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, maHoaDon);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                tongTien = resultSet.getDouble("TongTien");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUltils.getClose(connection);
        }

        return tongTien;
    }
public List<OrderStatistics> thongKeHoaDonTheoTenThucUong(String tenThucUong) {
    List<OrderStatistics> statistics = new ArrayList<>();
    Connection connection = JdbcUltils.getConnect();

    if (connection == null) {
        return statistics;
    }

    String query = "SELECT HoaDon.MaHoaDon, HoaDon.ThoiGianVao, HoaDon.ThoiGianRa, HoaDon.MaBan, "
            + "ThucUong.TenThucUong, ChiTietHoaDon.SoLuong, ThucUong.Gia, "
            + "(ChiTietHoaDon.SoLuong * ThucUong.Gia) AS TotalAmount "
            + "FROM HoaDon "
            + "INNER JOIN ChiTietHoaDon ON HoaDon.MaHoaDon = ChiTietHoaDon.MaHoaDon "
            + "INNER JOIN ThucUong ON ChiTietHoaDon.MaThucUong = ThucUong.MaThucUong "
            + "WHERE ThucUong.TenThucUong = ?";

    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setString(1, tenThucUong);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            OrderStatistics stat = new OrderStatistics();
            stat.setOrderID(resultSet.getInt("MaHoaDon"));
            stat.setEntryTime(resultSet.getDate("ThoiGianVao"));
            stat.setExitTime(resultSet.getDate("ThoiGianRa"));
            stat.setTableNumber(resultSet.getInt("MaBan"));
            stat.setDrinkName(resultSet.getString("TenThucUong"));
            stat.setQuantity(resultSet.getInt("SoLuong"));
            stat.setUnitPrice(resultSet.getDouble("Gia"));
            stat.setTotalAmount(resultSet.getDouble("TotalAmount"));
            statistics.add(stat);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        JdbcUltils.getClose(connection);
    }

    return statistics;
}

}
