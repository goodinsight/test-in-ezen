/*
���� -> �ҽ��ۼ� -> �����
Ű���忡 ���� �Է��ۼ�
�� 12���� �ְ� => ����? �迭? => �迭 room[12]
�Է� �������� // menu���� : 1,2,3,99�� �Է¹���
1�� �������� ���� ����, // room[���ȣ]�� ���� 1�̸� �������
	1-> ȣ�ǹ�ȣ ����(1~12) -> ������¿��� Ȯ��
	-> ���� ���ɻ��� -> ���� �ǽ�-> ȣ��Ȯ�� => �޴��� ����
	-> ���� �Ұ����� -> ȣ�ǹ�ȣ ����(1~12) or �޴��� ����
2�� �������� ���� ���(����->����), // room[���ȣ]�� ���� 0�̸� ����
	2-> ȣ�ǹ�ȣ ����(1~12) -> ��Ұ��ɿ���
	-> ��Ұ��� : �ش�ȣ���� ���� 0���� => �޴�����
	-> ��ҺҰ� : ����������� ���̶�� ǥ��. => �޴�����
3�� �������� ȣ�� Ȯ��, // 1�� ���� "�����:��" 0�� ���� "���డ�ɡ�"

99�� ���� ���� ���α׷� ����

=> �߰����� :  1. ���ǱԸ�(����)�� ���۰� ���ÿ� �Է���
			2. ȣ�ڹ��ȣ/ ȣ�ڹ��(��-�ξ�/������ ��)/ �����ο�/ ����
			3. ����� �����ڸ� / �����ȣ(��ҽ� �ʿ�) ��
			4. ��Ÿ �ʿ��� ���(������ ���)

=> �����ؾ��� ����
	1. method�� ���� ����ȭ ���Ѿ� ��
	2. �Է��� ������ String���� �޾Ƽ� ��Ȳ�� ���� �̸� int�� �ٸ� type���� ������Ѵ°� �� ȿ�����ϵ�
		-> �Է� method ������ �������� �������� �����Ұ�
	3. class ������ �����Ͽ� method parameter�� ���ϰ�
	4. 1���� �̾����� ������� �ϳ��� class���� �� �Ϸ��� �������� class�� �߰��ϰ�, �߰��� class�� ȣ���Ͽ� ����ϵ��� ������ ��.
	5. �޴�ȭ�� �԰��� ó���� ���� �̸� ����ȭ ���ѳ��� ���ľ��� ���(?)�� �����غ���.......

*/

package kr.co.dong.checkPoint;

import java.util.Scanner;

public class CheckTest17_3 {
	static int roomNum = 12; // ���� ����
	static int option = 7; // ���� ����(�ɼ�) ����
	static int power = 99; // menu ������ 99 �Է½� ���α׷� ����
	static int password = 1234; // ������ �޴� ��й�ȣ
	static boolean sysoff = true;
	static String[][] room;
	static String[] reserveInfo = { "�����ڸ�", "�����ȣ" };

	public static void main(String[] args) {
// ���� ����
		String[] menu = { "�� ����", "���� ����", "���� ���", "ȣ�� Ȯ��" }; // , "�� �ɼǺ� �˻�"};
		String[] initMenu = { "���ǱԸ�", "���������Է�", "��������default�� ����" };
		String[] adminMenu = { "������������", "������Ȳ" }; // , "��¥�� ���� �޴�" };
		String[] roomOption = { "���ȣ", "ȣ�ڹ��", "�����ο�", "����", "���డ�ɻ���", "�����ڸ�", "�����ȣ" }; // ���డ�ɻ���,�����ڸ�,�����ȣ ��ġ�� ������
																									// 3��°���ͷ� ����Ұ�
		String[] message = { "���డ�ɡ�", "�����:��" }; // ���� ���� ���¿� ���� �޼��� ǥ��
//		���۰� ���ÿ� ������ ��忡�� ���ǱԸ� �Է��� ����		
		while (true) {
			showInit(initMenu, power);
			int result = firstMenuNumber(initMenu, power); // power �Է½� ������ ��� ������ ����
			if (result == power) {
				break;
			}
			sysoff = moveToNextInitMenu(result, roomOption);
			if (sysoff == false) {
				break;
			}
		}

// main stream
		while (true) {
			showMenu(menu, power); // ���� ��
			int result = firstMenuNumber(menu, power);
			if (result == power) {
				break;
			}
			if (result == password) { // �����ڸ�� ��� �Է½� ����
				while (true) {
					showAdmin(adminMenu, power);
					result = firstMenuNumber(adminMenu, power); // power �Է½� ������ ��� ������ ����
					if (result == power) {
						break;
					}
					boolean res = moveToNextAdminMenu(result, roomOption);
					if (res == false) {
						break;
					}
				}
				result = 0;
			} // �����ڸ�� ��
			sysoff = moveToNextMenu(result, room, message);
			if (sysoff == false) { // ���α׷� ����
				break;
			}
		} // main stream end
		System.out.println("�ý����� �����մϴ�.");
	} // main end
// �޼ҵ�

