/* 마이너스 카드 클래스
 * - 은행계좌, 예금주명, 잔액, 마이너스 한도
 * - 예금한다, 인추랗ㄴ다
 */

package ch6;

public class MonusAccount extends Account {
	int minus;
	
	public MonusAccount() {
	}

	public MonusAccount(String accNo, String onName, int balance, String etc) {
		super(accNo, onName, balance);
		this.minus = minus;
	}

//	인출한다의 기능을 수정한다 -> 메소드 오버라이딩
	@Override
	int withdraw(int amount) throws Exception {
		if (this.balance + this.minus < amount) {
			throw new Exception("잔액이 부족합니다");
		}
		this.balance -= amount;
		return balance;
	}

}
