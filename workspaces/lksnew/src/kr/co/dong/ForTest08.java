package kr.co.dong;

public class ForTest08 {
	public static void main(String[] args) {
//		1부터 100까지 3의 배수를 출력한다
//		3의 배수의 합을 구한다
//		총 몇개였는지 구하여 출력한다
		
		int num = 100;
		int sum = 0;
		int count = 0;
		
		System.out.print("1부터 100까지 3의 배수 : ");
		for (int i = 1; i<=100; i++) {
			if(i % 3 == 0) {
				System.out.print(i + " ");
				sum += i;
				count++;
			}
		}
		System.out.println();
		System.out.println("3의 배수의 합 : " + sum);
		System.out.println("3의 배수의 갯수 : " + count);
	}
}
