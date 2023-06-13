// 호텔 예약 프로그램 구현하기 ver 1.0
// 호텔방 : 호수, 방이름, 가격, 설명, 예약자명, 예약코드
// 방예약 : 호수, 예약자명, 예약코드
// 기능 : 예약하기, 예약취소, 방 정보 확인, 메뉴, 흐름보여주기

package kr.co.dong.room;

public class Room {
	private int rNo;	// 방 호수
	private String rName; // 방 이름
	private int rPrice; // 방 가격
	private String rContent = "입력되어있지 않습니다."; // 방 설명 
	private boolean rState = false; // 예약상태
	private String customer; // 예약자 명
	private String resCode; // 예약 코드
	
	public Room(int rNo, String rName, int rPrice) { 
		super();
		this.rNo = rNo;
		this.rName = rName;
		this.rPrice = rPrice;
	}

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

	public boolean isrState() {
		return rState;
	}

	public void setrState(boolean rState) {
		this.rState = rState;
	}

	public String getCustoemr() {
		return customer;
	}

	public void setCustoemr(String customer) {
		this.customer = customer;
	}

	public String getResCode() {
		return resCode;
	}

	public void setResCode(String resCode) {
		this.resCode = resCode;
	}
	
	
	
}
