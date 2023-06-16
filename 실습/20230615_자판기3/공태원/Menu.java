package drink;

public class Menu {

	private int DNo;
	private String DName;
	private int DPrice;
	private int stock;
	
	private int money;
	
	@Override
	public String toString() {
		return "Menu [음료 번호 =" + DNo + ", 음료 이름=" + DName + ", 음료 가격=" + DPrice + ", 음료 재고=" + stock + "]";
	}

	public int getDNo() {
		return DNo;
	}

	public void setDNo(int dNo) {
		DNo = dNo;
	}

	public String getDName() {
		return DName;
	}

	public void setDName(String dName) {
		DName = dName;
	}

	public int getDPrice() {
		return DPrice;
	}

	public void setDPrice(int dPrice) {
		DPrice = dPrice;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public Menu() { //디폴트 생성자
		super();
	}

	public Menu(int dNo, String dName, int dPrice, int stock) { //매개변수있는 생성자가있으면 디폴트생성자가 자동으로 안만들어져요
		super();
		DNo = dNo;
		DName = dName;
		DPrice = dPrice;
		this.stock = stock;
	}
	
	
}
