package DAL;
import IDAL.ITaiKhoanDAL;
import DTO.TaiKhoanDTO;
import Utils.JdbcUltils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaiKhoanDAL implements ITaiKhoanDAL {

    @Override
    public boolean themTaiKhoan(TaiKhoanDTO taiKhoan) {
        Connection connection = JdbcUltils.getConnect();
        if (connection == null) {
            return false;
        }

        String query = "INSERT INTO TaiKhoan (TenDangNhap, TenHienThi, MatKhau, Type) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, taiKhoan.getTenDangNhap());
            preparedStatement.setString(2, taiKhoan.getTenHienThi());
            preparedStatement.setString(3, taiKhoan.getMatKhau());
            preparedStatement.setInt(4, taiKhoan.getType());

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
    public boolean suaTaiKhoan(TaiKhoanDTO taiKhoan) {
        Connection connection = JdbcUltils.getConnect();
        if (connection == null) {
            return false;
        }

        String query = "UPDATE TaiKhoan SET TenHienThi = ?, MatKhau = ?, Type = ? WHERE TenDangNhap = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, taiKhoan.getTenHienThi());
            preparedStatement.setString(2, taiKhoan.getMatKhau());
            preparedStatement.setInt(3, taiKhoan.getType());
            preparedStatement.setString(4, taiKhoan.getTenDangNhap());

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
    public boolean xoaTaiKhoan(String tenDangNhap) {
        Connection connection = JdbcUltils.getConnect();
        if (connection == null) {
            return false;
        }

        String query = "DELETE FROM TaiKhoan WHERE TenDangNhap = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, tenDangNhap);

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
    public List<TaiKhoanDTO> layDanhSachTaiKhoan() {
        List<TaiKhoanDTO> danhSachTaiKhoan = new ArrayList<>();
        Connection connection = JdbcUltils.getConnect();
        if (connection == null) {
            return danhSachTaiKhoan;
        }

        String query = "SELECT * FROM TaiKhoan";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                TaiKhoanDTO taiKhoan = new TaiKhoanDTO();
                taiKhoan.setTenDangNhap(resultSet.getString("TenDangNhap"));
                taiKhoan.setTenHienThi(resultSet.getString("TenHienThi"));
                taiKhoan.setMatKhau(resultSet.getString("MatKhau"));
                taiKhoan.setType(resultSet.getInt("Type"));
                danhSachTaiKhoan.add(taiKhoan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUltils.getClose(connection);
        }

        return danhSachTaiKhoan;
    }

    @Override
    public TaiKhoanDTO timTaiKhoanTheoTenDangNhap(String tenDangNhap) {
        TaiKhoanDTO taiKhoan = null;
        Connection connection = JdbcUltils.getConnect();
        if (connection == null) {
            return taiKhoan;
        }

        String query = "SELECT * FROM TaiKhoan WHERE TenDangNhap = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, tenDangNhap);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    taiKhoan = new TaiKhoanDTO();
                    taiKhoan.setTenDangNhap(resultSet.getString("TenDangNhap"));
                    taiKhoan.setTenHienThi(resultSet.getString("TenHienThi"));
                    taiKhoan.setMatKhau(resultSet.getString("MatKhau"));
                    taiKhoan.setType(resultSet.getInt("Type"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUltils.getClose(connection);
        }

        return taiKhoan;
    }

    @Override
    public TaiKhoanDTO dangNhap(String tenDangNhap, String matKhau) {
        TaiKhoanDTO taiKhoan = null;
        Connection connection = JdbcUltils.getConnect();
        if (connection == null) {
            return taiKhoan;
        }

        String query = "SELECT * FROM TaiKhoan WHERE TenDangNhap = ? AND MatKhau = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, tenDangNhap);
            preparedStatement.setString(2, matKhau);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    taiKhoan = new TaiKhoanDTO();
                    taiKhoan.setTenDangNhap(resultSet.getString("TenDangNhap"));
                    taiKhoan.setTenHienThi(resultSet.getString("TenHienThi"));
                    taiKhoan.setMatKhau(resultSet.getString("MatKhau"));
                    taiKhoan.setType(resultSet.getInt("Type"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUltils.getClose(connection);
        }

        return taiKhoan;
    }
}
