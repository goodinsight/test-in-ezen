package kr.co.dong.room;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomControl3 {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
//		호텔룸(5개)의 정보를 보관 -> List		
		List<Room> list = new ArrayList<Room>(5);

		
		
		boolean stop = false;		
		init(list); // 참조형 list 주소를 던져주고 초기화 해서 받음 (리턴 필요없음-참조형은 아무데나 수정가능하니)
		
//		구동 부분
		while(!stop) {
			int sel = menu();
			
			switch(sel) {
			case 1:    // 방 예약
				revRoom(list);
				break;
			case 2:    // 방 예약 취소
				cancelRoom(list);
				break;
			case 3:    // 방 전체 확인, 선택확인
				printRoom(list);
				break;
			case 4:    // 예약자 정보 확인
				checkRoom(list);
				break;
			case 5:    // 예약자 정보 확인
				managerRoom(list);
				break;
			case 6:    // 종료
				System.out.println("프로그램이 종료됩니다.");
				stop = true;
				break;
			default:
				System.out.println("잘못선택하셨습니다. \n");
			}
		}
	}

	private static void managerRoom(List<Room> list) {
		// 각요소의 이름 변경, 가격변경, 예약자명 변경, 등등 변경하는 class
		// 매출 통계
		// 관리자 로그인
		// 비밀번호 변경
		//
		boolean manageOnOff = false;

		String value = null;
		int changeValue = 0;
		
		while(!manageOnOff) {
			
			int mangaeMenunum = manageMenu();
			
			switch (mangaeMenunum) {

			case 1:
				boolean OnOff = false;
				while(!OnOff) {
					System.out.println("변경할 값을 넣어주세요 1. 방호수 2.방이름 3. 예약자명 4. 종료");
					changeValue = scan.nextInt();
					
						switch (changeValue) {
						case 1: // 방호수					
							value = "방호수"; // int
							changeValue(value, list);
							break;						
						case 2: // 방이름
							value = "방이름"; // String
							changeValue(value, list);
							break;
						case 3: // 예약자명
							value = "예약자명"; // int
							changeValue(value, list);
							break;
						case 4: // 종료
							System.out.println("변경모드를 종료합니다. ");
							OnOff = true;
							break;
						default:
							System.out.println("알수없는 명령어 입니다. 다시 부탁드립니다. ");
							break;
					}
				}
				break;
			case 2:
				calSales(list);
				break;
			case 3:
				changePass(list);
				break;
			case 4:
				manageOnOff = true;
				break;
			default:
				System.out.println("잘못선택하셨습니다. \n");
				
				break;
			}
		}	
	}
	

//	관리자모드 제어 부분 start
	private static void changeValue(String value, List<Room> list) {
		String baseTmp = null;
		String changeTmp = null;
		String resultTmp = null;
		
		System.out.println("기존의 값을 입력해주세요 >");
		baseTmp = scan.next();
//		값 스티리밍
		System.out.println("변경하고 싶은 것으로 입력해주세요 >");	
		changeTmp = scan.next();
		
		if(value.equals("방호수")) {
			resultTmp = findIndexRoomNum(list, baseTmp); // 룸번호로 인덱스 찾기
			int idx = Integer.parseInt(resultTmp);	
			list.get(idx).setrNo(Integer.parseInt(changeTmp));
		}
		if(value.equals("방이름")) {
			int idx = findIndexRName(list, baseTmp); // 룸번호로 인덱스 찾기
			list.get(idx).setrName(changeTmp);
		}
		if(value.equals("예약자명")) {
			int idx = findIndexName(list, baseTmp); // 룸번호로 인덱스 찾기
			System.out.println(idx);
			list.get(idx).setCustomer(changeTmp);
		}
		

		
		System.out.printf("방번호가 %s에서 %s로 변경되었습니다. ",baseTmp, changeTmp );
		
	}
	private static void calSales(List<Room> list) {
		// 매출 계산할 것(별도 list 제작해서 들어올마다 일자 및 매출 내역 반영할 것)
		// 입력된 것들의 일 매출액,월매출액등을 확인하기 위한 간단한 sum 기능 
		
	}
	private static void changePass(List<Room> list) {
		// 관리자 패스워드 변경 이전에 작업 안해봤어니 해볼것
		
	}

