package kr.co.dong.vendingMachine;

public abstract class MoneyChanger {
	public static String[] moneyName = {"5����","1����","5õ��","1õ��","5���","1���"};
	public static int[] moneyValue = {50000, 10000, 5000, 1000, 500, 100};
	
	public abstract int changeMoney(int moneyValue); // ���� ������ ���� ȭ��� �ٲ��ش�?
	
	
	
}
