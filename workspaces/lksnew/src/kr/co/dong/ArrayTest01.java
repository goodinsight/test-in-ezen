package kr.co.dong;

public class ArrayTest01 {
	public static void main(String[] args) {
//		배열 : 같은 타입의 종류를 모아놓기
//		선언 및 생성
		String[] dName = new String[4];
//		배열 값 입력
		dName[0] = "콜라";
		dName[1] = "사이다";
		dName[2] = "커피";
		dName[3] = "생강차";
//		배열 값 출력
		System.out.printf("dName[0] = %s%n", dName[0]);
		System.out.printf("dName[1] = %s%n", dName[1]);
		System.out.printf("dName[2] = %s%n", dName[2]);
		System.out.printf("dName[3] = %s%n", dName[3]);

//		배열 값 for문으로 출력
		for (int i = 0; i < 4; i++) {
			System.out.printf("dName[" + i + "] = %s%n", dName[i]);
		}
		
		for (int i = 0; i < dName.length; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.printf("dName[" + i + "] = %s%n", dName[i]);
		}
	}
}
