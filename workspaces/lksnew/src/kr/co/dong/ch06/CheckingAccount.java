/*
 * 직불카드 클래스
 * -은행계좌, 예금주명, 잔액, 직불카드번호
 * -예금한다, 인출한다, 지불한다.
 */

package kr.co.dong.ch06;

public class CheckingAccount extends Account{
	String cardName;
	
//	디폴트 생성자 작성해주기
	public CheckingAccount() {
	}

	public CheckingAccount(String accountNo, String ownerName, int balance, int[] a, String cardName) {
		super(accountNo, ownerName, balance, a);
		this.cardName = cardName;
	}

	int pay(String cardName, int amount) throws Exception{
		if(!cardName.equals(this.cardName) || balance < amount) {
//			return 500;
			throw new Exception("지불이 불가능 합니다.");
		}
//		this.balance -= amount;
//		return amount;
		return withdraw(amount);
	}
}
