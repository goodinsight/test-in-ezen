package reportt;

import java.util.Scanner;

public class Report12_v2 {
	public static void main(String[] args) {
//		������ �迭�� ����
		String[] dName = new String[3];
		int[] dPrice = new int[3];
		int[] dAmount = new int[3];

//		���Ǳ⿡ �ʿ��� �͵� ����
		boolean power = false; // �Ŀ��� true�� �Ǹ� while�� Ż��
		boolean godd = false; // �����ڸ���
		int payy = 0; // �Աݱݾ�
		int gott = 0; // ����
		int tmp1 = 0, tmp2 = 0, tmp3 = 0, tmp4 = 0;

//		���� �̸�
		dName[0] = "�ݶ�";
		dName[1] = "���̴�";
		dName[2] = "����";

//		���� ����
		dPrice[0] = 1200;
		dPrice[1] = 1500;
		dPrice[2] = 3000;

//		���� ���
		dAmount[0] = 5;
		dAmount[1] = 10;
		dAmount[2] = 12;

//		���Ǳ� ����
		Scanner scan = new Scanner(System.in);
		System.out.println("���Ǳ� ����");
		while (!power) {
			System.out.println("\n���� �ݾ�: " + payy);
			System.out.print("�Ŵ�: ");
			for (int i = 0; i < dName.length; i++) {
				System.out.print(dName[i] + "(���:" + dAmount[i] + "�� 1��:" + dPrice[i] + "��)" + " ");
			}
			System.out.println();
			System.out.print("1: ���ֱ� /// 2: ���� /// 3. �ܱݹ�ȯ /// 4. ����\n");
			tmp1 = scan.nextInt();
			switch (tmp1) {
			case 1:
				System.out.print("�Ա��� �ݾ��� �����ּ���: ");
				payy += scan.nextInt();
				break;
			case 2:
				if (payy < 1) {
					System.out.println("�ݾ��� �����մϴ� �Ա����ּ���");
					break;
				}
				System.out.println("������ ���� �Ͻðڽ��ϱ�?\n" + "1: " + dName[0] + " 2: " + dName[1] + " 3: " + dName[2]);
				tmp2 = scan.nextInt();
				switch (tmp2) {
				case 1:	case 2:	case 3:
					if (payy < dPrice[tmp2 - 1]) {
						System.out.println("�ݾ��� �����մϴ�.");
						break;
					}
					if (dAmount[tmp2 - 1] < 1) {
						System.out.println("��� �����մϴ�.");
						break;
					}
					payy -= dPrice[tmp2 - 1];
					dAmount[tmp2 - 1]--;
					gott += dPrice[tmp2 - 1];
					System.out.println(dName[tmp2 - 1] + "���ſϷ�");
					break;
				}
				break;
			case 3:
				System.out.println("��ȯ �Ϸ� "+payy+"��");
				payy = 0;
				break;
			case 4:
				System.out.println("\n���Ǳ⸦ �����մϴ�.");
				power = true;
				break;
			case 77:
				while (!godd) {
					System.out.println("---������ ���---");
					System.out.println("1: ���ֱ� /// 2: ��� ���� /// 3. ��ǰ ���� ���� /// 4. ���ͺ��� /// 5. ����");
					tmp2 = scan.nextInt();
					switch (tmp2) {
					case 1:
						System.out.println("���� " + dName[0] + " " + dAmount[0] + "��");
						System.out.println("���� " + dName[1] + " " + dAmount[1] + "��");
						System.out.println("���� " + dName[2] + " " + dAmount[2] + "��");

						System.out.println("� ��ǰ�� ��� �����ðڽ��ϱ�?");
						System.out.println("1: " + dName[0] + " 2: " + dName[1] + " 3: " + dName[2]);
						tmp3 = scan.nextInt();

						System.out.println(dName[tmp3 - 1] + "�� � �����ó���?");
						tmp4 = scan.nextInt();
						dAmount[tmp3 - 1] += tmp4;
						System.out.println(dName[tmp3 - 1] + "�� ����: " + dAmount[tmp3 - 1]);
						break;
					case 2:
						System.out.println("���� " + dName[0] + " " + dAmount[0] + "��");
						System.out.println("���� " + dName[1] + " " + dAmount[1] + "��");
						System.out.println("���� " + dName[2] + " " + dAmount[2] + "��");

						System.out.println("� ��ǰ�� ��� ���ðٽ��ϱ�?");
						System.out.println("1: " + dName[0] + " 2: " + dName[1] + " 3: " + dName[2]);
						tmp2 = scan.nextInt();
						System.out.println(dName[tmp2 - 1] + "�� � ���ó���?");

						tmp1 = scan.nextInt();
						dAmount[tmp2 - 1] -= tmp1;
						System.out.println(dName[tmp2 - 1] + "�� ����: " + dAmount[tmp2 - 1]);
						break;
					case 3:
						System.out.println("� ��ǰ�� ������ �����ϳ���?");
						System.out.println("1: " + dName[0] + " 2: " + dName[1] + " 3: " + dName[2]);
						tmp3 = scan.nextInt();
						System.out.println(dName[tmp3 - 1] + "�� ������ �󸶷� �����Ͻó���? ����: " + dPrice[tmp3 - 1] + "��");
						tmp4 = scan.nextInt();
						dPrice[tmp3 - 1] = tmp4;
						System.out.println(dName[tmp3 - 1] + "�� ������ " + dPrice[tmp3 - 1] + "������ �����Ͽ����ϴ�.");
						break;
					case 4:
						System.out.println("����: " + gott);
						break;
					case 5:
						System.out.println("������ ��� ����");
						godd = true;
						break;
					default:
						System.out.println("�ٽ� �Է��� �ּ���");
						break;
					}
				}
			default:
				System.out.println("�ٽ� �Է��� �ּ���");
				break;
			}
		}
	}
}
