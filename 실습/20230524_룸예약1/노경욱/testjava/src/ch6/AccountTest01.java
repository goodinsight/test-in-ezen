package ch6;

public class AccountTest01 {
	public static void main(String[] args) {
//		�Ѹ��� ���¹߱�_����
		Account ac1 = new Account();
//		�� �ο�
		ac1.acoountNo = "123-4567-0000";
		ac1.ownerName = "ȫ�浿";
		ac1.balance = 1000;

//		5���� ����Ѵ�
		int tmp = 0;
		try {
			tmp = ac1.withdraw(50000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (tmp < 0) {
			System.out.println("�ܾ��� �����մϴ�. �����ܾ�: " + ac1.balance);
		} else {
			System.out.println(tmp + "���� ��� �Ǿ����ϴ�");
		}

//		ac2 �ν��Ͻ����� �Ӽ��� ���� �ο��ؼ� �����ϰ�ʹ�
		Account ac2 = new Account("010-1234-1234", "ȫ����", 10);

//		ac1�� �ν��Ͻ����� ����ϱ�
		System.out.println(ac1.ownerName);
		System.out.println(ac1.acoountNo);
		System.out.println(ac1.balance);

		printAccount(ac1);
//		ac2�� �ν��Ͻ����� ����ϱ�
		System.out.println(ac2.ownerName);
		System.out.println(ac2.acoountNo);
		System.out.println(ac2.balance);
		printAccount(ac2);

		System.out.println("End!!");
	}

	private static void printAccount(Account obj) {
		System.out.println("�����ڸ�: " + obj.ownerName);
		System.out.println("���¹�ȣ: " + obj.acoountNo);
		System.out.println("�ܾ�: " + obj.balance);
	}
}
