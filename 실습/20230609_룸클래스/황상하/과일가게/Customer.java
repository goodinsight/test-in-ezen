package kr.co.dong.shopping;

public class Customer {
	private String name; // ¿Ã∏ß
	private int money; // µ∑
	
	public Customer(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	@Override
	public String toString() {
		return "Customer [name=" + name + ", money=" + money + "]";
	}
	
}
