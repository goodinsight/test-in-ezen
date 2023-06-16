package kr.co.dong.machine;

public class Machine {
	
	private String drink;
	private int price;
	private int count;
	
	public Machine() {
		// TODO Auto-generated constructor stub
	}
	
	public Machine(String drink, int price, int count) {
		super();
		this.drink = drink;
		this.price = price;
		this.count = count;
	}
	
	public String getDrink() {
		return drink;
	}

	public void setDrink(String drink) {
		this.drink = drink;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "[음료명 : " + drink + ", 가격 : " + price + ", 개수 : " + count + "]";
	}
	
	
	
	
	
}
