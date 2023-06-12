// ȣ�� ���� ���α׷� �����ϱ� ver 1.0
// ȣ�ڹ� : ȣ��, ���̸�, ����, ����, �����ڸ�, �����ڵ�
// �濹�� : ȣ��, �����ڸ�, �����ڵ�
// ��� : �����ϱ�, �������, �� ���� Ȯ��, �޴�, �帧�����ֱ�

package kr.co.dong.room;

public class Room {
	private int rNo;	// �� ȣ��
	private String rName; // �� �̸�
	private int rPrice; // �� ����
	private String rContent = "�ԷµǾ����� �ʽ��ϴ�."; // �� ���� 
	private boolean rState = false; // �������
	private String customer; // ������ ��
	private String resCode; // ���� �ڵ�
	
	public Room(int rNo, String rName, int rPrice) { 
		super();
		this.rNo = rNo;
		this.rName = rName;
		this.rPrice = rPrice;
	}

	public Room(int rNo, String rName, int rPrice, String rContent) {
		super();
		this.rNo = rNo;
		this.rName = rName;
		this.rPrice = rPrice;
		this.rContent = rContent;
	}

	public int getrNo() {
		return rNo;
	}

	public void setrNo(int rNo) {
		this.rNo = rNo;
	}

	public String getrName() {
		return rName;
	}

	public void setrName(String rName) {
		this.rName = rName;
	}

	public int getrPrice() {
		return rPrice;
	}

	public void setrPrice(int rPrice) {
		this.rPrice = rPrice;
	}

	public String getrContent() {
		return rContent;
	}

	public void setrContent(String rContent) {
		this.rContent = rContent;
	}

	public boolean isrState() {
		return rState;
	}

	public void setrState(boolean rState) {
		this.rState = rState;
	}

	public String getCustoemr() {
		return customer;
	}

	public void setCustoemr(String customer) {
		this.customer = customer;
	}

	public String getResCode() {
		return resCode;
	}

	public void setResCode(String resCode) {
		this.resCode = resCode;
	}
	
	
	
}
