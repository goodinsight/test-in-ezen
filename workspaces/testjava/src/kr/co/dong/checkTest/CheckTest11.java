package kr.co.dong.checkTest;

import java.util.Scanner;

import javax.management.loading.PrivateClassLoader;

public class CheckTest11 {
	public static void main(String[] args) {

		boolean power = true; // ����
		String[][] room = null; // ���Ǻ� ����
		int[][] resNum = null; // ���Ǻ� ���� �ο�, ���� ��ȣ
		String[] resName = null; // ���Ǻ� ������ �̸�
		boolean[] rAbl = null; // ���Ǻ� ���� ���� ����
		int roomCount = 0; // ����� ���� ��
		String input = null; // �ܼ� �Է°�
		int count = 0; // for���� ����ϴ� �ӽ� ī��Ʈ
		int cmm = 0; // ����ġ ����
		int idx = 0; // �ܼ� �Է°����� �����Ǵ� �迭 �ε���
		int tmp = 0; // �ܼ� �Է°� int ��ȯ �� �ӽ� ����
		int tmp2 = 0; // tmp���� �����ؾ��� �� ���Ǵ� �ι�° �ӽ� ����
		int[] roomSize = null; // ���Ǻ� �Ը�
		String[] log = null; // ���� ����
		int logMax = 10; // ���� ���� �ִ�ġ
		int logCount = 0; // ���� ���� �ε��� ����

		String[][] roomD = { // ���Ǻ� ���� �⺻��
				{ "101", "�̱�A", "1��", "50000" }, { "102", "�̱�B", "1��", "50000" }, { "103", "�̱�C", "1��", "50000" },
				{ "104", "�̱�D", "1��", "50000" }, { "201", "����A", "2��", "100000" }, { "202", "����B", "2��", "100000" },
				{ "203", "����C", "2��", "100000" }, { "204", "����D", "2��", "100000" }, { "301", "����A", "4��", "200000" },
				{ "302", "����B", "4��", "200000" }, { "303", "����C", "4��", "200000" }, { "304", "����D", "4��", "200000" }, };
		room = new String[12][4]; // ���Ǻ� ���� �ʱ�ȭ
		for (int i = 0; i < room.length; i++) {
			for (int j = 0; j < room[0].length; j++) {
				room[i][j] = roomD[i][j];
			}
		}
		resNum = new int[12][2]; // ���Ǻ� ���� �ο�, ���� ��ȣ �ʱ�ȭ
		resName = new String[12]; // ���Ǻ� ������ �̸� �ʱ�ȭ
		rAbl = new boolean[12]; // ���Ǻ� ���� ���� ���� �ʱ�ȭ
		for (int i = 0; i < rAbl.length; i++) {
			rAbl[i] = true;
		}
		roomSize = new int[12]; // ���Ǻ� �Ը� �ʱ�ȭ
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 4; j++) {
				if (i == 3) {
					continue;
				}
				roomSize[idx] = i;
				idx += 1;
			}
		}
		log = new String[logMax]; // ���� ���� �ʱ�ȭ
		int pass = 1111; // ������ ��ȣ �ʱ�ȭ

		Scanner scan = new Scanner(System.in); // Scanner Ŭ���� ȣ��
		CheckTest11 ra = new CheckTest11(); // RoomArr11_1 Ŭ���� ȣ��

		while (power) { // ù ȭ��
			System.out.println();
			System.out.println("[ȣ�� ���� ���α׷�]");
			System.out.println("(1)����� ���� �޴� (2)������ ��� (99)����");
			System.out.print("�׸� ��ȣ�� �Է����ּ��� : ");

			input = scan.nextLine();
			cmm = ra.toInt(input);
			if ((cmm != 1 && cmm != 2 && cmm != 99) || cmm == -1) {
				System.out.println("***�ùٸ� ��ȣ�� �Է����ּ���.***");
				continue;
			}

			switch (cmm) {
			case 1: // ����� ���� �޴�
				while (true) {
					System.out.println();
					System.out.println("[���� �޴�]");
					System.out.println("(1)���� (2)���� Ȯ��/��� (3)���� ���� (99)ù ȭ�� ����");
					System.out.print("�׸� ��ȣ�� �Է����ּ��� : ");

					input = scan.nextLine();
					cmm = ra.toInt(input);

					if ((cmm != 1 && cmm != 2 && cmm != 3 && cmm != 99) || cmm == -1) {
						System.out.println("***�ùٸ� ��ȣ�� �Է����ּ���.***");
						continue;
					}

					switch (cmm) {
					case 1: // ����
						while (true) {
							if (roomCount == room.length) {
								System.out.println("***���� ���� ������ ������ �����ϴ�.***");
								break;
							}
							tmp2 = ra.maxNum(roomSize);
							System.out.print("�ִ� " + tmp2 + "������� ������ �ο� ���� �Է����ּ���.(���:99) : ");
							input = scan.nextLine();
							tmp = ra.toInt(input);
							if (tmp == 99) {
								break;
							} else if (tmp > tmp2) {
								System.out.println("***�ִ� " + tmp2 + "������� ������ �����մϴ�.***");
								continue;
							} else if (tmp < 1) {
								System.out.println("***�ùٸ� �ο� ���� �Է����ּ���.***");
								continue;
							}

							count = 0;
							for (int i = 0; i < room.length; i++) {
								if (rAbl[i] == true && tmp <= roomSize[i]) {
									count += 1;
								}
							}
							if (count == 0) {
								System.out.println("***" + tmp + "�� ���� ������ ������ �����ϴ�.***");
								break;
							}

							System.out.println();
							System.out.println("[���� ������ ����]");
							System.out.println(" ��ȣ ȣ�� ���Ǹ� �Ը�  ���డ��");

							for (int i = 0; i < room.length; i++) {
								if (rAbl[i] == true && tmp <= roomSize[i]) {
									System.out.printf("(%2d) %s %s %s %7s%n", i + 1, room[i][0], room[i][1], room[i][2],
											room[i][3]);
								}
							}
							System.out.print("������ ���� ��ȣ�� �Է����ּ���. (99:���) : ");
							input = scan.nextLine();
							idx = ra.toInt(input) - 1;
							if (idx == 98) {
								break;
							} else if (idx > room.length || idx < 0 || rAbl[idx] == false || tmp > roomSize[idx]) {
								System.out.println("***�ùٸ� ���� ��ȣ�� �Է����ּ���.***");
								continue;
							}

							System.out.println(room[idx][0] + "ȣ " + room[idx][1] + " ������ �����մϴ�.");
							System.out.print("������ �̸��� �Է����ּ���. : ");
							resName[idx] = scan.nextLine();

							while (true) {
								System.out.print("���� ��ȣ�� �ۼ����ּ���.(4�ڸ�) : ");
								input = scan.nextLine();
								tmp2 = ra.toInt(input);
								if (tmp2 > 9999 || tmp2 < 1000 || tmp2 == -1) {
									System.out.println("***�ùٸ� ���� ��ȣ�� �ۼ����ּ���.***");
									continue;
								}

								count = 0;
								for (int i = 0; i < room.length; i++) {
									if (tmp2 == resNum[i][1]) {
										System.out.println("***�ߺ��� ���� ��ȣ�Դϴ�.***");
										count += 1;
										break;
									}
								}
								if (count > 0) {
									continue;
								}

								break;
							}

							resNum[idx][0] = tmp;
							resNum[idx][1] = tmp2;
							rAbl[idx] = false;
							roomCount += 1;

							System.out.printf("%n%sȣ %s ������ %s �� %d�� ���࿡�� ����Ǿ����ϴ�.%n", room[idx][0], room[idx][1],
									resName[idx], resNum[idx][0]);

							if (logCount >= log.length) {
								for (int i = 1; i < log.length; i++) {
									log[i - 1] = log[i];
								}
								log[logCount - 1] = room[idx][0] + "ȣ " + room[idx][1] + " - " + resName[idx];
							} else {
								log[logCount] = room[idx][0] + "ȣ " + room[idx][1] + " - " + resName[idx];
								logCount += 1;
							}

							break;

						}

						continue;

					case 2: // ���� Ȯ��/���
						while (true) {
							System.out.print("���� ��ȣ�� �Է����ּ���.(99:���) : ");
							input = scan.nextLine();
							tmp = ra.toInt(input);
							if (tmp == 99) {
								break;
							} else if (tmp > 9999 || tmp < 1000 || tmp2 == -1) {
								System.out.println("***�ùٸ� ���� ��ȣ�� �Է����ּ���.***");
								continue;
							}

							count = 0;
							for (int i = 0; i < room.length; i++) {
								if (tmp == resNum[i][1]) {
									idx = i;
									count += 1;
								}
							}

							if (count == 0) {
								System.out.println("***��ϵ� ���� ��ȣ�� �����ϴ�.***");
								break;
							}

							System.out.printf("%s �� %d�� ����, %sȣ %s ���� ����Ǿ��ֽ��ϴ�.%n", resName[idx], resNum[idx][0],
									room[idx][0], room[idx][1]);

							while (true) {
								System.out.print("������ ����Ͻðڽ��ϱ�?(y/n) : ");
								input = scan.nextLine();
								if (!(input.equals("y")) && !(input.equals("n"))) {
									continue;
								}
								break;
							}

							if (input.equals("n")) {
								System.out.println("������ �����˴ϴ�.");
								break;
							}
							System.out.println("������ ����߽��ϴ�.");
							resName[idx] = null;
							resNum[idx][0] = 0;
							resNum[idx][1] = 0;
							rAbl[idx] = true;

							break;
						}

						continue;

					case 3: // ���� ����
						System.out.println();
						System.out.println("[���� ����]");
						System.out.println(" ��ȣ  ȣ��  ���Ǹ� �Ը�  ���డ��");
						for (int i = 0; i < room.length; i++) {
							System.out.printf("(%2d) %sȣ %s %2s %7s ", i + 1, room[i][0], room[i][1], room[i][2],
									room[i][3]);
							if (rAbl[i]) {
								System.out.print("���డ�ɡ�");
							} else {
								System.out.print("����Ұ���");
							}
							System.out.println();
						}

						continue;

					case 99: // ù ȭ�� ����

						break;
					}
					break;

				}

				break;

			case 2: // ������ ���
				System.out.print("������ ��ȣ�� �Է����ּ���. : ");
				input = scan.nextLine();
				tmp = ra.toInt(input);
				if (tmp != pass) {
					System.out.println("***������ ��ȣ�� ���� �ʽ��ϴ�.***");
					break;
				}

				while (true) {
					System.out.println();
					System.out.println("[������ ���]");
					System.out.println("(1)���� ���� ���� (2)���� ���� ���� (3)��ü �缳�� (4)���� ���� (99)ù ȭ�� ����");
					System.out.print("�׸� ��ȣ�� �Է����ּ���. : ");
					input = scan.nextLine();
					cmm = ra.toInt(input);
					if (cmm == 99) {
						break;
					} else if ((cmm != 1 && cmm != 2 && cmm != 3 && cmm != 4 && cmm != 99) || cmm == -1) {
						System.out.println("***�ùٸ� ��ȣ�� �Է����ּ���.***");
						continue;
					}
					switch (cmm) {
					case 1: // ���� ���� ����
						while (true) {
							System.out.println();
							System.out.println("[���� ����]");
							System.out.println(" ��ȣ  ȣ�� ���Ǹ� �Ը�  ���డ��");
							for (int i = 0; i < room.length; i++) {
								System.out.printf("(%2d) %sȣ %s %s %7s%n", i + 1, room[i][0], room[i][1], room[i][2],
										room[i][3]);
							}

							System.out.print("������ ������ ���� ��ȣ�� �Է����ּ���.(99:���) : ");
							input = scan.nextLine();
							tmp = ra.toInt(input);
							if (tmp == 99) {
								break;
							} else if (tmp < 1 || tmp > room.length || tmp == -1) {
								System.out.println("***�ùٸ� ���� ��ȣ�� �Է����ּ���.***");
								continue;
							}
							idx = tmp - 1;

							while (true) {
								System.out.printf("(%2d) %sȣ %s %s %7s%n", idx + 1, room[idx][0], room[idx][1],
										room[idx][2], room[idx][3]);
								System.out.println("(1)���� �̸� ���� (2)���� �Ը� ���� (3)���� ���� ���� (99)�ٸ� ���� ����");
								System.out.print("�׸� ��ȣ�� �Է����ּ���. : ");
								input = scan.nextLine();
								cmm = ra.toInt(input);
								if (cmm == 99) {
									break;
								} else if ((cmm != 1 && cmm != 2 && cmm != 3) || cmm == -1) {
									System.out.println("***�ùٸ� �׸� ��ȣ�� �Է����ּ���.***");
									continue;
								}

								switch (cmm) {
								case 1: // ���� �̸� ����
									System.out.print("������ �̸��� �Է����ּ���.");
									room[idx][1] = scan.nextLine();

									break;

								case 2: // ���� �Ը� ����
									tmp2 = ra.maxNum(roomSize);
									System.out.print("������ �Ը� �Է����ּ���.(�ִ� " + tmp2 + "��) : ");
									input = scan.nextLine();
									tmp = ra.toInt(input);

									if (tmp < 1) {
										System.out.println("***1�� �̻��� �Ը� �Է����ּ���.***");
										continue;
									} else if (tmp > 8) {
										System.out.println("***" + tmp2 + "�� ������ �Ը� �Է����ּ���***");
										continue;
									}
									roomSize[idx] = tmp;
									room[idx][2] = tmp + "��";

									break;

								case 3: // ���� ���� ����
									System.out.print("������ ������ �Է����ּ��� : ");
									input = scan.nextLine();
									tmp = ra.toInt(input);
									if (tmp < 0) {
										System.out.println("***0 �̻��� ������ �Է����ּ���.***");
										continue;
									}
									room[idx][3] = tmp + "";

									break;

								}

							}
						}
						continue;

					case 2: // ���� ���� ����
						while (true) {
							System.out.println();
							System.out.println("[���� ����]");
							System.out.println(" ��ȣ  ȣ�� ���Ǹ� �Ը�  ���డ��");
							for (int i = 0; i < room.length; i++) {
								System.out.printf("(%2d) %sȣ %s %s %7s ", i + 1, room[i][0], room[i][1], room[i][2],
										room[i][3]);
								if (rAbl[i]) {
									System.out.print("���డ�ɡ�");
								} else {
									System.out.printf("����Ϸ�� %s %d�� %d ", resName[i], resNum[i][0], resNum[i][1]);
								}
								System.out.println();
							}

							System.out.print("������ ������ ���� ��ȣ�� �Է����ּ���.(99:���) : ");
							input = scan.nextLine();
							tmp = ra.toInt(input);
							if (tmp == 99) {
								break;
							} else if (tmp < 1 || tmp > room.length || tmp == -1) {
								System.out.println("***�ùٸ� ���� ��ȣ�� �Է����ּ���.***");
								continue;
							}
							idx = tmp - 1;
							while (true) {
								System.out.printf("(%2d) %sȣ %s %s %7s ", idx + 1, room[idx][0], room[idx][1],
										room[idx][2], room[idx][3]);
								if (rAbl[idx]) {
									System.out.print("���డ�ɡ�");
								} else {
									System.out.printf("����Ϸ�� %s %d�� %d ", resName[idx], resNum[idx][0], resNum[idx][1]);
								}
								System.out.println();
								System.out.println("(1)������ ���� (2)���� �ο� ���� (3)���� ���� ���� (4)���� ��� (99)�ٸ� ���� ����");
								System.out.print("�׸� ��ȣ�� �Է����ּ���. : ");
								input = scan.nextLine();
								cmm = ra.toInt(input);
								if (cmm == 99) {
									break;
								} else if ((cmm != 1 && cmm != 2 && cmm != 3 && cmm != 4) || cmm == -1) {
									System.out.println("***�ùٸ� �׸� ��ȣ�� �Է����ּ���.***");
									continue;
								}
								switch (cmm) {
								case 1: // ������ ����
									System.out.print("������ ������ �̸��� �Է����ּ���. : ");
									resName[idx] = scan.nextLine();

									break;

								case 2: // ���� �ο� ����
									System.out.print("������ ���� �ο��� �Է����ּ���.(" + roomSize[idx] + "�� ����) : ");
									input = scan.nextLine();
									tmp = ra.toInt(input);
									if (tmp < 1 || tmp > roomSize[idx]) {
										System.out.println("***�ùٸ� �ο��� �Է����ּ���.***");
										continue;
									}
									resNum[idx][0] = tmp;

									break;

								case 3: // ���� ���� ����
									System.out.println("���� ����/�Ұ� ���¸� �����մϴ�.");
									rAbl[idx] = !rAbl[idx];

									break;

								case 4: // ���� ���
									while (true) {
										System.out.print("���� ������ �����ϰڽ��ϱ�?(y/n) : ");
										input = scan.nextLine();
										if (!(input.equals("y")) && !(input.equals("n"))) {
											continue;
										}
										break;
									}

									if (input.equals("n")) {
										System.out.println("���� ������ �����˴ϴ�.");
										break;
									}
									System.out.println("���� ������ �����߽��ϴ�.");
									resName[idx] = null;
									resNum[idx][0] = 0;
									resNum[idx][1] = 0;
									rAbl[idx] = true;

									break;
								}
							}
						}
						continue;

					case 3: // ��ü �缳��
						while (true) {
							System.out.println();
							System.out.println("(1)�ű� �缳�� (2)�⺻�� ����");
							System.out.print("�׸� ��ȣ�� �Է����ּ���.(99:���) : ");
							input = scan.nextLine();
							cmm = ra.toInt(input);
							if (cmm == 99) {
								break;
							}
							if (cmm != 1 && cmm != 2 || cmm == -1) {
								System.out.println("�ùٸ� �׸� ��ȣ�� �Է����ּ���.");
								continue;
							}

							switch (cmm) {
							case 1: // �ű� �缳��
								while (true) {
									System.out.print("��ü ���� ���� �ű� ������ �����ϰڽ��ϱ�?(y/n) : ");
									input = scan.nextLine();
									if (!(input.equals("y")) && !(input.equals("n"))) {
										continue;
									}
									break;
								}
								if (input.equals("n")) {
									System.out.println("��ҵǾ����ϴ�.");
									break;
								}

								System.out.println("[�ű� ������ �����մϴ�.]");
								System.out.println("1. ȣ�� �Ը� ����");

								while (true) {
									System.out.print("ȣ���� ������ �Է����ּ��� : ");
									input = scan.nextLine();
									tmp = ra.toInt(input);
									if (tmp < 0) {
										System.out.println("***1�� �̻��� ������ �Է����ּ���.***");
										continue;
									}
									break;
								}
								while (true) {
									System.out.print("ȣ�� ���� ���� ���� �Է����ּ���. : ");
									input = scan.nextLine();
									tmp2 = ra.toInt(input);
									if (tmp2 < 0) {
										System.out.println("***1�� �̻��� ���� ���� �Է����ּ���.***");
										continue;
									}
									break;
								}
								room = new String[tmp * tmp2][4];
								resNum = new int[tmp * tmp2][2];
								resName = new String[tmp * tmp2];
								roomSize = new int[tmp * tmp2];
								rAbl = new boolean[tmp * tmp2];
								for (int i = 0; i < rAbl.length; i++) {
									rAbl[i] = true;
								}

								idx = 0;
								for (int i = 1; i <= tmp; i++) {
									for (int j = 1; j <= tmp2; j++) {
										if (j < 10) {
											room[idx][0] = i + "0" + j;
											idx += 1;
										} else {
											room[idx][0] = i + "" + j;
											idx += 1;
										}
									}
								}

								while (true) {
									System.out.println("2. ���� ���� �Է�");
									for (int i = 0; i < room.length; i++) {
										System.out.printf("(%2d) %s %s %s %s%n", i + 1, room[i][0], room[i][1],
												room[i][2], room[i][3]);
									}
									System.out.print("������ �Է��� ���� ��ȣ�� �Է����ּ���. : ");
									input = scan.nextLine();
									idx = ra.toInt(input) - 1;
									if (idx < 0 || idx >= room.length) {
										System.out.println("***�ùٸ� ���� ��ȣ�� �Է����ּ���.***");
										continue;
									}

									System.out.printf("%sȣ�� �ִ� �ο��� �Է����ּ���. : ", room[idx][0]);
									input = scan.nextLine();
									tmp = ra.toInt(input);
									if (tmp < 1) {
										System.out.println("***1�� �̻��� �ִ� �ο��� �Է����ּ���.***");
										continue;
									}
									room[idx][2] = tmp + "��";
									roomSize[idx] = tmp;

									System.out.printf("%sȣ�� ���� �̸��� �Է����ּ���. : ", room[idx][0]);
									room[idx][1] = scan.nextLine();

									System.out.printf("%sȣ�� ���� ������ �Է����ּ���. : ", room[idx][0]);
									input = scan.nextLine();
									tmp = ra.toInt(input);
									if (tmp < 0) {
										System.out.println("***0 �̻��� ������ �Է����ּ���.***");
										continue;
									}
									room[idx][3] = tmp + "";

									count = 0;
									for (int i = 0; i < room.length; i++) {
										for (int j = 0; j < room[i].length; j++) {
											if (room[i][j] == null) {
												count += 1;
											}
										}
									}

									if (count == 0) {
										System.out.println("��� ������ �ű� ������ �ԷµǾ����ϴ�.");
										break;
									}

								}

								break;

							case 2: // �⺻�� ����
								while (true) {
									System.out.print("��� ���� ������ �ʱ�ȭ�ϰڽ��ϱ�?(y/n) : ");
									input = scan.nextLine();
									if (!(input.equals("y")) && !(input.equals("n"))) {
										continue;
									}
									break;
								}
								if (input.equals("n")) {
									System.out.println("��ҵǾ����ϴ�.");
									break;
								}

								room = new String[12][4];
								for (int i = 0; i < room.length; i++) {
									for (int j = 0; j < room[0].length; j++) {
										room[i][j] = roomD[i][j];
									}
								}
								resNum = new int[12][2];
								resName = new String[12];
								rAbl = new boolean[12];
								for (int i = 0; i < rAbl.length; i++) {
									rAbl[i] = true;
								}
								idx = 0;
								roomSize = new int[12];
								for (int i = 1; i <= 4; i++) {
									for (int j = 1; j <= 4; j++) {
										if (i == 3) {
											continue;
										}
										roomSize[idx] = i;
										idx += 1;
									}
								}

								System.out.println("��� ���� ������ �⺻������ �ʱ�ȭ�Ǿ����ϴ�.");

								break;
							}

						}

						continue;

					case 4: // ���� ����
						while (true) {
							System.out.println();
							System.out.println("(1)���� Ȯ�� (2)���� ���� (3)���� �뷮 ����");
							System.out.print("�׸� ��ȣ�� �Է����ּ���.(99:���) : ");

							input = scan.nextLine();
							cmm = ra.toInt(input);

							if (cmm != 1 && cmm != 2 && cmm != 3 && cmm != 99 || cmm == -1) {
								System.out.println("***�ùٸ� �׸� ��ȣ�� �Է����ּ���.***");
							} else if (cmm == 99) {
								break;
							}

							switch (cmm) {
							case 1: // ���� Ȯ��
								System.out.println();
								count = 0;
								for (int i = 0; i < log.length; i++) {
									if (log[i] != null) {
										System.out.println(log[i]);
										count += 1;
									}
								}
								if (count == 0) {
									System.out.println("���� ������ �����ϴ�.");
								}

								break;

							case 2: // ���� ����
								while (true) {
									System.out.println("���� ������ ���� �����մϱ�?(y/n) : ");
									input = scan.nextLine();
									if (!(input.equals("n")) && !(input.equals("y"))) {
										continue;
									} else if (input.equals("n")) {
										System.out.println("��ҵǾ����ϴ�.");
										break;
									}
									log = new String[logMax];
									logCount = 0;

									break;
								}

								break;

							case 3: // ���� �뷮 ����
								while (true) {
									System.out.println("���� ���� �ִ� ���� ���� : " + logMax);
									System.out.println("*����� ���� ������ ���� �����˴ϴ�.*");
									System.out.print("������ �ִ� ���� ������ �Է����ּ���.(99:���) : ");
									input = scan.nextLine();
									tmp = ra.toInt(input);
									if (tmp < 1) {
										System.out.println("***1 �̻��� ���� ������ �Է����ּ���***");
										continue;
									} else if (tmp == 99) {
										break;
									}
									logMax = tmp;
									log = new String[logMax];

									break;

								}

								break;
							}

						}

						continue;

					case 99: // ù ȭ�� ����
						break;
					}

					break;
				}
				break;

			case 99: // ����
				System.out.println("�����մϴ�.");
				scan.close();
				power = false;

			} // end of switch main

		} // end of while(power)

	} // end of main

	int toInt(String str) { // int ��ȯ ����ó�� �޼ҵ�
		try {
			int result = Integer.parseInt(str);
			return result;
		} catch (Exception e) {
			return -1;
		}
	} // end of toInt

	int maxNum(int x[]) { // �迭 �ִ밪 �޼ҵ�
		int max = x[0];
		for (int i = 1; i < x.length; i++) {
			if (x[i] > max) {
				max = x[i];
			}
		}
		return max;
	} // end of maxNum

} // end of class
