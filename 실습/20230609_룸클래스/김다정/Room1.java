/*
 * ȣ�� ���� ���α׷� �����ϱ� ver 1.0
 * - ȣ�ڹ� : ȣ��, ���̸�, ����, ����, ��������, �����ڸ�, �����ڵ�
 * - �濹�� : �����ڸ�, �����ڵ�, ȣ��
 * - ��� : �����ϱ�, ��������ϱ�, ȣ�ڷ� Ȯ���ϱ�, �޴������ֱ�, �帧�����ֱ�(1���̸� ����, 2���̸� ����~~ �޴��Ǵ���)
 * 
 */
package kr.co.dong.room;

public class Room1 {
//	���� ���� - �ش��ϴ� ��� �Ӽ� �� ����ֱ�
	private int rNo;				//���ȣ
	private String rName;			//���̸�		
	private int rPrice;				//����
	private String rContent;		//����
	private boolean check;			//���࿩��
	private String customer;		//�����ڼ���
	private String revCode;			//�����ȣ
	
	public Room1 () {}   //default ������
	
//  �ʼ�����(ȣ��, ���̸�, ����, ����)���� ������(=�ν��Ͻ� �ʱ�ȭ)�� �����
	public Room1(int rNo, String rName, int rPrice, String rContent) {
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

	@Override    // toString����� - �ν��Ͻ��� �ʵ尪�� �������� �ؽ��ڵ带 String������ ��ȯ�����ִ� ���� 
	public String toString() {
		return "Room [rNo=" + rNo + ", rName=" + rName + ", rPrice=" + rPrice + ", rContent=" + rContent + ", check="
				+ check + ", customer=" + customer + ", revCode=" + revCode + "]";
	}
	
	
	
	

}
