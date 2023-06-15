/*
 * 두수를 서로 교환하여 출력하기
 * 즉 num1 = 10, num2 = 20 이 있다면
 * num1 = 20, num2 = 10이 대입되게 한다.
 */
package kr.co.dong;

public class Test03 {

	public static void main(String[] args) {
//		1. 선언 및 초기화
		int num1 = 0, num2 = 0;
		int tmp = 0;
		
//		2. 입력
		num1 = 10;
		num2 = 20;
		System.out.println("======변경 전 =======");
		System.out.println(num1);
		System.out.println(num2);

//		3. 처리
		tmp = num1;
		num1 = num2;
		num2 = tmp;
		
//		4. 출력
		System.out.println("======변경 후 =======");
		System.out.println(num1);
		System.out.println(num2);


	}

}
