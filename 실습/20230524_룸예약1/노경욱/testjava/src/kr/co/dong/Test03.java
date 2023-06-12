/* 
 * 두수를 서로 교환하여 출력하기
   즉 num1 = 10, num2=20 이 있다면
   num1 = 20, num2= 10이 대입되게 한다.  
*/
package kr.co.dong;

public class Test03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		1. 선언 및 초기화
		int num1 = 0, num2 = 0, temp = 0;
		char ch = 'x';
		
//		2.입력
		num1 = 10;
		num2 = 20;
		
		System.out.println("==변경전==");
		System.out.println(num1);
		System.out.println(num2);
		
//		3. 처리
		temp = num1;
		num1 = num2;
		num2 = temp;
		
//		4. 출력
		System.out.println("==변경후==");
		System.out.println(num1);
		System.out.println(num2);
		
	}

}
