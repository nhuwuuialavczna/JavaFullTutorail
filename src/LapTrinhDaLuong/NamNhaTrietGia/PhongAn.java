package LapTrinhDaLuong.NamNhaTrietGia;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class PhongAn {
	static List<TrietGia> TrietGia = new ArrayList<TrietGia>();
	static List<Dua> Dua = new ArrayList<Dua>();
	static List<Thread> TienTrinh = new ArrayList<Thread>();
	static String[] ten = { "Triet gia A ", "Triet gia B ", "Triet gia C ", "Triet gia D ", "Triet gia E " };

	Semaphore phucVu = new Semaphore(2, true);
	
	// Semaphore là một biến được bảo vệ (hay là một kiểu dữ liệu trừu tượng),
	// tạo thành một phương pháp để hạn chế truy nhập tới tài nguyên dùng chung
	// trong môi trường đa lập trình (multiprogramming)

	static final int SONHATRIETGIA = 5;
	static final int SOCHIECDUA = 5;

	public static void main(String[] args) {

		for (int i = 1; i <= SOCHIECDUA; i++) {
			Dua.add(new Dua(i, true));
		}

		for (int i = 0; i < SONHATRIETGIA; i++) {
			TrietGia.add(new TrietGia((i + 1), ten[i], TrangThai.DANGSUYNGHI));
			TienTrinh.add(new Thread(TrietGia.get(i)));
		}

		for (int i = 0; i < TienTrinh.size(); i++) {
			TienTrinh.get(i).start();
		}
	}
}
