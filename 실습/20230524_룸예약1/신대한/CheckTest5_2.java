package kr.co.dong.checkPoint;

import java.util.Scanner;

public class CheckTest5_2 {

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
		Scanner sc = new Scanner(System.in);
		
//		������, �����ȣ, ������ �� ��ȣ, ���ϸ��� ���� ����, id, ���� ��ҿ���
		String[][] userdate = new String[99][6];
		for (int i = 0; i < userdate.length; i++) {
			userdate[i][0] = "";
			userdate[i][1] = "";
			userdate[i][2] = "";
			userdate[i][3] = "";
			userdate[i][4] = "";
		}
//		���ǹ�ȣ, ���࿩��
		int[][] room = new int[3][];
//		ȣ�ڷ��, �����ο�, ����
		String[][] roomdate = new String[3][3];
//		���� ���̵�, ���� ��й�ȣ, ���ϸ���, �ܾ�, �ڵ��� ��ȣ
		String[][] userdate2 = new String[99][5];
//		�Ŵ��� ����
		int userchoice = 0;
//		���� ���̵�
		String id = "";
//		���� ���̵� �δ콺
		int userid = 0;
//		���� ��й�ȣ
		String pw = "";
//		���� ���̵� ��ȸ����
		boolean idCheck = false;
//		���� ��й�ȣ ��ȸ����
		boolean pwCheck = false;
//		�� ó�� ������ ����
		boolean userpower = false;
//		�� �̸�
		String roomname = "";
//		�δ콺 �����ϴ� ����
		int index = 0;
//		���� ����Ȯ���ϴ� ����
		String reservation = "";
//		case1 ���� ���� ����
		boolean bReservation = false;
//		�����Ҷ� �ο���
		int people = 0;
//		ȣ�� ����� �ش� ���� �ش��ϴ� �ݾ� �����ϴ� ����
		int roomMoney = 0;
//		���� ���ϸ����� ��� ����
		int mileage = 0;
//		���� �������� �ܾ��� ��� ����
		int userMoney = 0;
//		����� index �Ȱ�ġ�� ���ִ� ����
		int count = 0;
//		���� ��ȣ �������� �����ϴ� ����
		String randomNum = "";
//		������ ���� ��� ����
		String name = "";
//		���ϸ��� ��뿩�� ����
		char milcheck = ' ';
//		���� ��ҽ� 80%�ݾ� ��� ����
		int cancelMoney = 0;
		
		userdate2[0][0] = "�Ŵ���";
		userdate2[0][1] = "user01";
		userdate2[0][2] = "500";
		userdate2[0][3] = "500";
		userdate2[0][4] = "010-8991-7494";
		
