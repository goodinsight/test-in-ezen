package kss.co.kr.array;

import java.util.Scanner;

public class Report03_5 {
	public static void main(String[] args) {

		boolean power = false;

		String id = "root";
		String pw = "1111";

		String id2 = "";
		String pw2 = "";

		String[] dName = { "사이다", "콜라", "맥주" };

		int[] dPrice = { 2000, 3000, 5000 };

		int[] dAmount = { 10, 5, 7 };
		int money = 0;

		int num = 0;

		int pay = 0;

		int[] count = { 0, 0, 0 };

		String xy = "";

		Scanner sc = new Scanner(System.in);

		System.out.println("자판기를 실행하시겠습니까 ( y, x )");
		System.out.print("선택 >> ");
		xy = sc.next();

		switch (xy) {
		case "y":

			while (!power) {

				System.out.println("=======================음료 선택=======================");
				for (int i = 0; i < dName.length; i++) {

					System.out.println((i + 1) + ") " + dName[i] + " " + dPrice[i] + "원 ☆재고☆ " + dAmount[i] + "개");

				}

				System.out.println("4) 종료");
				System.out.println("99) 관리자 모드");
				System.out.print("돈을 입력 >> ");
				money += sc.nextInt();
				System.out.println("현재 투입 금액 " + money + "원");
				System.out.print("뽑을 음료 번호를 선택 or 종료 >>");
				num = sc.nextInt();
				System.out.println();

				switch (num) {
				case 1: // 1 ~ 3번 선택시 결재 / 재고 -1 / 수익 계산을 위해 카운트
				case 2:
				case 3:

					for (int i = 0; i < num; i++) {

						if (money >= dPrice[i]) {
							System.out.println(dName[i] + "를 선택");
							dAmount[i] -= 1;
							money -= dPrice[i];
							count[i]++;

							System.out.println(dPrice[i] + "원 결제");
							System.out.println(dAmount[i] + "개 남음");
							System.out.println(money + "원 남았습니다");
							System.out.println();

						} else if (money < dPrice[i]) {
							System.out.println("====돈이 부족====");
						} else if (dAmount[i] == 0) {
							System.out.println("====재고가 없음====");
						}

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
					System.out.println(id2);
					System.out.println();
					System.out.print("비밀번호 >> ");
					pw2 = sc.next();
					System.out.println(pw2);

					if (id.equals(id2) && pw.equals(pw2)) {

						System.out.println(id + " " + id2);
						System.out.println(pw + " " + pw2);
						System.out.println();

					} else if (!(id.equals(id2)) || !(pw.equals(pw2))) {

						System.out.println(id + " " + id2);
						System.out.println(pw + " " + pw2);
						System.out.println("아이디나 비밀번호가 틀립니다");
						System.out.println();

						break;

					}

					while (num != 9) {

						System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
						System.out.println("1) 재고관리, 2) 상품관리, 3) 가격변경, 4) 매출 확인");
						System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
						System.out.println("5) 관리자 아이디 변경, 6) 관리자 비밀번호 변경, 9) 뒤로가기");
						System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
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
								System.out.print("1) OK, 44) NO >> ");
								num = sc.nextInt();

								switch (num) {
								case 1:

									for (int i = 0; i < dAmount.length; i++) {

										System.out.print(dName[i] + " 재고변경 >> ");
										dAmount[i] = sc.nextInt();
										dAmount[i] = dAmount[i];

										System.out.println();

										System.out.println(dName[i] + " " + dAmount[i] + "개 재고가 변경되었습니다");

									}

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
								System.out.print("1) OK, 55) NO >> ");
								num = sc.nextInt();

								switch (num) {
								case 1:

									for (int i = 0; i < dName.length; i++) {

										System.out.print(dName[i] + " 상품변경 >> ");
										dName[i] = sc.next();
										dName[i] = dName[i];

										System.out.println();

										System.out.println(dName[i] + " 상품이 변경되었습니다");

									}

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
								System.out.print("1) OK, 66) NO >>");
								num = sc.nextInt();

								switch (num) {
								case 1:

									for (int i = 0; i < dPrice.length; i++) {

										System.out.print(dName[i] + " " + dPrice[i] + " 가격변경 >> ");
										dPrice[i] = sc.nextInt();
										dPrice[i] = dPrice[i];

										System.out.println();

										System.out.println(dName[i] + " " + dPrice[i] + "원 가격이 변경되었습니다");

									}

									break;

								case 66:

									System.out.println("뒤로가기");

									break;
								}

							}

							break;

						case 4: // 총매출 확인

							for (int i = 0; i < count.length; i++) {

								pay += count[i] * dPrice[i];
								System.out.println(dName[i] + " " + dPrice[i] + "원 " + count[i] + "개 판매");

							}

							System.out.println("총 매출 " + pay + "원 입니다");
							System.out.println();

							break;

						case 5: // 관리자 아이디 변경

							while (num != 77) {

								System.out.println(id);
								System.out.println("관리자 아이디 변경 하쉴?");
								System.out.print("1) OK, 77) NO >> ");
								num = sc.nextInt();

								switch (num) {
								case 1:

									System.out.print("관리자 아이디 변경 >> ");
									id2 = sc.next();
									id = id2;
									System.out.println(id);

									break;

								case 77:

									System.out.println("뒤로가기");

									break;
								}

							}

							break;

						case 6: // 관리자 비밀번호 변경

							while (num != 88) {

								System.out.println(pw);
								System.out.println("관리자 비밀번호 변경 하쉴?");
								System.out.print("1) OK, 88) NO >> ");
								num = sc.nextInt();

								switch (num) {
								case 1:

									System.out.print("관리자 비밀번호 변경 >> ");
									pw2 = sc.next();
									pw = pw2;
									System.out.println(pw);

									break;

								case 77:

									System.out.println("뒤로가기");

									break;
								}

							}

							break;

						case 9:

							System.out.println("뒤로가기");

							break;

						}

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
