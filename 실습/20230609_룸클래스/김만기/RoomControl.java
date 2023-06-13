package kr.co.dong.room;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomControl {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
//		호텔룸(5개)의 정보를 보관 -> List
//		
		List<Room> list = new ArrayList<Room>(5);
		boolean stop = false;

//		호텔의 룸 정보를 초기화하고 저장
		init(list);
		while (!stop) {
			int sel = menu();

			switch (sel) {
			case 1: // 방 예약하기
				revRoom(list);
				break;
			case 2: // 방 예약 취소
				canselRoom(list);
				break;
			case 3: // 방 전체확인 / 선택확인
				printRoom(list);
				break;
			case 4: // 예약자 정보확인
				revInformation(list);
				break;
			case 99: // 프로그램 종료
				System.out.println("프로그램을 종료합니다.");
				stop = !stop;
				break;
			default:
				System.out.println("잘못된 입력입니다.");
			}
		}
	}

	static int findRoom(String name, List<Room> list) {
		int index = -1;

		for (int i = 0; i < list.size(); i++) {
//			list.get(i).getrName() => 리스트내에 방이름
			if (name.equals(list.get(i).getrName())) {
				index = i;
				break;
//				return index;
			}
		}
		return index;
	}

	static int findRoom(int rNo, List<Room> list) {
		int index = -1;

		for (int i = 0; i < list.size(); i++) {
			if (rNo == list.get(i).getrNo()) {
				index = i;
				break;
			}
		}
		return index;
	}

	private static void revInformation(List<Room> list) {
		System.out.println("성함을 입력해주세요.");
		String input = scan.next();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getCustomer().equals(input)) {
				System.out.println("예약번호를 입력해주세요");
				for (int j = 0; j < list.size(); j++) {
					input = scan.next();
					if (list.get(j).getRevCode().equals(input)) {
						System.out.println("예약정보입니다");
						System.out.println(list.get(j));
						return;
					} else {
						System.out.println("예약번호가 틀렸습니다.");
						return;
					}
				}
			} else {
				System.out.println("예약된 방이 없습니다.");
				return;
			}
		}
	}

	private static int menu() {
		System.out.println("메뉴");
		System.out.println("호텔 예약 프로그램");
		System.out.println("1.예약하기 2.예약취소하기 3.방전체확인/선택확인 4.예약자정보확인 99.프로그램 종료");
		return scan.nextInt();
	}

	private static void revRoom(List<Room> list) {
		int i = revOrCansel(list, "예약");
		String name = scan.next();
		list.get(i).setCustomer(name);
		String revNum = String.valueOf((int) (Math.random() * 888888) + 111111);
		list.get(i).setRevCode(revNum);
		list.get(i).setCheck(true);
		System.out.println(list.get(i) + "\n예약이 완료되었습니다");
	}

	private static void canselRoom(List<Room> list) {
		int i = revOrCansel(list, "예약취소");
		String input = scan.next();
		if (list.get(i).getCustomer().equals(input)) {
			System.out.println("예약번호를 입력해주세요.");
			input = scan.next();
			if (list.get(i).getRevCode().equals(input)) {
				System.out.println(list.get(i) + "\n예약이 취소되었습니다");
				list.get(i).setCustomer(null);
				list.get(i).setCheck(false);
			} else {
				System.out.println("예약번호가 틀렸습니다.");
			}
		} else {
			System.out.println("예약된 방이 없습니다.");
		}
	}

	private static int revOrCansel(List<Room> list, String string) {
		System.out.println(string + "하실 호실을 입력해주세요");
		int sel = scan.nextInt();
		int i = findRoom(sel, list);
		if (i > 4) {
			System.out.println("잘못된 입력입니다.");
			revOrCansel(list, string);
		} else {
			System.out.println("성함을 입력해주세요.");
		}
		return i;
	}

	private static void printRoom(List<Room> list) {
		System.out.println("1.전체호실확인 2.선택호실확인");
		int sel = scan.nextInt();

		if (sel == 1) {
			for (Room r : list) {
				System.out.println(r);
			}
		} else if (sel == 2) {
			System.out.println("호실을 선택해주세요.");
			sel = scan.nextInt();
			int i = findRoom(sel, list);
			if (i > 4) {
				System.out.println("잘못된 입력입니다.");
			} else {
				System.out.println(list.get(i));
			}

		}

	}

	private static void init(List<Room> list) {
		Room r1 = new Room(101, "좋은방", 20000, "좋은 방");
		Room r2 = new Room(102, "안좋은방", 20000, "좋지 않은 방");
		Room r3 = new Room(103, "매우좋은방", 20000, "매우 좋은 방");
		Room r4 = new Room(104, "개좋은방", 20000, "개 좋은 방");
		Room r5 = new Room(105, "짱좋은방", 20000, "짱 좋은 방");

		list.add(r1);
		list.add(r2);
		list.add(r3);
		list.add(r4);
		list.add(r5);

	}

}
