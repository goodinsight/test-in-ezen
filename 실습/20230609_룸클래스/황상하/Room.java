/*
 * ȣ�� ���� ���α׷� �����ϱ� ver1.0

 * - ȣ�ڹ� : ���̸�, ȣ��, ����, ����, �������
 * - �濹�� : ȣ��, �����ڸ�, �����ڵ�
 * - ��� : ȣ�ڷ� Ȯ���ϱ�, �޴������ֱ�, �帧�����ֱ�
 * - �մԱ�� : �����ϱ�, �������, 
 * - �����ڱ�� : �������� Ȯ��
*/
package kr.co.dong.room;

public class Room {
	protected int rNo;
	private String rName;
	private int rPrice;
	private String rContent;
	protected boolean rCheck;
	
	// ����Ʈ������
	public Room() {
		
	}; 
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
	public String isrCheck() {
		String check = null;
		if(rCheck == false) {
			check = "���డ��";
		}else {
			check = "����Ұ�";
		}
		return check;
	}
	public void setrCheck(boolean rCheck) {
		this.rCheck = rCheck;
	}

	@Override
	public String toString() {
		String check = null;
		if(rCheck == false) {
			check = "���డ��";
		}else {
			check = "����Ұ�";
		}
		return "Room "+rNo+" ["+rName+" / "+rPrice+"�� / "+rContent+" / "+ check + "]";
	}
	
}
