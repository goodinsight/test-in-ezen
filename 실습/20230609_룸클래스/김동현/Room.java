package kr.co.dong.room;

//ȣ�� ���� ���α׷� �����ϱ� ,,ȣ�ڹ� :ȣ�� ,���̸� ,  ����, ����,��������������� �����ڸ�,�����ڵ�
//�濹�� : , �����ڸ� , �����ڵ� ���  ,  ȣ��
//��� : �����ϱ� , ��������ϱ� , ȣ�ڷ�Ȯ���ϱ� , �޴������ֱ�,�帧�����ֱ�
//
public class Room {

	private int rNo;// ȣ��
	private String rName;/// ���̸�
	private int rPrice;// ����
	private String rContent;// ����
	private boolean check;// ���������������üũ???
	private String customer;// �����ڸ�??
	private String revCode;// �����ڵ�

	public Room() {//����Ʈ ������?!?!
	}
	
	
	

	/**
	 * @param rNo
	 * @param rName
	 * @param rPrice
	 * @param rContent
	 */
	public Room(int rNo, String rName, int rPrice, String rContent) {
		super();
		this.rNo = rNo;
		this.rName = rName;
		this.rPrice = rPrice;
		this.rContent = rContent;
	}




	/**
	 * @param rNo
	 * @param rName
	 * @param rPrice
	 * @param rContent
	 * @param check
	 * @param customer
	 * @param revCode
	 */
//	public Room(int rNo, String rName, int rPrice, String rContent, boolean check, String customer, String revCode) {
//		super();
//		this.rNo = rNo;
//		this.rName = rName;
//		this.rPrice = rPrice;
//		this.rContent = rContent;
//		this.check = check;
//		this.customer = customer;
//		this.revCode = revCode;
//	}
	
	

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
		return "Room [rNo=" + rNo + ", rName=" + rName + ", rPrice=" + rPrice + ", rContent=" + rContent + ", check="
				+ check + ", customer=" + customer + ", revCode=" + revCode + "]";
	}

}
