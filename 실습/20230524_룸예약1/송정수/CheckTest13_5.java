package kr.co.dong.checkPoint;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class CheckTest13_5 {
	public static void main(String[] args) {
//		Ű���忡 ���� �Է��ۼ�
//		��12���� �ְ� =>����?�迭? => �迭 ����room[12]
//		�Է±�������	//menu����:1,2,3,99�� �Է¹���
//		1�� �������� ���� ����,	//room[���ȣ]�� ���� 1�̸� �������
//			1->ȣ�ǹ�ȣ ����(1~12) -> ������¿��� Ȯ��
//		->���డ�ɻ��� -> ����ǽ� ->ȣ��Ȯ�� => �޴��� ����
//		->����Ұ����� -> ȣ�ǹ�ȣ ����(1~12) or �޴��� ����
//		2�� ���� ��� �������(����->����),	//room[���ȣ]�� ���� 0�̸� ����
//				2-> ȣ�ǹ�ȣ����(1~12)->��Ұ��ɿ���
//			->��Ұ���: �ش�ȣ���� ���� 0���� =>�޴�����
//			->��ҺҰ�: ����������� ���̶�� ǥ��. =>�޴�����
//		3�� ���� ���� ȣ�� Ȯ��,	//1�� ���� "�����:��"0�ΰ��� "���డ�ɡ�"
//		99�� ���� ���� ���α׷�����.
//		=> �߰����� : 1.���ǱԸ�(ũ��)�� ���۰� ���ÿ� �Է���  ȣ�� �� �氳��
//				    2.ȣ�ڹ��ȣ/ȣ�ڹ��(��-�ξ�/������ ��)/�����ο�/����
//					3.����� �����ڸ�/�����ȣ(��ҽ� �ʿ�) ��
//					4.��Ÿ �ʿ��� ���(�����ڸ��)
		Scanner scan = new Scanner(System.in);
		boolean power = false; // ���α׷� ����
		String name = "";		//������ �̸� Ȯ��
		int num = 0;			//�����ȣ Ȯ��
		int person = 0;			//�����ο� Ȯ��
		int roomnum = 0;		//ȣ�� �Է�	
		int pay = 0;			//���� �ݾ�
		int tmp = 0;			//���� �ݾ� ����
		int count = 0;			
		int sel = 0; // ����
		int[][] room = new int[3][]; // ���� ����
		String[][] preorder = new String[50][3];	//������ ������	(ȣ��-�̸�-��ȣ)
		String[][] sweet = new String[3][3];	//ȣ��ǥ
		sweet[0][0] = "���ڳ��";
		sweet[0][1] = "45000";
		sweet[0][2] = "2";
		sweet[1][0] = "�����Ͻ�";
		sweet[1][1] = "60000";
		sweet[1][2] = "3";
		sweet[2][0] = "�ξ�";
		sweet[2][1] = "80000";
		sweet[2][2] = "4";
		String possible = ""; // ���డ�� �Ұ��� ǥ��
		for (int i = 0; i < room.length; i++) {
			System.out.println(i + 1 + "�� ���� ���� �Է� : ");
			sel = scan.nextInt();
			room[i] = new int[sel+1];
		}
		room[0][0] = 1; // ��
		room[1][0] = 2; // ��
		room[2][0] = 3; // ��
		
		
		while (!power) {// ȣ�ڸ޴� ����
			System.out.println("=====ȣ�� �޴�=====");
			System.out.println("1.ȣ�ǿ��� 2.������� 3.ȣ��Ȯ�� 4.�����ݾ� ���� 99.����");
			System.out.println("���Ͻô� ���� ��ȣ�� �Է��ϼ��� : ");
			System.out.println("�����ݾ� : "+pay);
			sel = scan.nextInt();

			switch (sel) {
			case 1: // ȣ�� ����
				System.out.println("===ȣ�� ���� �޴�===");
				for (int i = 0; i < sweet.length; i++) {
					System.out.println(i + 1 + "�� : " + sweet[i][0] + "(�����ִ��ο�:" + sweet[i][2] + ")" + "�ݾ�:" + sweet[i][1] + "��");
				}
				System.out.println("���Ͻô� ���� �Է����ּ��� : ");
				sel = scan.nextInt();
				if(pay < Integer.parseInt(sweet[sel-1][1])) {
					System.out.println("�ݾ��� �����մϴ�.");
				}else {
					for (int i = 1; i < room[sel-1].length; i++) {
						if (i % 5 == 0) {
							System.out.println();
						}
						if (room[sel-1][i] == 0) {
							possible = "���� ����";
						} else {
							possible = "�̹� ����Ǿ���";
						}
						System.out.print((sel*100+ i) + "ȣ��  " + possible + "   ");
					}
					System.out.println();
					System.out.println("���Ͻô� ȣ��(�ǵڼ��ڸ�)�� �Է����ּ��� : ");
					roomnum = scan.nextInt();
					if (room[sel-1][roomnum] == 1) {
						System.out.println("�̹� ����� ȣ���Դϴ�.\n�ٸ�ȣ���� �������ּ���.");
					} else {
						System.out.println("�����ο��� �Է����ּ��� : ");
						person = scan.nextInt();
						if(Integer.parseInt(sweet[sel-1][2]) < person) {
							System.out.println("���� �ִ��ο����� �ѽ��ϴ�.");
							break;
						}else {
						System.out.println("�����Ͻôº��� ������ �Է����ּ��� : ");
						scan.nextLine();
						preorder[count][0] = sel*100+roomnum+"";
						preorder[count][1] = scan.nextLine();
						preorder[count][2] = (int) (Math.random() * 999) + 1+"";
						System.out.println("�����ȣ : " + preorder[count][2] + "�Դϴ�.\n��������Ҷ� �ʿ��ϴ� �� ������ּ���.");
						room[sel-1][roomnum] = 1;
						pay -= Integer.parseInt(sweet[sel-1][1]);
						count++;
						}
					}
				}
				break;
			case 2: // ȣ�� �������
				System.out.println("===���� ��� �޴�===");
				System.out.println("������ ȣ���� �Է����ּ��� : ");
				roomnum = scan.nextInt();
				for (int i = 0; i < preorder.length; i++) {
					if(roomnum == Integer.parseInt(preorder[i][0])) {
						System.out.println("�����ȣ�� �Է����ּ��� : ");
						num = scan.nextInt();
						if(num == Integer.parseInt(preorder[i][2])) {
							System.out.println("������ ��ҵǾ����ϴ�.");
							if((roomnum/10)%10 != 0) {
							room[roomnum/100-1][roomnum%10+10] = 0;
							pay += Integer.parseInt(sweet[roomnum/100-1][1]);
							System.out.println(Integer.parseInt(sweet[roomnum/100-1][1]));
							
							}else {
								room[roomnum/100-1][roomnum%10] = 0;
								pay += Integer.parseInt(sweet[roomnum/100-1][1]);
								System.out.println(Integer.parseInt(sweet[roomnum/100-1][1]));
								break;
							}
						}else {
							System.out.println("���� ��ȣ�� Ʋ���ϴ�.");
							break;
						}
					}else {
						System.out.println("������ ȣ���� Ʋ���ϴ�.");
						break;
					}
				}
				break;
			case 3: // ȣ�� �����Ȳ
				System.out.println("===ȣ�� ���� ��Ȳ Ȯ�� �޴�===");
				System.out.println("���Ͻô� ���� �Է����ּ��� : ");
				sel = scan.nextInt();
				System.out.println(room[sel-1][0]+"�� : "+sweet[sel-1][0]);
				for (int i = 1; i < room[sel-1].length; i++) {
					if (i % 5 == 0) {
						System.out.println();
					}
					if (room[sel-1][i] == 0) {
						possible = "���� ����";
					} else {
						possible = "�̹� ����Ǿ���";
					}
					System.out.print((sel*100+ i) + "ȣ��  " + possible + "   ");
				}
				System.out.println();
				break;
			case 4:	//�����ݾ� ����
				System.out.println("������ �ݾ��� �Է��ϼ��� : ");
				pay += scan.nextInt();
				tmp = pay;
				break;
			case 99:
				System.out.println("����");
				power = true;
				break;
				default :
					System.out.println("�ٽ� �Է��Ͻʽÿ�.");
			}// switch����
		} // while����

	}

}
