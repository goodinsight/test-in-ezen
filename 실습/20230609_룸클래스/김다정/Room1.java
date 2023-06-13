/*
 * 호텔 예약 프로그램 구현하기 ver 1.0
 * - 호텔방 : 호수, 방이름, 가격, 설명, 예약유무, 예약자명, 예약코드
 * - 방예약 : 예약자명, 예약코드, 호수
 * - 기능 : 예약하기, 예약취소하기, 호텔룸 확인하기, 메뉴보여주기, 흐름보여주기(1번이면 뭐고, 2번이면 뭐고~~ 메뉴판느낌)
 * 
 */
package kr.co.dong.room;

public class Room1 {
//	선언만 먼저 - 해당하는 모든 속성 다 집어넣기
	private int rNo;				//방번호
	private String rName;			//방이름		
	private int rPrice;				//가격
	private String rContent;		//내용
	private boolean check;			//예약여부
	private String customer;		//예약자성함
	private String revCode;			//예약번호
	
	public Room1 () {}   //default 생성자
	
//  필수조건(호수, 방이름, 가격, 설명)에만 생성자(=인스턴스 초기화)를 만든다
	public Room1(int rNo, String rName, int rPrice, String rContent) {
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

	@Override    // toString만들기 - 인스턴스의 필드값을 추출해줌 해시코드를 String값으로 전환시켜주는 역할 
	public String toString() {
		return "Room [rNo=" + rNo + ", rName=" + rName + ", rPrice=" + rPrice + ", rContent=" + rContent + ", check="
				+ check + ", customer=" + customer + ", revCode=" + revCode + "]";
	}
	
	
	
	

}
