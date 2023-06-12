package kr.co.dong.func;

import java.util.Scanner;

public class FunTest04 {

	static Scanner scan = new Scanner(System.in);
	static boolean power = false;
	static boolean done = false;
	static String[] menu = { "재미있는 숫자 놀이~~~", "두수의 합 구하기", "구구단 구하기", "두 수 범위의 합 구하기", "            종료를 원하면" };
	static String[] googooDanMenu = { "구구단을 구해보아용~~~", "모든 구구단 보기", "원하는 단만 보기", "원하는 범위의 단을 보기", "이전 메뉴로 이동을 원하면" };

	public static void main(String[] args) {
//		메뉴 1> 두수의합구하기 2> 구구단 구하기 3> 두 수 범위의 합구하기
//		각 메서드로 구현하기
		while (!power) {
			showMenu(menu);
			int tmp = inputNumber();
			mainMenu(tmp);
		}
		System.out.println("프로그램을 종료합니다.");
	}

	private static void mainMenu(int tmp) {
		// 메뉴 선택시 하나로 이동
		switch (tmp) {
		case 1:
			System.out.println("두 수를 입력하시면 합을 구하실 수 있습니다.");
			int a = getNumber();
			int b = getNumber();
			dusooSum(a, b);
			break;
		case 2:
			while (!done) {
				showMenu(googooDanMenu);
				int tmp1 = inputNumber();
				googoodanMenu(tmp1);
			}
			break;
		case 3:
			System.out.println("두 수를 입력하시면 두수 사이의 모든 수의 합을 보실 수 있습니다.");
			int d = getNumber();
			int e = getNumber();
			rangeSum(d, e);
			break;
		case 99:
			power = true;
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
			break;
		}
	}

	private static void googoodanMenu(int tmp) {
		// TODO Auto-generated method stub
		switch (tmp) {
		case 1:
			googooDan();
			break;
		case 2:
			System.out.println("보고 싶은 구구단 단을 보실 수 있습니다.");
			int a = getNumber();
			googooDan(a);
			break;
		case 3:
			System.out.println("두 수를 입력하시면 두단 사이 모은 구구단을 보실 수 있습니다.");
			int b = getNumber();
			int c = getNumber();
			googooDan(b, c);
			break;
		case 99:
			done = true;
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
			break;
		}
	}

	private static int getNumber() {
		// 입력 숫자 받기
		System.out.println("원하시는 정수를 입력하세요:");
		int num = scan.nextInt();
		return num;
	}

	private static int inputNumber() {
		// 메뉴 번호 누르기
		int tmp = scan.nextInt();
		return tmp;
	}

	private static void showMenu(String[] menu) {
		// 메뉴 고르는 화면
		System.out.println("======================================");
		System.out.println();
		System.out.println(menu[0]);
		System.out.println();
		System.out.println("1. " + menu[1]);
		System.out.println("2. " + menu[2]);
		System.out.println("3. " + menu[3]);
		System.out.println();
		System.out.println("======================================");
		System.out.println();
		System.out.println("메뉴를 고르세요~(1~3)");
		System.out.println("            " + menu[4] + " 99 입력");
	}

	private static void rangeSum(int a, int b) {
		// 두수 사이의 정수들의 합을 구하고 출력.
		int sum = 0;
		for (int i = a; i <= b; i++) {
			sum += i;
		}
		System.out.println(a + "(" + a + "포함)부터 " + b + "(" + b + "포함)사이에 있는 정수들을 모두 더하면 " + sum + "이다.");
	}

	private static void googooDan() {
		// 구구단을 출력
		System.out.println("구구단을 출력해 보자");
		for (int i = 2; i <= 6; i += 4) {
			for (int k = 0; k < 4; k++) {
				System.out.printf("=====" + (i + k) + "단=====");
				if (k != 3)
					System.out.print("\t");
				else
					System.out.print("\n");
			}
			for (int j = 1; j <= 9; j++) {
				for (int k = 0; k < 4; k++) {
					System.out.printf("%2d X%2d =%3d", i + k, j, (i + k) * j);
					if (k != 3)
						System.out.print("\t");
					else
						System.out.print("\n");
				}
			}
			System.out.println();
		}
	}

	private static void googooDan(int n) {
		// 구구단 n단을 출력하라
		System.out.println("구구단 " + n + "단을 출력해 보자");
		System.out.printf("=====" + n + "단=====%n");
		for (int j = 1; j <= 9; j++) {
			System.out.printf("%2d X%2d =%3d%n", n, j, n * j);
		}
	}

	private static void googooDan(int a, int b) {
		// 구구단 a단부터 b단까지 출력하라
		System.out.println("구구단 " + a + "단에서 " + b + "단을 출력해 보자");
		for (int i = a; i <= b; i++)
			System.out.printf("=====" + i + "단=====\t");
		System.out.println();
		for (int j = 1; j <= 9; j++) {
			for (int i = a; i <= b; i++)
				System.out.printf("%2d X%2d =%3d\t", i, j, i * j);
			System.out.println();
		}
	}

	private static void dusooSum(int a, int b) {
		// 두 수를 변수로 받아서 합을 프린트
		System.out.println("두 수 " + a + "와 " + b + "의 합 :" + (a + b));
	}
}
