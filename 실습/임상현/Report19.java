package kr.co.dong;

import java.util.Scanner;

public class Report19 {
	public static void main(String[] args) {
		boolean power = false;
		
		Scanner scan = new Scanner(System.in);
		boolean admin_on = false;
		String pwd = "admin";
		int juice1_sell = 0, juice2_sell = 0, juice3_sell = 0;
		int sel1 = 0, sel2 = 0, sel3 = 0;
		int money = 0, juice1_price = 1000, juice2_price = 1500, juice3_price = 2000;
		int juice1_inventory = 5, juice2_inventory = 5, juice3_inventory = 0;
		String juice1 = "���̴�", juice2 = "�ݶ�", juice3 = "Ŀ��"; 
		while(!power) {
			if(juice1_inventory + juice2_inventory + juice3_inventory == 0) {
				System.out.println("��� �������� �����մϴ�.");
				power = true;
			}
			int choice = 0;
			System.out.println("=================================================================================");
			System.out.printf("(1)%s(%d��), (2)%s(%d��), (3)%s(%d��), (4)�� �Է�, (5)�Ž�����, (0)���Ǳ� ����\n", juice1, juice1_price, juice2, juice2_price, juice3, juice3_price);
			System.out.println("=================================================================================");
			System.out.printf("���� �� %s : " + juice1_inventory +"��, %s : " + juice2_inventory + "��, %s : " + juice3_inventory + "�� ���ҽ��ϴ�", juice1, juice2, juice3);
			if(money >= 2000) {
				System.out.printf("���� ���� : (1)%s(%d��), (2)%s(%d��), (3)%s(%d��)\n", juice1, juice1_price, juice2, juice2_price, juice3, juice3_price);
			} else if(money >= 1500){
				System.out.printf("���� ���� : (1)%s(%d��), (2)%s(%d��)\n", juice1, juice1_price, juice2, juice2_price);
			} else if(money >= 1000) {
				System.out.printf("���� ���� : (1)%s(%d��)\n", juice1, juice1_price);
			} else if(money > 0){
				System.out.println("���� ������ ���ᰡ �����ϴ�. (4)�� �Է�, (5)�Ž����� �ޱ�");
			}
			System.out.println("���� �ݾ��� : " + money +"�� �Դϴ�.");
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
					
				case 1:
					if(money >= juice1_price && juice1_inventory > 0) {
						System.out.printf("%s�� ���Խ��ϴ�. \n", juice1);
						money -= juice1_price;
						juice1_inventory--;
						juice1_sell += juice1_price;
					} else if(money < juice1_price) {
						System.out.println("�ݾ��� �����մϴ�.");
					} else {
						System.out.println("��� �����մϴ�.");
					} break;

				case 2:
					if(money >= juice2_price && juice2_inventory > 0) {
						System.out.printf("%s�� ���Խ��ϴ�. \n", juice2);
						money -= juice2_price;
						juice2_inventory--;
						juice2_sell += juice2_price;
					} else if(money < juice2_price) {
						System.out.println("�ݾ��� �����մϴ�.");
					} else {
						System.out.println("��� �����մϴ�.");
					} break;
					
				case 3:
					if(money >= juice3_price && juice3_inventory > 0) {
						System.out.printf("%s�� ���Խ��ϴ�. \n", juice3);
						money -= juice3_price;
						juice3_inventory--;
						juice3_sell += juice3_price;
					} else if(money < juice3_price) {
						System.out.println("�ݾ��� �����մϴ�.");
					} else {
						System.out.println("��� �����մϴ�.");
					} break;
					
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
							System.out.print("������ : (1)" + juice1 + " (2)" + juice2 + " (3)" + juice3 + " : ");
							sel2 = scan.nextInt();
							switch (sel2) {
							case 1:
								System.out.println(juice1 +"�� ���� : " + juice1_inventory);
								System.out.print("(1)�߰�(����), (0)���ư��� : ");
								sel3 = scan.nextInt();
								switch(sel3){
								case 0:
									break;
								case 1:
									int num = 0;
									System.out.print("�߰�(����) ������ �Է��ϼ��� : ");
									num = scan.nextInt();
									juice1_inventory += num;
									System.out.println(juice1 +"�� ��� : " + juice1_inventory);
									break;
								}
								break;
								
							case 2:
								System.out.println(juice2 +"�� ���� : " + juice2_inventory);
								System.out.print("(1)�߰�(����), (0)���ư��� : ");
								sel3 = scan.nextInt();
								switch(sel3){
								case 0:
									break;
								case 1:
									int num = 0;
									System.out.print("�߰�(����) ������ �Է��ϼ��� : ");
									num = scan.nextInt();
									juice2_inventory += num;
									System.out.println(juice2 +"�� ��� : " + juice2_inventory);
									break;
								}
								break;
								
							case 3:
								System.out.println(juice3 +"�� ���� : " + juice3_inventory);
								System.out.print("(1)�߰�(����), (0)���ư��� : ");
								sel3 = scan.nextInt();
								switch(sel3){
								case 0:
									break;
								case 1:
									int num = 0;
									System.out.print("�߰�(����) ������ �Է��ϼ��� : ");
									num = scan.nextInt();
									juice3_inventory += num;
									System.out.println(juice3 +"�� ��� : " + juice3_inventory);
									break;
								}
								break;
								
							default:
								System.out.println("�߸��� �Է°��Դϴ�.");
								break;
							}
							break;
						case 2:
							System.out.print("������ ��ǰ�� �������ּ��� (1)" + juice1 + " (2)" + juice2 + " (3)" + juice3 + " : ");
							int num = 0;
							num = scan.nextInt();
							switch (num) {
							case 1:
								System.out.print("(1)��ǰ����, (2)���ݺ��� : ");
								num = scan.nextInt();
								switch (num) {
								case 1:
									System.out.print("������ ��ǰ���� �Է����ּ��� : ");
									String name = scan.next();
									System.out.println(juice1 +"�� " + name + "���� ����Ǿ����ϴ�.");
									juice1 = name;
									break;

								case 2:
									System.out.print("������ ������ �Է����ּ��� : ");
									int price = scan.nextInt();
									System.out.println(juice1 +"�� ������ " + juice1_price + "������ " + price + "������ ����Ǿ����ϴ�.");
									juice1_price = price;
									break;
								default:
									System.out.println("�߸��� �Է��Դϴ�.");
									break;
									
								}
								break;

							case 2:
								System.out.print("(1)��ǰ����, (2)���ݺ��� : ");
								num = scan.nextInt();
								switch (num) {
								case 1:
									System.out.print("������ ��ǰ���� �Է����ּ��� : ");
									String name = scan.next();
									System.out.println(juice2 +"�� " + name + "���� ����Ǿ����ϴ�.");
									juice2 = name;
									break;

								case 2:
									System.out.print("������ ������ �Է����ּ��� : ");
									int price = scan.nextInt();
									System.out.println(juice2 +"�� ������ " + juice2_price + "������ " + price + "������ ����Ǿ����ϴ�.");
									juice2_price = price;
									break;
								default:
									System.out.println("�߸��� �Է��Դϴ�.");
									break;
							}
							case 3:
								System.out.print("(1)��ǰ����, (2)���ݺ��� : ");
								num = scan.nextInt();
								switch (num) {
								case 1:
									System.out.print("������ ��ǰ���� �Է����ּ��� : ");
									String name = scan.next();
									System.out.println(juice3 +"�� " + name + "���� ����Ǿ����ϴ�.");
									juice3 = name;
									break;

								case 2:
									System.out.print("������ ������ �Է����ּ��� : ");
									int price = scan.nextInt();
									System.out.println(juice3 +"�� ������ " + juice3_price + "������ " + price + "������ ����Ǿ����ϴ�.");
									juice3_price = price;
									break;
								default:
									System.out.println("�߸��� �Է��Դϴ�.");
									break;
								}
							}
							break;
							
						case 3:
							int result = juice1_sell + juice2_sell + juice3_sell;
							System.out.println("�� ������ " + result + "���Դϴ�.");
							break;
					
						case 4:
							System.out.print("������ ��й�ȣ : ");
							String npwd = scan.next();
							pwd = npwd;
							break;
						}
					}
			}
					//������ ��� ��
			default:
				break;
			}
		}
		scan.close();
		System.out.println("���Ǳ� ����.");


		
	// �迭	
