package kr.co.dong;

public class ForTest08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		1부텅 100 까지 3의 배수 출력, 3의배수의 합, 3의배수의 개수출력
		int hap = 0;
		int baesu = 0;

		System.out.print("1부터 100까지 3의 배수: ");

		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0) {
				System.out.print(i + " ");
				hap = hap + i;
				baesu++;
			}
		}
		System.out.println("\n1부터 100까지 3의 배수들의 합: " + hap);
		System.out.println("1부터 100까지 3의 배수의 개수: " + baesu);

	}

}
