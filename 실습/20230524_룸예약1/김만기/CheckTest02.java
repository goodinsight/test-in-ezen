//=> �߰����� : 1. ���ǱԸ�(ũ��)�� ���۰� ���ÿ� �Է���
//			  2. ȣ�ڹ��ȣ / ȣ�ڹ��(��-�ξ�/������ ��)/�����ο�/����
//			  3. ����� �����ڸ� / �����ȣ(��ҽ� �ʿ�) ��
//			  4. ��Ÿ �ʿ��� ���(�����ڸ��)

package kr.co.checkpoint;

import java.util.Scanner;

public class CheckTest02 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.print("ȣ�� �Ը� �Է�(1 ~ 20) : ");
		int roomScale = scan.nextInt(); // ȣ�ڿ� ��ϵ� ���� ���� �Է�
		String input = null;

		int[] roomNumbers = new int[roomScale]; // �� ���� ȣ���� ������ �迭
		int[] roomStatus = new int[roomScale];	// ���� ���� ���¸� ������ ����
		String[] reservationStatus = { "�ۿ��� ���ɡ�", "�ܿ���Ұ��ɡ�" }; // roomStatus[]�� ����Ǿ� �ִ� ���� ���� ����� ���ڿ� ex) 0 = ���డ��, 1 = ���� �Ұ���
		
		String[][] reservationNumber = new String[roomScale][2]; // �������� �̸��� �����ȣ�� ���� ��ų 2���� �迭 [][0] = �̸�, [][1] = �����ȣ
		
		// ���� �̸��� ���� ���������� �ο����� ������ 2�����迭
		String[][] roomClass = { 
								{ "Deluxe", "Sweet", "Special", "Guest", "Suit", "King" }, // [0][i] ���� �̸�
								{ "100,000", "150,000", "200,000", "250,000", "130,000", "300,000" }, // [1][i] ���� ����
								{ "3", "2", "4", "3", "2", "5" }  // [2][i] ���������� �ο���
								};

		// roomNumvers[]�� 0 ~ �Է��� �迭�� ���̱��� ȣ�� ��ȣ�� ���� (�� ������ ���� 4���� �����ϱ� ���� ȣ���� X01 ~ X04 ����)
		for (int i = 0; i < roomNumbers.length; i++) {
			int k = i / 4 * 100 + 200;
			roomNumbers[i] = i % 4 + k + 1;
		}
		
		// ȣ�� �������α׷��� ����
		hotel: while (true) {
			System.out.println("=========================================================================================");
			System.out.println("                                           "+((roomScale-1)/4+2)+"��");
			
			// ���θ޴�
			// �� ���� ������ ���
			int i = roomNumbers.length-1; // i�� �Է��� �迭�� ���� -1�� ����
				do {
						// ȣ���� ���������� ������������ ������ �� ���� 4���� ����ϱ� ���� ����
						for(int j=i-i%4; j<=i; j++) { // �Է��� �迭�� ���̰� 17 �̶��  16-(16%4) = 16-0 = 16 = �ʱⰪ    j=i;  �Է��� �迭�� ���� - 1 16����
							System.out.printf("[ %2dȣ %s\t] \t", roomNumbers[j], roomClass[0][i/4+1]); // roomNumbers[16], roomClass[0=�����̸�][�Է��� �迭�� ����-1(16)/4+1]
						}
						System.out.println();
						
						// ������ ���� �̸��� �´� ������ ���
						for(int j=i-i%4; j<=i; j++) {
							System.out.printf("[   ���� %s \t]\t", roomClass[1][i/4+1]);
						}
						System.out.println();
						for(int j=i-i%4; j<=i; j++) {
							System.out.printf("[   �ο� �� %s \t]\t", roomClass[2][i/4+1]);
						}
						System.out.println();
						for(int j=i-i%4; j<=i; j++) {
							System.out.printf("[   %s \t]\t", reservationStatus[roomStatus[j]]);
						}
						System.out.println();
						System.out.println("=========================================================================================");
						System.out.println("                                           "+(i/4+1)+"��");
						
						i = (i-i%4)-1; // ������ ������������ ����ϱ� ���� i���� ��ȭ�ϰ� �ٽ� ó������
						
				}while(i>0); // i�� 0�� �Ǹ� ���� ����
				
				//�׳� �̻ڰ� ����� ���� ���
				System.out.println("[\t\t]\t[\t\t]\t[\t��\t]\t[\t\t]");
				System.out.println("[\tī\t]\t[\tī\t]\t[\t��\t]\t[\t��\t]");
				System.out.println("[\t\t]\t[\t��\t]\t[\t��\t]\t[\t��\t]");
				System.out.println("[\t��\t]\t[\t��\t]\t[\t��\t]\t[\t��\t]");
				System.out.println("=========================================================================================");
				System.out.println("���ϴ� �޴��� ��ȣ�� �Է����ּ���");
				System.out.println("1.�����ϱ� \t 2.��������ϱ� \t 3.����Ȯ���ϱ� \t 4.����Ȯ���ϱ� \t 99.����");
				
				input = scan.next(); // input�� StringŸ��
				
				mainManu:
				switch(input) {
				case "1": 
					System.out.print("ȣ���� �������ּ���. : ");
					input = scan.next();
					
					// �Էµ� ȣ�� ���ڿ��� ������ �ٲ��ֱ�
					int num = Integer.parseInt(input);
					
					// �Էµ� ȣ���� ����Ǿ� �ִ� �迭�� ã�������� �ݺ�
					for(int j=0; j<roomNumbers.length; j++) {
						if(roomNumbers[j] == num) {
							
							// roomClass[���� �̸�][roomNumbers[ã�� ȣ���� ����Ǿ� �ִ� �ε���]/100-1 = ã�� ȣ���� ���� �̸��� ����Ǿ� �ִ� �ε���]
							System.out.println("�����Ͻ� ������ "+roomNumbers[j]+"ȣ "+roomClass[0][roomNumbers[j]/100-1]+"�̸�");
							System.out.println("[ "+reservationStatus[roomStatus[j]]+" ] ���� �Դϴ�");
							
							// 0�̶�� ������ ������ ȣ��
							if(roomStatus[j] == 0) {
								System.out.println("���� �Ͻðڽ��ϱ�?");
								System.out.println("�� / �ƴϿ�");
								input = scan.next();
								switch(input) {
								case "��": case "��": case "sp":
									System.out.println("");
									System.out.println("�����ں� ������ �Է����ּ���.");
									reservationNumber[j][0] = scan.next();
									System.out.println(reservationNumber[j][0]+" ��");
									
									// �����ȣ�� 111111 ~ 999999������ ������ ���� ���ڿ��� ��ȯ�Ͽ� ����
									reservationNumber[j][1] = Integer.toString((int)(Math.random() * 888888) + 111111);
									System.out.println("�����ȣ�� "+reservationNumber[j][1]+"�Դϴ�.");
									roomStatus[j] = 1;
									System.out.println("������ �Ϸ�Ǿ����ϴ�.");
									break mainManu;
								case "�ƴϿ�": case "�ƴϿ�": case "�ƴ�": case "dksldh": case "dksldy":
									System.out.println("����Ͽ����ϴ�.");
									System.out.println("ó������ �ǵ��ư��ϴ�.");
									break mainManu;
								default:
									System.out.println("�߸��� �Է��Դϴ�.");
								}
							}
							else {
								System.out.println("�ٽ� �������ּ���");
								break;
							}
							break;
						}
					}
					System.out.println("�߸��� �Է��Դϴ�.");
					break;
				case "2":
					System.out.print("�����ں� ������ �Է����ּ���. : ");
					input = scan.next();
					for(int j=0; j<reservationNumber.length; j++) {
						if(input.equals(reservationNumber[j][0])) {
							System.out.println(reservationNumber[j][0]+" ��");
							System.out.println("�����Ͻ� ������ "+roomNumbers[j]+"ȣ "+roomClass[0][roomNumbers[j]/100-1]+"�Դϴ�.");
							System.out.println("������ ����Ͻ÷��� �����ȣ�� �Է����ּ���");
							input = scan.next();
							if(input.equals(reservationNumber[j][1])) {
								roomStatus[j] = 0;
								System.out.println("������ ��ҵǾ����ϴ�.");
								break mainManu;
							}
							else {
								System.out.println("�����ȣ�� Ʋ�Ƚ��ϴ�");
								break mainManu;
							}
						}
					}
					System.out.println("����� ������ �����ϴ�.");
					break;
				case "3":
					System.out.println("�����ں� ������ �Է����ּ���. : ");
					input = scan.next();
					for(int j=0; j<roomNumbers.length; j++) {
						if(input.equals(reservationNumber[j][0])) {
							System.out.println(reservationNumber[j][0]+" ��");
							System.out.println("�����Ͻ� ������ "+roomNumbers[j]+"ȣ "+roomClass[0][roomNumbers[j]/100-1]+"�Դϴ�.");
							System.out.println("�����ȣ : "+reservationNumber[j][1]);
							break mainManu;
						}
					}
					System.out.println("����� ������ �����ϴ�.");
					break;
				case "4":
					break;
				case "55":
					System.out.println("");
				case "99":
					break hotel;
					default:
						System.out.println("�߸��� �Է��Դϴ�.");
				}
		}
	}
}
