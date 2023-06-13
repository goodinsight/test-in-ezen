/*
 * ȣ�� ���� ���α׷� �����ϱ� verl.0
 * - ȣ�� �� : ȣ��, ���̸�, ����, ����, ��������(����), ������ ��, �����ڵ�(������ ��, �����ڵ�� �� �ؿ� �濹�� ������ó�� ������ �����ؾ���)
 * - �� ���� : ������ ��, �����ڵ�, ȣ��
 * - ��� : �����ϱ�, ���� ����ϱ�, ȣ�� �� Ȯ���ϱ�, �޴������ֱ�, �帧�����ֱ�
 *  
 */
package kr.co.dong.room;

public class Room {
	private int rNo; // ȣ��
	private String rName; // ���̸�
	private int rPrice; // ����
	private String rContent; //�漳��
	private boolean check; // Ȯ��
	private String customer; //������ �̸�
	private String revCode; // ������ ��ȣ
	
	public Room() {
		
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
		return "Room [�� ��ȣ : " + rNo + ", �� �̸� : " + rName + ", �� ���� : " + rPrice + " ]";
	}   
	
	
	
}
