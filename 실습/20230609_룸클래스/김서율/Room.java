package kr.co.dong.roomsy;

public class Room {
	private int rNo; // 생성자 만들 시 rNo, rName, rPrice, rContent는 필수
	private String rName;
	private int rPrice;
	private String rContent;
	private boolean rCheck;

	private String customer;
	private String revCode;

//	생성자
	public Room() {
	}

//	public Room(int rNo, String rName, int rPrice, String rContent, boolean rCheck, String customer, String revCode) {
	public Room(int rNo, String rName, int rPrice, String rContent) {
		super();
		this.rNo = rNo;
		this.rName = rName;
		this.rPrice = rPrice;
		this.rContent = rContent;
//		this.rCheck = rCheck;
//		this.customer = customer;
//		this.revCode = revCode;
	}

//private 제어자 사용 -> getter/ setter로 필드 사용
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

	public boolean isrCheck() {
		return rCheck;
	}

	public void setrCheck(boolean rCheck) {
		this.rCheck = rCheck;
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

	// 인스턴스의 필드 값을 추출 (String으로 전환)
	@Override
	public String toString() {
//		return "Room [rNo=" + rNo + ", rName=" + rName + ", rPrice=" + rPrice + ", rContent=" + rContent + ", rCheck="
//				+ rCheck + ", customer=" + customer + ", revCode=" + revCode + "]";
		return "Room [호실=" + rNo + ", 방 이름=" + rName + ", 방 가격=" + rPrice + ", 방 설명=" + rContent + ", 예약여부=" + rCheck
				+ "]"; // 실행클래스에서 필요한 정보만 출력
	}

}
