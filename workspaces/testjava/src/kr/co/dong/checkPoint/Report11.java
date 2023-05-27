/*
 * [_1 변경 사항]
 * 1.관리자모드 추가
 * 
 * 
 * [_1_1 변경 사항]
 * 1.세부 while 조건 변경 - 어차피 true인 부분은 그냥 true로 처리
 * 
 * 2.switch문 간소화 - 잘못된 입력과 메뉴 종료를 do-while과 if문 조합으로 변경
 * (변경 후 관리자모드 input=99가 관리자 메뉴 안의 input=99와 겹쳐 관리자모드가 종료되는 상황 -> 메뉴 안의 '이전으로' 명령을 99에서 9로 변경)
 * 
 * 3.if문 간소화 - 부정 조건을 우선 배치
 * 
 * 4.돈이 부족할 때 얼마가 부족한지 표시
 * 
 * 5.관리자모드의 '품목 변경' 입력에 띄어쓰기가 가능하게 변경
 * (입력을 nextLine으로 변경, 모든 입력부분을 nextLine으로 변경하는 대신 '품목 변경'의 input 직후에 nextLine을 배치해 오류 대응)
 * 
 * 6.관리자모드의 '재고 관리'와 '가격 설정' 입력에 음수 입력 불가
 * (임시 입력에 사용하는 tmp 변수는 어차피 바로 입력돼서 덧씌워지니까 따로 여러개 안 만들어도 됨, 암호 변경때처럼 임시 변수를 바로 여러개 사용할 때는 제외)
 * 
 * 
 * [_2 변경 사항]
 * 1.변수를 배열로 처리
 * (배열 길이가 더 길어질 것을 고려해 관리자모드 내부 메뉴의 '이전으로' 명령을 9에서 99로 변경)
 * 
 * 2.반복문이 많은 switch문을 배열을 활용한 for문으로 변경
 * (변경된 부분이 속한 do-while문은 종료 명령을 if문으로 편하게 처리하기 위해 while문으로 변경)
 * 
 * 3.거스름을 화폐로 반환하도록 변경
 * 
 * 4.관리자모드에 '매출 확인' 추가
 * 
 * 5.제품과 가격 변경시 해당 슬롯의 판매 수가 초기화되도록 설정
 * 
 * 6.'재고 관리'를 신규 입력 방식이 아닌 증가 감소 방식으로 변경
 * 
 * 7.'음료 구입' 메뉴에서 구매 가능한 제품만 표기하도록 변경
 * 
 * 8.관리자모드에 '전체 재설정' 추가
 * 
 * 
 * [_2_1 변경 사항]
 * 9.코드가 변해서 input==99 중복이 일어나지 않았기에 관리자모드 내부의 '이전으로' 명령을 99로 다시 변경
 * 
 * 10.'매출 확인'의 총매출 계산식이 잘못되어있어 수정
 * (구매시 개별 매출을 저장하는 dGain 배열을 추가해서 매출 확인 때에 그 합을 총매출로 표시하도록 변경)
 * 
 */

