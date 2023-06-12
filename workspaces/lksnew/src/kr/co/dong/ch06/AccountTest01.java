package kr.co.dong.ch06;

public class AccountTest01 {
	public static void main(String[] args) {
//		한 명의 계좌발급 : 생성
		Account ac1 = new Account();
//		값 부여
		ac1.accountNo = "123-4567-0000";
		ac1.ownerName = "홍길동";
		ac1.balance = 1000;

//		5만원 출금한다
		int tmp = 0;
		try {
			tmp = ac1.withdraw(50000);
			System.out.println(tmp + "원이 출금 되었습니다.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("잔액이 부족합니다. 현재 잔액 : " + ac1.balance);
		}
		if (tmp <= 0) {
			System.out.println("잔액이 부족합니다. 현재 잔액 : " + ac1.balance);
		} else {
			System.out.println(tmp + "원이 출금 되었습니다.");
		}

//		ac2 인스턴스에는 속성의 값을 부여해서 생성하고 싶다?
		Account ac2 = new Account();
		
		System.out.println(ac1.productNumber);
		System.out.println(ac2.productNumber);
		System.out.println(ac1.cnt);
		System.out.println(ac2.cnt);
		System.out.println(Account.cnt);
		
		
		
//		ac1의 인스턴스변수를 출력해보자
//		ac1.printAccount();
		printAccount(ac1);
//		ac2의 인스턴스변수를 출력해보자
//		System.out.println(ac2.printAccount());

		
		System.out.println("End!!!");

	}

	private static void printAccount(Object obj) {
		// 타입이 애매할때는 인스턴스인지 확인하고 메소드를 사용할 수 있음
		if(obj instanceof Account) {
			Account ac = (Account) obj;
			System.out.println("예금자명 :" + ac.ownerName);
			System.out.println("계좌번호 :" + ac.accountNo);
			System.out.println("계좌잔액 :" + ac.balance);
			
			System.out.println(obj.getClass());
			System.out.println(obj.toString());
		} else {
			System.out.println("타입이 맞지 않습니다.");
		}
	}
	
}
