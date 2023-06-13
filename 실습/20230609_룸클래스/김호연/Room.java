/*
 * ȣ�� ���� ���α׷� ���� ver1.0
 * - ȣ�� �� : ȣ��, �� �̸�, ����, ����, ������, ���� �ڵ�, ���� ����
 * (- �� ���� : ���� �ڵ�, ������, ȣ��)
 * - ��� : ����, ���� ���, ȣ�ڷ� Ȯ��, �޴� Ȯ��, �帧 Ȯ��
 * 
 * 
 */

package kr.co.dong.room;

public class Room {
	
	private int rNo;
	private String rName;
	private int rPrice;
	private String rContent;
	private boolean check;
	private String customer;
	private String revCode;
	
	
	public Room() {
	}
	
	public Room(int rNo, String rName, int rPrice, String rContent) {
		super();
		this.rNo = rNo;
		this.rName = rName;
		this.rPrice = rPrice;
		this.rContent = rContent;
	}

	
//	public Room(String rName, int rNo, int rPrice) {
//		super();
//		this.rName = rName;
//		this.rNo = rNo;
//		this.rPrice = rPrice;
//	}
//	
//	public Room(int rNo) {
//		super();
//		this.rNo = rNo;
//	}

	
	
	public String getrName() {
		return rName;
	}

	public void setrName(String rName) {
		this.rName = rName;
	}

	public int getrNo() {
		return rNo;
	}

	public void setrNo(int rNo) {
		this.rNo = rNo;
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
		return "[ȣ�� : " + rNo + " / �� �̸� : " + rName + " / �� ���� : " + rPrice + " / �� ���� : " + rContent + " / ���� ���� : "
				+ check + "]";
	}
	public String revInfo() {
		return "[������ : " + customer + " / ���� �ڵ� : " + revCode + "]";
	}
	
	
	
	
	
	

}
