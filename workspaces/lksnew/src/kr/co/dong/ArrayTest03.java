package kr.co.dong;

public class ArrayTest03 {
	public static void main(String[] args) {
//		10개의 랜덤수(1~100) 사이의 값을 입력받아서
//		입력된 배열의 값을 출력하고 그 배열의 합을 구해보자.
		
		int[] num = null;
		int sum = 0;
		int size = 10;
		
		num = new int[size];
		for (int i = 0; i < num.length; i++) {
			num[i] = (int)(Math.random()*100 + 1);
			sum += num[i];
		}
		System.out.println("입력된 랜덤수 배열은");
		for (int i : num) {
			System.out.print(num[i]);
			if (i != num.length-1) {
				System.out.print(", ");
			}
		}
		System.out.println();
		System.out.println("랜덤수 배열의 합은 " + sum + "입니다.");
		
		
	}
}
