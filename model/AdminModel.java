  package model;

public class AdminModel {
	private int stt;
	private int sl_tonkho;
	private String mavt;
	private Float gianhap;
	private String donvi;
	private Float giaban;
	public AdminModel() {
		
		// TODO Auto-generated constructor stub
	}
	public AdminModel(int stt, int sl_tonkho, String mavt, Float gianhap, String donvi, Float giaban) {
		
		this.stt = stt;
		this.sl_tonkho = sl_tonkho;
		this.mavt = mavt;
		this.gianhap = gianhap;
		this.donvi = donvi;
		this.giaban = giaban;
	}
	public int getStt() {
		return stt;
	}
	public void setStt(int stt) {
		this.stt = stt;
	}
	public int getSl_tonkho() {
		return sl_tonkho;
	}
	public void setSl_tonkho(int sl_tonkho) {
		this.sl_tonkho = sl_tonkho;
	}
	public String getMavt() {
		return mavt;
	}
	public void setMavt(String mavt) {
		this.mavt = mavt;
	}
	public Float getGianhap() {
		return gianhap;
	}
	public void setGianhap(Float gianhap) {
		this.gianhap = gianhap;
	}
	public String getDonvi() {
		return donvi;
	}
	public void setDonvi(String donvi) {
		this.donvi = donvi;
	}
	public Float getGiaban() {
		return giaban;
	}
	public void setGiaban(Float giaban) {
		this.giaban = giaban;
	}

}
	
	