/* ���̳ʽ� ī�� Ŭ����
 * - �������, �����ָ�, �ܾ�, ���̳ʽ� �ѵ�
 * - �����Ѵ�, ���߶�����
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

//	�����Ѵ��� ����� �����Ѵ� -> �޼ҵ� �������̵�
	@Override
	int withdraw(int amount) throws Exception {
		if (this.balance + this.minus < amount) {
			throw new Exception("�ܾ��� �����մϴ�");
		}
		this.balance -= amount;
		return balance;
	}

}
