package kr.co.dong.io;

/*
 * 호텔 예약 프로그램 구현 ver 1.0
 * 호텔방 : 방이름, 호수, 가격, 설명, 예약유무(상태), 예약자명, 예약코드
 * 방예약 : 호수, 예약자명, 예약코드
 * 기능 : 예약하기, 예약취소, 호텔룸 확인, 메뉴 보여주기, 흐름보여주기
 */
public class Room {

	private int rNo;
	private String rName;
	private int rPrince;
	private String rContent;
	private boolean check;
	private String customer;
	private String revCode;

	public Room() {
		// TODO Auto-generated constructor stub
	}

	public Room(int rNo, String rName, int rPrince, String rContent) {
		super();
		this.rNo = rNo;
		this.rName = rName;
		this.rPrince = rPrince;
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

	public int getrPrince() {
		return rPrince;
	}

	public void setrPrince(int rPrince) {
		this.rPrince = rPrince;
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

		return "방 번호 : " + rNo + "호 / 방 이름 : " + rName + " / 가격 : " + rPrince + " / 체크 : " + check;
	}

}
