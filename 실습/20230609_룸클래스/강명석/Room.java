/*
 * ȣ�� ���� ���α׷� �����ϱ� ver1.0((base: ������ ����, custom ����, ��ǰ ����)
 * - ȣ�ڹ� : ȣ��, ���̸�, ����, ����, ��������, �����ڸ�, �����ڵ� : ����ȭ(������ ¥�� �и�) // ���߿� ����� ���� �ʼ� ������ �ƴ�
 * - �濹�� : �����ڸ�, �����ڵ�, ȣ�� 
 * - ��� : �����ϱ�, ��������ϱ�, ȣ�ڷ� Ȯ���ϱ�, �޴� �����ֱ�(display), �帧�����ֱ�(play) 
 */

package kr.co.dong.room;

public class Room { // �濡���� �Ӽ��� �� ���� ����. ���� �ʿ�� ����� ��ɺ� �и�
	private int rNo;
	private String rName;
	private int rPrice;
	private String rContent;
	private boolean check;
	private String customer;
	private String revCode;
	
	
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


	
	
	public Room(int rNo, String rName, int rPrice, String rContent) { //�����ڸ� ��������� ������ ����.
		// TODO Auto-generated constructor stub
		this.rNo = rNo;
		this.rName = rName;
		this.rPrice = rPrice;
		this.rContent = rContent;
	}
	
	
	public boolean getCheck() {
		return check;
	}
	
	public void setCheck(boolean check) {
		this.check = check;
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
	
	@Override
	public String toString() {
		return "Room [rNo=" + rNo + ", rName=" + rName + ", rPrice=" + rPrice + ", rContent=" + rContent + ", check="
				+ check + ", customer=" + customer + ", revCode=" + revCode + "]";
	}
	


}
