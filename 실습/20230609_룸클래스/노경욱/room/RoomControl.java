package room;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import reportt.room_V2;

public class RoomControl {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
//		호텔룸(5개)의 정보를 보관 -> List

		List<Room> list = new ArrayList<Room>();
		boolean stop = false;

//		호텔의 룸 정보를 초기화 하고 저장
		init(list);

//		호텔의 룸 정보를 초기화
		Room r1 = new Room(101, "소나무", 20000, "1가", false, "");
		Room r2 = new Room(102, "참나무", 20000, "2가", false, "");
		Room r3 = new Room(103, "동백나무", 20000, "3가", false, "");
		Room r4 = new Room(104, "벛나무", 20000, "4가", false, "");
		Room r5 = new Room(105, "은행나무", 20000, "5가", false, "");

//		방 저장
		list.add(r1);
		list.add(r2);
		list.add(r3);
		list.add(r4);
		list.add(r5);

		while (!stop) {
			int sel = menu();
			switch (sel) {
			case 0:
				System.out.println("종료합니다");
				stop = true;
			case 1: // 방예약
				roomRev(list);
				break;
			case 2: // 방 예약 취소
				censelRoom(list);
				break;
			case 3: // 방 전체 확인, 선택확인
				printRoom(list);
				break;
			case 4: // 예약자 정보 확인
				checkPeople(list);
				break;
			default:
				System.out.println("올바르지 않은 방식입니다.");
				break;
			}
		}

	}

	private static void checkPeople(List<Room> list) {
		// TODO Auto-generated method stub
		System.out.println("확인할 방번호를 입력해 주세요 (예시: 101)");
		int tmp = scan.nextInt();
		for (Room r : list) {
			if (r.getrNo() == tmp && r.isRcheck() == true) {
				System.out.println(r.getCustomer() + "님 입니다");
				break;
			} else if (r.getrNo() == tmp && r.isRcheck() == false) {
				System.out.println(r.getrNo() + "호는 예약되어있지않습니다");
			} else {
				System.out.println("올바르지 않은 방식입니다.");
			}
		}
	}

	private static void init(List<Room> list) {
		// TODO Auto-generated method stub

	}

	private static int menu() {
		// TODO Auto-generated method stub
		System.out.println("1. 방예약 2. 방 예약취소 3. 방전체확인, 선택확인, 4. 예약자 정보 확인 0. 종료");
		int sel = scan.nextInt();
		return sel;
	}

	private static void roomRev(List<Room> list) {
		// TODO Auto-generated method stub
		System.out.println("예약할 방번호입력해 주세요 (예시: 101)");
		int tmp = scan.nextInt();
		for (Room r : list) {
			if (r.getrNo() == tmp) {
				r.setrcheck(true);
				System.out.println("성명을 입력해 주세요");
				String tmp2 = scan.next();
				r.setCustomer(tmp2);
				System.out.println(r.getrNo() + "호 예약되었습니다");
				break;
			}
		}
	}

	private static void censelRoom(List<Room> list) {
		// TODO Auto-generated method stub
		System.out.println("예약취소할 방번호입력해 주세요 (예시: 101)");
		int tmp = scan.nextInt();
		for (Room r : list) {
			if (r.getrNo() == tmp && r.isRcheck() == true) {
				r.setrcheck(false);
				System.out.println(r.getrNo() + "호 예약 취소되었습니다");
				break;
			} else if (r.getrNo() == tmp && r.isRcheck() == false) {
				System.out.println(r.getrNo() + "호는 예약되어있지않습니다");
				break;
			} else {
				System.out.println("올바르지 않은 방식입니다.");
			}
		}
	}

	private static void printRoom(List<Room> list) {
		// TODO Auto-generated method stub
		System.out.println("1. 전체호실확인 2. 선택호실확인");
		int sel = scan.nextInt();

		if (sel == 1) {
			for (Room r : list) {
				System.out.println(
						r.getrNo() + "호\n이름: " + r.getrName() + "\n가격: " + r.getrPrice() + "\n특징: " + r.getrContent());
				if (r.isRcheck() == true) {
					System.out.println("예약되었습니다");
					System.out.println("예약자명: " + r.getCustomer());

				} else {
					System.out.println("예약되어있지않습니다");
				}
				System.out.println();
			}
		} else if (sel == 2) {
			System.out.print("선택할 호실을 입력해 주세요 (예시: 101)");
			int tmp = scan.nextInt();

			for (Room r : list) {
				if (r.getrNo() == tmp) {
					System.out.println(r.getrNo() + "호\n이름: " + r.getrName() + "\n가격: " + r.getrPrice() + "\n특징: "
							+ r.getrContent());
					if (r.isRcheck() == true) {
						System.out.println("예약되었습니다");
						System.out.println("예약자명: " + r.getCustomer());
						break;
					} else {
						System.out.println("예약되어있지않습니다");
						break;
					}
				}
			}
		}

	}
}
