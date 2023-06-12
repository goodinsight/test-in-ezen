/*
 *  호텔 예약 프로그램 구현하기 ver1.0
 *  - 호텔방 : 방이름, 호수, 가격, 설명, 예약유무(상태), 예약자명, 예약코드
 *  - 방예약 : 호수, 예약자명, 예약번호, 예약일
 *  - 기능 : 예약하기, 예약취소하기, 호텔룸 확인하기, 메뉴보여주기, 흐름보여주기
 *  
 */
package kr.co.dong.room;

public class Room {

	private int roomNum;				//호수
	private String roomName;			//방 이름
	private int roomPrice;				//방 가격
	private String roomContent;			//방 설명
	private boolean roomCheck;			//예약여부
	
	public Room() {
		
	}
	
	public Room(int roomNum, String roomName, int roomPrice, String roomContent) {
		super();
		this.roomNum = roomNum;
		this.roomName = roomName;
		this.roomPrice = roomPrice;
		this.roomContent = roomContent;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public int getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}

	public String getRoomContent() {
		return roomContent;
	}

	public void setRoomContent(String roomContent) {
		this.roomContent = roomContent;
	}

	public boolean isRoomCheck() {
		return roomCheck;
	}

	public void setRoomCheck(boolean roomCheck) {
		this.roomCheck = roomCheck;
	}


	@Override
	public String toString() {
		return "[호실 : " + roomNum + ", 호실이름 : " + roomName + ", 호실가격 : " + roomPrice + ", 호실정보 : "
				+ roomContent + "예약정보 : "+(!roomCheck?"예약가능":"예약불가능")+"]";
	}
	
	
	
}
