/*
 *  �ۼ��� : ������	 ��¥ : 2023.05.24
 *  
 *  
 */

package kr.co.dong.checkPoint;

import java.util.Arrays;
import java.util.Scanner;

public class Hotel_1 {

	public static void main(String[] args) {

		final int MAX_ROOM = 12;
		
		boolean[] room = null;
		
		int menu;
		
		int input;
		
		boolean power;
		
		Scanner scan;
		
		//�ʱ�ȭ
		room = new boolean[MAX_ROOM];
		Arrays.fill(room, false);
		
		menu = 0;
		
		power = false;
		
		scan = new Scanner(System.in);
		
		/*
		 * ���� �������� �ʱ�ȭ�鿡�� ������� �ʴ´ٰų�
		 * 
		 * ���� ������ �游, ���� ��Ұ� ������ �游 �����شٰų�
		 * 
		 * �ƿ� ���� ������ �� �߿��� �������� �������شٰų�
		 * 
		 * ���� ��ҽ� ��й�ȣ �����Ŵ�?
		 * 
		 */
		
		while(!power) {
			switch(menu) {
			case 0://�ʱ�ȭ��
				
				//���� �������
				// 3�� ȣ�� Ȯ�� �߰��� ����
				System.out.println("\n\n== ���� ���� ���� ======================");
				
				String tmp = "";
				for(int i = 0; i < MAX_ROOM; i++) {
					
					String star = room[i] ? "��":"��";
					tmp += String.format("%-2d: %s |", i+1, star);
					if(i%5 == 4) tmp += "\n";
				}
				System.out.println(tmp);
				
				System.out.println("====================================");
				System.out.println("�� : ���� �Ұ�, �� : ���� ����");
				
				//�޴� �ȳ�
				System.out.println("\n�Է� �ȳ�\n"
						+ "1\t: ����\n"
						+ "2\t: ���� ���\n"
//						+ "3\t: ���� ��Ȳ Ȯ��\n"
						+ "99\t: ����");
				
				try {
					System.out.print(">> ");
					input = scan.nextInt();
					
					switch(input) {
						case 1 : case 2: case 99:
							menu = input;
							break;
						default :
							throw new Exception();
					}
					
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("�߸��� �Է��Դϴ�.");
					scan.nextLine();
				}
				
				break;
				
			case 1://����

				System.out.println("�����Ͻð� ���� �� ��ȣ�� �Է����ּ���.(��� : 99)");
				
				try {
					System.out.print(">> ");
					input = scan.nextInt();
					if(input == 99) {
						menu = 0;
					}else if(room[input-1]) {
						System.out.println("�̹� ����Ǿ��ִ� ���Դϴ�.");
					}else {
						room[input-1] = true;
						menu = 0;
						System.out.println("����Ǿ����ϴ�.");
					}
					
				} catch (Exception e) {
					System.out.println("�߸��� �Է��Դϴ�.");
					scan.nextLine();
				}
				
				break;
				
			case 2://�������
				
				System.out.println("������ ����Ͻð� ���� �� ��ȣ�� �Է����ּ���.(��� : 99)");
				
				try {
					System.out.print(">> ");
					input = scan.nextInt();
					if(input == 99) {
						menu = 0;
					}else if(!room[input-1]) {
						System.out.println("������ �Ǿ����� ���� ���Դϴ�.");
					}else {
						room[input-1] = false;
						menu = 0;
						System.out.println("������ ��ҵǾ����ϴ�.");
					}
					
				} catch (Exception e) {
					System.out.println("�߸��� �Է��Դϴ�.");
					scan.nextLine();
				}
				
				break;
				
			/*
			case 3 : //ȣ�� Ȯ��
				System.out.println("\n\n== ���� ���� ���� ======================");
				
				String tmp = "";
				for(int i = 0; i < MAX_ROOM; i++) {
					
					String star = room[i] ? "V":"_";
					tmp += String.format("%-2d: %s |", i+1, star);
					if(i%5 == 4) tmp += "\n";
				}
				System.out.println(tmp);
				
				System.out.println("====================================");
				System.out.println("V : ���� �Ұ�, _ : ���� ����");
				
				menu = 0;
				break;
			
			 */
				
			case 99://����
				System.out.println("���α׷��� �����մϴ�.");
				power = true;
				break;
				
			}
		}
		
		scan.close();
		
	}

}
