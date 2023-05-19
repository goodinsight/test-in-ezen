package kr.co.dong;

import java.util.Scanner;

public class Report19_2 {
	public static void main(String[] args) {
		// ����
		int money = 0;
		String[] dName = {"���̴�", "�ݶ�", "Ŀ��"};
		int[] dPrice = {1000, 1500, 2000};
		int[] dAmount = {5, 5, 5};
		int sel1 = -1, sel2 = -1, sel3 = -1, sell = 0;
		String pwd = "admin";
		boolean admin_on = false;
		boolean power = false;
		Scanner scan = new Scanner(System.in);
		
		
		while(!power) {
			int choice = 0;
			if(dAmount[0] + dAmount[1] + dAmount[2] == 0) { // ���Ȯ��, ��� 0�Ͻ� �Ž����� ��ȯ �� ���Ǳ� ����
				System.out.println("��� �������� �����մϴ�.");
				System.out.println("�Ž��� ���� ��ȯ�˴ϴ�." + money + "�� ��ȯ");
				money = 0;
				power = true;
				break;
			}
			System.out.println("=================================================================================");
			System.out.println("(1)" + dName[0] + "("+ dPrice[0] + "��), (2)" + dName[1] + "("+dPrice[1] + "��), (3)" + dName[2] + "(" + dPrice[2] + "��), (4)�� �Է�, (5)�Ž�����, (0)���Ǳ� ����");
			System.out.println("=================================================================================");
			System.out.println("���� �� " + dName[0] + " : " + dAmount[0] +"��, " + dName[1] + " : " + dAmount[1] + "��, " + dName[2] + " : " + dAmount[2] + "�� ���ҽ��ϴ�");
			int buy = 0;
			for(int i = 0; i < dPrice.length; i++) { // ���� ������ ���ᰡ �ִ��� Ȯ��
				if(money > dPrice[i]) {
					buy++;
				}
			}
			if(buy <= 0) {
					System.out.println("���� ������ ���ᰡ �����ϴ�. (4)�� �Է�, (5)�Ž����� �ޱ�");
			} else {
			System.out.print("���� ������ ���� : ");
			for(int i = 0; i < dPrice.length; i++) {
				if(money >= dPrice[i]) { // dPrice�� i ��° �ε��� ������ money�� ū ��� dName �ش� �ε����� ���� ����
					System.out.print("(" + (i+1) + ")" + dName[i] + "(" + dPrice[i] + ")");
					if((money < dPrice[i]) || !(i == 2)) {
						System.out.print(", ");
					}
				}
			}
					System.out.println();
				} // end of else
			System.out.println("���� �ݾ��� : " + money +"�� �Դϴ�.");
			System.out.print("��ȣ�� �Է��ϼ��� : ");
			choice = scan.nextInt();
			
			switch (choice) {
			case 0: // ���Ǳ� ����
				power = true;
				break;
			
			case 5: // �Ž����� ��ȯ
				System.out.println(money + "���� ��ȯ�Ǿ����ϴ�.");
				money = 0;
				break;
				
			case 4: // �� ����
				System.out.print("���� �ݾ��� �Է����ּ��� : ");
				money += scan.nextInt();
				break;
				
			case 1: case 2: case 3: // ���� ���� ��
				choice --;
				if(money >= dPrice[choice] && dAmount[choice] > 0) { // ���� ������ ������ ���� �̻��̸� ������ ������ ��� 1�� �̻����� Ȯ��
					System.out.println(dName[choice] + "�� ���Խ��ϴ�.");
					money -= dPrice[choice]; // ������ ������ ������ ������ ����.
					dAmount[choice] --; // ��� ����
				} else if(money < dPrice[choice]){ // ���� ������ ���ݺ��� ���ٸ�
					System.out.println("�ݾ��� �����մϴ�.");
				} else { // ��� 0�� ���϶��
					System.out.println("��� �����մϴ�.");
				}
				
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
							for(int i = 0; i < dName.length; i++) {
								System.out.print("(" + (i+1) + ")" + dName[i]);
								if(i != dName.length-1) { // ���������� ,�� ������ �ʵ��� �ϱ� ����
									System.out.print(", ");
								}
							}
							System.out.println(" : ");
						
							sel2 = scan.nextInt();
							sel2--; // �ε����� ���� �����ֱ� ���ؼ�
						
								System.out.println(dName[sel2] +"�� ���� : " + dAmount[sel2]);
								System.out.print("(1)�߰�(����), (0)���ư��� : ");
								sel3 = scan.nextInt();
								switch(sel3){
								case 0:
									break;
									
								case 1:
									int num = 0;
									System.out.print("�߰�(����) ������ �Է��ϼ��� : ");
									num = scan.nextInt();
									dAmount[sel2] +=  num;
									System.out.println(dName[sel2] + "�� ��� : " + dAmount[sel2]);
									break;
								}
								break;
						case 2:
							System.out.print("������ ��ǰ�� �������ּ��� ");
							for(int i = 0; i < dName.length; i++) {
								System.out.print("(" + (i+1) + ")" + dName[i]);
								if(i != dName.length-1) {
									System.out.print(", ");
								}
							}
							int change = 0;
							change = scan.nextInt();
							change--; // �ε����� ���� �����ֱ� ���ؼ�
							int num = 0;
							System.out.print("(1)��ǰ����, (2)���ݺ��� : ");
							num = scan.nextInt();
							switch (num) {
							
							case 0:
								break;
								
							case 1:
								System.out.print("������ ��ǰ���� �Է����ּ��� : ");
								String name = scan.next();
								System.out.println(dName[change] +"�� " + name + "���� ����Ǿ����ϴ�.");
								dName[change] = name;
								break;
									
							case 2:
								int price = 0;
								System.out.print("������ ������ �Է����ּ��� : ");
								price = scan.nextInt();
								System.out.println(dName[change] +"�� ������ " + dName[change] + "������ " + price + "������ ����Ǿ����ϴ�.");
								dPrice[change] = price;
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
				}
			default:
				break;
			}
		}
		scan.close();
		System.out.println("���Ǳ� ����.");
	}
}
