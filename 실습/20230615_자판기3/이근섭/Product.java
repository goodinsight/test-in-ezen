package kr.co.dong.vendingMachine;

public class Product{
	public static int serialNumber = 0; // 생성된 인스턴스의 수를 저장하기 위한 변수
	int serialNo;	// 인스턴스 고유의 번호
	private String category = "";	// 제품의 상위 구분을 넣어준다?
	private String name = "";	// 제품의 이름
	private int price = 0;	// 제품의 가격
	private String contents = "";	// 제품의 간단 설명
	private int numberOfProduct = 0;	//제품의 갯수
	
	public Product(String name, int price) {
		//로그에서 쓰는 생성자
		this.name = name;
		this.price = price;
	}
	
	public Product(String category, String name, int price, String contents, int numberOfProduct) {
		// 상품 추가할때 쓰는 생성자
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
		return serialNo + ". [" + "이름 : " + name + ", 가격: " + price + ", 설명: " + contents + ", 재고: " + numberOfProduct +"]";
	}
	
	
}
