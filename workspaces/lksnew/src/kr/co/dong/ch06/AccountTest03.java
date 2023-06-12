package kr.co.dong.ch06;

public class AccountTest03 {
	public static void main(String[] args) {
		Account ac1 = new Account("010-1319-6418", "조성민1", 10000);
		Account ac2 = new Account("010-2319-6418", "조성민2", 20000);
		Account ac3 = new Account("010-3319-6418", "조성민3", 30000);
		Account ac4 = new Account("010-4319-6418", "조성민4", 40000);
		
		System.out.println("클래스 변수 cnt : " + ac1.cnt + ", 계좌순번 : "+ac1.productNumber);
		System.out.println("클래스 변수 cnt : " + ac2.cnt + ", 계좌순번 : "+ac2.productNumber);
		System.out.println("클래스 변수 cnt : " + ac3.cnt + ", 계좌순번 : "+ac3.productNumber);
		System.out.println("클래스 변수 cnt : " + ac4.cnt + ", 계좌순번 : "+ac4.productNumber);
		System.out.println(Account.cnt);
		
	}
}
