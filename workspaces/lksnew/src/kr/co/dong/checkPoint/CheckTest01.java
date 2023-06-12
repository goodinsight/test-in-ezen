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

*/
package kr.co.dong.checkPoint;

import java.util.Scanner;

public class CheckTest01 {
	public static void main(String[] args) {
// ���� ����
		boolean sysoff = true;
		int roomNum = 12; // ���� ����
		int option = 2; // ���� ����(�ɼ�)
		int power = 99; // menu ������ 99 �Է½� ���α׷� ����
		
		String[] menu = { "���� ����", "���� ���", "ȣ�� Ȯ��"};
		String[] message = { "���డ�ɡ�", "�����:��" }; // ���� ���� ���¿� ���� �޼��� ǥ��
		String[][] room = new String[roomNum][option]; // �� �迭�� ����
// �� �̸� ������� �ɼ� �ʱ�ȭ
		for(int i = 0; i<room.length; i++) {
			room[i][0] = Integer.toString(i+1)+"ȣ��";
			room[i][1] = Integer.toString(0);
//			room[i][2] = "����Ʈ��";
		}
		
// main stream
		while (true) {
			showMenu(menu, power);
			int result = firstMenuNumber(menu, power);
			if (result == power) {
				break;
			}
			sysoff = moveToNextMenu(result, room, message);
			if(sysoff == false) {
				break;
			}
		}// main stream end
		
		System.out.println("�ý����� �����մϴ�.");
	}

	
	
/* �޼ҵ�	*/
	
	private static boolean moveToNextMenu(int result, String[][] room,String[] message) {
		// �޴� ���� ����� ���� ���� �޴� ȭ��(showNextMenu)���� �̵�
		boolean tmp = true;
		switch(result) {
		case 1: 
			showReservationMenu(room);
			break;
		case 2:
			showCancelMenu(room);
			break;
		case 3:
			showRoomStateMenu(room, message);
			break;
		case 4:
			break;
		case 99:
			tmp = false;
			break;
		}
		return tmp;
	}

	private static void showRoomStateMenu(String[][] room, String[] message) {
		// �� ���� ȭ��
		while(true) {
			System.out.println("=======================================");
			System.out.println("          <room ���� ȭ��>            ");
			System.out.println();
			for (int i = 0; i < room.length; i++) {
				System.out.printf("%2d. %4s   ", i + 1, room[i][0]);
				if (i%3 == 2)
					System.out.println();
			}
			System.out.println("=======================================");

			System.out.printf("ȣ�� ��ȣ�� ������:(1~%d)(���� �޴� :%d �Է�)%n",room.length,room.length+1);
			
			String[] reservMenu = new String[room.length+1];
			for (int i = 0; i < room.length; i++) {
				reservMenu[i] = room[i][0];
			}
			
			int result = inputMenuNumber(reservMenu);
			boolean res = stateRoom(result, room, message);
			if (res==false)
				break;
		}
	}

	
	private static void showCancelMenu(String[][] room) {
		/// ���� ��� ȭ��
		while(true) {
			System.out.println("=======================================");
			System.out.println("          <room ���� ��� ȭ��>            ");
			System.out.println();
			
			for (int i = 0; i < room.length; i++) {
				System.out.printf("%2d. %4s   ", i + 1, room[i][0]);
				if (i%3 == 2)
					System.out.println();
			}
			System.out.println("=======================================");

			System.out.printf("ȣ�� ��ȣ�� ������:(1~%d)(���� �޴� :%d �Է�)%n",room.length,room.length+1);
			
			String[] reservMenu = new String[room.length+1];
			for (int i = 0; i < room.length; i++) {
				reservMenu[i] = room[i][0];
			}
			
			int result = inputMenuNumber(reservMenu);
			boolean res = cancelRoom(result, room);
			if (res==false)
				break;
		}
	}

	private static void showReservationMenu(String[][] room) {
		// ���� �޴�ȭ��
		while(true) {
			System.out.println("=======================================");
			System.out.println("            <room ���� ȭ��>              ");
			System.out.println();
			for (int i = 0; i < room.length; i++) {
				System.out.printf("%2d. %4s   ", i + 1, room[i][0]);
				if (i%3 == 2)
					System.out.println();
	//			System.out.printf("���� ���´� %s �Դϴ�.%n", room[i][1]);
			}
			System.out.println("=======================================");
	//		String[] reservMenu = {"ȣ�ǹ�ȣ ����"};
	//		for (int i = 0; i < reservMenu.length; i++) {
	//			System.out.printf("%d. %s   ", i + 1, reservMenu[i]);
	//		}
			System.out.printf("ȣ�� ��ȣ�� ������:(1~%d)(���� �޴� :%d �Է�)%n",room.length,room.length+1);
			
			String[] reservMenu = new String[room.length+1];
			for (int i = 0; i < room.length; i++) {
				reservMenu[i] = room[i][0];
			}
			
			int result = inputMenuNumber(reservMenu);
			boolean res = reserveRoom(result, room);
			if (res==false)
				break;
		}
	}

