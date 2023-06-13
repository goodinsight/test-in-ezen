package kr.co.dong.roomsy;

import java.beans.Customizer;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class RoomControl04 {
	Scanner scan = new Scanner(System.in);

//	Room(int rNo, String rName, int rPrice, String rContent)
	public void init(List<Room> list) {

//		Room r1 = new Room(101, "방1", 10000, "1층방");
//		Room r2 = new Room(201, "방2", 10000, "2층방");
//		Room r3 = new Room(301, "방3", 10000, "3층방");
//		Room r4 = new Room(401, "방4", 10000, "4층방");
//		Room r5 = new Room(501, "방5", 10000, "5층방");
//
//		list.add(r1);
//		list.add(r2);
//		list.add(r3);
//		list.add(r4);
//		list.add(r5);
		
		list.add(new Room(101, "방1", 10000, "1층방"));
		list.add(new Room(201, "방2", 10000, "2층방"));
		list.add(new Room(301, "방3", 10000, "3층방"));
		list.add(new Room(401, "방4", 10000, "4층방"));
		list.add(new Room(501, "방5", 10000, "5층방"));

	}
	public void init2(List<Room> list) {
		BufferedReader br = null;
		StringTokenizer strT = null;
		
		try {
			br = new BufferedReader(new FileReader("room.txt"));
			
			while(true) {
				String str = br.readLine();		//str에 저장된 값 : room.txt에 있는 5줄 중에 한 줄 읽어줌 (101, 방1, 10000, 1층방)
				if(str == null) {
					break;
				}
				
//				한 줄 읽어서 , 콤마 분리							//strT는 한 줄에서 ,로 분리함. 101/방1/10000/1층방
				strT = new StringTokenizer(str, ",");
				
				Room r1 = new Room();
				r1.setrNo(Integer.parseInt(strT.nextToken()));
				r1.setrName(strT.nextToken().trim());
				r1.setrPrice(Integer.parseInt(strT.nextToken().trim()));
				r1.setrContent(strT.nextToken().trim());
				
				list.add(r1);
				
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

//	메뉴판 보여주는 기능
	public void printRoom() {
		System.out.println("======================================");
		System.out.println("1.방예약 2.예약취소 3.방확인 4.예약자정보확인");
		System.out.println("99.종료");
		System.out.println("======================================");
		System.out.print("번호를 입력하세요. > ");
	}

	// 3.방확인 -> 1번. 전체조회 2번. 선택조회
	public void checkRoom(List<Room> list) {
		System.out.println("==============================");
		System.out.println("1.전체 방 조회 2.선택 방 조회");
		System.out.println("==============================");
		System.out.print("번호를 선택하세요. > ");
		int sel = scan.nextInt();

		if (sel == 1) {
			for (int i = 0; i < list.size(); i++) {
				System.out.println("방 번호: " + list.get(i).getrNo() + ", 이름: " + list.get(i).getrName() + ", 가격: "
						+ list.get(i).getrPrice() + " 정보: " + list.get(i).getrContent() + " 예약여부: "
						+ list.get(i).isrCheck());
			}
		}else if(sel == 2) {
			System.out.print("조회하실 방 번호를 입력하세요.(101~501) > ");
			int rNo = scan.nextInt();
			
			int index = findRoom(list, rNo);
			System.out.println("방 번호: " + list.get(index).getrNo() + ", 이름: " + list.get(index).getrName() + 
					", 가격: " + list.get(index).getrPrice() + " 정보: " + list.get(index).getrContent() + 
					" 예약여부: "+ list.get(index).isrCheck());
		}

	}

	public void revRoom(List<Room> list) {
		System.out.print("방 호실을 입력하세요. (101~501)> ");
		int rNo = scan.nextInt();
		int index = findRoom(list, rNo);

		if (index == -1) {
			System.out.println("방 정보가 없습니다. 다시 입력하세요.");
			revRoom(list);
		} else {
			if (list.get(index).isrCheck() == true) {
				System.out.println("이미 예약된 방입니다. 다시 입력하세요.");
				revRoom(list);
			} else {
				System.out.println("예약을 진행합니다.");
				System.out.print("예약자 성함을 입력하세요. > ");
				String cName = scan.next();
				list.get(index).setCustomer(cName);

				String revNo = "20230613" + list.get(index).getrNo();
				System.out.println("예약번호는 : " + revNo + "입니다.");
				list.get(index).setRevCode(revNo);

				list.get(index).setrCheck(true);
			}
		}

	}

	public void checkCustomer(List<Room> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println("예약자 이름: " + list.get(i).getCustomer() + "예약자 예약번호 : " + list.get(i).getRevCode());
		}
	}

//	cName으로 index를 찾는 기능
	public int findRoom(List<Room> list, String cName) {
		int index = -1;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getCustomer().equals(cName)) {
				index = i;
				break;
			}
		}
		return index;
	}

//	rNo로 index 찾는 기능
	public int findRoom(List<Room> list, int rNo) {
		int index = -1;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getrNo() == rNo) {
				index = i;
				break;
			}
		}
		return index;
	}

	public void cancelRev(List<Room> list) {
		System.out.print("예약자 성함을 입력하세요. > ");
		String cName = scan.next();

		if (cName.equals(list.get(0).getCustomer())) {
			checkRevNo(list);

		} else {
			System.out.println("예약정보가 없습니다. 다시 입력하세요.");
			cancelRev(list);
		}
	}

	public void checkRevNo(List<Room> list) {
		System.out.print("예약번호를 입력하세요. > ");
		String revNo = scan.next();

		if (revNo.equals(list.get(0).getRevCode())) {
			System.out.println("예약이 취소되었습니다.");
			list.get(0).setrCheck(false);
			list.get(0).setCustomer(null);
			list.get(0).setRevCode(null);
		} else {
			System.out.println("예약정보가 없습니다. 다시 입력하세요.");
			checkRevNo(list);
		}
	}
	
	

}