package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report11 {

	public static void main(String[] args) {
//		1 음료 자판기 구현
//		2 음료 3종류 / 가격 별도 / 재고 구현
//		3 시작과 동시에 화면에 메뉴 표시
//		3-1	음료의 종류 와 가격, 재고, 거스름반환, 돈입력 등
//			99.자판기 종료
//		4. 99 이외의 숫자인 경우 화면 메뉴 표시
//
//		문자열 입력 상황을 고려해서 처음부터 nextLine만 사용하는 것을 추천

		boolean power = false; // 전원
		int input = 0; // 항목 선택 입력
		int tmp = 0; // 수치 입력과 임시 변수
		int idx = 0; // 항목 선택에서 연계되는 인덱스

		int money = 0; // 남아있는 돈
		int money2 = 0; // 남아있는 돈의 십의자리 미만 날림 (거스름 총액)
		int cha = 0; // 거스름 계산 변수
		int moreNeed = 0; // 구입시 부족한 금액
		int tGain = 0; // 총 매출

		String[] dName = null; // 음료 이름 배열
		int[] dAmount = null; // 음료 재고 배열
		int[] dPrice = null; // 음료 가격 배열

		dName = new String[] { "콜라", "커피", "생수" }; // 음료 이름 초기값
		dAmount = new int[] { 5, 5, 5 }; // 음료 재고 초기값
		dPrice = new int[] { 1500, 1800, 1000 }; // 음료 가격 초기값

		int[] dSell = new int[dName.length]; // 음료 판매 수 배열
		int[] dGain = new int[dName.length]; // 음료 매출 배열
		int[] dCoin = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 }; // 거스름 화폐 단위 값
		int[] dCoinCount = new int[dCoin.length]; // 거스름 화폐 개수
		String[] dCoinName = { "5만원", "1만원", "5천원", "1천원", "5백원", "1백원", "5십원", "1십원" }; // 거스름 화폐 이름

		int pass = 1111; // 관리자 암호

		Scanner scan = new Scanner(System.in);

		while (!power) {
			System.out.printf("%n[ 음료 자판기 ]%n"); // 자판기 초기 화면
			for (int i = 0; i < dName.length; i++) {
				System.out.printf("%s / %d원 / 재고 : %d%n", dName[i], dPrice[i], dAmount[i]);
			}

			System.out.printf("남은 돈 : %d원%n", money);
			System.out.println("(1)돈 투입 (2)음료 구입 (3)거스름 반환 (66)관리자 모드 (99)자판기 종료");

//					입력 예외처리 (여기 한 부분만 해봄)
//			-------------------------------------------------------------------------------

			while (true) { // 오류가 발생하지 않고 진행되면 break로 종료
				try {
					System.out.print("명령을 입력해주세요 : ");
					input = scan.nextInt(); // int형 입력만 받음
					break;
				} catch (Exception e) { // int형 입력이 아니었을 때 catch
					System.out.println("***숫자를 입력해주세요.***");
					scan = new Scanner(System.in); //
				}
			}

//			--------------------------------------------------------------------------------

			switch (input) {
			case 1: // 돈 투입
				while (true) {
					System.out.print("얼마나 넣겠습니까? : ");
					tmp = scan.nextInt();
					if (tmp < 0) {
						System.out.printf("%n***올바른 금액을 입력해주세요.***%n%n");
						continue;
					}
					money += tmp;
					break;
				}

				break; // case1 돈투입 -> case2 음료구입으로 바로 가게 하려면 case1의 break 없애도 됨

			case 2: // 음료 구입
				while (true) {
					System.out.println();
					tmp = 0;
					for (int i = 0; i < dName.length; i++) {
						if (money >= dPrice[i] && dAmount[i] != 0) {
							System.out.printf("(%d)%s / %d원 / 재고 : %d%n", i + 1, dName[i], dPrice[i], dAmount[i]);
							tmp += 1;
						}
					}
					if (tmp == 0) {
						System.out.println("***구매할 수 있는 제품이 없습니다.***");
						System.out.println("***재고를 확인하거나 충분한 돈을 투입해주세요.***");
						break;
					}

					System.out.printf("남은 돈 : %d%n", money);
					System.out.print("음료를 선택해주세요 (99=처음으로) : ");
					input = scan.nextInt();
					if ((input < 1 || input > dName.length) && input != 99) {
						System.out.printf("%n***올바른 숫자를 입력해주세요.***%n");
						continue;
					} else if (input == 99) {
						break;
					}

					idx = input - 1;

					if (money < dPrice[idx]) {
						moreNeed = dPrice[idx] - money;
						System.out.printf("%n***돈이 %d원 부족합니다.***%n", moreNeed);
						continue;
					} else if (dAmount[idx] <= 0) {
						System.out.printf("%n***%s 재고가 없습니다.***%n", dName[idx]);
						continue;
					} else {
						System.out.printf("%s를 1개 구입했습니다.%n", dName[idx]);
						money -= dPrice[idx];
						dAmount[idx]--;
						dSell[idx]++;
						dGain[idx] += dPrice[idx];
					}

				}
				break;

			case 3: // 거스름 반환

				cha = money;
				money2 = money / 10 * 10;

				for (int i = 0; i < dCoin.length; i++) {
					if (cha >= dCoin[i]) {
						dCoinCount[i] = cha / dCoin[i];
						cha -= dCoinCount[i] * dCoin[i];
					}
				}
				System.out.println();
				for (int i = 0; i < dCoin.length; i++) {
					if (dCoinCount[i] >= 1) {
						System.out.printf("%s %d개, ", dCoinName[i], dCoinCount[i]);
					}
				}
				System.out.printf("%n총 %d원 반환됩니다. 10원 미만은 반환되지 않습니다.%n", money2);

				money -= money2;

				break;

			case 66: // 관리자 모드
				System.out.print("관리자 암호를 입력해주세요 : ");
				tmp = scan.nextInt();
				if (tmp != pass) {
					System.out.printf("%n***암호가 틀렸습니다***%n");
					break;
				}
				while (true) {
					System.out.printf("%n[ 관리자 모드 ]%n");
					System.out.printf("(1)재고 관리 (2)품목 변경 (3)가격 설정 (4)매출 확인 (5)전체 재설정 (6)암호 변경 (99)관리자 모드 종료%n");
					System.out.print("명령을 입력해주세요 : ");
					input = scan.nextInt();
					if ((input < 1 || input > 6) && input != 99) {
						System.out.printf("%n***올바른 숫자를 입력해주세요.***%n");
						continue;
					} else if (input == 99)
						break;

					switch (input) {
					case 1: // 관리자 모드 - 재고 관리
						while (true) {
							System.out.println();
							for (int i = 0; i < dName.length; i++) {
								System.out.printf("%s [%d]개%n", dName[i], dAmount[i]);
							}
							for (int i = 0; i < dName.length; i++) {
								System.out.printf("(%d)%s 재고 변경 ", i + 1, dName[i]);
							}
							System.out.print("(99)이전으로");
							System.out.printf("%n명령을 입력해주세요 : ");
							input = scan.nextInt();
							if ((input < 1 || input > dName.length) && input != 99) {
								System.out.printf("%n***올바른 숫자를 입력해주세요.***%n");
								continue;
							} else if (input == 99) {
								break;
							}

							idx = input - 1;

							System.out.printf("(1)%s 재고 증가 (2)%s 재고 감소 (99)이전으로", dName[idx], dName[idx]);
							System.out.printf("%n명령을 입력해주세요 : ");
							input = scan.nextInt();

							switch (input) {
							case 1: // 관리자 모드 - 재고 관리 - 재고 증가
								System.out.printf("증가시킬 %s의 개수 입력 : ", dName[idx]);
								tmp = scan.nextInt();
								if (tmp < 0) {
									System.out.printf("%n***0개 이상의 개수를 입력해주세요.***%n");
									continue;
								}
								dAmount[idx] += tmp;

								break;

							case 2: // 관리자 모드 - 재고 관리 - 재고 감소
								System.out.printf("감소시킬 %s의 개수 입력 : ", dName[idx]);
								tmp = scan.nextInt();
								if (tmp < 0) {
									System.out.printf("%n***0개 이상의 개수를 입력해주세요.***%n");
									continue;
								} else if (tmp > dAmount[idx]) {
									dAmount[idx] = 0;
									break;
								}
								dAmount[idx] -= tmp;

								break;

							case 99:

								break;

							default:
								System.out.printf("%n***올바른 숫자를 입력해주세요.***%n");
								continue;

							}

						}
						break;

					case 2: // 관리자 모드 - 품목 변경
						while (true) {
							System.out.println();
							for (int i = 0; i < dName.length; i++) {
								System.out.printf("슬롯%d : [%s]%n", i + 1, dName[i]);
							}
							for (int i = 0; i < dName.length; i++) {
								System.out.printf("(%d)슬롯%d 변경 ", i + 1, i + 1);
							}
							System.out.printf("(99)이전으로%n");
							System.out.printf("%n***품목 변경시 기존 제품의 판매 수가 초기화됩니다.***%n");
							System.out.printf("명령을 입력해주세요 : ");
							input = scan.nextInt();
							String tmp99 = scan.nextLine(); // nextLine으로 수정해야 할 부분이 너무 많아서 그냥 엔터를 흡수해줄 nextLine하나를 추가해줌
							if ((input < 1 || input > dName.length) && input != 99) {
								System.out.printf("%n***올바른 숫자를 입력해주세요.***%n");
								continue;
							} else if (input == 99) {
								break;
							}

							idx = input - 1;

							System.out.printf("%s의 판매 수가 초기화됐습니다.%n", dName[idx]);
							dSell[idx] = 0;
							System.out.printf("슬롯%d 변경할 제품 입력 : ", input);
							dName[idx] = scan.nextLine();
							System.out.printf("제품이 변경되었습니다. %s의 재고를 새로 추가해주세요.%n", dName[idx]);
							dAmount[idx] = 0;
							continue;

						}
						break;

					case 3: // 관리자 모드 - 가격 설정
						while (true) {
							System.out.println();
							for (int i = 0; i < dName.length; i++) {
								System.out.printf("%s [%d]원%n", dName[i], dPrice[i]);
							}
							for (int i = 0; i < dName.length; i++) {
								System.out.printf("(%d)%s 가격 변경 ", i + 1, dName[i]);
							}
							System.out.printf("(99)이전으로%n");
							System.out.printf("%n***가격 변경시 해당 제품의 판매 수가 초기화됩니다.***%n");
							System.out.printf("명령을 입력해주세요 : ");
							input = scan.nextInt();
							if ((input < 1 || input > dName.length) && input != 99) {
								System.out.printf("%n***올바른 숫자를 입력해주세요.***%n");
								continue;
							} else if (input == 99) {
								break;
							}

							idx = input - 1;

							System.out.printf("%s의 판매 수가 초기화됐습니다.%n", dName[idx]);
							dSell[idx] = 0;
							System.out.printf("%s 변경할 가격 입력 : ", dName[idx]);
							tmp = scan.nextInt();
							if (tmp < 0) {
								System.out.printf("%n***0원 이상의 가격을 입력해주세요.***%n");
								continue;
							}
							dPrice[idx] = tmp;
							continue;

						}
						break;

					case 4: // 관리자 모드 - 매출 확인
						for (int i = 0; i < dName.length; i++) {
							if (dSell[i] > 0) {
								System.out.printf("%s 판매 수 : %d, 매출 : %d원%n", dName[i], dSell[i], dGain[i]);
							}
						}
						tGain = 0;
						for (int i = 0; i < dName.length; i++) {
							tGain += dGain[i];
						}
						System.out.printf("총 매출 (품목 및 가격 변경전 매출 포함): %d원%n", tGain);
						break;

					case 5: // 관리자 모드 - 전체 재설정
						System.out.printf("%n***재설정시 모든 제품의 판매 수가 초기화됩니다.***%n");
						System.out.print("모든 항목을 재설정하겠습니까? (666)신규 재설정 (777)초기 설정 복구 (그외 숫자)취소 : ");
						input = scan.nextInt();
						if (input != 666 && input != 777) {
							System.out.printf("%n***취소되었습니다.***%n");
							break;
						}

						for (int i = 0; i < dName.length; i++) {
							dSell[i] = 0;
						}

						if (input == 777) {
							dName = new String[] { "콜라", "커피", "생수" };
							dAmount = new int[] { 5, 5, 5 };
							dPrice = new int[] { 1500, 1800, 1000 };
							System.out.println("초기 설정으로 복구되었습니다.");
							break;
						}

						System.out.println("1. 슬롯 설정 단계");

						while (true) {
							System.out.print("자판기 슬롯의 개수를 입력해주세요. : ");
							input = scan.nextInt();
							String tmp99 = scan.nextLine();
							if (input <= 0) {
								System.out.printf("%n***1개 이상의 슬롯을 입력해주세요.***%n%n");
								continue;
							}
							break;
						}

						dName = new String[input];
						dPrice = new int[input];
						dAmount = new int[input];

						System.out.println("2. 제품 등록 단계");
						for (int i = 0; i < dName.length; i++) {
							System.out.printf("[%d번] 슬롯 제품의 이름 입력: ", i + 1);
							dName[i] = scan.nextLine();
						}

						System.out.println("3. 가격 설정 단계");
						for (int i = 0; i < dName.length; i++) {
							System.out.printf("%d번 슬롯 [%s]의 가격 입력: ", i + 1, dName[i]);
							input = scan.nextInt();
							if (input <= 0) {
								System.out.printf("%n***0보다 큰 가격을 입력해주세요.***%n%n");
								i--;
							}
							dPrice[i] = input;
						}

						System.out.println("4. 재고 설정 단계");
						for (int i = 0; i < dName.length; i++) {
							System.out.printf("%d번 슬롯 [%s]의 재고 입력 : ", i + 1, dName[i]);
							input = scan.nextInt();
							if (input <= 0) {
								System.out.printf("%n***0보다 큰 개수를 입력해주세요***%n%n");
								i--;
							}
							dAmount[i] = input;
						}
						System.out.println("신규 재설정이 완료되었습니다.");

						break;

					case 6: // 관리자 모드 - 암호 변경
						System.out.printf("%n관리자 암호를 한번 더 입력해주세요 : ");
						tmp = scan.nextInt();
						if (tmp != pass) {
							System.out.printf("%n***암호가 틀렸습니다.***%n");
							break;
						}
						System.out.print("변경할 암호 입력 : ");
						int tmp1 = scan.nextInt();
						System.out.print("변경할 암호 재입력 : ");
						int tmp2 = scan.nextInt();
						if (tmp1 != tmp2) {
							System.out.printf("%n***재입력이 맞지 않습니다.***%n");
							break;
						}
						pass = tmp;
						System.out.println("관리자 암호를 변경했습니다.");
						break;

					}

				}
				break;

			case 99: // 자판기 종료
				power = true;
				break;

			default:
				System.out.printf("%n***올바른 숫자를 입력해주세요.***%n");
				break;
			}

		}

		scan.close();
		System.out.println("자판기 종료");

	} // end of main

} // end of class
