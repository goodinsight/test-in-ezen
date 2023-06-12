/*
 * ȣ�� ���� ���α׷� �����ϱ� ver1.0
 * 	- ȣ�ڹ� : ȣ��, ���̸�, ����, ����, ��������(����), �����ڸ�, �����ڵ�
 *  - �濹�� : �����ڸ�, �����ڵ�, ȣ�� 
 *  - ��� : �����ϱ�, ��������ϱ�, ȣ�ڷ� Ȯ���ϱ�, �޴������ֱ�, �帧�����ֱ�
 * 
 */

package kr.co.dong.room;

public class Room {
	private int rNumber;
	private String rName;
	private int rPrice;
	private String rContent;
	private boolean check;
	private String customer;
	private String revCode;
	
	public Room (int rNumber, String rName, int rPrice, String rContent){                       
		this.rNumber = rNumber;
		this.rName = rName;
		this.rPrice = rPrice;
		this.rContent = rContent;
	}

	public String getrName() {
		return rName;
	}

	public void setrName(String rName) {
		this.rName = rName;
	}

	public int getrNumber() {
		return rNumber;
	}

	public void setrNumber(int rNumber) {
		this.rNumber = rNumber;
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
		return "< "+ rNumber + "ȣ�� ���� > �� �̸� : " + rName + ", ���� : " + rPrice + ", �ȳ� : " + rContent
				+ ", �����Ȳ : " + (check == true ? "������" : "���డ��") + (customer == null ? "" : ", �����ڸ� : " + customer) + (revCode == null ? "" : ", �����ڵ� : " + revCode);
	}
	
	
	
}
