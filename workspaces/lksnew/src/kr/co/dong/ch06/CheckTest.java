package kr.co.dong.ch06;

public class CheckTest {
	public static void main(String[] args) {
		CheckingAccount c1 = new CheckingAccount();
		c1.accountNo = "123-124-125125";
		c1.balance = 2000;
		c1.cardName = "5235-2352-3523-3525";
		
		int tmp;
		
		try {
			tmp = c1.pay("5235-2352-3523-3525", 30000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("End!!!");
	}
}
