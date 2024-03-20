package DAL;
import IDAL.IChiTietHoaDonDAL;
import DTO.ChiTietHoaDonDTO;
import Utils.JdbcUltils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChiTietHoaDonDAL implements IChiTietHoaDonDAL {

    @Override
    public boolean themChiTietHoaDon(ChiTietHoaDonDTO chiTietHoaDon) {
        Connection connection = JdbcUltils.getConnect();
        if (connection == null) {
            return false;
        }

        String query = "INSERT INTO ChiTietHoaDon (MaHoaDon, MaThucUong, SoLuong) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, chiTietHoaDon.getMaHoaDon());
            preparedStatement.setInt(2, chiTietHoaDon.getMaThucUong());
            preparedStatement.setInt(3, chiTietHoaDon.getSoLuong());

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
    public boolean suaChiTietHoaDon(ChiTietHoaDonDTO chiTietHoaDon) {
        Connection connection = JdbcUltils.getConnect();
        if (connection == null) {
            return false;
        }

        String query = "UPDATE ChiTietHoaDon SET SoLuong = ? WHERE MaHoaDon = ? AND MaThucUong = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, chiTietHoaDon.getSoLuong());
            preparedStatement.setInt(2, chiTietHoaDon.getMaHoaDon());
            preparedStatement.setInt(3, chiTietHoaDon.getMaThucUong());

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
    public boolean xoaChiTietHoaDon(int id) {
        Connection connection = JdbcUltils.getConnect();
        if (connection == null) {
            return false;
        }

        String query = "DELETE FROM ChiTietHoaDon WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);

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
    public List<ChiTietHoaDonDTO> layDanhSachChiTietHoaDonTheoMaHoaDon(int maHoaDon) {
        List<ChiTietHoaDonDTO> danhSachChiTietHoaDon = new ArrayList<>();
        Connection connection = JdbcUltils.getConnect();
        if (connection == null) {
            return danhSachChiTietHoaDon;
        }

        String query = "SELECT * FROM ChiTietHoaDon WHERE MaHoaDon = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, maHoaDon);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    ChiTietHoaDonDTO chiTietHoaDon = new ChiTietHoaDonDTO();
                    chiTietHoaDon.setId(resultSet.getInt("id"));
                    chiTietHoaDon.setMaHoaDon(resultSet.getInt("MaHoaDon"));
                    chiTietHoaDon.setMaThucUong(resultSet.getInt("MaThucUong"));
                    chiTietHoaDon.setSoLuong(resultSet.getInt("SoLuong"));
                    danhSachChiTietHoaDon.add(chiTietHoaDon);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUltils.getClose(connection);
        }

        return danhSachChiTietHoaDon;
    }
}
