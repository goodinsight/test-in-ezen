package kr.co.dong.checkTest;

import java.util.Scanner;

public class CheckTest14 {
	public static void main(String[] args) {
//		Ű���忡 ���� �Է��ۼ�
//		��12���� �ְ� => ����?�迭? => �迭 room[12]
//		�Է±�������			// menu���� : 1,2,3,99�� �Է¹���
//		1�� ������� �� ���� ����	//room[���ȣ]�� ���� 1�̸� �������
//		1-> ȣ�ǹ�ȣ ����(1~12) -> ������¿��� Ȯ��
//		-> ���డ�ɻ��� -> ����ǽ� -> ȣ��Ȯ�� => �޴��� ����
//		-> ����Ұ����� -> ȣ�ǹ�ȣ ����(1~12) or �޴��� ����
//		2�� ���� ��� �������(����->����),	//room[���ȣ]�� ���� 0�̸� ����
//		2-> ȣ�ǹ�ȣ����(1~12) -> ��Ұ��ɿ���
//		-> ��Ұ��� : �ش�ȣ���� ���� 0���� => �޴�����
//		-> ��ҺҰ� : ����������� ���̶�� ǥ��. => �޴�����
//		3�� ���� ���� ȣ�� Ȯ��,	// 1�� ���� �����:�� "0�ΰ��� "���డ�ɡ�"
//		99�� ���� ���� ���α׷�����
		
//		=> �߰����� : 1. ���ǱԸ�(ũ��)�� ���۰� ���ÿ� �Է���
//					2. ȣ�ڹ��ȣ/ȣ�ڹ��(��-�ξ�/��������)/�����ο�/����
//					3. ����� �����ڸ�/�����ȣ(��ҽ� �ʿ�) ��
//					4. ��Ÿ �ʿ��� ���(�����ڸ��)
		int people = 0;
		int num = 0;
		String reservation = "";
		String reservationnum = "";
		String cancel = "";
		int sum = 0;
		int floor = 0;
		int rooms = 0;
		int choice = 0;
		String roomname = "";
		int guest = 0;
//		����
		int price =0;
//		[��][��]
		int[][] room;
//		[0���̸�]	[1����]	[2����]
		String[][] detail;
		boolean user = false;
		boolean admin = false;
		boolean power = false;
		int userchoice = 0;
		String judgment = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("ȣ���� ������ �Է��ϼ���.");
		floor = sc.nextInt();
		room = new int[floor][];
		detail = new String[floor][3];
		for (int i = 1; i <= floor; i++) {
			System.out.println(i+"��° ���� ������ ������ �Է����ּ���.");
			rooms = sc.nextInt();
			room[i-1] = new int[rooms];
			System.out.println(i+"�� ������ ������ �����Ǽ̽��ϴ�.");
			sum += rooms;
			System.out.println(i+"���� �����̸��� �������ּ���.");
			sc.nextLine();
			roomname = sc.nextLine();
			detail[i-1][0] = roomname;
			System.out.println(i+"���� �����̸��� �����Ǽ̽��ϴ�.");
			System.out.println(detail[i-1][0]+"�� ������ �������ּ���.");
			price = sc.nextInt();
			detail[i-1][1] = price + "".trim();
			System.out.println(detail[i-1][0]+" ������ ������ �����Ǽ̽��ϴ�.");
			System.out.println("������ ������ �������ּ���.");
			guest = sc.nextInt();
			detail[i-1][2] = guest+"".trim();
			System.out.println(detail[i-1][0]+" ������ ������ �����Ǽ̽��ϴ�.");
			
		}
//		[������][�����ȣ][���ǹ�ȣ]
		String[][] guestdate = new String[sum][3];
		int money = 0;
		while (true) {
			System.out.println("1. ����ڸ�� 2. �����ڸ��");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				while (!user) {
					System.out.println("�޴��� �������ּ���\n1. ȣ�ǿ���    2. �������    3. ȣ��Ȯ��    4. �����ݾ� ����    99. ����");
					userchoice = sc.nextInt();
					switch (userchoice) {
					case 1:
						System.out.println("�����Ͻ� ������ �������ּ���.");
						for (int i = 0; i < room.length; i++) {
							System.out.print((i+1)+". "+detail[i][0]+"   ");
						}
						userchoice = sc.nextInt();
						floor = userchoice;
						if(userchoice > room.length) {
							System.out.println("�߸� �Է��ϼ̽��ϴ� �ٽ� �Է����ּ���.");
						}
						
						for (int i = 0; i < room[userchoice-1].length; i++) {
							if(i%5 == 0) {
								System.out.println();
							}
							if(room[userchoice-1][i]== 0) {
								judgment = "���డ�ɡ�";
							}else {
								judgment = "�ҿ��డ��";
							}
							System.out.print(floor+"0"+(i+1)+"ȣ��("+judgment+")   ");
							
						}
						
						System.out.println("\n�����Ͻ� ȣ���� �������ּ���.");
						userchoice = sc.nextInt();
						System.out.println("�����ϴ� �ο��� �����ּ���.");
						people = sc.nextInt();
						if(room[floor-1][userchoice-1] == 1) {
							System.out.println("�ش� ������ �̹� ������ֽ��ϴ�. �ٸ� ȣ���� �������ּ���.");
						}else if(people > Integer.parseInt(detail[floor-1][2])) {
							System.out.println("�ش� ������ ������ "+detail[floor-1][2]+"�� ���� �����մϴ�.");
						}else if(money < Integer.parseInt(detail[floor-1][1])) {
							System.out.println("�ݾ��� �����մϴ� �����ݾ��� �������ּ���. --> 4");
							System.out.println("�����Ͻ� �ݾ� : " +(Integer.parseInt(detail[floor-1][1])-money));
						}else{
							System.out.println("�����ڴ��� ������ �Է����ּ���.");
							reservation = sc.next();
							guestdate[num][0] = reservation;
							System.out.println("������ �Ϸ�Ǽ̽��ϴ�.");
							for (int i = 1; i <= 6; i++) {
								reservationnum += (int)(Math.random()*10);
							}
							money -= Integer.parseInt(detail[floor-1][1]);
							guestdate[num][1] = reservationnum;
							guestdate[num][2] = floor + "0" + userchoice;
							
							reservationnum = "";
							System.out.println("������ : "+guestdate[num][0]+" �����ȣ : "+guestdate[num][1]+"���� �ݾ� : "+money);
							room[floor-1][userchoice-1] = 1;
							num++;
						}
						break;
						
					case 2: 
						System.out.println("����Ͻ÷��ϴ� ȣ���� �Է����ּ���.");
						cancel = sc.next();
						floor = Integer.parseInt(cancel.substring(0, 1));
						rooms = Integer.parseInt(cancel.substring(2));
						if(room[floor-1][rooms-1] == 0) {
							System.out.println("�ش� ȣ���� ����Ǿ����� �ʽ��ϴ�.");
							break;
						}
						System.out.println("����Ͻôº��� �����̳� �����ȣ�� �Է����ּ���.");
						reservation = sc.next();
						System.out.println();
						boolean b = false;
						for (int i = 0; i < guestdate.length; i++) {
							if((reservation.equals(guestdate[i][0]) || reservation.equals(guestdate[i][1])) && cancel.equals(guestdate[i][2])) {
								room[floor-1][rooms-1] = 0;
								guestdate[i][0] = "";
								guestdate[0][i] = "";
								b = true;
								break;
							}
						}
						if(b) {
							System.out.println("������ ��ҵǼ̽��ϴ�.");
							
						}else {
							System.out.println("�ش� ���ǿ� �Է��Ͻ� �̸� Ȥ�� �����ȣ�� ��ȸ�����ʽ��ϴ�.");
						}
						break;
					case 3:
						System.out.println("��ȸ�Ͻ� ������ �������ּ���.");
						for (int i = 0; i < detail.length; i++) {
							System.out.print((i+1)+". "+detail[i][0]+"   ");
						}
						userchoice = sc.nextInt();
						for (int i = 0; i < room[userchoice-1].length; i++) {
							if(i%5 == 0) {
								System.out.println();
							}
							if(room[userchoice-1][i]== 0) {
								judgment = "���డ�ɡ�";
							}else {
								judgment = "�ҿ��డ��";
							}
							System.out.print(userchoice+"0"+(i+1)+"ȣ��("+judgment+")   ");
							
						}
						System.out.println();
					case 4:
						System.out.println("�����Ͻ� �ݾ� : "+money+
								 "��   �����Ͻ� �ݾ��� �Է����ּ���.");
						money += sc.nextInt();
						System.out.println("�ݾ��� �����Ǽ̽��ϴ�. " + money);
						break;
					case 99:
						user = !user;
						break;
					default:
						break;
					}
				}user = !user;
				break;
			case 2:
				while (!admin) {
					System.out.println("1. ���� ��ȸ   99. ������ ����");
					choice = sc.nextInt();
					switch (choice) {
					case 1:
						if(num == 0) {
							System.out.println("�����Ͻ� �մ��� �����ϴ�.");
						}else {
							for (int i = 0; i < num; i++) {
								if(guestdate[i][0] != null) {
									System.out.print("���ǹ�ȣ : " +guestdate[i][2]+ "ȣ ���� : "+guestdate[i][0]+" �����ȣ : "+guestdate[i][1]);
								}
							}
							System.out.println();
						}
						break;
					case 99:
						System.out.println("������ ��带 �����մϴ�.");
						admin = !admin;
						break;
					default:
						break;
					}
					break;
				}
					admin = !admin;
				default:
					break;
			}
			
		}
		
		
	}
}
