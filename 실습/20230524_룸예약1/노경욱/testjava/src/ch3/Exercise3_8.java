package ch3;

public class Exercise3_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte a = 10;
		byte b = 20;
		byte c = (byte) (a + b);
		
		char ch = 'A';
		ch = (char)(ch + 2);
		
		float f2 = 3 / 2f;
		long L = 3000 * 3000 * 3000L;
		
//		float f2 = 0.1f;
		double d = 0.1;
		
		boolean result = (float) d==f2;
		
		System.out.println("c="+c);
		System.out.println("ch="+ch);
		System.out.println("f="+0.1f);
		System.out.println("L="+L);
		System.out.println("result="+result);
	}

}
