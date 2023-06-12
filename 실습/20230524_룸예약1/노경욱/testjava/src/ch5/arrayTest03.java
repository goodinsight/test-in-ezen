package ch5;

public class arrayTest03 {
	public static void main(String[] args) {
//		10개의 랜덤수(1~100) 사이의 값을 입력 받아서
//		입력된 배열의 값을 출력하고 그 배열의 합을 구해보자.
//		int [] num = null;
//		int [] num = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		int[] num = new int[10]; // 선언 및 생성
		int hap = 0;

//		배열 초기화 init : 7Line
		for (int i = 0; i < num.length; i++) {
			num[i] = 0;
		}

//		배열의 랜덤값 입력
		for (int i = 0; i < num.length; i++) {
			num[i] = (int) (Math.random() * 100) + 1;
		}
//		입력값 출력
		for (int i = 0; i < num.length; i++) {
			System.out.print("num[" + i + "]=" + num[i] + " ");
		}

//		배열의 요소(element)에 대한 합 구하기
		for (int i = 0; i < num.length; i++) {
			hap += num[i];
		}

//		합 출력
		System.out.println("\nnum배열의 합은: " + hap);

//		for문2 -> 향상된 for문 : 값에 의한 출력
		for (int n : num) {
			System.out.println(n);
		}
//		평균구하기
		float avg = (float)hap / num.length;
		System.out.println("평균: " + avg);
	}
}
