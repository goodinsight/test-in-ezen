package reportt;

import java.util.Scanner;

public class room_V2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// 객실 규모 받기 및 생성
		System.out.println("객실 규모를 입력하세요");
		int how = scan.nextInt();
		int tmp = 0, tmp2 = 0;

		String tmp1 = "";
		int[][] room = new int[how][5]; // 0 이름 1 객실인원 2 가격 3 예약상황(예약시-1 미예약상태-0) 4 예약 번호
		String[][] roomTag = new String[how][2]; // 0 호텔특성 1 예약자명
		boolean power = true;
		boolean power2 = true;

		for (int i = 0; i < room.length; i++) {
			// 방 특성 적용, 가격 지정
			how = (int) (Math.random() * 2 + 1);
			if (how == 1) {
				roomTag[i][0] = "프리미엄";
				room[i][2] = 150000;
			} else {
				roomTag[i][0] = "일반";
				room[i][2] = 75000;
			}
			// 각각의 방 이름을 101 102 이런식으로
			room[i][0] = 100 + (i + 1);
			// 객실인원 랜덤
			how = (int) (Math.random() * 3 + 1);
			room[i][1] = how;
			// 모두 미예약으로
			room[i][3] = 0;
		}
		for (int i = 0; i < room.length; i++) {
			System.out.printf("이름: %d호 객실인원: %d 가격: %d 특성: %s이며 ", room[i][0], room[i][1], room[i][2], roomTag[i][0]);
			if (room[i][3] == 1) {
				System.out.println("예약되었습니다.");
			} else {
				System.out.println("예약되어있지않습니다");
			}
		}

		System.out.println();

		while (power) {
			power2 = true;
			System.out.println("1: 예약하기 /// 2: 예약취소 /// 3: 예약상황 /// 4: 종료");
			tmp = scan.nextInt();
			switch (tmp) {
			default:
				System.out.println("다시 입력해 주세요");
				break;
			case 4:
				power = false;
				System.out.println("종료합니다...");
				break;
			case 3:
				for (int i = 0; i < room.length; i++) {
					if (room[i][3] == 1) {
						System.out.println(room[i][0] + "방은 예약되어있습니다");
					} else {
						System.out.println(room[i][0] + "방은 예약가능합니다");
					}
				}
				break;
			case 1:
				System.out.println("예약할 방의 번호를 입력해 주세요(101번 시작)");
				tmp = scan.nextInt();
				if (room[tmp - 101][3] == 1) {
					System.out.println("그 방은 이미 예약 되어 있습니다");
				} else {
					System.out.println("예약자명을 입력해 주세요");
					tmp1 = scan.next();
					roomTag[tmp - 101][1] = tmp1;
					System.out.println("예약번호 4자리를 입력해 주세요");
					tmp2 = scan.nextInt();
					room[tmp - 101][4] = tmp2;
					System.out.println(roomTag[tmp - 101][1] + "님 예약되었습니다");
					room[tmp - 101][3] = 1;
				}
				break;
			case 2:
				System.out.println("예약취소할 방의 번호를 입력해 주세요(101번 시작)");
				tmp = scan.nextInt();
				if (room[tmp - 101][3] == 0) {
					System.out.println(room[tmp - 101][0] + "은 예약되어 있지 않은 상태입니다");
				} else {
					while (power2) {
						System.out.println("예약번호를 입력해 주세요 (0입력시 종료)");
						tmp2 = scan.nextInt();
						if (tmp2 == 0) {
							power2 = false;
							break;
						} else if (room[tmp - 101][4] == tmp2) {
							System.out.println("예약을 취소하였습니다");
							room[tmp - 101][3] = 0;
						} else {
							System.out.println("예약번호가 다릅니다");
						}
					}
				}
				break;
			}
		}
	}
}