	private static boolean reserveRoom(int result, String[][] room) {
		// �� �����ϱ�
		if (result == room.length+1) {
			return false;
		}else {
//			System.out.println(room[result-1][0]+"�� ���� ���´�" +room[result-1][1]+ "�Դϴ�.");
			if (room[result-1][1].equals("0")) {
				System.out.println("����"+room[result-1][0]+"�� ���� ���� �����Դϴ�.");
				System.out.println("������ �����ϰڽ��ϴ�.");
				System.out.println(room[result-1][0]+"�� �����Ͽ����ϴ�.");
				room[result-1][1] = "1";
			}else {
				System.out.println("����"+room[result-1][0]+"�� ���� �Ұ��� �����Դϴ�.");
			}
			return true;
		}
			
	}
	private static boolean cancelRoom(int result, String[][] room) {
		// �� ����ϱ�
		if (result == room.length+1) {
			return false;
		}else {
//			System.out.println(room[result-1][0]+"�� ���� ���´�" +room[result-1][1]+ "�Դϴ�.");
			if (room[result-1][1].equals("1")) {
				System.out.println("����"+room[result-1][0]+"�� ��������Դϴ�.");
				System.out.println("������Ҹ� �����ϰڽ��ϴ�.");
				System.out.println(room[result-1][0]+"�� ����Ͽ����ϴ�.");
				room[result-1][1] = "0";
			}else {
				System.out.println("����"+room[result-1][0]+"�� �̿��� �����Դϴ�.");
			}
			return true;
		}
	}
	private static boolean stateRoom(int result, String[][] room, String[] message) {
		// �� ���� Ȯ���ϱ�
				if (result == room.length+1) {
					return false;
				}else {
					if (room[result-1][1].equals("1")) {
						System.out.println("����"+room[result-1][0]+" : "+message[1]);
					}else {
						System.out.println("����"+room[result-1][0]+" : "+message[0]);
					}
					return true;
				}
	}
	private static int inputMenuNumber(String[] menu) {
		// �޴��� �����ϸ� �̸� �޾Ƽ� int�� return
		int result = 0;
		while (true) {
			try {
				Scanner scan = new Scanner(System.in);
				int choice = scan.nextInt();
				if (choice >= 1 && choice <= menu.length) {
					result = choice;
					break;
				}
				else {
					System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���. :");
				}
			} catch(Exception e){ // ����ó�� ���� �̿��� ���� ���� ��� �ٽ� �Է� ����
				System.out.println("������ �Է��ϽǼ� �ֽ��ϴ�. �ٽ� �Է��ϼ���.");
			}
		}
		return result;
	}
	private static int firstMenuNumber(String[] menu, int power) {
		// power �Է½� ���α׷� ���Ḧ ���� �߰���
		int result = 0;
		while (true) {
			try {
				Scanner scan = new Scanner(System.in);
				int choice = scan.nextInt();
				if (choice >= 1 && choice <= menu.length) {
					result = choice;
					break;
				}else if(choice == power){
					result = power;
					break;
				}else {
					System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���. :");
				}
			} catch(Exception e){ // ����ó�� ���� �̿��� ���� ���� ��� �ٽ� �Է� ����
				System.out.println("������ �Է��ϽǼ� �ֽ��ϴ�. �ٽ� �Է��ϼ���.");
			}
		}
		return result;
	}
	private static void showMenu(String[] menu, int power) {
		// ó�� �޴�ȭ��
		System.out.println("=======================================");
		System.out.println("           <** ȣ�� ���� �ý���>            ");
		System.out.println();
		for (int i = 0; i < menu.length; i++) {
			System.out.printf("%d. %s   ", i + 1, menu[i]);
		}
		System.out.println();
		System.out.println();
		System.out.printf("                    �ý����� ���� (%d)�Է�%n", power);
		System.out.println("=======================================");

		System.out.printf("�޴��� ������:(1~%d) %n", menu.length);
		
	}
}
