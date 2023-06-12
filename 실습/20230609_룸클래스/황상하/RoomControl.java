package kr.co.dong.room;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomControl {
	static Scanner scan = new Scanner(System.in);
	static int sel = 0;

	public static void main(String[] args) {

		// 호텔룸(5개)의 정보를 보관 -> List
		List<Room> rList = new ArrayList<Room>();
		List<Reserve> revList = new ArrayList<Reserve>();
		boolean power = false;
		String revName = null;
		int revNo = 0;

		// 호텔의 룸 정보를 초기화하고 저장
		init(rList);
		while (!power) {
			sel = menu();

			switch (sel) {
			case 1: // 방예약하기
				revRoom(revList, rList);
				break;
			case 2: // 방예약취소
				canRoom(revList, rList);
				break;
			case 3: // 방 전체확인 / 선택 확인
				printRoom(rList);
				break;
			case 4: // 예약자 정보 확인
				printRev(revList);
				break;
			case 99: // 종료
				power = true;
				break;
			default:

			}
		}
	}

	// 방 예약
	private static void revRoom(List<Reserve> revList, List<Room> rList) {
		for (int i = 0; i < rList.size(); i++) {
			System.out.println(i + 1 + ". " + rList.get(i).getrNo() + "호 (" + rList.get(i).isrCheck() + ")");
		}
		sel = inputMD("예약할 방을 선택해주세요");
		if ((rList.get(sel - 1).isrCheck()).equals("예약가능")) {
			revList.add(new Reserve(rList.get(sel - 1).getrNo(), inputMS("예약자 이름 입력"), inputMD("예약자 코드 설정")));
			rList.get(sel - 1).setrCheck(true);
		} else {
			System.out.println("이미 예약된 방입니다.");
		}

	}

	// 예약 취소
	private static void canRoom(List<Reserve> revList, List<Room> rList) {
		int revCode = inputMD("예약코드를 입력해주세요");
		int count = 0; // 등록되지 않은 예약코드 메시지 출력용
		for (int i = 0; i < revList.size(); i++) {
			if (revList.get(i).getRevCode() == revCode) { // 입력한 예약코드가 존재할 시 취소진행
				System.out.println(revList.get(i));
				if (inputMS("정말 취소하시겠습니까?(Y/N)").toUpperCase().equals("Y")) {
					for (int j = 0; j < rList.size(); j++) {
						if (revList.get(i).getrNo() == rList.get(j).getrNo()) {
							rList.get(j).setrCheck(false);
						}
					}
					revList.remove(i);
					count = -1; // 예약취소시 revList사이즈가 0이될 경우 카운트와 revList 사이즈가 같아지는 것을 방지
				}
			} else { // 입력한 예약코드와 맞지않으면 카운트 증가
				count++;
			}
		}
		if (count == revList.size()) { // 전체 예약리스트와 비교를 끝냈을때 입력한 예약코드가 없을시
			System.out.println("등록되지않은 예약코드입니다.");
		}
	}

	// 방 상태확인
	private static void printRoom(List<Room> rList) {
		System.out.println("1. 전체호실 확인 2. 선택호실확인");
		sel = inputMD("메뉴를 선택해주세요");

		if (sel == 1) {
			System.out.println("===========================================");
			for (Room r : rList) {
				System.out.println(r);
			}
			System.out.println("===========================================");
		} else if (sel == 2) {
			for (int i = 0; i < rList.size(); i++) {
				System.out.println(i + 1 + ". " + rList.get(i).getrNo() + "호");
			}
			System.out.println(rList.get(inputMD("방을 선택해주세요") - 1));

		}

	}

	// 예약정보 확인
	private static void printRev(List<Reserve> revList) {
		for (Reserve r : revList) {
			System.out.println(r);
		}
	}

	private static int inputMD(String msg) { // 인풋메세지 리턴:int
		System.out.print(msg + " : ");
		return scan.nextInt();
	}

	private static String inputMS(String msg) { // 인풋메세지 리턴:String
		System.out.print(msg + " : ");
		return scan.next();
	}

	private static int menu() {
		System.out.println("1. 방예약 2. 방취소 3. 방정보확인 4. 예약자확인 99. 종료");
		return inputMD("메뉴를 선택해주세요");
	}

	private static void init(List<Room> rList) {
		rList.add(new Room(101, "일반", 20000, "최대인원 2명"));
		rList.add(new Room(102, "스위트", 30000, "최대인원 2명"));
		rList.add(new Room(103, "프리미엄", 40000, "최대인원 2명"));
		rList.add(new Room(104, "패밀리", 50000, "최대인원 4명"));
		rList.add(new Room(105, "프레지던트", 60000, "최대인원 6명"));
	}
}
