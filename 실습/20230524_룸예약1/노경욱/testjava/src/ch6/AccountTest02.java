package ch6;

public class AccountTest02 {
	public static void main(String[] args) {
		Account ac1 = new Account("010-1234-1234","ȫ����1",10000);
		Account ac2 = new Account("010-1234-1234","ȫ����2",20000);
		Account ac3 = new Account("010-1234-1234","ȫ����3",30000);
		Account ac4 = new Account("010-1234-1234","ȫ����4",40000);
		
		System.out.println("Ŭ���� ���� cnt: " + ac1.cnt + ", ���¼���: " + ac1.pNo);
		System.out.println("Ŭ���� ���� cnt: " + ac2.cnt + ", ���¼���: " + ac2.pNo);
		System.out.println("Ŭ���� ���� cnt: " + ac3.cnt + ", ���¼���: " + ac3.pNo);
		System.out.println("Ŭ���� ���� cnt: " + ac4.cnt + ", ���¼���: " + ac4.pNo);
	}
}
