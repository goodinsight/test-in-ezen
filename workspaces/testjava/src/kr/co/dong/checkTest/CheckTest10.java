/*���� -> �ҽ��ۼ� - >�����
 * Ű���忡 ���� �Է��ۼ�
 * ��12�����ְ� =>����? �迭? =>�迭room[12]
 * �Է±�������					//menu���� : 1,2,3,99�� �Է¹���
 * 1�� ������� �� ���� ����,     //room[���ȣ]�� ���� 1 �̸� �������
 *    1->ȣ�ǹ�ȣ ����(1~12) -> ������¿��� Ȯ��
 *    ->���డ�ɻ��� -> ����ǽ� ->ȣ��Ȯ�� => �޴��� ����
 *    ->����Ұ����� -> ȣ�ǹ�ȣ ����(1~12)or �޴��� ����
 * 2�� ���� ��� �������(����->����), //room[���ȣ]�� ���� 0�̸� ����
 * 					2->ȣ�ǹ��㼱��(1~12) -> ��Ұ��ɿ���
 * 				->��Ұ��� : �ش�ȣ���� ���� 0���� =>�޴�����
 * 				->��ҺҰ� : ����������� ���̶�� ǥ�� =>�޴�����
 * 3�� ���� ���� ȣ��Ȯ��, // 1�� ���� "�����:��"0�� ����"���డ�ɡ�"    
 * 99�� �������� ���α׷�����
 * 
 * =>�߰����� :	1.���ǱԸ�(����)�� ���۰� ���ÿ� �Է��� 
 * 			 	2.ȣ�ڹ��ȣ/Ȧ�ڹ��(��-�ξ�/������ ��)/�����ο�/����
 *  		 	3.����� �����ڸ�/�����ȣ(��ҽ� �ʿ�)��
 *				4.��Ÿ �ǿ��� ���(�����ڸ��)
 */

package kr.co.dong.checkTest;

import java.util.Scanner;

import javax.management.loading.PrivateClassLoader;

public class CheckTest10 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean power = false; // ����
		String[] room = new String[12];
		int menu = 0;
		int select = 0;
		int roomNumber = 0;

		room[0] = "101ȣ��(�Ϲ� ����) (0)";
		room[1] = "102ȣ��(�Ϲ� ����) (1)";
		room[2] = "103ȣ��(�Ϲ� ����) (2)";
		room[3] = "104ȣ��(�Ϲ� ����) (3)";
		room[4] = "105ȣ��(�Ϲ� ����) (4)";
		room[5] = "206ȣ��(�ξ� ����) (5)";
		room[6] = "207ȣ��(�ξ� ����) (6)";
		room[7] = "208ȣ��(�ξ� ����) (7)";
		room[8] = "209ȣ��(�ξ� ����) (8)";
		room[9] = "310ȣ��(����Ʈ ��) (9)";
		room[10] = "311ȣ��(����Ʈ ��) (10)";
		room[11] = "312ȣ��(����Ʈ ��) (11)";

		System.out.println("=================[MENU]====================");
		System.out.println("|1.���� ���� 		| 2.���� ��� 	| 3.ȣ��Ȯ��");
		System.out.println("|		|		|");
		System.out.println("|50. �����ڸ�� 	| 99.���α׷� ����  |");
		System.out.println("===========================================");

