package kr.co.dong.vendingMachine;

public interface Customerable {
//	public static final String name = "";
//	public static final String membership = "";
//	public static final int money = 0;
//	public static final int bonusPoint = 0;

	
//	public abstract void buy();	// ��ǰ�� ��� -> ���ǿ��� ������ �̴´�
//	public abstract void refund();	// ��ǰ�� ȯ���Ѵ�
	void refund(Product p);	// ��ǰ�� ȯ���Ѵ�
	void buy(Product p);
	
}
