package kr.co.dong.checkPoint;

import java.util.Scanner;

public class CheckTest01 {
	public static void main(String[] args) {
		int[] room = new int [12];
		for(int i = 0; i < room.length; i++) {
			room[i] = 0;
		}
		boolean power = false;
		String reservation = null;
		while(!power) {
			int choice = 0;
			Scanner scan = new Scanner(System.in);
			System.out.print("(1)ȣ�Ǽ��� (2)������� (3)ȣ��Ȯ�� (99)���� : ");
			choice = scan.nextInt();
	
			switch(choice) {
			case 1:
				int roomNum = 0;
				System.out.print("ȣ�ǹ�ȣ ���� : ");
				roomNum = scan.nextInt();
				
				if(roomNum >= 1 && roomNum <= 12) {
					int tmp = roomNum - 1;
					if(room[tmp] != 0) {
						System.out.println("������ �Ұ����մϴ�.");
					} else {
						System.out.println("������ �����մϴ�.");
						while(true) {
							System.out.println("(1)���� (0)���ư���");
							int sel = scan.nextInt();
							if(sel == 0) {
								break;
							} else if(sel == 1) {
								System.out.println(roomNum + "�� ���� ����Ǿ����ϴ�.");
								room[tmp] = 1;
								break;
							} else {
								System.out.println("�߸��� �Է��Դϴ�.");
							}

						}
						
					}
				}
				break;
			// case 1 end
				
			case 2:
				while(true){
					System.out.print("������ ����� �� ��ȣ�� �Է����ּ���((0)���ư���) :");
					int sel = scan.nextInt();
					if(sel >= 1 && sel <= 12) {
						int seltmp = sel - 1;
						if(room[seltmp] == 0) {
							System.out.println("������� ���� ���Դϴ�.");
						} else {
							System.out.println(sel + "�� �� ������ ��ҵǾ����ϴ�.");
							room[seltmp] = 0;
							break;
						}
					}else if(sel == 0){
						break;
					}else {
						System.out.println("�߸��� �Է��Դϴ�.");
					}
				}
				break;
			// case 2 end
				
			case 3:
				for(int i = 0; i < room.length; i++) {
					if(room[i] == 0) {
						reservation = "���డ��";
					} else {
						reservation = "�����";
					}
					System.out.println(i+1 +"�� ��(" + reservation + ") ");
				}
				break;
			// case 3 end
			case 99:
				System.out.println("����");
				power = true;
				break;
			}
		}
	}
}
