/*	
 * 	ȣ�� ���� ���α׷� �����ϱ� ver1.0
 * 	- ȣ�ڹ� : ȣ��, ���̸�, ����, ����, ��������(����), �����ڸ�, �����ڵ�
 *  - �濹�� : �����ڸ�, �����ڵ�, ȣ��
 *  - ��� : �����ϱ�, ��������ϱ�, ȣ�ڷ� Ȯ���ϱ�, �޴������ֱ�, �帧�����ֱ�
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
	
	public Room() {}
	/**
	 * @param rNo
	 * @param rName
	 * @param rPrice
	 * @param rContent
	 */
	public Room(int rNo, String rName, int rPrice, String rContent) {
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
		return "["+rNo+"ȣ "+rName+" "+rPrice+"�� ���� : "+rContent+"]\n[�����ڸ� : "+customer+" �����ȣ : "+revCode+"]";
	}
	
	
}
