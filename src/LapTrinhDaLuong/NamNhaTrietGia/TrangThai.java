package LapTrinhDaLuong.NamNhaTrietGia;

public enum TrangThai {
	DOIBUNG("đói bụng"), DANGAN("ăn"), DANGSUYNGHI("suy nghĩ");

	private final String trangThai;

	TrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	@Override
	public String toString() {
		return trangThai;
	}
}
