package nhom7.com.models;

public abstract class Thuoc {
	protected String ten;
    protected double gia;
    protected int soLuong;

    public Thuoc(String ten, double gia, int soLuong) {
        this.ten = ten;
        this.gia = gia;
        this.soLuong = soLuong;
    }

    public abstract void XuatThongTin();

    public String getTen() {
        return ten;
    }

    public double getGia() {
        return gia;
    }

    public int getSoLuong() {
        return soLuong;
    }
    public void setGia(double gia) {
        this.gia = gia;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    public double TongTien() {
        return gia * soLuong  ;
    }


    public double VAT() {
        // VAT là 10% (0.1)
        return TongTien() * 0.1;
    }


    public double GiaNiemYet() {
        return gia;
    }
}
