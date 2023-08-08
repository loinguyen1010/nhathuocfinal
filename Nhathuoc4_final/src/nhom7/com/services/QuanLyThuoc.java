package nhom7.com.services;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import nhom7.com.models.*;
import java.io.*;
public class QuanLyThuoc {
	private List<Thuoc> danhSachThuoc;

    public QuanLyThuoc() {
        danhSachThuoc = new ArrayList<>();
    }

    public void themThuoc(Thuoc thuoc) {
        danhSachThuoc.add(thuoc);
    }

    public void XoaThuoc(String tenthuoc) {
    	danhSachThuoc.removeIf(thuoc -> thuoc.getTen().equalsIgnoreCase(tenthuoc));
		System.out.println("Thuốc Đã Xóa Thành Công!");
		
	}
    public void CapNhatGia(String TenThuoc, double newGia) {
		for (Thuoc thuoc : danhSachThuoc) {
            if (thuoc.getTen().equalsIgnoreCase(TenThuoc)) {
                thuoc.setGia(newGia);
                return;
            }
		}
		 System.out.println("không Tìm Thấy Thuốc.");
		
	}
	public void CapNhatSL(String TenThuoc, int newSL) {
		for (Thuoc thuoc : danhSachThuoc) {
            if (thuoc.getTen().equalsIgnoreCase(TenThuoc)) {
                thuoc.setSoLuong(newSL);
                return;
            }
        }
        System.out.println("không Tìm Thấy Thuốc.");
		
	}
	 public Thuoc timKiemThuocTheoTen(String ten) {
	        for (Thuoc thuoc : danhSachThuoc) {
	            if (thuoc.getTen().equalsIgnoreCase(ten)) {
	                return thuoc;
	            }
	        }
	        return null;
	    }
    public void hienThiDanhSachThuoc() {
        for (Thuoc thuoc : danhSachThuoc) {
            thuoc.XuatThongTin();
        }
    }
    public double TongTien() {
        double tongTien = 0;
        for (Thuoc thuoc : danhSachThuoc) {
            tongTien += thuoc.TongTien();
        }
        return tongTien;
    }

    public double VAT() {
        double tongVAT = 0;
        for (Thuoc thuoc : danhSachThuoc) {
            tongVAT += thuoc.VAT();
        }
        return tongVAT;
    }


    public double GiaNiemYet() {
        double tongGiaNiemYet = 0;
        for (Thuoc thuoc : danhSachThuoc) {
            tongGiaNiemYet += thuoc.getGia();
        }
        return tongGiaNiemYet;
    }
    public void ghiFile(String tenFile) {
        try {
            FileWriter writer = new FileWriter(tenFile);
            for (Thuoc thuoc : danhSachThuoc) {
                writer.write(thuoc.getTen() + "," + thuoc.getGia() + "," + thuoc.getSoLuong() + "\n");
            }
            writer.close();
            System.out.println("Ghi file thành công.");
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }
    public void docFile(String tenFile) {
        danhSachThuoc.clear();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(tenFile));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String ten = parts[0];
                    double gia = Double.parseDouble(parts[1]);
                    int soLuong = Integer.parseInt(parts[2]);
                    // Tạo đối tượng thuốc và thêm vào danh sách
                    Thuoc thuoc = new Thuoc(ten, gia, soLuong) {
                        @Override
                        public void XuatThongTin() {
                            System.out.println("Tên thuốc: " + getTen() + ", Giá: " + getGia() + "đ, Số lượng: " + getSoLuong());
                        }
                    };
                    danhSachThuoc.add(thuoc);
                }
            }
            reader.close();
            System.out.println("Đọc file thành công.");
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }
}
