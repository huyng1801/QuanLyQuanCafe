package DAL;
import IDAL.ILoaiDAL;
import DTO.LoaiDTO;
import Utils.JdbcUltils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoaiDAL implements ILoaiDAL {

    @Override
    public boolean themLoai(LoaiDTO loai) {
        Connection connection = JdbcUltils.getConnect();
        if (connection == null) {
            return false;
        }

        String query = "INSERT INTO Loai (TenLoai) VALUES (?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, loai.getTenLoai());

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
    public boolean suaLoai(LoaiDTO loai) {
        Connection connection = JdbcUltils.getConnect();
        if (connection == null) {
            return false;
        }

        String query = "UPDATE Loai SET TenLoai = ? WHERE MaLoai = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, loai.getTenLoai());
            preparedStatement.setInt(2, loai.getMaLoai());

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
    public boolean xoaLoai(int maLoai) {
        Connection connection = JdbcUltils.getConnect();
        if (connection == null) {
            return false;
        }

        String query = "DELETE FROM Loai WHERE MaLoai = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, maLoai);

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
    public List<LoaiDTO> layDanhSachLoai() {
        List<LoaiDTO> danhSachLoai = new ArrayList<>();
        Connection connection = JdbcUltils.getConnect();
        if (connection == null) {
            return danhSachLoai;
        }

        String query = "SELECT * FROM Loai";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                LoaiDTO loai = new LoaiDTO();
                loai.setMaLoai(resultSet.getInt("MaLoai"));
                loai.setTenLoai(resultSet.getString("TenLoai"));
                danhSachLoai.add(loai);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUltils.getClose(connection);
        }

        return danhSachLoai;
    }

    @Override
    public LoaiDTO timLoaiTheoMa(int maLoai) {
        LoaiDTO loai = null;
        Connection connection = JdbcUltils.getConnect();
        if (connection == null) {
            return loai;
        }

        String query = "SELECT * FROM Loai WHERE MaLoai = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, maLoai);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    loai = new LoaiDTO();
                    loai.setMaLoai(resultSet.getInt("MaLoai"));
                    loai.setTenLoai(resultSet.getString("TenLoai"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUltils.getClose(connection);
        }

        return loai;
    }

    @Override
    public LoaiDTO timLoaiTheoTen(String tenLoai) {
        LoaiDTO loai = null;
        Connection connection = JdbcUltils.getConnect();
        if (connection == null) {
            return loai;
        }

        String query = "SELECT * FROM Loai WHERE TenLoai = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, tenLoai);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    loai = new LoaiDTO();
                    loai.setMaLoai(resultSet.getInt("MaLoai"));
                    loai.setTenLoai(resultSet.getString("TenLoai"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUltils.getClose(connection);
        }

        return loai;
    }
}
