/*
 * ȣ�� ���� ���α׷� �����ϱ� ver1.0
 * - ȣ�ڹ�: ȣ��, ���̸�, ����, ����
 * - �濹��: �����ڸ�, �����ڵ�, ȣ��
 * - ���: �����ϱ�, ��������ϱ�, ȣ�ڷ� Ȯ���ϱ�, �޴������ֱ�, �帧�����ֱ�
 */

package room;

public class Room {

	
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
	public boolean isRcheck() {
		return rcheck;
	}
	public void setrcheck(boolean rcheck) {
		this.rcheck = rcheck;
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
	public Room(int rNo, String rName, int rPrice, String rContent, boolean rcheck, String rcustomer) {
		super();
		this.rNo = rNo;
		this.rName = rName;
		this.rPrice = rPrice;
		this.rContent = rContent;
		this.rcheck = rcheck;
		this.customer = rcustomer;
	}
	private int rNo;
	private String rName;
	private int rPrice;
	private String rContent;
	private boolean rcheck;
	private String customer;
	private String revCode;
	
}
