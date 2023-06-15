package kr.co.dong.vendingMachine;

import java.util.ArrayList;
import java.util.List;

public class Customer implements Customerable {
	private String name = "";
	private String membership = "";
	private int money = 0;
	private int bonusPoint = 0;
	private List<String> listOfPurchase = new ArrayList<String>();
	private List<String> listOfRefund = new ArrayList<String>();;
	
	public Customer() {
		
	}
	public Customer(int money) {
		this.money = money;	
	}
	public Customer(int money, List<String> listOfPurchase, List<String> listOfRefund) {
		this.money = money;
		this.listOfPurchase = listOfPurchase;
		this.listOfRefund = listOfRefund;
	}
	public void showMoney() {
		System.out.println("                                              현재 잔액 : " + this.money + "원");
	}
	
	@Override
	public void buy(Product p) {
		// 제품을 구매한다.
		this.money -= p.getPrice();
		this.listOfPurchase.add(p.getName());
	}
	@Override
	public void refund(Product p) {
		// 제품을 환불한다.
		this.money += p.getPrice();
		this.listOfRefund.add(p.getName());
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMembership() {
		return membership;
	}
	public void setMembership(String membership) {
		this.membership = membership;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getBonusPoint() {
		return bonusPoint;
	}
	public void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}

}