//	관리자모드 제어 부분 end
	
	public static boolean isNumeric(String str) {
	    return str.matches("\\d+");
	}
	
	
	private static int manageMenu() {
	System.out.println("관리자 모드에 들어 오셨습니다. ");
	System.out.println("1. 이름 및 값 변경");
	System.out.println("2. 매출 통계");
	System.out.println("3. 관리자 비밀번호 변경");
	System.out.println("4. 관리자모드 종료");
	return scan.nextInt();
	}

	private static void revRoom(List<Room> list) {
		System.out.println("예약하고 싶은 방을 선택해 주세요 >");
		System.out.println("예약 가능한 룸입니다.>");
		for(Room r:list) {
			if(r.getCheck()==false) {
			System.out.print(r.getrNo() + "호  ");
			}
		}
		int selRoom = scan.nextInt(); // 방호수 선택   // 입력값이 한글이면 다시 입력 받기
		
		
//		if(입력값이 ture 바뀌어 있는 인덱의 방번호랑 같으면 )
//		else(다시입력)
//		check 가능방 번호 
		int count =0;
		
		List<Integer> tmpList = new ArrayList<>(); // 임시로 예약가능한 호실을 저장함
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getCheck() == false) {
				tmpList.add(list.get(i).getrNo());
			}
		}
		
		if(tmpList.contains(selRoom)) { // 입력값 이외의 것이 
	
			int start = 0; //리스트 시작 index
			int end = list.size()-1; //리스트 마지막 index
			if( selRoom>= list.get(start).getrNo() && selRoom <= list.get(end).getrNo()) {
			
				System.out.printf("%d 호를 선택하셨습니다. 이름을 입력해 주세요 >",selRoom);
				
				String tmpStr2 = Integer.toString(selRoom);
				String idx = findIndexRoomNum(list, tmpStr2); // 룸번호로 인덱스 찾기
				int idx1= Integer.parseInt(idx);
				String tmpStr = scan.next(); // 예약지 이름 넣기
				list.get(idx1).setCustomer(tmpStr);
				// 예약번호 생성 = room 번호 + 1004
				list.get(idx1).setRevCode((Integer.toString(selRoom)+ "1004")); 
		
				System.out.printf("%s님 예약번호는 %s 입니다. 잘기억하셔요. \n", list.get(idx1).getCustomer(), list.get(idx1).getRevCode() );
				System.out.println("감사합니다. \n");
				list.get(idx1).setCheck(true); // true 예약된 방, false 빈방
			} else {
				System.out.println("예약 가능한 룸번호가 아닙니다. 다시 메뉴를 선택해주세요. \n");
			}
		} else {
			System.out.println("입력한 호실은 예약가능하지 않습니다. ");
		}
			
			
	}
	private static void cancelRoom(List<Room> list) {
		System.out.println("취소하기 싶은 방번호를 적어주세요>");

		int selRoom = scan.nextInt();		
		String tmpStr2 = Integer.toString(selRoom);
		String idx2 = findIndexRoomNum(list, tmpStr2); // 룸번호로 인덱스 찾기
		int idx1 = Integer.parseInt(idx2);
		if(list.get(idx1).getCheck() == true) {  		
			System.out.println("이름 ID, 패스워드 : 예약번호 입니다.");
			System.out.println("ID(이름)을 적어주세요 >");
			String name = scan.next();
			System.out.println("패스워드(예약번호)를 적어주세요 >");
			String resNum = scan.next();
			if( (list.get(idx1).getCustomer().equals(name)) && (list.get(idx1).getRevCode().equals(resNum)) ) {
				System.out.println("정상적으로 예약취소 되었습니다. \n");
				list.get(idx1).setCheck(false);		
				list.get(idx1).setCustomer(null);
				list.get(idx1).setRevCode(null);
			} else {
				System.out.println("아이디와 이름이 맞지 않습니다. 다시부탁드립니다. ");
			}	
		} else {
			System.out.println("예약 취소가 가능한 룸번호가 아닙니다. 다시 메뉴를 선택해주세요. \n");
		}
	}
	
	private static void checkRoom(List<Room> list) {
		System.out.println("예약여부를 확인하겠습니다. ");
		System.out.println("이름을 입력해 주세요");
		System.out.println("입력 >");
		String nameName = scan.next();
		
//		인덱스 추출 // 고객이름으로 인덱스 추출
		int idx = findIndexName(list, nameName);
			System.out.println("정보를 확인하였습니다. ");
			System.out.println("고객님의 예약된 내역입니다. ");
			System.out.println("고객명 : " + list.get(idx).getCustomer());
			System.out.println("객실호수 : " + list.get(idx).getrNo());
			System.out.println("결재액 : " + list.get(idx).getrPrice());
	}
	
