package reportt;

import java.util.Scanner;

public class Report12_ {
	public static void main(String[] args) {
//		저장할 배열들 선언
		String[] dName = new String[3];
		int[] dPrice = new int[3];
		int[] dAmount = new int[3];

//		자판기에 필요한 것들 선언
		boolean power = false; // 파워가 true가 되면 while문 탈출
		boolean godd = false; // 관리자모드용
		int payy = 0; // 입금금액
		int gott = 0; // 수익
		int tmp1 = 0, tmp2 = 0, tmp3 = 0, tmp4 = 0;

//		음료 이름
		dName[0] = "콜라";
		dName[1] = "사이다";
		dName[2] = "녹차";

//		음료 가격
		dPrice[0] = 1200;
		dPrice[1] = 1500;
		dPrice[2] = 3000;

//		음료 재고
		dAmount[0] = 5;
		dAmount[1] = 10;
		dAmount[2] = 12;

//		자판기 시작
		System.out.println("자판기 시작");
		while (!power) {
			System.out.println("\n현재 금액: " + payy);
			System.out.print("매뉴: ");
			for (int i = 0; i < dName.length; i++) {
				System.out.print(dName[i] + "(" + dAmount[i] + "개 개당 " + dPrice[i] + "원)" + " ");
			}
			System.out.println();
			System.out.print("1: 돈넣기 /// 2: 구매 /// 3. 잔금반환 /// 4. 종료\n");
			Scanner scan1 = new Scanner(System.in);
			tmp1 = scan1.nextInt();
			switch (tmp1) {
			case 1:
				System.out.print("입금할 금액을 적어주세요: ");
				Scanner scan2 = new Scanner(System.in);
				payy += scan2.nextInt();
				break;
			case 2:
				if (payy < 1) {
					System.out.println("금액이 부족합니다 입금해주세요");
					break;
				}
				System.out.println("무엇을 구매 하시겠습니까?\n" + "1: " + dName[0] + " 2: " + dName[1] + " 3: " + dName[2]);
				Scanner scan3 = new Scanner(System.in);
				tmp2 = scan3.nextInt();
				switch (tmp2) {
				case 1:
				case 2:
				case 3:
					if (payy < dPrice[tmp2 - 1]) {
						System.out.println("금액이 부족합니다.");
						break;
					}
					if (dAmount[tmp2 - 1] < 1) {
						System.out.println("재고가 부족합니다.");
						break;
					}
					payy -= dPrice[tmp2 - 1];
					dAmount[tmp2 - 1]--;
					gott += dPrice[tmp2 - 1];
					System.out.println(dName[tmp2 - 1] + "구매완료");
					break;
				}
				break;
			case 3:
				System.out.println("반환 완료.");
				payy = 0;
				break;
			case 4:
				System.out.println("\n자판기를 종료합니다.");
				power = true;
				break;
			case 77:
				while (!godd) {
					System.out.println("---관리자 모드---");
					System.out.println("1: 재고넣기 /// 2: 재고 빼기 /// 3. 제품 가격 수정 /// 4. 수익보기 /// 5. 종료");
					Scanner scan4 = new Scanner(System.in);
					tmp3 = scan4.nextInt();
					switch (tmp3) {
					case 1:
						System.out.println("현재 " + dName[0] + " " + dAmount[0] + "개");
						System.out.println("현재 " + dName[1] + " " + dAmount[1] + "개");
						System.out.println("현재 " + dName[2] + " " + dAmount[2] + "개");

						System.out.println("어떤 제품의 재고를 넣으시겠습니까?");
						System.out.println("1: " + dName[0] + " 2: " + dName[1] + " 3: " + dName[2]);
						Scanner scan5 = new Scanner(System.in);
						tmp2 = scan5.nextInt();

						System.out.println(dName[tmp2 - 1] + "을 몇개 넣으시나요?");
						Scanner scan6 = new Scanner(System.in);

						tmp1 = scan6.nextInt();
						dAmount[tmp2 - 1] += tmp1;
						System.out.println(dName[tmp2 - 1] + "의 재고수: " + dAmount[tmp2 - 1]);
						break;
					case 2:
						System.out.println("현재 " + dName[0] + " " + dAmount[0] + "개");
						System.out.println("현재 " + dName[1] + " " + dAmount[1] + "개");
						System.out.println("현재 " + dName[2] + " " + dAmount[2] + "개");

						System.out.println("어떤 제품의 재고를 빼시겟습니까?");
						System.out.println("1: " + dName[0] + " 2: " + dName[1] + " 3: " + dName[2]);
						Scanner scan7 = new Scanner(System.in);

						tmp2 = scan7.nextInt();
						System.out.println(dName[tmp2 - 1] + "을 몇개 빼시나요?");

						Scanner scan8 = new Scanner(System.in);
						tmp1 = scan8.nextInt();
						dAmount[tmp2 - 1] -= tmp1;
						System.out.println(dName[tmp2 - 1] + "의 재고수: " + dAmount[tmp2 - 1]);
						break;
					case 3:
						System.out.println("어떤 제품의 가격을 수정하나요?");
						System.out.println("1: " + dName[0] + " 2: " + dName[1] + " 3: " + dName[2]);
						Scanner scan9 = new Scanner(System.in);
						tmp1 = scan9.nextInt();
						System.out.println(dName[tmp1 - 1] + "의 가격을 얼마로 수정하시나요? 현재: " + dPrice[tmp1 - 1] + "원");
						Scanner scan10 = new Scanner(System.in);
						tmp4 = scan10.nextInt();
						dPrice[tmp1 - 1] = tmp4;
						System.out.println(dName[tmp1 - 1] + "의 가격은 " + dPrice[tmp1 - 1] + "원으로 수정하였습니다.");
						break;
					case 4:
						System.out.println("수익: " + gott);
						break;
					case 5:
						System.out.println("관리자 모드 종료");
						godd = true;
						break;
					default:
						System.out.println("다시 입력해 주세요");
						break;
					}
				}
			default:
				System.out.println("다시 입력해 주세요");
				break;
			}
		}
	}
}
