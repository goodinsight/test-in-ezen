package reportt;

import java.util.Scanner;

public class Report12_ {
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
		System.out.println("���Ǳ� ����");
		while (!power) {
			System.out.println("\n���� �ݾ�: " + payy);
			System.out.print("�Ŵ�: ");
			for (int i = 0; i < dName.length; i++) {
				System.out.print(dName[i] + "(" + dAmount[i] + "�� ���� " + dPrice[i] + "��)" + " ");
			}
			System.out.println();
			System.out.print("1: ���ֱ� /// 2: ���� /// 3. �ܱݹ�ȯ /// 4. ����\n");
			Scanner scan1 = new Scanner(System.in);
			tmp1 = scan1.nextInt();
			switch (tmp1) {
			case 1:
				System.out.print("�Ա��� �ݾ��� �����ּ���: ");
				Scanner scan2 = new Scanner(System.in);
				payy += scan2.nextInt();
				break;
			case 2:
				if (payy < 1) {
					System.out.println("�ݾ��� �����մϴ� �Ա����ּ���");
					break;
				}
				System.out.println("������ ���� �Ͻðڽ��ϱ�?\n" + "1: " + dName[0] + " 2: " + dName[1] + " 3: " + dName[2]);
				Scanner scan3 = new Scanner(System.in);
				tmp2 = scan3.nextInt();
				switch (tmp2) {
				case 1:
				case 2:
				case 3:
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
				System.out.println("��ȯ �Ϸ�.");
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
					Scanner scan4 = new Scanner(System.in);
					tmp3 = scan4.nextInt();
					switch (tmp3) {
					case 1:
						System.out.println("���� " + dName[0] + " " + dAmount[0] + "��");
						System.out.println("���� " + dName[1] + " " + dAmount[1] + "��");
						System.out.println("���� " + dName[2] + " " + dAmount[2] + "��");

						System.out.println("� ��ǰ�� ��� �����ðڽ��ϱ�?");
						System.out.println("1: " + dName[0] + " 2: " + dName[1] + " 3: " + dName[2]);
						Scanner scan5 = new Scanner(System.in);
						tmp2 = scan5.nextInt();

						System.out.println(dName[tmp2 - 1] + "�� � �����ó���?");
						Scanner scan6 = new Scanner(System.in);

						tmp1 = scan6.nextInt();
						dAmount[tmp2 - 1] += tmp1;
						System.out.println(dName[tmp2 - 1] + "�� ����: " + dAmount[tmp2 - 1]);
						break;
					case 2:
						System.out.println("���� " + dName[0] + " " + dAmount[0] + "��");
						System.out.println("���� " + dName[1] + " " + dAmount[1] + "��");
						System.out.println("���� " + dName[2] + " " + dAmount[2] + "��");

						System.out.println("� ��ǰ�� ��� ���ðٽ��ϱ�?");
						System.out.println("1: " + dName[0] + " 2: " + dName[1] + " 3: " + dName[2]);
						Scanner scan7 = new Scanner(System.in);

						tmp2 = scan7.nextInt();
						System.out.println(dName[tmp2 - 1] + "�� � ���ó���?");

						Scanner scan8 = new Scanner(System.in);
						tmp1 = scan8.nextInt();
						dAmount[tmp2 - 1] -= tmp1;
						System.out.println(dName[tmp2 - 1] + "�� ����: " + dAmount[tmp2 - 1]);
						break;
					case 3:
						System.out.println("� ��ǰ�� ������ �����ϳ���?");
						System.out.println("1: " + dName[0] + " 2: " + dName[1] + " 3: " + dName[2]);
						Scanner scan9 = new Scanner(System.in);
						tmp1 = scan9.nextInt();
						System.out.println(dName[tmp1 - 1] + "�� ������ �󸶷� �����Ͻó���? ����: " + dPrice[tmp1 - 1] + "��");
						Scanner scan10 = new Scanner(System.in);
						tmp4 = scan10.nextInt();
						dPrice[tmp1 - 1] = tmp4;
						System.out.println(dName[tmp1 - 1] + "�� ������ " + dPrice[tmp1 - 1] + "������ �����Ͽ����ϴ�.");
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
