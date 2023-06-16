package vendingmachine;

public class MoneyCount {

	private static int moneySum;
	private int moneyType;
	private int mTypeAmount;
	
	public MoneyCount() {}
	public MoneyCount(int moneyType, int mTypeAmount) {
		this.moneyType = moneyType;
		this.mTypeAmount = mTypeAmount;
	}
	
	public int getMoneyType() {
		return moneyType;
	}

	public void setMoneyType(int moneyType) {
		this.moneyType = moneyType;
	}

	public int getmTypeAmount() {
		return mTypeAmount;
	}

	public void setmTypeAmount(int mTypeAmount) {
		this.mTypeAmount = mTypeAmount;
	}

	public static int getMoneySum() {
		return moneySum;
	}
	public static void setMoneySum(int moneySum) {
		MoneyCount.moneySum = moneySum;
	}
}
