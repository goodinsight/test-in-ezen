package kr.co.dong.checkPoint;

import java.util.Scanner;

/* 2023/05/25 �߰� ���� => 1. ���� �Ը�� ���۰� ���ÿ� �Է� 2. ȣ�� ���ȣ/ ȣ�ڹ��(ex : �ξ�
		 * /���ٴٵ�....���)/���� �ο�/ ���� 3. ����� �����ڸ�/ ���� ��ȣ (��ҽ� �ʿ�) �� 4. ��Ÿ �ʿ��� ��� (������ ���)
		 *
		 * 1) ���� �Ը� ����. 
		 * 2) ȣ�� ȭ�鿡�� => ȣ�� �� ��ȣ �� �ο�(0�ν�) ���� ��� �����ֱ� 
		 * 3) ���� ȭ�鿡�� ������ �̸� ��, ��ȭ��ȣ �Է� => ���� ��ҽ� ��� ���� & ������� ����
		 * 4) ������ ��� => ������ Ȯ�� �� ������ �� ���� �Ⱓ(0��) �߰� �ο�
		 * �߻��� �߰���ݱ��� �Ҽ� ��������........
*/
public class CheckTest01 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String roomType[][] = {{"���Ĵٵ�", "20000", "60000", "2"}, {"�𷰽�", "25000", "70000", "2"}, {"Ʈ��", "30000", "90000", "4"}};
		String typeName[] = {"���", "����"};
		String pwd = "admin";
		String state = "�����";
		boolean admin_Power = false;
		System.out.print("���� �Ը� �Է� : ");
		int size = scan.nextInt();
		int plus = 0;
		String[][] room = new String [size][8];
		int roomNum = 301;
		for(int i = 0; i < room.length; i++) {
			for(int j = 1; j <= roomType.length + 1; j++) {
			room[i][j] = roomType[i%roomType.length][j-1]; // �� ����
			}
			room[i][5] = "empty"; // �����ڸ�
			room[i][6] = "empty"; // �����ȣ
			room[i][7] = "NotReservation"; // �������
		}
		
		for(int i = 0; i < room.length - 1; i++) {
			if(Integer.parseInt(room[i][2]) > Integer.parseInt(room[i+1][2])) {
				String[] tmp = room[i];
				room[i] = room[i+1];
				room[i+1] = tmp;
				i = 0;
			}
		}
		
		for(int i = 0; i < room.length; i++) {
			room[i][0] = String.valueOf(roomNum); // �� ��ȣ
			roomNum++;
			if(i != room.length -1 && !(room[i][1].equals(room[i+1][1]))) {
				roomNum = ((((roomNum + 100) / 100)*100) + 1);
			}
		}
		
		while(true) {
			int choice = 0;
			System.out.print("(1)ȣ�Ǽ��� (2)������� (3)ȣ��Ȯ�� (99)���� : ");
			choice = scan.nextInt();
			switch(choice) {
			case 1:
				for(int i = 0; i < room.length;) {
					if(room[i][7].equals("NotReservation")){
						state = "���డ��";
					}
					System.out.printf(room[i][0] +"�� %4s" + " " + typeName[0] +" : " + room[i][2] + " " +typeName[1] + " : " + room[i][3] + " " + room[i][4] + "�ν� " + state, room[i][1] );
					i++;
					if(i%3 == 0 && i != 0) {
						System.out.println();
					}else {
						System.out.print("      ");
					}
					state = "�����";
				}
				
				System.out.println();
				int selNum = 0;
				System.out.print("ȣ�ǹ�ȣ ���� : ");
				selNum = scan.nextInt();
				int tmp = selNum%100-1;
				if(selNum >= Integer.parseInt(room[0][0]) && selNum <= Integer.parseInt(room[room.length-1][0])) {
					if(room[tmp][7].equals("NotReservation")) {
						System.out.println("������ �����մϴ�.");
					} else {
						System.out.println("������ �Ұ����մϴ�.");
					}
						while(true) {
							System.out.println("(1)���� (0)���ư���");
							int sel = scan.nextInt();
							if(sel == 0) {
								break;
							} else if(sel == 1) {
								System.out.println("(1)��� (2)���� (0)���ư���");
								sel = scan.nextInt();
							}
							if (sel == 0){
								break;
							} else if(sel == 1 || sel == 2) {
								System.out.println(selNum +"�� �� " + room[tmp][1] + " " + typeName[sel-1] + " " + room[tmp][sel+1]+"�� ����");
								System.out.println(room[tmp][1] + "���� ���� �ο��� " + room[tmp][4] + "�� �Դϴ�. (1)�߰� �ο� ���� (2)�ο� �߰�(�ο� �� ���� �߰�) : ");
								int selNum2 = scan.nextInt();
								if(selNum2 == 2) {
									System.out.println("�߰� �ο� ���� �Է����ּ��� : ");
									plus = scan.nextInt();
								}
								System.out.print("�����ڸ��� �Է����ּ��� : ");
								room[tmp][5] = scan.next();
								System.out.print("�����ȣ�� �Է����ּ��� : ");
								room[tmp][6] = scan.next();
								System.out.println(room[tmp][5] + "�� �̸����� " + selNum + "�� ���� ����Ǿ����ϴ�.");
								System.out.println(Integer.parseInt(room[tmp][sel+1]) + (plus * 10000) + "�� �����Ǿ����ϴ�.");
								room[tmp][7] = "Reservation";
								break;
							} else {
								System.out.println("�߸��� �Է��Դϴ�.");
							}
						}
				}else {
					System.out.println("�߸��� �Է��Դϴ�.");
				}
				break;
			// case 1 end
			case 2:
				for(int i = 0; i < room.length;) {
					System.out.printf(room[i][0] +"�� %4s" + " " + typeName[0] +" : " + room[i][2] + " " +typeName[1] + " : " + room[i][3] + " " + room[i][4] + "�ν� ", room[i][1]);
					if(room[i][7].equals("NotReservation")){
						state = "���డ��";
					}
					System.out.print(state);
					i++;
					if(i%3 == 0 && i != 0) {
						System.out.println();
					}else {
						System.out.print("      ");
					}
					state = "�����";
				}
				System.out.println();
				while(true){
					System.out.print("������ ����� �� ��ȣ�� �Է����ּ���((0)���ư���) :");
					int selNum2 = scan.nextInt();
					int tmp2 = selNum2%100-1;
					if(selNum2 > Integer.parseInt(room[0][0]) && selNum2 < Integer.parseInt(room[room.length-1][0])) {
						if(room[tmp2][7].equals("Reservation")) {
							while(true){
								System.out.print("�����ȣ�� �Է��ϼ��� (0)���ư��� : ");
								String input = scan.next();
								if(input.equals(room[tmp2][6])) {
									System.out.println(selNum2 + "�� �� ������ ��ҵǾ����ϴ�.");
									room[tmp2][7] = "NotReservation";
									room[tmp2][5] = "empty";
									room[tmp2][6] = "NotReservation";
									break;
								}else if(input == "0") {
									break;
								}else {
									System.out.println("�����ȣ�� Ʋ���ϴ�. �ٽ� �Է����ּ���");
								}
							}
							break;
						} else {
							System.out.println("������� ���� ���Դϴ�.");
						}
					}else if(selNum2 == 0){
						break;
					}else {
						System.out.println("�߸��� �Է��Դϴ�.");
					}
				}
				break;
			//case 2 end
				
			case 3:
				for(int i = 0; i < room.length;) {
					System.out.printf(room[i][0] +"�� %4s" + " " + typeName[0] +" : " + room[i][2] + " " +typeName[1] + " : " + room[i][3] + " " + room[i][4] + "�ν� ", room[i][1]);
					if(room[i][7].equals("NotReservation")){
						state = "���డ��";
					}
						System.out.print(state);
					i++;
					if(i%3 == 0 && i != 0) {
						System.out.println();
					}else {
						System.out.print("      ");
					}
					state = "�����";
				}
				System.out.println();
				break;
				//case 3 end
				
			case 77:
					System.out.print("������ ��� ��й�ȣ �Է�(�ʱ� ��й�ȣ : admin) : ");
					String pwdinput = scan.next();
					if(pwdinput.equals(pwd)) {
						while(!admin_Power) {
							System.out.print("(1)�������� Ȯ�� (2)�� ���� (3)��й�ȣ ���� : ");
							int admin_sel = scan.nextInt();
							switch(admin_sel) {
							case 1:
								for(int i = 0; i < room.length;) {
									System.out.printf(room[i][0] +"�� %4s" + " " + typeName[0] +" : " + room[i][2] + " " +typeName[1] + " : " + room[i][3] + " " + room[i][4] + "�ν� ", room[i][1]);
									if(room[i][7].equals("NotReservation")){
										state = "���డ��";
									}
										System.out.print(state);
									i++;
									if(i%3 == 0 && i != 0) {
										System.out.println();
									}else {
										System.out.print("      ");
									}
									state = "�����";
								}
								System.out.print("Ȯ���� �� ��ȣ�� �Է����ּ��� : ");
								int sel_roomNum = scan.nextInt();
								int roomNumtmp = sel_roomNum%100 - 1;
								System.out.print(room[roomNumtmp][0] + "�� �� " + room[roomNumtmp][1] + " " + typeName[0] + " : " + room[roomNumtmp][2] + " " + typeName[1] + " : " + room[roomNumtmp][3] + " ");
								if(!(room[roomNumtmp][7].equals("Reservation"))) {
									state = "���� ����";
									System.out.println(state);
								}else {
									System.out.println(state);
									System.out.println(" �߰� �ο� : " + plus + " �����ڸ� : " + room[roomNumtmp][5] + " �����ȣ : " + room[roomNumtmp][6]);
								}
								break; // case 1
								
							case 2:
								for(int i = 0; i < room.length;) {
									System.out.printf(room[i][0] +"�� %4s" + " " + typeName[0] +" : " + room[i][2] + " " +typeName[1] + " : " + room[i][3] + " " + room[i][4] + "�ν� ", room[i][1]);
									if(room[i][7].equals("NotReservation")){
										state = "���డ��";
									}
										System.out.print(state);
									i++;
									if(i%3 == 0 && i != 0) {
										System.out.println();
									}else {
										System.out.print("      ");
									}
									state = "�����";
								}
								System.out.print("������ �� ��ȣ�� �Է����ּ���(1) : ");
								int sel1_RoomNum = scan.nextInt();
								int sel1_tmp = sel1_RoomNum%100-1;
								if(room[sel1_tmp][7].equals("NotReservation")){
									System.out.println("����Ǿ����� ���� ���Դϴ�.");
								}else if(room[sel1_tmp][7].equals("Reservation")){
									System.out.print("������ �� ��ȣ�� �Է����ּ���(2) : ");
									int sel2_RoomNum = scan.nextInt();
									int sel2_tmp = sel2_RoomNum%100-1;
									if(room[sel2_tmp][7].equals("Reservation")){
										System.out.println("�̹� ����� ���Դϴ�.");
									}else {
										System.out.println(sel1_RoomNum + "�� ���������� " + sel2_RoomNum +"������ ����Ǿ����ϴ�.");
										room[sel2_tmp][5] = room[sel1_tmp][5];
										room[sel2_tmp][6] = room[sel1_tmp][6];
										room[sel2_tmp][7] = "Reservation";
										room[sel1_tmp][7] = "NotReservation";
									}
								}
								break;
								
							case 3:
								System.out.print("������ ��й�ȣ : ");
								String npwd = scan.next();
								System.out.println("��й�ȣ�� " + npwd +"�� ����Ǿ����ϴ�.");
								pwd = npwd;
							}//switch
						}
							break;
							
					}else {
						System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�.");
						break;
					}
			}
			scan.close();
		}
	}
}
