package kr.co.dong.shopping;

public class SaleProduct {
	private String sname;
	private int sCount;
	private int sPrice;
	
	public SaleProduct(String sname, int sCount, int sPrice) {
		super();
		this.sname = sname;
		this.sCount = sCount;
		this.sPrice = sPrice;
	}
	
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getsCount() {
		return sCount;
	}
	public void setsCount(int sCount) {
		this.sCount = sCount;
	}
	public int getsPrice() {
		return sPrice;
	}
	public void setsPrice(int sPrice) {
		this.sPrice = sPrice;
	}
	@Override
	public String toString() {
		return "SaleProduct [sname=" + sname + ", sCount=" + sCount + ", sPrice=" + sPrice + "]";
	}
	
	
}
