package Package.io;

import java.util.Scanner;

//문자열 입력받아서 출력
//두수의 합, 차, 배, 나눔

public class MethodTest {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

//		선언
		cal cal = null;
		boolean done = true;

//		초기화면
		while (done) {
			System.out.println("대항 계산기의  기능을 연습하자");
			System.out.println("1. 합 2. 차 . 3 곱 4. 나누기");
			System.out.print("당신의 선택: ");
			int sel = scan.nextInt();
			int n1 = 0, n2 = 0, r = 0;
			switch (sel) {
			case 1:
				System.out.println("first Number: ");
				n1 = scan.nextInt();
				System.out.println("second Number: ");
				n2 = scan.nextInt();
				cal = new cal();
				r = cal.sum(n1, n2);
				System.out.println("결과값: " + r);
				break;
			case 2:
				System.out.println("first Number: ");
				n1 = scan.nextInt();
				System.out.println("second Number: ");
				n2 = scan.nextInt();
				cal = new cal();
				r = cal.minus(n1, n2);
				System.out.println("결과값: " + r);
				break;
			case 3:
				break;
			case 4:
				break;
			default:
				break;
			}
		}
	}
}
