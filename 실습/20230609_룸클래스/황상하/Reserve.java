/*
 * 호텔 예약 프로그램 구현하기 ver1.0
 * - 호텔방 : 방이름, 호수, 가격, 설명, 예약상태
 * - 방예약 : 호수, 예약자명, 예약코드
 * - 기능 : 호텔룸 확인하기, 메뉴보여주기, 흐름보여주기
 * - 손님기능 : 예약하기, 예약취소, 
 * - 관리자기능 : 예약정보 확인
*/
package kr.co.dong.room;

public class Reserve extends Room {
	private String cumtomer;
	private int revCode;
	
	
	public Reserve(int rNo, String cumtomer, int revCode) {
		super.rNo = rNo;
		this.cumtomer = cumtomer;
		this.revCode = revCode;
	}
	public String getCumtomer() {
		return cumtomer;
	}
	public void setCumtomer(String cumtomer) {
		this.cumtomer = cumtomer;
	}
	public int getRevCode() {
		return revCode;
	}
	public void setRevCode(int revCode) {
		this.revCode = revCode;
	}
	
	@Override
	public String toString() {
		return "Reserve "+rNo+"[예약자 : " + cumtomer + " / 예약코드 : " + revCode+"]";
	}
	
}
