package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report12 {
	public static void main(String[] args) {
//		1. 음료 자판기를 구현하자.
//		2. 음료 3종류 종류 / 가격 별도 / 재고수
//		3. 시작과 동시에 화면에 메뉴를 보여준다.
//		3-1 음료의 종류와 가격, 재고수, 거스름돈 반환, 돈입력 등
//		99. 자판기 종료.	
//		4. 99이외의 숫자인 경우 화면메뉴 보여주기
		boolean power = false, godmod = true;
//		메뉴입력값, 받은 돈, 음료이름1,2,3 / 가격1,2,3 , 거스름돈
		int insert = 0, payy = 0, coke = 1300, cofe = 1500, cake = 3000, godd = 0, tmp = 0, tmp2 = 0;
//		  첫번째 선택용값  낸 금액                                   	     갓모드용 값                              
		int cokeCount = 13, cofeCount = 15, cakeCount = 30; // 재고수
		int cokeGet = 0, cofeGet = 0, cakeGet = 0; // 얻은 제품 개수

		System.out.println("메뉴: coke:1300 cofe:1500 cake:3000\n");

		while (!power) { // 파워가 true값 가지기 전까지 무한반복
			System.out.println("\n자판기에 입금된 금액: " + payy);
			System.out.print("1: 입금 2: coke구매 3: cofe구매: 4: cake구매 5: 잔금 반환 6: 종료\n");
			System.out.printf("coke %d개 cofe %d개 cake %d개 남았습니다.\n입력:", cokeCount, cofeCount, cakeCount);
			Scanner scan = new Scanner(System.in);
			insert = scan.nextInt();
			switch (insert) {
			case 1:
				System.out.print("\n입금할 금액을 입력하세요: ");
				Scanner scan2 = new Scanner(System.in);
				payy = payy + scan2.nextInt();
				break;
			case 2:
				System.out.println("coke의 재고수: " + cokeCount);
				if (cokeCount < 1) {
					System.out.println("coke의 재고가 부족합니다.");
					break;
				}
				if (payy < coke) {
					System.out.println("금액이 부족합니다.");
					break;
				} else {
					payy -= 1300;
				}
				cokeCount--;
				cokeGet++;
				System.out.println("coke 구매완료.");
				break;
			case 3:
				System.out.println("cofe의 재고수: " + cofeCount);
				if (cofeCount < 1) {
					System.out.println("cofe의 재고가 부족합니다.");
					break;
				}
				if (payy < cofe) {
					System.out.println("금액이 부족합니다.");
					break;
				} else {
					payy -= 1500;
				}
				cofeCount--;
				cofeGet++;
				System.out.println("cofe 구매완료.");
				break;
			case 4:
				System.out.println("cake의 재고수: " + cakeCount);
				if (cakeCount < 1) {
					System.out.println("cake의 재고가 부족합니다.");
					break;
				}
				if (payy < cake) {
					System.out.println("금액이 부족합니다.");
					break;
				} else {
					payy -= 3000;
				}
				cakeCount--;
				cakeGet++;
				System.out.println("cake 구매완료.");
				break;
			case 5:
				System.out.println("금액을 반환합니다." + payy + "원");
				payy = 0;
				break;
			case 6:
				System.out.println("\n자판기 종료");
				power = true;
				break;
			case 77:
				while (godmod) {
					System.out.println("--관리자모드--");
					System.out.print("1. 전체 재고수 확인 2. 재고수 채우기 3. 재고수 빼기 5. 종료\n");
					Scanner scan3 = new Scanner(System.in);
					godd = scan3.nextInt();
					switch (godd) {
					case 1:
						System.out.printf("coke: %d개 cofe %d개 cake %d개\n", cokeCount, cofeCount, cakeCount);
						break;
					case 2:
						System.out.printf("coke %d개 cofe %d개 cake %d개 남았습니다...\n", cokeCount, cofeCount, cakeCount);
						System.out.print("1: coke 재고 넣기 2: cofe 재고 넣기 3: cake 재고 넣기 4: 종료\n");
						Scanner scan4 = new Scanner(System.in);
						tmp = scan4.nextInt();
						switch (tmp) {
						case 1:
							System.out.print("coke를 얼마나 넣는가: ");
							Scanner scan5 = new Scanner(System.in);
							tmp2 = scan5.nextInt();
							cokeCount += tmp2;
							System.out.println("coke의 재고수: " + cokeCount);
							break;
						case 2:
							System.out.print("cofe를 얼마나 넣는가: ");
							Scanner scan6 = new Scanner(System.in);
							tmp2 = scan6.nextInt();
							cofeCount += tmp2;
							System.out.println("cofe의 재고수: " + cofeCount);
							break;
						case 3:
							System.out.print("cake를 얼마나 넣는가: ");
							Scanner scan7 = new Scanner(System.in);
							tmp2 = scan7.nextInt();
							cakeCount += tmp2;
							System.out.println("cake의 재고수: " + cakeCount);
							break;
						case 4:
							break;
						}
						break;
					case 3:
						System.out.printf("coke %d개 cofe %d개 cake %d개 남았습니다...\n", cokeCount, cofeCount, cakeCount);
						System.out.print("1: coke 재고 빼기 2: cofe 재고 빼기 3: cake 재고 빼기 4: 종료\n");
						Scanner scan7 = new Scanner(System.in);
						tmp = scan7.nextInt();
						switch (tmp) {
						case 1:
							System.out.print("coke를 얼마나 빼는가: ");
							Scanner scan5 = new Scanner(System.in);
							tmp2 = scan5.nextInt();
							cokeCount -= tmp2;
							System.out.println("coke의 재고수: " + cokeCount);
							break;
						case 2:
							System.out.print("cofe를 얼마나 빼는가: ");
							Scanner scan6 = new Scanner(System.in);
							tmp2 = scan6.nextInt();
							cofeCount -= tmp2;
							System.out.println("cofe의 재고수: " + cofeCount);
							break;
						case 3:
							System.out.print("cake를 얼마나 빼는가: ");
							Scanner scan8 = new Scanner(System.in);
							tmp2 = scan8.nextInt();
							cakeCount -= tmp2;
							System.out.println("cake의 재고수: " + cakeCount);
							break;
						case 4:
							break;
						}
						break;
					case 5:
						godmod = false;
						break;
					}
				}
				break;
			default:
				System.out.println("잘못된 선택 다시 입력");
				break;
			}
		}
		if (payy > 0) {
			System.out.println("금액이 남아있습니다. 반환된 금액: " + payy + "원");
		}
		System.out.printf("coke %d개 cofe %d개 cake %d개 지급 완료", cokeGet, cofeGet, cakeGet);
	}
}
