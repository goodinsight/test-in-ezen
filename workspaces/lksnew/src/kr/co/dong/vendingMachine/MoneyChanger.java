package kr.co.dong.vendingMachine;

public abstract class MoneyChanger {
	public static String[] moneyName = {"5만원","1만원","5천원","1천원","5백원","1백원"};
	public static int[] moneyValue = {50000, 10000, 5000, 1000, 500, 100};
	
	public abstract int changeMoney(int moneyValue); // 돈이 들어오면 하위 화폐로 바꿔준다?
	
	
	
}
