package kr.co.dong.room;

//호텔 예약 프로그램 구현하기 ,,호텔방 :호수 ,방이름 ,  가격, 설명,예약상태유무여부 예약자명,예약코드
//방예약 : , 예약자명 , 예약코드 등등  ,  호수
//기능 : 예약하기 , 예약취소하기 , 호텔룸확인하기 , 메뉴보여주기,흐름보여주기
//
public class Room {

	private int rNo;// 호수
	private String rName;/// 방이름
	private int rPrice;// 가격
	private String rContent;// 설명
	private boolean check;// 예약상태유무여부체크???
	private String customer;// 예약자명??
	private String revCode;// 예약코드

	public Room() {//디펄트 생성자?!?!
	}
	
	
	

	/**
	 * @param rNo
	 * @param rName
	 * @param rPrice
	 * @param rContent
	 */
	public Room(int rNo, String rName, int rPrice, String rContent) {
		super();
		this.rNo = rNo;
		this.rName = rName;
		this.rPrice = rPrice;
		this.rContent = rContent;
	}




	/**
	 * @param rNo
	 * @param rName
	 * @param rPrice
	 * @param rContent
	 * @param check
	 * @param customer
	 * @param revCode
	 */
//	public Room(int rNo, String rName, int rPrice, String rContent, boolean check, String customer, String revCode) {
//		super();
//		this.rNo = rNo;
//		this.rName = rName;
//		this.rPrice = rPrice;
//		this.rContent = rContent;
//		this.check = check;
//		this.customer = customer;
//		this.revCode = revCode;
//	}
	
	

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
		return "Room [rNo=" + rNo + ", rName=" + rName + ", rPrice=" + rPrice + ", rContent=" + rContent + ", check="
				+ check + ", customer=" + customer + ", revCode=" + revCode + "]";
	}

}
