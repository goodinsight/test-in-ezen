package kr.co.dong.room;

public class Customer {
	// ȸ�������� �ؼ� id pw �����ϰ�, �⺻ �̸� ������ȣ�� �ְ� ��ü����
	private String id;
	private String password;
	private String name;
	private String code;
	
//	private int headCount; // �ο����� ���� �� ���� ���� ������ �ʿ��Ҷ�
//	private int money; // ���� ����� �ʿ�
//	private String membership; // ���� �Ǽ� ������ ����� ����
	
	Customer(){
		
	}
	
	Customer(String id, String password, String name, String code){
		this.id = id;
		this.password = password;
		this.name = name;
		this.code = code;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Customer Infor"+this.getId() + this.getPassword();
	}
	
	
	
	
	
//	void makeReserv() {
//		// ���� �����ϴ� �޼ҵ�
//	}
//	
//	void cancelReserv() {
//		// ���� ����ϴ� �޼ҵ�
//	}
}