//		�޴� ����
		while (!power) {
			System.out.println("MENU�� ������ �ּ���");
			menu = scan.nextInt(); // �޴� �Է�

			switch (menu) {
//			�� ����
			case 1:
				for (int i = 0; i < room.length; i++) {
					System.out.println(room[i]);
				}
				System.out.println("������ ������ ������ �ּ���(0~11)");
				roomNumber = scan.nextInt();
				if (roomNumber == 0) {
					System.out.println(room[0]);
					System.out.println("���� Ȯ�� : ");
					select = scan.nextInt();
					if (select == 0) {
						System.out.println("���డ�ɡ١١١١�!!");

					} else if (select == 1)
						System.out.println("����ʡڡڡڡڡ�!!");

				} else if (roomNumber == 1) {
					System.out.println(room[1]);
					System.out.println("���� Ȯ�� : ");
					select = scan.nextInt();
					if (select == 0) {
						System.out.println("���డ�ɡ١١١١�!!");

					} else if (select == 1)
						System.out.println("����ʡڡڡڡڡ�!!");

				} else if (roomNumber == 2) {
					System.out.println(room[2]);
					System.out.println("���� Ȯ�� : ");
					select = scan.nextInt();
					if (select == 0) {
						System.out.println("���డ�ɡ١١١١�!!");

					} else if (select == 1)
						System.out.println("����ʡڡڡڡڡ�!!");

				} else if (roomNumber == 3) {
					System.out.println(room[3]);
					System.out.println("���� Ȯ�� : ");
					select = scan.nextInt();
					if (select == 0) {
						System.out.println("���డ�ɡ١١١١�!!");

					} else if (select == 1)
						System.out.println("����ʡڡڡڡڡ�!!");

				} else if (roomNumber == 4) {
					System.out.println(room[4]);
					System.out.println("���� Ȯ�� : ");
					select = scan.nextInt();
					if (select == 0) {
						System.out.println("���డ�ɡ١١١١�!!");

					} else if (select == 1)
						System.out.println("����ʡڡڡڡڡ�!!");

				} else if (roomNumber == 5) {
					System.out.println(room[5]);
					System.out.println("���� Ȯ�� : ");
					select = scan.nextInt();
					if (select == 0) {
						System.out.println("���డ�ɡ١١١١�!!");

					} else if (select == 1)
						System.out.println("����ʡڡڡڡڡ�!!");

				} else if (roomNumber == 6) {
					System.out.println(room[6]);
					System.out.println("���� Ȯ�� : ");
					select = scan.nextInt();
					if (select == 0) {
						System.out.println("���డ�ɡ١١١١�!!");

					} else if (select == 1)
						System.out.println("����ʡڡڡڡڡ�!!");

				} else if (roomNumber == 7) {
					System.out.println(room[7]);
					System.out.println("���� Ȯ�� : ");
					select = scan.nextInt();
					if (select == 0) {
						System.out.println("���డ�ɡ١١١١�!!");

					} else if (select == 1)
						System.out.println("����ʡڡڡڡڡ�!!");

				} else if (roomNumber == 8) {
					System.out.println(room[8]);
					System.out.println("���� Ȯ�� : ");
					select = scan.nextInt();
					if (select == 0) {
						System.out.println("���డ�ɡ١١١١�!!");

					} else if (select == 1)
						System.out.println("����ʡڡڡڡڡ�!!");

				} else if (roomNumber == 9) {
					System.out.println(room[9]);
					System.out.println("���� Ȯ�� : ");
					select = scan.nextInt();
					if (select == 0) {
						System.out.println("���డ�ɡ١١١١�!!");

					} else if (select == 1)
						System.out.println("����ʡڡڡڡڡ�!!");

				} else if (roomNumber == 10) {
					System.out.println(room[10]);
					System.out.println("���� Ȯ�� : ");
					select = scan.nextInt();
					if (select == 0) {
						System.out.println("���డ�ɡ١١١١�!!");

					} else if (select == 1)
						System.out.println("����ʡڡڡڡڡ�!!");

				} else if (roomNumber == 11) {
					System.out.println(room[11]);
					System.out.println("���� Ȯ�� : ");
					select = scan.nextInt();
					if (select == 0) {
						System.out.println("���డ�ɡ١١١١�!!");

					} else if (select == 1)
						System.out.println("����ʡڡڡڡڡ�!!");

				}
				continue;
//				�������
			case 2:
				System.out.println("������ ����� ���� (0~11)");
				roomNumber = scan.nextInt();
				if (roomNumber == 0) {
					System.out.println(room[0]);
					System.out.println("���� Ȯ�� : " + select);
					System.out.println("������ ��Ҵ� 0�� �Դϴ�.");
					select = scan.nextInt();
					if (select == 0) {
						System.out.println("���پ����ټ� �١�!!");
						System.out.println("������ ��� �մϴ�.");
						break;
					}

					System.out.println("������ ����� ���� (0~11)");
					roomNumber = scan.nextInt();
				} else if (roomNumber == 1) {
					System.out.println(room[1]);
					System.out.println("���� Ȯ�� : " + select);
					System.out.println("������ ��Ҵ� 0�� �Դϴ�.");
					select = scan.nextInt();
					if (select == 0) {
						System.out.println("���پ����ټ� �١�!!");
						System.out.println("������ ��� �մϴ�.");
						break;
					}

					System.out.println("������ ����� ���� (0~11)");
					roomNumber = scan.nextInt();
				} else if (roomNumber == 2) {
					System.out.println(room[2]);
					System.out.println("���� Ȯ�� : " + select);
					System.out.println("������ ��Ҵ� 0�� �Դϴ�.");
					select = scan.nextInt();
					if (select == 0) {
						System.out.println("���پ����ټ� �١�!!");
						System.out.println("������ ��� �մϴ�.");
						break;
					}

					System.out.println("������ ����� ���� (0~11)");
					roomNumber = scan.nextInt();
				} else if (roomNumber == 3) {
					System.out.println(room[3]);
					System.out.println("���� Ȯ�� : " + select);
					System.out.println("������ ��Ҵ� 0�� �Դϴ�.");
					select = scan.nextInt();
					if (select == 0) {
						System.out.println("���پ����ټ� �١�!!");
						System.out.println("������ ��� �մϴ�.");
						break;
					}

					System.out.println("������ ����� ���� (0~11)");
					roomNumber = scan.nextInt();
				} else if (roomNumber == 4) {
					System.out.println(room[4]);
					System.out.println("���� Ȯ�� : " + select);
					System.out.println("������ ��Ҵ� 0�� �Դϴ�.");
					select = scan.nextInt();
					if (select == 0) {
						System.out.println("���پ����ټ� �١�!!");
						System.out.println("������ ��� �մϴ�.");
						break;
					}

					System.out.println("������ ����� ���� (0~11)");
					roomNumber = scan.nextInt();
				} else if (roomNumber == 5) {
					System.out.println(room[5]);
					System.out.println("���� Ȯ�� : " + select);
					System.out.println("������ ��Ҵ� 0�� �Դϴ�.");
					select = scan.nextInt();
					if (select == 0) {
						System.out.println("���پ����ټ� �١�!!");
						System.out.println("������ ��� �մϴ�.");
						break;
					}

					System.out.println("������ ����� ���� (0~11)");
					roomNumber = scan.nextInt();
				} else if (roomNumber == 6) {
					System.out.println(room[6]);
					System.out.println("���� Ȯ�� : " + select);
					System.out.println("������ ��Ҵ� 0�� �Դϴ�.");
					select = scan.nextInt();
					if (select == 0) {
						System.out.println("���پ����ټ� �١�!!");
						System.out.println("������ ��� �մϴ�.");
						break;
					}

					System.out.println("������ ����� ���� (0~11)");
					roomNumber = scan.nextInt();
				} else if (roomNumber == 7) {
					System.out.println(room[7]);
					System.out.println("���� Ȯ�� : " + select);
					System.out.println("������ ��Ҵ� 0�� �Դϴ�.");
					select = scan.nextInt();
					if (select == 0) {
						System.out.println("���پ����ټ� �١�!!");
						System.out.println("������ ��� �մϴ�.");
						break;
					}

					System.out.println("������ ����� ���� (0~11)");
					roomNumber = scan.nextInt();
				} else if (roomNumber == 8) {
					System.out.println(room[8]);
					System.out.println("���� Ȯ�� : " + select);
					System.out.println("������ ��Ҵ� 0�� �Դϴ�.");
					select = scan.nextInt();
					if (select == 0) {
						System.out.println("���پ����ټ� �١�!!");
						System.out.println("������ ��� �մϴ�.");
						break;
					}

					System.out.println("������ ����� ���� (0~11)");
					roomNumber = scan.nextInt();
				} else if (roomNumber == 9) {
					System.out.println(room[9]);
					System.out.println("���� Ȯ�� : " + select);
					System.out.println("������ ��Ҵ� 0�� �Դϴ�.");
					select = scan.nextInt();
					if (select == 0) {
						System.out.println("���پ����ټ� �١�!!");
						System.out.println("������ ��� �մϴ�.");
						break;
					}

					System.out.println("������ ����� ���� (0~11)");
					roomNumber = scan.nextInt();
				} else if (roomNumber == 10) {
					System.out.println(room[10]);
					System.out.println("���� Ȯ�� : " + select);
					System.out.println("������ ��Ҵ� 0�� �Դϴ�.");
					select = scan.nextInt();
					if (select == 0) {
						System.out.println("���پ����ټ� �١�!!");
						System.out.println("������ ��� �մϴ�.");
						break;
					}

					System.out.println("������ ����� ���� (0~11)");
					roomNumber = scan.nextInt();
				} else if (roomNumber == 11) {
					System.out.println(room[11]);
					System.out.println("���� Ȯ�� : " + select);
					System.out.println("������ ��Ҵ� 0�� �Դϴ�.");
					select = scan.nextInt();
					if (select == 0) {
						System.out.println("���پ����ټ� �١�!!");
						System.out.println("������ ��� �մϴ�.");
						break;
					}
				}

				break;
//				 ȣ��Ȯ��
			case 3:
				System.out.println("ȣ��(0~11)");
				System.out.println("0�� ���� ���� | 1�� ���� �Ұ� ");
				roomNumber = scan.nextInt();
				if (roomNumber == 0) {
					System.out.println(room[0]);
					System.out.println("���� Ȯ�� : " + select);
				} else if (roomNumber == 1) {
					System.out.println(room[1]);
					System.out.println("���� Ȯ�� : " + select);

				} else if (roomNumber == 2) {
					System.out.println(room[2]);
					System.out.println("���� Ȯ�� : " + select);

				} else if (roomNumber == 3) {
					System.out.println(room[3]);
					System.out.println("���� Ȯ�� : " + select);

				} else if (roomNumber == 4) {
					System.out.println(room[4]);
					System.out.println("���� Ȯ�� : " + select);

				} else if (roomNumber == 5) {
					System.out.println(room[5]);
					System.out.println("���� Ȯ�� : " + select);

				} else if (roomNumber == 6) {
					System.out.println(room[6]);
					System.out.println("���� Ȯ�� : " + select);

				} else if (roomNumber == 7) {
					System.out.println(room[7]);
					System.out.println("���� Ȯ�� : " + select);

				} else if (roomNumber == 8) {
					System.out.println(room[8]);
					System.out.println("���� Ȯ�� : " + select);

				} else if (roomNumber == 9) {
					System.out.println(room[9]);
					System.out.println("���� Ȯ�� : " + select);

				} else if (roomNumber == 10) {
					System.out.println(room[10]);
					System.out.println("���� Ȯ�� : " + select);

				} else if (roomNumber == 11) {
					System.out.println(room[11]);
					System.out.println("���� Ȯ�� : " + select);

				}

				break;

			case 50:

				break;
//				���α׷� ����
			case 99:
				power = true;
				System.out.println("���α׷� ����!! ");
				break;

			default:
				System.out.println("warning!!!!!");
				break;
			}
		}
	}
}
