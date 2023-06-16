package kr.co.dong.japangi;

public class Product {
	private String pName = null;    // ��ǰ �̸�
	private String pPrice = null;   // ��ǰ ����
	private String gCount = null;   // ��� ����
	private String sCount = null;   // �Ǹ� ����
	/**
	 * @param pName
	 * @param pPrice
	 * @param gCount
	 * @param sCount
	 */
	public Product(String pName, String pPrice, String gCount, String sCount) {
		super();
		this.pName = pName;
		this.pPrice = pPrice;
		this.gCount = gCount;
		this.sCount = sCount;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpPrice() {
		return pPrice;
	}
	public void setpPrice(String pPrice) {
		this.pPrice = pPrice;
	}
	public String getgCount() {
		return gCount;
	}
	public void setgCount(String gCount) {
		this.gCount = gCount;
	}
	public String getsCount() {
		return sCount;
	}
	public void setsCount(String sCount) {
		this.sCount = sCount;
	}
	@Override
	public String toString() {
		return "Product [pName=" + pName + ", pPrice=" + pPrice + ", gCount=" + gCount + ", sCount=" + sCount + "]";
	}
	
	
	
}