	private static boolean moveToNextAdminMenu(int result, String[] roomOption) {
		// ������ �޴� ���� ����� ���� ���� �޴� ȭ��(showNextMenu)���� �̵�
		boolean tmp = true;
		switch (result) {
		case 1:
			modifyRoomInfor(roomOption);
			break;
		case 2:
			reservationStatus();
			break;
		case 3:
			reserve();
			break;
		case 99:
			tmp = false;
			break;
		default:
			System.out.println("�ٽ� �Է��ϼ���.");
		}
		return tmp;
	}

	private static void reserve() {
		// ��¥�� ������ �Ѵ��� ���� ����
		System.out.println("���� ���� ����");
	}

	private static void reservationStatus() {
		// �뺰 ���� ��Ȳ�� �Ѵ��� ���� �̸� ����ϰų� ������ ����� �� ����
		while (true) {
			System.out.println("==================================================");
			System.out.println("                 <Reservation Status>               ");
			System.out.println();
			for (int i = 0; i < room.length; i++) {
				System.out.printf("%2d. %4s -�����ڸ�: %5s, -�����ȣ: %5s ", i + 1, room[i][0], room[i][room[0].length - 2],
						room[i][room[0].length - 1]);
				System.out.println();
			}
			System.out.println();
			System.out.println("==================================================");
			System.out.printf("���������� �����ϰ� ���� �� ��ȣ�� ������:(1~%d)(���� �޴� :%d �Է�)%n", room.length, room.length + 1);

			String[] reservMenu = new String[room.length + 1];
			for (int i = 0; i < room.length; i++) {
				reservMenu[i] = room[i][0];
			}
			int result = inputMenuNumber(reservMenu);
			boolean res = modifyReservation(result);
			if (res == false)
				break;
		}
	}

	private static boolean modifyReservation(int num) {
		//
		if (num == room.length + 1) {
			return false;
		} else {
			if (room[num - 1][room[0].length - 3].equals("0")) {
				System.out.println("�����Ͻ� ���� ������ �Ǿ����� �ʽ��ϴ�.");
				while (true) {
					System.out.println("������ �Ͻðڽ��ϱ�?(y/n)");
					Scanner scan = new Scanner(System.in);
					String tmp = scan.next();
					if (tmp.equals("y")) {
						System.out.println("�����ڸ�: ");
						room[num - 1][room[0].length - 2] = reserveInfo[0] = scan.next(); // �� ������ �����ڸ�� �����ȣ ����
						System.out.println("�����ȣ: ");
						room[num - 1][room[0].length - 1] = reserveInfo[1] = scan.next();
						System.out.println(room[num - 1][0] + "�� �����Ͽ����ϴ�.");
						System.out.println("�����ڸ��� " + reserveInfo[0] + "�̰�, �����ȣ: " + reserveInfo[1] + "���� ����Ǿ����ϴ�.");
						room[num - 1][room[0].length - 3] = "1";
						break;
					} else if (tmp.equals("n")) {
						System.out.println("������ ������� �ʾҽ��ϴ�.");
						break;
					} else {
						System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���");
					}
				}
			} else if (room[num - 1][room[0].length - 3].equals("1")) {
				System.out.println("�����Ͻ� ���� ������ �Ǿ��ֽ��ϴ�.");
				while (true) {
					System.out.println("������ ��� ��Ű�ڽ��ϱ�?(y/n)");
					Scanner scan = new Scanner(System.in);
					String tmp = scan.next();
					if (tmp.equals("y")) {
						System.out.println("�����ڸ��� " + room[num - 1][room[0].length - 1] + "�̰�, �����ȣ: "
								+ room[num - 1][room[0].length - 2] + "��");
						System.out.println(room[num - 1][0] + "�� ��������Ͽ����ϴ�.");
						room[num - 1][room[0].length - 2] = reserveInfo[0] = ""; // �� ������ �����ڸ�� �����ȣ ����
						room[num - 1][room[0].length - 1] = reserveInfo[1] = "";
						room[num - 1][room[0].length - 3] = "0";
						break;
					} else if (tmp.equals("n")) {
						System.out.println("������ ������� �ʾҽ��ϴ�.");
						break;
					} else {
						System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���");
					}
				}
			}
			return true;
		}
	}

