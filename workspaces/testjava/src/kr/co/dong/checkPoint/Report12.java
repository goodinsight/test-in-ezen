package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report12 {
	public static void main(String[] args) {
//		1. ���� ���Ǳ⸦ ��������.
//		2. ���� 3���� ���� / ���� ���� / ����
//		3. ���۰� ���ÿ� ȭ�鿡 �޴��� �����ش�.
//		3-1 ������ ������ ����, ����, �Ž����� ��ȯ, ���Է� ��
//		99. ���Ǳ� ����.	
//		4. 99�̿��� ������ ��� ȭ��޴� �����ֱ�
		boolean power = false, godmod = true;
//		�޴��Է°�, ���� ��, �����̸�1,2,3 / ����1,2,3 , �Ž�����
		int insert = 0, payy = 0, coke = 1300, cofe = 1500, cake = 3000, godd = 0, tmp = 0, tmp2 = 0;
//		  ù��° ���ÿ밪  �� �ݾ�                                   	     ������ ��                              
		int cokeCount = 13, cofeCount = 15, cakeCount = 30; // ����
		int cokeGet = 0, cofeGet = 0, cakeGet = 0; // ���� ��ǰ ����

		System.out.println("�޴�: coke:1300 cofe:1500 cake:3000\n");

		while (!power) { // �Ŀ��� true�� ������ ������ ���ѹݺ�
			System.out.println("\n���Ǳ⿡ �Աݵ� �ݾ�: " + payy);
			System.out.print("1: �Ա� 2: coke���� 3: cofe����: 4: cake���� 5: �ܱ� ��ȯ 6: ����\n");
			System.out.printf("coke %d�� cofe %d�� cake %d�� ���ҽ��ϴ�.\n�Է�:", cokeCount, cofeCount, cakeCount);
			Scanner scan = new Scanner(System.in);
			insert = scan.nextInt();
			switch (insert) {
			case 1:
				System.out.print("\n�Ա��� �ݾ��� �Է��ϼ���: ");
				Scanner scan2 = new Scanner(System.in);
				payy = payy + scan2.nextInt();
				break;
			case 2:
				System.out.println("coke�� ����: " + cokeCount);
				if (cokeCount < 1) {
					System.out.println("coke�� ��� �����մϴ�.");
					break;
				}
				if (payy < coke) {
					System.out.println("�ݾ��� �����մϴ�.");
					break;
				} else {
					payy -= 1300;
				}
				cokeCount--;
				cokeGet++;
				System.out.println("coke ���ſϷ�.");
				break;
			case 3:
				System.out.println("cofe�� ����: " + cofeCount);
				if (cofeCount < 1) {
					System.out.println("cofe�� ��� �����մϴ�.");
					break;
				}
				if (payy < cofe) {
					System.out.println("�ݾ��� �����մϴ�.");
					break;
				} else {
					payy -= 1500;
				}
				cofeCount--;
				cofeGet++;
				System.out.println("cofe ���ſϷ�.");
				break;
			case 4:
				System.out.println("cake�� ����: " + cakeCount);
				if (cakeCount < 1) {
					System.out.println("cake�� ��� �����մϴ�.");
					break;
				}
				if (payy < cake) {
					System.out.println("�ݾ��� �����մϴ�.");
					break;
				} else {
					payy -= 3000;
				}
				cakeCount--;
				cakeGet++;
				System.out.println("cake ���ſϷ�.");
				break;
			case 5:
				System.out.println("�ݾ��� ��ȯ�մϴ�." + payy + "��");
				payy = 0;
				break;
			case 6:
				System.out.println("\n���Ǳ� ����");
				power = true;
				break;
			case 77:
				while (godmod) {
					System.out.println("--�����ڸ��--");
					System.out.print("1. ��ü ���� Ȯ�� 2. ���� ä��� 3. ���� ���� 5. ����\n");
					Scanner scan3 = new Scanner(System.in);
					godd = scan3.nextInt();
					switch (godd) {
					case 1:
						System.out.printf("coke: %d�� cofe %d�� cake %d��\n", cokeCount, cofeCount, cakeCount);
						break;
					case 2:
						System.out.printf("coke %d�� cofe %d�� cake %d�� ���ҽ��ϴ�...\n", cokeCount, cofeCount, cakeCount);
						System.out.print("1: coke ��� �ֱ� 2: cofe ��� �ֱ� 3: cake ��� �ֱ� 4: ����\n");
						Scanner scan4 = new Scanner(System.in);
						tmp = scan4.nextInt();
						switch (tmp) {
						case 1:
							System.out.print("coke�� �󸶳� �ִ°�: ");
							Scanner scan5 = new Scanner(System.in);
							tmp2 = scan5.nextInt();
							cokeCount += tmp2;
							System.out.println("coke�� ����: " + cokeCount);
							break;
						case 2:
							System.out.print("cofe�� �󸶳� �ִ°�: ");
							Scanner scan6 = new Scanner(System.in);
							tmp2 = scan6.nextInt();
							cofeCount += tmp2;
							System.out.println("cofe�� ����: " + cofeCount);
							break;
						case 3:
							System.out.print("cake�� �󸶳� �ִ°�: ");
							Scanner scan7 = new Scanner(System.in);
							tmp2 = scan7.nextInt();
							cakeCount += tmp2;
							System.out.println("cake�� ����: " + cakeCount);
							break;
						case 4:
							break;
						}
						break;
					case 3:
						System.out.printf("coke %d�� cofe %d�� cake %d�� ���ҽ��ϴ�...\n", cokeCount, cofeCount, cakeCount);
						System.out.print("1: coke ��� ���� 2: cofe ��� ���� 3: cake ��� ���� 4: ����\n");
						Scanner scan7 = new Scanner(System.in);
						tmp = scan7.nextInt();
						switch (tmp) {
						case 1:
							System.out.print("coke�� �󸶳� ���°�: ");
							Scanner scan5 = new Scanner(System.in);
							tmp2 = scan5.nextInt();
							cokeCount -= tmp2;
							System.out.println("coke�� ����: " + cokeCount);
							break;
						case 2:
							System.out.print("cofe�� �󸶳� ���°�: ");
							Scanner scan6 = new Scanner(System.in);
							tmp2 = scan6.nextInt();
							cofeCount -= tmp2;
							System.out.println("cofe�� ����: " + cofeCount);
							break;
						case 3:
							System.out.print("cake�� �󸶳� ���°�: ");
							Scanner scan8 = new Scanner(System.in);
							tmp2 = scan8.nextInt();
							cakeCount -= tmp2;
							System.out.println("cake�� ����: " + cakeCount);
							break;
						case 4:
							break;
						}
						break;
					case 5:
						godmod = false;
						break;
					}
				}
				break;
			default:
				System.out.println("�߸��� ���� �ٽ� �Է�");
				break;
			}
		}
		if (payy > 0) {
			System.out.println("�ݾ��� �����ֽ��ϴ�. ��ȯ�� �ݾ�: " + payy + "��");
		}
		System.out.printf("coke %d�� cofe %d�� cake %d�� ���� �Ϸ�", cokeGet, cofeGet, cakeGet);
	}
}
