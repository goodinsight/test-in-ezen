/*
 * _1 ���� ����
 * �����ڸ�� �߰�
 * 
 */

package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report11_1 {

	public static void main(String[] args) {
//		1 ���� ���Ǳ� ����
//		2 ���� 3���� / ���� ���� / ��� ����
//		3 ���۰� ���ÿ� ȭ�鿡 �޴� ǥ��
//		3-1	������ ���� �� ����, ���, �Ž�����ȯ, ���Է� ��
//			99.���Ǳ� ����
//		4. 99 �̿��� ������ ��� ȭ�� �޴� ǥ��

//		���� ���� ��ǰ ����

		boolean power = false; // ����
		int input = -1;

		int money = 0;
		int cha = 0;

		int rem1 = 5;
		int rem2 = 5;
		int rem3 = 5;

		int cost1 = 1200;
		int cost2 = 1000;
		int cost3 = 800;

		String menu1 = "�ݶ�";
		String menu2 = "Ŀ��";
		String menu3 = "����";

		int pass = 1111;

		Scanner scan = new Scanner(System.in);

		while (!power) {
			System.out.println();
			System.out.println("[ ���� ���Ǳ� ]");
			System.out.printf("%s / %d�� / ��� : %d%n", menu1, cost1, rem1);
			System.out.printf("%s / %d�� / ��� : %d%n", menu2, cost2, rem2);
			System.out.printf("%s / %d�� / ��� : %d%n", menu3, cost3, rem3);
			System.out.printf("���� �� : %d��%n", money);
			System.out.printf("(1)�� ���� (2)���� ���� (3)�Ž��� ��ȯ (66)������ ��� (99)���Ǳ� ����%n");
			System.out.print("����� �Է����ּ��� : ");
			input = scan.nextInt();

			main: switch (input) {
			case 1:
				int tmp = 0;
				while (!power) {
					System.out.print("�󸶳� �ְڽ��ϱ�? : ");
					tmp = scan.nextInt();
					if (tmp < 0) {
						System.out.println("�ùٸ� �ݾ��� �Է����ּ���.");
					} else {
						money += tmp;
						break;
					}
				}
				break;

			case 2:
				while (!power) {
					System.out.println();
					System.out.printf("(1)%s / %d�� / ��� : %d%n", menu1, cost1, rem1);
					System.out.printf("(2)%s / %d�� / ��� : %d%n", menu2, cost2, rem2);
					System.out.printf("(3)%s / %d�� / ��� : %d%n", menu3, cost3, rem3);
					System.out.printf("���� �� : %d%n", money);
					System.out.printf("���Ḧ �������ּ��� (99=ó������) : ");
					input = scan.nextInt();
					switch (input) {
					case 1:
						if (money < cost1) {
							System.out.printf("%n***���� �����մϴ�.***%n");
							break main;
						} else if (rem1 <= 0) {
							System.out.printf("%n***%s ��� �����ϴ�.***%n", menu1);
							break;
						} else {
							System.out.printf("%s�� 1�� �����߽��ϴ�.%n", menu1);
							money -= cost1;
							rem1--;
						}
						break;
					case 2:
						if (money < cost2) {
							System.out.printf("%n***���� �����մϴ�.***%n");
							break main;
						} else if (rem2 <= 0) {
							System.out.printf("%n***%s ��� �����ϴ�.***%n", menu2);
							break;
						} else {
							System.out.printf("%s�� 1�� �����߽��ϴ�.%n", menu2);
							money -= cost2;
							rem2--;
						}
						break;
					case 3:
						if (money < cost3) {
							System.out.printf("%n***���� �����մϴ�.***%n");
							break main;
						} else if (rem3 <= 0) {
							System.out.printf("%n***%s ��� �����ϴ�.***%n", menu3);
							break;
						} else {
							System.out.printf("%s�� 1�� �����߽��ϴ�.%n", menu3);
							money -= cost3;
							rem3--;
						}
						break;
					case 99:
						break main;

					default:
						System.out.printf("%n�ùٸ� ���ڸ� �Է����ּ���.%n");
						continue;
					}

				}

			case 3:
				cha = money;
				money = 0;
				System.out.printf("�Ž��� %d���� ��ȯ�մϴ�.%n", cha);
				break;

			case 66:
				System.out.print("������ ��ȣ�� �Է����ּ��� : ");
				int tmp2 = scan.nextInt();
				if (tmp2 == pass) {
					while (!power) {
						System.out.printf("%n[ ������ ��� ]%n");
						System.out.printf("(1)��� ���� (2)ǰ�� ���� (3)���� ���� (4)��ȣ ���� (99)������ ��� ����%n");
						System.out.print("����� �Է����ּ��� : ");
						input = scan.nextInt();
						adm: switch (input) {
						case 1:
							while (!power) {
								System.out.printf("%n%s [%d]�� / %s [%d]�� / %s [%d]��%n", menu1, rem1, menu2, rem2, menu3, rem3);
								System.out.printf("(1)%s ��� ���� (2)%s ��� ���� (3)%s ��� ���� (99)��������%n", menu1, menu2,
										menu3);
								System.out.print("����� �Է����ּ��� : ");
								input = scan.nextInt();
								rem: switch (input) {
								case 1:
									System.out.printf("������ %s�� ��� �Է� : ", menu1);
									rem1 = scan.nextInt();
									break;

								case 2:
									System.out.printf("������ %s�� ��� �Է� : ", menu2);
									rem2 = scan.nextInt();
									break;

								case 3:
									System.out.printf("������ %s�� ��� �Է� : ", menu3);
									rem3 = scan.nextInt();
									break;
								case 99:
									break adm;
								default:
									System.out.printf("%n�ùٸ� ���ڸ� �Է����ּ���.%n");
									continue;
								}

							}

						case 2:
							while (!power) {
								System.out.printf("%n���� 1 : [%s] / ���� 2 : [%s] / ���� 3 : [%s]%n", menu1, menu2, menu3);
								System.out.printf("(1)���� 1 ���� (2)���� 2 ���� (3)���� 3 ���� (99)��������%n");
								System.out.print("����� �Է����ּ��� : ");
								input = scan.nextInt();
								name: switch (input) {
								case 1:
									System.out.printf("���� 1 ������ ��ǰ �Է� : ");
									menu1 = scan.next();
									break;
								case 2:
									System.out.printf("���� 2 ������ ��ǰ �Է� : ");
									menu2 = scan.next();
									break;
								case 3:
									System.out.printf("���� 3 ������ ��ǰ �Է� : ");
									menu3 = scan.next();
									break;
								case 99:
									break adm;

								default:
									System.out.printf("%n�ùٸ� ���ڸ� �Է����ּ���.%n");
									continue;
								}

							}

						case 3:
							while (!power) {
								System.out.printf("%n%s [%d]�� / %s [%d]�� / %s [%d]��%n", menu1, cost1, menu2, cost2, menu3,
										cost3);
								System.out.printf("(1)%s ���� ���� (2)%s ���� ���� (3)%s ���� ���� (99)��������%n", menu1, menu2,
										menu3);
								System.out.print("����� �Է����ּ��� : ");
								input = scan.nextInt();
								cost: switch (input) {
								case 1:
									System.out.printf("%s ������ ���� �Է� : ", menu1);
									cost1 = scan.nextInt();
									break;
								case 2:
									System.out.printf("%s ������ ���� �Է� : ", menu2);
									cost2 = scan.nextInt();
									break;
								case 3:
									System.out.printf("%s ������ ���� �Է� : ", menu3);
									cost3 = scan.nextInt();
									break;
								case 99:
									break adm;

								default:
									System.out.printf("%n�ùٸ� ���ڸ� �Է����ּ���.%n");
									continue;
								}

							}

						case 4:
							System.out.printf("%n������ ��ȣ�� �ѹ� �� �Է����ּ��� : ");
							int tmp3 = scan.nextInt();
							if (tmp3 == pass) {
								System.out.print("������ ��ȣ �Է� : ");
								int tmp4 = scan.nextInt();
								System.out.print("������ ��ȣ ���Է� : ");
								int tmp5 = scan.nextInt();
								if (tmp4 == tmp5) {
									pass = tmp4;
									System.out.println("������ ��ȣ�� �����߽��ϴ�.");
									break;
								} else {
									System.out.println("���Է��� ���� �ʽ��ϴ�");
									break;
								}
							} else {
								System.out.println("��ȣ�� Ʋ�Ƚ��ϴ�.");
								break;
							}

						case 99:
							break main;

						default:
							System.out.printf("%n�ùٸ� ���ڸ� �Է����ּ���.%n");
							continue;

						}
					}
				} else {
					System.out.println("��ȣ�� Ʋ�Ƚ��ϴ�");
					break;
				}

			case 99:
				power = true;
				break;

			default:
				System.out.printf("%n�ùٸ� ���ڸ� �Է����ּ���.%n");
				break;
			}

		}

		scan.close();
		System.out.println("���Ǳ� ����");

	} // end of main

} // end of class
