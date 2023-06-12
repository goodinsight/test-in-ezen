package kr.co.dong.room;

public class Reservation {
	
	private int roomNum;				//호수
	private String customer;			//예약자성함
	private String revCode;				//예약코드
	
	
	
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
		return "[호실 : " + roomNum + ", 예약자성함 : " + customer + ", 예약번호 : " + revCode + "]";
	}


	
	
	
}
