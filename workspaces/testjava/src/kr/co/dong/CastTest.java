package kr.co.dong;

public class CastTest {

	public static void main(String[] args) {
//		����ȯ�� ���Ͽ�
		int num1 = 4, num2 = 3;
		int result = 0;
		float f = 0.0f;
		double d = 0.0;
		long lo = 0L;
		
//		���� �ٸ� ������ ��� : ūŸ������ �����
		result = num1 / num2;
		
		System.out.println(result);
		
		f = (float)num1 / (float)num2;
//		f = num1 / (float)num2;
//		f = (float)num1 / num2;
		System.out.println(f);
		
//		���ڿ� "123" -> ������ 123
		String str = "123";
		int castNum = 0;
		
		castNum = Integer.parseInt(str);
		System.out.println(castNum);
		
//		type mismatch from String to int;
		
	}

}
