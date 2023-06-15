package kr.co.dong.vendingMachine;

public interface Customerable {
//	public static final String name = "";
//	public static final String membership = "";
//	public static final int money = 0;
//	public static final int bonusPoint = 0;

	
//	public abstract void buy();	// 제품을 산다 -> 자판에서 물건을 뽑는다
//	public abstract void refund();	// 제품을 환불한다
	void refund(Product p);	// 제품을 환불한다
	void buy(Product p);
	
}
