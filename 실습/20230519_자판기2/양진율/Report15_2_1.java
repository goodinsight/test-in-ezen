/*
 *  �ۼ��� : ������		��¥ : 2023.05.19		
 *  
 */

package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report15_2_1 {

	public static void main(String[] args) {

		final int DRINK_MAX = 3;

		boolean power = false; // ����

		Scanner scan = new Scanner(System.in);

		int input = 0;
		int balance = 0;
		int mode = 0;
		/*
		 * mode 
		 * 0 : �ʱ� ȭ�� 
		 * 1 : ���� �ݾ� �Է� 
		 * 2 : ����ó��(���н�, ���� ���� ���. �ݾ� ����/��� ����) 
		 * 3 : �ܾ� ��ȯ 
		 * 4 : ������ ��� -> ����/����/��� ���� 
		 * 		40 : ������ ��� - �ʱ�ȭ�� 
		 * 		41 : ������ ��� - �׸� ���� �ܰ� 
		 * 		42 : ������ ��� - ���� �ܰ� 
		 * 10 : ����
		 */
		boolean tmpflag = false;
		int tmpValue = 0;
		String tmpStr = "";

		String[] dName = null;
		int[] dPrice = null;
		int[] dAmount = null;

		int[] changes = { 1000, 500, 100, 50, 10 };

		int targetIdx = 0;

		
//		ǰ�� �Է�
		dName = new String[] { "Ŀ��", "����", "�����" };
		dPrice = new int[] { 1200, 2900, 2500 };
		dAmount = new int[] { 3, 5, 7 };
		
		
		
		while (!power) {

			switch (mode) {
			case 0:// �ʱ� ȭ��
				System.out.println("\n\n--���Ǳ�-----------------------");// ȭ�� ���
				System.out.print("��ȣ\t�̸�\t����\t���\n");
				for (int i = 0; i < DRINK_MAX; i++) {
					System.out.println((i + 1) + "\t" + dName[i] + "\t" + dPrice[i] + "\t" + dAmount[i]);
				}
				System.out.println("�ܾ� : " + balance);
				System.out.println("-----------------------------");

				System.out.println("�Է� �ȳ�" 
						+ "\n 0\t: �ݾ� ����" 
						+ "\n 1~3\t: �ش� ���� ����" 
						+ "\n 77\t: �ܾ� ȸ��"
						+ "\n 88\t: ������ ���" 
						+ "\n 99\t: ����\n");// ��ɾ� ����

				System.out.print("�����Ͻð� ���� �ൿ�� �Է����ּ���.\n>>");

				try {
					input = scan.nextInt();
					
					if(input >= 1 && input <= DRINK_MAX) {//Ÿ�� ���� �� case ����
						targetIdx = input - 1;
						input = 1;
					}
					
				} catch (Exception e) {
					input = 100;
					scan.nextLine();// ���� �ݺ� ������ ��������
				}

				switch (input) {
				case 0:
					mode = 1;// �ݾ� ����
					break;
				case 1: //case 2: case 3:
					mode = 2;// ���� ����
					break;
				case 77:
					mode = 3;// �ܾ� ��ȯ
					break;
				case 88:
					mode = 40;// ������ ���
					break;
				case 99:
					mode = 10;// ����
					break;
				default:
					System.out.println("�߸��� �Է��Դϴ�.");
				}

				break;// �ʱ� ȭ�� end

			case 1:// �ݾ� ����

				tmpflag = false;

				while (!tmpflag) {
					try {
						System.out.print("���� �ݾ��� �Է����ּ���. \n>>");
						input = scan.nextInt();
						
					} catch (Exception e) {
						input = -1;
						scan.nextLine();// ���� �ݺ� ������ ��������
					}

					if (input >= 0) {
						balance += input;
						tmpflag = true;
					} else {
						System.out.println("�߸��� �Է��Դϴ�.");
					}

				}

				mode = 0;// �ʱ�ȭ������
				break;// �ݾ����� end

			case 2:// ���� ����

				// ���� �� ���
				if (balance < dPrice[targetIdx]) {
					System.out.println("�ܾ��� �����մϴ�.");
					mode = 0;
					break;
				} else if (dAmount[targetIdx] == 0) {
					System.out.println("��� �����մϴ�.");
					mode = 0;
					break;
				} else {
					balance -= dPrice[targetIdx];
					dAmount[targetIdx]--;

					System.out.printf("%s��(��) �����մϴ�.\n", dName[targetIdx]);
					System.out.printf("�ܾ� : %d -> %d\n", balance + dPrice[targetIdx], balance);
				}

				mode = 0;// �ʱ�ȭ������
				break;//�������� end

			case 3:// �ܾ� ȸ��

				System.out.printf("�ܾ� %d���� ȸ���մϴ�.\n", balance);

				for (int i = 0; i < changes.length; i++) {
					if (balance / changes[i] > 0) {
						System.out.println(changes[i] + "�� " + balance / changes[i] + "��(��)");
						balance %= changes[i];
					}
				}

				mode = 0;// �ʱ�ȭ������
				break;// �ܾ� ȸ�� end

			case 40:// ������ ��� - �ʱ� ȭ��

				tmpflag = false;

				while (!tmpflag) {
					System.out.println("\n\n--���� ǰ��---------------------");// ���� ȭ�� ��¹�
					System.out.printf("��ȣ\t�̸�\t����\t���\n");
					for (int i = 0; i < DRINK_MAX; i++) {
						System.out.println((i + 1) + "\t" + dName[i] + "\t" + dPrice[i] + "\t" + dAmount[i]);
					}
					System.out.println("-----------------------------");
					System.out.println("99\t���");
					System.out.println("-----------------------------");

					System.out.print("�����Ͻð� ���� ǰ���� ��ȣ�� �Է����ּ���.\n>>");
					try {
						input = scan.nextInt();
					} catch (Exception e) {
						input = -1;
						scan.nextLine();// ���� �ݺ� ������ ��������
					}

					if (input >= 1 && input <= DRINK_MAX) {// ǰ�� ���ý�
						targetIdx = input - 1;
						mode = 41;// ������ ��� - �׸� ��������
						tmpflag = true;
					} else if (input == 99) {// ��� ���ý�
						mode = 0;// �ʱ� ȭ������
						tmpflag = true;
					} else {
						System.out.println("�߸��� �Է��Դϴ�.");
					}

				}
				break;//������ ��� - �ʱ� ȭ�� end

			case 41:// ������ ��� - �׸� ����

				tmpflag = false;

				while (!tmpflag) {

					System.out.print("\n\n1) ��ǰ �̸� : " + dName[targetIdx] 
							+ "\n2) ��ǰ ���� : " + dPrice[targetIdx]
							+ "\n3) ��ǰ ��� : " + dAmount[targetIdx] 
							+ "\n99) ���" 
							+ "\n�����Ͻð� ���� �׸��� ��ȣ�� �Է����ּ���.\n>>");

					try {
						input = scan.nextInt();
					} catch (Exception e) {
						input = -1;
						scan.nextLine();// ���� �ݺ� ������ ��������
					}

					if (input >= 1 && input <= 3) {// �׸� ���ý�
						mode = 42;// ������ ��� - ���� �ܰ��
						tmpflag = true;
					} else if (input == 99) {// ��� ���ý�
						mode = 0;// �ʱ� ȭ������
						tmpflag = true;
					} else {
						System.out.println("�߸��� �Է��Դϴ�.");
					}

				}
				break;// ������ ��� - �׸� ���� end

			case 42:// ������ ��� - ���� �ܰ�

				tmpflag = false;

				switch (input) {
				case 1:// �̸� ����
					while (!tmpflag) {
						System.out.printf("\n\n���� �̸� : %s\n", dName[targetIdx]);
						System.out.print("���ο� �̸��� �Է����ּ���. (5���� ����)\n>>");
						tmpStr = scan.next();

						if (tmpStr.length() > 5) {
							System.out.println("�̸��� �ʹ� ��ϴ�.");
						} else if (tmpStr.length() == 0) {
							System.out.println("�� ���� �̻� �Է����ּ���.");
						} else {
							dName[targetIdx] = tmpStr;
							tmpflag = true;
						}
					}

					break;// ������ ��� - ���� �ܰ� end

				case 2:// ���� ����
					while (!tmpflag) {
						System.out.printf("\n\n���� ���� : %d\n", dPrice[targetIdx]);
						System.out.print("���ο� ������ �Է����ּ���. (50000�� ����)\n>>");

						try {
							tmpValue = scan.nextInt();

							if (tmpValue > 50000) {
								System.out.println("�����ϰ����ϴ� ������ �ʹ� �����ϴ�.");
							} else if (tmpValue < 0) {
								System.out.println("0 �̻��� ������ �Է����ּ���.");
							} else {
								dPrice[targetIdx] = tmpValue;
								tmpflag = true;
							}

						} catch (Exception e) {
							System.out.println("�߸��� �Է��Դϴ�.");
							scan.nextLine();// ���� �ݺ� ������ ��������
						}

					}

					break;// ���� ���� end
					
				case 3:// ��� ����
					while (!tmpflag) {
						System.out.printf("\n\n���� ��� : %d\n", dAmount[targetIdx]);
						System.out.print("����ġ�� �Է����ּ���. (���� �ִ� 50)\n>>");

						try {

							tmpValue = scan.nextInt();

							if (tmpValue + dAmount[targetIdx] > 50) {
								System.out.println("�߰��ϰ��� �ϴ� ���� �ʹ� Ů�ϴ�.");
							} else if (tmpValue + dAmount[targetIdx] < 0) {
								System.out.println("��� ���� �����մϴ�.");
							} else {
								dAmount[targetIdx] += tmpValue;
								tmpflag = true;
							}

						} catch (Exception e) {
							System.out.println("�߸��� �Է��Դϴ�.");
							scan.nextLine();// ���� �ݺ� ������ ��������
						}

					}

				}

				mode = 40;// ������ ��� - �ʱ� ȭ������
				break;// ��� ���� end

			case 10:// ����
				System.out.println("�ŷ��� �����մϴ�.");
				power = true;
			}

		}

	}

}
