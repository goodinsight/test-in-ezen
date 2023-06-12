/* 은행계좌클래스
 * - 계좌번호/ 예금주 이름 / 잔액
 * - 예금한다/출금한다
 */

package ch6;

public class Account {
	static int cnt;
	public String acoountNo;
	public String ownerName;
	public String etc;
	public int balance;
	public int pNo; //은행계좌 순번

//	default 생성자 -> 자동발생 but 다른생성자가 있는 경우 발생되지 않음
	public Account() {
		cnt++;
		pNo = cnt;
		System.out.println("은행계좌발급");
	}
	
	

	public Account(String accNo, String onName, int balance) { //String etc) {
		super();
		this.acoountNo = accNo;
		this.ownerName = onName;
		this.balance = balance;
		this.etc = etc;
		cnt++;
		pNo = cnt;
	}

	void deposit(int amount) {
		this.balance += amount;
	}

	int withdraw(int amount) throws Exception{
		if (this.balance < amount) {
//			return 0; // 처리안됨
			throw new Exception("잔액이 부족합니다");
		}
		this.balance -= amount;
		return balance;
		
	}
}
