package com.javalec.ex;

public class TestEx {

	public static void main(String[] args) {

//		char c = 'C';
		int i = 10;
		double d = 3.140;
		
		i = (int) d;
		
//		boolean b = true;
//		System.out.println(c);
		System.out.println(i);
		System.out.println(d);
//		System.out.println(b);

		System.out.println("|\\_/|");
        System.out.println("|q p|   /}");
        System.out.println("( 0 )\"\"\"\\");
        System.out.println("|\"^\"`    |");
        System.out.println("||_/=\\\\__|");
        
        double f1 = 0.1d;
        float f2 = 0.1f;
        if (f1 == f2) {
        	System.out.println("true");
        }else {
        	System.out.println("false");
        }
        System.out.printf("%.55f%n", f1);
        System.out.printf("%.55f", f2);
	}

}
