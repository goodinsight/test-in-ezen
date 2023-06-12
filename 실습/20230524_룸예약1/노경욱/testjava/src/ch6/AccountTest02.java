package ch6;

public class AccountTest02 {
	public static void main(String[] args) {
		Account ac1 = new Account("010-1234-1234","홍순이1",10000);
		Account ac2 = new Account("010-1234-1234","홍순이2",20000);
		Account ac3 = new Account("010-1234-1234","홍순이3",30000);
		Account ac4 = new Account("010-1234-1234","홍순이4",40000);
		
		System.out.println("클래스 변수 cnt: " + ac1.cnt + ", 계좌순번: " + ac1.pNo);
		System.out.println("클래스 변수 cnt: " + ac2.cnt + ", 계좌순번: " + ac2.pNo);
		System.out.println("클래스 변수 cnt: " + ac3.cnt + ", 계좌순번: " + ac3.pNo);
		System.out.println("클래스 변수 cnt: " + ac4.cnt + ", 계좌순번: " + ac4.pNo);
	}
}
