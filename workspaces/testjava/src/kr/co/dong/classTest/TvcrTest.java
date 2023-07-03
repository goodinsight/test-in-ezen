package kr.co.dong.classTest;

public class TvcrTest {
	public static void main(String[] args) {
		Buyer user1 = new Buyer();
		Tv t = new Tv();
		Computer c = new Computer();
		System.out.println(t.point);
		user1.buy(t);
		user1.buy(c);
		System.out.println(user1.item);
		
		System.out.println(user1.money);
		System.out.println(user1.bonusPoint);
		user1.refund(c);
		
		System.out.println(user1.item);
		
		System.out.println(user1.money);
		System.out.println(user1.bonusPoint);
		user1.summary();
	}
}
