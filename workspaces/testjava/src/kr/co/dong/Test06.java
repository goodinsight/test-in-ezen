package kr.co.dong;

import java.util.Scanner;

public class Test06 {
	public static void main(String[] args) {
//		두 정수 A와 B가 주어졌을 때, A와 B를 비교하는 프로그램을 작성하시오.
//		첫째 줄에 A와 B가 주어진다.
//		A와 B는 공백 한 칸으로 구분되어져 있다.
//		ex) 입력 : 10 20
//			int a = scan.nextInt();
//			int b = scan.nextInt();
//		첫째 줄에 다음 세 가지 중 하나를 출력한다.
//		A가 B보다 큰 경우에는 '>'를 출력한다.
//		A가 B보다 작은 경우에는 '<'를 출력한다.
//		A가 B가 같은 경우에는 '=='를 출력한다.
		
		Scanner scan = new Scanner(System.in);
		int A = scan.nextInt();
		int B = scan.nextInt();
		
		if(A > B) {
			System.out.println(">");
		}else if(A < B) {
			System.out.println("<");			
		}else {
			System.out.println("==");
		}		
	}
}
