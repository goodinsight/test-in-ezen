/*
 * 호텔 예약 프로그램 구현하기 ver1.0((base: 관리자 정보, custom 정보, 상품 정보)
 * - 호텔방 : 호수, 방이름, 가격, 설명, 예약유무, 예약자명, 예약코드 : 정규화(통으로 짜서 분리) // 나중에 생기는 것은 필수 생성자 아님
 * - 방예약 : 예약자명, 예약코드, 호수 
 * - 기능 : 예약하기, 예약취소하기, 호텔룸 확인하기, 메뉴 보여주기(display), 흐름보여주기(play) 
 */

package kr.co.dong.room;

public class Room { // 방에대한 속성을 다 집어 넣음. 추후 필요시 예약등 기능별 분리
	private int rNo;
	private String rName;
	private int rPrice;
	private String rContent;
	private boolean check;
	private String customer;
	private String revCode;
	
	
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


	
	
	public Room(int rNo, String rName, int rPrice, String rContent) { //생성자를 만들어주지 않으면 에러.
		// TODO Auto-generated constructor stub
		this.rNo = rNo;
		this.rName = rName;
		this.rPrice = rPrice;
		this.rContent = rContent;
	}
	
	
	public boolean getCheck() {
		return check;
	}
	
	public void setCheck(boolean check) {
		this.check = check;
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
	
	@Override
	public String toString() {
		return "Room [rNo=" + rNo + ", rName=" + rName + ", rPrice=" + rPrice + ", rContent=" + rContent + ", check="
				+ check + ", customer=" + customer + ", revCode=" + revCode + "]";
	}
	


}
