package kr.co.dong.checkTest;

import java.util.Scanner;

public class CheckTest23 {
	public static void main(String[] args) {
		// ����ִ� ���� = 0 , ����� ���� = 1
				// �߰�����
				// 1. ���ǱԸ�(ũ��)�� ���۰� ���ÿ� �Է���
				// 2. ȣ�ڹ��ȣ / ȣ�ڹ�� (��-�ξ� / ������ ��) / �����ο� / ����
				// 3. ����� �����ڸ� / �����ȣ(��ҽ� �ʿ�) ��
				// 4. ��Ÿ �ʿ��� ��� (�����ڸ��)
				Scanner scan = new Scanner(System.in);
				int roomChoice = 0; // ���ǹ�ȣ ����
				int roomSize = 0; // ���ǰ��� ����
				String answer = ""; // Y or N
				int[] roomCheck = null; // ���ǿ������
				int[] roomNum = null; // ���ǹ�ȣ
				String[] roomName = null; // �����̸�
				int[] roomPer = null; // �����ο�
				int[] roomPrice = null; // ���ǰ���
				String[] reserveName = null; // �������̸�
				int[] reserveNum = null; // �����ȣ
				String nameCheck = null; // �������̸� Ȯ��
				int numCheck = 0; // �����ڹ�ȣ Ȯ��
				// ��ư���
				int menu = 0;
				// �����ڸ��
				int password = 4444;
				int input_pass = 0;
				// �������
				String check0 = "���డ�ɡ�";
				String check1 = "����Ұ��ɡ�";
				// ����
				boolean power = false;

				while (!power) {
					if(roomSize == 0) {
						System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
						System.out.println("�����ڸ�忡�� �ʱ⼳���� �ʿ��մϴ�.");
						System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
					}
					System.out.println("=======================");
					System.out.println("     ȣ�ڿ���/�����ý���");
					System.out.println("=======================");
					System.out.println("     1. �մԸ��");
					System.out.println("     2. �����ڸ��");
					System.out.println("     99. �����ϱ�");
					System.out.println("=======================");
					System.out.print("    �޴��� �Է����ּ��� : ");
					menu = scan.nextInt();
					switch (menu) {
					case 1: // �մԿ�
						if (roomSize == 0) { // �� ������ ������� �غ���
							System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
							System.out.println("    ���� �غ� �� �Դϴ�.");
							System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
						} else {
							while (menu != 88) {
								System.out.println("=======================");
								System.out.println("     1. ���ǿ���");
								System.out.println("     2. �������");
								System.out.println("     3. ���ǻ���Ȯ��");
								System.out.println("     88. ó������");
								System.out.println("=======================");
								System.out.print("    �޴��� �Է����ּ��� : ");
								menu = scan.nextInt();
								switch (menu) {
								case 1: // ���ǿ���
									System.out.println("=======================");
									System.out.print("���Ͻô� �� ��ȣ�� �Է����ּ���(1~" + roomCheck.length + ") : ");
									roomChoice = scan.nextInt();
									if (roomCheck[roomChoice - 1] == 0) { // ���డ���ҽ�
										System.out.println("=======================");
										System.out.println("  " + roomChoice + "�� ���� �����ϼ̽��ϴ�.");
										System.out.println("=======================");
										System.out.println("���ǹ�ȣ : " + roomNum[roomChoice - 1]);
										System.out.println("�����̸� : " + roomName[roomChoice - 1]);
										System.out.println("�����ο� : " + roomPer[roomChoice - 1]);
										System.out.println("���ǰ��� : " + roomPrice[roomChoice - 1]);
										System.out.println("=======================");
										System.out.print("  �����Ͻðڽ��ϱ� ? (Y/N) : ");
										answer = scan.next().toUpperCase();
										if (answer.equals("Y")) { // ��������
											System.out.println("=======================");
											System.out.print(" �����ڸ��� �Է����ּ��� : ");
											reserveName[roomChoice - 1] = scan.next();
											System.out.println("=======================");
											System.out.print(" �����ȣ�� �Է����ּ��� : ");
											reserveNum[roomChoice - 1] = scan.nextInt();
											roomCheck[roomChoice - 1] = 1;
											System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
											System.out.println("    ������ �Ϸ� �Ǿ����ϴ�.");
											System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
										} else { // ��������
											System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
											System.out.println("      ��� �Ǿ����ϴ�.");
											System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
										}
									} else { // ����Ұ��ɽ�
										System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
										System.out.println(roomChoice + "�� ������ �̹� ����Ǿ����ϴ�");
										System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
									}
									break;
								case 2: // �������
									System.out.println("=======================");
									System.out.print("���Ͻô� �� ��ȣ�� �Է����ּ���(1~" + roomCheck.length + ") : ");
									roomChoice = scan.nextInt();
									if (roomCheck[roomChoice - 1] == 1) { // ��Ұ����ҽ�
										System.out.println("=======================");
										System.out.println("  " + roomChoice + "�� ���� �����ϼ̽��ϴ�.");
										System.out.println("=======================");
										System.out.println("���ǹ�ȣ : " + roomNum[roomChoice - 1]);
										System.out.println("�����̸� : " + roomName[roomChoice - 1]);
										System.out.println("�����ο� : " + roomPer[roomChoice - 1]);
										System.out.println("���ǰ��� : " + roomPrice[roomChoice - 1]);
										System.out.println("=======================");
										System.out.print("  ����Ͻðڽ��ϱ� ? (Y/N) : ");
										answer = scan.next().toUpperCase();
										if (answer.equals("Y")) { // �������
											System.out.println("=======================");
											System.out.print(" �����ڸ��� �Է����ּ��� : ");
											nameCheck = scan.next();
											if (reserveName[roomChoice - 1].equals(nameCheck)) { // �̸�üũ
												System.out.println("=======================");
												System.out.print(" �����ȣ�� �Է����ּ��� : ");
												numCheck = scan.nextInt();
												if (reserveNum[roomChoice - 1] == numCheck) { // �����ȣ üũ
													roomCheck[roomChoice - 1] = 0; // ������� ����
													reserveName[roomChoice - 1] = null; // �������̸� ����
													reserveNum[roomChoice - 1] = 0; // �����ڹ�ȣ ����
													System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
													System.out.println("    ��Ұ� �Ϸ� �Ǿ����ϴ�.");
													System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
												} else { //��ȣ�ٸ���
													System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
													System.out.println("   �����ȣ�� Ȯ�����ּ���.");
													System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
												}
											} else { // �̸��ٸ���
												System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
												System.out.println("   �����ڼ����� Ȯ�����ּ���.");
												System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
											}
										} else { // �������
											System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
											System.out.println("      ��� �Ǿ����ϴ�.");
											System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
										}
									} else { // ��ҺҰ��ɽ�
										System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
										System.out.println(roomChoice + "�� ������ ����Ǿ����� �ʽ��ϴ�.");
										System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
									}
									break;
								case 3: // ���ǻ���Ȯ��
									System.out.println("=======================");
									for (int i = 0; i < roomSize; i++) {
										System.out.printf("%d�� ����(%dȣ / %s / %d�� / %d��) : ", i + 1, roomNum[i], roomName[i],
												roomPer[i], roomPrice[i]);
										if (roomCheck[i] == 0) {
											System.out.println(check0);
										} else if (roomCheck[i] == 1) {
											System.out.println(check1);
										}
									}
									break;
								case 88:
									break;
								default: // �߸��� ��ȣ �Է½�
									System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
									System.out.println("   �ùٸ� ��ȣ�� �Է����ּ���.");
									System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
								}
							}
						}
						break;
					case 2: // �����ڿ�
						System.out.println("=======================");
						System.out.println("  �����ڸ�带 �����ϼ̽��ϴ�.");
						System.out.println("=======================");
						System.out.print("  ��й�ȣ�� �Է��� �ּ��� : ");
						input_pass = scan.nextInt();
						if (input_pass == password) {
							while (menu != 88) {
								System.out.println("=======================");
								System.out.println("     1. �����ʱ⼳��");
								System.out.println("     2. ���ǻ��¼���");
								System.out.println("     3. ������ȲȮ��");
								System.out.println("     88. ó������");
								System.out.println("=======================");
								System.out.print("    �޴��� �Է����ּ��� : ");
								menu = scan.nextInt();
								switch (menu) {
								case 1: // �����ʱ⼳��
									System.out.println("=======================");
									System.out.print("    ���� ũ�⸦ �Է����ּ��� : ");
									roomSize = scan.nextInt(); // �Է��� ������ �ε��� �ο�(���� ����)
									roomCheck = new int[roomSize];
									roomNum = new int[roomSize];
									roomName = new String[roomSize];
									roomPer = new int[roomSize];
									roomPrice = new int[roomSize];
									reserveName = new String[roomSize];
									reserveNum = new int[roomSize];
									for (int i = 0; i < roomSize; i++) { // �� ������ �ο� (��ȣ, �̸�, �ο�, ����)
										roomNum[i] = 101 + i;
										if (i > 5) {
											roomName[i] = "�йи�";
											roomPer[i] = 4;
											roomPrice[i] = 100000;
										} else if (i > 3) {
											roomName[i] = "����Ʈ";
											roomPer[i] = 2;
											roomPrice[i] = 90000;
										} else if (i > 1) {
											roomName[i] = "�����̾�";
											roomPer[i] = 2;
											roomPrice[i] = 80000;
										} else {
											roomName[i] = "�𷰽�";
											roomPer[i] = 2;
											roomPrice[i] = 70000;
										}
									}
									break;
								case 2: // ���ǻ��¼���
									System.out.println("������");
									break;
								case 3: // ������ȲȮ��
									System.out.println("=======================");
									for (int i = 0; i < roomSize; i++) {
										System.out.printf("%d�� ����(%dȣ/%s) - ������ : %s / �����ȣ : %d ", i + 1, roomNum[i],
												roomName[i], reserveName[i], reserveNum[i]);
										System.out.println();
									}
									break;
								case 88: // ó������ ���ư�(�ݺ��� Ż��)
									break;
								default: // �߸��� ��ȣ �Է½�
									System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
									System.out.println("   �ùٸ� ��ȣ�� �Է����ּ���.");
									System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
								}
							}
						} else {
							System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
							System.out.println("   �߸��� ��й�ȣ �Դϴ�.");
							System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
						}
						break;
					case 99: // ����
						power = true;
						break;
					default:
						System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
						System.out.println("   �ùٸ� ��ȣ�� �Է����ּ���.");
						System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
					}
				}
				System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
				System.out.println("   �̿��� �ּż� �����մϴ�.");
				System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
			}
		}
