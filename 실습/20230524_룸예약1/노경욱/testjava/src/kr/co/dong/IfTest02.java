package kr.co.dong;

import java.util.Scanner;

public class IfTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		나이를 입력받아서 20세 미만-> "청소년", 20세 이상~60세 미만-> "중년", 60세 이상이면 -> "노년"이 되게 표시
		
		int age = 0;
		Scanner scan = new Scanner(System.in);
		String result = null;
		
		System.out.printf("나이를 입력하시오: ");
		age = scan.nextInt();
		
		if(age < 20) {
//			System.out.println("청소년입니다.");
			result = "청소년";
		}else if(age > 19 && age < 60){
//			System.out.println("중년입니다.");
			result = "중년";
		}
		else {
//			System.out.println("노년입니다");
			result = "노년";
		}
//		"당신의 나이는 ??세이고, 000입니다."
		System.out.println("당신의 나이는 "+ age + "세이고, " + result + " 입니다.");
	}

}
