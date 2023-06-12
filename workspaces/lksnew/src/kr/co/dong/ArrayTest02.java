package kr.co.dong;

import java.util.Scanner;

public class ArrayTest02 {
	public static void main(String[] args) {
//		01번의 데이터를 console로 입력받아서 출력한다.

//		1.선언
		String[] dName = null;
		Scanner scan = null;
		int size = 4; //크기
		
//		1-1.생성
		dName = new String[size];
		scan = new Scanner(System.in);
		
//		2. 입력
		for (int i = 0; i < dName.length; i++) {
			System.out.println("dName[" + i + "]에 들어갈 음료를 입력 > : ");
			dName[i] = scan.nextLine();
		}

//		3. 처리
		
//		4. 출력
		for (int i = 0; i < dName.length; i++) {
			System.out.println("dName[" + i + "] = " + dName[i]);
		}

	}
}
