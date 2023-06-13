package kr.co.dong.room;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomControl {
	
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		List<Room> list = new ArrayList<>();
		boolean stop = false;
		
		
		
//		호텔의 룸 정보를 초기화하고 저장
		list = init();
		
		while(!stop) {
			int sel = menu();
			
			switch (sel) {
			case 1:	// 방 예약하기
				revRoom(list);
				break;
			case 2:	// 방 예약 취소
				cancelRoom(list);
				break;
			case 3:	// 방 전체확인 / 선택확인
				printRoom(list);
				break;
			case 4: // 예약자 정보확인
				inforCustomer(list);
				break;

			default:
				
				break;
			}
		}
	}
//	list 내에 해당 내용이 저장되어 있는 index를 찾는 메소드
//	방번호로 찾기? 방이름으로 찾기?
	private static int findRoom(String name, List<Room> list) {
		int index = -1;
		for(Room r : list) {
//			list.get(i).getrName() => 리스트내에 방이름
			if(r.getrName().equals(name)) {
				
//				index = r;
				break;
			}	
		}
		return index;
	}
	
	private static int findRoom(int rNumber, List<Room> list) {
		int index = -1;
		for(int i = 0; i < list.size(); i++) {
//			list.get(i).getrName() => 리스트내에 방이름
			if(list.get(i).getrNumber() == rNumber) {
				index = i;
				break;
			}	
		}
		return index;
	}
	private static int searchRoom(int rPrice, List<Room> list) {
		int index = -1;
		for(int i = 0; i < list.size(); i++) {
//			list.get(i).getrName() => 리스트내에 방이름
			if(list.get(i).getrPrice() == rPrice) {
				index = i;
				break;
			}	
		}
		return index;
	}
	private static int searchRoom(String rName, List<Room> list) {
		int index = -1;
		for(int i = 0; i < list.size(); i++) {
//			list.get(i).getrName() => 리스트내에 방이름
			if(list.get(i).getrName().equals(rName)) {
				index = i;
				break;
			}	
		}
		return index;
	}
	
	private static void inforCustomer(List<Room> list) {
		try {
			int sel = inpuM("예약자 정보를 원하시는 방 호실을 입력하세요 : ");
			System.out.println(sel+"호실의 예약자명 : " + list.get(findRoom(sel,list)).getCustomer() + ", 예약코드 : " + list.get(findRoom(sel,list)).getRevCode() + " 입니다.");
		}catch(Exception e){
			System.out.println("방 호실을 제대로 입력하세요");
			scan.nextLine();
		}
	}

	private static void cancelRoom(List<Room> list) {
		try {
			int sel = inpuM("예약취소 하고자 하는 방 호실을 입력하세요 : ");
			if(list.get(findRoom(sel,list)).isCheck() == true) {
				System.out.println(sel+"호실은 예약취소가 가능합니다.");
				System.out.println("예약자 이름을 입력하세요 : ");
				if(list.get(findRoom(sel,list)).getCustomer().equals(scan.next())) {
					System.out.println("예약 코드를 입력하세요 : ");
					if(list.get(findRoom(sel,list)).getRevCode().equals(scan.next())) {
						list.get(findRoom(sel,list)).setCheck(false);
						System.out.println(sel+"호실은 예약이 취소되었습니다.");
					}else {
						System.out.println("예약코드가 틀립니다.");
					}
					
				}else {
					System.out.println("예약자 명이 틀립니다.");
				}
					
			}else {
				System.out.println("예약이 되어있지 않아 예약취소가 불가합니다.");
			}
		}catch(Exception e){
			System.out.println("방 호실을 제대로 입력하세요");
			scan.nextLine();
		}
		
	}

	private static void revRoom(List<Room> list) {
		try {
			int sel = inpuM("예약하고자 하는 방 호실을 입력하세요 : ");
			if(list.get(findRoom(sel,list)).isCheck() == false) {
				System.out.println(sel+"호실은 예약이 가능합니다.");
				System.out.println("예약자 이름을 입력하세요 : ");
				list.get(findRoom(sel,list)).setCustomer(scan.next());
				System.out.println("예약 코드를 입력하세요(예약취소시 필요) : ");
				list.get(findRoom(sel,list)).setRevCode(scan.next());
				list.get(findRoom(sel,list)).setCheck(true);
				System.out.println(sel+"호실은 예약자 : "+list.get(findRoom(sel,list)).getCustomer()+", 예약 코드 : "+list.get(findRoom(sel,list)).getRevCode()+" 로  예약 되었습니다.");
			}else {
				System.out.println("예약이 불가합니다.");
			}
		}catch(Exception e){
			System.out.println("방 호실을 제대로 입력하세요");
			scan.nextLine();
		}
		
	}

	private static int menu() {
		System.out.println("========================================================");
		System.out.println("1. 방예약하기 2. 방 예약 취소 3. 방 전체확인/선택확인 4. 예약자 정보확인");
		System.out.println("========================================================");
		int sel;
		try {
			sel = inpuM("메뉴를 선택하세요 : ");
			return sel;
		}catch(Exception e) {
			System.out.println("메뉴를 제대로 입력하세요");
			scan.nextLine();
			return 0;
		}
	}

	private static int inpuM(String string) {
		System.out.println(string);
		try{
			int r = scan.nextInt();
			return r;
		}catch(Exception e) {
			System.out.println("숫자로 입력하세요");
			scan.nextLine();
			return 0;
		}
		
	}

	private static void printRoom(List<Room> list) {
		try {
			int sel = inpuM("1. 전체호실 확인 2. 선택호실 확인");
		
			if(sel == 1) {
				for(Room r : list) {
					System.out.println(r);
				}
			}else if(sel == 2) {
				int r = inpuM("확인하실 룸의 호실을 입력하세요 : ");
				System.out.println(list.get(r-101));
			}else {
				System.out.println("메뉴를 제대로 입력하세요");
			}
		}catch(Exception e) {
			System.out.println("메뉴를 제대로 입력하세요");
			scan.nextLine();
		}
	}

	private static List init() {
		// TODO Auto-generated method stub
		List<Room> list = new ArrayList<>();
		String fileName = "roomInfor.txt";
		BufferedReader br;
		Room r;
		try {
			br = new BufferedReader(new FileReader(fileName));
			while(true) {
				String data = br.readLine();
				if(data==null)
					break;
				String[] tmp = data.split(", ");
				r = new Room(Integer.parseInt(tmp[0]),tmp[1],Integer.parseInt(tmp[2]),tmp[3]);
				list.add(r);
			}		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return list;
	}
}
