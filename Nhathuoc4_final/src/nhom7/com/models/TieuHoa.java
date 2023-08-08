package nhom7.com.models;

public class TieuHoa extends Thuoc{
	public TieuHoa(String ten, double gia, int soLuong) {
        super(ten, gia, soLuong);
    }

    @Override
    public void XuatThongTin() {
        System.out.println("Thuốc tiêu hóa: " + ten + ", Giá: " + gia + "đ, Số lượng: " + soLuong);
    }

}
