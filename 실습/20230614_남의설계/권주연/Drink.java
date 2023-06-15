// 음료 자판기 구현하기
// 1. 음료 종류, 가격, 재고
// 2. 구매하기, 판매하기, 금액지불하기, 잔돈주기, 재고&가격&종류 수정하기
package jpg;

public class Drink {
	
	private String name; //음료 이름
	private int price; // 음료 가격
	private int stock; // 음료 재고
	
	private int moniy; 
	
	public Drink() {
		
	}

	public Drink(String name, int price, int stock) {
		super();
		this.name = name;
		this.price = price;
		this.stock = stock;
	}


	public int getMoniy() {
		return moniy;
	}
	
	public void setMoniy(int moniy) {
		this.moniy = moniy;
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

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "[종류 : " + name + "], [가격 : " + price + "], [재고 : " + stock + "]";
	}
	
	
}
