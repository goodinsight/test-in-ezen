package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report18_Day5 {
	// 거스름돈 완료
	//앞으로할일: 동전관리 제작하기
	public static void main(String[] args) {
		boolean power = false; // 전원

		int items = 3; // 제품 종류
		String[] dName = new String[items]; // 이름
		int[] dPrice = new int[items]; // 가격
		int[] dAmount = new int[items]; // 재고수
		int money = 0;
		int moneys[] = { 50, 100, 500, 1000 };
		int summoney[] = new int[moneys.length];
		int inmoney[] = new int[moneys.length];
		int tempcoin = 0;

		// 테스트용 설정
		dName[0] = "음료수";
		dPrice[0] = 1800;

		for (int i = 0; i < summoney.length; i++) { // 초기 동전세팅 : 전부 10개
			summoney[i] = 10;
		}

		Scanner scan = new Scanner(System.in);
		while (!power) {
			int adminS = 0; // 관리자메뉴
			int itemN = 0; // 제품번호
			int select = 0;
			System.out.println("==================================");
			System.out.println("현재 잔액:" + money + " (돈입력>>50,100,500,1000을 입력)");
			System.out.println("음료번호를 선택하세요 잔돈반환:9번");
			for (int i = 0; i < dName.length; i++) {
				System.out.print(i + "번:" + dName[i] + "(" + dPrice[i] + "원) ");
			}
			select = scan.nextInt();

			// 음료나오는 과정
			for (int i = 0; i < dName.length; i++) {
				if (i == select) {
					if (dPrice[i] > money) {
						System.out.println("돈이 부족합니다!");
						continue;
					} else if (dAmount[i] == 0) {
						System.out.println("재고가 부족합니다!");
						continue;
					} else {
						System.out.println(dName[i] + "(이)가 나왔습니다.");
						money -= dPrice[i];
						dAmount[i]--;
						while (!(inmoney[3] * moneys[3] < money)) {
							inmoney[3]--;
							continue;
						}
					}
				}
			}

			switch (select) {
			case 50:
				money += moneys[0];
				summoney[0]++;
				inmoney[0]++;
				continue;

			case 100:
				money += moneys[1];
				summoney[1]++;
				inmoney[1]++;
				continue;

			case 500:
				money += moneys[2];
				summoney[2]++;
				inmoney[2]++;
				continue;

			case 1000:
				money += moneys[3];
				summoney[3]++;
				inmoney[3]++;
				continue;

			case 9: // 거스름돈
				System.out.println("==================================");
				System.out.println("거스름돈 " + money + "원 입니다.");
				if (money <= 1000) {
					inmoney[3] = 0;
				}
				if (money >= 1000 && inmoney[3] >= 1) {
					while (!(inmoney[3] == 1)) {
						money -= moneys[3];
						inmoney[3]--;
						tempcoin += 2;
					}
					tempcoin -= 2;
				}

				inmoney[2] = money / moneys[2]; // 500원 처리
				money -= inmoney[2] * moneys[2];
				inmoney[2] += tempcoin; // 지폐>동전 교환 반영
				
				inmoney[1] = money / moneys[1]; // 100원 처리
				money -= inmoney[1] * moneys[1];
				
				inmoney[0] = money / moneys[0]; // 50원 처리
				money -= inmoney[0] * moneys[0];

				for (int i = 0; i < inmoney.length; i++) {
					summoney[i] -= inmoney[i]; // 자판기 동전수 감소
					System.out.print(moneys[i] + "원:" + inmoney[i] + " ");
					inmoney[i] = 0; // 반환한 동전카운트 리셋
				}
				tempcoin = 0;
				System.out.println();
				continue;

			case 99: // 관리자번호
				while (!(adminS == 9)) {
					System.out.println("==================================");
					System.out.println(">>관리자 모드입니다<<");
					System.out.println(">>원하는 설정의 번호를 입력해주세요.<<");
					System.out.println("1)음료이름변경 2)가격설정 3)재고관리");
					System.out.print("7)동전관리 8)음료재설정 9)설정종료 0)자판기종료");
					adminS = scan.nextInt();
					switch (adminS) {
					case 1:
						System.out.println("==================================");
						System.out.println("이름을 바꿀 음료번호를 입력하세요");
						System.out.println("현재 음료들의 이름");
						for (int i = 0; i < dName.length; i++) {
							System.out.print(i + "번" + dName[i] + " ");
						}
						itemN = scan.nextInt();

						for (int i = 0; i < dName.length; i++) {
							if (i == itemN) {
								System.out.println("새로운 음료의 이름은?");
								dName[i] = scan.next();
							}
						}
						System.out.println("설정이 완료되었습니다.");
						continue;

					case 2:
						System.out.println("==================================");
						System.out.println("가격을 바꿀 음료번호를 입력하세요");
						System.out.println("현재 음료의 이름과 가격");
						for (int i = 0; i < dName.length; i++) {
							System.out.print(i + "번:" + dName[i] + "(" + dPrice[i] + "원) ");
						}
						itemN = scan.nextInt();

						for (int i = 0; i < dName.length; i++) {
							if (i == itemN) {
								System.out.println("재설정할 가격은?");
								dPrice[i] = scan.nextInt();
							}
						}
						System.out.println("설정이 완료되었습니다.");
						continue;

					case 3:
						System.out.println("==================================");
						System.out.println("가격을 바꿀 음료번호를 입력하세요");
						System.out.println("현재 음료의 이름");
						for (int i = 0; i < dName.length; i++) {
							System.out.print(i + "번" + dName[i] + " ");
						}
						itemN = scan.nextInt();

						for (int i = 0; i < dName.length; i++) {
							if (i == itemN) {
								System.out.println("이 음료의 현재 재고는?");
								dAmount[i] = scan.nextInt(); // 나중에 재고 더하기,빼기로 바꾸기
							}
						}
						System.out.println("설정이 완료되었습니다.");
						continue;
					case 7:
						System.out.println("==================================");
						System.out.println("현재 남아있는 동전 수입니다.");
						for (int i = 0; i < summoney.length - 1; i++) {
							System.out.println(moneys[i] + "원 " + summoney[i] + "개");
						}
						// 이후 동전 개수 조정 만들어야함
						continue;

					case 8:
						System.out.println("==================================");
						System.out.println("재설정할 음료의 번호를 입력하세요");
						System.out.println("현재 음료의 이름");
						for (int i = 0; i < dName.length; i++) {
							System.out.print(i + "번" + dName[i] + " ");
						}

						itemN = scan.nextInt();

						System.out.println("변경을 시작합니다.");
						for (int i = 0; i < dName.length; i++) {
							if (i == itemN) {
								System.out.println("새로운 음료의 이름은?");
								dName[i] = scan.next();
								System.out.println("새로운 음료의 가격은?");
								dPrice[i] = scan.nextInt();
								System.out.println("새로운 음료의 현재 재고수는?");
								dAmount[i] = scan.nextInt();
							}
						}
						System.out.println("설정이 완료되었습니다.");
						continue;

					case 9:
						System.out.println("관리자 모드 마침.");
						break;

					case 0:
						power = true; // 전원 끄기
						adminS = 9; // 관리자 while문 벗어나기
						break;
					}
				}
			}
		}
		System.out.println("자판기 종료!!");
		scan.close();
	}
}