	private static void modifyRoomInfor(String[] roomOption) {
		// �� ��ȣ�� �����ϰ� �ϳ��� ������ �����Ҽ� �ִ� ȭ��
		while (true) {
			showRoomInfor();
			System.out.printf("�����ϰ� ���� �� ��ȣ�� ������:(1~%d)(���� �޴� :%d �Է�)%n", room.length, room.length + 1);
			String[] reservMenu = new String[room.length + 1];
			for (int i = 0; i < room.length; i++) {
				reservMenu[i] = room[i][0];
			}
			int tmp3 = inputMenuNumber(reservMenu);
			if (tmp3 == reservMenu.length) {
				break;
			}
			System.out.println(
					roomOption[0] + ", " + roomOption[1] + ", " + roomOption[2] + ", " + roomOption[3] + "�� �Է��ϼ���.");
			Scanner scan = new Scanner(System.in);
			String tmp = scan.next();
			String[] tmp2 = tmp.split(",");
			for (int j = 0; j < tmp2.length; j++) {
				room[tmp3 - 1][j] = tmp2[j];
			}
			System.out.println("������ ���� �����Ǿ����ϴ�.");
			System.out.printf("%2d. %4s -���: %3s, -�����ο�: %s, -����/1��: %9s %n", tmp3, room[tmp3 - 1][0],
					room[tmp3 - 1][1], room[tmp3 - 1][2], room[tmp3 - 1][3]);
		}
	}

	private static boolean moveToNextInitMenu(int result, String[] roomOption) {
		// �ʱ�ȭ �޴� ���� ����� ���� ���� �޴� ȭ��(showNextMenu)���� �̵�
		boolean tmp = true;
		switch (result) {
		case 1:
			setRoomSize(roomNum, option);
			break;
		case 2:
			setRoom(roomNum, option, roomOption);
			break;
		case 3:
			setRoomDefault(roomNum, option);
			break;
		case 99:
			tmp = false;
			break;
		default:
			System.out.println("�ٽ� �Է��ϼ���.");
		}
		return tmp;
	}

	private static void setRoomDefault(int roomNum2, int option2) {
		// �⺻�� �ڵ� ����
		room = new String[roomNum2][option2];
		for (int i = 0; i < room.length; i++) {
			room[i][0] = Integer.toString(i / 3 + 1) + "0" + Integer.toString(i % 3 + 1) + "ȣ";
			if (i % 3 == 0) {
				room[i][1] = "�ξ�";
				room[i][2] = "2�ν�";
				room[i][3] = "100,000��";
			}
			if (i % 3 == 1) {
				room[i][1] = "����Ʈ";
				room[i][2] = "3�ν�";
				room[i][3] = "150,000��";
			}
			if (i % 3 == 2) {
				room[i][1] = "VIP";
				room[i][2] = "4�ν�";
				room[i][3] = "200,000��";
			}
			room[i][4] = Integer.toString(0);
			room[i][5] = "";
			room[i][6] = "";

		}
	}

