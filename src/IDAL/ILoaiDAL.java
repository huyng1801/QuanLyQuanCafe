package IDAL;
import DTO.LoaiDTO;
import java.util.List;

public interface ILoaiDAL {
    boolean themLoai(LoaiDTO loai);
    boolean suaLoai(LoaiDTO loai);
    boolean xoaLoai(int maLoai);
    List<LoaiDTO> layDanhSachLoai();
    LoaiDTO timLoaiTheoMa(int maLoai);
    LoaiDTO timLoaiTheoTen(String tenLoai);
}
