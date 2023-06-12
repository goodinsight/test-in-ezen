package kr.co.dong;

import java.util.Scanner;

public class PrintfEx1 {

	public static void main(String[] args) {
		byte b = 1;
		short s = 2;
		char c = 'A';
		
		int finger = 10;
		long big = 100_000_000_000L;
		long hex = 0xFFFF_FFFF_FFFF_FFFFL;
		
		int octNum = 010;
		int hexNum = 0x10;
		int binNum = 0b10;
		
		System.out.printf("b=%d%n", b);
		System.out.printf("s=%d%n", s);
		System.out.printf("c=%c, %d %n", c, (int)c);
		System.out.printf("finger=[%5d]%n", finger);
		System.out.printf("finger=[%-5d]%n", finger);
		System.out.printf("finger=[%05d]%n", finger);
		System.out.printf("big=%d%n", big);
		System.out.printf("hex=%#x%n", hex);
		System.out.printf("octNum=%o, %d%n", octNum, octNum);
		System.out.printf("hexNum=%x, %d%n", hexNum, hexNum);
		System.out.printf("binNum=%s, %d%n", Integer.toBinaryString(binNum), binNum);
		
		String url = "www.codechobo.com";
		float f1 = .10f;
		float f2 = 1e1f;
		float f3 = 3.14e3f;
		double d = 1.23456789;
		System.out.printf("f1=%f, %e, %g%n", f1, f1, f1);
		System.out.printf("f2=%f, %e, %g%n", f2, f2, f2);
		System.out.printf("f3=%f, %e, %g%n", f3, f3, f3);
		System.out.printf("d=%f%n", d);
		System.out.printf("d=%14.10f%n", d);
		System.out.printf("[12345678901234567890]%n");
		System.out.printf("[%s]%n", url);
		System.out.printf("[%20s]%n", url);
		System.out.printf("[%-20s]%n", url);
		System.out.printf("[%.8s]%n", url);
		/*
		Scanner scanner = new Scanner(System.in);
		System.out.print("두자리 정수를 하나 입력해 주세요.>");
		String input = scanner.nextLine();
		int num = Integer.parseInt(input);
		System.out.println("입력내용 :"+input);
		System.out.printf("num=%d%n", num);
		*/
		System.out.println('\'');
		System.out.println("abc\t123\b456");
		System.out.println("\n");
		System.out.println("\"Hello\"");
		System.out.println("c:\\");
		System.out.println("\u0041");
		
		float f = 9.1234567f;
		int i = Float.floatToIntBits(f);
		
		System.out.printf("%f%n", f);
		System.out.printf("%X%n", i);
		
		int a = 300;
		byte b1 = (byte) a;
		System.out.println(b1);
		
		byte b2 = -2;
		int a1 = (int) b2;
		System.out.println(Integer.toBinaryString(a1));
		
		double d1 = 1.0e100;
		float f10 = (float)d1;
		System.out.println(f10);
		System.out.println(Float.toString(f10));
		System.out.println(Double.MAX_VALUE);
		System.out.println(Double.MIN_VALUE);
		System.out.println(Double.toHexString(Double.MAX_VALUE));
		
	}

}
