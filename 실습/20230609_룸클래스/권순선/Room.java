package kr.co.dong.io;

/*
 * ȣ�� ���� ���α׷� ���� ver 1.0
 * ȣ�ڹ� : ���̸�, ȣ��, ����, ����, ��������(����), �����ڸ�, �����ڵ�
 * �濹�� : ȣ��, �����ڸ�, �����ڵ�
 * ��� : �����ϱ�, �������, ȣ�ڷ� Ȯ��, �޴� �����ֱ�, �帧�����ֱ�
 */
public class Room {

	private int rNo;
	private String rName;
	private int rPrince;
	private String rContent;
	private boolean check;
	private String customer;
	private String revCode;

	public Room() {
		// TODO Auto-generated constructor stub
	}

	public Room(int rNo, String rName, int rPrince, String rContent) {
		super();
		this.rNo = rNo;
		this.rName = rName;
		this.rPrince = rPrince;
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

	public int getrPrince() {
		return rPrince;
	}

	public void setrPrince(int rPrince) {
		this.rPrince = rPrince;
	}

	public String getrContent() {
		return rContent;
	}

	public void setrContent(String rContent) {
		this.rContent = rContent;
	}

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
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

	@Override
	public String toString() {

		return "�� ��ȣ : " + rNo + "ȣ / �� �̸� : " + rName + " / ���� : " + rPrince + " / üũ : " + check;
	}

}
