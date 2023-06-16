package vendingmachine;

public class Product {
	
	private String name;
	private int price;
	private int amount;
	
	public Product() {}
	public Product(String name, int price, int amount) {
		this.name = name;
		this.price = price;
		this.amount = amount;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "["+name + " 가격:" + price + "원 남은수량:" + amount + "]";
	}

}
