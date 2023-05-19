/*
 * _1 변경 사항
 * 관리자모드 추가
 * 
 */

package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report11_1 {

	public static void main(String[] args) {
//		1 음료 자판기 구현
//		2 음료 3종류 / 가격 별도 / 재고 구현
//		3 시작과 동시에 화면에 메뉴 표시
//		3-1	음료의 종류 와 가격, 재고, 거스름반환, 돈입력 등
//			99.자판기 종료
//		4. 99 이외의 숫자인 경우 화면 메뉴 표시

//		구입 가능 제품 점등

		boolean power = false; // 전원
		int input = -1;

		int money = 0;
		int cha = 0;

		int rem1 = 5;
		int rem2 = 5;
		int rem3 = 5;

		int cost1 = 1200;
		int cost2 = 1000;
		int cost3 = 800;

		String menu1 = "콜라";
		String menu2 = "커피";
		String menu3 = "생수";

		int pass = 1111;

		Scanner scan = new Scanner(System.in);

		while (!power) {
			System.out.println();
			System.out.println("[ 음료 자판기 ]");
			System.out.printf("%s / %d원 / 재고 : %d%n", menu1, cost1, rem1);
			System.out.printf("%s / %d원 / 재고 : %d%n", menu2, cost2, rem2);
			System.out.printf("%s / %d원 / 재고 : %d%n", menu3, cost3, rem3);
			System.out.printf("남은 돈 : %d원%n", money);
			System.out.printf("(1)돈 투입 (2)음료 구입 (3)거스름 반환 (66)관리자 모드 (99)자판기 종료%n");
			System.out.print("명령을 입력해주세요 : ");
			input = scan.nextInt();

			main: switch (input) {
			case 1:
				int tmp = 0;
				while (!power) {
					System.out.print("얼마나 넣겠습니까? : ");
					tmp = scan.nextInt();
					if (tmp < 0) {
						System.out.println("올바른 금액을 입력해주세요.");
					} else {
						money += tmp;
						break;
					}
				}
				break;

			case 2:
				while (!power) {
					System.out.println();
					System.out.printf("(1)%s / %d원 / 재고 : %d%n", menu1, cost1, rem1);
					System.out.printf("(2)%s / %d원 / 재고 : %d%n", menu2, cost2, rem2);
					System.out.printf("(3)%s / %d원 / 재고 : %d%n", menu3, cost3, rem3);
					System.out.printf("남은 돈 : %d%n", money);
					System.out.printf("음료를 선택해주세요 (99=처음으로) : ");
					input = scan.nextInt();
					switch (input) {
					case 1:
						if (money < cost1) {
							System.out.printf("%n***돈이 부족합니다.***%n");
							break main;
						} else if (rem1 <= 0) {
							System.out.printf("%n***%s 재고가 없습니다.***%n", menu1);
							break;
						} else {
							System.out.printf("%s를 1개 구입했습니다.%n", menu1);
							money -= cost1;
							rem1--;
						}
						break;
					case 2:
						if (money < cost2) {
							System.out.printf("%n***돈이 부족합니다.***%n");
							break main;
						} else if (rem2 <= 0) {
							System.out.printf("%n***%s 재고가 없습니다.***%n", menu2);
							break;
						} else {
							System.out.printf("%s를 1개 구입했습니다.%n", menu2);
							money -= cost2;
							rem2--;
						}
						break;
					case 3:
						if (money < cost3) {
							System.out.printf("%n***돈이 부족합니다.***%n");
							break main;
						} else if (rem3 <= 0) {
							System.out.printf("%n***%s 재고가 없습니다.***%n", menu3);
							break;
						} else {
							System.out.printf("%s를 1개 구입했습니다.%n", menu3);
							money -= cost3;
							rem3--;
						}
						break;
					case 99:
						break main;

					default:
						System.out.printf("%n올바른 숫자를 입력해주세요.%n");
						continue;
					}

				}

			case 3:
				cha = money;
				money = 0;
				System.out.printf("거스름 %d원을 반환합니다.%n", cha);
				break;

			case 66:
				System.out.print("관리자 암호를 입력해주세요 : ");
				int tmp2 = scan.nextInt();
				if (tmp2 == pass) {
					while (!power) {
						System.out.printf("%n[ 관리자 모드 ]%n");
						System.out.printf("(1)재고 관리 (2)품목 변경 (3)가격 설정 (4)암호 변경 (99)관리자 모드 종료%n");
						System.out.print("명령을 입력해주세요 : ");
						input = scan.nextInt();
						adm: switch (input) {
						case 1:
							while (!power) {
								System.out.printf("%n%s [%d]개 / %s [%d]개 / %s [%d]개%n", menu1, rem1, menu2, rem2, menu3, rem3);
								System.out.printf("(1)%s 재고 변경 (2)%s 재고 변경 (3)%s 재고 변경 (99)이전으로%n", menu1, menu2,
										menu3);
								System.out.print("명령을 입력해주세요 : ");
								input = scan.nextInt();
								rem: switch (input) {
								case 1:
									System.out.printf("변경할 %s의 재고 입력 : ", menu1);
									rem1 = scan.nextInt();
									break;

								case 2:
									System.out.printf("변경할 %s의 재고 입력 : ", menu2);
									rem2 = scan.nextInt();
									break;

								case 3:
									System.out.printf("변경할 %s의 재고 입력 : ", menu3);
									rem3 = scan.nextInt();
									break;
								case 99:
									break adm;
								default:
									System.out.printf("%n올바른 숫자를 입력해주세요.%n");
									continue;
								}

							}

						case 2:
							while (!power) {
								System.out.printf("%n슬롯 1 : [%s] / 슬롯 2 : [%s] / 슬롯 3 : [%s]%n", menu1, menu2, menu3);
								System.out.printf("(1)슬롯 1 변경 (2)슬롯 2 변경 (3)슬롯 3 변경 (99)이전으로%n");
								System.out.print("명령을 입력해주세요 : ");
								input = scan.nextInt();
								name: switch (input) {
								case 1:
									System.out.printf("슬롯 1 변경할 제품 입력 : ");
									menu1 = scan.next();
									break;
								case 2:
									System.out.printf("슬롯 2 변경할 제품 입력 : ");
									menu2 = scan.next();
									break;
								case 3:
									System.out.printf("슬롯 3 변경할 제품 입력 : ");
									menu3 = scan.next();
									break;
								case 99:
									break adm;

								default:
									System.out.printf("%n올바른 숫자를 입력해주세요.%n");
									continue;
								}

							}

						case 3:
							while (!power) {
								System.out.printf("%n%s [%d]원 / %s [%d]원 / %s [%d]원%n", menu1, cost1, menu2, cost2, menu3,
										cost3);
								System.out.printf("(1)%s 가격 변경 (2)%s 가격 변경 (3)%s 가격 변경 (99)이전으로%n", menu1, menu2,
										menu3);
								System.out.print("명령을 입력해주세요 : ");
								input = scan.nextInt();
								cost: switch (input) {
								case 1:
									System.out.printf("%s 변경할 가격 입력 : ", menu1);
									cost1 = scan.nextInt();
									break;
								case 2:
									System.out.printf("%s 변경할 가격 입력 : ", menu2);
									cost2 = scan.nextInt();
									break;
								case 3:
									System.out.printf("%s 변경할 가격 입력 : ", menu3);
									cost3 = scan.nextInt();
									break;
								case 99:
									break adm;

								default:
									System.out.printf("%n올바른 숫자를 입력해주세요.%n");
									continue;
								}

							}

						case 4:
							System.out.printf("%n관리자 암호를 한번 더 입력해주세요 : ");
							int tmp3 = scan.nextInt();
							if (tmp3 == pass) {
								System.out.print("변경할 암호 입력 : ");
								int tmp4 = scan.nextInt();
								System.out.print("변경할 암호 재입력 : ");
								int tmp5 = scan.nextInt();
								if (tmp4 == tmp5) {
									pass = tmp4;
									System.out.println("관리자 암호를 변경했습니다.");
									break;
								} else {
									System.out.println("재입력이 맞지 않습니다");
									break;
								}
							} else {
								System.out.println("암호가 틀렸습니다.");
								break;
							}

						case 99:
							break main;

						default:
							System.out.printf("%n올바른 숫자를 입력해주세요.%n");
							continue;

						}
					}
				} else {
					System.out.println("암호가 틀렸습니다");
					break;
				}

			case 99:
				power = true;
				break;

			default:
				System.out.printf("%n올바른 숫자를 입력해주세요.%n");
				break;
			}

		}

		scan.close();
		System.out.println("자판기 종료");

	} // end of main

} // end of class
