package VendingMachine;

public class Japangi {
//----------------------------------------------
	private String jName; // ��ǰ �̸�
	private int jPrice; // ���� �ʼ� 3����(�մ�)
	private int jCount; // ���

	private int jMoney; // ��


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
		return " ���Ǳ� [�޴� : " + jName + ", ���� : " + jPrice + ", ��� : " + jCount + "]";
	}

}
