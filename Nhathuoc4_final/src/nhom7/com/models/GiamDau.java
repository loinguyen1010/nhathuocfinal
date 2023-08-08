package nhom7.com.models;

public class GiamDau extends Thuoc{
	public GiamDau(String ten, double gia, int soLuong) {
        super(ten, gia, soLuong);
    }

    @Override
    public void XuatThongTin() {
        System.out.println("Thuốc giảm đau: " + ten + ", Giá: " + gia + "đ, Số lượng: " + soLuong);
    }
}
