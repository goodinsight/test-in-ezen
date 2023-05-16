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
		String drk1 = "콜라";
		String drk2 = "사이다";
		String drk3 = "커피";
		
		System.out.println("설명서");
		System.out.println("금액을 투입해주세요");
		System.out.println("돈은 100원, 500원, 1000원, 5000원, 10000원, 50000원씩 투입 가능하며, 여러번 투입 가능합니다");
		System.out.println("원하는 메뉴의 번호를 입력시 실행합니다");
		System.out.println("돈을 넣지 않아도 메뉴 실행이 가능합니다");
		System.out.println("단 잔액이 없으면 음료는 나오지 않습니다");
		System.out.println("[55 관리자 모드]를 입력시 관리자 모드로 전환됩니다 비밀번호(0425) 4자리를 입력해야합니다");
		System.out.println("[99 종료]를 입력시 남은 잔액을 모두 반환하고 자판기를 종료합니다");
		System.out.println();
		while(!power) {
			System.out.println("[1 반환]"+" [2 "+drk1+" "+price1+"원] [3 "+drk2+" "+price2+"원] [4 "+drk3+" "+price3+"원] [55 관리자 모드] [99 종료]");
			System.out.println("[돈을 넣거나 메뉴의 번호를 입력하세요]");
			System.out.println("잔액 : " + money);
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
					System.out.println("[거스름돈 반환 : ]"+money);
					temp = money;
					temp1 = 0;
					System.out.println("※잔돈※");
					while(temp>0) {
						if(temp >= 50000) {
							temp1 = temp / 50000;
							System.out.println("50000원"+temp1+"개");
							coin50000 -= temp1;
							temp = temp % 50000;
						}
						else if(temp < 50000 && temp >= 10000) {
							temp1 = temp / 10000;
							System.out.println("10000원"+temp1+"개");
							coin10000 -= temp1;
							temp = temp % 10000;
						}
						else if(temp < 10000 && temp >= 5000) {
							temp1 = temp / 5000;
							System.out.println("5000원"+temp1+"개");
							coin5000 -= temp1;
							temp = temp % 5000;
						}
						else if(temp < 5000 && temp >= 1000) {
							temp1 = temp / 1000;
							System.out.println("1000원"+temp1+"개");
							coin1000 -= temp1;
							temp = temp % 1000;
						}
						else if(temp < 1000 && temp >= 500) {
							temp1 = temp / 500;
							System.out.println("500원"+temp1+"개");
							coin500 -= temp1;
							temp = temp % 500;
						}
						else if(temp < 500 && temp >= 100) {
							temp1 = temp / 100;
							System.out.println("100원"+temp1+"개");
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
						System.out.println("[잔액이 부족합니다]");
						break;
					}
					else if(money >= price1 && qua1 <= 0) {
						System.out.println("ⅩⅩ품절입니다ⅩⅩ");
						break;
					}
					else {
						System.out.println("["+drk1 + " 나왔습니다]");
						money -= price1;
						qua1--;
						break;
					}
				case 3:
					if(money < price2) {
						System.out.println("[잔액이 부족합니다]");
						break;
					}
					else if(money >= price2 && qua2 <= 0) {
						System.out.println("ⅩⅩ품절입니다ⅩⅩ");
						break;
					}
					else {
						System.out.println("["+drk2 + " 나왔습니다]");
						money -= price2;
						qua2--;
						break;
					}
				case 4:
					if(money < price3) {
						System.out.println("[잔액이 부족합니다]");
						break;
					}
					else if(money >= price3 && qua3 <= 0) {
						System.out.println("ⅩⅩ품절입니다ⅩⅩ");
						break;
					}
					else {
						System.out.println("["+drk3 + " 나왔습니다]");
						money -= price3;
						qua3--;
						break;
					}
				case 55:
					System.out.print("[비밀번호 입력 : ]");
					String password = scan.next();
					if(pass.equals(password)) {
						System.out.println("[관리자 모드입니다]");
						System.out.println("[재고 수량을 변경 할수 있습니다]");
						System.out.println("[1 품목변경] [2 품목수량변경] [3 가격변경] [4 입금/출금] [99 종료]");
						boolean end = true;
						while(end) {
							int num = scan.nextInt();
							switch(num) {
							case 1:
								System.out.println("[품목변경 입니다]");
								System.out.println("[변경하고자 하는 품목을 선택해주세요]");
								System.out.println("[1 "+drk1+"] [2 "+drk2+"] [3 "+drk3+"] [99 품목변경 종료]");
								String tmp = "";
								int select = scan.nextInt();
								switch(select) {
								case 1:
									System.out.println("[변경하고자 하는 품목의 이름을 입력해주세요]");
									tmp = scan.next();
									System.out.println("[품목 "+drk1+"를 "+tmp+"로 변경하였습니다]");
									drk1 = tmp;
									break;
								case 2:
									System.out.println("[변경하고자 하는 품목의 이름을 입력해주세요]");
									tmp = scan.next();
									System.out.println("[품목 "+drk2+"를 "+tmp+"로 변경하였습니다]");
									drk2 = tmp;
									break;
								case 3:
									System.out.println("[변경하고자 하는 품목의 이름을 입력해주세요]");
									tmp = scan.next();
									System.out.println("[품목 "+drk3+"를 "+tmp+"로 변경하였습니다]");
									drk3 = tmp;
									break;
								case 99:
									System.out.println("[품목 변경을 종료합니다]");
									break;
								default:
									System.out.println("[잘못된 입력입니다]");
								}
								break;
							case 2:
								System.out.println("[품목수량을 추가하거나 변경합니다]");
								System.out.println("[원하시는 메뉴를 선택해주세요]");
								System.out.println("[1 추가] [2 변경] [99 품목수량변경 종료]");
								select = scan.nextInt();
								switch(select) {
								case 1:
									System.out.println("[기존 수량에 새로 추가합니다]");
									System.out.println("[추가하실 품목을 입력해주세요]");
									System.out.println("[1 "+drk1+"] [2 "+drk2+"] [3 "+drk3+"] [99 품목수량추가 종료]");
									select = scan.nextInt();
									switch(select) {
									case 1:
										System.out.println("[현재 "+drk1+"수량 :"+qua1+"]");
										System.out.println("[추가하실 수량을 입력해주세요]");
										qua1 += scan.nextInt();
										System.out.println("[현재 "+drk1+"수량 :"+qua1+"로 변경되었습니다]");
										break;
									case 2:
										System.out.println("[현재 "+drk2+"수량 :"+qua2+"]");
										System.out.println("[추가하실 수량을 입력해주세요]");
										qua2 += scan.nextInt();
										System.out.println("[현재 "+drk2+"수량 :"+qua2+"로 변경되었습니다]");
										break;
									case 3:
										System.out.println("[현재 "+drk3+"수량 :"+qua3+"]");
										System.out.println("[추가하실 수량을 입력해주세요]");
										qua3 += scan.nextInt();
										System.out.println("[현재 "+drk3+"수량 :"+qua3+"로 변경되었습니다]");
										break;
									case 99:
										System.out.println("[품목수량추가를 종료합니다]");
										break;
									default:
										System.out.println("[잘못된 입력입니다]");
									}
									break;
								case 2:
									System.out.println("[기존 수량을 새로운 수량으로 변경합니다]");
									System.out.println("[변경하실 품목을 입력해주세요]");
									System.out.println("[1 "+drk1+"] [2 "+drk2+"] [3 "+drk3+"] [99 품목수량변경 종료]");
									select = scan.nextInt();
									switch(select) {
									case 1:
										System.out.println("[현재 "+drk1+"수량 :"+qua1+"]");
										System.out.println("[변경하실 수량을 입력해주세요]");
										qua1 = scan.nextInt();
										System.out.println("[현재 "+drk1+"수량 :"+qua1+"로 변경되었습니다]");
										break;
									case 2:
										System.out.println("[현재 "+drk2+"수량 :"+qua2+"]");
										System.out.println("[변경하실 수량을 입력해주세요]");
										qua2 = scan.nextInt();
										System.out.println("[현재 "+drk2+"수량 :"+qua2+"로 변경되었습니다]");
										break;
									case 3:
										System.out.println("[현재 "+drk3+"수량 :"+qua3+"]");
										System.out.println("[변경하실 수량을 입력해주세요]");
										qua3 = scan.nextInt();
										System.out.println("[현재 "+drk3+"수량 :"+qua3+"로 변경되었습니다]");
										break;
									case 99:
										System.out.println("[품목수량변경을 종료합니다]");
										break;
									default:
										System.out.println("[잘못된 입력입니다]");
									}
									break;
								}
							case 3:
								System.out.println("[품목의 가격을 변경합니다]");
								System.out.println("[변경하고자 하는 품목을 입력해주세요]");
								System.out.println("[1 "+drk1+"] [2 "+drk2+"] [3 "+drk3+"] [99 가격변경 종료]");
								select = scan.nextInt();
								switch(select) {
								case 1:
									System.out.println("["+drk1+"의 가격을 변경합니다]");
									System.out.println("[현재 "+drk1+"의 가격은"+price1+"입니다.]");
									System.out.println("[변경하고자 하는 가격을 입력해주세요]");
									price1 = scan.nextInt();
									System.out.println("["+drk1+"의 가격을 "+price1+"로 변경하였습니다]");
									break;
								case 2:
									System.out.println("["+drk2+"의 가격을 변경합니다]");
									System.out.println("[현재 "+drk2+"의 가격은"+price2+"입니다.]");
									System.out.println("[변경하고자 하는 가격을 입력해주세요]");
									price2 = scan.nextInt();
									System.out.println("["+drk2+"의 가격을 "+price2+"로 변경하였습니다]");
									break;
								case 3:
									System.out.println("["+drk3+"의 가격을 변경합니다]");
									System.out.println("[현재 "+drk3+"의 가격은"+price3+"입니다.]");
									System.out.println("[변경하고자 하는 가격을 입력해주세요]");
									price3 = scan.nextInt();
									System.out.println("["+drk3+"의 가격을 "+price3+"로 변경하였습니다]");
									break;
								case 99:
									System.out.println("[가격변경을 종료합니다]");
									break;
								default:
									System.out.println("[잘못된 입력입니다]");
								}
								break;
							case 4:
								System.out.println("[잔돈을 입금하거나 출금합니다]");
								System.out.println("[원하시는 메뉴를 입력해주세요]");
								System.out.println("[1 입금] [2 출금] [3 조회] [99 입금/출금 종료]");
								select = scan.nextInt();
								switch(select) {
								case 1:
									System.out.println("[잔돈을 입금합니다]");
									System.out.println("현재 잔돈");
									System.out.println("100원 :"+coin100+"개");
									System.out.println("500원 :"+coin500+"개");
									System.out.println("1000원 :"+coin1000+"개");
									System.out.println("5000원 :"+coin5000+"개");
									System.out.println("10000원 :"+coin10000+"개");
									System.out.println("50000원 :"+coin50000+"개");
									System.out.println("[입금하실 잔돈을 선택해주세요]");
									System.out.println("[1 100원] [2 500원] [3 1000원] [4 5000원] [5 10000원] [6 50000원] [99 입금 종료]");
									select = scan.nextInt();
									switch(select) {
									case 1:
										System.out.println("[100원을 입금합니다]");
										System.out.println("[입금 하실 수량을 입력해주세요]");
										coin100 += scan.nextInt();
										System.out.println("[100원 : "+coin100+"]");
										System.out.println("[변경되었습니다]");
										break;
									case 2:
										System.out.println("[500원을 입금합니다]");
										System.out.println("[입금 하실 수량을 입력해주세요]");
										coin500 += scan.nextInt();
										System.out.println("[500원 : "+coin500+"]");
										System.out.println("[변경되었습니다]");
										break;
									case 3:
										System.out.println("[1000원을 입금합니다]");
										System.out.println("[입금 하실 수량을 입력해주세요]");
										coin1000 += scan.nextInt();
										System.out.println("[1000원 : "+coin1000+"]");
										System.out.println("[변경되었습니다]");
										break;
									case 4:
										System.out.println("[5000원을 입금합니다]");
										System.out.println("[입금 하실 수량을 입력해주세요]");
										coin5000 += scan.nextInt();
										System.out.println("[5000원 : "+coin5000+"]");
										System.out.println("[변경되었습니다]");
										break;
									case 5:
										System.out.println("[10000원을 입금합니다]");
										System.out.println("[입금 하실 수량을 입력해주세요]");
										coin10000 += scan.nextInt();
										System.out.println("[10000원 : "+coin10000+"]");
										System.out.println("[변경되었습니다]");
										break;
									case 6:
										System.out.println("[50000원을 입금합니다]");
										System.out.println("[입금 하실 수량을 입력해주세요]");
										coin50000 += scan.nextInt();
										System.out.println("[50000원 : "+coin50000+"]");
										System.out.println("[변경되었습니다]");
										break;
									case 99:
										System.out.println("[입금을 종료합니다]");
										break;
									default:
										System.out.println("[잘못된 입력입니다]");
									}
									break;
								case 2:
									System.out.println("[잔돈을 출금합니다]");
									System.out.println("[현재 잔돈]");
									System.out.println("100원 :"+coin100+"개");
									System.out.println("500원 :"+coin500+"개");
									System.out.println("1000원 :"+coin1000+"개");
									System.out.println("5000원 :"+coin5000+"개");
									System.out.println("10000원 :"+coin10000+"개");
									System.out.println("50000원 :"+coin50000+"개");
									System.out.println("[출금하실 잔돈을 선택해주세요]");
									System.out.println("[1 100원] [2 500원] [3 1000원] [4 5000원] [5 10000원] [6 50000원] [99 출금 종료]");
									select = scan.nextInt();
									switch(select) {
									case 1:
										System.out.println("[100원을 출금합니다]");
										System.out.println("[출금 하실 수량을 입력해주세요]");
										
										coin100 -= scan.nextInt();
										System.out.println("[100원 : "+coin100+"]");
										System.out.println("[변경되었습니다]");
										break;
									case 2:
										System.out.println("[500원을 출금합니다]");
										System.out.println("[출금 하실 수량을 입력해주세요]");
										coin500 -= scan.nextInt();
										System.out.println("[500원 : "+coin500+"]");
										System.out.println("[변경되었습니다]");
										break;
									case 3:
										System.out.println("[1000원을 출금합니다]");
										System.out.println("[출금 하실 수량을 입력해주세요]");
										coin1000 -= scan.nextInt();
										System.out.println("[1000원 : "+coin1000+"]");
										System.out.println("[변경되었습니다]");
										break;
									case 4:
										System.out.println("[5000원을 출금합니다]");
										System.out.println("[출금 하실 수량을 입력해주세요]");
										coin5000 -= scan.nextInt();
										System.out.println("[5000원 : "+coin5000+"]");
										System.out.println("[변경되었습니다]");
										break;
									case 5:
										System.out.println("[10000원을 출금합니다]");
										System.out.println("[출금 하실 수량을 입력해주세요]");
										coin10000 -= scan.nextInt();
										System.out.println("[10000원 : "+coin10000+"]");
										System.out.println("[변경되었습니다]");
										break;
									case 6:
										System.out.println("[50000원을 출금합니다]");
										System.out.println("[출금 하실 수량을 입력해주세요]");
										coin50000 -= scan.nextInt();
										System.out.println("[50000원 : "+coin50000+"]");
										System.out.println("[변경되었습니다]");
										break;
									case 99:
										System.out.println("[출금을 종료합니다]");
										break;
									default:
										System.out.println("[잘못된 입력입니다]");
									}
									break;
								case 3:
									System.out.println("[잔돈을 조회합니다]");
									System.out.println("[현재 잔돈]");
									System.out.println("100원 :"+coin100+"개");
									System.out.println("500원 :"+coin500+"개");
									System.out.println("1000원 :"+coin1000+"개");
									System.out.println("5000원 :"+coin5000+"개");
									System.out.println("10000원 :"+coin10000+"개");
									System.out.println("50000원 :"+coin50000+"개");
									break;
								case 99:
									System.out.println("[입금/출금을 종료합니다]");
									break;
								default:
									System.out.println("[잘못된 입력입니다]");
								}
								break;
							case 99:
								System.out.println("[관리자 모드를 종료합니다]");
								end = false;
								break;
							default:
								System.out.println("[잘못된 입력입니다.]");
							}
							break;
						}
						break;
					}
					else {
						System.out.println("[잘못된 비밀번호 입니다.]");
						break;
					}
				case 99:
					System.out.println("[거스름돈 반환 : " + money+"]");
					System.out.println("※잔돈※");
					temp = money;
					temp1 = 0;
					while(temp>0) {
						if(temp >= 50000) {
							temp1 = temp / 50000;
							System.out.println("50000원"+temp1+"개");
							coin50000 -= temp1;
							temp = temp % 50000;
						}
						else if(temp < 50000 && temp >= 10000) {
							temp1 = temp / 10000;
							System.out.println("10000원"+temp1+"개");
							coin10000 -= temp1;
							temp = temp % 10000;
						}
						else if(temp < 10000 && temp >= 5000) {
							temp1 = temp / 5000;
							System.out.println("5000원"+temp1+"개");
							coin5000 -= temp1;
							temp = temp % 5000;
						}
						else if(temp < 5000 && temp >= 1000) {
							temp1 = temp / 1000;
							System.out.println("1000원"+temp1+"개");
							coin1000 -= temp1;
							temp = temp % 1000;
						}
						else if(temp < 1000 && temp >= 500) {
							temp1 = temp / 500;
							System.out.println("500원"+temp1+"개");
							coin500 -= temp1;
							temp = temp % 500;
						}
						else if(temp < 500 && temp >= 100) {
							temp1 = temp / 100;
							System.out.println("100원"+temp1+"개");
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
					System.out.println("[잘못된 입력입니다]");	
				}
		}
		System.out.println("자판기 종료");
	}
}
