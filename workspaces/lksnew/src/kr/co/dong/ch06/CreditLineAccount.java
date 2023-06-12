/*
 *마이너스 카드 클래스 
 * -은행계좌, 예금주명, 잔액, 마이너스한도
 * -예금한다, 인출한다(????) 
 * 
 */
package kr.co.dong.ch06;

public class CreditLineAccount extends Account{
	int creditLine;
	
	
	
	public CreditLineAccount() {
		super();
	}
	
	public CreditLineAccount(String accountNo, String ownerName, int balance, int[] a, int creditLine) {
		super(accountNo, ownerName, balance, a);
		this.creditLine = creditLine;
	}

	@Override
	public int withdraw(int amount) throws Exception{
		if (this.balance + this.creditLine < amount) {
//			return 0; // 처리안됨
			throw new Exception("잔액이 부족합니다.");
		}
		this.balance -= amount;
		return amount;// return this.balance;
	}
	
}
