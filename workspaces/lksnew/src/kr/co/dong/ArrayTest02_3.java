package kr.co.dong;

import java.util.Scanner;

public class ArrayTest02_3 {
	public static void main(String[] args) {
		
//		5명의 사람의 이름과 취미 그리고 혈액형 입력하기
		
		String[] name = null;
		String[] hobby = null;
		String[] bloodtype = null;
		Scanner scan = null;
		int num = 1; // 크기
		
		name = new String[num];
		hobby = new String[num];
		bloodtype = new String[num];
		scan = new Scanner(System.in);
		
		for (int i = 0; i < num; i++) {
			System.out.println(i+1 + "번째 사람의 이름을 입력 :");
			name[i] = scan.nextLine();
			System.out.println(i+1 + "번째 사람의 취미를 입력 :");
			hobby[i] = scan.nextLine();
			System.out.println(i+1 + "번째 사람의 혈액형을 입력 :");
			bloodtype[i] = scan.nextLine();
			
		}
		
		for (int i = 0; i < num; i++) {
			System.out.printf(i+1+"번째 사람은 이름:%s, 취미:%s, 혈액형:%s 입니다.%n", name[i], hobby[i], bloodtype[i]);
		}

	}
}
