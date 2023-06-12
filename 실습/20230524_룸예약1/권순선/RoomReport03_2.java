package kss.co.kr.array;

import java.util.Scanner;

public class RoomReport03_2 {
	public static void main(String[] args) {

		boolean moon = false;

		Scanner sc = new Scanner(System.in);
		String[] roomName = { "일반룸", "일반룸", "일반룸", "일반룸", "PC룸", "PC룸", "영화룸", "영화룸", "vip스위트룸", "vip스위트룸", "vvip룸",
				"vvip룸" };
		String[] name2 = new String[12];
		String name = null;
		String roomName2 = null;
		String id = "root";
		String pw = "1234";
		String id2 = null;
		String pw2 = null;

		int[] pay = { 20000, 20000, 20000, 20000, 40000, 40000, 60000, 60000, 80000, 80000, 100000, 100000 };
		int[] roomNum = { 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112 };
		int[] person = { 2, 2, 2, 2, 4, 4, 6, 6, 8, 8, 10, 10 };
		int[] room = new int[12];
		int[] num2 = new int[12];
		int num = 0;
		int pay2 = 0;
		int money = 0;

		while (!moon) {

			System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
			System.out.println("★☆★☆★ 객실 확인 필수必로 확인 부탁드립니다 ☆★☆★☆");
			System.out.println("★☆★☆★☆★☆★☆★☆ 카드 결제입니다 ★☆★☆★☆★☆★☆★☆");
			System.out.println("1) 방 예약");
			System.out.println("2) 객실 확인");
			System.out.println("3) 예약 취소");
			System.out.println("4) 관리자 모드");
			System.out.println("99) 종료");
			System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
			System.out.print("번호 선택 >> ");
			num = sc.nextInt();
			System.out.println();

			switch (num) {
			case 1:

				while (num != 55) {

					System.out.print("예약자 이름 >> ");
					name = sc.next();
					System.out.print("호실 번호 선택(1 ~ 12) 종료) : 55 >> ");
					num = sc.nextInt();

					if (num > 12 || num < 1) {
						System.out.println("다시 입력");
						continue;
					} else if (room[num - 1] == 1) {
						System.out.println("★ 예약되어있는 방 ★");
						continue;
					}

					if (num >= 1 && num <= 12) {
						System.out.print(roomName[num - 1] + " " + roomNum[num - 1] + "호의 금액은 " + pay[num - 1]
								+ "원 입니다 입금 하세요 >> ");
						money = sc.nextInt();
						if (money == pay[num - 1]) {
							room[num - 1] = 1;
							name2[num - 1] = name;
							num2[num - 1] = (int) (Math.random() * 100) + 1;
							System.out.println(
									name2[num - 1] + "님 " + roomName[num - 1] + " " + roomNum[num - 1] + "호 예약됨");
							System.out.println("예약 번호는 " + num2[num - 1] + "번 입니다");
						} else {
							System.out.println("금액이 맞지 않습니다 다시 입금하세요");
							continue;
						}
						System.out.println();
						break;
					}

				}

				break;

			case 2:

				for (int i = 0; i < room.length; i++) {
					if (room[i] == 0) {
						System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
						System.out.println("============== 이벤트 세일중 ==============");
						System.out.println();
						System.out.println(" " + roomNum[i] + "호 " + roomName[i] + " " + person[i] + "명 " + pay[i] + "원"
								+ " ☆ 예약 가능 ☆");
					} else if (room[i] != 0) {
						System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
						System.out.println(" ============== 이벤트 종료 ============== ");
						System.out.println();
						System.out.println(" " + roomNum[i] + "호 " + roomName[i] + " " + person[i] + "명 " + pay[i] + "원"
								+ " ★ 예약 불가 ★");
					}
					System.out.println();
				}

				break;

			case 3:

				while (num != 66) {

					System.out.println("예약자 확인");
					System.out.print("이름을 적어주세요 >> ");
					name = sc.next();
					int idx = -1; // 인덱스로 값을 가져오기 위해 -1

					for (int i = 0; i < room.length; i++) {
						if (name.equals(name2[i]) && num2[i] != 0 && room[i] == 1) {
							idx = i;
							break;
						}
					}

					if (idx != -1) {
						System.out.println(name2[idx] + "님으로 예약");
						System.out.println(roomNum[idx] + "호 " + roomName[idx] + " " + person[idx] + "명");
						System.out.println("예약 번호 " + num2[idx] + "번");
					} else {
						System.out.println("예약되지 않은 이름이거나 없습니다");
						System.out.println("다시 입력하세요");
					}

//					for (int i = 0; i < num2.length; i++) {
//						System.out.println(room[i] + " < > " + num2[i] + " < > " + name2[i]);
//					}

					System.out.print("1) 예약 취소하기, 66) 뒤로가기 >> ");
					num = sc.nextInt();

					switch (num) {
					case 1:

						System.out.print("예약 취소할 이름 >> ");
						name = sc.next();
						System.out.print("예약 취소할 예약번호 >> ");
						num = sc.nextInt();
						int idx2 = -1;

						for (int i = 0; i < room.length; i++) {
							if (name.equals(name2[i]) && num2[i] == num && room[i] == 1) {
								idx2 = i;
								break;
							}
						}

						if (idx2 != -1) {
							room[idx2] = 0;
							num2[idx2] = 0;
							name2[idx2] = null;
							System.out.println("예약 취소되었습니다");
							System.out.println(money + "원 환불됩니다");
						} else {
							System.out.println("예약되지 않은 이름이거나 예약 번호입니다");
							System.out.println("이름 및 예약 번호 다시 확인하세요");
						}

						break;

					}
				}

				break;

			case 4:

				while (num != 77) {

					System.out.println("관리자 모드를 이용하기 위한 로그인");
					System.out.print("아이디 입력 >> ");
					id2 = sc.next();
					System.out.print("비밀번호 입력 >> ");
					pw2 = sc.next();

					if (id.equals(id2) && pw.equals(pw2)) {
						System.out.println("관리자 링크 스따또");
					} else {
						System.out.println("다시 입력하세요");
						break;
					}

					System.out.println("★☆관리자님 환영합니다 번호를 선택하세요★☆");
					System.out.println("========== 1) 방 이름 변경 ==========");
					System.out.println("========== 2) 방 가격 변경 ==========");
					System.out.println("============ 77) 나가기 ============");
					System.out.print("번호 입력 >> ");
					num = sc.nextInt();

					switch (num) {
					case 1:

						while (num != 123) {

							System.out.println("방 목록입니다");
							for (int i = 0; i < room.length; i++) {
								System.out.println(i + 1 + "번 " + roomName[i]);
							}

							System.out.println("변경하시겠습니까?");
							System.out.println("1) YES, 123) NO");
							System.out.print("번호 입력 >> ");
							num = sc.nextInt();

							switch (num) {
							case 1:

								System.out.println("방 이름을 변경합니다");
								System.out.println("몇번 방을 변경하겠습니까?");
								System.out.print("방 번호 선택 >> ");
								num = sc.nextInt();
								System.out.println("변경할 방 이름을 입력하세요");
								roomName2 = sc.next();

								for (int i = 0; i < room.length; i++) {
									roomName[num - 1] = roomName2;
								}
								System.out.println(roomName[num - 1] + "으로 변경됨");

								break;

							}

						}

						break;

					case 2:

						while (num != 234) {

							System.out.println("방 가격입니다");
							for (int i = 0; i < room.length; i++) {
								System.out.println(i + 1 + "번 " + roomName[i] + " 가격" + pay[i] + "원");
							}

							System.out.println("변경하시겠습니까?");
							System.out.println("1) YES, 234) NO");
							System.out.print("번호 입력 >> ");
							num = sc.nextInt();

							switch (num) {
							case 1:

								System.out.println("방 가격을 변경합니다");
								System.out.println("몇번 방 가격을 변경하겠습니까?");
								System.out.print("방 번호 선택 >> ");
								num = sc.nextInt();
								System.out.println("변경할 방 가격을 입력하세요");
								pay2 = sc.nextInt();

								for (int i = 0; i < room.length; i++) {
									pay[num - 1] = pay2;
								}
								System.out.println(pay[num - 1] + "원으로 변경됨");

								break;

							}

						}

						break;
					}

				}

				break;

			case 99:

				moon = true;
				System.out.println("프로그램 종료");

				break;

			}

		}

	}
}
