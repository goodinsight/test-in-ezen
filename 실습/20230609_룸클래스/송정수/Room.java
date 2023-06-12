/*	
 * 호텔 예약 프로그램 구현하기 ver1.0
 * - 호텔방 : 호수,방이름,가격,설명,예약유무(상태),예약자명,예약코드
 * - 방예약 : 예약자명,예약코드,호수
 * - 기능 : 예약하기,예약취소,호텔룸 확인, 메뉴보여주기,흐름보여주기
 * 
 */
package kr.co.dong.room;

public class Room {
	private int rNo;
	private String rName;
	private int rprice;
	private String rdescription;
	private boolean check;
	private String customer;
	private String revCode;
	
	public Room( ) {}

	/**
	 * @param rNo      호수 예) 101,102....
	 * @param rName    방이름 예)스위트,비지니스....
	 * @param rprice   가격 예)40000,50000....
	 * @param rdescription 방에 대한 설명 예)침대 2개, 에어컨, 컴퓨터....
	 */
	public Room(int rNo, String rName, int rprice, String rdescription) {
		super();
		this.rNo = rNo;
		this.rName = rName;
		this.rprice = rprice;
		this.rdescription = rdescription;
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

	public int getRprice() {
		return rprice;
	}

	public void setRprice(int rprice) {
		this.rprice = rprice;
	}

	public String getrdescription() {
		return rdescription;
	}

	public void setrdescription(String rdescription) {
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
		String mark = "";
		if(isCheck() == false) {
			mark = "예약가능";
		}else {
			mark = "예약 불가능";
		}
		return "Room [방 호수 =" + rNo + ", 방 이름 =" + rName + ", 방 가격 =" + rprice + ", 방 설명 =" + rdescription
				+ ", 예약여부 =" + mark +"]";
	}

}
