package vendingMachine;

public class vendingMachine {
	private String drinkName;
	private int drinkPrice;
	private int drinkCount;
	private int sellCount;
	/**
	 * @param drinkName
	 * @param drinkPrice
	 * @param drinkCount
	 */
	public vendingMachine(String drinkName, int drinkPrice, int drinkCount, int sellCount) {
		super();
		this.drinkName = drinkName;
		this.drinkPrice = drinkPrice;
		this.drinkCount = drinkCount;
		this.sellCount = sellCount;
	}
	
	public String getDrinkName() {
		return drinkName;
	}

	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}

	public int getDrinkPrice() {
		return drinkPrice;
	}

	public void setDrinkPrice(int drinkPrice) {
		this.drinkPrice = drinkPrice;
	}

	public int getDrinkCount() {
		return drinkCount;
	}

	public void setDrinkCount(int drinkCount) {
		this.drinkCount = drinkCount;
	}

	public int getSellCount() {
		return sellCount;
	}

	public void setSellCount(int sellCount) {
		this.sellCount = sellCount;
	}

	@Override
	public String toString() {
		return "[음료이름 = " + drinkName + ", 음료가격 = " + drinkPrice + ", 음료재고 = " + drinkCount + "]";
	}

}