// 강사님 방법
//	int findRoom(String name, List<Room> list ) {
//	int index = -1;
//		
//		for(int i = 0; i<list.size(); i++) {
////			list.get(i).getName() => 리스트내에 방이름
//			if(name.equals(list.get(i).getrName())) {
//				index = i;
//				break;
//				return index;
//			}
//		}
//	}
	
	private static String findIndexRoomNum(List<Room> list, String selRoom) {
		int idx = -1;
		String returnStr = null;
		
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getrNo() == Integer.parseInt(selRoom))
				idx = i;
        	}
		returnStr = Integer.toString(idx);
		return returnStr;
	}
	
	private static int findIndexName(List<Room> list, String str) {
		int idx = -1; 
		
        for (int i = 0; i < list.size(); i++) {
//        	System.out.println(list.get(i).getCustomer());
            if(list.get(i).getCustomer().equals(str)) {
            	idx = i;
            	System.out.println(idx);
     
            	break;
            }
        }
		return idx;
	}
	
	private static int findIndexRName(List<Room> list, String str) {
		int idx = -1; 	
		
        for (int i = 0; i < list.size(); i++) {
        	System.out.println(list.get(i).getrName());
            if(list.get(i).getrName().equals(str)) {
            	idx = i;
            	break;
            }
        }

		return idx;
	}
		
	private static int menu() {
		System.out.println("매뉴를 선택하세요");
		System.out.println("1. 방예약 ");
		System.out.println("2. 방예약 취소" );
		System.out.println("3. 방예약 확인(1.전체호실확인 2.선택호실확인)" );
		System.out.println("4. 예약정보 확인");
		System.out.println("5. 관리자모드");
		System.out.println("6. 프로그램 종료");
		
		return scan.nextInt();
	}

	private static void printRoom(List<Room> list) {
		System.out.println("1. 전체호실확인 2. 선택호실 확인");
		int sel = scan.nextInt();
		
		if(sel == 1) {
			for(Room r:list) {
				System.out.println(r);
			}
		} else if(sel==2) {
			System.out.println("원하는 호실을 입력하세요");
			int selTemp = scan.nextInt();
			selTemp = (selTemp % 100) -1;
			System.out.println(list.get(selTemp));
		}
		
	}
	
	private static void init(List<Room> list) { //나중에 다 분리
//		호텔의 룸 정보를 초기화
		Room r1 = new Room(101, "소나무", 20000, "행복 사는 방", "김");
		Room r2 = new Room(102, "참나무", 20000, "사랑 사는 방", "김");
		Room r3 = new Room(103, "동백나무", 20000, " 즐거운사는 방", "김");
		Room r4 = new Room(104, "벗나무", 20000, "이상한 사는 방", "김");
		Room r5 = new Room(105, "은행나무", 20000, "그냥 사는 방", "김");
		
//		방저장
		list.add(r1);
		list.add(r2);
		list.add(r3);
		list.add(r4);
		list.add(r5);
	}
}
