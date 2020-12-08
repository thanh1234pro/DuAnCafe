package D4;

public class Table3 {
	private int sttcthd;
	private String tensanpham;
	private int giaban;
	private int  soluong;
	private int  thanhtien;
	
	public Table3() {	
	}

	public int getSttcthd() {
		return sttcthd;
	}

	public void setSttcthd(int sttcthd) {
		this.sttcthd = sttcthd;
	}

	public String getTensanpham() {
		return tensanpham;
	}

	public void setTensanpham(String tensanpham) {
		this.tensanpham = tensanpham;
	}

	public int getGiaban() {
		return giaban;
	}

	public void setGiaban(int giaban) {
		this.giaban = giaban;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public int getThanhtien() {
		return thanhtien;
	}

	public void setThanhtien(int thanhtien) {
		this.thanhtien = thanhtien;
	}

	public Table3(int sttcthd, String tensanpham, int giaban, int soluong, int thanhtien) {
		this.sttcthd = sttcthd;
		this.tensanpham = tensanpham;
		this.giaban = giaban;
		this.soluong = soluong;
		this.thanhtien = thanhtien;
	}
	public Table3(String tensanpham, int giaban, int soluong, int thanhtien) {
		this.tensanpham = tensanpham;
		this.giaban = giaban;
		this.soluong = soluong;
		this.thanhtien = thanhtien;
	}

}
