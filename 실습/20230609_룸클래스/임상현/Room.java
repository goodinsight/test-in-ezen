// 호텔 예약 프로그램 구현하기 ver 1.0
// 호텔방 : 호수, 방이름, 가격, 설명, 예약자명, 예약코드
// 방예약 : 호수, 예약자명, 예약코드
// 기능 : 예약하기, 예약취소, 방 정보 확인, 메뉴, 흐름보여주기

package kr.co.dong.room;

public class Room {
	private int rNo;
	private String rName;
	private int rPrice;
	private String rContent = "입력되어있지 않습니다.";
	private boolean rState = false;
	private String Customer;
	private String resCode;
	
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

	public String getCustomer() {
		return Customer;
	}

	public void setCustomer(String Customer) {
		this.Customer = Customer;
	}

	public String getResCode() {
		return resCode;
	}

	public void setResCode(String resCode) {
		this.resCode = resCode;
	}
	
	
	
}
