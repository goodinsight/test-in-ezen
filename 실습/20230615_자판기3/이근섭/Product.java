package kr.co.dong.vendingMachine;

public class Product{
	public static int serialNumber = 0; // ������ �ν��Ͻ��� ���� �����ϱ� ���� ����
	int serialNo;	// �ν��Ͻ� ������ ��ȣ
	private String category = "";	// ��ǰ�� ���� ������ �־��ش�?
	private String name = "";	// ��ǰ�� �̸�
	private int price = 0;	// ��ǰ�� ����
	private String contents = "";	// ��ǰ�� ���� ����
	private int numberOfProduct = 0;	//��ǰ�� ����
	
	public Product(String name, int price) {
		//�α׿��� ���� ������
		this.name = name;
		this.price = price;
	}
	
	public Product(String category, String name, int price, String contents, int numberOfProduct) {
		// ��ǰ �߰��Ҷ� ���� ������
		serialNumber++;		
		serialNo = serialNumber;
		this.category = category;
		this.name = name;
		this.price = price;
		this.contents = contents;
		this.numberOfProduct = numberOfProduct;
	}
	
	public Product(int serialNo, String category, String name, int price, String contents, int numberOfProduct) {
		this.serialNo = serialNo;
		this.category = category;
		this.name = name;
		this.price = price;
		this.contents = contents;
		this.numberOfProduct = numberOfProduct;
	}
	
	public int getSerialNo() {
		return serialNo;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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
	
	public int getNumberOfProduct() {
		return numberOfProduct;
	}
	
	public void setNumberOfProduct(int numberOfProduct) {
		this.numberOfProduct = numberOfProduct;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	@Override
	public String toString() {
		return serialNo + ". [" + "�̸� : " + name + ", ����: " + price + ", ����: " + contents + ", ���: " + numberOfProduct +"]";
	}
	
	
}
