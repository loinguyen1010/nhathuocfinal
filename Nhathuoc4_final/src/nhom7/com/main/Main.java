package nhom7.com.main;
import java.util.Scanner;
import java.util.Date;
import nhom7.com.models.*;
import nhom7.com.services.*;
public class Main {

	public static void main(String[] args) throws InterruptedException {
		 QuanLyThuoc quanLyThuoc = new QuanLyThuoc();
		 String FILE_PATH = "D:/nhom7.txt";
	        Scanner scanner = new Scanner(System.in);

	        while (true) {

	                 
	             
	             
	            System.out.println("*********************************************");
	            System.out.println("*            MENU CHƯƠNG TRÌNH              *");
	            System.out.println("*********************************************");
	            System.out.println("* 1.            Thêm thuốc                  *");
	            System.out.println("* 2.            Xóa thuốc                   *");
	            System.out.println("* 3.            Hiển thị DS thuốc           *");
	            System.out.println("* 4.            Tính tổng tiền              *");
	            System.out.println("* 5.            Cập nhật giá thuốc          *");
	            System.out.println("* 6.            Cập nhật số lượng           *");
	            System.out.println("* 7.            Tìm kiếm thuốc              *");
	            System.out.println("* 8.            Đọc file                    *");
	            System.out.println("* 9.            Ghi file                    *");
	            System.out.println("* 0.            Thoát                       *");
	            System.out.println("*********************************************");
	            System.out.print("Nhập Lựa Chọn Của Bạn: ");
	            int choice = scanner.nextInt();
	           
	            switch (choice) {
	                case 1:
	                    System.out.print("Nhập loại thuốc (1. Kháng sinh, 2. Tiêu hóa, 3. Giảm đau): ");
	                    int loai = scanner.nextInt();
	                    scanner.nextLine(); 

	                    System.out.print("Nhập tên thuốc: ");
	                    String tenThuoc = scanner.nextLine();

	                    System.out.print("Nhập giá thuốc: ");
	                    double giaThuoc = scanner.nextDouble();

	                    System.out.print("Nhập số lượng thuốc: ");
	                    int soLuongThuoc = scanner.nextInt();

	                    Thuoc thuoc;

	                    switch (loai) {
	                        case 1:
	                            thuoc = new KhangSinh(tenThuoc, giaThuoc, soLuongThuoc);
	                            break;
	                        case 2:
	                            thuoc = new TieuHoa(tenThuoc, giaThuoc, soLuongThuoc);
	                            break;
	                        case 3:
	                            thuoc = new GiamDau(tenThuoc, giaThuoc, soLuongThuoc);
	                            break;
	                        default:
	                            System.out.println("Loại thuốc không hợp lệ");
	                            continue;
	                    }

	                    quanLyThuoc.themThuoc(thuoc);
	                    System.out.println("Thêm thuốc thành công");
	                    break;

	                case 2:
	                	System.out.print("Nhập Tên Thuốc Cần Xóa: ");
                        String tenthuocdexoa = scanner.nextLine();
                        quanLyThuoc.XoaThuoc(tenthuocdexoa);
	                    break;

	                case 3:
	                    System.out.println("Danh sách thuốc:");
	                    quanLyThuoc.hienThiDanhSachThuoc();
	                    break;

	                case 4:
	                	tinhToanTongTien(quanLyThuoc);
	                    break;
	                    
	                case 5:
	                    System.out.print("Nhập tên thuốc cần cập nhật giá: ");
	                    String tenCanCapNhat = scanner.nextLine();
	                    System.out.print("Nhập giá mới: ");
	                    double giaMoi = scanner.nextDouble();
	                    quanLyThuoc.CapNhatGia(tenCanCapNhat, giaMoi);;;
	                    System.out.println("Cập nhật giá thuốc thành công");
	                    break;

	                case 6:
	                    System.out.print("Nhập tên thuốc cần cập nhật số lượng: ");
	                    String tenCanCapNhatSoLuong = scanner.nextLine();
	                    System.out.print("Nhập số lượng mới: ");
	                    int soLuongMoi = scanner.nextInt();
	                    quanLyThuoc.CapNhatSL(tenCanCapNhatSoLuong, soLuongMoi);;
	                    System.out.println("Cập nhật số lượng thuốc thành công");
	                    break;

	                case 7:
	                    System.out.print("Nhập tên thuốc cần tìm kiếm: ");
	                    String tenCanTim = scanner.nextLine();
	                    Thuoc thuocTim = quanLyThuoc.timKiemThuocTheoTen(tenCanTim);
	                    if (thuocTim != null) {
	                        System.out.println("Tìm thấy thuốc:");
	                        thuocTim.XuatThongTin();
	                    } else {
	                        System.out.println("Không tìm thấy thuốc với tên '" + tenCanTim + "'");
	                    }
	                    break;

	                case 8:
	                    quanLyThuoc.docFile("D:/nhom7");
	                    break;

	                case 9:
	                	quanLyThuoc.ghiFile("D:/nhom7");
	                    break;

	                case 0:
	                    System.out.println("Đã thoát chương trình.");
	                    return;

	                default:
	                    System.out.println("Chức năng không hợp lệ");
	                    break;
	            }
	        }
	        }
	    
	public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        return;
        
    }
	 private static void tinhToanTongTien(QuanLyThuoc QLThuoc) {
	        System.out.println("Tổng Tiền Của Các Loại Thuốc: " + QLThuoc.TongTien() + " VND");
	        System.out.println("Tổng Thuế VAT Của Các Loại Thuốc: " + QLThuoc.VAT() + " VND");
	        System.out.println("Tổng Giá Niêm Yết Của Các Loại Thuốc: " + QLThuoc.GiaNiemYet() + " VND");
	    }
	}

