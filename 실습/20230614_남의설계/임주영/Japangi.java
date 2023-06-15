package VendingMachine;

public class Japangi {
//----------------------------------------------
	private String jName; // 상품 이름
	private int jPrice; // 가격 필수 3가지(손님)
	private int jCount; // 재고

	private int jMoney; // 돈


	public Japangi() {
		super();
	}

	public Japangi(String jName, int jPrice, int jCount) {
		super();
		this.jName = jName;
		this.jPrice = jPrice;
		this.jCount = jCount;
	}

	public String getjName() {
		return jName;
	}

	public void setjName(String jName) {
		this.jName = jName;
	}

	public int getjPrice() {
		return jPrice;
	}

	public void setjPrice(int jPrice) {
		this.jPrice = jPrice;
	}

	public int getjCount() {
		return jCount;
	}

	public void setjCount(int jCount) {
		this.jCount = jCount;
	}

	public int getjMoney() {
		return jMoney;
	}

	public void setjMoney(int jMoney) {
		this.jMoney = jMoney;
	}

	@Override
	public String toString() {
		return " 자판기 [메뉴 : " + jName + ", 가격 : " + jPrice + ", 재고 : " + jCount + "]";
	}

}
