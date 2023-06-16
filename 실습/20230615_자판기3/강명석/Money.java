package kr.co.dong.japangi;

public class Money {
	private int m100 = 0;      // ÀÜµ· ¼ö
	private int m500 = 0;;      // ÀÜµ· ¼ö
	private int m1000 = 0;     // ÀÜµ· ¼ö
	private int m5000 = 0;     // ÀÜµ· ¼ö
	private int m10000 = 0;    // ÀÜµ· ¼ö
	private int m50000 = 0;    // ÀÜµ· ¼ö 
	private int inMoney = 0;   // ÀÔ±Ý¾×
	private int saleMoney = 0; // ÆÇ¸Å¾×
	private int totMoney = 0;  // ÀüÃ¼±Ý¾×
	/**
	 * @param m100
	 * @param m500
	 * @param m1000
	 * @param m5000
	 * @param m10000
	 * @param m50000
	 * @param inMoney
	 * @param saleMoney
	 * @param totMoney
	 */
	/**
	 * @param m100
	 * @param m500
	 * @param m1000
	 * @param m5000
	 * @param m10000
	 * @param m50000
	 * @param inMoney
	 * @param saleMoney
	 * @param totMoney
	 */
	public Money(int m100, int m500, int m1000, int m5000, int m10000, int m50000, int inMoney, int saleMoney,
			int totMoney) {
		super();
		this.m100 = m100;
		this.m500 = m500;
		this.m1000 = m1000;
		this.m5000 = m5000;
		this.m10000 = m10000;
		this.m50000 = m50000;
		this.inMoney = inMoney;
		this.saleMoney = saleMoney;
		this.totMoney = totMoney;
	}
	public int getM100() {
		return m100;
	}
	public void setM100(int m100) {
		this.m100 = m100;
	}
	public int getM500() {
		return m500;
	}
	public void setM500(int m500) {
		this.m500 = m500;
	}
	public int getM1000() {
		return m1000;
	}
	public void setM1000(int m1000) {
		this.m1000 = m1000;
	}
	public int getM5000() {
		return m5000;
	}
	public void setM5000(int m5000) {
		this.m5000 = m5000;
	}
	public int getM10000() {
		return m10000;
	}
	public void setM10000(int m10000) {
		this.m10000 = m10000;
	}
	public int getM50000() {
		return m50000;
	}
	public void setM50000(int m50000) {
		this.m50000 = m50000;
	}
	public int getInMoney() {
		return inMoney;
	}
	public void setInMoney(int inMoney) {
		this.inMoney = inMoney;
	}
	public int getSaleMoney() {
		return saleMoney;
	}
	public void setSaleMoney(int saleMoney) {
		this.saleMoney = saleMoney;
	}
	public int getTotMoney() {
		return totMoney;
	}
	public void setTotMoney(int totMoney) {
		this.totMoney = totMoney;
	}
	@Override
	public String toString() {
		return "Money [m100=" + m100 + ", m500=" + m500 + ", m1000=" + m1000 + ", m5000=" + m5000 + ", m10000=" + m10000
				+ ", m50000=" + m50000 + ", inMoney=" + inMoney + ", saleMoney=" + saleMoney + ", totMoney=" + totMoney
				+ "]";
	}


	
	
	
}
