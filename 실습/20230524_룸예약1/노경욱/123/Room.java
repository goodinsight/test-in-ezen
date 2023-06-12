/*
 * 호텔 예약 프로그램 규현하기 ver1.0
 * - 호텔방: 호수, 방이름, 가격, 설명
 * - 방예약: 예약자명, 예약코드, 호수
 * - 기능: 예약하기, 예약취소하기, 호텔룸 확인하기, 메뉴보여주기, 흐름보여주기
 */

package room;

public class Room {
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
	
	public Room(int rNO, String rName, int rPrice, String rContent) {
		
	}
	
	private int rNo;
	private String rName;
	private int rPrice;
	private String rContent;
	private boolean check;
	private String customer;
	private String revCode;
	
}