		userdate2[1][0] = "�Źα�";
		userdate2[1][1] = "user02";
		userdate2[1][2] = "500";
		userdate2[1][3] = "500";
		userdate2[1][4] = "010-9047-7494";
		boolean power = false;
		for (int i = 0; i < room.length; i++) {
			System.out.println(i+1+"���� ȣ�ڷ��� �̸��� �������ּ��� : ");
			roomdate[i][0] = sc.nextLine();
			System.out.println(roomdate[i][0]+"�� ������ �������ּ��� : ");
			roomdate[i][1] = sc.next();
			System.out.println(roomdate[i][0]+"�� ������ �������ּ��� : ");
			roomdate[i][2] = sc.next();
			System.out.println(roomdate[i][0]+"�� ���� ������ �������ּ��� : ");
			room[i] = new int[sc.nextInt()];
			sc.nextLine();
		}
		
		
		while (!power) {
//			���̵� �Է¹���
			System.out.println("==============================================");
			System.out.println("1. �α���    2. ���̵� ã��    3. ��й�ȣ �缳��");
			userchoice = sc.nextInt();
			switch (userchoice) {
			case 1:
				while (!idCheck) {
					System.out.println("���̵� �Է����ּ���.");
					id = sc.next();
					for(int i = 0; i<userdate2.length;i++) {
						if(id.equals(userdate2[i][0])) {
							userid = i;
							idCheck = !idCheck;
						}
					}
					if(!idCheck) {
						System.out.println("�Է��Ͻ� ���̵�� ��ȸ���� �ʽ��ϴ� �ٽ��Է����ּ���.");
					}
				}
//				��й�ȣ�� �Է¹���
				while (!pwCheck) {
					System.out.println("��й�ȣ�� �Է����ּ���.");
					pw = sc.next();
					if(pw.equals(userdate2[userid][1])) {
						System.out.println(userdate2[userid][0]+"���� ȯ���մϴ�. ");
						pwCheck = !pwCheck;
					}else if(pw.equals("0")){
						System.out.println("ó�� �������� ���ư��ϴ�.");
					}else {
						System.out.println("��й�ȣ�� �߸� �Է��ϼ̽��ϴ� �ڷΰ���� 0���Դϴ�.");
					}
				}
				break;

			default:
				System.out.println("1~3���� �����ּ���.");
				break;
			}// �α���, ���̵�ã��, ��й�ȣ ã�� ��
			idCheck = !idCheck; pwCheck = !pwCheck;
			while (!userpower) {
				System.out.println("1. �����ϱ�     2. �������     3. ������Ȳ     4. ���ϸ�����ȸ     5. ����     99. �α׾ƿ�");
				userchoice = sc.nextInt();
				switch (userchoice) {
				case 1:
					while (!bReservation) {
						System.out.print("�����Ͻ� ���� ��ȣ�� �������ּ���.");
						for (int i = 0; i < roomdate.length; i++) {
							System.out.print(i+1+". "+roomdate[i][0]+"    ");
						}
						userchoice = sc.nextInt();
						for (int i = 0; i < room[userchoice-1].length; i++) {
							if(i%5==0) {
								System.out.println();
							}
							
							if(room[userchoice-1][i] == 0) {
								reservation = "���� ���ɡ�";
							}else {
								reservation = "���� �Ұ���(T_T)";
							}
							System.out.print((userchoice*100+i+1)+"ȣ ("+reservation+")   ");
						}
						System.out.println();
						for (int i = 1; i <= 6; i++) {
							randomNum += (int)(Math.random()*9);
						}
						userchoice = sc.nextInt();
						index = userchoice%10;
						mileage = Integer.parseInt(userdate2[userid][2]);		//���� ���ϸ��� �ܾ�
						userMoney = Integer.parseInt(userdate2[userid][3]);		//���� ���̵� �ܾ�
						if(room[(userchoice/100)-1][index-1] == 1) {
							System.out.println("�������ֽ� ���� �̹� ����Ǿ��ֽ��ϴ� �ٽü������ּ���.");
						}else {
							roomMoney = Integer.parseInt(roomdate[userchoice/100-1][2]);
							System.out.println("�����ϴ� �ο��� ���� �Է����ּ���.");
							people = sc.nextInt();
							if(people > Integer.parseInt(roomdate[userchoice/100-1][1])) {
								System.out.println("�����Ͻ� ���� ������ "+roomdate[userchoice/100-1][1]+"���Դϴ�. �ٸ����� �������ּ���.");
								break;
							}else if(userMoney < roomMoney){
								System.out.println("�ݾ��� �����մϴ�. ���ϸ����� ����Ͻðڽ��ϱ�? Y/N");
								System.out.println("�����ѱݾ� : "+(roomMoney-userMoney)+" ���ϸ��� : "+mileage);
								milcheck = sc.next().charAt(0);
								if(milcheck == 'Y') {
									if(mileage + userMoney < roomMoney) {
										System.out.println("�ݾ��� �����մϴ� ������ �ݾ��� ������ �ٽ� �������ּ���.\n"
												+ "������ �ݾ� : "+(roomMoney - (mileage+ userMoney)));
												bReservation = !bReservation;
												break;
									}else {
										if(roomMoney < mileage) {
											mileage -= roomMoney;
											roomMoney = 0;
										}else if(roomMoney >mileage) {
											int tmp = 0;
											tmp = mileage;
											mileage -= roomMoney;
											roomMoney -= tmp;
											userMoney -= roomMoney;
										}
										System.out.println("�����ڴ��� ������ �Է����ּ��� : ");
										name = sc.next();
										userdate[count][0] = name;
										userdate[count][1] = randomNum;
										userdate[count][2] = userchoice+"";
										userdate[count][3] = "Y";
										userdate[count][4] = id;
										userdate2[userid][2] = mileage+"";
										userdate2[userid][3] = userMoney+"";
										System.out.println(name+"�� ������ ������ �Ϸ�Ǿ����ϴ�.");
										room[userchoice/100-1][index-1] = 1;
										bReservation = !bReservation;
										count++;
										randomNum = "";
										System.out.println("���� �� : "+userMoney);
										System.out.println("���� ���ϸ��� : "+mileage);
										break;
									}
								}else if(milcheck == 'N') {
									System.out.println("������ �ݾ��� ������ �ٽ� �������ּ���.\n"
											+"������ �ݾ� : "+(roomMoney-userMoney));
									bReservation = !bReservation;
									break;
								}// ���ϸ��� ��� ���� ����
							}else {
								System.out.println("�����ڴ��� ������ �Է����ּ��� : ");
								name = sc.next();
								userMoney -= roomMoney;
								mileage += 0.10*roomMoney;
								userdate[count][0] = name;
								userdate[count][1] = randomNum;
								userdate[count][2] = userchoice+"";
								userdate[count][3] = "N";
								userdate[count][4] = id;
								userdate2[userid][2] = mileage+"";
								userdate2[userid][3] = userMoney+"";
								room[userchoice/100-1][index-1] = 1;
								bReservation = !bReservation;
								System.out.println(name+"�� ������ ������ �Ϸ�Ǿ����ϴ�.");
								count++;
								randomNum = "";
								System.out.println("���� �� : "+userMoney);
								System.out.println("���� ���ϸ��� : "+mileage);
								break;
							}
							
						}
					}// ���� while�� ��
					bReservation = !bReservation;
					break;
//					case1��
				case 2:
					System.out.println("������ ����Ͻ� ���� �������ּ���. ���ϸ����� ������ ���� �ݾ�ȯ���� �ȵ˴ϴ�.");
					userchoice = sc.nextInt();
					for (int i = 0; i < userdate.length; i++) {
						if(userdate[i][2].equals(userchoice+"")&& userdate[i][3].equals("N") && userdate[i][4].equals(id)) {
							System.out.println("��й�ȣ�� �Է����ּ���.");
							if(sc.next().equals(pw)) {
								room[userchoice/100-1][userchoice%10-1] = 0;
								cancelMoney = Integer.parseInt(roomdate[userchoice/100-1][2]);
								cancelMoney = (int)(cancelMoney*0.80);
								userdate2[userid][3] = cancelMoney+"";
								System.out.println("������ ��ҵǾ����ϴ�. �ش� �� ���ݿ� 80%�� ȯ���ص�Ƚ��ϴ� : "+ cancelMoney+"��");
							}else {
								System.out.println("��й�ȣ�� �ٽ� �Է����ּ���.");
							}
						}else if(userdate[i][2].equals(userchoice+"")&& userdate[i][3].equals("Y") && userdate[i][4].equals(id)) {
							System.out.println("��й�ȣ�� �Է����ּ���.");
							if(sc.next().equals(pw)) {
								room[userchoice/100-1][userchoice%10-1] = 0;
								System.out.println("������ ��ҵǾ����ϴ�. ���ϸ����� �����Ͻ� ���̾ �ݾ�ȯ���� �ȵ˴ϴ�.");
							}else {
								System.out.println("��й�ȣ�� �ٽ� �Է����ּ���.");
							}
							
						}else {
							System.out.println("�Է��Ͻ� ������ ȸ������ �����Ͻ��� �����̽��ϴ�. ������ȸ�� ���� Ȯ�����ּ���. -->6");
						}
					}
					break;
//					���� ��� ��
				case 3:
					System.out.print("��ȸ�Ͻ� ���� ���������ּ���.");
					for (int i = 0; i < roomdate.length; i++) {
						System.out.print(i+1+". "+roomdate[i][0]+"    ");
					}
					userchoice = sc.nextInt();
					for (int i = 0; i < room[userchoice-1].length; i++) {
						if(room[userchoice-1][i] == 0) {
							reservation = "���� ���ɡ�";
						}else {
							reservation = "���� �Ұ���(T_T)";
						}
						System.out.print((userchoice*100+i+1)+"ȣ ("+reservation+")   ");
					}
					System.out.println();
					break;
//					���� ��ȸ ��
				case 4:
					System.out.println(userdate2[userid][0]+"���� ���ϸ����� "+userdate2[userid][2]+"�� ���ҽ��ϴ�.");
					break;
				case 5:
					
					System.out.println("�����Ͻ� �ݾ��� �Է����ּ��� : ");
					userMoney = sc.nextInt();
					userdate2[userid][3] = (userMoney+Integer.parseInt(userdate2[userid][3]))+"";
					System.out.println("������ �Ϸ�Ǿ����ϴ�. ");
					System.out.println("�ܾ� : "+userdate2[userid][3]);
					break;
				case 99: 
					userpower = !userpower;
					System.out.println("�α׾ƿ� �Ǽ̽��ϴ�.");
					id = "";
					pw = "";
//					�α׾ƿ� ��
				default:
					break;
				}
			}
			userpower = !userpower;
			
			
			
		}
	}
}
