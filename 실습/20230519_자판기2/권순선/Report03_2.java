package kss.co.kr.array;

import java.util.Scanner;

public class Report03_2 {
	public static void main(String[] args) {

		boolean power = false;

		String id = "root";
		String pw = "a1234";

		String id2 = "";
		String pw2 = "";

		String[] dName = { "사이다", "콜라", "맥주" };

		int[] dPrice = { 2000, 3000, 5000 };

		int[] dAmount = { 10, 5, 7 };
		int money = 0;

		int num = 0;

		int pay = 0;
		int pay2 = 0;
		int pay3 = 0;
		int pay4 = 0;

		int count = 0;
		int count2 = 0;
		int count3 = 0;

		String xy = "";

		Scanner sc = new Scanner(System.in);

		System.out.println("자판기를 실행하시겠습니까 ( y, x )");
		System.out.print("선택 >> ");
		xy = sc.next();

		switch (xy) {
		case "y":

			while (!power) {

				System.out.println("=======================음료 선택=======================");
				System.out.println("1) " + dName[0] + " " + dPrice[0] + "원 ☆재고☆ " + dAmount[0] + "개");
				System.out.println("2) " + dName[1] + " " + dPrice[1] + "원 ☆재고☆ " + dAmount[1] + "개");
				System.out.println("3) " + dName[2] + " " + dPrice[2] + "원 ☆재고☆ " + dAmount[2] + "개");
				System.out.println("4) 종료");
				System.out.println("99) 관리자 모드");
				System.out.print("돈을 입력 >> ");
				money += sc.nextInt();
				System.out.println("현재 투입 금액 " + money + "원");
				System.out.print("뽑을 음료 번호를 선택 or 종료 >>");
				num = sc.nextInt();

				switch (num) {
				case 1: // 1번 선택시 결재 / 재고 -1 / 수익 계산을 위해 카운트

					if (money >= dPrice[0]) {
						System.out.println(dName[0] + "를 선택");
						dAmount[0] -= 1;
						money -= dPrice[0];
						System.out.println(dPrice[0] + "원 결제");
						System.out.println(dAmount[0] + "개 남음");
						System.out.println(money + "원 남았습니다");
						count++;
					} else if (money < dPrice[0]) {
						System.out.println("====돈이 부족====");
					} else if (dAmount[0] == 0) {
						System.out.println("====재고가 없음====");
					}

					break;

				case 2: // 2번 선택시 결재 / 재고 -1 / 수익 계산을 위해 카운트

					if (money >= dPrice[1]) {
						System.out.println(dName[1] + "를 선택");
						dAmount[1] -= 1;
						money -= dPrice[1];
						System.out.println(dPrice[1] + "원 결제");
						System.out.println(dAmount[1] + "개 남음");
						System.out.println(money + "원 남았습니다");
						count2++;
					} else if (money < dPrice[1]) {
						System.out.println("====돈이 부족====");
					} else if (dAmount[1] == 0) {
						System.out.println("====재고가 없음====");
					}

					break;

				case 3: // 3번 선택시 결재 / 재고 -1 / 수익 계산을 위해 카운트

					if (money >= dPrice[2]) {
						System.out.println(dName[2] + "를 선택");
						dAmount[2] -= 1;
						money -= dPrice[2];
						System.out.println(dPrice[2] + "원 결제");
						System.out.println(dAmount[2] + "개 남음");
						System.out.println(money + "원 남았습니다");
						count3++;
					} else if (money < dPrice[2]) {
						System.out.println("====돈이 부족====");
					} else if (dAmount[2] == 0) {
						System.out.println("====재고가 없음====");
					}

					break;

				case 4: // 종료시 잔돈 나옴

					power = true;
					System.out.println(money + "원 잔돈입니다");
					System.out.println("종료");
					break;

				case 99: // 관리자

					System.out.println("아이디와 비밀번호 입력");
					System.out.print("아이디 >> ");
					id2 = sc.next();
					System.out.println();
					System.out.print("비밀번호 >> ");
					pw2 = sc.next();
										
					if (id != id2 && pw != pw2) {

						while (num != 9) {

							System.out.println("1) 재고관리, 2) 상품관리, 3) 가격변경 4) 매출 확인 9) 뒤로가기");
							System.out.print("번호 선택 >> ");
							num = sc.nextInt();

							switch (num) {
							case 1: // 재고확인 및 변경

								while (num != 44) {

									for (int i = 0; i < dAmount.length; i++) {
										System.out.println("현재 재고 " + dName[i] + " " + dAmount[i] + "개");
									}

									System.out.println();
									System.out.println("재고변경 하쉴?");
									System.out.println("1) OK, 44) NO");
									num = sc.nextInt();

									switch (num) {
									case 1:

										System.out.println("1번 재고 변경 >> ");
										dAmount[0] = sc.nextInt();
										dAmount[0] = dAmount[0];
										System.out.println("2번 재고 변경 >> ");
										dAmount[1] = sc.nextInt();
										dAmount[1] = dAmount[1];
										System.out.println("3번 재고 변경 >> ");
										dAmount[2] = sc.nextInt();
										dAmount[2] = dAmount[2];

										System.out.println("1번 " + dAmount[0] + "개");
										System.out.println("2번 " + dAmount[1] + "개");
										System.out.println("3번 " + dAmount[2] + "개");

										break;

									case 44:

										System.out.println("뒤로가기");

										break;
									}

								}

								break;

							case 2: // 상품변경

								while (num != 55) {

									for (int i = 0; i < dName.length; i++) {
										System.out.println("현재 상품 " + dName[i]);
									}

									System.out.println();
									System.out.println("상품변경 하쉴?");
									System.out.println("1) OK, 55) NO");
									num = sc.nextInt();

									switch (num) {
									case 1:

										System.out.println("1번 상품 변경 >> ");
										dName[0] = sc.next();
										dName[0] = dName[0];

										System.out.println("2번 상품 변경 >> ");
										dName[1] = sc.next();
										dName[1] = dName[1];

										System.out.println("3번 상품 변경 >> ");
										dName[2] = sc.next();
										dName[2] = dName[2];

										System.out.println("1번 " + dName[0]);
										System.out.println("2번 " + dName[1]);
										System.out.println("3번 " + dName[2]);

										break;

									case 55:

										System.out.println("뒤로가기");

										break;
									}

								}

								break;

							case 3: // 가격변경

								while (num != 66) {

									for (int i = 0; i < dPrice.length; i++) {
										System.out.println("현재 가격 " + dName[i] + " " + dPrice[i]);
									}

									System.out.println();
									System.out.println("가격변경 하쉴?");
									System.out.println("1) OK, 66) NO");
									num = sc.nextInt();

									switch (num) {
									case 1:

										System.out.println("1번 가격 변경 >> ");
										dPrice[0] = sc.nextInt();
										dPrice[0] = dPrice[0];
										System.out.println("2번 가격 변경 >> ");
										dPrice[1] = sc.nextInt();
										dPrice[1] = dPrice[1];
										System.out.println("3번 가격 변경 >> ");
										dPrice[2] = sc.nextInt();
										dPrice[2] = dPrice[2];

										System.out.println("1번 " + dPrice[0] + "원");
										System.out.println("2번 " + dPrice[1] + "원");
										System.out.println("3번 " + dPrice[2] + "원");

										break;

									case 66:

										System.out.println("뒤로가기");

										break;
									}

								}

								break;

							case 4: // 총매출 확인

								pay = count * dPrice[0];
								pay2 = count2 * dPrice[1];
								pay3 = count3 * dPrice[2];
								System.out.println(dName[0] + " " + dPrice[0] + "원 " + count + "개 판매");
								System.out.println(dName[1] + " " + dPrice[1] + "원 " + count2 + "개 판매");
								System.out.println(dName[2] + " " + dPrice[2] + "원 " + count3 + "개 판매");
								pay4 = pay + pay2 + pay3;
								System.out.println("총 매출 " + pay4 + "원 입니다");
								System.out.println();

								break;

							case 9:

								System.out.println("뒤로가기");

								break;

							}

						}

					} else {

						System.out.println("아이디나 비밀번호가 틀립니다");
						System.out.println("다시 입력하세요");

					}

				}

			}

			break;

		case "x":
			power = true;
			System.out.println("종료");

			break;

		}
	}
}
