// ���� ���Ǳ� �����ϱ�
// 1. ���� ����, ����, ���
// 2. �����ϱ�, �Ǹ��ϱ�, �ݾ������ϱ�, �ܵ��ֱ�, ���&����&���� �����ϱ�
package jpg;

public class Drink {
	
	private String name; //���� �̸�
	private int price; // ���� ����
	private int stock; // ���� ���
	
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
		return "[���� : " + name + "], [���� : " + price + "], [��� : " + stock + "]";
	}
	
	
}
