/* 은행계좌 클래스
 * - 계좌번호 / 예금주이름 / 잔액
 * - 예금한다 / 출금한다
 * 
 */
package kr.co.dong.ch06;

public class Account {
	
	public static int cnt;	// 클래스 변수라고 함
	public int productNumber;	// 은행계좌 고유번호(순번)
	public String accountNo;
	public String ownerName;
	public String etc;
	public int balance;
	

	public int[] a = new int[0];
	
	//	default 생성자 -> 자동발생 but 다른생성자가 있는경우 발생되지않음
	public Account() {
		System.out.println("은행계좌발급!!!!!");
		cnt++;
		this.productNumber = cnt;
	}
	
	
	public Account(String accountNo, String ownerName, int balance, int[] a) {
		this(accountNo, ownerName, balance);
		this.a = a;
		cnt++;
		this.productNumber = cnt;
	}


	public Account(String accountNo, String ownerName, int balance) {
		super();
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
		cnt++;
		this.productNumber = cnt;
	}

	void deposit(int amount) {
		this.balance += amount;
	}

	public int withdraw(int amount) throws Exception{
		if (this.balance < amount) {
//			return 0; // 처리안됨
			throw new Exception("잔액이 부족합니다.");
		}
		this.balance -= amount;
		return amount;// return this.balance;
	}

	public int printAccount(int b) {
		// TODO Auto-generated method stub
//		System.out.println("계좌주인의 이름은 " + this.ownerName + "이고,");
//		System.out.println("계좌번호는 " + this.accountNo + "이고,");
//		System.out.println("계좌 잔액은 " + this.balance + "입니다.");
		b = b + 1;
		
		return b;
	}
	
	@Override
	public String toString() {
		return "은행계좌클래스 [accountNo=" + accountNo + ", ownerName=" + ownerName + ", balance=" + balance + "]";
	}
}
