/* 직불카드 클래스
 * 은행 계좌, 예금주명, 잔액 ,직불카드번호
 * 예금한다, 인출한다, 지불한다
 */

package ch6;

public class CheckingAccount extends Account {
	String cardNo;

//	생성자 : 디폴트 생성자 수동으로 작성해주기
	public CheckingAccount() {
	}

	public CheckingAccount(String accountNo, String owerName, String etc, int balance) {
		super();
		this.cardNo = cardNo;
	}

	int pay(String cardNo, int amount) throws Exception {
		if (!cardNo.equals(this.cardNo) || balance < amount) {
			throw new Exception("지불이 불가능합니다");
		}
		return withdraw(amount);
//		this.balance -= amount;
//		return amount;
	}
}
