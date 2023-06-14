package kr.co.dong.room;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomControl03 {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
//		호텔룸(5개)의 정보를 보관 -> List

		List<Room> list = new ArrayList<Room>();
		boolean stop = false;

//		호텔의 룸 정보를 초기화하고 저장
		init(list);

		while (!stop) {
			int sel = menu();

			switch (sel) {
			case 1: // 방 예약하기
				revRoom(list);
				break;
			case 2: // 방 예약취소
				cancelRoom(list);
				break;
			case 3: // 방 전체확인 / 선택확인
				printRoom(list);
				break;
			case 4: // 예약자 정보확인
				infoCheck(list);
				break;
			case 5: // 방 지우기
				removeRoom(list);
				break;
			case 6: // 방 추가하기
				addRoom(list);
				break;
			case 7: // 방 수정하기
				editRoom(list);
				break;
			default:

			}
		}
	}

	// 방 수정하는 메소드 입니당
	private static void editRoom(List<Room> list) {
		for (Room r : list) {
			System.out.println(r);
		}
		int sel = choice("수정할 호실을 입력하세요 : ");
		int per = findRoomNum(sel, list);
		if (per == -1) {
			System.out.println("없는 호실입니다.");
		} else if (sel == list.get(per).getrNo()) {
			list.get(per).setrNo(choice("새로운 호실번호을/를 입력하세요 : "));
			list.get(per).setrName(stringChoice("방 이름을 입력하세요 : "));
			list.get(per).setRprice(choice("가격을 입력하세요 : "));
			list.get(per).setrdescription(stringChoice("설명을 입력하세요 : "));
		}

	}

	// 방 추가하는 메소드 입니당
	private static void addRoom(List<Room> list) {
		int num = choice("호실을 입력하세요 : ");
		String name = stringChoice("방 이름을 입력하세요 : ");
		int price = choice("가격을 입력하세요 : ");
		String description = stringChoice("설명을 입력하세요 : ");
		list.add(new Room(num, name, price, description));
	}

	// 방 지우는 메소드 입니당
	private static void removeRoom(List<Room> list) {
		int sel = choice("지우실 호실을 입력해주세요 : ");
		System.out.println(list.size());
		int per = findRoomNum(sel, list);
		if (per == -1) {
			System.out.println("없는 호실입니다.");
		} else if (list.get(per).getrNo() == sel) {
			list.remove(per);
			System.out.println("호실을 삭제했습니다.");
			System.out.println(list.size());
		}
	}

	// 예약자 정보확인 메소드 입니당
	private static void infoCheck(List<Room> list) {
		int sel = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getCustomer() != null) {
				sel++;
				System.out.println("호실 : " + list.get(i).getrNo() + " 예약자명 : " + list.get(i).getCustomer() + " 예약번호 : "
						+ list.get(i).getRevCode());
			}
		}
		if (sel == 0) {
			System.out.println("예약한 사람이 없습니다.");
		}
	}

//	예약취소 메소드 입니당
	private static void cancelRoom(List<Room> list) {
		// TODO Auto-generated method stub
		int sel = choice("취소할 호실을/를 입력하세요 : ");
		int per = findRoomNum(sel, list);
		if (per == -1) {
			System.out.println("없는 호실입니다.");
		} else if (list.get(per).isCheck() == false) {
			System.out.println("입력하신 호실은 예약이 되어있지 않습니다.");
		} else {
			String name = stringChoice("예약자 성함을 입력하세요 : ");
			if (!list.get(per).getCustomer().equals(name)) {
				System.out.println("예약자 성함을 다시 한번 확인해주세요.");
			} else {
				String num = stringChoice("예약 코드를 입력해주세요 : ");
				if (!list.get(per).getRevCode().equals(num)) {
					System.out.println("예약 코드가 다릅니다. 다시 확인해주세요.");
				} else {
					System.out.println("예약이 취소되었습니다.");
					list.get(per).setCheck(false);
					list.get(per).setCustomer(null);
					list.get(per).setRevCode(null);
				}
			}
		}

	}

