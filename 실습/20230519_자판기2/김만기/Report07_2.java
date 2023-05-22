package kr.co.man.array;

import java.util.Scanner;

public class Report07_2 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		boolean power = false; // 전원
		String[] dName = { "콜라", "사이다", "커피" }; // 제품 이름
		String pass1 = "0927"; // 현재 비밀번호
		String pass2 = "";	// 입력받는 비밀번호
		int[] dPrice = { 600, 700, 800 }; // 제품 가격
		int[] dAmount = { 10, 10, 10 }; // 제품 수량
		int[] dCount = { 0, 0, 0 };
		int[] coin = { 10, 10, 10, 10, 10, 10 }; // 100원, 500원, 1000원, 5000원, 10000원, 50000원 잔돈 수
		int[] coinType = { 100, 500, 1000, 5000, 10000, 50000 };
		int input = 0; // 입력받기
		int money = 0; // 잔액

		while (!power) { // 자판기 루프 on
			System.out.println(
					"==============================================================================================");
			System.out.println("                                            자판기"); // 메뉴 루프 시작
			for (int i = 0; i < 3; i++) {
				System.out.print(+(i + 1) + "." + dName[i] + " " + dPrice[i] + "원 수량:" + dAmount[i] + "개\t"); // 메뉴
			}
			System.out.print("7.잔돈반환 \t55.관리자 \t99.종료");
			System.out.println();
			System.out.println("메뉴를 입력하거나 금액을 투입해주세요");
			System.out.println("잔액 : " + money); // 잔액
			input = scan.nextInt(); // 입력받기
			switch (input) { // 메뉴선택 혹은 금액투입 시작
			case 1: // 메뉴선택후 제품제공
				if (money >= dPrice[0]) {
					if (dAmount[0] >= 0) {
						System.out.println(dName[0] + " 나왔습니다.");
						money -= dPrice[0];
						dAmount[0]--;
						dCount[0]++;
					} else {
						System.out.println("품절입니다");
					}
				} else {
					System.out.println("잔액이 부족합니다.");
				}
				break;
			case 2:
				if (money >= dPrice[1]) {
					if (dAmount[0] >= 0) {
						System.out.println(dName[1] + " 나왔습니다.");
						money -= dPrice[1];
						dAmount[1]--;
						dCount[1]++;
					} else {
						System.out.println("품절입니다");
					}
				} else {
					System.out.println("잔액이 부족합니다.");
				}
				break;
			case 3:
				if (money >= dPrice[2]) {
					if (dAmount[2] >= 0) {
						System.out.println(dName[2] + " 나왔습니다.");
						money -= dPrice[2];
						dAmount[2]--;
						dCount[2]++;
					} else {
						System.out.println("품절입니다");
					}
				} else {
					System.out.println("잔액이 부족합니다.");
				}
				break;
			case 7:
				for(int j=coin.length-1; j>=0; j--) {
					if (money>=coinType[j]) {
						int temp =  money / coinType[j];
						System.out.println(coinType[j]+"원 : " + temp + "개");
						coin[j] -= temp;
						money %= coinType[j];
					}
				}
				break;
			case 55: // 관리자모드 시작
				int i = 1;
				while (true) {
					System.out.println("비밀번호 : ");
					pass2 = scan.next();
					if (pass1.equals(pass2)) {
						System.out.println("관리자 모드입니다.");
						System.out.println("1.재고변경 2.품목변경 3.가격변경 4.입금/출금 5.판매현황 6.비밀번호변경 99.종료");
						input = scan.nextInt();
						while (true) {
							switch (input) {
							case 1:
								System.out.println("재고변경 메뉴입니다.");
								System.out.println("1.재고수량추가 2.재고수량빼기 3.재고수량변경 99.종료");
								input = scan.nextInt();
								switch (input) {
								case 1: // 재고 추가 루프 시작
									while (true) {
										System.out.println("추가하실 품목을 입력해주세요.");
										for (int j = 0; j < dName.length; j++) {
											System.out.print((j + 1) + "." + dName[j] + "\t");
										}
										System.out.println("99.종료");
										input = scan.nextInt();
											if (input >= 0 && input <= 3) {
												System.out.println(dName[input - 1] + "의 현재 수량 : " + dAmount[input - 1]);
												System.out.println(dName[input - 1] + "의 추가하실 수량을 입력해주세요");
												int amountCount = scan.nextInt();
												dAmount[input - 1] += amountCount;
												System.out.println(dName[input - 1] + "의 현재 수량 : " + dAmount[input - 1] + "\n");
												break;
											} else if (input == 99) {
												break;
											} else {
												System.out.println("잘못된 입력입니다.");
											}
									} // 재고 추가 루프 끝
								continue ;
								case 2: // 재고 뺴기 루프 시작
									while (true) {
										System.out.println("빼실 품목을 입력해주세요.");
										for (int j = 0; j < dName.length; j++) {
											System.out.print((j + 1) + "." + dName[j] + "\t");
										}
										System.out.println("99.종료");
										input = scan.nextInt();
											if (input >= 0 && input <= 3) {
												System.out
														.println(dName[input - 1] + "의 현재 수량 : " + dAmount[input - 1]);
												System.out.println(dName[input - 1] + "의 빼실 수량을 입력해주세요");
												int amountCount = scan.nextInt();
												dAmount[input - 1] -= amountCount;
												System.out.println(dName[input - 1] + "의 현재 수량 : " + dAmount[input - 1] + "\n");
												break;
											} else if (input == 99) {
												break;
											} else {
												System.out.println("잘못된 입력입니다.");
											}
									} // 재고 뺴기 루프 
									break;
								case 3: // 재고 변경 루프 시작
									while (true) {
										System.out.println("변경하실 품목을 입력해주세요.");
										for (int j = 0; j < dName.length; j++) {
											System.out.print((j + 1) + "." + dName[j] + "\t");
										}
										System.out.println("99.종료");
										input = scan.nextInt();
											if (input >= 0 && input <= 3) {
												System.out
														.println(dName[input - 1] + "의 현재 수량 : " + dAmount[input - 1]);
												System.out.println(dName[input - 1] + "의 변경하실 수량을 입력해주세요");
												int amountCount = scan.nextInt();
												dAmount[input - 1] = amountCount;
												System.out.println(dName[input - 1] + "의 현재 수량 : " + dAmount[input - 1] + "\n");
												break;
											} else if (input == 99) {
												break;
											} else {
												System.out.println("잘못된 입력입니다.");
											}
									}
									break;
								case 99:
									break;
								default:
									System.out.println("잘못된 입력입니다.");
								} // 재고 변경 루프 끝
								break;
							case 2: // 품목 변경 시작
								while (true) {
									System.out.println("품목변경입니다");
									System.out.println("변경하고자 하는 품목을 선택해주세요");
									for (int j = 0; j < dName.length; j++) {
										System.out.print((j + 1) + "." + dName[j] + "\t");
									}
									System.out.println("99.종료");
									input = scan.nextInt();
									while (true) {
										if (input >= 0 && input <= 3) {
											System.out.println("변경하고자 하는 품목을 입력해주세요");
											dName[input - 1] = scan.next();
											System.out.println("기존 품목에서 " + dName[input - 1] + "으로 변경되었습니다");
											break;
										} else if (input == 99) {
											break;
										} else {
											System.out.println("잘못된 입력입니다.");
										}
									}
									break;
								}
								break;
							case 3: // 물품의 가격을 변경
								while (true) {
									System.out.println("가격변경입니다");
									System.out.println("변경하고자 하는 품목을 선택해주세요");
									for (int j = 0; j < dName.length; j++) {
										System.out.print((j + 1) + "." + dName[j] + "\t");
									}
									System.out.println("99.종료");
									input = scan.nextInt();
									while (true) {
										if (input >= 0 && input <= 3) {
											System.out.println("변경하고자 하는 가격을 입력해주세요");
											dPrice[input - 1] = scan.nextInt();
											System.out.println("기존 가격에서 " + dPrice[input - 1] + "으로 변경되었습니다");
											break;
										} else if (input == 99) {
											break;
										} else {
											System.out.println("잘못된 입력입니다.");
										}
									}
									break;
								}
								break;
							case 4: // 입/출금 메뉴
								while (true) {
									System.out.println("입금/출금 입니다");
									System.out.println("원하시는 메뉴를 선택해주세요");
									System.out.println("1.입금 2.출금 3.조회 99.종료");
									input = scan.nextInt();
									switch (input) {
									case 1: // 입금 메뉴 선택시
										System.out.println("입금하고자 하는 금액의 번호를 입력해주세요  99.종료");
										for (int j = 0; j < coinType.length; j++) {
											System.out.print((j + 1) + "." + coinType[j] + "원     ");
										}
										input = scan.nextInt();
										while (true) {
											if (input >= 0 && input < coinType.length) {
												System.out.println("입금하고자 하는 수량을 입력해주세요");
												int coinCount = scan.nextInt();
												coin[input-1] += coinCount;
												System.out.println("현재 " + coinType[input - 1] + "원의 개수 : " + coin[input - 1]);
												break;
											} else if (input == 99) {
												break;
											} else {
												System.out.println("잘못된 입력입니다.");
											}
										}
										break;
									case 2: // 출금 메뉴 선택시
										System.out.println("출금하고자 하는 금액의 번호를 입력해주세요  99.종료");
										for(int j=0; j<coinType.length; j++) {
											System.out.print((j + 1) + "." + coinType[j] + "원     ");
										}
										input = scan.nextInt();
										while (true) {
											if (input >= 0 && input < coinType.length) {
												System.out.println("출금하고자 하는 수량을 입력해주세요");
												int coinCount = scan.nextInt();
												coin[input-1] -= coinCount;
												System.out.println("현재 " + coinType[input - 1] + "원의 개수 : " + coin[input - 1]);
												break;
											} else if (input == 99) {
												break;
											} else {
												System.out.println("잘못된 입력입니다.");
											}
										}
										break;
									case 3: // 금고에 남아 있는 잔돈의 개수를 조회
										System.out.println("남은 잔돈을 조회합니다");
										for(int j=0; j<coinType.length; j++) {
											System.out.println(coinType[j]+"원 : "+ coin[j]);
										}
										break;
									case 99:
										break;
									default:
										System.out.println("잘못된 입력입니다.");
									}
									break;
								}
								break;
							case 5:	// 판매 현황
								System.out.println("판매 현황입니다");
								for (int j = 0; j < dName.length; j++) {
									System.out.println(dName[j] + " 판매수량 : " + dCount[j] + " 수입 : " + (dCount[j] * dPrice[j]));
								}
								break;
							case 6: // 비밀번호 변경
								System.out.println("비밀번호 변경입니다");
								System.out.println("현재 비밀번호를 입력해주세요");
								pass2 = scan.next();
								if (pass1.equals(pass2)) {
									System.out.println("변경하고자 하는 비밀번호를 입력해주세요");
									pass1 = scan.next();
								} else {
									System.out.println("비밀번호가 틀렸습니다");
								}
								break;
							case 99:
								break;
							default:
								System.out.println("잘못된 입력입니다.");
							}
							break;
						}
						break;
					} else { //비밀번호 3회 틀리면 처음으로
						System.out.println("비밀번호가" + i + "회 틀렸습니다.");
						i++;
						if (i > 3) {
							break;
						}
					}
				}
				break; // 관리자모드 끝
			case 99: // 자판기 종료
				System.out.println("자판기 종료");
				for(int j=coin.length-1; j>=0; j--) { // 남은 잔액을 모두 반환
					if (money>=coinType[j]) {
						int temp =  money / coinType[j];
						System.out.println(coinType[j]+"원 : " + temp + "개");
						coin[j] -= temp;
						money %= coinType[j];
					}
				}
				power = true;
				break; // 메뉴선택 끝
			case 100: // 금액 투입
				money += input; // 잔돈 누적
				coin[0]++;	// 잔돈 개수 누적
				break;
			case 500:
				money += input;
				coin[1]++;
				break;
			case 1000:
				money += input;
				coin[2]++;
				break;
			case 5000:
				money += input;
				coin[3]++;
				break;
			case 10000:
				money += input;
				coin[4]++;
				break;
			case 50000:
				money += input;
				coin[5]++;
				break; // 금액 투입 끝
			default: // 그외 정해지지않은 입력
				System.out.println("잘못된 입력입니다.");
				break;
			} // 메뉴선택 혹은 금액투입 루프 끝
		} // 자판기 루프 끝
	}
}
