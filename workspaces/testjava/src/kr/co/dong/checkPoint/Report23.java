package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report23 {

	public static void main(String[] args) {
		// 입력
		Scanner scan = new Scanner(System.in);
		// 전원
		boolean power = false;
		// 메뉴 버튼
		int button = 0;
		int button2 = 0;
		// 음료수 관련 (이름, 가격, 재고)
		String[] dName = null;
		int[] dPrice = null;
		int[] dAmount = null;
		dName = new String[] { "제로콜라", "제로사이다", "제로환타" };
		dPrice = new int[] { 1000, 2000, 3000 };
		dAmount = new int[] { 6, 6, 3 };
		// 돈 관련(잔돈 포함)
		int money = 0;
		// 거스름돈 관련
		int[] mChange = null;
		mChange = new int[] { 10000, 5000, 1000, 500, 100, 50, 10 };
		// 관리자모드
		int password = 4444;
		int pass = 0;
		// 상품 변경 관련
		String[] n_dName = new String[dName.length];
		int[] n_dPrice = new int[dPrice.length];
		int[] n_dAmount = new int[dAmount.length];
		// 매출관련
		int[] salesA = new int[dName.length]; // 매출액
		int[] salesC = new int[dName.length]; // 매출량
		int salesAll = 0; // 총 매출액
		int cMax = 0; // 최다판매품목 구하기
		int cMin = 0; // 최소판매품목 구하기
		int dMax = 0; // 최다판매품목 인덱스
		int dMin = 0; // 최소판매품목 인덱스
		// 메뉴 아이콘
		String icon = "";

		while (!power) {
			System.out.println("======================");
			System.out.println("         자판기         ");
			System.out.println("======================");
			System.out.println("     1. 손님 모드　    　 ");
			System.out.println("     2. 관리자 모드　　　  ");
			System.out.println("     99. 종료하기　　　　　 ");
			System.out.println("======================");
			System.out.print("   번호를 입력해 주세요 : ");
			button = scan.nextInt();
			switch (button) {
			case 1: // 손님모드
				while (button != 88) { // 88번(처음으로) 입력하지 않을시 화면 다시 출력
					System.out.println("======================");
					System.out.printf("   현재 잔액 : %d원\n", money);
					System.out.println("======================");
					for (int i = 0; i < dName.length; i++) {
						System.out.printf(" %d. %s 뽑기(%d원)(%d개)\n", (i + 1), dName[i], dPrice[i], dAmount[i]);
					}
					System.out.println(" 4. 금액 투입하기");
					System.out.println(" 5. 거스름돈 반환하기");
					System.out.println(" 88. 처음으로");
					System.out.println("======================");
					System.out.print("  번호를 입력해 주세요 :");
					button = scan.nextInt();
					switch (button) {
					case 1:
					case 2:
					case 3: // 음료 뽑기
						if (money >= dPrice[button - 1] && dAmount[button - 1] != 0) {
							System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
							System.out.printf("  %s가 나왔습니다.\n", dName[button - 1]);
							System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
							money -= dPrice[button - 1];
							dAmount[button - 1] -= 1;
							salesC[button - 1] += 1; // 매출관리를 위한 판매개수저장
							salesA[button - 1] += dPrice[button - 1];// 매출관리를 위한 판매금액저장
						} else if (money < dPrice[button - 1]) {
							System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
							System.out.println("     잔액이 부족합니다.");
							System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
						} else if (dAmount[button - 1] == 0) {
							System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
							System.out.println("     재고가 부족합니다.");
							System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
						}
						break;
					case 4: // 금액 투입
						System.out.println("======================");
						System.out.print(" 투입하실 금액을 입력해 주세요 :");
						money += scan.nextInt();
						break;
					case 5: // 잔돈 반환
						System.out.println("======================");
						System.out.printf(" %d원이 반납되었습니다.\n", money);
						System.out.print("( ");
						for (int i = 0; i < mChange.length; i++) { // 잔돈 종류계산
							if (money / mChange[i] != 0) {
								System.out.print(mChange[i] + "원 " + money / mChange[i]);
								if (mChange[i] >= 1000) {
									System.out.print("장 ");
								} else {
									System.out.print("개 ");
								}
								money = money % mChange[i];
							}
						}
						System.out.println(")");
						money = 0;
						break;
					case 88: // 처음으로
						break;
					default: // 주어진 번호 외 다른 번호선택시
						System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
						System.out.println("  올바른 번호를 입력해 주세요.");
						System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
						break;
					}
				}
				break;
			case 2: // 관리자모드
				while (button != 88) {
					System.out.println("======================");
					System.out.println("     1. 비밀번호 입력 ");
					System.out.println("     88. 처음으로 ");
					System.out.println("======================");
					System.out.print("   번호를 입력해 주세요 : ");
					button = scan.nextInt();
					switch (button) {
					case 1: // 비밀번호 입력
						System.out.println("======================");
						System.out.print("   비밀번호를 입력해주세요 : ");
						pass = scan.nextInt();
						while (button != 88) {
							if (pass == password) { // 비밀번호가 맞을시
								System.out.println("======================");
								System.out.println("     1. 상품 변경");
								System.out.println("     2. 상품가격 변경");
								System.out.println("     3. 상품재고 관리");
								System.out.println("     4. 매출 관리");
								System.out.println("     88. 처음으로");
								System.out.println("======================");
								System.out.print("  번호를 입력해 주세요 : ");
								button = scan.nextInt();
								switch (button) {
								case 1: // 상품 변경
									while (button != 77) {
										System.out.println("======================");
										for (int i = 0; i < dName.length; i++) {
											System.out.println("     " + (i + 1) + ". " + dName[i]);
										}
										System.out.println("     77. 이전화면으로");
										System.out.println("======================");
										System.out.print(" 변경하실 상품을 선택해주세요 : ");
										button = scan.nextInt();
										switch (button) {
										case 1:
										case 2:
										case 3: // 1번 상품 선택(상품변경)
											System.out.println("======================");
											System.out.println(button + ". " + dName[button - 1] + "를 선택 하셨습니다.");
											System.out.println("======================");
											System.out.print(" 새로운 상품을 입력해 주세요 : ");
											n_dName[button - 1] = scan.next();
											System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
											System.out.printf("  %s가 %s로 변경되었습니다.\n", dName[button - 1],
													n_dName[button - 1]);
											System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
											dName[button - 1] = n_dName[button - 1];
											break;
										case 77: // 돌아가기
											break;
										default: // 주어진 번호 외 선택
											System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
											System.out.println("  올바른 번호를 입력해 주세요.");
											System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
											break;
										}
									}
									break;
								case 2: // 상품 가격변경
									while (button != 77) {
										System.out.println("======================");
										for (int i = 0; i < dName.length; i++) {
											System.out.println(
													"     " + (i + 1) + ". " + dName[i] + "(" + dPrice[i] + "원)");
										}
										System.out.println("     77. 이전화면으로");
										System.out.println("======================");
										System.out.print(" 가격을 변경하실 상품을 선택해주세요 : ");
										button = scan.nextInt();
										switch (button) {
										case 1:
										case 2:
										case 3: // 1번 상품 가격변경
											System.out.println("======================");
											System.out.println(button + ". " + dName[button - 1] + "("
													+ dPrice[button - 1] + "원)" + "를 선택 하셨습니다.");
											System.out.println("======================");
											System.out.print(" 변경할 가격을 입력해 주세요 : ");
											n_dPrice[button - 1] = scan.nextInt();
											System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
											System.out.printf("%d원에서 %d원으로 변경되었습니다.\n", dPrice[button - 1],
													n_dPrice[button - 1]);
											System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
											dPrice[button - 1] = n_dPrice[button - 1];
											break;
										case 77: // 돌아가기
											break;
										default: // 주어진 번호외 선택
											System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
											System.out.println("  올바른 번호를 입력해 주세요.");
											System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
											break;
										}
									}
									break;
								case 3: // 상품 재고 변경
									while (button != 77) {
										System.out.println("======================");
										for (int i = 0; i < dName.length; i++) {
											System.out.println(
													"     " + (i + 1) + ". " + dName[i] + "(" + dAmount[i] + "개)");
										}
										System.out.println("     77. 이전으로");
										System.out.println("======================");
										System.out.print("재고를 변경하실 상품을 선택해주세요 : ");
										button = scan.nextInt();
										switch (button) {
										case 1:
										case 2:
										case 3: // 1번상품 재고 변경
											while (button != 77) {
												System.out.println("======================");
												System.out.println(button + ". " + dName[button - 1] + "("
														+ dAmount[button - 1] + "개)" + "를 선택 하셨습니다.");
												System.out.println("======================");
												System.out.println("     1. 재고 추가");
												System.out.println("     2. 재고 감소");
												System.out.println("     77. 이전으로");
												System.out.println("======================");
												System.out.print(" 번호를 선택해 주세요. : ");
												button2 = scan.nextInt();
												switch (button2) {
												case 1:// 재고 추가
													System.out.println("======================");
													System.out.println("       재고 추가");
													System.out.println("======================");
													System.out.print(" 변경할 수치를 입력해 주세요 : ");
													n_dAmount[button - 1] = dAmount[button - 1] + scan.nextInt();
													System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
													System.out.printf("%d개에서 %d개로 변경되었습니다.\n", dAmount[button - 1],
															n_dAmount[button - 1]);
													System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
													dAmount[button - 1] = n_dAmount[button - 1];
													button = 77;
													break;
												case 2: // 재고 감소
													System.out.println("======================");
													System.out.println("       재고 감소");
													System.out.println("======================");
													System.out.print(" 변경할 수치를 입력해 주세요 : ");
													n_dAmount[button - 1] = dAmount[button - 1] - scan.nextInt();
													if (n_dAmount[button - 1] >= 0) {
														System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
														System.out.printf("%d개에서 %d개로 변경되었습니다.\n", dAmount[button - 1],
																n_dAmount[button - 1]);
														System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
														dAmount[button - 1] = n_dAmount[button - 1];
													} else {
														System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
														System.out.println("재고는 0개보다 작아질수 없습니다.");
														System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
													}
													button = 77;
													break;
												case 77: // 돌아가기
													button = 77;
													break;
												default: // 주어진 번호 외 선택
													System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
													System.out.println("  올바른 번호를 입력해 주세요.");
													System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
													break;
												}
											}
											button = 3; // 77번입력으로 반복문 나간 후 case 3번 화면으로 돌아감
											break;
										case 77: // 돌아가기 (반복문 종료)
											break;
										default: // 주어진 번호 외 선택
											System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
											System.out.println("  올바른 번호를 입력해 주세요.");
											System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
											break;
										}
									}
									break;
								case 4: // 매출관리
									cMax = salesC[0]; // 비교를 위해 첫품목 판매개수를 cMin, cMax에 넣고 시작
									cMin = salesC[0];
									System.out.println("======================");
									for (int i = 0; i < dName.length; i++) {
										if (i % 2 == 0) { // 단순꾸미기용
											icon = "★";
										} else {
											icon = "☆";
										}
										System.out.println(icon + " " + dName[i] + " 판매개수 : " + salesC[i] + " / 판매금액 : "
												+ salesA[i]);
										if (cMax < salesC[i]) { // 최다품목개수의 인덱스를 dMax에 저장
											cMax = salesC[i];
											dMax = i;
										}
										if (cMin > salesC[i]) { // 최소판매개수의 인덱스를 dMin에 저장
											cMin = salesC[i];
											dMin = i;
										}
									}
									if (cMax != 0) { // 최대 판매개수가 0이면 즉 판매내역이 없으면 출력하지 않음.
										System.out.print("※ 최다 판매 품목 : " + dName[dMax]);
										for (int i = 0; i < dName.length; i++) { // 최대 판매개수가 같은 품목 출력
											if (dMax != i && salesC[i] == salesC[dMax]) {
												System.out.print(", " + dName[i]);
											}
										}
										System.out.println();
									}
									System.out.print("※ 최소 판매 품목 : " + dName[dMin]);
									for (int i = 0; i < dName.length; i++) { // 최소 판매개수가 같은 품목 출력
										if (dMin != i && salesC[i] == salesC[dMin]) {
											System.out.print(", " + dName[i]);
										}
									}
									System.out.println();
									for (int i = 0; i < salesA.length; i++) { // 총 판매액 계산
										salesAll += salesA[i];
									}
									System.out.println("※ 총 판매액 : " + salesAll);
									break;
								case 88: // 첫 화면으로 ( 반복문 종료)
									break;
								default: // 주어진 번호 외 선택
									System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
									System.out.println("   올바른 번호를 입력해주세요");
									System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
								}
							} else { // 입력한 비밀번호가 틀릴시
								System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
								System.out.println("    잘못된 비밀번호입니다. ");
								System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
								break;
							}
						}
					case 88: // 처음으로 (반복문 종료 )
						break;
					default: // 주어진 번호 외 선택
						System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
						System.out.println("   올바른 번호를 입력해주세요");
						System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
						break;
					}
				}
				break;
			case 99: // 자판기 종료 (반복문 종료)
				power = true;
				break;
			default: // 주어진 번호 외 선택시
				System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
				System.out.println("   올바른 번호를 입력해주세요");
				System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
				break;
			}
		}
		System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
		System.out.println("        자판기 종료");
		System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
	}
}