//	예약하는 메소드 입니당
	private static void revRoom(List<Room> list) {
		// TODO Auto-generated method stub
//		printRoom(list);
		for (Room r : list) {
			System.out.println(r);
		}
		boolean d = true;
		do {
			int sel = choice("원하는 호실을/를 입력하세요 : ");
			int per = findRoomNum(sel, list);

			if (per == -1) {
				System.out.println("없는 호실입니다.");
			} else if (list.get(per).isCheck() == true) {
				System.out.println("해당 호실은 이미 예약되었습니다.");
			} else {
				String name = stringChoice("예약자 성함을 입력해주세요 : ");
				list.get(per).setCustomer(name);
				int num = 0;
				for (int i = 0; i < 1; i++) {
					num = (int) (Math.random() * 3) + 1;
					for (int j = 0; j < list.size(); j++) {
						if ((num+"").equals(list.get(j).getRevCode())) {
							i--;
						}
					}
				}
				list.get(per).setRevCode(num + "");
				System.out.println("예약코드 : " + num);
				System.out.println("예약이 완료되었습니다.");
				list.get(per).setCheck(true);
				d = false;
			}
		} while (d);
	}

	// 방 전체확인 메소드입니당
	private static void printRoom(List<Room> list) {
		// TODO Auto-generated method stub
		System.out.println("1.전체호실확인 2.선택호실확인");
		int sel = choice("원하는 번호를 입력하세요 : ");
		if (sel == 1) {
			for (Room r : list) {
				System.out.println(r);
			}
		} else if (sel == 2) {
			sel = choice("확인하실 호실을/를 입력하세요 : ");
			int per = findRoomNum(sel, list);
			if (per == -1) {
				System.out.println("없는 호실입니다.");
			} else {
				String mark = "";
				if (list.get(per).isCheck() == false) {
					mark = "예약가능";
				} else {
					mark = "예약 불가능";
				}
				System.out.println("호실 : " + list.get(per).getrNo() + " 방이름 : " + list.get(per).getrName() + " 가격 : "
						+ list.get(per).getRprice() + " 예약여부 : " + mark);
			}
		}
	}

// 	예약시 입력한 호실이 예약되었는지 확인하는 메소드 입니당
//	예약자이름으로 찾기
	private static int findRoomCus(String name, List<Room> list) {
		int index = -1;
		for (int i = 0; i < list.size(); i++) {
			if (name.equals(list.get(i).getCustomer())) {
				index = i;
				break;
			}
		}
		return index;
	}

//	방이름으로 찾기
	private static int findRoomName(String name, List<Room> list) {
		int index = -1;
		for (int i = 0; i < list.size(); i++) {
//			list.get(i).getrName()	=> 리스트내에 방이름
			if (name.equals(list.get(i).getrName())) {
				index = i;
				break;
//				return index;
			}
		}
		return index;
	}

//	방번호로 찾기
	private static int findRoomNum(int num, List<Room> list) {
		int index = -1;
		for (int i = 0; i < list.size(); i++) {
			if (num == list.get(i).getrNo()) {
				index = i;
				break;
			}
		}
		return index;
	}

//	msg 받으면 int.scan으로 반환
	private static int choice(String msg) {
		System.out.println(msg);
		return scan.nextInt();
	}

//	msg 받으면 String.scan으로 반환
	private static String stringChoice(String msg) {
		System.out.println(msg);
		return scan.next();
	}

	private static int menu() {
		// TODO Auto-generated method stub
		System.out.println("=====호텔 메뉴=====");
		System.out.println("1.예약하기 2.예약취소 3.예약여부확인 4.예약자정보확인 5.방 지우기 6.방 추가하기 7.방 수정하기");
		return choice("원하는 번호를 입력하세요 : ");
	}

	private static void init(List<Room> list) {
		// TODO Auto-generated method stub
		Room r1 = new Room(101, "소나무", 20000, "침대1개");
		Room r2 = new Room(102, "참나무", 20000, "침대1개");
		Room r3 = new Room(103, "동백나무", 40000, "침대2개");
		Room r4 = new Room(104, "벚나무", 40000, "침대2개");
		Room r5 = new Room(105, "은행나무", 50000, "침대3개");
//		방 저장
		list.add(r1);
		list.add(r2);
		list.add(r3);
		list.add(r4);
		list.add(r5);
	}

}
