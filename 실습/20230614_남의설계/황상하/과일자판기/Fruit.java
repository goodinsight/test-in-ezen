package vendingMahchine;

public class Fruit {
	private String fName;
	private int fPrice;
	private int fCount;
	
	
	public Fruit(String fName, int fPrice, int fCount) {
		super();
		this.fName = fName;
		this.fPrice = fPrice;
		this.fCount = fCount;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public int getfPrice() {
		return fPrice;
	}
	public void setfPrice(int fPrice) {
		this.fPrice = fPrice;
	}
	public int getfCount() {
		return fCount;
	}
	public void setfCount(int fCount) {
		this.fCount = fCount;
	}
	@Override
	public String toString() {
		return "[" + fName + " / " + fPrice + "¿ø / " + fCount + "°³]";
	}
	
}
