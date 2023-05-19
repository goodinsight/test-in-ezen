package kr.co.dong;

import java.util.Scanner;

public class Report19_3 {
	public static void main(String[] args) {
		String[][] menu = {{"���̴�", "1000", "5"}, {"�ݶ�", "1500", "5"}, {"Ŀ��", "2000", "5"}}; // �迭�� �������� ����Ͽ� �ε����� �Ӽ�ó�� ���
		// �� [][0] : �̸�, [][1] : ����, [][2] : ���
		String pwd = "admin";
		int money = 0;
		int sel1 = -1, sel2 = -1, sel3 = -1, sell = 0;
		boolean power = false;
		boolean admin_on = false;
		Scanner scan = new Scanner(System.in);
		
		while(!power) {
			int choice = 0;
			int sumAmount = 0;
			for(int i = 0; i < menu.length; i++) {
				sumAmount += Integer.parseInt(menu[i][2]); // menu[i][2]�� String���̱� ������ int������ ��ȯ�� ���� Integer.parseInt ���
			}
			if(sumAmount == 0) {
				System.out.println("��� �������� �����մϴ�.");
				System.out.println("�Ž��� ���� ��ȯ�˴ϴ�." + money + "�� ��ȯ");
				money = 0;
				power = true;
				break;
			}
			System.out.println("=================================================================================");
			for(int i = 0; i < menu.length; i++) {
			System.out.print("(" + (i+1) + ")" + menu[i][0] + "("+ menu[i][1] + "��), ");
			}
					System.out.println("(4)�� �Է�, (5)�Ž�����, (0)���Ǳ� ����");
			System.out.print("���� : ");
			for(int i = 0; i < menu.length; i++) {
			System.out.print(menu[i][0] + " : " + menu[i][2] +"��");
				if(i != 2) {
					System.out.print(", ");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println("�Դϴ�");
			System.out.println("=================================================================================");
			System.out.println("���� �ݾ��� : " + money +"�� �Դϴ�.");

			int buyMenu = 0;
			for(int i = 0; i < menu.length; i++) {
				if(money > Integer.parseInt(menu[i][1])) {
					buyMenu++; // ������ �� �ִ� ���ᰡ �ִٸ� buyMenu++, ������ ���ᰡ ���ٸ� 0
			}
			}
			if(buyMenu <= 0) {
				System.out.println("���� ������ ���ᰡ �����ϴ�. (4)�� �Է�, (5)�Ž����� �ޱ�");
			} else { // buyMenu�� 0�� ���
				System.out.print("���� ������ ���� : ");
				for(int i = 0; i < menu.length; i++) {
					if(money > Integer.parseInt(menu[i][1])) {
						System.out.print("(" + (i+1) + ")" + menu[i][0] + "(" + menu[i][1] + ")");
					}
					if(i != menu.length-1) {
						System.out.print(", ");
					}		
				}
				System.out.println();
			} // end of else
			System.out.print("��ȣ�� �Է��ϼ��� : ");
			choice = scan.nextInt();
			
			switch (choice) {
			case 0:
				power = true;
				break;
			
			case 5:
				System.out.println(money + "���� ��ȯ�Ǿ����ϴ�.");
				money = 0;
				break;
				
			case 4:
				System.out.print("���� �ݾ��� �Է����ּ��� : ");
				money += scan.nextInt();
				break;
				
			case 1: case 2: case 3:
				choice --;
				if(money >= Integer.parseInt(menu[choice][1]) && Integer.parseInt(menu[choice][2]) > 0) {
					System.out.println(menu[choice][0] + "�� ���Խ��ϴ�.");
					money -= Integer.parseInt(menu[choice][1]);
					menu[choice][2] = String.valueOf(Integer.parseInt(menu[choice][2]) - 1); // menu[choice][2]�� ������ ���� parseInt ��� �� String�� �迭�� �ٽ� �ֱ� ���� valoueOf ���
					sell += Integer.parseInt(menu[choice][1]);
				} else if(money < Integer.parseInt(menu[choice][1])){
					System.out.println("�ݾ��� �����մϴ�.");
				} else {
					System.out.println("��� �����մϴ�.");
				}
				break;
				// ������ ���
			case 77:
				String input = null;
				System.out.print("��й�ȣ(�ʱ� ��й�ȣ�� admin�Դϴ�.) : ");
				input = scan.next();
				if(!(pwd.equals(input))) {
					System.out.println("��й�ȣ�� Ʋ���ϴ�.");
				} else {
					admin_on = false;
					while(!admin_on) {
						
						System.out.print("(1)������, (2)��ǰ(����)����, (3)���ͱ�, (4)��й�ȣ ����, (0)���ư��� : ");
						sel1 = scan.nextInt();
						
						switch (sel1) {
						
						case 0:
							admin_on = true;
							break;
						
						case 1:
							System.out.print("������ : ");
							for(int i = 0; i < menu.length; i++) {
								System.out.print("(" + (i+1) + ")" + menu[i][0]);
								if(i != menu.length-1) {
									System.out.print(", ");
								}
							}
							System.out.println(" : ");
						
							sel2 = scan.nextInt();
							sel2--;
								System.out.println(menu[sel2][0] +"�� ���� : " + menu[sel2][2]);
								System.out.print("(1)�߰�(����), (0)���ư��� : ");
								sel3 = scan.nextInt();
								switch(sel3){
								case 0:
									break;
									
								case 1:
									int num = 0;
									System.out.print("�߰�(����) ������ �Է��ϼ��� : ");
									num = scan.nextInt();
									menu[sel2][2] = String.valueOf((Integer.parseInt(menu[sel2][2])) + num);
									System.out.println(menu[sel2][0] + "�� ��� : " + menu[sel2][2]);
									break;
								}
								break;
						case 2:
							System.out.print("������ ��ǰ�� �������ּ��� ");
							for(int i = 0; i < menu.length; i++) {
								System.out.print("(" + (i+1) + ")" + menu[i][0]);
								if(i != menu.length-1) {
									System.out.print(", ");
								}
							}
							int change = 0;
							change = scan.nextInt();
							change--;
							int num = 0;
							System.out.print("(1)��ǰ����, (2)���ݺ��� : ");
							num = scan.nextInt();
							switch (num) {
							
							case 0:
								break;
								
							case 1:
								System.out.print("������ ��ǰ���� �Է����ּ��� : ");
								String name = scan.next();
								System.out.println(menu[change][0] +"�� " + name + "���� ����Ǿ����ϴ�.");
								menu[change][0] = name; 
								break;
									
							case 2:
								int price = 0;
								System.out.print("������ ������ �Է����ּ��� : ");
								price = scan.nextInt();
								System.out.println(menu[change][0] +"�� ������ " + menu[change][1] + "������ " + price + "������ ����Ǿ����ϴ�.");
								menu[change][2] = String.valueOf(price);
								break;
							}
							break;
							
						case 3:
							System.out.println("���ͱ� : " + sell + "��");
							break;
							
						case 4:
							System.out.print("������ ��й�ȣ : ");
							String npwd = scan.next();
							pwd = npwd;
							break;
							
						default:
							System.out.println("�߸��� �Է°��Դϴ�.");
							break;
						} // switch1
					} // while(!admin_on)
				}// else
			default:
				break;
			}
		}
		scan.close();
	}
}
