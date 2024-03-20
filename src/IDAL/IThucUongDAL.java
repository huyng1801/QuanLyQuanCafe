package IDAL;
import DTO.ThucUongDTO;
import java.util.List;

public interface IThucUongDAL {
    boolean themThucUong(ThucUongDTO thucUong);
    boolean suaThucUong(ThucUongDTO thucUong);
    boolean xoaThucUong(int maThucUong);
    List<ThucUongDTO> layDanhSachThucUong();
    ThucUongDTO timThucUongTheoMa(int maThucUong);
    ThucUongDTO timThucUongTheoTen(String tenThucUong);
}
