package kr.co.dong.ch06;

public class AccountTest03 {
	public static void main(String[] args) {
		Account ac1 = new Account("010-1319-6418", "������1", 10000);
		Account ac2 = new Account("010-2319-6418", "������2", 20000);
		Account ac3 = new Account("010-3319-6418", "������3", 30000);
		Account ac4 = new Account("010-4319-6418", "������4", 40000);
		
		System.out.println("Ŭ���� ���� cnt : " + ac1.cnt + ", ���¼��� : "+ac1.productNumber);
		System.out.println("Ŭ���� ���� cnt : " + ac2.cnt + ", ���¼��� : "+ac2.productNumber);
		System.out.println("Ŭ���� ���� cnt : " + ac3.cnt + ", ���¼��� : "+ac3.productNumber);
		System.out.println("Ŭ���� ���� cnt : " + ac4.cnt + ", ���¼��� : "+ac4.productNumber);
		System.out.println(Account.cnt);
		
	}
}
