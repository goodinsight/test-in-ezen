package ch6;

public class AccountTest01 {
	public static void main(String[] args) {
//		한명의 계좌발급_생성
		Account ac1 = new Account();
//		값 부여
		ac1.acoountNo = "123-4567-0000";
		ac1.ownerName = "홍길동";
		ac1.balance = 1000;

//		5만원 출금한다
		int tmp = 0;
		try {
			tmp = ac1.withdraw(50000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (tmp < 0) {
			System.out.println("잔액이 부족합니다. 현재잔액: " + ac1.balance);
		} else {
			System.out.println(tmp + "원리 출금 되었습니다");
		}

//		ac2 인스턴스에는 속성의 값을 부여해서 생성하고싶다
		Account ac2 = new Account("010-1234-1234", "홍순이", 10);

//		ac1의 인스턴스변수 출력하기
		System.out.println(ac1.ownerName);
		System.out.println(ac1.acoountNo);
		System.out.println(ac1.balance);

		printAccount(ac1);
//		ac2의 인스턴스변수 출력하기
		System.out.println(ac2.ownerName);
		System.out.println(ac2.acoountNo);
		System.out.println(ac2.balance);
		printAccount(ac2);

		System.out.println("End!!");
	}

	private static void printAccount(Account obj) {
		System.out.println("예금자명: " + obj.ownerName);
		System.out.println("계좌번호: " + obj.acoountNo);
		System.out.println("잔액: " + obj.balance);
	}
}
