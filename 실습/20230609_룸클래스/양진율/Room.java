/*
 * 호텔 예약 프로그램 구현하기 Ver1.0
0 * 
 * - 호텔방 : 호수, 방이름, 가격, 설명(정원?)
 * - 방예약 : 호수, 예약여부, 예약자명, 예약코드
 * 
 * - 기능 : 예약하기, 예약취소하기, 호텔룸 정보 확인, 메뉴 보여주기(정보 표시), 흐름 보여주기(입력 안내)
 * 
 * 
 * - Administrator
 * - Customer
 * - Product
 * 
 */

package kr.co.dong.room;

import java.util.Scanner;

public class Room {

//	static int cnt;
	private int rNo;
	private String rName;
	private int rPrice;
	private String rContent;
	private boolean rCheck;
	
//	----------------------- 추후 분리
	
//	private String customer;
//	private String revCode;
	

	public Room() {
		Scanner scan = new Scanner(System.in);

		
		System.out.print("\n방 번호 : ");
		this.setrNo(scan.nextInt());
		System.out.print("\n이름 : ");
		this.setrName(scan.next());
		System.out.print("\n가격 : ");
		this.setrPrice(scan.nextInt());
		System.out.print("\n설명 : ");
		this.setrContent(scan.nextLine());
		
		scan.close();
	}

	
	/**
	 * @param rNo
	 * @param rName
	 * @param rPrice
	 * @param rContent
	 */
	public Room(int rNo, String rName, int rPrice, String rContent) {
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
	
	

	public boolean isrCheck() {
		return rCheck;
	}

	public void setrCheck(boolean rCheck) {
		this.rCheck = rCheck;
	}


	@Override
	public String toString() {
		return "[객실 번호=" + rNo + ", 객실 이름=" + rName + ", 가격=" + rPrice + ", 기타=" + rContent + "]";
	}
	
	
	
	
	
	
	
	
	
}
