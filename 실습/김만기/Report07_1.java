package kr.co.man;

import java.util.Scanner;

public class Report07_1 {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		boolean power = false;
		int input = 0;
		int money = 0;
		int temp = 0;
		int temp1 = 0;
		
		int qua1 = 10;
		int qua2 = 10;
		int qua3 = 10;
		
		int price1 = 500;
		int price2 = 700;
		int price3 = 1000;
		
		int coin100 = 100;
		int coin500 = 100;
		int coin1000 = 100;
		int coin5000 = 100;
		int coin10000 = 100;
		int coin50000 = 100;
		
		String pass = "0425";
		String drk1 = "�ݶ�";
		String drk2 = "���̴�";
		String drk3 = "Ŀ��";
		
		System.out.println("����");
		System.out.println("�ݾ��� �������ּ���");
		System.out.println("���� 100��, 500��, 1000��, 5000��, 10000��, 50000���� ���� �����ϸ�, ������ ���� �����մϴ�");
		System.out.println("���ϴ� �޴��� ��ȣ�� �Է½� �����մϴ�");
		System.out.println("���� ���� �ʾƵ� �޴� ������ �����մϴ�");
		System.out.println("�� �ܾ��� ������ ����� ������ �ʽ��ϴ�");
		System.out.println("[55 ������ ���]�� �Է½� ������ ���� ��ȯ�˴ϴ� ��й�ȣ(0425) 4�ڸ��� �Է��ؾ��մϴ�");
		System.out.println("[99 ����]�� �Է½� ���� �ܾ��� ��� ��ȯ�ϰ� ���Ǳ⸦ �����մϴ�");
		System.out.println();
		while(!power) {
			System.out.println("[1 ��ȯ]"+" [2 "+drk1+" "+price1+"��] [3 "+drk2+" "+price2+"��] [4 "+drk3+" "+price3+"��] [55 ������ ���] [99 ����]");
			System.out.println("[���� �ְų� �޴��� ��ȣ�� �Է��ϼ���]");
			System.out.println("�ܾ� : " + money);
				input = scan.nextInt();
				switch(input) {
				case 100: 
					money += input;
					coin100++;
					break;
				case 500:
					money += input;
					coin500++;
					break;
				case 1000: 
					money += input;
					coin1000++;
					break;
				case 5000: 
					money += input;
					coin5000++;
					break;
				case 10000:
					money += input;
					coin10000++;
					break;
				case 50000:
					money += input;
					coin50000++;
					break;
				case 1:
					System.out.println("[�Ž����� ��ȯ : ]"+money);
					temp = money;
					temp1 = 0;
					System.out.println("���ܵ���");
					while(temp>0) {
						if(temp >= 50000) {
							temp1 = temp / 50000;
							System.out.println("50000��"+temp1+"��");
							coin50000 -= temp1;
							temp = temp % 50000;
						}
						else if(temp < 50000 && temp >= 10000) {
							temp1 = temp / 10000;
							System.out.println("10000��"+temp1+"��");
							coin10000 -= temp1;
							temp = temp % 10000;
						}
						else if(temp < 10000 && temp >= 5000) {
							temp1 = temp / 5000;
							System.out.println("5000��"+temp1+"��");
							coin5000 -= temp1;
							temp = temp % 5000;
						}
						else if(temp < 5000 && temp >= 1000) {
							temp1 = temp / 1000;
							System.out.println("1000��"+temp1+"��");
							coin1000 -= temp1;
							temp = temp % 1000;
						}
						else if(temp < 1000 && temp >= 500) {
							temp1 = temp / 500;
							System.out.println("500��"+temp1+"��");
							coin500 -= temp1;
							temp = temp % 500;
						}
						else if(temp < 500 && temp >= 100) {
							temp1 = temp / 100;
							System.out.println("100��"+temp1+"��");
							coin100 -= temp1;
							temp = money % 100;
						}
					}
					System.out.println("===========================================================================");
					System.out.println();
					money = 0;
					break;
				case 2:
					if(money < price1) {
						System.out.println("[�ܾ��� �����մϴ�]");
						break;
					}
					else if(money >= price1 && qua1 <= 0) {
						System.out.println("����ǰ���Դϴ٥���");
						break;
					}
					else {
						System.out.println("["+drk1 + " ���Խ��ϴ�]");
						money -= price1;
						qua1--;
						break;
					}
				case 3:
					if(money < price2) {
						System.out.println("[�ܾ��� �����մϴ�]");
						break;
					}
					else if(money >= price2 && qua2 <= 0) {
						System.out.println("����ǰ���Դϴ٥���");
						break;
					}
					else {
						System.out.println("["+drk2 + " ���Խ��ϴ�]");
						money -= price2;
						qua2--;
						break;
					}
				case 4:
					if(money < price3) {
						System.out.println("[�ܾ��� �����մϴ�]");
						break;
					}
					else if(money >= price3 && qua3 <= 0) {
						System.out.println("����ǰ���Դϴ٥���");
						break;
					}
					else {
						System.out.println("["+drk3 + " ���Խ��ϴ�]");
						money -= price3;
						qua3--;
						break;
					}
				case 55:
					System.out.print("[��й�ȣ �Է� : ]");
					String password = scan.next();
					if(pass.equals(password)) {
						System.out.println("[������ ����Դϴ�]");
						System.out.println("[��� ������ ���� �Ҽ� �ֽ��ϴ�]");
						System.out.println("[1 ǰ�񺯰�] [2 ǰ���������] [3 ���ݺ���] [4 �Ա�/���] [99 ����]");
						boolean end = true;
						while(end) {
							int num = scan.nextInt();
							switch(num) {
							case 1:
								System.out.println("[ǰ�񺯰� �Դϴ�]");
								System.out.println("[�����ϰ��� �ϴ� ǰ���� �������ּ���]");
								System.out.println("[1 "+drk1+"] [2 "+drk2+"] [3 "+drk3+"] [99 ǰ�񺯰� ����]");
								String tmp = "";
								int select = scan.nextInt();
								switch(select) {
								case 1:
									System.out.println("[�����ϰ��� �ϴ� ǰ���� �̸��� �Է����ּ���]");
									tmp = scan.next();
									System.out.println("[ǰ�� "+drk1+"�� "+tmp+"�� �����Ͽ����ϴ�]");
									drk1 = tmp;
									break;
								case 2:
									System.out.println("[�����ϰ��� �ϴ� ǰ���� �̸��� �Է����ּ���]");
									tmp = scan.next();
									System.out.println("[ǰ�� "+drk2+"�� "+tmp+"�� �����Ͽ����ϴ�]");
									drk2 = tmp;
									break;
								case 3:
									System.out.println("[�����ϰ��� �ϴ� ǰ���� �̸��� �Է����ּ���]");
									tmp = scan.next();
									System.out.println("[ǰ�� "+drk3+"�� "+tmp+"�� �����Ͽ����ϴ�]");
									drk3 = tmp;
									break;
								case 99:
									System.out.println("[ǰ�� ������ �����մϴ�]");
									break;
								default:
									System.out.println("[�߸��� �Է��Դϴ�]");
								}
								break;
							case 2:
								System.out.println("[ǰ������� �߰��ϰų� �����մϴ�]");
								System.out.println("[���Ͻô� �޴��� �������ּ���]");
								System.out.println("[1 �߰�] [2 ����] [99 ǰ��������� ����]");
								select = scan.nextInt();
								switch(select) {
								case 1:
									System.out.println("[���� ������ ���� �߰��մϴ�]");
									System.out.println("[�߰��Ͻ� ǰ���� �Է����ּ���]");
									System.out.println("[1 "+drk1+"] [2 "+drk2+"] [3 "+drk3+"] [99 ǰ������߰� ����]");
									select = scan.nextInt();
									switch(select) {
									case 1:
										System.out.println("[���� "+drk1+"���� :"+qua1+"]");
										System.out.println("[�߰��Ͻ� ������ �Է����ּ���]");
										qua1 += scan.nextInt();
										System.out.println("[���� "+drk1+"���� :"+qua1+"�� ����Ǿ����ϴ�]");
										break;
									case 2:
										System.out.println("[���� "+drk2+"���� :"+qua2+"]");
										System.out.println("[�߰��Ͻ� ������ �Է����ּ���]");
										qua2 += scan.nextInt();
										System.out.println("[���� "+drk2+"���� :"+qua2+"�� ����Ǿ����ϴ�]");
										break;
									case 3:
										System.out.println("[���� "+drk3+"���� :"+qua3+"]");
										System.out.println("[�߰��Ͻ� ������ �Է����ּ���]");
										qua3 += scan.nextInt();
										System.out.println("[���� "+drk3+"���� :"+qua3+"�� ����Ǿ����ϴ�]");
										break;
									case 99:
										System.out.println("[ǰ������߰��� �����մϴ�]");
										break;
									default:
										System.out.println("[�߸��� �Է��Դϴ�]");
									}
									break;
								case 2:
									System.out.println("[���� ������ ���ο� �������� �����մϴ�]");
									System.out.println("[�����Ͻ� ǰ���� �Է����ּ���]");
									System.out.println("[1 "+drk1+"] [2 "+drk2+"] [3 "+drk3+"] [99 ǰ��������� ����]");
									select = scan.nextInt();
									switch(select) {
									case 1:
										System.out.println("[���� "+drk1+"���� :"+qua1+"]");
										System.out.println("[�����Ͻ� ������ �Է����ּ���]");
										qua1 = scan.nextInt();
										System.out.println("[���� "+drk1+"���� :"+qua1+"�� ����Ǿ����ϴ�]");
										break;
									case 2:
										System.out.println("[���� "+drk2+"���� :"+qua2+"]");
										System.out.println("[�����Ͻ� ������ �Է����ּ���]");
										qua2 = scan.nextInt();
										System.out.println("[���� "+drk2+"���� :"+qua2+"�� ����Ǿ����ϴ�]");
										break;
									case 3:
										System.out.println("[���� "+drk3+"���� :"+qua3+"]");
										System.out.println("[�����Ͻ� ������ �Է����ּ���]");
										qua3 = scan.nextInt();
										System.out.println("[���� "+drk3+"���� :"+qua3+"�� ����Ǿ����ϴ�]");
										break;
									case 99:
										System.out.println("[ǰ����������� �����մϴ�]");
										break;
									default:
										System.out.println("[�߸��� �Է��Դϴ�]");
									}
									break;
								}
							case 3:
								System.out.println("[ǰ���� ������ �����մϴ�]");
								System.out.println("[�����ϰ��� �ϴ� ǰ���� �Է����ּ���]");
								System.out.println("[1 "+drk1+"] [2 "+drk2+"] [3 "+drk3+"] [99 ���ݺ��� ����]");
								select = scan.nextInt();
								switch(select) {
								case 1:
									System.out.println("["+drk1+"�� ������ �����մϴ�]");
									System.out.println("[���� "+drk1+"�� ������"+price1+"�Դϴ�.]");
									System.out.println("[�����ϰ��� �ϴ� ������ �Է����ּ���]");
									price1 = scan.nextInt();
									System.out.println("["+drk1+"�� ������ "+price1+"�� �����Ͽ����ϴ�]");
									break;
								case 2:
									System.out.println("["+drk2+"�� ������ �����մϴ�]");
									System.out.println("[���� "+drk2+"�� ������"+price2+"�Դϴ�.]");
									System.out.println("[�����ϰ��� �ϴ� ������ �Է����ּ���]");
									price2 = scan.nextInt();
									System.out.println("["+drk2+"�� ������ "+price2+"�� �����Ͽ����ϴ�]");
									break;
								case 3:
									System.out.println("["+drk3+"�� ������ �����մϴ�]");
									System.out.println("[���� "+drk3+"�� ������"+price3+"�Դϴ�.]");
									System.out.println("[�����ϰ��� �ϴ� ������ �Է����ּ���]");
									price3 = scan.nextInt();
									System.out.println("["+drk3+"�� ������ "+price3+"�� �����Ͽ����ϴ�]");
									break;
								case 99:
									System.out.println("[���ݺ����� �����մϴ�]");
									break;
								default:
									System.out.println("[�߸��� �Է��Դϴ�]");
								}
								break;
							case 4:
								System.out.println("[�ܵ��� �Ա��ϰų� ����մϴ�]");
								System.out.println("[���Ͻô� �޴��� �Է����ּ���]");
								System.out.println("[1 �Ա�] [2 ���] [3 ��ȸ] [99 �Ա�/��� ����]");
								select = scan.nextInt();
								switch(select) {
								case 1:
									System.out.println("[�ܵ��� �Ա��մϴ�]");
									System.out.println("���� �ܵ�");
									System.out.println("100�� :"+coin100+"��");
									System.out.println("500�� :"+coin500+"��");
									System.out.println("1000�� :"+coin1000+"��");
									System.out.println("5000�� :"+coin5000+"��");
									System.out.println("10000�� :"+coin10000+"��");
									System.out.println("50000�� :"+coin50000+"��");
									System.out.println("[�Ա��Ͻ� �ܵ��� �������ּ���]");
									System.out.println("[1 100��] [2 500��] [3 1000��] [4 5000��] [5 10000��] [6 50000��] [99 �Ա� ����]");
									select = scan.nextInt();
									switch(select) {
									case 1:
										System.out.println("[100���� �Ա��մϴ�]");
										System.out.println("[�Ա� �Ͻ� ������ �Է����ּ���]");
										coin100 += scan.nextInt();
										System.out.println("[100�� : "+coin100+"]");
										System.out.println("[����Ǿ����ϴ�]");
										break;
									case 2:
										System.out.println("[500���� �Ա��մϴ�]");
										System.out.println("[�Ա� �Ͻ� ������ �Է����ּ���]");
										coin500 += scan.nextInt();
										System.out.println("[500�� : "+coin500+"]");
										System.out.println("[����Ǿ����ϴ�]");
										break;
									case 3:
										System.out.println("[1000���� �Ա��մϴ�]");
										System.out.println("[�Ա� �Ͻ� ������ �Է����ּ���]");
										coin1000 += scan.nextInt();
										System.out.println("[1000�� : "+coin1000+"]");
										System.out.println("[����Ǿ����ϴ�]");
										break;
									case 4:
										System.out.println("[5000���� �Ա��մϴ�]");
										System.out.println("[�Ա� �Ͻ� ������ �Է����ּ���]");
										coin5000 += scan.nextInt();
										System.out.println("[5000�� : "+coin5000+"]");
										System.out.println("[����Ǿ����ϴ�]");
										break;
									case 5:
										System.out.println("[10000���� �Ա��մϴ�]");
										System.out.println("[�Ա� �Ͻ� ������ �Է����ּ���]");
										coin10000 += scan.nextInt();
										System.out.println("[10000�� : "+coin10000+"]");
										System.out.println("[����Ǿ����ϴ�]");
										break;
									case 6:
										System.out.println("[50000���� �Ա��մϴ�]");
										System.out.println("[�Ա� �Ͻ� ������ �Է����ּ���]");
										coin50000 += scan.nextInt();
										System.out.println("[50000�� : "+coin50000+"]");
										System.out.println("[����Ǿ����ϴ�]");
										break;
									case 99:
										System.out.println("[�Ա��� �����մϴ�]");
										break;
									default:
										System.out.println("[�߸��� �Է��Դϴ�]");
									}
									break;
								case 2:
									System.out.println("[�ܵ��� ����մϴ�]");
									System.out.println("[���� �ܵ�]");
									System.out.println("100�� :"+coin100+"��");
									System.out.println("500�� :"+coin500+"��");
									System.out.println("1000�� :"+coin1000+"��");
									System.out.println("5000�� :"+coin5000+"��");
									System.out.println("10000�� :"+coin10000+"��");
									System.out.println("50000�� :"+coin50000+"��");
									System.out.println("[����Ͻ� �ܵ��� �������ּ���]");
									System.out.println("[1 100��] [2 500��] [3 1000��] [4 5000��] [5 10000��] [6 50000��] [99 ��� ����]");
									select = scan.nextInt();
									switch(select) {
									case 1:
										System.out.println("[100���� ����մϴ�]");
										System.out.println("[��� �Ͻ� ������ �Է����ּ���]");
										
										coin100 -= scan.nextInt();
										System.out.println("[100�� : "+coin100+"]");
										System.out.println("[����Ǿ����ϴ�]");
										break;
									case 2:
										System.out.println("[500���� ����մϴ�]");
										System.out.println("[��� �Ͻ� ������ �Է����ּ���]");
										coin500 -= scan.nextInt();
										System.out.println("[500�� : "+coin500+"]");
										System.out.println("[����Ǿ����ϴ�]");
										break;
									case 3:
										System.out.println("[1000���� ����մϴ�]");
										System.out.println("[��� �Ͻ� ������ �Է����ּ���]");
										coin1000 -= scan.nextInt();
										System.out.println("[1000�� : "+coin1000+"]");
										System.out.println("[����Ǿ����ϴ�]");
										break;
									case 4:
										System.out.println("[5000���� ����մϴ�]");
										System.out.println("[��� �Ͻ� ������ �Է����ּ���]");
										coin5000 -= scan.nextInt();
										System.out.println("[5000�� : "+coin5000+"]");
										System.out.println("[����Ǿ����ϴ�]");
										break;
									case 5:
										System.out.println("[10000���� ����մϴ�]");
										System.out.println("[��� �Ͻ� ������ �Է����ּ���]");
										coin10000 -= scan.nextInt();
										System.out.println("[10000�� : "+coin10000+"]");
										System.out.println("[����Ǿ����ϴ�]");
										break;
									case 6:
										System.out.println("[50000���� ����մϴ�]");
										System.out.println("[��� �Ͻ� ������ �Է����ּ���]");
										coin50000 -= scan.nextInt();
										System.out.println("[50000�� : "+coin50000+"]");
										System.out.println("[����Ǿ����ϴ�]");
										break;
									case 99:
										System.out.println("[����� �����մϴ�]");
										break;
									default:
										System.out.println("[�߸��� �Է��Դϴ�]");
									}
									break;
								case 3:
									System.out.println("[�ܵ��� ��ȸ�մϴ�]");
									System.out.println("[���� �ܵ�]");
									System.out.println("100�� :"+coin100+"��");
									System.out.println("500�� :"+coin500+"��");
									System.out.println("1000�� :"+coin1000+"��");
									System.out.println("5000�� :"+coin5000+"��");
									System.out.println("10000�� :"+coin10000+"��");
									System.out.println("50000�� :"+coin50000+"��");
									break;
								case 99:
									System.out.println("[�Ա�/����� �����մϴ�]");
									break;
								default:
									System.out.println("[�߸��� �Է��Դϴ�]");
								}
								break;
							case 99:
								System.out.println("[������ ��带 �����մϴ�]");
								end = false;
								break;
							default:
								System.out.println("[�߸��� �Է��Դϴ�.]");
							}
							break;
						}
						break;
					}
					else {
						System.out.println("[�߸��� ��й�ȣ �Դϴ�.]");
						break;
					}
				case 99:
					System.out.println("[�Ž����� ��ȯ : " + money+"]");
					System.out.println("���ܵ���");
					temp = money;
					temp1 = 0;
					while(temp>0) {
						if(temp >= 50000) {
							temp1 = temp / 50000;
							System.out.println("50000��"+temp1+"��");
							coin50000 -= temp1;
							temp = temp % 50000;
						}
						else if(temp < 50000 && temp >= 10000) {
							temp1 = temp / 10000;
							System.out.println("10000��"+temp1+"��");
							coin10000 -= temp1;
							temp = temp % 10000;
						}
						else if(temp < 10000 && temp >= 5000) {
							temp1 = temp / 5000;
							System.out.println("5000��"+temp1+"��");
							coin5000 -= temp1;
							temp = temp % 5000;
						}
						else if(temp < 5000 && temp >= 1000) {
							temp1 = temp / 1000;
							System.out.println("1000��"+temp1+"��");
							coin1000 -= temp1;
							temp = temp % 1000;
						}
						else if(temp < 1000 && temp >= 500) {
							temp1 = temp / 500;
							System.out.println("500��"+temp1+"��");
							coin500 -= temp1;
							temp = temp % 500;
						}
						else if(temp < 500 && temp >= 100) {
							temp1 = temp / 100;
							System.out.println("100��"+temp1+"��");
							coin100 -= temp1;
							temp = money % 100;
						}
					}
					System.out.println("===========================================================================");
					System.out.println();
					money = 0;
					power = true;
					break;
				default:
					System.out.println("[�߸��� �Է��Դϴ�]");	
				}
		}
		System.out.println("���Ǳ� ����");
	}
}
