/* 
 * �μ��� ���� ��ȯ�Ͽ� ����ϱ�
   �� num1 = 10, num2=20 �� �ִٸ�
   num1 = 20, num2= 10�� ���Եǰ� �Ѵ�.  
*/
package kr.co.dong;

public class Test03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		1. ���� �� �ʱ�ȭ
		int num1 = 0, num2 = 0, temp = 0;
		char ch = 'x';
		
//		2.�Է�
		num1 = 10;
		num2 = 20;
		
		System.out.println("==������==");
		System.out.println(num1);
		System.out.println(num2);
		
//		3. ó��
		temp = num1;
		num1 = num2;
		num2 = temp;
		
//		4. ���
		System.out.println("==������==");
		System.out.println(num1);
		System.out.println(num2);
		
	}

}