	private static void setRoom(int roomNum2, int option2, String[] roomOption) {
		// ���� �ɼ� ����
		System.out.println("�� �������" + roomOption[0] + ", " + roomOption[1] + ", " + roomOption[2] + ", " + roomOption[3]
				+ "�� �Է��ϼ���.");
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < room.length; i++) {
			System.out.println(
					roomOption[0] + ", " + roomOption[1] + ", " + roomOption[2] + ", " + roomOption[3] + "�� �Է��ϼ���.");
			String tmp = scan.nextLine();
			String[] tmp2 = tmp.split(",");
			for (int j = 0; j < tmp2.length; j++) {
				room[i][j] = tmp2[j];
			}
			room[i][room[0].length - 3] = "0"; // ���� �������� "0"�� ����
			room[i][room[0].length - 2] = ""; // ���� ������ ���� ""�� ����
			room[i][room[0].length - 1] = ""; // ���� �����ȣ ���� ""�� ����
		}
	}

	private static void setRoomSize(int Num, int option) {
		// ���� �Ը� �Է�
		Scanner scan = new Scanner(System.in);
		System.out.println("������ ũ�⸦ �Է��ϼ���:");
		Num = scan.nextInt();
		roomNum = Num;
		room = new String[Num][option]; // �� �迭�� ����
		System.out.println("���� ũ�Ⱑ " + Num + "���� ���õǾ����ϴ�.");
		for (int i = 0; i < room.length; i++) {
			room[i][0] = Integer.toString(i / 3 + 1) + "0" + Integer.toString(i % 3 + 1) + "ȣ";
			if (i % 3 == 0) {
				room[i][1] = "�ξ�";
				room[i][2] = "2�ν�";
				room[i][3] = "100,000��";
			}
			if (i % 3 == 1) {
				room[i][1] = "����Ʈ";
				room[i][2] = "3�ν�";
				room[i][3] = "150,000��";
			}
			if (i % 3 == 2) {
				room[i][1] = "VIP";
				room[i][2] = "4�ν�";
				room[i][3] = "200,000��";
			}
			room[i][4] = Integer.toString(0);
		}
	}

	private static void showInit(String[] initMenu, int power) {
		// ������ ��� ����
		System.out.println("==================================================");
		System.out.println("               <�ʱ� ���� �޴�>              ");
		System.out.println();
		for (int i = 0; i < initMenu.length; i++) {
			System.out.printf("%d. %s   ", i + 1, initMenu[i]);
		}
		System.out.println();
		System.out.println();
		System.out.printf("                    �ʱ� ���� �޴��� ���� (%d)�Է�%n", power);
		System.out.println("==================================================");
		System.out.println();
		System.out.printf("�޴��� ������:(1~%d) %n", initMenu.length);
	}

	private static void showAdmin(String[] initMenu, int power) {
		// ������ ��� ����
		System.out.println("==================================================");
		System.out.println("               <������ �޴�>              ");
		System.out.println();
		for (int i = 0; i < initMenu.length; i++) {
			System.out.printf("%d. %s   ", i + 1, initMenu[i]);
		}
		System.out.println();
		System.out.println();
		System.out.printf("                    �����ڸ޴��� ���� (%d)�Է�%n", power);
		System.out.println("==================================================");
		System.out.println();
		System.out.printf("�޴��� ������:(1~%d) %n", initMenu.length);
	}

	private static boolean moveToNextMenu(int result, String[][] room, String[] message) {
		// �޴� ���� ����� ���� ���� �޴� ȭ��(showNextMenu)���� �̵�
		boolean tmp = true;
		switch (result) {
		case 1:
			showRoomInfor();
			break;
		case 2:
			showReservationMenu(room);
			break;
		case 3:
			showCancelMenu(room);
			break;
		case 4:
			showRoomStateMenu(room, message);
			break;
		case 5:
			searchRoomInfor();
		case 99:
			tmp = false;
			break;
		}
		return tmp;
	}

	private static void searchRoomInfor() {
		// �ɼǺ� ���ý� �ش��ϴ� �� ������ ǥ���� ��
		System.out.println("�ɼǺ� ���ý� �ش��ϴ� �� ������ ǥ���� ��");
		System.out.println("���� ���� ����");
	}

	private static void showRoomInfor() {
		// �� ������ ��ü������ �����ش�.
		while (true) {
			System.out.println("==================================================");
			System.out.println("                 <room Information>               ");
			System.out.println(" �ȳ� - ���� ������ �� ������ ǥ�õ˴ϴ�.                    ");
			for (int i = 0; i < room.length; i++) {
				if (room[i][room[0].length - 3].equals("0")) { // ���� ������ �� ������ ǥ��
					System.out.printf("%2d. %4s -���: %3s, -�����ο�: %s, -����/1��: %9s ", i + 1, room[i][0], room[i][1],
							room[i][2], room[i][3]);
					System.out.println();
				}
			}
			System.out.println();
			System.out.println("==================================================");
			System.out.printf("������ ���Ͻø� �����޴����� room����޴��� �̿��ϼ���(���� �޴� :%d �Է�)%n", room.length + 1);
			Scanner scan = new Scanner(System.in);
			int res = scan.nextInt();
			if (res == room.length + 1) {
				break;
			}
		}
	}

	private static void showRoomStateMenu(String[][] room, String[] message) {
		// �� ���� ȭ��
		while (true) {
			System.out.println("==================================================");
			System.out.println("                   <room ���� ȭ��>                  ");
			System.out.println();
			String state;
			for (int i = 0; i < room.length; i++) {
				if (room[i][room[0].length - 3].equals("0")) {
					state = "���డ�ɡ�";
				} else {
					state = "����Ұ���";
				}
				System.out.printf("%2d. %4s-%s  ", i + 1, room[i][0], state);
				if (i % 3 == 2) {
					System.out.println();
				}
			}
			System.out.println();
			System.out.println("==================================================");
			System.out.printf("������ ���Ͻø� �����޴����� room����޴��� �̿��ϼ���(���� �޴� :%d �Է�)%n", room.length + 1);
			Scanner scan = new Scanner(System.in);
			int res = scan.nextInt();
			if (res == room.length + 1) {
				break;
			}
		}
	}

	private static void showCancelMenu(String[][] room) {
		/// ���� ��� ȭ��
		while (true) {
			System.out.println("==================================================");
			System.out.println("                <room ���� ��� ȭ��>                  ");
			System.out.println();
			for (int i = 0; i < room.length; i++) {
				System.out.printf("%2d. %4s   ", i + 1, room[i][0]);
				if (i % 3 == 2)
					System.out.println();
			}
			System.out.println();
			System.out.println("==================================================");
			System.out.printf("ȣ�� ��ȣ�� ������:(1~%d)(���� �޴� :%d �Է�)%n", room.length, room.length + 1);
			String[] reservMenu = new String[room.length + 1];
			for (int i = 0; i < room.length; i++) {
				reservMenu[i] = room[i][0];
			}
			int result = inputMenuNumber(reservMenu);
			boolean res = cancelRoom(result, room);
			if (res == false)
				break;
		}
	}

	private static void showReservationMenu(String[][] room) {
		// ���� �޴�ȭ��
		while (true) {
			System.out.println("==================================================");
			System.out.println("                   <room ���� ȭ��>                   ");
			System.out.println();
			for (int i = 0; i < room.length; i++) {
				System.out.printf("%2d. [%4s %s]  ", i + 1, room[i][0], room[i][1]);
				if (i % 3 == 2)
					System.out.println();
			}
			System.out.println();
			System.out.println("==================================================");
			System.out.printf("ȣ�� ��ȣ�� ������:(1~%d)(���� �޴� :%d �Է�)%n", room.length, room.length + 1);
			String[] reservMenu = new String[room.length + 1];
			for (int i = 0; i < room.length; i++) {
				reservMenu[i] = room[i][0];
			}
			int result = inputMenuNumber(reservMenu);
			boolean res = reserveRoom(result, room);
			if (res == false)
				break;
		}
	}

	private static boolean reserveRoom(int result, String[][] room) {
		// �� �����ϱ�
		if (result == room.length + 1) {
			return false;
		} else {
//			System.out.println(room[result-1][0]+"�� ���� ���´�" +room[result-1][1]+ "�Դϴ�.");
			if (room[result - 1][room[0].length - 3].equals("0")) {
				System.out.println("����" + room[result - 1][0] + "�� ���� ���� �����Դϴ�.");
				System.out.println("������ �����ϰڽ��ϴ�. �����ڸ�,�����ȣ�� �Է��ϼ���.");
				Scanner scan = new Scanner(System.in);
				System.out.println("�����ڸ�: ");
				room[result - 1][room[0].length - 2] = reserveInfo[0] = scan.next(); // �� ������ �����ڸ�� �����ȣ ����
				System.out.println("�����ȣ:(������ҽ� �ʿ�) ");
				room[result - 1][room[0].length - 1] = reserveInfo[1] = scan.next();
				System.out.println(room[result - 1][0] + "�� �����Ͽ����ϴ�.");
				System.out.println("�����ڸ��� " + reserveInfo[0] + "�̰�, �����ȣ: " + reserveInfo[1] + "���� ����Ǿ����ϴ�.");
				room[result - 1][room[0].length - 3] = "1";
			} else {
				System.out.println("����" + room[result - 1][0] + "�� ���� �Ұ��� �����Դϴ�.");
			}
			return true;
		}
	}

	private static boolean cancelRoom(int result, String[][] room) {
		// �� ����ϱ�
		if (result == room.length + 1) {
			return false;
		} else {
//			System.out.println(room[result-1][0]+"�� ���� ���´�" +room[result-1][1]+ "�Դϴ�.");
			if (room[result - 1][room[0].length - 3].equals("1")) {
				System.out.println("����" + room[result - 1][0] + "�� ��������Դϴ�.");
				while (true) {
					System.out.println("������Ҹ� �����ϰڽ��ϱ�?(y/n)");
					Scanner scan = new Scanner(System.in);
					String tmp = scan.next();
					if (tmp.equals("y")) {
						System.out.println("�����ڸ�,�����ȣ�� �Է��ϼ���.");
						System.out.println("�����ڸ�: ");
						reserveInfo[0] = scan.next(); // �� ������ �����ڸ�� �����ȣ ����
						if (!room[result - 1][room[0].length - 2].equals(reserveInfo[0])) {
							System.out.println("�����ڸ��� ��ġ���� �ʽ��ϴ�. ó������ �ٽ� �����ϼ���.");
							continue;
						}
						System.out.println("�����ȣ:(������ҽ� �ʿ�) ");
						reserveInfo[1] = scan.next(); // �� ������ �����ڸ�� �����ȣ ����
						if (!room[result - 1][room[0].length - 1].equals(reserveInfo[1])) {
							System.out.println("�����ȣ�� ��ġ���� �ʽ��ϴ�. ó������ �ٽ� �����ϼ���.");
							continue;
						}
						System.out.println(room[result - 1][0] + "�� ��ҵǾ����ϴ�.");
						room[result - 1][room[0].length - 3] = "0";
						break;
					} else if (tmp.equals("n")) {
						System.out.println("������Ҹ� �������� �ʾҽ��ϴ�.");
						break;
					} else {
						System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���.");
					}
				}
			} else {
				System.out.println("����" + room[result - 1][0] + "�� �̿��� �����Դϴ�.");
			}
			return true;
		}
	}

	private static int inputMenuNumber(String[] menu) {
		// �޴��� �����ϸ� �̸� �޾Ƽ� int�� return
		int result = 0;
		Scanner scan = new Scanner(System.in);
		while (true) {
			try {
				int choice = scan.nextInt();
				if (choice >= 1 && choice <= menu.length) {
					result = choice;
					break;
				} else {
					System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���. :");
				}
			} catch (Exception e) { // ����ó�� ���� �̿��� ���� ���� ��� �ٽ� �Է� ����
				System.out.println("������ �Է��ϽǼ� �ֽ��ϴ�. �ٽ� �Է��ϼ���.");
			}
		}
		return result;
	}

	private static int firstMenuNumber(String[] menu, int power) {
		// power �Է½� ���α׷� ���Ḧ ���� �߰���
		int result = 0;
		Scanner scan = new Scanner(System.in);
		while (true) {
			try {
				int choice = scan.nextInt();
				if (choice >= 1 && choice <= menu.length) {
					result = choice;
					break;
				} else if (choice == power) {
					result = power;
					break;
				} else if (choice == password) {
					result = password;
					break;
				} else {
					System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���. :");
				}
			} catch (Exception e) { // ����ó�� ���� �̿��� ���� ���� ��� �ٽ� �Է� ����
				System.out.println("������ �Է��ϽǼ� �ֽ��ϴ�. �ٽ� �Է��ϼ���.");
			}
		}
		return result;
	}

	private static void showMenu(String[] menu, int power) {
		// ó�� �޴�ȭ��
		System.out.println("==================================================");
		System.out.println("                   <** ȣ�� ���� �ý���>            ");
		System.out.println();
		for (int i = 0; i < menu.length; i++) {
			System.out.printf("%d. %s   ", i + 1, menu[i]);
		}
		System.out.println();
		System.out.println();
		System.out.printf("                    �ý����� ���� (%d)�Է�%n", power);
		System.out.println("==================================================");
		System.out.printf("�޴��� ������:(1~%d) %n", menu.length);
	}
}
