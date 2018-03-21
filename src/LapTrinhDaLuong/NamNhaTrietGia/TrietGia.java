package LapTrinhDaLuong.NamNhaTrietGia;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class TrietGia extends PhongAn implements Runnable {
	private String tenTrietGia;
	private TrangThai trangThai;
	private int idTrietGia;

	private Dua duaPhai;
	private Dua duaTrai;
	Random rd = new Random();

	public TrietGia(int ID, String ten, TrangThai trangThai) {
		setId(ID);
		setTen(ten);
		setTrangThai(trangThai);
		setDuaXungQuanh();
	}

	public String getTenTrietGia() {
		return tenTrietGia;
	}

	public void setTen(String tenTrietGia) {
		this.tenTrietGia = tenTrietGia;
	}

	public TrangThai getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(TrangThai trangThai) {
		this.trangThai = trangThai;
		if (getTrangThai() == TrangThai.DANGAN)
			System.out.println(this.tenTrietGia + this.trangThai.toString());
		else
			System.out.println(this.tenTrietGia + this.trangThai.toString());
	}

	public int getId() {
		return idTrietGia;
	}

	public void setId(int idTrietGia) {
		this.idTrietGia = idTrietGia;
	}

	private void setDuaXungQuanh() {
		duaPhai = Dua.get((idTrietGia % 5));
		duaTrai = Dua.get((idTrietGia - 1));

	}

	public void run() {
		while (true) {
			trangThaiSuyNghi();
			if (layDuaLen()) {
				an();
				datDuaXuong();
			}
		}
	}

	private synchronized boolean layDuaLen() {
		setTrangThai(TrangThai.DOIBUNG);

		while (getTrangThai() == TrangThai.DOIBUNG) {
			if (getTrangThai() == TrangThai.DOIBUNG && duaPhai.isDuaCoSan() && duaTrai.isDuaCoSan()) {

				duaPhai.setDuaCoSan(false);
				duaTrai.setDuaCoSan(false);

				System.out.println(tenTrietGia + "cầm đũa trái " + duaTrai.getIdDua() + " và đũa phải "
						+ duaPhai.getIdDua() + " lên");
				try {
					phucVu.acquire();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return true;
			}
		}

		return false;
	}

	private synchronized void datDuaXuong() {
		duaPhai.setDuaCoSan(true);
		duaTrai.setDuaCoSan(true);
		phucVu.release();
		System.out.println(
				tenTrietGia + "đặt đũa trái " + duaTrai.getIdDua() + " và đũa phải " + duaPhai.getIdDua() + " xuống");
	}

	private synchronized void trangThaiSuyNghi() {
		setTrangThai(TrangThai.DANGSUYNGHI);

		cho();
	}

	private synchronized void an() {
		setTrangThai(TrangThai.DANGAN);
		cho();
	}

	private void cho() {
		try {
			this.wait((rd.nextInt(70)) * 100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
