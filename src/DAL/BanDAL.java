package DAL;
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

public class BanDAL implements IBanDAL {

    @Override
    public boolean themBan(BanDTO ban) {
        Connection connection = JdbcUltils.getConnect();
        if (connection == null) {
            return false;
        }

        String query = "INSERT INTO Ban (TenBan) VALUES (?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, ban.getTenBan());

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
    public boolean suaBan(BanDTO ban) {
        Connection connection = JdbcUltils.getConnect();
        if (connection == null) {
            return false;
        }

        String query = "UPDATE Ban SET TenBan = ? WHERE MaBan = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, ban.getTenBan());
            preparedStatement.setInt(2, ban.getMaBan());

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
    public boolean xoaBan(int maBan) {
        Connection connection = JdbcUltils.getConnect();
        if (connection == null) {
            return false;
        }

        String query = "DELETE FROM Ban WHERE MaBan = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, maBan);

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
    public List<BanDTO> layDanhSachBan() {
        List<BanDTO> danhSachBan = new ArrayList<>();
        Connection connection = JdbcUltils.getConnect();
        if (connection == null) {
            return danhSachBan;
        }

        String query = "SELECT * FROM Ban";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                BanDTO ban = new BanDTO();
                ban.setMaBan(resultSet.getInt("MaBan"));
                ban.setTenBan(resultSet.getString("TenBan"));
                ban.setTrangThai(resultSet.getString("TrangThai"));
                danhSachBan.add(ban);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUltils.getClose(connection);
        }

        return danhSachBan;
    }

    @Override
    public BanDTO timBanTheoMa(int maBan) {
        BanDTO ban = null;
        Connection connection = JdbcUltils.getConnect();
        if (connection == null) {
            return ban;
        }

        String query = "SELECT * FROM Ban WHERE MaBan = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, maBan);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    ban = new BanDTO();
                    ban.setMaBan(resultSet.getInt("MaBan"));
                    ban.setTenBan(resultSet.getString("TenBan"));
                    ban.setTrangThai(resultSet.getString("TrangThai"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUltils.getClose(connection);
        }

        return ban;
    }

    @Override
    public BanDTO timBanTheoTen(String tenBan) {
        BanDTO ban = null;
        Connection connection = JdbcUltils.getConnect();
        if (connection == null) {
            return ban;
        }

        String query = "SELECT * FROM Ban WHERE TenBan = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, tenBan);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    ban = new BanDTO();
                    ban.setMaBan(resultSet.getInt("MaBan"));
                    ban.setTenBan(resultSet.getString("TenBan"));
                    ban.setTrangThai(resultSet.getString("TrangThai"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUltils.getClose(connection);
        }

        return ban;
    }

    @Override
    public HoaDonDTO timHoaDonHienTai(int maBan) {
        HoaDonDTO hoaDon = null;
        Connection connection = JdbcUltils.getConnect();
        if (connection == null) {
            return hoaDon;
        }

        String query = "SELECT * FROM HoaDon WHERE MaBan = ? AND TrangThai = 0";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, maBan);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    hoaDon = new HoaDonDTO();
                    hoaDon.setMaHoaDon(resultSet.getInt("MaHoaDon"));
                    hoaDon.setThoiGianVao(resultSet.getDate("ThoiGianVao"));
                    hoaDon.setThoiGianRa(resultSet.getDate("ThoiGianRa"));
                    hoaDon.setMaBan(resultSet.getInt("MaBan"));
                    hoaDon.setTrangThai(resultSet.getBoolean("TrangThai"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUltils.getClose(connection);
        }

        return hoaDon;
    }
    @Override
public boolean capNhatTrangThai(int maBan, String trangThai) {
    Connection connection = JdbcUltils.getConnect();
    if (connection == null) {
        return false;
    }

    String query = "UPDATE Ban SET TrangThai = ? WHERE MaBan = ?";

    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setString(1, trangThai);
        preparedStatement.setInt(2, maBan);

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
    public List<ChiTietHoaDonDTO> layChiTietHoaDonChuaThanhToanCuaBan(int maBan) {
    Connection connection = JdbcUltils.getConnect();
    if (connection == null) {
        return new ArrayList<>();
    }

    String query = "SELECT HoaDon.MaHoaDon, ChiTietHoaDon.id, ChiTietHoaDon.MaThucUong, ChiTietHoaDon.SoLuong " +
                   "FROM HoaDon " +
                   "INNER JOIN ChiTietHoaDon ON HoaDon.MaHoaDon = ChiTietHoaDon.MaHoaDon " +
                   "INNER JOIN ThucUong ON ChiTietHoaDon.MaThucUong = ThucUong.MaThucUong " +
                   "WHERE HoaDon.MaBan = ? AND HoaDon.TrangThai = 0";

    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setInt(1, maBan);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<ChiTietHoaDonDTO> chiTietHoaDonList = new ArrayList<>();

        while (resultSet.next()) {
            ChiTietHoaDonDTO chiTietHoaDon = new ChiTietHoaDonDTO();
            chiTietHoaDon.setId(resultSet.getInt("id"));
            chiTietHoaDon.setMaHoaDon(resultSet.getInt("MaHoaDon"));
            chiTietHoaDon.setMaThucUong(resultSet.getInt("MaThucUong"));
            chiTietHoaDon.setSoLuong(resultSet.getInt("SoLuong"));
            chiTietHoaDonList.add(chiTietHoaDon);
        }

        return chiTietHoaDonList;
    } catch (SQLException e) {
        e.printStackTrace();
        return new ArrayList<>();
    } finally {
        JdbcUltils.getClose(connection);
    }
}
    @Override
    public HoaDonDTO layHoaDonChuaThanhToanCuaBan(int maBan) {
    Connection connection = JdbcUltils.getConnect();
    if (connection == null) {
        return null;
    }

    String query = "SELECT * FROM HoaDon WHERE MaBan = ? AND TrangThai = 0 ORDER BY ThoiGianVao DESC";

    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setInt(1, maBan);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            HoaDonDTO hoaDon = new HoaDonDTO();
            hoaDon.setMaHoaDon(resultSet.getInt("MaHoaDon"));
            hoaDon.setThoiGianVao(resultSet.getDate("ThoiGianVao"));
            hoaDon.setThoiGianRa(resultSet.getDate("ThoiGianRa"));
            hoaDon.setMaBan(resultSet.getInt("MaBan"));
            hoaDon.setTrangThai(resultSet.getBoolean("TrangThai"));

            return hoaDon;
        } else {
            return null; // Không tìm thấy hóa đơn chưa thanh toán cho bàn này
        }
    } catch (SQLException e) {
        e.printStackTrace();
        return null;
    } finally {
        JdbcUltils.getClose(connection);
    }
}

}
