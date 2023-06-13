package kr.co.dong.roomsy;

public class Room {
	private int rNo; // ������ ���� �� rNo, rName, rPrice, rContent�� �ʼ�
	private String rName;
	private int rPrice;
	private String rContent;
	private boolean rCheck;

	private String customer;
	private String revCode;

//	������
	public Room() {
	}

//	public Room(int rNo, String rName, int rPrice, String rContent, boolean rCheck, String customer, String revCode) {
	public Room(int rNo, String rName, int rPrice, String rContent) {
		super();
		this.rNo = rNo;
		this.rName = rName;
		this.rPrice = rPrice;
		this.rContent = rContent;
//		this.rCheck = rCheck;
//		this.customer = customer;
//		this.revCode = revCode;
	}

//private ������ ��� -> getter/ setter�� �ʵ� ���
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

	public boolean isrCheck() {
		return rCheck;
	}

	public void setrCheck(boolean rCheck) {
		this.rCheck = rCheck;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getRevCode() {
		return revCode;
	}

	public void setRevCode(String revCode) {
		this.revCode = revCode;
	}

	// �ν��Ͻ��� �ʵ� ���� ���� (String���� ��ȯ)
	@Override
	public String toString() {
//		return "Room [rNo=" + rNo + ", rName=" + rName + ", rPrice=" + rPrice + ", rContent=" + rContent + ", rCheck="
//				+ rCheck + ", customer=" + customer + ", revCode=" + revCode + "]";
		return "Room [ȣ��=" + rNo + ", �� �̸�=" + rName + ", �� ����=" + rPrice + ", �� ����=" + rContent + ", ���࿩��=" + rCheck
				+ "]"; // ����Ŭ�������� �ʿ��� ������ ���
	}

}
