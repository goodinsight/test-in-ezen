package kr.co.dong.shopping;

public class Product {
	private String name;
	private int price;
	private int count;

	public  Product() {
		
	}

	public Product(String name, int price, int count) {
		super();
		this.name = name;
		this.price = price;
		this.count = count;
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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "["+name+" / " + price+"�� / ���� : "+count+"]";
	}

}
