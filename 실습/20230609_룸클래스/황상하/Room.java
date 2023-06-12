/*
 * 호텔 예약 프로그램 구현하기 ver1.0

 * - 호텔방 : 방이름, 호수, 가격, 설명, 예약상태
 * - 방예약 : 호수, 예약자명, 예약코드
 * - 기능 : 호텔룸 확인하기, 메뉴보여주기, 흐름보여주기
 * - 손님기능 : 예약하기, 예약취소, 
 * - 관리자기능 : 예약정보 확인
*/
package kr.co.dong.room;

public class Room {
	protected int rNo;
	private String rName;
	private int rPrice;
	private String rContent;
	protected boolean rCheck;
	
	// 디폴트생성자
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
			check = "예약가능";
		}else {
			check = "예약불가";
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
			check = "예약가능";
		}else {
			check = "예약불가";
		}
		return "Room "+rNo+" ["+rName+" / "+rPrice+"원 / "+rContent+" / "+ check + "]";
	}
	
}
