package kr.co.dong.room;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomControl {
	
	static Scanner scan=new Scanner(System.in);
	
	public static void main(String[] args) {
//		호텔룸 정보 보관 -> List
		List<Room> list = new ArrayList<Room>();
		boolean stop=false;
		
//		호텔의 객실 정보 초기화
		init(list);
		
//		
		while(!stop) {
			int sel=menu();
			
			switch(sel) {
			case 1:			// 객실 예약
				revRoom(list);
				break;
			case 2:			// 객실 예약 취소
				canselRoom(list);
				break;
			case 3:			// 전체 확인 / 선택 확인
				printRoom(list);
				break;
			case 4:			// 예약자 정보 확인
				viewCustm(list);
				break;
			default:
				stop=true;
			}
		}
		
	}	// end of main

	
	
	
	
	
	private static int viewCustm(List<Room> list) {	// 예약자 정보 확인 메소드
		String revC=inputS("예약 코드 입력 : ");
		for(int i=0; i<list.size(); i++) {
			if(revC.equals(list.get(i).getRevCode())) {
				System.out.println(list.get(i).revInfo());
				System.out.println(list.get(i));
				return i;
			}
			else if(i==list.size()-1){
				System.out.println("예약 코드 불명");
			}
		}
		return -1;
		
	}


	private static void canselRoom(List<Room> list) {	// 객실 예약 취소 메소드
		int idx=viewCustm(list);
		String yn=inputS("예약 취소? (y/n) : ");
			if(yn.equals("y")) {
				System.out.println("예약 취소됨");
				list.get(idx).setCheck(false);
				list.get(idx).setCustomer(null);
				list.get(idx).setRevCode(null);
			}
			else {
				return;
			}
			
	}


	private static void revRoom(List<Room> list) {		// 객실 예약 메소드
		for(int i=0; i<list.size(); i++) {
			System.out.println((i+1)+". "+list.get(i));
		}
		while(true) {
			int sel=inputM("예약 객실 선택 (1~"+list.size()+") : ");
			if(sel<0 || sel>list.size()) {
				continue;
			}
			else {
				int idx=sel-1;
				if(list.get(idx).isCheck()) {
					System.out.println("이미 예약된 객실");
					return;
				}
				list.get(idx).setCheck(true);
				String cust=inputS("예약자 입력 : ");
				list.get(idx).setCustomer(cust);
				int revC=(int)(Math.random()*9000)+1000;
				list.get(idx).setRevCode(revC+"");
				System.out.println("예약 코드 : "+revC);
				break;
			}
		}
		
	}


	private static void printRoom(List<Room> list) {	// 객실 확인 메소드
		int sel=inputM("1.전체 객실 확인 2.선택 객실 확인 : ");
		if(sel==1) {
			for(Room r:list) {
				System.out.println(r);
			}
		}else if(sel==2) {
			sel=inputM("1.호수 검색 2.가격 검색 3.이름 검색: ");
			if(sel==1) {
				int idx=findNo(inputS("확인 호수 입력 : "), list);
				if(idx==-1) {
					System.out.println("호수 불명");
				} else {
					System.out.println(list.get(idx));
				}
//				searchNo(list);
			}else if(sel==2) {
				searchPrice(list);
			}else if(sel==3) {
				findName(inputS("이름 입력 : "), list);
			}
		}
		
	}


	private static void init(List<Room> list) {			// 객실 정보 초기화 메소드
		list.add(new Room(101, "가1", 2000, "A"));
		list.add(new Room(102, "가2", 3000, "B"));
		list.add(new Room(103, "나1", 4000, "C"));
		list.add(new Room(104, "나2", 5000, "D"));
		list.add(new Room(105, "나3", 6000, "E"));
	
		
	}
	

	private static int menu() {							// 메뉴 선택 메소드
		System.out.println("호텔 예약 프로그램");	
		int sel=inputM("1.예약 2.예약 취소 3.객실 확인 4.예약 확인 : ");
		return sel;
		
	}
	
	
	private static int inputM(String txt) {				// int 입력문 메소드
		System.out.print(txt);
		return scan.nextInt();
		
	}
	
	
	private static String inputS(String txt) {			// String 입력문 메소드
		System.out.print(txt);
		return scan.next();
		
	}
	
	
	private static void searchNo(List<Room> list) {		// no 검색 메소드
		String rNo=inputS("확인 호수 입력 : ");
		int count=0;
		for(int i=0; i<list.size(); i++) {
			if(rNo.equals(""+list.get(i).getrNo())) {
				System.out.println(list.get(i));
				count+=1;
				break;
			}
		}
		if(count==0){
			System.out.println("호수 불명");
		}
		
	}
	
	
	private static void searchPrice(List<Room> list) {	// price 이하 검색 메소드
		int rPrice=inputM("최대 가격 입력 : ");
		int count=0;
		for(int i=0; i<list.size(); i++) {
			if(rPrice>=list.get(i).getrPrice()) {
				System.out.println(list.get(i));
				count+=1;
			}
		}
		if(count==0) {
			System.out.println("가격 "+rPrice+" 이하 객실 없음");
		}
		
	}
	
	
//	list 내에 해당 내용이 저장되어있는 index 검색 메소드
//	방번호 or 방이름
	
	private static int findNo(String rNo, List<Room> list) {
		int idx=-1;
		for(int i=0; i<list.size(); i++) {
			if(rNo.equals(""+list.get(i).getrNo())) {
				idx=i;
				break;
			}
		}
		return idx;
	}
	
	
	private static void findName(String rName, List<Room> list) {
		int count=0;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getrName().contains(rName)) {
				System.out.println(list.get(i));
				count+=1;
			}
		}
		if(count==0) {
			System.out.println("이름 불명");
		}
	}
	
}
