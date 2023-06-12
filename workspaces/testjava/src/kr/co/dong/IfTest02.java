package kr.co.dong;

import java.util.Scanner;

public class IfTest02 {

	public static void main(String[] args) {
//		나이를 입력받아서 20세미만 -> "청소년"
//		20세~60세 미만 -> "중년"
//		60세 이상 -> "노년" 이 되게 표시하세요.
		Scanner scan = new Scanner(System.in);
		int age = 0;
		System.out.print("나이를 입력하세요 : ");
		age = scan.nextInt();
		String result = null; // 결과값 저장
		if (age < 20) {
			result = "청소년";
		} else if (age >= 60) {
			result = "노년";
		} else {
			result = "중년";
		}
		System.out.println("당신의 나이는 " + age + "세이고, " + result + "입니다.");
	}
}
