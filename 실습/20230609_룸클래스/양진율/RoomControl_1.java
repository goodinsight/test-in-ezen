package kr.co.dong.room;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RoomControl_1 {
	
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
//		호텔룸(5개)의 정보를 보관 -> List
		
		Map<Integer, Room> roomMap = new HashMap<Integer, Room>();
//		key: 객실번호, value: 객실정보
		
		Map<Integer, Reservation> revMap = new HashMap<Integer, Reservation>();
//		key: 객실번호, value : 예약 정보
		
		Map<String, ArrayList<Integer>> revInfo = new HashMap<String, ArrayList<Integer>>();
//		key: 예약자이름 + " " + 예약번호, value : 객실번호
		
		boolean stop = false;
		
		init(roomMap, "room.txt");
		
		int mode = 0;
		
		while(!stop) {
			
			switch(mode) {
				case 0: // 초기 메뉴
					mode = menu();
					break;
				case 1: // 방 예약
					revRoom(roomMap, revMap, revInfo);
					mode = 0;
					break;
				case 2: // 방 예약 취소
					cancelRoom(roomMap, revMap, revInfo);
					mode = 0;
					break;
				case 3:	// 방 전체확인/ 선택확인
					printRoom(roomMap);
					mode = 0;
					break;
				case 4: // 예약정보 확인
					printRevInfo(roomMap, revInfo);
					mode = 0;
					break;
				case 99: // 종료
					stop = true;
					break;
				default: 
					System.out.println("잘못된 입력입니다.");
					mode = 0;
			}
			
		}
		
	}






	private static int inputInt(String string) {
		
		boolean flag = true;
		int input = 0;
		while(flag) {
			try {
				System.out.print(string + "\n>>");
				input = scan.nextInt();				
				flag = false;
			} catch (Exception e) {
				System.out.println("잘못된 입력입니다.");
				scan.next();
			}
		}
		
		return input;
	}
	
	private static int inputInt(String string, int range, boolean cancel) {
		
		boolean flag = true;
		int input = 0;
		while(flag) {
			try {
				System.out.print(string + "\n>>");
				input = scan.nextInt();	
				
				if((input >= 1 && input <= range)||(cancel && input == 99)) {
					flag = false;
				}else {
					System.out.println("잘못된 입력입니다.");
				}
				
			} catch (Exception e) {
				System.out.println("잘못된 입력입니다.");
				scan.next();
			}
		}
		
		return input;
	}

	private static String inputStr(String string) {

		System.out.print(string + "\n>>");
		String input = scan.nextLine();
		scan.next();
		
		return input;
	}

	private static int menu() {
		
		return inputInt("\n입력 안내\n"
				+ "1\t: 예약\n"
				+ "2\t: 예약 취소\n"
				+ "3\t: 객실 확인\n"
				+ "4\t: 예약정보 확인\n"
				+ "99\t: 종료");
	}

	private static void revRoom(Map<Integer, Room> roomMap, Map<Integer, Reservation> revMap, Map<String, ArrayList<Integer>> revInfo) {
		
		int roomNo = inputInt("\n예약하시고 싶은 객실 번호를 입력해주세요.");
		
		if(!roomMap.containsKey(roomNo)) {
			System.out.println("해당하는 번호의 객실이 없습니다.");
		}else if(roomMap.get(roomNo).isrCheck()) {
			System.out.println("이미 예약되어있는 객실입니다.");
		}else {
			System.out.println(roomMap.get(roomNo));
			int sel = inputInt("해당 객실을 예약하시겠습니까? (1 : yes, 2 : no)", 2, false);
			
			if(sel == 1) {
			
				String cName = inputStr("예약자 명을 입력해주세요.");
				String rCode = inputStr("예약 번호를 입력해주세요.");
				
				roomMap.get(roomNo).setrCheck(true);
				revMap.put(roomNo, new Reservation(roomNo, cName, rCode));
				
				String tmp = cName + " " + rCode;
				if(!revInfo.containsKey(tmp)) revInfo.put(tmp, new ArrayList<Integer>());
				revInfo.get(tmp).add(roomNo);
			}
			
		}
		
	}	
	


	private static void cancelRoom(Map<Integer, Room> roomMap, Map<Integer, Reservation> revMap, Map<String, ArrayList<Integer>> revInfo) {
		
		String cName = inputStr("예약자 명을 입력해주세요.");
		String rCode = inputStr("예약 번호를 입력해주세요.");
		
		String tmp = cName + " " + rCode;
		
		if(!revInfo.containsKey(tmp)) {
			System.out.println("해당하는 예약자가 없거나 예약 번호가 일치하지 않습니다.");
		}else {
			
			List<Integer> removeList = new ArrayList<Integer>();
			
			for(Integer rNo : revInfo.get(tmp)) {
				System.out.println(roomMap.get(rNo));
				
				int sel = inputInt("해당 객실의 예약을 취소하시겠습니까? (1 : yes, 2: no)", 2, false);
				if(sel == 1) {
					removeList.add(rNo);
					
					revMap.remove(rNo);
					roomMap.get(rNo).setrCheck(false);
					System.out.println("예약이 취소되었습니다.");
				}
			}
			
			for(Integer rNo : removeList) {
				revInfo.get(tmp).remove(rNo);
			}
			
			if(revInfo.get(tmp).size() == 0) {
				revInfo.remove(tmp);
			}
			
		}
		
	}

	private static void printRoom(Map<Integer, Room> map) {
		
		int sel = inputInt("1. 전체 객실 확인 \n"
				+ "2. 선택한 객실 확인\n"
				+ "3. 예약되어있는 객실 확인\n"
				+ "4. 예약되어있지 않은 객실 확인\n"
				+ "확인하시고 싶은 유형의 번호를 입력해주세요.", 4, false);
	
		if(sel == 1) {
			for(Integer key : map.keySet()) {
				System.out.println(map.get(key));
			}
		}else if(sel == 2) {
			System.out.println(map.get(inputInt("확인하시고 싶은 객실의 번호를 입력해주세요.")));
			
		}else {
			boolean notflag = false;
			if(sel == 4) notflag = true;
			
			for(Integer key : map.keySet()) {
				if(notflag^map.get(key).isrCheck()) {
					System.out.println(map.get(key));
				}
			}
		}
		
		
	}
	
	

	private static void printRevInfo(Map<Integer, Room> roomMap, Map<String, ArrayList<Integer>> revInfo) {
		
		String cName = inputStr("예약자 명을 입력해주세요.");
		String rCode = inputStr("예약 번호를 입력해주세요.");
		
		String tmp = cName + " " + rCode;
		
		if(!revInfo.containsKey(tmp)) {
			System.out.println("해당하는 예약자가 없거나 예약 번호가 일치하지 않습니다.");
		}else {
			System.out.println("현재 고객님이 예약중이신 객실은 다음과 같습니다.");
			for(Integer rNo : revInfo.get(tmp)) {
				System.out.println(roomMap.get(rNo));
			}
		}
		
		
	}

	private static void init(Map<Integer, Room> map, String filename) {
		
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(filename));
			
			while(true) {
				String str = br.readLine();
				if(str == null) break;
				String[] strArr = str.split(", ");
				map.put(Integer.valueOf(strArr[0]), new Room(Integer.valueOf(strArr[0]), strArr[1], Integer.valueOf(strArr[2]), strArr[3]));
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
}
