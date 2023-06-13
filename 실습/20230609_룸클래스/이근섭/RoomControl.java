package kr.co.dong.room;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomControl {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		List<Room> list = new ArrayList<>();
		boolean done = false;
		boolean stop = false;
		Customer customer = null;
		LogIn login = null;
		
//		호텔의 룸 정보를 초기화하고 저장
		list = init();
		
		main:
		while (true) {

//			회원가입 및 로그인 메뉴
			while (!done) {
				login = new LogIn();
				int select = login.showLogin();
				switch (select) {
				case 1:
					// 처음 방문시 회원가입
					int tmp = login.showSetMenu();
					if (tmp == 1) {
						customer = login.setCustomer(customer); 
						login.saveCustomer(customer);	// 초기화 직접 회원가입하여 생성
						done = true;
						stop = false;
					}
					if (tmp == 2) {
						done = true;
						break main; // 프로그램 완전 종료
					}
					break;
				case 2:
					// 기존 회원시 로그인하기
					customer = login.logIn(customer);
					if (customer.getId() != null && customer.getPassword() != null) {
						done = true;
						stop = false;
					}
					break;
				case 3:
					// 아이디 비번 찾기
					login.findCustomer();
					break;
				default:
					break;
				}
			} // 로그인 메뉴 끝

//			메인 roomcontrol
			while (!stop) {
				int sel = menu();

				switch (sel) {
				case 1: // 방 예약하기
					revRoom(list, customer);
					break;
				case 2: // 방 예약 취소
					cancelRoom(list, customer);
					break;
				case 3: // 방 전체확인 / 선택확인
					printRoom(list);
					break;
				case 4: // 예약자 정보확인
					inforCustomer(list);
					break;
				case 5:
					System.out.println("로그아웃되었습니다.");
					stop = true;
					done = false;
					break;
				default:
					break;
				}
			} // roomcontrol 끝
		}
		System.out.println("프로그램을 종료합니다.");
	}

	private static int findRoom(int rNumber, List<Room> list) {
		int index = -1;
		for (int i = 0; i < list.size(); i++) {
//			list.get(i).getrName() => 리스트내에 방이름
			if (list.get(i).getrNumber() == rNumber) {
				index = i;
				break;
			}
		}
		return index;
	}

	private static void inforCustomer(List<Room> list) {
		try {
			int sel = inputM("예약자 정보를 원하시는 방 호실을 입력하세요 : ");
			System.out.println(sel + "호실의 예약자명 : " + list.get(findRoom(sel, list)).getCustomer() + ", 예약코드 : "
					+ list.get(findRoom(sel, list)).getRevCode() + " 입니다.");
		} catch (Exception e) {
			System.out.println("방 호실을 제대로 입력하세요");
			scan.nextLine();
		}
	}

	private static void cancelRoom(List<Room> list, Customer customer) {
		try {
			int sel = inputM("예약취소 하고자 하는 방 호실을 입력하세요 : ");
			if (list.get(findRoom(sel, list)).isCheck() == true) {
				System.out.println(sel + "호실은 예약취소가 가능합니다.");
				System.out.println("예약 코드를 입력하세요 : ");
				if (list.get(findRoom(sel, list)).getRevCode().equals(scan.next())) {
					list.get(findRoom(sel, list)).setCheck(false);
					list.get(findRoom(sel, list)).setCustomer(null);
					list.get(findRoom(sel, list)).setRevCode(null);
					System.out.println(sel + "호실은 예약이 취소되었습니다.");
					cancelResevation(sel, list, customer);
				} else {
					System.out.println("예약코드가 틀립니다.");
				}

			} else {
				System.out.println("예약이 되어있지 않아 예약취소가 불가합니다.");
			}
		} catch (Exception e) {
			System.out.println("방 호실을 제대로 입력하세요");
			scan.nextLine();
		}
	}

	private static void revRoom(List<Room> list, Customer customer) {
		try {
			int sel = inputM("예약하고자 하는 방 호실을 입력하세요 : ");
			if (list.get(findRoom(sel, list)).isCheck() == false) {
				System.out.println(sel + "호실은 예약이 가능합니다.");
				list.get(findRoom(sel, list)).setCustomer(customer.getName());
				list.get(findRoom(sel, list)).setRevCode(customer.getCode());
				list.get(findRoom(sel, list)).setCheck(true);
				System.out.println(sel + "호실은 예약자 : " + list.get(findRoom(sel, list)).getCustomer() + ", 예약 코드(민증번호) : "
						+ list.get(findRoom(sel, list)).getRevCode() + " 로  예약 되었습니다.");
				saveResevation(sel, list, customer);
			} else {
				System.out.println("예약이 불가합니다.");
			}
		} catch (Exception e) {
			System.out.println("방 호실을 제대로 입력하세요");
			scan.nextLine();
		}
	}

	private static int menu() {
		System.out.println("========================================================");
		System.out.println("1. 방예약하기 2. 방 예약 취소 3. 방 전체확인/선택확인 4. 예약자 정보확인 5.로그아웃");
		System.out.println("========================================================");
		int sel;
		try {
			sel = inputM("메뉴를 선택하세요 : ");
			return sel;
		} catch (Exception e) {
			System.out.println("메뉴를 제대로 입력하세요");
			scan.nextLine();
			return 0;
		}
	}

	private static int inputM(String string) {
		System.out.println(string);
		try {
			int r = scan.nextInt();
			return r;
		} catch (Exception e) {
			System.out.println("숫자로 입력하세요");
			scan.nextLine();
			return 0;
		}
	}

	private static void printRoom(List<Room> list) {
		try {
			int sel = inputM("1. 전체호실 확인 2. 선택호실 확인");

			if (sel == 1) {
				for (Room rm : list) {
					System.out.println(rm);
				}
			} else if (sel == 2) {
				int r = inputM("확인하실 룸의 호실을 입력하세요 : ");
				System.out.println(list.get(findRoom(r, list)));
			} else {
				System.out.println("메뉴를 제대로 입력하세요");
			}
		} catch (Exception e) {
			System.out.println("메뉴를 제대로 입력하세요");
			scan.nextLine();
		}
	}

	private static List<Room> init() {
		// 파일에서 룸 정보 불러와서 초기 세팅하기
		List<Room> list = new ArrayList<>();
		String fileName = "roomInfor.txt";
		BufferedReader br;
		Room r;
		try {
			br = new BufferedReader(new FileReader(fileName));
			while (true) {
				String data = br.readLine();
				if (data == null)
					break;
				String[] tmp = data.split(", ");
				r = new Room(Integer.parseInt(tmp[0]), tmp[1], Integer.parseInt(tmp[2]), tmp[3]);
				list.add(r);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return list;
	}

	private static void saveResevation(int sel, List<Room> list, Customer customer) {
		// 예약한 방 정보를 파일에 저장하기
		String fileName = "reservation.txt";
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(fileName, true));
			bw.write("다음 방을 예약하였습니다.");
			bw.write("예약방이름 : " + list.get(findRoom(sel, list)).getrName() + ", ");
			bw.write("예약고객ID : " + customer.getId() + ", ");
			bw.write("예약고객명 : " + customer.getName() + ", ");
			bw.newLine();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void cancelResevation(int sel, List<Room> list, Customer customer) {
		// 취소한 방 정보를 파일에 저장하기
		String fileName = "reservation.txt";
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(fileName, true));
			bw.write("다음 방을 취소하였습니다.");
			bw.write("예약방이름 : " + list.get(findRoom(sel, list)).getrName() + ", ");
			bw.write("예약고객ID : " + customer.getId() + ", ");
			bw.write("예약고객명 : " + customer.getName() + ", ");
			bw.newLine();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
