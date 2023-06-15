package kr.co.dong.vendingMachine;

public class Menu {
	private int price;
	private String name;
	private int amount;
	private int number;
	
	public Menu(String name, int price, int amount, int number) {
		super();
		this.name = name;
		this.price = price;
		this.amount = amount;
		this.number = number;
	}
	
	
	@Override
	public String toString() {
		return "[번호 : " + number + ", 이름 : " + name + ", 가격 : " + number + ", 재고 : " + amount + "]";
	}



	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
