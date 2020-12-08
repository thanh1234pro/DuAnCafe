package D6;

public class Table5 {
	private int stthd;
	private String tenban;
	private int tongtien;
	private String  ngaymua;
	
	public Table5() {
		
	}

	public int getStthd() {
		return stthd;
	}

	public void setStthd(int stthd) {
		this.stthd = stthd;
	}

	public String getTenban() {
		return tenban;
	}

	public void setTenban(String tenban) {
		this.tenban = tenban;
	}

	public int getTongtien() {
		return tongtien;
	}

	public void setTongtien(int tongtien) {
		this.tongtien = tongtien;
	}

	public String getNgaymua() {
		return ngaymua;
	}

	public void setNgaymua(String ngaymua) {
		this.ngaymua = ngaymua;
	}

	public Table5(int stthd, String tenban, int tongtien, String ngaymua) {
		super();
		this.stthd = stthd;
		this.tenban = tenban;
		this.tongtien = tongtien;
		this.ngaymua = ngaymua;
	}
	public Table5( String tenban, int tongtien, String ngaymua) {
		
		this.tenban = tenban;
		this.tongtien = tongtien;
		this.ngaymua = ngaymua;
	}
}
