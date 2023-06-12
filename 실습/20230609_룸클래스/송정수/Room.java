/*	
 * ȣ�� ���� ���α׷� �����ϱ� ver1.0
 * - ȣ�ڹ� : ȣ��,���̸�,����,����,��������(����),�����ڸ�,�����ڵ�
 * - �濹�� : �����ڸ�,�����ڵ�,ȣ��
 * - ��� : �����ϱ�,�������,ȣ�ڷ� Ȯ��, �޴������ֱ�,�帧�����ֱ�
 * 
 */
package kr.co.dong.room;

public class Room {
	private int rNo;
	private String rName;
	private int rprice;
	private String rdescription;
	private boolean check;
	private String customer;
	private String revCode;
	
	public Room( ) {}

	/**
	 * @param rNo      ȣ�� ��) 101,102....
	 * @param rName    ���̸� ��)����Ʈ,�����Ͻ�....
	 * @param rprice   ���� ��)40000,50000....
	 * @param rdescription �濡 ���� ���� ��)ħ�� 2��, ������, ��ǻ��....
	 */
	public Room(int rNo, String rName, int rprice, String rdescription) {
		super();
		this.rNo = rNo;
		this.rName = rName;
		this.rprice = rprice;
		this.rdescription = rdescription;
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

	public int getRprice() {
		return rprice;
	}

	public void setRprice(int rprice) {
		this.rprice = rprice;
	}

	public String getrdescription() {
		return rdescription;
	}

	public void setrdescription(String rdescription) {
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
		String mark = "";
		if(isCheck() == false) {
			mark = "���డ��";
		}else {
			mark = "���� �Ұ���";
		}
		return "Room [�� ȣ�� =" + rNo + ", �� �̸� =" + rName + ", �� ���� =" + rprice + ", �� ���� =" + rdescription
				+ ", ���࿩�� =" + mark +"]";
	}

}