/*
		int money = 0;
		String[] juice = {"���̴�", "�ݶ�", "Ŀ��"};
		int[] price = {1000, 1500, 2000};
		int[] inventory = {5, 5, 5};
		
		while(!power) {
			int choice = 0;
			if(inventory[0] + inventory[1] + inventory[2] == 0) {
				System.out.println("��� �������� �����մϴ�.");
				System.out.println("�Ž��� ���� ��ȯ�˴ϴ�." + money + "�� ��ȯ");
				money = 0;
				power = true;
				break;
			}
			System.out.println("=================================================================================");
			System.out.println("(1)" + juice[0] + "("+price[0] + "��), (2)" + juice[1] + "("+price[1] + "��), (3)" + juice[2] + "(" + price[2] + "��), (4)�� �Է�, (5)�Ž�����, (0)���Ǳ� ����");
			System.out.println("=================================================================================");
			System.out.println("���� �� " + juice[0] + " : " + inventory[0] +"��, " + juice[1] + " : " + inventory[1] + "��, " + juice[2] + " : " + inventory[2] + "�� ���ҽ��ϴ�");
			if(money < inventory[0]) {
				System.out.println("���� ������ ���ᰡ �����ϴ�. (4)�� �Է�, (5)�Ž����� �ޱ�");
			} else {
				System.out.print("���� ������ ���� : ");
				for(int i = 0; i < price.length; i++) {
					if(money >= price[i]) {
						System.out.print("(" + (i+1) + ")" + juice[i] + "(" + price[i] + ")");
						if((money < price[i]) || !(i == 2)) {
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
				if(money >= price[choice] && inventory[choice] > 0) {
					System.out.println(juice[choice] + "�� ���Խ��ϴ�.");
					money -= price[choice];
					inventory[choice] --;
				} else if(money < price[choice]){
					System.out.println("�ݾ��� �����մϴ�.");
				} else {
					System.out.println("��� �����մϴ�.");
				}
				
			default:
				break;
			}
		}
		System.out.println("���Ǳ� ����.");
*/
	}
}
