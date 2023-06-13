/*
 * 호텔 예약 프로그램 구현하기 verl.0
 * - 호텔 방 : 호수, 방이름, 가격, 설명, 예약유무(상태), 예약자 명, 예약코드(예약자 명, 예약코드등 은 밑에 방예약 구분한처럼 원래는 구분해야함)
 * - 방 예약 : 예약자 명, 예약코드, 호수
 * - 기능 : 예약하기, 예약 취소하기, 호텔 룸 확인하기, 메뉴보여주기, 흐름보여주기
 *  
 */
package kr.co.dong.room;

public class Room {
	private int rNo; // 호수
	private String rName; // 방이름
	private int rPrice; // 가격
	private String rContent; //방설명
	private boolean check; // 확인
	private String customer; //예약자 이름
	private String revCode; // 예약자 번호
	
	public Room() {
		
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
		return "Room [방 번호 : " + rNo + ", 방 이름 : " + rName + ", 방 가격 : " + rPrice + " ]";
	}   
	
	
	
}
