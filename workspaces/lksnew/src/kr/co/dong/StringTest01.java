package kr.co.dong;

public class StringTest01 {
	public static void main(String[] args) {
		String str = "Do not Slipping!!";
		String str1 = "Do no Spping";
		
		System.out.println(str.compareTo(str1));
		
		System.out.println(str.charAt(0));
		char ch = str.charAt(0);
		int len = str.length();
		
		System.out.println("���ڿ��� ���� : " + len);
		
		for (int i = 0; i < len; i++) {
			System.out.print(str.charAt(i));
		}
		
		System.out.println();
		
		StringBuffer sb = new StringBuffer("hello");
		String s = new String(sb);
		System.out.println(s);
		
		String s1 = "Hello";
		String n1 = "0123456";
		char c1 = s1.charAt(1);
		char c2 = n1.charAt(1);
		System.out.println(c1);
		System.out.println(c2);
		
		int i1 = "aaa".compareTo("aaa");
		int i2 = "aaa".compareTo("bbb");
		int i3 = "bbb".compareTo("bbb");
		
		System.out.println(i1);
		System.out.println(i2);
		System.out.println(i3);
		
		System.out.println("String s1�� " + s1 + "�Դϴ�");
		
		String s2 = s1.concat(" World");
		System.out.printf("���ڿ� s1�� \"World\"�� ��ġ�� " + s2 +"�Դϴ�.");
		System.out.println();
		
		boolean c = s2.contains("el");
		System.out.printf("���ڿ� s2�ȿ� \"el\"�� �ֳ���? " + c);
		System.out.println();
		
		String file = "Hello.txt";
		boolean d = file.endsWith("txt");
		System.out.println(file + "�ȿ� \"txt\"�� �����°�? " + d);
		System.out.println();
		
		boolean f1 = s1.equals("Hello");
		boolean f2 = s1.equals("hello");
		
		System.out.println(""+f1+" "+f2);
		
		boolean f3 = s1.equalsIgnoreCase("Hello");
		boolean f4 = s1.equalsIgnoreCase("hello");
		
		System.out.println(""+f3+" "+f4);
		
		System.out.println(s1.indexOf('o'));
		System.out.println(s1.indexOf('k'));
		
		System.out.println(s1.indexOf('l', 0));
		System.out.println(s1.indexOf('e', 2));
	
		System.out.println(s1.indexOf("lo"));
		
		String ss = new String("abc");
		String ss2 = new String("abc");
		boolean bb = (ss==ss2);
		boolean bb2 = ss.equals(ss2);
		boolean bb3 = (ss.intern() == ss2.intern());
		System.out.println(bb);
		System.out.println(bb2);
		System.out.println(bb3);
		
		String sss = new String("jasadfsafsadfsava.ladng.sdagagsaegsObject");
		int idx1 = sss.lastIndexOf('.');
		int idx2 = sss.indexOf('.');
		
		System.out.printf("%d , %d", idx1, idx2);
		System.out.println();
		
		s = "java.lang.java";
		idx1 = s.lastIndexOf("java");
		idx2 = s.indexOf("java");
		System.out.printf("%d , %d", idx1, idx2);
		System.out.println();
		
		s = "Hello";
		int length = s.length();
		System.out.println(length);
		
		
		String s1s = s.replace('H', 'C');
		System.out.println(s1s);
		s = "Hellollo";
		String s2s = s.replace("ll", "LL");
		System.out.println(s2s);
		
		String ab = "AABBAABB";
		String r = ab.replaceFirst("BB", "bb");
		
		
	}
}
