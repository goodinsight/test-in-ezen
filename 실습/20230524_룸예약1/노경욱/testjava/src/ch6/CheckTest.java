package ch6;

public class CheckTest {
	public static void main(String[] args) {
		CheckingAccount c1 = new CheckingAccount();
		c1.acoountNo = "123-4213=1321";
		c1.balance = 2000;
		c1.cardNo = "777-77";

//		����ī��� 3������ �����غ���
		int tmp = 0;
		try {
			tmp = c1.pay("777-77", 30000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("End!!");
		System.out.println(tmp);
	}
}
