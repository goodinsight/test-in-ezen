package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Hotel04_3 {

	public static void main(String[] args) {
//		�� 12���� �ְ� �迭 room[12]
//		�Է±������� menu���� : 1,2,3,99�� �Է¹���
//		1.�� ����
//		1�� ���� ���� ���� ���� => room[���ȣ]�� ���� 1�̸� �������
//		1-> ȣ�ǹ�ȣ ����(1~12) -> ������¿��� Ȯ��
//		->���డ�ɻ��� -> ����ǽ� -> ȣ��Ȯ�� => �޴��� ����

//		2.���� ���
//		2�� ���� ��� ���� ���(����-> ����) -> room[���ȣ]�� ���� 0�̸� ����
//		2-> ȣ�ǹ�ȣ ����(1~12) -> ��Ұ��ɿ���
//		-> �ּҰ��� : �ش�ȣ���� ���� 0���� => �޴� ����
//		-> ��ҺҰ� : ����������� ���̶�� ǥ�� => �޴�����

//		3. ȣ��Ȯ��
//		1��-> "�����:��" 0��-> "���డ�ɡ�"
//		99 ������ ���α׷� ����

//		=> �߰����� : 1. ���ǱԸ�(ũ��)�� ���۰� ���ÿ� �Է�(�� ȣ�ڿ� ������ � �ִ���)
//		            2. ȣ�ڹ��ȣ/ȣ�ڹ��(ex-�ξ�/������ ��)/�����ο�/����
//		            3. ���� �� �����ڸ�/�����ȣ(��ҽ� �ʿ�)/��ȭ��ȣ ��
//		            4. ��Ÿ �ʿ��� ���(�����ڸ��)

		boolean power = false;
		int[] room = null; // 0,1 ���� ���� Ȯ��
		int[] n = null; // ���ȣ
		String[] name = null; // �� �̸�
		int[] hu = null; // �ο�
		int[] price = null; // �氡��
		String[] s = null; // ������ �̸�
		int[] nb = null; // �����ȣ
		String sCheck = null; // �����ڸ� Ȯ��
		int nbCheck = 0; // �����ȣ Ȯ��
		int password = 1202; // ��й�ȣ
		int pass = 0; //��й�ȣ Ȯ��
		int pass1 = 0; // ���� ������ �����ȣ
		int ran = 0; //���� �����ȣ
//		int[] ran = null; //���� �����ȣ
    
//		int[] room = {101 ,102 ,103, 104, 105, 106 }; // �� ��ȣ
		int roomN = -1; // ����ũ��
		String[] menu = { "�� ����", "���� ���", "ȣ�� Ȯ��", "����" }; // �޴���ȣ
		int menu1 = 0; // �޴�����
		int button = 0; // ������, ����� ���� ��ȣ

		Scanner scan = new Scanner(System.in);

		System.out.println("���� ũ�⸦ �Է����ּ���: "); // �Է��Ѱ� �� ����  >6��
		roomN = scan.nextInt();
		room = new int[roomN];
		n = new int[roomN]; // ���ȣ
		name = new String[roomN];// �� �̸�
		hu = new int[roomN];// �ο�
		price = new int[roomN];// �氡��
		s = new String[roomN];// ������ �̸�
		nb = new int[roomN];// �����ȣ
//		ran = new int[9]; //���� �����ȣ

		for (int i = 0; i < roomN; i++) { //�� ȣ��
			n[i] = 101 + i;
		}
		for (int i = 0; i < roomN; i++) { // �� �̸�, ����
			hu[i] = 4;
			if (n[i] <= 102) {
				name[i] = "�Ϲ�";
				price[i] = 30000;
			} else if (n[i] <= 104) {
				name[i] = "���ٴٵ�";
				price[i] = 50000;
			} else if (n[i] <= 106) {
				name[i] = "VIP";
				price[i] = 80000;
			}
			System.out.printf("�� %dȣ %s %d��\n", n[i], name[i], price[i]);
		}

		while (!power) {
			System.out.println();
			System.out.println("====================================================");
			System.out.println("�ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ�  Menu  �ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ�");
			System.out.println("�� 1. �� ���� 2. ���� ��� 3. ȣ�� Ȯ�� 66. �����ڸ�� 99. ����");
			System.out.println("====================================================");
			System.out.println("�� ���ϴ� �޴��� �������ּ���.");
			menu1 = scan.nextInt();
//		room �� 0�϶� = ���� ����, room �� 1�϶� = ���� �Ұ���
			switch (menu1) {
			case 1: // ����
				System.out.println("��" + menu[menu1 - 1] + "���� �����ϼ̽��ϴ�.");
				System.out.println();
				System.out.println("�����Ͻô� Room�� �������ּ���(1~"+roomN+"): ");
				button = scan.nextInt();
				if (button > 0 && button <= room.length && room[button - 1] == 0) {
					System.out.println("�� �����Ͻ� " + button + "�� ���� ���� �����մϴ�.");
					System.out.println("�� �����ڸ��� �Է����ּ���: ");
					s[button - 1] = scan.next();
					for(int i=0; i<1; i++) {
						ran = (int)(Math.random() * 9999) + 1000; // ���� �����ȣ 1000~9999
						for(int j=0; j<nb.length; j++) {
							if(ran == nb[j]) {
								i--;
							}
						}
					}
					nb[button-1] = ran;
					System.out.println("�� �����ȣ: " + ran );
//					nb[button - 1] = scan.nextInt();
					room[button - 1] = 1;
				} else if (button > 0 && button <= room.length && room[button - 1] == 1) {
					System.out.println("�� �����Ͻ� " + button + "�� ���� �̹� ����� ���Դϴ�.");
				} else {
					System.out.println("�� Ȯ�ε��� �ʴ� ���Դϴ�. �ٽ� �������ּ���.");
				}
				break;
			case 2: // ������� //���⼭ button�� �� ��ȣ
				System.out.println("��" + menu[menu1 - 1] + "���� �����ϼ̽��ϴ�.");
				System.out.println("������Ͻ� Room ��ȣ�� �Է��ϼ���(1~"+roomN+"): ");
				button = scan.nextInt();
				if (button > 0 && button <= room.length && room[button - 1] == 1) {
					System.out.println("�� �����ڸ��� �Է����ּ���: ");
					sCheck = scan.next();
					if(s[button-1].equals(sCheck)) {//s=����
						System.out.println("�� �����ȣ�� �Է����ּ���: ");
						nbCheck = scan.nextInt();
						if(nb[button-1]==nbCheck) {
							room[button - 1] = 0;
							s[button-1] = null;
							nb[button-1] = 0;
							System.out.println("�� �����Ͻ� " + button + "�� ���� ���������� ��ҵǾ����ϴ�.");
						} else {
							System.out.println("�� ��Ȯ���� ���� �����ȣ�Դϴ�.");
						}
					} else {
						System.out.println("�� ��Ȯ���� ���� �������Դϴ�.");
					}
					
				} else if (button > 0 && button <= room.length && room[button - 1] == 0) {
					System.out.println("�� �����Ͻ� " + button + "�� ���� ���� ���� ���� ���Դϴ�.");
				} else {
					System.out.println("�� ��ȣ�� �ٽ� �Է����ּ���.");
				}
				break;
			case 3: // ȣ��Ȯ��
				for (int j = 0; j < roomN; j++) {
					System.out.print(n[j] + "ȣ��");
					if (room[j] == 1) {
						System.out.println("�ڡ��̹� ����� ���Դϴ١ڡ�");
					} else if (room[j] == 0) {
						System.out.println(" �ٿ����� �����մϴ١�");
					}
				}
				break;
			case 66: //������
				System.out.println("�� ��й�ȣ�� �Է��ϼ��� : ");
				pass = scan.nextInt();
				if(pass == password) {
					System.out.println("================================================");
					System.out.println("                    Menu                        ");
					System.out.println("�� 1. ����Ȯ�� 2. ���ݺ��� 3. ��й�ȣ ���� 99. ����");
					System.out.println("================================================");
					System.out.println("�� ���ϴ� �޴��� �������ּ���.");
					menu1 = scan.nextInt();
					switch(menu1) {
					case 1:
						System.out.println("=====================");
						System.out.println("  ��ȣ��  ������  �����ȣ");
						System.out.println("=====================");
						for(int i=0; i<roomN; i++) {
							if(s[i] != sCheck); {
								if(s[i]==null) {
									s[i] = "     ";
								
								}
							System.out.printf("%5sȣ %5s %6s \n",n[i],s[i],nb[i]);
							} //%5 => ���ں� ����(ĭ ��?)
						}
						System.out.println("=====================");
						break;
					case 2: //���ݺ���
						for(int i=0; i<roomN; i++) {
							System.out.println(i+1 +"��"+ " "+ n[i]+" "+ name[i]+ " "+price[i]+" "+hu[i]);
						}
						System.out.println("�� ��ȣ�� �Է����ּ���.");
						menu1 = scan.nextInt(); //�Է��� ��ȣ ����
						System.out.println("�� ������ ������ �Է����ּ���.");
						price[menu1-1] = scan.nextInt(); // �ٲ� ���� ����
						break;
					case 3: //��й�ȣ ����
						System.out.println("�� ���ο� ��й�ȣ�� �Է��ϼ���.");
						pass1 = scan.nextInt();
						if(password == pass1) { // ���� ��й�ȣ�� ������
							System.out.println("�� ���� ��й�ȣ�� �����ϴ�. �ٸ��ɷ� �������ּ���.");
						}else { // ���� ��й�ȣ�� �ٸ���
							System.out.println("�� ������ ��й�ȣ�� " + pass1 + "�� �´��� Ȯ���ϼ���.");
							password = pass1;
						}
						break;
					case 99: //����(���ư���)
						power = true;
						System.out.println("====== �����ڸ�带 �����մϴ� ======");
						break;
					default:
						System.out.println("!!! �߸� �����̽��ϴ�. �ٽ� �������ּ��� !!!");
					}
				} else if(password != pass) {
					System.out.println("!!! ��й�ȣ�� �ٽ� �Է��ϼ��� !!!");
				}
				break;
			case 99: // ����
				power = true;
				System.out.println("====== ����â�� ����˴ϴ�:) ======");
				break;

			default:
				System.out.println("!!! �߸� �����̽��ϴ�. �ٽ� �������ּ��� !!!");
			}
		}
	}
}

