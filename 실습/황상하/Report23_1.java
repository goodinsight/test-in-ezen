package checkPoint;

import java.util.Scanner;

public class Report23 {

	public static void main(String[] args) {
		// 1. ���� ���Ǳ⸦ ��������.
		// 2. ���� 3������ ���� / ���ݺ��� / ����
		// 3. ���۰� ���ÿ� ȭ�鿡 �޴��� �����ش�
		// 3-1.������ ���� �� ���� , ����, �Ž����� ��ȯ/ ���Է� ��
		// (99. ���Ǳ� ����)
		// 4. 99�̿��� ������ ��� ȭ��޴� �����ֱ�.

		boolean power = false; // ����
		// �޴� �Է°�, ���� ��, �����̸�1/2/3, ���� 1/2/3, �Ž�����
		int button = 0;
		int money = 0;
		int change = 0;
		String drink1 = "coca zero";
		String drink2 = "pepsi zero";
		String drink3 = "cidar zero";
		int drink1_s = 10;
		int drink2_s = 9;
		int drink3_s = 8;
		int drink1_m = 1000;
		int drink2_m = 2000;
		int drink3_m = 3000;

		Scanner scan = new Scanner(System.in);

		while (!power) {
			System.out.println("======================");
			System.out.println("         ���Ǳ�         ");
			System.out.println("======================");
			System.out.println("     1. ����� Ȯ���ϱ⡡�� ");
			System.out.println("     99. �����ϱ⡡�������� ");
			System.out.println("======================");
			System.out.println("   �޴��� ������ �ּ��� : ");
			button = scan.nextInt();
			
			while (button != 99) {				
				if (button == 1) {
					System.out.println("=============================");
					System.out.printf("%s(%d��) / ���(%d��)\n", drink1, drink1_m, drink1_s);
					System.out.printf("%s(%d��) / ���(%d��)\n", drink2, drink2_m, drink2_s);
					System.out.printf("%s(%d��) / ���(%d��)\n", drink3, drink3_m, drink3_s);
					System.out.println("=============================");
					System.out.println("        1. �ݾ� �����ϱ�         ");
					System.out.println("        99. ���� �ϱ�           ");
					System.out.println("=============================");
					System.out.println("      �޴��� ������ �ּ��� :       ");
					button = scan.nextInt();
					if (button == 1) {
						System.out.println("=========================");
						System.out.println("   ������ �ݾ��� �Է����ּ��� :      ");
						System.out.println("=========================");
						money += scan.nextInt();

						while (button != 99) {
							System.out.println("=============================");
							System.out.printf("      ���� �ܾ� : %d��\n", money);
							System.out.println("=============================");
							System.out.printf("1. %s(%d��) / ���(%d��)\n", drink1, drink1_m, drink1_s);
							System.out.printf("2. %s(%d��) / ���(%d��)\n", drink2, drink2_m, drink2_s);
							System.out.printf("3. %s(%d��) / ���(%d��)\n", drink3, drink3_m, drink3_s);
							System.out.println("4. �ݾ� �߰� �����ϱ�");
							System.out.println("99. �����ϱ� (�Ž����� ��ȯ)        ");
							System.out.println("=============================");
							System.out.println("      �޴��� ������ �ּ��� :       ");
							button = scan.nextInt();
							if (button == 1) {
								if (money >= drink1_m && drink1_s != 0) {
									money -= drink1_m;
									drink1_s -= 1;
									System.out.println("=============================");
									System.out.println("     " + drink1 + "�� ���Խ��ϴ�.");
								} else if (drink1_s == 0) {
									System.out.println("=============================");
									System.out.println("          ��� ����");
									System.out.println("     �ٸ� ��ǰ�� �������ּ���.");
								} else {
									System.out.println("=============================");
									System.out.println("          �ܾ� ����");
									System.out.println("      �ݾ��� �� �Է����ּ���.");
								}
							} else if (button == 2) {
								if (money >= drink2_m && drink2_s != 0) {
									money -= drink2_m;
									drink2_s -= 1;
									System.out.println("=============================");
									System.out.println("     " + drink2 + "�� ���Խ��ϴ�.");
								} else if (drink2_s == 0) {
									System.out.println("=============================");
									System.out.println("          ��� ����");
									System.out.println("     �ٸ� ��ǰ�� �������ּ���.");
								} else {
									System.out.println("=============================");
									System.out.println("          �ܾ� ����");
									System.out.println("      �ݾ��� �� �Է����ּ���.");
								}
							} else if (button == 3) {
								if (money >= drink3_m && drink3_s != 0) {
									money -= drink3_m;
									drink3_s -= 1;
									System.out.println("=============================");
									System.out.println("     " + drink3 + "�� ���Խ��ϴ�.");
								} else if (drink2_s == 0) {
									System.out.println("=============================");
									System.out.println("          ��� ����");
									System.out.println("     �ٸ� ��ǰ�� �������ּ���.");
								} else {
									System.out.println("=============================");
									System.out.println("          �ܾ� ����");
									System.out.println("      �ݾ��� �� �Է����ּ���.");
								}
							} else if (button == 4) {
								System.out.println("=========================");
								System.out.println("   ������ �ݾ��� �Է����ּ��� :      ");
								System.out.println("=========================");
								money += scan.nextInt();
							} else if (button == 99) {
								System.out.println("=============================");
								System.out.printf("     %d���� �ݳ� �Ǿ����ϴ�.\n", money);
								System.out.println("=============================");
								power = true;
							} else {
								System.out.println("=============================");
								System.out.println("     �ùٸ� �޴��� ������ �ּ���. ");
							}
						}
					} else if (button == 99) {
						power = true;
					} else {
						System.out.println("=============================");
						System.out.println("     �ùٸ� �޴��� ������ �ּ���. ");
						button = 1;
					}
				} else if (button == 99) {
					power = true;
				} else {
					System.out.println("======================");
					System.out.println(" �ùٸ� �޴��� ������ �ּ���.");
					break;
				}
			}
		}
		System.out.println("���Ǳ� ����!!");
	}
}
