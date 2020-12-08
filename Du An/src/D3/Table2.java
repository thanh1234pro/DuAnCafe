package D3;

public class Table2 {
	private int sttsp;
	private String tensanpham;
	private String giaban;
	private String ngaykm;
	private String ngayhetkm;
	
	public Table2() {	
	}

	public int getSttsp() {
		return sttsp;
	}

	public void setStt(int sttsp) {
		this.sttsp = sttsp;
	}

	public String getTensanpham() {
		return tensanpham;
	}

	public void setTensanpham(String tensanpham) {
		this.tensanpham = tensanpham;
	}

	public String getGiaban() {
		return giaban;
	}

	public void setGiaban(String giaban) {
		this.giaban = giaban;
	}

	public String getNgaykm() {
		return ngaykm;
	}

	public void setNgaykm(String ngaykm) {
		this.ngaykm = ngaykm;
	}

	public String getNgayhetkm() {
		return ngayhetkm;
	}

	public void setNgayhetkm(String ngayhetkm) {
		this.ngayhetkm = ngayhetkm;
	}

	public Table2(int sttsp, String tensanpham, String giaban, String ngaykm, String ngayhetkm) {
		this.sttsp = sttsp;
		this.tensanpham = tensanpham;
		this.giaban = giaban;
		this.ngaykm = ngaykm;
		this.ngayhetkm = ngayhetkm;
	}
	public Table2( String tensanpham, String giaban, String ngaykm, String ngayhetkm) {
	
		this.tensanpham = tensanpham;
		this.giaban = giaban;
		this.ngaykm = ngaykm;
		this.ngayhetkm = ngayhetkm;
	}

}
