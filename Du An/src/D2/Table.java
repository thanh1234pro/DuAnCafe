package D2;

public class Table {
	private int sttban;
	private String tenban;
	private String trangthai;
	private String ghichu;
	
	public Table() {
		
	}
	public int getSttban() {
		return sttban;
	}


	public void setSttban(int sttban) {
		this.sttban = sttban;
	}


	public String getTenban() {
		return tenban;
	}


	public void setTenban(String tenban) {
		this.tenban = tenban;
	}


	public String getTrangthai() {
		return trangthai;
	}


	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}


	public String getGhichu() {
		return ghichu;
	}


	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}


	public Table(int sttban, String tenban, String trangthai, String ghichu) {
		this.sttban = sttban;
		this.tenban = tenban;
		this.trangthai = trangthai;
		this.ghichu = ghichu;
	}

	public Table(String tenban, String trangthai, String ghichu) {
		this.tenban = tenban;
		this.trangthai = trangthai;
		this.ghichu = ghichu;
	}
}
