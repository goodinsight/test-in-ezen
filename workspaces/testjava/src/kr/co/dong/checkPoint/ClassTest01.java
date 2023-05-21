package kr.co.dong.checkPoint;

public class ClassTest01 {
	public static void main(String[] args) {
		Beverage b1 = new Beverage(3);
		Beverage b2 = new Beverage(4);
		
		System.out.println(b1.dAmount.length);
		System.out.println(b1.dName.length);
		System.out.println(b1.dPrice.length);
		System.out.println(b2.dAmount.length);
		System.out.println(b2.dName.length);
		System.out.println(b2.dPrice.length);
		
		for (int i = 0; i < b1.dName.length; i++)
			System.out.println(b1.dName[i]);
		
		b2.dName[0] = "콜라";
		b2.dName[1] = "사이다";
		b2.dName[2] = "커피";
		
		for (int i = 0; i < b2.dName.length; i++)
			System.out.println(b2.dName[i]);
		
		
		
	}
}
