package reportt;

import java.util.Scanner;

public class Report12 {
	public static void main(String[] args) {
//		1. 음료 자판기를 구현하자.
//		2. 음료 3종류 종류 / 가격 별도 / 재고수
//		3. 시작과 동시에 화면에 메뉴를 보여준다.
//		3-1 음료의 종류와 가격, 재고수, 거스름돈 반환, 돈입력 등
//		99. 자판기 종료.	
//		4. 99이외의 숫자인 경우 화면메뉴 보여주기
//		!!!갓모드 수익이랑 가격변경모드 추가하기
		boolean power = false, godmod = true;
//		메뉴입력값, 받은 돈, 음료이름1,2,3 / 가격1,2,3 , 거스름돈
		int insert = 0, payy = 0, coke = 1300, cofe = 1500, cake = 3000, godd = 0, gott = 0, tmp = 0, tmp2 = 0;
//		  첫번째 선택용값  낸 금액                                   	     갓모드용값   수익
		int cokeCount = 13, cofeCount = 15, cakeCount = 30; // 재고수
		int cokeGet = 0, cofeGet = 0, cakeGet = 0; // 얻은 제품 개수

		while (!power) { // 파워가 true값 가지기 전까지 무한반복
			System.out.printf("메뉴: coke:%d cofe:%d cake:%d\n", coke, cofe, cake);
			System.out.println("\n자판기에 입금된 금액: " + payy);
			System.out.print("1: 입금 /// 2: coke구매 /// 3: cofe구매: /// 4: cake구매 /// 5: 잔금 반환 /// 6: 종료\n");
			System.out.printf("현재 coke %d개 cofe %d개 cake %d개 남았습니다.\n입력:", cokeCount, cofeCount, cakeCount);
			Scanner scan = new Scanner(System.in);
			insert = scan.nextInt();
			switch (insert) {
			case 1:
				System.out.print("\n입금할 금액을 입력하세요: ");
				Scanner scan2 = new Scanner(System.in);
				payy = payy + scan2.nextInt();
				break;
			case 2:
				if (cokeCount < 1) {
					System.out.println("coke의 재고가 부족합니다.");
					break;
				}
				if (payy < coke) {
					System.out.println("금액이 부족합니다.");
					break;
				}
				payy -= coke;
				gott += coke;
				cokeCount--;
				cokeGet++;
				System.out.println("coke 구매완료.");
				break;
			case 3:
				if (cofeCount < 1) {
					System.out.println("cofe의 재고가 부족합니다.");
					break;
				}
				if (payy < cofe) {
					System.out.println("금액이 부족합니다.");
					break;
				}
				payy -= cofe;
				gott += cofe;
				cofeCount--;
				cofeGet++;
				System.out.println("cofe 구매완료.");
				break;
			case 4:
				if (cakeCount < 1) {
					System.out.println("cake의 재고가 부족합니다.");
					break;
				}
				if (payy < cake) {
					System.out.println("금액이 부족합니다.");
					break;
				}
				payy -= cake;
				gott += cake;
				cakeCount--;
				cakeGet++;
				System.out.println("cake 구매완료.");
				break;
			case 5:
				System.out.println("금액을 반환합니다. " + payy + "원");
				payy = 0;
				break;
			case 6:
				System.out.println("\n자판기 종료");
				power = true;
				break;
			case 77:
				while (godmod) {
					System.out.println("--관리자모드--");
					System.out.print("1. 전체 재고수 확인 /// 2. 재고수 채우기 /// 3. 재고수 빼기 /// 4. 수익보기 /// 5. 제품가격수정 /// 6. 종료\n");
					Scanner scan3 = new Scanner(System.in);
					godd = scan3.nextInt();
					switch (godd) {
					case 1:
						System.out.printf("coke: %d개 cofe %d개 cake %d개\n", cokeCount, cofeCount, cakeCount);
						break;
					case 2:
						System.out.printf("coke %d개 cofe %d개 cake %d개 남았습니다...\n", cokeCount, cofeCount, cakeCount);
						System.out.print("1: coke 재고 넣기 /// 2: cofe 재고 넣기 /// 3: cake 재고 넣기 /// 4: 재고넣기종료\n");
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
						System.out.print("1: coke 재고 빼기 /// 2: cofe 재고 빼기 /// 3: cake 재고 빼기 /// 4: 재고빼기종료\n");
						Scanner scan7 = new Scanner(System.in);
						tmp = scan7.nextInt();
						switch (tmp) {
						case 1:
							if (cokeCount < 1) {
								System.out.println("coke의 재고가 없습니다 빼기불가능");
							} else {
								System.out.print("coke를 얼마나 빼는가: ");
								Scanner scan5 = new Scanner(System.in);
								tmp2 = scan5.nextInt();
								cokeCount -= tmp2;
							}
							System.out.println("coke의 재고수: " + cokeCount);
							break;
						case 2:
							if (cofeCount < 1) {
								System.out.println("cofe의 재고가 없습니다 빼기불가능");
							} else {
								System.out.print("cofe를 얼마나 빼는가: ");
								Scanner scan6 = new Scanner(System.in);
								tmp2 = scan6.nextInt();
								cofeCount -= tmp2;
							}
							System.out.println("cofe의 재고수: " + cofeCount);
							break;
						case 3:
							if (cakeCount < 1) {
								System.out.println("cake의 재고가 없습니다 빼기불가능");
							} else {
								System.out.print("cake를 얼마나 빼는가: ");
								Scanner scan8 = new Scanner(System.in);
								tmp2 = scan8.nextInt();
								cakeCount -= tmp2;
							}
							System.out.println("cake의 재고수: " + cakeCount);
							break;
						case 4:
							break;
						}
						break;
					case 4:
						System.out.printf("coke: %d개 cofe: %d개 cake %d개 판매완료\n", cokeGet, cofeGet, cakeGet);
						System.out.println("수익: " + gott);
						break;
					case 5:
						System.out.printf("--현제 제품들의 가격--\ncoke: %d cofe: %d cake %d\n", coke, cofe, cake);
						System.out.println("어떤 제품의 가격을 수정하시겠습니까?");
						System.out.print("1: coke /// 2: cofe /// 3: cake /// 4: 가격수정종료\n");
						Scanner scan9 = new Scanner(System.in);
						tmp = scan9.nextInt();
						switch (tmp) {
						case 1:
							System.out.println("coke 의 현재 가격: " + coke);
							System.out.print("수정할 가격 입력: ");
							Scanner scan10 = new Scanner(System.in);
							coke = scan10.nextInt();
							System.out.println("\n수정완료 coke의 현재 가격은: " + coke);
							System.out.printf("--현제 제품들의 가격--\ncoke: %d cofe: %d cake %d\n", coke, cofe, cake);
							break;
						case 2:
							System.out.println("cofe 의 현재 가격: " + cofe);
							System.out.print("수정할 가격 입력: ");
							Scanner scan11 = new Scanner(System.in);
							cofe = scan11.nextInt();
							System.out.println("\n수정완료 cofe의 현재 가격은: " + cofe);
							System.out.printf("--현제 제품들의 가격--\ncoke: %d cofe: %d cake %d\n", coke, cofe, cake);
							break;
						case 3:
							System.out.println("cake 의 현재 가격: " + cake);
							System.out.print("수정할 가격 입력: ");
							Scanner scan12 = new Scanner(System.in);
							cake = scan12.nextInt();
							System.out.println("\n수정완료 cake의 현재 가격은: " + cake);
							System.out.printf("--현제 제품들의 가격--\ncoke: %d cofe: %d cake %d\n", coke, cofe, cake);
							break;
						}
						break;

					case 6:
						System.out.println("관리자모드 종료\n");
						godmod = false;
						break;
					default:
						System.out.println("잘못된 선택 다시 입력");
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
