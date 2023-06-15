package vending;

public class VendingMea {
	public int getDrinkPrice() {
		return drinkPrice;
	}
	public void setDrinkPrice(int drinkPrice) {
		this.drinkPrice = drinkPrice;
	}
	public String getDrinkName() {
		return drinkName;
	}
	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}
	public int getDrinkCount() {
		return drinkCount;
	}
	public void setDrinkCount(int drinkCount) {
		this.drinkCount = drinkCount;
	}
	private String drinkName;
	private int drinkCount;
	private int drinkPrice;
	
	public VendingMea(String drinkName, int drinkCount, int drinkPrice) {
		super();
		this.drinkName = drinkName;
		this.drinkCount = drinkCount;
		this.drinkPrice = drinkPrice;
	}
	public static VendingMea get(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
