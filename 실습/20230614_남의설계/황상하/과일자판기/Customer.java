package vendingMahchine;

public class Customer {

	private String cName;
	private int cMoney;
//	private int cPoint;
	
	public Customer() {
		super();
	}
	
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public int getcMoney() {
		return cMoney;
	}
	public void setcMoney(int cMoney) {
		this.cMoney = cMoney;
	}
//	public int getcPoint() {
//		return cPoint;
//	}
//	public void setcPoint(int cPoint) {
//		this.cPoint = cPoint;
//	}

	@Override
	public String toString() {
		return "Customer [cName=" + cName + ", cMoney=" + cMoney + "]";
	}
	
}
