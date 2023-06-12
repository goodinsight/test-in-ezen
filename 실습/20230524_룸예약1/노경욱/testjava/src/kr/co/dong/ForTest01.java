/*
 * 작성자: 노경욱
 * 값: Value
 * 참조: Reference
 */

package kr.co.dong;

public class ForTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		1부터 10까지의 출력
		for (int i = 1; i <= 10; i++) {
			System.out.println("i=" + i);
		}

//		1부터 100까지의 3의 배수를 출력하기
		int stack = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0) {
				System.out.print(i);
				stack++;
				if (stack == 4) {
//				if(i % 12 == 0){ 12배수일때 줄바꿈을 사용
					System.out.print("\n");
					stack = 0;
				} else {
					System.out.print(",");
				}

			}
		}
	}

}
