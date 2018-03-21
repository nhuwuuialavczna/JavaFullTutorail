package LapTrinhDaLuong.NamNhaTrietGia;

public class Dua {
	private int idDua;
	private boolean coSan;

	public Dua(int ID, boolean coSan) {
		setIdDua(ID);
		setDuaCoSan(coSan);
	}

	public synchronized int getIdDua() {
		return idDua;
	}

	public synchronized void setIdDua(int idDua) {
		this.idDua = idDua;
	}

	public synchronized boolean isDuaCoSan() {
		return coSan;
	}

	public synchronized void setDuaCoSan(boolean coSan) {
		this.coSan = coSan;
	}

}
