package kr.co.dong.room;

public class Reservation {
	
	private int roomNum;				//ȣ��
	private String customer;			//�����ڼ���
	private String revCode;				//�����ڵ�
	
	
	
	public Reservation(int roomNum, String customer, String revCode) {
		super();
		this.roomNum = roomNum;
		this.customer = customer;
		this.revCode = revCode;
	}


	public int getRoomNum() {
		return roomNum;
	}


	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
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
		return "[ȣ�� : " + roomNum + ", �����ڼ��� : " + customer + ", �����ȣ : " + revCode + "]";
	}


	
	
	
}
