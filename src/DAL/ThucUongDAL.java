package DAL;
import IDAL.IThucUongDAL;
import DTO.ThucUongDTO;
import Utils.JdbcUltils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ThucUongDAL implements IThucUongDAL {

    @Override
    public boolean themThucUong(ThucUongDTO thucUong) {
        Connection connection = JdbcUltils.getConnect();
        if (connection == null) {
            return false;
        }

        String query = "INSERT INTO ThucUong (TenThucUong, MaLoai, Gia) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, thucUong.getTenThucUong());
            preparedStatement.setInt(2, thucUong.getMaLoai());
            preparedStatement.setLong(3, thucUong.getGia());

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
    public boolean suaThucUong(ThucUongDTO thucUong) {
        Connection connection = JdbcUltils.getConnect();
        if (connection == null) {
            return false;
        }

        String query = "UPDATE ThucUong SET TenThucUong = ?, MaLoai = ?, Gia = ? WHERE MaThucUong = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, thucUong.getTenThucUong());
            preparedStatement.setInt(2, thucUong.getMaLoai());
            preparedStatement.setLong(3, thucUong.getGia());
            preparedStatement.setInt(4, thucUong.getMaThucUong());

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
    public boolean xoaThucUong(int maThucUong) {
        Connection connection = JdbcUltils.getConnect();
        if (connection == null) {
            return false;
        }

        String query = "DELETE FROM ThucUong WHERE MaThucUong = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, maThucUong);

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
    public List<ThucUongDTO> layDanhSachThucUong() {
        List<ThucUongDTO> danhSachThucUong = new ArrayList<>();
        Connection connection = JdbcUltils.getConnect();
        if (connection == null) {
            return danhSachThucUong;
        }

        String query = "SELECT * FROM ThucUong";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                ThucUongDTO thucUong = new ThucUongDTO();
                thucUong.setMaThucUong(resultSet.getInt("MaThucUong"));
                thucUong.setTenThucUong(resultSet.getString("TenThucUong"));
                thucUong.setMaLoai(resultSet.getInt("MaLoai"));
                thucUong.setGia(resultSet.getLong("Gia"));
                danhSachThucUong.add(thucUong);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUltils.getClose(connection);
        }

        return danhSachThucUong;
    }

    @Override
    public ThucUongDTO timThucUongTheoMa(int maThucUong) {
        ThucUongDTO thucUong = null;
        Connection connection = JdbcUltils.getConnect();
        if (connection == null) {
            return thucUong;
        }

        String query = "SELECT * FROM ThucUong WHERE MaThucUong = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, maThucUong);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    thucUong = new ThucUongDTO();
                    thucUong.setMaThucUong(resultSet.getInt("MaThucUong"));
                    thucUong.setTenThucUong(resultSet.getString("TenThucUong"));
                    thucUong.setMaLoai(resultSet.getInt("MaLoai"));
                    thucUong.setGia(resultSet.getLong("Gia"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUltils.getClose(connection);
        }

        return thucUong;
    }

    @Override
    public ThucUongDTO timThucUongTheoTen(String tenThucUong) {
        ThucUongDTO thucUong = null;
        Connection connection = JdbcUltils.getConnect();
        if (connection == null) {
            return thucUong;
        }

        String query = "SELECT * FROM ThucUong WHERE TenThucUong = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, tenThucUong);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    thucUong = new ThucUongDTO();
                    thucUong.setMaThucUong(resultSet.getInt("MaThucUong"));
                    thucUong.setTenThucUong(resultSet.getString("TenThucUong"));
                    thucUong.setMaLoai(resultSet.getInt("MaLoai"));
                    thucUong.setGia(resultSet.getLong("Gia"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUltils.getClose(connection);
        }

        return thucUong;
    }
}
