package nhom7.com.models;

public class KhangSinh extends Thuoc{
	 public KhangSinh(String ten, double gia, int soLuong) {
	        super(ten, gia, soLuong);
	    }

	    @Override
	    public void XuatThongTin() {
	        System.out.println("Thuốc kháng sinh: " + ten + ", Giá: " + gia + "đ, Số lượng: " + soLuong);
	    }
	    

}
