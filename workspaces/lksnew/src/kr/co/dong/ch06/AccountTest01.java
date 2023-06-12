package kr.co.dong.ch06;

public class AccountTest01 {
	public static void main(String[] args) {
//		�� ���� ���¹߱� : ����
		Account ac1 = new Account();
//		�� �ο�
		ac1.accountNo = "123-4567-0000";
		ac1.ownerName = "ȫ�浿";
		ac1.balance = 1000;

//		5���� ����Ѵ�
		int tmp = 0;
		try {
			tmp = ac1.withdraw(50000);
			System.out.println(tmp + "���� ��� �Ǿ����ϴ�.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�ܾ��� �����մϴ�. ���� �ܾ� : " + ac1.balance);
		}
		if (tmp <= 0) {
			System.out.println("�ܾ��� �����մϴ�. ���� �ܾ� : " + ac1.balance);
		} else {
			System.out.println(tmp + "���� ��� �Ǿ����ϴ�.");
		}

//		ac2 �ν��Ͻ����� �Ӽ��� ���� �ο��ؼ� �����ϰ� �ʹ�?
		Account ac2 = new Account();
		
		System.out.println(ac1.productNumber);
		System.out.println(ac2.productNumber);
		System.out.println(ac1.cnt);
		System.out.println(ac2.cnt);
		System.out.println(Account.cnt);
		
		
		
//		ac1�� �ν��Ͻ������� ����غ���
//		ac1.printAccount();
		printAccount(ac1);
//		ac2�� �ν��Ͻ������� ����غ���
//		System.out.println(ac2.printAccount());

		
		System.out.println("End!!!");

	}

	private static void printAccount(Object obj) {
		// Ÿ���� �ָ��Ҷ��� �ν��Ͻ����� Ȯ���ϰ� �޼ҵ带 ����� �� ����
		if(obj instanceof Account) {
			Account ac = (Account) obj;
			System.out.println("�����ڸ� :" + ac.ownerName);
			System.out.println("���¹�ȣ :" + ac.accountNo);
			System.out.println("�����ܾ� :" + ac.balance);
			
			System.out.println(obj.getClass());
			System.out.println(obj.toString());
		} else {
			System.out.println("Ÿ���� ���� �ʽ��ϴ�.");
		}
	}
	
}
