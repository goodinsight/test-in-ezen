package func;

import java.util.Scanner;

public class FuncTest04 {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
//		메뉴 1> 두수의 합 구하기 2> 구구단 구하기 3> 두 수 범위의 합 구하기
//		각 메서드로 구현하기

		boolean done = false;
		int sel = 0;
		int a1 = 0, b1 = 0, gugugot = 0;

		while (!done) {
			sel = menuView();
			switch (sel) {
			case 99:
				System.out.println("종료합니다");
				done = true;
				break;
			case 1:
				duHap(a1, b1);
				break;
			case 2:
				gugu(gugugot); // 구구단 출력
				break;
			case 3:
				rangeHap(a1, b1); // 두 수 범위의 합을 출력
				break;
			default:
				System.out.println("다시 입력해 주세요");
				break;
			}
		}
	}

	static int menuView() {
		// TODO Auto-generated method stub
		System.out.println("1: 두수의 합 구하기 /// 2: 구구단 구하기 /// 3: 두 수 범위의 합 구하기 /// 99: 종료");
		return scan.nextInt();
	}

	static void duHap(int a, int b) {
		// TODO Auto-generated method stub
		System.out.println("\n두수의 합 구하기");
		System.out.print("첫번째 숫자를 입력해 주세요: ");
		int a1 = scan.nextInt();
		System.out.print("두번째 숫자를 입력해 주세요: ");
		int b1 = scan.nextInt();
		System.out.println(a1+b1);
	}

	static void gugu(int a) {
		System.out.println("\n구구단에서 몇번째 단을 구하시나요?: ");
		int gugugot = scan.nextInt();
		for (int i = 1; i <= 9; i++) {
			System.out.println(gugugot + " x " + i + " = " + gugugot * i);
		}
	}

	static void rangeHap(int a, int b) {
		System.out.println("\n두 수 범위의 합을 구하기");
		System.out.print("첫번째 숫자를 입력해 주세요: ");
		a = scan.nextInt();
		System.out.print("두번째 숫자를 입력해 주세요: ");
		b = scan.nextInt();
		int allHap = 0;
		if (a < b) {
			for (int i = a + 1; i < b; i++) {
				allHap += i;
			}
			System.out.println(allHap);
		} else {
			for (int i = b + 1; i < a; i++) {
				allHap += i;
			}
			System.out.println(allHap);
		}
	}
}
