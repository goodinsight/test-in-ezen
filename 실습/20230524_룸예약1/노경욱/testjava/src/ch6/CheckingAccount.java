/* ����ī�� Ŭ����
 * ���� ����, �����ָ�, �ܾ� ,����ī���ȣ
 * �����Ѵ�, �����Ѵ�, �����Ѵ�
 */

package ch6;

public class CheckingAccount extends Account {
	String cardNo;

//	������ : ����Ʈ ������ �������� �ۼ����ֱ�
	public CheckingAccount() {
	}

	public CheckingAccount(String accountNo, String owerName, String etc, int balance) {
		super();
		this.cardNo = cardNo;
	}

	int pay(String cardNo, int amount) throws Exception {
		if (!cardNo.equals(this.cardNo) || balance < amount) {
			throw new Exception("������ �Ұ����մϴ�");
		}
		return withdraw(amount);
//		this.balance -= amount;
//		return amount;
	}
}
