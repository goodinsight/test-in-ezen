/*
 * ����ī�� Ŭ����
 * -�������, �����ָ�, �ܾ�, ����ī���ȣ
 * -�����Ѵ�, �����Ѵ�, �����Ѵ�.
 */

package kr.co.dong.ch06;

public class CheckingAccount extends Account{
	String cardName;
	
//	����Ʈ ������ �ۼ����ֱ�
	public CheckingAccount() {
	}

	public CheckingAccount(String accountNo, String ownerName, int balance, int[] a, String cardName) {
		super(accountNo, ownerName, balance, a);
		this.cardName = cardName;
	}

	int pay(String cardName, int amount) throws Exception{
		if(!cardName.equals(this.cardName) || balance < amount) {
//			return 500;
			throw new Exception("������ �Ұ��� �մϴ�.");
		}
//		this.balance -= amount;
//		return amount;
		return withdraw(amount);
	}
}
